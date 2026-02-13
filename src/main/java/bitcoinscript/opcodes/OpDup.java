public class OpDup implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack) {
        stack.dup();
    }

    @Override
    public String toString() {
        return "OP_DUP";
    }
}
