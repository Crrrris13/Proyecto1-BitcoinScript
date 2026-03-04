package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

public class OpBoolOr implements OpCode {

    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String b = stack.pop();
        String a = stack.pop();
        if (isTrue(a) || isTrue(b)) {
            stack.push("1");
        } else {
            stack.push("0");    
        }
    }

    public String getName() {
        return "OP_BOOLOR";
    }

    public String toString() {
        return getName();
    }

    private boolean isTrue(String value) {
        return !value.equals("0") && !value.equals("");
    }
    
}
