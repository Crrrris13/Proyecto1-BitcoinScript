package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * Implementa la operacion OP_RETURN.
 * Termina inmediatamente la ejecucion, marcandolo como invalido. Siempre provoca un fallo al lanzar una excepcion.
 */
public class OpReturn implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        throw new RuntimeException("El script ha fallado");
    }

    @Override
    public String getName() {
        return "OP_RETURN";
    }

    @Override
    public String toString() {
        return getName();
    }
    
}