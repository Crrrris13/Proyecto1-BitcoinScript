package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * la operacion OP_VERIFY.
 * Verifica el valor superior de la pila. si el valor es "0", lanza una excepcion (script invalido). Si es distinto de "0",
 * continua la ejecucion. No deja ningun valor en la pila.
 */
public class OpVerify implements OpCode {
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String value = stack.pop();
        
        if (value.equals("0")) {
            throw new RuntimeException("El valor en la cima es falso");
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
