package SVM;

import java.io.DataOutputStream;
import java.io.IOException;

public class InstructionNoArg extends Instruction {
    public InstructionNoArg(OpCode opcode) {
        super(opcode);
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {
        out.writeByte(opcode.ordinal());
    }

    @Override
    public String toString() {
        return opcode.name().toLowerCase();
    }
}
