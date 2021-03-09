package com.zte.eas.getData.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Encrypt
{
  private static final ThreadLocal<Md5Encrypt> local = new ThreadLocal();
  
  public static Md5Encrypt getEncrypt()
  {
    Md5Encrypt localMd5Encrypt = (Md5Encrypt)local.get();
    if (localMd5Encrypt == null)
    {
      localMd5Encrypt = new Md5Encrypt();
      local.set(localMd5Encrypt);
    }
    return localMd5Encrypt;
  }
  
  public String encode(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return DigestUtils.md5Hex(paramString);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.util.Md5Encrypt
 * JD-Core Version:    0.7.0.1
 */