package com.zte.esb.trans;

import com.zte.esb.bean.ObjectFactory;
import com.zte.esb.bean.SendRoleInfoResponse;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SendRoleInfoResponseTrans
{
  private static Log log = LogFactory.getLog(SendRoleInfoResponse.class);
  private static final Class<SendRoleInfoResponse> clzz = SendRoleInfoResponse.class;
  private static JAXBContext context = initContext();
  
  public static SendRoleInfoResponse toMessage(String paramString)
    throws Exception
  {
    try
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramString.getBytes("UTF-8"));
      Unmarshaller localUnmarshaller = context.createUnmarshaller();
      JAXBElement localJAXBElement = localUnmarshaller.unmarshal(new StreamSource(localByteArrayInputStream), clzz);
      return (SendRoleInfoResponse)localJAXBElement.getValue();
    }
    catch (JAXBException localJAXBException)
    {
      throw new Exception("反序列化" + clzz.getName() + "时失败！", localJAXBException);
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
    localStringBuffer.append("<SendRoleInfoRequest xmlns=\"http://www.deppon.com/uums/inteface/domain/usermanagement\">");
    localStringBuffer.append("    <roleInfo>");
    localStringBuffer.append("        <roleId>2670</roleId>");
    localStringBuffer.append("        <roleName>下雨角色03</roleName>");
    localStringBuffer.append("        <roleBasCode>EIS0008</roleBasCode>");
    localStringBuffer.append("        <roleEnCode>dsfdg</roleEnCode>");
    localStringBuffer.append("        <changeType>1</changeType>");
    localStringBuffer.append("        <changeDate>2013-06-07T11:48:51.340+08:00</changeDate>");
    localStringBuffer.append("    </roleInfo>");
    localStringBuffer.append("</SendRoleInfoRequest>");
  }
  
  public static String fromMessage(SendRoleInfoResponse paramSendRoleInfoResponse)
    throws Exception
  {
    if (paramSendRoleInfoResponse == null) {
      return null;
    }
    try
    {
      StringWriter localStringWriter = new StringWriter();
      Marshaller localMarshaller = context.createMarshaller();
      localMarshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
      localMarshaller.setProperty("jaxb.encoding", "UTF-8");
      JAXBElement localJAXBElement = new ObjectFactory().createSendRoleInfoResponse(paramSendRoleInfoResponse);
      localMarshaller.marshal(localJAXBElement, localStringWriter);
      localStringWriter.flush();
      return localStringWriter.toString();
    }
    catch (PropertyException localPropertyException)
    {
      throw new Exception("序列化" + paramSendRoleInfoResponse.getClass().getName() + "时失败！", localPropertyException);
    }
    catch (FactoryConfigurationError localFactoryConfigurationError)
    {
      throw new Exception("序列化" + paramSendRoleInfoResponse.getClass().getName() + "时失败！", localFactoryConfigurationError);
    }
    catch (JAXBException localJAXBException)
    {
      throw new Exception("序列化" + paramSendRoleInfoResponse.getClass().getName() + "时失败！", localJAXBException);
    }
  }
  
  private static JAXBContext initContext()
  {
    JAXBContext localJAXBContext = null;
    try
    {
      localJAXBContext = JAXBContext.newInstance(new Class[] { clzz });
    }
    catch (JAXBException localJAXBException)
    {
      log.error(localJAXBException.getMessage(), localJAXBException);
    }
    return localJAXBContext;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.trans.SendRoleInfoResponseTrans
 * JD-Core Version:    0.7.0.1
 */