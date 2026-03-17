package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * La operacion OP_ADD.
 * Extrae dos valores de la pila, los suma y coloca el resultado nuevamente en la pila.
 * Ejemplo:
 * [2, 3] -> OP_ADD -> [5]
 */
public class OpAdd implements OpCode {

    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String b = stack.pop();
        String a = stack.pop();
        try {
            int sum = Integer.parseInt(a) + Integer.parseInt(b);
            stack.push(Integer.toString(sum));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Los operandos deben ser números enteros");
        }
    }
    @Override
    public String getName() {
        return "OP_ADD";
    }
    @Override
    public String toString() {
        return getName();
    }
    
}
