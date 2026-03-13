package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine; 

public class OpLiteral implements OpCode {
    
    private final String value;
    private final String name;

    public OpLiteral(String value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        stack.push(this.value);
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return getName();
    }
}