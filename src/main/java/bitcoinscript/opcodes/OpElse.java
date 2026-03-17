package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * Implementa la operacion OP_ELSE.
 * Cambia la rama de ejecucion dentro de una condicional.
 */
public class OpElse implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        engine.enterElse();
    }

    @Override
    public String getName() {
        return "OP_ELSE";
    }

    @Override
    public String toString() {
        return getName();
    }
    
}
