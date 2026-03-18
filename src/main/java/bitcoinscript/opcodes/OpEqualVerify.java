package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * La operacion OP_EQUALVERIFY.
 * Compara dos valores y falla si no son iguales. A diferencia de OP_EQUAL, no deja resultado en la pila
 * y lanza una excepcion si los valores son distintos
 */
public class OpEqualVerify implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String value1 = stack.pop();
        String value2 = stack.pop();
        
        if (!value1.equals(value2)) {
            throw new RuntimeException("Los valores no son iguales. Script fallido");
        }
    }

    @Override
    public String getName() {
        return "OP_EQUALVERIFY";
    }

    @Override
    public String toString() {
        return getName();
    }

}
