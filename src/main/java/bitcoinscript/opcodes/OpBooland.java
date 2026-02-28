package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;

public class OpBooland implements OpCode {

    public void execute(BitcoinStack stack) {
        String b = stack.pop();
        String a = stack.pop();
        if (isTrue(a) && isTrue(b)) {
            stack.push("1");
        } else {
            stack.push("0");    
        }
    }
    
    public String getName() {
        return "OP_BOOLAND";
    }

    public String toString() {
        return getName();
    }

    private boolean isTrue(String value) {
        return !value.equals("0") && !value.equals("");
    }
}