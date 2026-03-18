package bitcoinscript.opcodes;

import bitcoinscript.crypto.CryptoMock;
import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * La operacion OP_SHA256.
 * Hace una funcion hash SHA-256 simulada sobre el valor superior de la pila con el CryptoMock.
 * Resultado:
 * reemplaza el valor original por su hash SHA-256
 */
public class OpSha256 implements OpCode {

    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String data = stack.pop(); 
        CryptoMock crypto = new CryptoMock();
        String hashResult = crypto.sha256(data);    
        stack.push(hashResult); 
    }

    @Override
    public String getName() {
        return "OP_SHA256";
    }

    @Override
    public String toString() {
        return getName();
    }
}