package bitcoinscript.opcodes;

import bitcoinscript.crypto.CryptoMock;
import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * La operacion OP_CHECKSIG.
 * Extrae una firma y una clave publica de la pila y verifica si la firma es valida con el CryptoMock.
 * Resultados:
 * firma valida: 1
 * firma invalida: 0
 * Orden de la pila:
 * [firma, clavePublica]
 */
public class OpCheckSig implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String publicKey = stack.pop();
        String signature = stack.pop();

        boolean isValid = CryptoMock.verifySignature(signature, publicKey);
        
        if (isValid) {
            stack.push("1");
        } else {
            stack.push("0");
        }
    }

    @Override
    public String getName() {
        return "OP_CHECKSIG";
    }

    @Override
    public String toString() {
        return getName();
    }
}
