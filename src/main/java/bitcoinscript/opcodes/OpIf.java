package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

public class OpIf implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        boolean condition = engine.shouldExecute();

        if (condition) {
            String value = stack.pop();

            boolean conditionValue = !value.equals("0") && !value.isEmpty();
            engine.enterIf(conditionValue);
        } else {
            engine.enterIf(false);
        }
    }

    @Override
    public String getName() {
        return "OP_IF";
    }

    @Override
    public String toString() {
        return getName();
    }
    
}
