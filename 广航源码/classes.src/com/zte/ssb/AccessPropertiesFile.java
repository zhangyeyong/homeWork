package com.zte.ssb;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;

public class AccessPropertiesFile
{
  static String fileName = "connectBpel.properties";
  static HashMap hm = null;
  
  public static String getValue(String paramString)
  {
    String str1 = "";
    String str2 = "";
    if ((hm != null) && (hm.containsKey(paramString)))
    {
      str2 = (String)hm.get(paramString);
      return str2;
    }
    try
    {
      InputStream localInputStream = AccessPropertiesFile.class.getClassLoader().getResourceAsStream(fileName);
      InputStreamReader localInputStreamReader = new InputStreamReader(localInputStream);
      BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
      while ((str1 = localBufferedReader.readLine()) != null)
      {
        int i = str1.indexOf("=");
        if (i != -1)
        {
          String str3 = str1.substring(0, i).trim();
          String str4 = str1.substring(i + 1).trim();
          if (hm == null) {
            hm = new HashMap();
          }
          hm.put(str3, str4);
        }
      }
      localBufferedReader.close();
      localInputStreamReader.close();
      localInputStream.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return (String)hm.get(paramString);
  }
  
  public static String getValue(String paramString1, String paramString2)
  {
    String str1 = "";
    String str2 = "";
    if ((hm != null) && (hm.containsKey(paramString1)))
    {
      str2 = (String)hm.get(paramString1);
      return str2;
    }
    try
    {
      InputStream localInputStream = AccessPropertiesFile.class.getClassLoader().getResourceAsStream(paramString2);
      InputStreamReader localInputStreamReader = new InputStreamReader(localInputStream);
      BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
      while ((str1 = localBufferedReader.readLine()) != null)
      {
        int i = str1.indexOf("=");
        if (i != -1)
        {
          String str3 = str1.substring(0, i).trim();
          String str4 = str1.substring(i + 1).trim();
          if (hm == null) {
            hm = new HashMap();
          }
          hm.put(str3, str4);
        }
      }
      localBufferedReader.close();
      localInputStreamReader.close();
      localInputStream.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return (String)hm.get(paramString1);
  }
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    new AccessPropertiesFile();
    String str = getValue("BILL_MGT_TITLE", "gdyd_mail_infomap.properties");
    System.out.println(str);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.ssb.AccessPropertiesFile
 * JD-Core Version:    0.7.0.1
 */