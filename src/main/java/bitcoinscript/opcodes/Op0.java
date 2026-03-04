package bitcoinscript.opcodes;
import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

public class Op0 implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        stack.push("0");
    }

    @Override
    public String getName() {
        return "OP_0";
    }

    @Override
    public String toString() {
        return getName();
    }
}