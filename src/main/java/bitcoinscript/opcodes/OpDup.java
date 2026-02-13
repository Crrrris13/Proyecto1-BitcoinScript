public class OpDup implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack) {
        stack.dup();
    }

    @Override
    public String getName() {
        return "OP_DUP";
    }

    @Override
    public String toString() {
        return getName();
    }
}
