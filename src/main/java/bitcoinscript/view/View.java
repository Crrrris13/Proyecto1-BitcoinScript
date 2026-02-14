package bitcoinscript.view;

public class View {

    public void showHeader() {
        System.out.println("Demo P2PKH");
    }
    public void showScripts(String sig, String pub) {
        System.out.println("scriptSig: " + sig);
        System.out.println("scriptPubKey: " + pub);
    }
    public void showResult(boolean result) {
        if (result) {
            System.out.println("Transacción valida");
        } else {
            System.out.println("Transacción invalida");
        }
    }
    public void showFooter() {
        System.out.println("Fin de la demo");
    }
}