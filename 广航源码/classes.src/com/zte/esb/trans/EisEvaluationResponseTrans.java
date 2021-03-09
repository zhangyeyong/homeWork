package com.zte.esb.trans;

import com.zte.esb.bean.fssc.EisEvaluationResponse;
import com.zte.esb.bean.fssc.ObjectFactory;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
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

public class EisEvaluationResponseTrans
{
  private static Log log = LogFactory.getLog(EisEvaluationResponse.class);
  private static final Class<EisEvaluationResponse> clzz = EisEvaluationResponse.class;
  private static JAXBContext context = initContext();
  
  public static EisEvaluationResponse toMessage(String paramString)
    throws Exception
  {
    try
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramString.getBytes("UTF-8"));
      Unmarshaller localUnmarshaller = context.createUnmarshaller();
      JAXBElement localJAXBElement = localUnmarshaller.unmarshal(new StreamSource(localByteArrayInputStream), clzz);
      return (EisEvaluationResponse)localJAXBElement.getValue();
    }
    catch (JAXBException localJAXBException)
    {
      throw new Exception("反序列化" + clzz.getName() + "时失败！", localJAXBException);
    }
  }
  
  public static String fromMessage(EisEvaluationResponse paramEisEvaluationResponse)
    throws Exception
  {
    if (paramEisEvaluationResponse == null) {
      return null;
    }
    try
    {
      StringWriter localStringWriter = new StringWriter();
      Marshaller localMarshaller = context.createMarshaller();
      localMarshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
      localMarshaller.setProperty("jaxb.encoding", "UTF-8");
      JAXBElement localJAXBElement = new ObjectFactory().createEisEvaluationResponse(paramEisEvaluationResponse);
      localMarshaller.marshal(localJAXBElement, localStringWriter);
      localStringWriter.flush();
      return localStringWriter.toString();
    }
    catch (PropertyException localPropertyException)
    {
      throw new Exception("序列化" + paramEisEvaluationResponse.getClass().getName() + "时失败！", localPropertyException);
    }
    catch (FactoryConfigurationError localFactoryConfigurationError)
    {
      throw new Exception("序列化" + paramEisEvaluationResponse.getClass().getName() + "时失败！", localFactoryConfigurationError);
    }
    catch (JAXBException localJAXBException)
    {
      throw new Exception("序列化" + paramEisEvaluationResponse.getClass().getName() + "时失败！", localJAXBException);
    }
  }
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    EisEvaluationResponse localEisEvaluationResponse = new EisEvaluationResponse();
    localEisEvaluationResponse.setClaimBillNumber("FSSC104130607000014");
    localEisEvaluationResponse.setEvaluationType("WORKFLOW_REJECT");
    localEisEvaluationResponse.setFailtureReason("影像不存在!");
    localEisEvaluationResponse.setSuccessMark(Boolean.valueOf(false));
    System.out.println(CommonRequestTrans.fromMessage(localEisEvaluationResponse));
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
 * Qualified Name:     com.zte.esb.trans.EisEvaluationResponseTrans
 * JD-Core Version:    0.7.0.1
 */