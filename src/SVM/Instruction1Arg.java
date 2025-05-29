package SVM;

import java.io.DataOutputStream;
import java.io.IOException;

public class Instruction1Arg  extends Instruction {
    private int arg;

    public Instruction1Arg(OpCode opcode, int arg) {
        super(opcode);
        this.arg = arg;
    }

    public void setArg(int arg) {
        this.arg = arg;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {
        out.writeByte(opcode.ordinal());
        out.writeInt(arg);
    }

    public int getArg() {
        return arg;
    }

    @Override
    public String toString() {
        return opcode.name().toLowerCase() + " " + arg;
    }
}
