package com.chen.jason.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/**
 * Created on 2019/3/31. By CenJS
 */
public class AesEncryptUtil {
    //使用AES-128-CBC加密模式，key需要为16位,key和iv可以相同！
    private static String KEY = "1234567890123456";
    private static String IV = "1234567890123456";

    //加密方法
    public static String encrypt(String data, String key, String iv) throws Exception {
        try {
            //"算法/模式/补码方式"NoPadding PkcsPadding
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();

            byte[] dataBytes = data.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new Base64().encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //解密方法
    public static String desEncrypt(String data, String key, String iv) throws Exception {
        try {
            byte[] encrypted1 = new Base64().decode(data);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String data) throws Exception {
        return encrypt(data, KEY, IV);
    }

    public static String desEncrypt(String data) throws Exception {
        return desEncrypt(data, KEY, IV);
    }

    public static void main(String[] args) throws Exception {
        String name = "测试姓名";
        String test = new String(name.getBytes(),"UTF-8");
        String dataTo = encrypt(test);
        String dataFrom = desEncrypt(dataTo);
        System.out.println("对数据\'"+name+"\'进行加密："+dataTo+"\n对加密数据进行解密->"+dataFrom);

        String s = "1";
        String test1 = new String(s.getBytes(),"UTF-8");
        String dataTo1 = encrypt(test1);
        String dataFrom1 = desEncrypt(dataTo1);
        System.out.println("对数据\'"+s+"\'进行加密："+dataTo1+"\n对加密数据进行解密->"+dataFrom1);

    }
}
