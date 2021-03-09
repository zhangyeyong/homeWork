package com.zte.ssb;

import java.io.InputStream;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Util
{
  public static final String USER_PASSWORD = "USER_PASSWORD";
  public static final String NO_USER_PASSWORD = "NO_USER_PASSWORD";
  public static final String COMMON_LOGIN = "COMMON_LOGIN";
  public static final String EAS_LOGIN = "EAS_LOGIN";
  public static final String EAS_COMMON_LOGIN = "EAS_COMMON_LOGIN";
  
  public static String getToolModel()
  {
    String str1 = null;
    Document localDocument = readXMLFile();
    if (localDocument != null)
    {
      String str2 = localDocument.asXML();
      List localList = localDocument.selectNodes("//run/model");
      if ((localList != null) && (localList.size() > 0))
      {
        Element localElement = (Element)localList.get(0);
        str1 = localElement.getText();
      }
    }
    if ((str1 == null) || (str1.trim().equals(""))) {
      str1 = "USER_PASSWORD";
    }
    return str1;
  }
  
  private static InputStream getStream(String paramString)
  {
    InputStream localInputStream = Util.class.getClassLoader().getResourceAsStream(paramString);
    if (localInputStream == null)
    {
      Util.class.getClassLoader();
      localInputStream = ClassLoader.getSystemResourceAsStream(paramString);
    }
    return localInputStream;
  }
  
  private static Document readXMLFile()
  {
    SAXReader localSAXReader = new SAXReader();
    Document localDocument = null;
    try
    {
      localDocument = localSAXReader.read(getStream("run.xml"));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localDocument;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    getLoginType();
  }
  
  public static String getLoginType()
  {
    String str1 = null;
    Document localDocument = readXMLFile();
    if (localDocument != null)
    {
      String str2 = localDocument.asXML();
      List localList = localDocument.selectNodes("//run/login");
      if ((localList != null) && (localList.size() > 0))
      {
        Element localElement = (Element)localList.get(0);
        str1 = localElement.getText();
      }
    }
    if ((str1 == null) || (str1.trim().equals(""))) {
      str1 = "EAS_LOGIN";
    }
    return str1;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.ssb.Util
 * JD-Core Version:    0.7.0.1
 */