package com.zte.eas.appframe.business.syscommon;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class InfoMapEncrypt
{
  public static String key = "LmMGStGtOpF4xNyvYt54EQ==";
  
  public static String encrypt(String paramString)
  {
    byte[] arrayOfByte1 = null;
    try
    {
      arrayOfByte1 = paramString.getBytes("utf-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    byte[] arrayOfByte2 = null;
    try
    {
      arrayOfByte2 = MD5Hash(arrayOfByte1, 0, arrayOfByte1.length);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    byte[] arrayOfByte3 = addMD5(arrayOfByte2, arrayOfByte1);
    byte[] arrayOfByte4 = new byte[8];
    byte[] arrayOfByte5 = new byte[8];
    getKeyIV(key, arrayOfByte4, arrayOfByte5);
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(arrayOfByte4, "DES");
    IvParameterSpec localIvParameterSpec = new IvParameterSpec(arrayOfByte5);
    byte[] arrayOfByte6 = null;
    try
    {
      arrayOfByte6 = DES_CBC_Encrypt(arrayOfByte3, localSecretKeySpec, localIvParameterSpec);
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    return new BASE64Encoder().encode(arrayOfByte6);
  }
  
  public static String decrypt(String paramString)
    throws Exception
  {
    BASE64Decoder localBASE64Decoder = new BASE64Decoder();
    byte[] arrayOfByte1 = null;
    try
    {
      arrayOfByte1 = localBASE64Decoder.decodeBuffer(paramString);
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    byte[] arrayOfByte2 = new byte[8];
    byte[] arrayOfByte3 = new byte[8];
    getKeyIV(key, arrayOfByte2, arrayOfByte3);
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(arrayOfByte2, "DES");
    IvParameterSpec localIvParameterSpec = new IvParameterSpec(arrayOfByte3);
    byte[] arrayOfByte4 = null;
    try
    {
      arrayOfByte4 = DES_CBC_Decrypt(arrayOfByte1, localSecretKeySpec, localIvParameterSpec);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    byte[] arrayOfByte5 = null;
    try
    {
      arrayOfByte5 = MD5Hash(arrayOfByte4, 16, arrayOfByte4.length - 16);
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    for (int i = 0; i < arrayOfByte5.length; i++) {
      if (arrayOfByte5[i] != arrayOfByte4[i]) {
        throw new Exception("MD5校验错误。");
      }
    }
    return new String(arrayOfByte4, 16, arrayOfByte4.length - 16, "utf-8");
  }
  
  public static byte[] TripleDES_CBC_Encrypt(byte[] paramArrayOfByte, SecretKeySpec paramSecretKeySpec, IvParameterSpec paramIvParameterSpec)
    throws Exception
  {
    Cipher localCipher = Cipher.getInstance("TripleDES/CBC/PKCS5Padding");
    localCipher.init(1, paramSecretKeySpec, paramIvParameterSpec);
    byte[] arrayOfByte = localCipher.doFinal(paramArrayOfByte, 0, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public static byte[] TripleDES_CBC_Decrypt(byte[] paramArrayOfByte, SecretKeySpec paramSecretKeySpec, IvParameterSpec paramIvParameterSpec)
    throws Exception
  {
    Cipher localCipher = Cipher.getInstance("TripleDES/CBC/PKCS5Padding");
    localCipher.init(2, paramSecretKeySpec, paramIvParameterSpec);
    byte[] arrayOfByte = localCipher.doFinal(paramArrayOfByte, 0, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public static byte[] DES_CBC_Encrypt(byte[] paramArrayOfByte, SecretKeySpec paramSecretKeySpec, IvParameterSpec paramIvParameterSpec)
    throws Exception
  {
    Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    localCipher.init(1, paramSecretKeySpec, paramIvParameterSpec);
    byte[] arrayOfByte = localCipher.doFinal(paramArrayOfByte, 0, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public static byte[] DES_CBC_Decrypt(byte[] paramArrayOfByte, SecretKeySpec paramSecretKeySpec, IvParameterSpec paramIvParameterSpec)
    throws Exception
  {
    Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    localCipher.init(2, paramSecretKeySpec, paramIvParameterSpec);
    byte[] arrayOfByte = localCipher.doFinal(paramArrayOfByte, 0, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public static byte[] MD5Hash(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws Exception
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
    localMessageDigest.update(paramArrayOfByte, paramInt1, paramInt2);
    return localMessageDigest.digest();
  }
  
  public static String byte2hex(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuffer.append("0" + str);
      } else {
        localStringBuffer.append(str);
      }
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] addMD5(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = paramArrayOfByte2.length + paramArrayOfByte1.length;
    byte[] arrayOfByte = new byte[i];
    for (int j = 0; j < i; j++) {
      if (j < paramArrayOfByte1.length) {
        arrayOfByte[j] = paramArrayOfByte1[j];
      } else {
        arrayOfByte[j] = paramArrayOfByte2[(j - paramArrayOfByte1.length)];
      }
    }
    return arrayOfByte;
  }
  
  public static void getKeyIV(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    BASE64Decoder localBASE64Decoder = new BASE64Decoder();
    byte[] arrayOfByte = null;
    try
    {
      arrayOfByte = localBASE64Decoder.decodeBuffer(paramString);
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    for (int i = 0; i < paramArrayOfByte1.length; i++) {
      paramArrayOfByte1[i] = arrayOfByte[i];
    }
    for (i = 0; i < paramArrayOfByte2.length; i++) {
      paramArrayOfByte2[i] = arrayOfByte[(i + 8)];
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    String str1 = "depponfsscftp!@#";
    System.out.println("加密前:" + str1);
    String str2 = encrypt(str1);
    System.out.println("加密后:" + str2);
    try
    {
      String str3 = decrypt(str2);
      System.out.println("对加密结果解密:" + str3);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    str2 = str2.replace("4", "3");
    try
    {
      decrypt(str2);
    }
    catch (Exception localException2)
    {
      System.out.println("如果密文存在问题,则有异常:" + localException2.getMessage());
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.syscommon.InfoMapEncrypt
 * JD-Core Version:    0.7.0.1
 */