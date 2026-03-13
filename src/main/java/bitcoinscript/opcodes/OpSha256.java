package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;
import bitcoinscript.crypto.CryptoMock;

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