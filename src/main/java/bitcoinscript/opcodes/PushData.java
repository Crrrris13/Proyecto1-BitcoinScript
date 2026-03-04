package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

public class PushData implements OpCode {
    private String value;

    public PushData(String value) {
        this.value = value;
    }

    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        stack.push(value);
    }

    @Override
    public String getName() {
        return "PUSH(" + value + ")";
    }

    @Override
    public String toString() {
        return getName();
    }
}