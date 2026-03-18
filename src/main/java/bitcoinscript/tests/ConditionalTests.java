package bitcoinscript.tests;

import bitcoinscript.engine.ScriptEngine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Conjunto de pruebas para validar el comportamiento de las condicionales de control de flujo en el ScriptEngine.
 */
public class ConditionalTests {

    /**
     * Verifica que el bloque IF se ejecuta cuando la condicion es verdadera.
     */
    @Test
    void testIfTrueBranch() {

        ScriptEngine engine = new ScriptEngine();

        String scriptSig = "";
        String scriptPubKey =
                "OP_1 OP_IF OP_2 OP_ELSE OP_3 OP_ENDIF";

        boolean result = engine.executeScript(scriptSig, scriptPubKey);

        assertTrue(result);
    }

    /**
     * Verifica que se ejecuta el bloque ELSE cuando la condicion del IF es falsa.
     */
    @Test
    void testIfElseBranch() {

        ScriptEngine engine = new ScriptEngine();

        String scriptSig = "";
        String scriptPubKey =
                "OP_0 OP_IF OP_2 OP_ELSE OP_3 OP_ENDIF";

        boolean result = engine.executeScript(scriptSig, scriptPubKey);

        assertTrue(result);
    }

    /**
     * Verifica que el motor maneja correctamente las estructuras IF.
     */
    @Test
    void testNestedIf() {

        ScriptEngine engine = new ScriptEngine();

        String scriptSig = "";
        String scriptPubKey =
                "OP_1 OP_IF OP_1 OP_IF OP_2 OP_ENDIF OP_ENDIF";

        boolean result = engine.executeScript(scriptSig, scriptPubKey);

        assertTrue(result);
    }
}