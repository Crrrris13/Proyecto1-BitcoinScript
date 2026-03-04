package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

public class OpEndIf implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        engine.exitIf();
    }

    @Override
    public String getName() {
        return "OP_ENDIF";
    }
    
}
