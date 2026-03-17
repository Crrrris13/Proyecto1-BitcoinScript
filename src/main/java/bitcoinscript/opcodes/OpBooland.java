package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * La operacion OP_BOOLAND.
 * Evalua dos valores como bool y realiza un AND logico.
 * Resultados posibles:
 * true AND true (es decir, 1 AND 1): 1
 * cualquier otro caso: 0
 */
public class OpBooland implements OpCode {

    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String b = stack.pop();
        String a = stack.pop();
        if (isTrue(a) && isTrue(b)) {
            stack.push("1");
        } else {
            stack.push("0");    
        }
    }
    @Override
    public String getName() {
        return "OP_BOOLAND";
    }
    @Override
    public String toString() {
        return getName();
    }

    private boolean isTrue(String value) {
        return !value.equals("0") && !value.equals("");
    }
}