package bitcoinscript.opcodes;

import bitcoinscript.crypto.CryptoMock;
import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * La operacion OP_HASH160.
 * Aplica una funcion hash simulada sobre el valor superior de la pila con el CryptoMock.
 * Resultado:
 * reemplaza el valor por su hash
 */
public class OpHash160 implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String value = stack.pop();
        String hash160 = CryptoMock.hash160(value);
        stack.push(hash160);
    }

    @Override
    public String getName() {
        return "OP_HASH160";
    }

    @Override
    public String toString() {
        return getName();
    }
}