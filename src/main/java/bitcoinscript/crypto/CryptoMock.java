public class CryptoMock {

    public static String hash160(String data) {
        return "HASH160(" + data + ")";
    }
    
    public static boolean verifySignature(String signature, String pubkey) {
        if (!signature.startsWith("SIG_") || !pubkey.startsWith("PUB_")) {
            return false;
        }
        String sigId = signature.substring(4);  
        String pubId = pubkey.substring(4);     
        return sigId.equals(pubId);
    }
}
