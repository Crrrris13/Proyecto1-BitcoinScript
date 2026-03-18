package bitcoinscript.view;
/**
 * Clase responsable de la salida por consola.
 * Implementa la vista, que muestra la informacion relacionada con la ejecucion y sus resultados.
 */
public class View {
    
    /**
     * Muestra el encabezado principal del programa.
     */
    public void showHeader() {
        System.out.println("Bitcoin Script Interpreter");
    }
   
    /**
     * Muestra los scripts que seran ejecutados.
     * @param sig scriptSig (firma y datos de entrada)
     * @param pub scriptPubKey (condiciones de gasto)
     */
    public void showScripts(String sig, String pub) {
        System.out.println("scriptSig:    " + sig);
        System.out.println("scriptPubKey: " + pub);
    }

    /**
     * Muestra el resultado de la ejecucion del script.
     * @param result true si la transaccion es valida, false en caso contrario
     */
    public void showResult(boolean result) {
        if (result) {
            System.out.println("Transaccion valida");
        } else {
            System.out.println("Transaccion invalida");
        }
    }

    /**
     * Muestra un pie de pagina al finalizar una prueba.
     */
    public void showFooter() {
        System.out.println("Fin\n");
    }


    /**
     * Muestra el encabezado de una prueba especifica.
     * @param numero numero de la prueba
     * @param descripcion descripcion de la prueba
     */
    public void showTestHeader(int numero, String descripcion) {
        System.out.println("  PRUEBA " + numero + ": " + descripcion);
    }
}