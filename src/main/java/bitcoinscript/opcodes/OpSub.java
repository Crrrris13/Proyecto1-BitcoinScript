package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * La operacion OP_SUB.
 * Extrae dos valores de la pila, los interpreta como enteros y realiza una resta (a - b).
 * Ejemplo:
 * [5, 3] -> OP_SUB -> [2]
 */
public class OpSub implements OpCode {

    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String bStr = stack.pop();
        String aStr = stack.pop();
        int a = Integer.parseInt(aStr);
        int b = Integer.parseInt(bStr);
        int result = a - b;
        stack.push(Integer.toString(result));
    }

    public String getName() {
        return "OP_SUB";
    }

    public String toString() {
        return getName();
    }
}
