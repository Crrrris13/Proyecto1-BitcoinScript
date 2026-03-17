package bitcoinscript.tests;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.opcodes.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Conjunto de pruebas unitarias para validar el comportamiento de algunos opcodes del sistema.
 */
public class OpcodeTests {

    /**
     * Verifica que OP_ADD suma correctamente dos enteros.
     */
    @Test
    void testOpAddCorrecto() {
        BitcoinStack stack = new BitcoinStack();
        stack.push("2");
        stack.push("3");

        new OpAdd().execute(stack, null);

        assertEquals("5", stack.peek());
    }

    /**
     * Verifica que OP_ADD lanza una excepcion cuando los operandos no son numeros validos.
     */
    @Test
    void testOpAddFallaTipo() {
        BitcoinStack stack = new BitcoinStack();
        stack.push("a");
        stack.push("3");

        assertThrows(RuntimeException.class,
                () -> new OpAdd().execute(stack, null));
    }

    /**
     * Verifica que OP_DUP duplica correctamente el elemento superior de la pila.
     */
    @Test
    void testOpDup() {
        BitcoinStack stack = new BitcoinStack();
        stack.push("10");

        new OpDup().execute(stack, null);

        assertEquals("10", stack.pop());
        assertEquals("10", stack.pop());
    }

    /**
     * Verifica que OP_DROP elimina el elemento superior de la pila.
     */
    @Test
    void testOpDrop() {
        BitcoinStack stack = new BitcoinStack();
        stack.push("10");

        new OpDrop().execute(stack, null);

        assertTrue(stack.isEmpty());
    }

    /**
     * Verifica que OP_EQUAL devuelve verdadero ("1") cuando los valores son iguales.
     */
    @Test
    void testOpEqualTrue() {
        BitcoinStack stack = new BitcoinStack();
        stack.push("5");
        stack.push("5");

        new OpEqual().execute(stack, null);

        assertEquals("1", stack.peek());
    }

    /**
     * Verifica que OP_EQUAL devuelve falso ("0") cuando los valores son distintos.
     */
    @Test
    void testOpEqualFalse() {
        BitcoinStack stack = new BitcoinStack();
        stack.push("5");
        stack.push("7");

        new OpEqual().execute(stack, null);

        assertEquals("0", stack.peek());
    }

    /**
     * Verifica que OP_BOOLAND realiza correctamente la operación logica AND.
     */
    @Test
    void testOpBoolAnd() {
        BitcoinStack stack = new BitcoinStack();
        stack.push("1");
        stack.push("1");

        new OpBooland().execute(stack, null);

        assertEquals("1", stack.peek());
    }
}