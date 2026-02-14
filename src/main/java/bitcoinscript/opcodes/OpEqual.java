package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;

public class OpEqual implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack) {
        String value1 = stack.pop();
        String value2 = stack.pop();
        
        if (value1.equals(value2)) {
            stack.push("1");
        } else {
            stack.push("0");
        }
    }

    @Override
    public String getName() {
        return "OP_EQUAL";
    }

    @Override
    public String toString() {
        return getName();
    }
    
}
