package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine; 

public class OpGreaterThan implements OpCode {

    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String bStr = stack.pop();
        String aStr = stack.pop();
        
        try {
            int b = Integer.parseInt(bStr);
            int a = Integer.parseInt(aStr);
            
            if (a > b) {
                stack.push("1");
            } else {
                stack.push("0");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("OP_GREATERTHAN: Los operandos deben ser números enteros.");
        }
    }

    @Override
    public String getName() {
        return "OP_GREATERTHAN";
    }

    @Override
    public String toString() {
        return getName();
    }
}