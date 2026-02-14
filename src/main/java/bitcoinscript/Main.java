package bitcoinscript;

import bitcoinscript.controller.Controller;
import bitcoinscript.engine.ScriptEngine;
import bitcoinscript.view.View;

public class Main {
    public static void main(String[] args) {

        ScriptEngine engine = new ScriptEngine(true); 
        View view = new View();
        Controller controller = new Controller(engine, view);
        String firma = "firma_valida";
        String pubKey = "clave_publica";
        String pubKeyHash = "hash_clave_publica";
        String scriptSig = firma + " " + pubKey;
        String scriptPubKey =
                "OP_DUP OP_HASH160 " + pubKeyHash +
                " OP_EQUALVERIFY OP_CHECKSIG";
        controller.runDemo(scriptSig, scriptPubKey);
    }
}