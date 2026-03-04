package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

public class OpElse implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        engine.enterElse();
    }

    @Override
    public String getName() {
        return "OP_ELSE";
    }
    
}
