public class OpDrop implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack) {
        stack.drop();
    }

    @Override
    public String toString() {
        return "OP_DROP";
    }
    
}
