package SVM;

public enum OpCode {
    // 1 Instruction
    ICONST, DCONST, SCONST,
    // Integer
    IPRINT, IUMINUS, IADD, ISUB, IMULT, IDIV, IMOD, IEQ, INEQ, ILT, ILEQ, ITOD, ITOS,
    // Double
    DPRINT, DUMINUS, DADD, DSUB, DMULT, DDIV, DEQ, DNEQ, DLT, DLEQ, DTOS,
    // String
    SPRINT, SCONCAT, SEQ, SNEQ,
    // Boolean
    TCONST, FCONST, BPRINT, BEQ, BNEQ, AND, OR, NOT, BTOS,
    HALT,
    JUMP, JUMPF, GALLOC, GLOAD, GSTORE, LALLOC, LLOAD, LSTORE, POP, CALL, RETVAL, RET;

    public boolean hasArg() {
        return switch (this) {
            case ICONST, DCONST, SCONST,
                 JUMP, JUMPF, GALLOC, GLOAD, GSTORE,
                 LALLOC, LLOAD, LSTORE, POP, CALL, RETVAL, RET-> true;
            default -> false;
        };
    }
}
