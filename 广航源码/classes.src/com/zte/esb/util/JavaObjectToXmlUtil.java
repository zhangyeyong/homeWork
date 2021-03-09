package com.zte.esb.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class JavaObjectToXmlUtil
{
  private static String charset = "UTF-8";
  
  public static String javaObjectToXmlStr(String paramString, Object paramObject)
  {
    String str = null;
    if ((paramString == null) || ("".equals(paramString))) {
      return str;
    }
    if ((paramObject == null) || ("".equals(paramObject))) {
      return str;
    }
    Class localClass = null;
    JAXBContext localJAXBContext = null;
    ByteArrayOutputStream localByteArrayOutputStream = null;
    try
    {
      localClass = Class.forName(paramString);
      localJAXBContext = JAXBContext.newInstance(new Class[] { localClass });
      localByteArrayOutputStream = new ByteArrayOutputStream();
      Marshaller localMarshaller = localJAXBContext.createMarshaller();
      localMarshaller.setProperty("jaxb.encoding", charset);
      localMarshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
      localMarshaller.setProperty("jaxb.fragment", Boolean.valueOf(false));
      localMarshaller.marshal(paramObject, localByteArrayOutputStream);
      if (localByteArrayOutputStream != null) {
        try
        {
          localByteArrayOutputStream.flush();
          str = localByteArrayOutputStream.toString() == null ? "" : new String(localByteArrayOutputStream.toString().getBytes(), charset);
          localByteArrayOutputStream.close();
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
        }
      }
      if (str != null) {
        return str;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
    catch (JAXBException localJAXBException)
    {
      localJAXBException.printStackTrace();
    }
    finally
    {
      if (localByteArrayOutputStream != null) {
        try
        {
          localByteArrayOutputStream.flush();
          str = localByteArrayOutputStream.toString() == null ? "" : new String(localByteArrayOutputStream.toString().getBytes(), charset);
          localByteArrayOutputStream.close();
        }
        catch (IOException localIOException4)
        {
          localIOException4.printStackTrace();
        }
      }
    }
    tmpTernaryOp = "";
    return str;
  }
  
  public static Object xmlToJavaObject(String paramString1, String paramString2)
  {
    Object localObject = null;
    if ((paramString2 == null) || ("".equals(paramString2))) {
      return localObject;
    }
    if ((paramString1 == null) || ("".equals(paramString1))) {
      return localObject;
    }
    JAXBContext localJAXBContext = null;
    Class localClass = null;
    StringReader localStringReader = null;
    try
    {
      localClass = Class.forName(paramString2);
      localStringReader = new StringReader(paramString1);
      localJAXBContext = JAXBContext.newInstance(new Class[] { localClass });
      Unmarshaller localUnmarshaller = localJAXBContext.createUnmarshaller();
      localObject = localUnmarshaller.unmarshal(localStringReader);
    }
    catch (JAXBException localJAXBException)
    {
      localJAXBException.printStackTrace();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
    return localObject;
  }
  
  public static XMLGregorianCalendar convertToXMLGregorianCalendar(Date paramDate)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.setTime(paramDate);
    XMLGregorianCalendar localXMLGregorianCalendar = null;
    try
    {
      localXMLGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(localGregorianCalendar);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localXMLGregorianCalendar;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.JavaObjectToXmlUtil
 * JD-Core Version:    0.7.0.1
 */