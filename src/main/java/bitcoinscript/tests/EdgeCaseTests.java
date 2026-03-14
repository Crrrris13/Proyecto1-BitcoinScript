package bitcoinscript.tests;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EdgeCaseTests {

    @Test
    void testPopPilaVacia() {
        BitcoinStack stack = new BitcoinStack();

        assertThrows(RuntimeException.class,
                stack::pop);
    }

    @Test
    void testDupPilaVacia() {
        BitcoinStack stack = new BitcoinStack();

        assertThrows(RuntimeException.class,
                stack::dup);
    }

    @Test
    void testScriptTokenInvalido() {

        ScriptEngine engine = new ScriptEngine();

        boolean result = engine.executeScript(
                "",
                "OP_INVALID"
        );

        assertFalse(result);
    }

    @Test
    void testStackFinalVacia() {

        ScriptEngine engine = new ScriptEngine();

        boolean result = engine.executeScript("", "");

        assertFalse(result);
    }
}