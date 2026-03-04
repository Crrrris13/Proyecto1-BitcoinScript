package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

public class OpDup implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        stack.dup();
    }

    @Override
    public String getName() {
        return "OP_DUP";
    }

    @Override
    public String toString() {
        return getName();
    }
}
