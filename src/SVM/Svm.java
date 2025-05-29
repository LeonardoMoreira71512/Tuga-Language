package SVM;
import java.io.*;
import java.util.*;

public class Svm {
    private final boolean trace;
    private Instruction[] code;
    private int IP = 0;
    private int FP = 0;
    private final Stack<Object> stack = new Stack<>();
    private final List<Object> constantPool = new ArrayList<>();
    private Object[] globals;
    private int callCount = 0;

    public Svm(byte[] bytecodes, boolean trace) {
        this.trace = trace;
        decode(bytecodes);
    }

    public record FunctionInfo(int address, int numArgs) {
    }

    public final Map<Integer, FunctionInfo> functionInfos = new HashMap<>();

    public void setFunctionInfos(Map<Integer, FunctionInfo> infos) {
        this.functionInfos.putAll(infos);
    }

    private void decode(byte[] bytecodes) {
        try (DataInputStream in = new DataInputStream(new ByteArrayInputStream(bytecodes))) {
            int poolSize = in.readInt();
            for (int i = 0; i < poolSize; i++) {
                byte type = in.readByte();
                if (type == 1) {
                    constantPool.add(in.readDouble());
                } else if (type == 3) {
                    int len = in.readInt();
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < len; j++) {
                        sb.append(in.readChar());
                    }
                    constantPool.add(sb.toString());
                }
            }

            List<Instruction> insts = new ArrayList<>();
            while (in.available() > 0) {
                int opcode = in.readUnsignedByte();
                OpCode op = OpCode.values()[opcode];
                if (op.hasArg()) {
                    int arg = in.readInt();
                    insts.add(new Instruction1Arg(op, arg));
                } else {
                    insts.add(new InstructionNoArg(op));
                }
            }
            code = insts.toArray(new Instruction[0]);

        } catch (IOException e) {
            System.err.println("Erro ao decodificar bytecodes: " + e.getMessage());
            System.exit(1);
        }
    }

    public void run() {
        System.out.println("*** VM output ***");
        if (trace) {
            printMachineState();
        }
        while (IP < code.length) {
            Instruction inst = code[IP];
            if (trace) {
                System.out.printf("%2d: %-20s\n", IP, inst);
            }

            exec(inst);
            IP++;
            if (trace) {
                printMachineState();
            }
        }
        if (trace) {
            printMachineState();
        }
    }

    private void printMachineState() {
        System.out.print("\t\t\t\t Globals: [");
        if (globals != null) {
            for (int i = 0; i < globals.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(globals[i] == null ? "NULO" : globals[i]);
            }
        }
        System.out.println("]");

        System.out.println("\t\t\t\t Stack:   " + formatStack(stack));
        System.out.printf("\t\t\t\t IP: %d  FP: %d\n\n", IP, FP);
    }

    private String formatStack(Stack<Object> stack) {
        if (stack.isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (Object o : stack) {
            sb.append(o == null ? "NULO" : o).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    private double convertToDouble(Object o) {
        if (o instanceof Integer i) return i.doubleValue();
        if (o instanceof Double d) return d;
        throw new RuntimeException("Tipo invalido para comparacao double: " + o.getClass().getSimpleName());
    }

    private void exec(Instruction inst) {
        OpCode op = inst.getOpcode();
        switch (op) {

            // Global and Local Memory
            case GALLOC -> {
                int n = ((Instruction1Arg) inst).getArg();
                if (globals == null) {
                    globals = new Object[n];
                } else {
                    Object[] newGlobals = new Object[globals.length + n];
                    System.arraycopy(globals, 0, newGlobals, 0, globals.length);
                    globals = newGlobals;
                }
                Arrays.fill(globals, globals.length - n, globals.length, null);
            }
            case LALLOC -> {
                int n = ((Instruction1Arg) inst).getArg();
                for (int i = 0; i < n; i++) stack.push(null);
            }
            case GLOAD -> {
                int addr = ((Instruction1Arg) inst).getArg();
                Object val = globals[addr];
                stack.push(val);
            }
            case LLOAD -> {
                int offset = ((Instruction1Arg) inst).getArg();
                stack.push(stack.get(FP + offset));
            }
            case GSTORE -> {
                int addr = ((Instruction1Arg) inst).getArg();
                globals[addr] = stack.pop();
            }
            case LSTORE -> {
                int offset = ((Instruction1Arg) inst).getArg();
                stack.set(FP + offset, stack.pop());
            }
            case POP -> {
                int n = ((Instruction1Arg) inst).getArg();
                for (int i = 0; i < n; i++) stack.pop();
            }
            case CALL -> {
                int addr = ((Instruction1Arg) inst).getArg();
                stack.push(FP); //Control Link posicao na stack, quando fazemo um novo call
                FP = stack.size() - 1;
                stack.push(IP + 1); //Return Adress
                IP = addr - 1;
                callCount++;
            }
            case RETVAL -> {
                int n = ((Instruction1Arg) inst).getArg();
                Object retVal = stack.pop();
                while (stack.size() > FP + 2) {
                    stack.pop();
                }
                int returnAddr = (int) stack.pop();
                int prevFP = (int) stack.pop();
                for (int i = 0; i < n; i++) {
                    stack.pop();
                }
                FP = prevFP;
                IP = returnAddr - 1;
                stack.push(retVal);
                callCount--;
            }
            case RET -> {
                int n = ((Instruction1Arg) inst).getArg();
                while (stack.size() > FP + 2) {
                    stack.pop();
                }
                int returnAddr = (int) stack.pop();
                int prevFP = (int) stack.pop();

                for (int i = 0; i < n; i++) {
                    stack.pop();
                }
                FP = prevFP;
                IP = returnAddr - 1;
                callCount--;
            }

            // Fluxo de controlo
            case JUMP -> {
                int addr = ((Instruction1Arg) inst).getArg();
                IP = addr - 1;
            }
            case JUMPF -> {
                int addr = ((Instruction1Arg) inst).getArg();
                Object cond = stack.pop();
                if (!(cond instanceof Boolean))
                    throw new RuntimeException("Tipo invalido em JUMPF: esperado booleano, recebeu " + cond.getClass().getSimpleName());
                if (!(Boolean) cond) {
                    IP = addr - 1;
                }
            }

            // Constantes
            case ICONST -> stack.push(((Instruction1Arg) inst).getArg());
            case DCONST -> stack.push((Double) constantPool.get(((Instruction1Arg) inst).getArg()));
            case SCONST -> stack.push((String) constantPool.get(((Instruction1Arg) inst).getArg()));
            case TCONST -> stack.push(true);
            case FCONST -> stack.push(false);

            // Print
            case IPRINT, DPRINT, SPRINT -> System.out.println(stack.pop());
            case BPRINT -> {
                boolean b = (boolean) stack.pop();
                System.out.println(b ? "verdadeiro" : "falso");
            }

            //Operacoes Int
            case IADD -> {
                int b = (int) stack.pop();
                int a = (int) stack.pop();
                stack.push(a + b);
            }
            case ISUB -> {
                int b = (int) stack.pop();
                int a = (int) stack.pop();
                stack.push(a - b);
            }
            case IMULT -> {
                int b = (int) stack.pop();
                int a = (int) stack.pop();
                stack.push(a * b);
            }
            case IDIV -> {
                int b = (int) stack.pop();
                int a = (int) stack.pop();
                if (b == 0) System.out.println("divisao por zero!");
                else stack.push(a / b);
            }
            case IMOD -> {
                int b = (int) stack.pop();
                int a = (int) stack.pop();
                stack.push(a % b);
            }
            case IUMINUS -> stack.push(-(int) stack.pop());


            // Operacoes Double
            case DADD -> {
                double b = (double) stack.pop();
                double a = (double) stack.pop();
                stack.push(a + b);
            }
            case DSUB -> {
                double b = (double) stack.pop();
                double a = (double) stack.pop();
                stack.push(a - b);
            }
            case DMULT -> {
                double b = (double) stack.pop();
                double a = (double) stack.pop();
                stack.push(a * b);
            }
            case DDIV -> {
                double b = (double) stack.pop();
                double a = (double) stack.pop();
                stack.push(a / b);
            }
            case DUMINUS -> stack.push(-(double) stack.pop());

            // Comparacoes
            case IEQ -> {
                int b = (int) stack.pop();
                int a = (int) stack.pop();
                stack.push(a == b);
            }
            case INEQ -> {
                int b = (int) stack.pop();
                int a = (int) stack.pop();
                stack.push(a != b);
            }
            case ILT -> {
                int b = (int) stack.pop();
                int a = (int) stack.pop();
                stack.push(a < b);
            }
            case ILEQ -> {
                int b = (int) stack.pop();
                int a = (int) stack.pop();
                stack.push(a <= b);
            }


            case DEQ -> {
                Object b = stack.pop();
                Object a = stack.pop();
                stack.push(convertToDouble(a) == convertToDouble(b));
            }
            case DNEQ -> {
                Object b = stack.pop();
                Object a = stack.pop();
                stack.push(convertToDouble(a) != convertToDouble(b));
            }
            case DLT -> {
                double b = (double) stack.pop();
                double a = (double) stack.pop();
                stack.push(a < b);
            }
            case DLEQ -> {
                double b = (double) stack.pop();
                double a = (double) stack.pop();
                stack.push(a <= b);
            }

            case SEQ -> {
                Object b = stack.pop();
                Object a = stack.pop();
                stack.push(a.equals(b));
            }
            case SNEQ -> {
                Object b = stack.pop();
                Object a = stack.pop();
                stack.push(!a.equals(b));
            }

            case BEQ -> {
                boolean b = (boolean) stack.pop();
                boolean a = (boolean) stack.pop();
                stack.push(a == b);
            }
            case BNEQ -> {
                boolean b = (boolean) stack.pop();
                boolean a = (boolean) stack.pop();
                stack.push(a != b);
            }

            // Conversoes
            case ITOD -> stack.push(((int) stack.pop()) * 1.0);
            case ITOS -> stack.push(Integer.toString((int) stack.pop()));
            case DTOS -> stack.push(Double.toString((double) stack.pop()));
            case BTOS -> {
                boolean b = (boolean) stack.pop();
                stack.push(b ? "verdadeiro" : "falso");
            }

            // Operacoes string e booleanas
            case SCONCAT -> {
                String b = (String) stack.pop();
                String a = (String) stack.pop();
                stack.push(a + b);
            }

            case AND -> {
                boolean b = (boolean) stack.pop();
                boolean a = (boolean) stack.pop();
                stack.push(a && b);
            }
            case OR -> {
                boolean b = (boolean) stack.pop();
                boolean a = (boolean) stack.pop();
                stack.push(a || b);
            }
            case NOT -> stack.push(!(boolean) stack.pop());

            case HALT -> System.exit(0);

            default -> throw new RuntimeException("Instrucao nao implementada: " + op);
        }
    }
}
