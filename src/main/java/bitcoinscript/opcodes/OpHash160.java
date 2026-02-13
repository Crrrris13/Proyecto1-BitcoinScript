public class OpHash160 implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack) {
        String value = stack.pop();
        String hash160 = CryptoMock.hash160(value);
        stack.push(hash160);
    }

    @Override
    public String getName() {
        return "OP_HASH160";
    }

    @Override
    public String toString() {
        return getName();
    }
}