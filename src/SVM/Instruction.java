package SVM;
import java.io.*;

public abstract class Instruction {
    protected OpCode opcode;

    public Instruction(OpCode opcode) {
        this.opcode = opcode;
    }

    public abstract void writeTo(DataOutputStream out) throws IOException;

    public OpCode getOpcode() {
        return opcode;
    }
}
