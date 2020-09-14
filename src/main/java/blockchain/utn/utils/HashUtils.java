package blockchain.utn.utils;

public class HashUtils {

    public static String getHashBlock(String txt) {
        try { java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }return null;
    }
}