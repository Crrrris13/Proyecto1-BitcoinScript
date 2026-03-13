package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;
import bitcoinscript.crypto.CryptoMock;

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