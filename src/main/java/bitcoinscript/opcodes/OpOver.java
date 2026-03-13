package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

public class OpOver implements OpCode {

    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String top1 = stack.pop();
        String top2 = stack.pop();
        stack.push(top2);
        stack.push(top1);
        stack.push(top2);
    }

    @Override
    public String getName() {
        return "OP_OVER";
    }

    @Override
    public String toString() {
        return getName();
    }
}