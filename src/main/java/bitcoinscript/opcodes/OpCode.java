package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

public interface OpCode {

    public void execute(BitcoinStack stack, ScriptEngine engine);
    public String getName();
} 
