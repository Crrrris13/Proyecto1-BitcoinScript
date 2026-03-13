package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

public class OpLessThan implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String b = stack.pop();
        String a = stack.pop();

        try {
            long aValue = Long.parseLong(a);
            long bValue = Long.parseLong(b);

            if (aValue < bValue) {
                stack.push("1");
            } else {
                stack.push("0");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Los operandos deben ser números enteros");
        }
    }

    @Override
    public String getName() {
        return "OP_LESSTHAN";
    }

    @Override
    public String toString() {
        return getName();
    }
}