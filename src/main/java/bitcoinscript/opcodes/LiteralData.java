public class LiteralData implements OpCode {
    private String value;

    public LiteralData(String value) {
        this.value = value;
    }

    @Override
    public void execute(BitcoinStack stack) {
        stack.push(value);
    }

    @Override
    public String toString() {
        return value;
    }
}