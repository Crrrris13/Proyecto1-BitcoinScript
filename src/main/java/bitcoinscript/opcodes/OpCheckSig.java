package bitcoinscript.opcodes;

import bitcoinscript.crypto.CryptoMock;
import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

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
