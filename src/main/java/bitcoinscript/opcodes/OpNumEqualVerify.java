package bitcoinscript.opcodes;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;

/**
 * La operacion OP_NUMEQUALVERIFY.
 * Compara dos valores numericos y falla si no son iguales. A diferencia de OP_EQUAL: compara los valores como enteros,
 * no deja su resultado en la pila y lanza una excepción si son distintos
 */
public class OpNumEqualVerify implements OpCode {

    @Override
    public void execute(BitcoinStack stack, ScriptEngine engine) {
        String bStr = stack.pop();
        String aStr = stack.pop();
        
        try {
            int b = Integer.parseInt(bStr);
            int a = Integer.parseInt(aStr);
            if (a != b) {
                throw new RuntimeException("Los números no son iguales");
            }      
        } catch (NumberFormatException e) {
            throw new RuntimeException("Los operandos deben ser enteros");
        }
    }

    @Override
    public String getName() {
        return "OP_NUMEQUALVERIFY";
    }

    @Override
    public String toString() {
        return getName();
    }
}