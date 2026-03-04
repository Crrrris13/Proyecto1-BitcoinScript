package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

public class OpDrop implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        stack.drop();
    }

    @Override
    public String getName() {
        return "OP_DROP";
    }

    @Override
    public String toString() {
        return getName();
    }
    
}
