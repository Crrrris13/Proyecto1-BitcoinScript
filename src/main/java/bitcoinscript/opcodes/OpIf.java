package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

public class OpIf implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        boolean condition = engine.shouldExecute();

        if (condition) {
            String value = stack.pop();

            boolean conditionValue = ScriptEngine.isTrue(value);
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
