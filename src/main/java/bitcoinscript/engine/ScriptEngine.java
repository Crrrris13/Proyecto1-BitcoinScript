import java.util.List;

public class ScriptEngine {

    private BitcoinStack mainStack;
    private List<OpCode> instructions;
    
    public boolean executeScript(String scriptSig, String scriptPubKey) {
        return false;
    }

    private void parseScript(String script) {
    }

    public List<String> getStackState() {
        return null;
    }
}
