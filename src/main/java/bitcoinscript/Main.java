package bitcoinscript;

import bitcoinscript.controller.Controller;
import bitcoinscript.engine.ScriptEngine;
import bitcoinscript.view.View;

public class Main {
    public static void main(String[] args) {

        ScriptEngine engine = new ScriptEngine();
        engine.setTraceMode(true); // Activar modo TRACE para mostrar detalles de la ejecución
        View view = new View();
        Controller controller = new Controller(engine, view);;
        String firma = "SIG_user1";
        String pubKey = "PUB_user1";
        String pubKeyHash = "HASH160(" + pubKey + ")";
        String scriptSig = firma + " " + pubKey;
        String scriptPubKey = "OP_DUP OP_HASH160 " + pubKeyHash + " OP_EQUALVERIFY OP_CHECKSIG";
        controller.runDemo(scriptSig, scriptPubKey);
    }
}