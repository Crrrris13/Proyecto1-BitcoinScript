package bitcoinscript;

import bitcoinscript.controller.Controller;
import bitcoinscript.engine.ScriptEngine;
import bitcoinscript.view.View;

/**
 * Punto de entrada de la aplicacion.
 * Esta clase ejecuta una serie de pruebas demostrativas del interprete. Los resultados se muestran a traves de la clase View.
 */

public class Main {
    /**
     * Método principal del programa. Ejecuta varios escenarios de prueba para demostrar el funcionamiento del motor 
     * de ejecucion de scripts.
     * @param args argumentos de linea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        View view = new View();

        ScriptEngine engine1 = new ScriptEngine();
        Controller controller1 = new Controller(engine1, view);
        String scriptSig1 = "SIG_user1 PUB_user1";
        String scriptPubKey1 = "OP_DUP OP_HASH160 HASH160(PUB_user1) OP_EQUALVERIFY OP_CHECKSIG";
        view.showTestHeader(1, "P2PKH Datos correctos");
        controller1.runDemo(scriptSig1, scriptPubKey1);

        ScriptEngine engine2 = new ScriptEngine();
        Controller controller2 = new Controller(engine2, view);
        String scriptSig2 = "SIG_hacker PUB_user2";
        String scriptPubKey2 = "OP_DUP OP_HASH160 HASH160(PUB_user2) OP_EQUALVERIFY OP_CHECKSIG";
        view.showTestHeader(2, "P2PKH Firma fraudulenta");
        controller2.runDemo(scriptSig2, scriptPubKey2);

        ScriptEngine engine3 = new ScriptEngine();
        Controller controller3 = new Controller(engine3, view);
        String scriptSig3    = "";
        String scriptPubKey3 = "OP_1 OP_IF OP_1 OP_ELSE OP_0 OP_ENDIF";
        view.showTestHeader(3, "Control de flujo con OP_IF y OP_ELSE");
        controller3.runDemo(scriptSig3, scriptPubKey3);

        ScriptEngine engine4 = new ScriptEngine();
        Controller controller4 = new Controller(engine4, view);
        String scriptSig4    = "5 5";
        String scriptPubKey4 = "OP_EQUAL";
        view.showTestHeader(4, "Comparación de valores con OP_EQUAL");
        controller4.runDemo(scriptSig4, scriptPubKey4);

        ScriptEngine engine5 = new ScriptEngine();
        Controller controller5 = new Controller(engine5, view);

        String scriptSig5    = "5 3";
        String scriptPubKey5 = "OP_ADD OP_8 OP_EQUAL OP_IF OP_10 OP_2 OP_SUB OP_ELSE OP_0 OP_ENDIF";
        view.showTestHeader(5, "Operaciones aritméticas y control de flujo combinados");
        controller5.runDemo(scriptSig5, scriptPubKey5);

        String scriptSig6    = "5 5";
        String scriptPubKey6 = "OP_EQUAL OP_IF OP_3 OP_1 OP_GREATERTHAN OP_IF OP_10 OP_ELSE OP_0 OP_ENDIF OP_ELSE OP_0 OP_ENDIF";
        view.showTestHeader(6, "Control de flujo anidado con OP_IF");
        controller5.runDemo(scriptSig6, scriptPubKey6);

    }
}