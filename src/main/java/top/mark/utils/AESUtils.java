package top.mark.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加解密算法
 * 
 * @author shenjunyu
 * @since 2023-07-30
 */
public class AESUtils {

    /**
     * 密钥
     */
    private static final String KEY = "46555f5e2e7611eebcf5b4b686fc1207";

    /**
     * 加密算法
     */
    private static final String ALGORITHM = "AES";

    /**
     * INSTANCE
     */
    private static final String INSTANCE = "AES/ECB/PKCS5Padding";

    /**
     * 加密
     * 
     * @param plainText
     * @return
     * @throws Exception
     */
    public static String encrypt(String plainText) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        Cipher cipher = Cipher.getInstance(INSTANCE);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    /**
     * 解密
     * 
     * @param encryptedText
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptedText) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        Cipher cipher = Cipher.getInstance(INSTANCE);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}
