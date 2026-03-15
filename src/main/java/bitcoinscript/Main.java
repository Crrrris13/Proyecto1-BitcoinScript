package bitcoinscript;

import bitcoinscript.controller.Controller;
import bitcoinscript.engine.ScriptEngine;
import bitcoinscript.view.View;

public class Main {
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
    }
}