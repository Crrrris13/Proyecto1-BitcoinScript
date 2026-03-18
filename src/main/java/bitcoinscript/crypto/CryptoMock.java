package bitcoinscript.crypto;

/**
 * Implementacion simulada de los opcodes. No implementa criptografia real, sino que usa metodos simplificados 
 * utilizados para las pruebas del interprete.
 */
public class CryptoMock {

    /**
     * Simula una operacion HASH160
     * @param data datos de entrada
     * @return representacion simulada del hash
     */
    public static String hash160(String data) {
        return "HASH160(" + data + ")";
    }

    /**
     * Simula una operacion SHA256.
     * @param data datos de entrada
     * @return representacion simulada del hash
     */
    public static String sha256(String data) {
        return "SHA256(" + data + ")";
    }
    
    /**
     * Verifica una firma digital simulada.
     * Se considera valida si el identificador de la firma coincide con el identificador de la clave publica.
     * @param signature firma digital
     * @param pubkey clave publica
     * @return true si la firma es valida
     */
    public static boolean verifySignature(String signature, String pubkey) {
        if (!signature.startsWith("SIG_") || !pubkey.startsWith("PUB_")) {
            return false;
        }
        String sigId = signature.substring(4);  
        String pubId = pubkey.substring(4);     
        return sigId.equals(pubId);
    }
}
