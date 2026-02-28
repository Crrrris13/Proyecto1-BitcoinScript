package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;

public class OpAdd implements OpCode {

    public void execute(BitcoinStack stack) {
        String b = stack.pop();
        String a = stack.pop();
        try {
            int sum = Integer.parseInt(a) + Integer.parseInt(b);
            stack.push(Integer.toString(sum));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Los operandos deben ser números enteros");
        }
    }

    public String getName() {
        return "OP_ADD";
    }

    public String toString() {
        return getName();
    }
    
}
