package bitcoinscript.opcodes;

import bitcoinscript.crypto.CryptoMock;
import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * La operacion OP_CHECKSIGVERIFY.
 * Verifica la firma digital y falla si la verificacion es invalida. A diferencia de OP_CHECKSIG,
 * no deja resultado en la pila y lanza una excepcion si falla.
 */
public class OpCheckSigVerify implements OpCode {

    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String pubKey = stack.pop(); 
        String sig = stack.pop();    
        
        CryptoMock crypto = new CryptoMock();
        boolean isValid = crypto.verifySignature(sig, pubKey);
        
        if (!isValid) {
            throw new RuntimeException("La firma es inválida");
        }
    }

    @Override
    public String getName() { return "OP_CHECKSIGVERIFY"; }

    @Override
    public String toString() { return getName(); }
}