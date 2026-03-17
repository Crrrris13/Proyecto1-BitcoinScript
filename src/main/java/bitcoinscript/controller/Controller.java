package bitcoinscript.controller;

import bitcoinscript.engine.ScriptEngine;
import bitcoinscript.view.View; 

/**
 * Clase controladora que coordina la interaccion entre la vista (View) y el motor de ejecucion (ScriptEngine).
 * Su responsabilidad principal es ejecutar scripts y mostrar los resultados al usuario.
 */
public class Controller {

    private ScriptEngine engine;
    private View view;
    
    /**
     * Constructor del controlador.
     * Inicializa el controlador con un motor de ejecucion y una vista.
     * @param engine motor de ejecucion de scripts
     * @param view vista para mostrar resultados
     */
    public Controller(ScriptEngine engine, View view) {
        this.engine = engine;
        this.view = view;
    }

    /**
     * Ejecuta una demostracion completa de un script.
     * Este metodo sigue el siguiente flujo: Muestra el encabezado, imprime los scripts (scriptSig y scriptPubKey) ejecuta
     * el script usando el ScriptEngine, muestra el resultado (valido o invalido) y finaliza.
     * @param scriptSig script de entrada (firma y datos)
     * @param scriptPubKey script de validacion
     */
    public void runDemo(String scriptSig, String scriptPubKey) {
        
        view.showHeader();
        view.showScripts(scriptSig, scriptPubKey);

        boolean result = engine.executeScript(scriptSig, scriptPubKey);

        view.showResult(result);
        view.showFooter();
    }

}