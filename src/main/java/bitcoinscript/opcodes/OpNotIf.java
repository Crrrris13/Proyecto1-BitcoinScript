package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * La operacion OP_NOTIF.
 * si el valor es falso (0) : ejecuta el bloque
 * si es verdadero (1) : omite el bloque
 */
public class OpNotIf implements OpCode {

    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        if(engine.shouldExecute()) {
            String value = stack.pop();
            boolean condicion = !ScriptEngine.isTrue(value);
            engine.enterIf(condicion);
        }else {
            engine.enterIf(false);
        }
        
    }

    @Override
    public String getName() {
        return "OP_NOTIF";
    }

    @Override
    public String toString() {
        return getName();
    }
}