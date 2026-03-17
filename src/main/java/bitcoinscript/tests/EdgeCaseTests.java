package bitcoinscript.tests;

import bitcoinscript.engine.BitcoinStack;
import bitcoinscript.engine.ScriptEngine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias JUnit. Verifica casos limite del interprete de Bitcoin Script (validan comportamientos anomalos)
 */
public class EdgeCaseTests {

    /**
     * Verifica que hacer pop sobre una pila vacia produce una excepcion.
     */
    @Test
    void testPopPilaVacia() {
        BitcoinStack stack = new BitcoinStack();

        assertThrows(RuntimeException.class,
                stack::pop);
    }

    /**
     * Verifica que la operacion DUP sobre una pila vacia genera una excepcion.
     */
    @Test
    void testDupPilaVacia() {
        BitcoinStack stack = new BitcoinStack();

        assertThrows(RuntimeException.class,
                stack::dup);
    }

    /**
     * Verifica que un token de script invalido provoque que la ejecucion del script falle.
     */
    @Test
    void testScriptTokenInvalido() {

        ScriptEngine engine = new ScriptEngine();

        boolean result = engine.executeScript(
                "",
                "OP_INVALID"
        );

        assertFalse(result);
    }

     /**
     * Verifica que si el script termina con una pila vacia el resultado sea invalido.
     */
    @Test
    void testStackFinalVacia() {

        ScriptEngine engine = new ScriptEngine();

        boolean result = engine.executeScript("", "");

        assertFalse(result);
    }
}