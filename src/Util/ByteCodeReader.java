package Util;
import SVM.OpCode;

import java.io.*;
public class ByteCodeReader {
    public static void readBytecodeFile(String filename) throws IOException {
        try (DataInputStream in = new DataInputStream(new FileInputStream(filename))) {
            System.out.println("\n======== Bytecode File Content ========\n");

            // Ler tamanho da constant pool
            int poolSize = in.readInt();
            System.out.println("Constant Pool Size: " + poolSize);

            for (int i = 0; i < poolSize; i++) {
                byte type = in.readByte();
                System.out.print(i + ": ");
                if (type == 1) {
                    double val = in.readDouble();
                    System.out.println("Double -> " + val);
                } else if (type == 3) {
                    int length = in.readInt();
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < length; j++) {
                        sb.append(in.readChar());
                    }
                    System.out.println("String -> \"" + sb + "\"");
                } else {
                    System.out.println("Unknown constant type: " + type);
                }
            }

            System.out.println("\n --- Instructions (raw bytes) --- hex format, to see opcode, convert to decimal");
            int idx = 0;
            while (in.available() > 0) {
                int opcode = in.readUnsignedByte();
                OpCode[] opcodes = OpCode.values();
                String name = opcode < opcodes.length ? opcodes[opcode].name().toLowerCase() : "???";
                System.out.print(idx + ": ");
                System.out.printf("%02X (%s) ", opcode, name);

                if (opcode == 0 || opcode == 1 || opcode == 2) { // ICONST, DCONST, SCONST
                    int arg = in.readInt();
                    System.out.printf("%08X", arg);
                    System.out.println();
                    idx += 5;
                } else {
                    System.out.println();
                    idx += 1;
                }
            }
            System.out.println("\n======== Fim ========");
        }
    }
}
