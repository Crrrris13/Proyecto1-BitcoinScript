public class OpEqualVerify implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack) {
        String value1 = stack.pop();
        String value2 = stack.pop();
        
        if (!value1.equals(value2)) {
            throw new RuntimeException("Los valores no son iguales. Script fallido.");
        }
    }

    @Override
    public String getName() {
        return "OP_EQUALVERIFY";
    }

    @Override
    public String toString() {
        return getName();
    }

}
