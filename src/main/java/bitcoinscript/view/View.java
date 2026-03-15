package bitcoinscript.view;

public class View {

    public void showHeader() {
        System.out.println("Bitcoin Script Interpreter");
    }

    public void showScripts(String sig, String pub) {
        System.out.println("scriptSig:    " + sig);
        System.out.println("scriptPubKey: " + pub);
    }

    public void showResult(boolean result) {
        if (result) {
            System.out.println("Transaccion valida");
        } else {
            System.out.println("Transaccion invalida");
        }
    }

    public void showFooter() {
        System.out.println("Fin\n");
    }

    public void showTestHeader(int numero, String descripcion) {
        System.out.println("  PRUEBA " + numero + ": " + descripcion);
    }
}