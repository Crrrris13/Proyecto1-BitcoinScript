package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * La operacion OP_BOOLOR.
 * Evalua dos valores como bool y realiza un OR logico.
 * Resultados posibles:
 * si al menos uno es verdadero (al menos un 1): 1
 * si ambos son falsos (0 y 0): 0
 */
public class OpBoolOr implements OpCode {

    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String b = stack.pop();
        String a = stack.pop();
        if (isTrue(a) || isTrue(b)) {
            stack.push("1");
        } else {
            stack.push("0");    
        }
    }

    @Override
    public String getName() {
        return "OP_BOOLOR";
    }
    @Override
    public String toString() {
        return getName();
    }

    private boolean isTrue(String value) {
        return !value.equals("0") && !value.equals("");
    }
    
}
