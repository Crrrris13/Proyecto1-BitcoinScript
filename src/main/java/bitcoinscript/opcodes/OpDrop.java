public class OpDrop implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack) {
        stack.drop();
    }

    @Override
    public String getName() {
        return "OP_DROP";
    }

    @Override
    public String toString() {
        return getName();
    }
    
}
