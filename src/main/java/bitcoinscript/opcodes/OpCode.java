package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;

public interface OpCode {

    public void execute(BitcoinStack stack);
    public String getName();
} 
