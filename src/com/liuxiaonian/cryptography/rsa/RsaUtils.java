package com.liuxiaonian.cryptography.rsa;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.management.MXBean;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RsaUtils {

    private static final int KEY_SIZE = 1024;
    private static final String ENCRYPT_TYPE = "RSA";
    private static final String CHARSET = "UTF-8";


    /**
     * @Author chengpunan
     * @Description Ĭ�ϴ�СΪ1024λ
     * @Date 16:20 2018/7/3
     * @Param []
     * @return com.liuxiaonian.cryptography.rsa.RsaEncrypt
     **/
    public static RsaEncrypt getRsaKeys(){
        return getRsaKeys(KEY_SIZE);
    }

    /**
     * @Author chengpunan
     * @Description ���ɹ�Կ��˽Կ��
     * @Date 16:21 2018/7/3
     * @Param [keySize]
     * @return com.liuxiaonian.cryptography.rsa.RsaEncrypt
     **/
    public static RsaEncrypt getRsaKeys(int keySize){
        KeyPairGenerator keyPairGenerator = null;
        RsaEncrypt rsaEncrypt = new RsaEncrypt();
        try {
            keyPairGenerator = KeyPairGenerator.getInstance(ENCRYPT_TYPE);
            keyPairGenerator.initialize(keySize);
            KeyPair keyPair = keyPairGenerator.genKeyPair();
            rsaEncrypt.setPublicKey(keyPair.getPublic());
            rsaEncrypt.setPrivateKey(keyPair.getPrivate());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return rsaEncrypt;
    }

    /**
     * @Author chengpunan
     * @Description ��ȡ����Base64�����Ĺ�Կ
     * @Date 16:39 2018/7/3
     * @Param [rsaEncrypt]
     * @return java.lang.String
     **/
    public static String getPublicKeyBase64(RsaEncrypt rsaEncrypt){
        PublicKey publicKey = rsaEncrypt.getPublicKey();
        byte[] temp = publicKey.getEncoded();
        //�ֽ�����תBase64����
        return Base64.encodeBase64URLSafeString(temp);
    }

    /**
     * @Author chengpunan
     * @Description ��ȡ����Base64������˽Կ
     * @Date 16:41 2018/7/3
     * @Param [rsaEncrypt]
     * @return java.lang.String
     **/
    public static String getPrivateKeyBase64(RsaEncrypt rsaEncrypt){
        PrivateKey privateKey = rsaEncrypt.getPrivateKey();
        byte[] temp = privateKey.getEncoded();
        //�ֽ�����תBase64����
        return Base64.encodeBase64URLSafeString(temp);
    }

    /**
     * @Author chengpunan
     * @Description ��Base64�����Ĺ�Կת��ΪPublicKey����
     * @Date 17:28 2018/7/3
     * @Param [base64PublicKey]
     * @return java.security.PublicKey
     **/
    public static RSAPublicKey base64ToPublicKey(String base64PublicKey){
        KeyFactory keyFactory = null;
        RSAPublicKey rsaPublicKey = null;
        try {
            keyFactory = KeyFactory.getInstance(ENCRYPT_TYPE);
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(base64PublicKey));
            rsaPublicKey = (RSAPublicKey) keyFactory.generatePublic(x509EncodedKeySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsaPublicKey;
    }

    /**
     * @Author chengpunan
     * @Description ������Base64�����˽Կת��ΪPrivateKey����
     * @Date 17:37 2018/7/3
     * @Param [base64PrivateKey]
     * @return java.security.PrivateKey
     **/
    public static RSAPrivateKey base64ToPrivateKey(String base64PrivateKey){
        KeyFactory keyFactory = null;
        RSAPrivateKey rsaPrivateKey = null;
        try {
            keyFactory = KeyFactory.getInstance(ENCRYPT_TYPE);
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(base64PrivateKey));
            rsaPrivateKey = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsaPrivateKey;
    }
    
    /**
     * @Author chengpunan
     * @Description ʹ�ù�Կ����
     * @Date 16:29 2018/7/3
     * @Param [data]
     * @return byte[]
     **/
    public static byte[] encryptByPublicKey(String Cleartext,RSAPublicKey publicKey){
        byte[] result = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE,publicKey);
            result = rsaSplitCodec(cipher,Cipher.ENCRYPT_MODE,Cleartext.getBytes("UTF-8"),publicKey.getModulus().bitLength());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



    /**
     * @Author chengpunan
     * @Description ˽Կ����
     * @Date 17:41 2018/7/3
     * @Param [data, privateKey]
     * @return byte[]
     **/
    public static byte[] decryptByPrivateKey(String Ciphertext,RSAPrivateKey privateKey){
        byte[] result = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE,privateKey);
            return rsaSplitCodec(cipher,Cipher.DECRYPT_MODE,Base64.decodeBase64(Ciphertext),privateKey.getModulus().bitLength());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @Author chengpunan
     * @Description �Ѽ��ܺ���ֽ����龭��Base64����ת��Ϊ�ַ���
     * @Date 15:04 2018/7/4
     * @Param [data]
     * @return java.lang.String
     **/
    public static String decodeByBase64(byte[] data){
        return Base64.encodeBase64URLSafeString(data);
    }

    /**
     * @Author chengpunan
     * @Description �ѽ��ܺ���ֽ�����ת��Ϊ�ַ���
     * @Date 16:28 2018/7/4
     * @Param [data]
     * @return java.lang.String
     **/
    public static String encodeByBase64(byte[] data){
        String result = null;
        try {
            result = new String(data,CHARSET);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @Author chengpunan
     * @Description ����ֽ�����
     * @Date 16:09 2018/7/4
     * @Param [cipher, encryptMode, bytes, i]
     * @return byte[]
     **/
    private static byte[] rsaSplitCodec(Cipher cipher, int encryptMode, byte[] bytes, int keySize) {
        int maxBlock = 0;
        if (encryptMode == Cipher.DECRYPT_MODE){
            maxBlock = keySize / 8;
        }else {
            maxBlock = keySize / 8 -11;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] buff;
        int i = 0;
        try {
            while (bytes.length > offSet){
                if (bytes.length - offSet > maxBlock){
                    buff = cipher.doFinal(bytes,offSet,maxBlock);
                }else {
                    buff = cipher.doFinal(bytes,offSet,bytes.length - offSet);
                }
                byteArrayOutputStream.write(buff,0,buff.length);
                i++;
                offSet = i * maxBlock;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        byte[] resultDatas = byteArrayOutputStream.toByteArray();
        IOUtils.closeQuietly(byteArrayOutputStream);
        return resultDatas;
    }
    
    /**
     * @Author chengpunan
     * @Description ����
     * @Date 17:45 2018/7/3
     * @Param []
     * @return void
     **/
    public static void main(String[] args) throws UnsupportedEncodingException {
        RsaEncrypt rsaEncrypt = getRsaKeys();
        System.err.println("ԭʼ�Ĺ�ԿΪ:"+rsaEncrypt.getPublicKey());
        System.err.println("ԭʼ��˽ԿΪ:"+rsaEncrypt.getPrivateKey());
        System.err.println("**********************************************************");
        System.err.println("����Base64����Ĺ�ԿΪ:"+getPublicKeyBase64(rsaEncrypt));
        System.err.println("����Base64�����˽ԿΪ:"+getPrivateKeyBase64(rsaEncrypt));
        System.err.println("**********************************************************");
        System.err.println("��Base64����Ĺ�Կת��ΪRSAPublicKey����Ϊ:"+base64ToPublicKey(getPublicKeyBase64(rsaEncrypt)));
        System.err.println("��Base64�����˽Կת��ΪRSAPrivateKey����Ϊ:"+base64ToPrivateKey(getPrivateKeyBase64(rsaEncrypt)));
        System.err.println("**********************************************************");
        String message = "hello, i am infi, good night!";
        System.err.println("�������ܵ�����Ϊ:"+decodeByBase64(encryptByPublicKey(message,base64ToPublicKey(getPublicKeyBase64(rsaEncrypt)))));
        System.err.println("�������ܵ�����Ϊ:"+encodeByBase64(decryptByPrivateKey(decodeByBase64(encryptByPublicKey(message,base64ToPublicKey(getPublicKeyBase64(rsaEncrypt)))),base64ToPrivateKey(getPrivateKeyBase64(rsaEncrypt)))));
    }
}
