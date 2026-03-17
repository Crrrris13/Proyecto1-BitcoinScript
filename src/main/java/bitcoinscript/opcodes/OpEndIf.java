package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * La operacion OP_ENDIF.
 * Finaliza un bloque condicional iniciado por OP_IF.
 * Restablece el estado de ejecucion del ScriptEngine.
 */
public class OpEndIf implements OpCode {
    
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        engine.exitIf();
    }

    @Override
    public String getName() {
        return "OP_ENDIF";
    }

    @Override
    public String toString() {
        return getName();
    }
    
}
