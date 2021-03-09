package com.zte.esb.trans;

import com.zte.esb.bean.ObjectFactory;
import com.zte.esb.bean.SendDegreeRequest;
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

public class SendDegreeRequestTrans
{
  private static Log log = LogFactory.getLog(SendDegreeRequest.class);
  private static final Class<SendDegreeRequest> clzz = SendDegreeRequest.class;
  private static JAXBContext context = initContext();
  
  public static SendDegreeRequest toMessage(String paramString)
    throws Exception
  {
    try
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramString.getBytes("UTF-8"));
      Unmarshaller localUnmarshaller = context.createUnmarshaller();
      JAXBElement localJAXBElement = localUnmarshaller.unmarshal(new StreamSource(localByteArrayInputStream), clzz);
      return (SendDegreeRequest)localJAXBElement.getValue();
    }
    catch (JAXBException localJAXBException)
    {
      throw new Exception("反序列化" + clzz.getName() + "时失败！", localJAXBException);
    }
  }
  
  public static String fromMessage(SendDegreeRequest paramSendDegreeRequest)
    throws Exception
  {
    if (paramSendDegreeRequest == null) {
      return null;
    }
    try
    {
      StringWriter localStringWriter = new StringWriter();
      Marshaller localMarshaller = context.createMarshaller();
      localMarshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
      localMarshaller.setProperty("jaxb.encoding", "UTF-8");
      JAXBElement localJAXBElement = new ObjectFactory().createSendDegreeRequest(paramSendDegreeRequest);
      localMarshaller.marshal(localJAXBElement, localStringWriter);
      localStringWriter.flush();
      return localStringWriter.toString();
    }
    catch (PropertyException localPropertyException)
    {
      throw new Exception("序列化" + paramSendDegreeRequest.getClass().getName() + "时失败！", localPropertyException);
    }
    catch (FactoryConfigurationError localFactoryConfigurationError)
    {
      throw new Exception("序列化" + paramSendDegreeRequest.getClass().getName() + "时失败！", localFactoryConfigurationError);
    }
    catch (JAXBException localJAXBException)
    {
      throw new Exception("序列化" + paramSendDegreeRequest.getClass().getName() + "时失败！", localJAXBException);
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
 * Qualified Name:     com.zte.esb.trans.SendDegreeRequestTrans
 * JD-Core Version:    0.7.0.1
 */