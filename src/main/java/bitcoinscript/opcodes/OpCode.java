package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * Interfaz que define el comportamiento de los opcode en el interprete. Todas las operaciones deben implementar
 * esta interfaz obligatoriamente. Define la logica de ejecucion sobre la pila y su nombre.
 */
public interface OpCode {

    /**
     * Ejecuta la operacion sobre la pila.
     * @param stack pila principal del script
     * @param engine motor de ejecucion
     */
    public void execute(BitcoinStack stack, ScriptEngine engine);
    
    /**
     * Devuelve el nombre del opcode.
     * @return nombre de la operacion
     */
    public String getName();
} 
