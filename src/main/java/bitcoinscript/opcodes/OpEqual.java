package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * La operacion OP_EQUAL.
 * Compara dos valores de la pila.
 * Resultado:
 * si son iguales (00 o 11) -> 1
 * si son diferentes (01 o 10) -> 0
 */
public class OpEqual implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
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
