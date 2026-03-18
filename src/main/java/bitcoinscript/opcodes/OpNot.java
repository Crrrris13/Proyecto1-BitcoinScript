package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * La operacion OP_NOT.
 * Invierte el valor logico del elemento superior de la pila.
 * Resultados:
 * valor verdadero (1): 0
 * valor falso (0): 1
 */
public class OpNot implements OpCode {
    @Override    
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String value = stack.pop();
        if (ScriptEngine.isTrue(value)) {
            stack.push("0");
        } else {
            stack.push("1");
        }
    }

    @Override
    public String getName() {
        return "OP_NOT";
    }
    @Override
    public String toString() {
        return getName();
    }
    
}
