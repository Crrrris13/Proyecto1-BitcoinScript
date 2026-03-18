package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * Una operacion de insercion de datos en la pila. Corresponde al Push de Bitcoin Script, donde un valor 
 * literal es colocado en la pila principal.
 */
public class PushData implements OpCode {
    private String value;

    /**
     * Crea una operacion de insercion de datos.
     * @param value valor que sera empujado a la pila
     */
    public PushData(String value) {
        this.value = value;
    }

    /**
     * Inserta el valor almacenado en la pila principal.
     * @param stack pila de ejecucion
     * @param engine motor de ejecucion del script
     */
    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        stack.push(value);
    }

    /**
     * Devuelve el nombre de la operacion.
     * @return nombre representativo del opcode
     */
    @Override
    public String getName() {
        return "PUSH(" + value + ")";
    }

    /**
     * Representacion textual del opcode.
     * @return nombre del opcode
     */
    @Override
    public String toString() {
        return getName();
    }
}