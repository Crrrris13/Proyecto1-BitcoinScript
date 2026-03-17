package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine; 

/**
 * Representa un opcode literal que inserta un valor constante en la pila.
 * A diferencia de PushData, permite definir explicitamente un nombre para la operacion (por ejemplo OP_1 o OP_2,).
 * Ejemplo:
 * OP_1 -> inserta "1" en la pila
 */
public class OpLiteral implements OpCode {
    
    private final String value;
    private final String name;

    public OpLiteral(String value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        stack.push(this.value);
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return getName();
    }
}