package com.xinxiwang.janfan;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
public class JiaMi {
    // 密钥生成器
    private KeyGenerator kg = null;
    // 密钥
    private SecretKey key = null;
    // 进行加密和解密
    private Cipher cip = null;
    public JiaMi() throws Exception{
        kg = KeyGenerator.getInstance("DES");
        key = kg.generateKey();
        cip = Cipher.getInstance("DES");
    }
    public byte[] encrypt(byte[] s) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        // 初始化
        cip.init(Cipher.ENCRYPT_MODE, key);
        // 加密
        return cip.doFinal(s);
    }
    public byte[] decrypt(byte[] b) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        // 初始化
        cip.init(Cipher.DECRYPT_MODE, key);
        // 解密
        return cip.doFinal(b);
    }
    public static void main(String[] args) {
        try {
            JiaMi jiaMi = new JiaMi();
            String str = "aba萨芬斯蒂芬";
            // 加密
            byte[] temp = jiaMi.encrypt(str.getBytes());
            // 解密
            byte[] flag = jiaMi.decrypt(temp);
            System.out.println("明文 : " + str);
            System.out.println("加密后的数据 : " + new String(temp));
            System.out.println("解密后的数据 : " + new String(flag));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
