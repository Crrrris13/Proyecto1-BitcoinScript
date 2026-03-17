package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * La operacion OP_IF.
 * Evalua un if basada en el valor superior de la pila y controla el flujo de ejecucion del script. Si el valor es verdadero,
 * ejecuta el bloque if. Si es falso, se omite hasta OP_ELSE o OP_ENDIF
 */
public class OpIf implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        boolean condition = engine.shouldExecute();

        if (condition) {
            String value = stack.pop();

            boolean conditionValue = ScriptEngine.isTrue(value);
            engine.enterIf(conditionValue);
        } else {
            engine.enterIf(false);
        }
    }

    @Override
    public String getName() {
        return "OP_IF";
    }

    @Override
    public String toString() {
        return getName();
    }
    
}
