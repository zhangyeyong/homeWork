package com.zte.eas.infomap.business.notice.service.client.sms;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.cxf.common.util.Base64Utility;

public class MD5Encrypt
{
  private static final String ALGORITHM = "MD5";
  
  public static String encrypt(String paramString)
  {
    MessageDigest localMessageDigest = null;
    String str = null;
    if (paramString == null) {
      return null;
    }
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      str = Base64Utility.encode(localMessageDigest.digest(paramString.getBytes("UTF-8")));
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return str;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    encrypt("hrsmstesthrsmstest");
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.client.sms.MD5Encrypt
 * JD-Core Version:    0.7.0.1
 */