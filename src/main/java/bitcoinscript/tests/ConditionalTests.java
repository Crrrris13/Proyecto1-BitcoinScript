package bitcoinscript.tests;

import bitcoinscript.engine.ScriptEngine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConditionalTests {

    @Test
    void testIfTrueBranch() {

        ScriptEngine engine = new ScriptEngine();

        String scriptSig = "";
        String scriptPubKey =
                "OP_1 OP_IF OP_2 OP_ELSE OP_3 OP_ENDIF";

        boolean result = engine.executeScript(scriptSig, scriptPubKey);

        assertTrue(result);
    }

    @Test
    void testIfElseBranch() {

        ScriptEngine engine = new ScriptEngine();

        String scriptSig = "";
        String scriptPubKey =
                "OP_0 OP_IF OP_2 OP_ELSE OP_3 OP_ENDIF";

        boolean result = engine.executeScript(scriptSig, scriptPubKey);

        assertTrue(result);
    }

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