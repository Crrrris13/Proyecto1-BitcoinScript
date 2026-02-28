package bitcoinscript.controller;

import bitcoinscript.engine.ScriptEngine;
import bitcoinscript.view.View; 

public class Controller {

    private ScriptEngine engine;
    private View view;
    
    public Controller(ScriptEngine engine, View view) {
        this.engine = engine;
        this.view = view;
    }

    public void runDemo(String scriptSig, String scriptPubKey) {
        
        view.showHeader();
        view.showScripts(scriptSig, scriptPubKey);

        boolean result = engine.executeScript(scriptSig, scriptPubKey);

        view.showResult(result);
        view.showFooter();
    }

}