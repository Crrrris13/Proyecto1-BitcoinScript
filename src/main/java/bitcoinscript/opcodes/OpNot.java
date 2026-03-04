package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

public class OpNot implements OpCode {
    
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String value = stack.pop();
        if (isTrue(value)) {
            stack.push("0");
        } else {
            stack.push("1");
        }
    }

    public String getName() {
        return "OP_NOT";
    }

    public String toString() {
        return getName();
    }
    
}
