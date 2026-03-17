package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * La operacion OP_DROP.
 * Elimina el elemento superior de la pila.
 * Ejemplo:
 * [A, B] -> OP_DROP -> [B]
 */
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
