package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

public class OpVerify implements OpCode {
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String value = stack.pop();
        
        if (value.equals("0")) {
            throw new RuntimeException("El valor en la cima es falso.");
        }
    }

    @Override
    public String getName() {
        return "OP_VERIFY";
    }

    @Override
    public String toString() {
        return getName();
    }
}
