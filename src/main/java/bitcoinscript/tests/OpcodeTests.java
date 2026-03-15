package bitcoinscript.tests;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.opcodes.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OpcodeTests {

    @Test
    void testOpAddCorrecto() {
        BitcoinStack stack = new BitcoinStack();
        stack.push("2");
        stack.push("3");

        new OpAdd().execute(stack, null);

        assertEquals("5", stack.peek());
    }

    @Test
    void testOpAddFallaTipo() {
        BitcoinStack stack = new BitcoinStack();
        stack.push("a");
        stack.push("3");

        assertThrows(RuntimeException.class,
                () -> new OpAdd().execute(stack, null));
    }

    @Test
    void testOpDup() {
        BitcoinStack stack = new BitcoinStack();
        stack.push("10");

        new OpDup().execute(stack, null);

        assertEquals("10", stack.pop());
        assertEquals("10", stack.pop());
    }

    @Test
    void testOpDrop() {
        BitcoinStack stack = new BitcoinStack();
        stack.push("10");

        new OpDrop().execute(stack, null);

        assertTrue(stack.isEmpty());
    }

    @Test
    void testOpEqualTrue() {
        BitcoinStack stack = new BitcoinStack();
        stack.push("5");
        stack.push("5");

        new OpEqual().execute(stack, null);

        assertEquals("1", stack.peek());
    }

    @Test
    void testOpEqualFalse() {
        BitcoinStack stack = new BitcoinStack();
        stack.push("5");
        stack.push("7");

        new OpEqual().execute(stack, null);

        assertEquals("0", stack.peek());
    }

    @Test
    void testOpBoolAnd() {
        BitcoinStack stack = new BitcoinStack();
        stack.push("1");
        stack.push("1");

        new OpBooland().execute(stack, null);

        assertEquals("1", stack.peek());
    }
}