package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

public class OpNotIf implements OpCode {

    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String value = stack.pop();
        boolean condicion = value.equals("0");
        engine.enterIf(condicion);
    }

    @Override
    public String getName() {
        return "OP_NOTIF";
    }

    @Override
    public String toString() {
        return getName();
    }
}