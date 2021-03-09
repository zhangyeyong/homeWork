package com.zte.esb.util;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import javax.jms.JMSException;
import javax.jms.Message;

public class HeaderUtil
{
  public static final String VERSION = "version";
  public static final String BUSINESSID = "businessId";
  public static final String BUSINESS_DESC1 = "businessDesc1";
  public static final String BUSINESS_DESC2 = "businessDesc2";
  public static final String BUSINESS_DESC3 = "businessDesc3";
  public static final String REQUEST_ID = "requestId";
  public static final String RESPONSE_ID = "responseId";
  public static final String ESB_SERVICE_CODE = "esbServiceCode";
  public static final String BACK_SERVICE_CODE = "backServiceCode";
  public static final String MESSAGE_FORMAT = "messageFormat";
  public static final String SOURCESYSTEM = "sourceSystem";
  public static final String TARGETSYSTEM = "targetSystem";
  public static final String EXCHANGEPATTERN = "exchangePattern";
  public static final String SENT_SEQUENCE = "sentSequence";
  public static final String RESULT_CODE = "resultCode";
  public static final String AUTHENTICATION = "authentication";
  public static final String USERNAME = "userName";
  public static final String PASSWORD = "password";
  public static final String STATUSLIST = "statusList";
  
  public static void buildRequestJMSProperties(Message paramMessage, String paramString1, String paramString2, String paramString3, int paramInt)
    throws JMSException
  {}
  
  public static void buildRequestJMSProperties(Message paramMessage, MsgHeader paramMsgHeader)
    throws JMSException
  {
    if ((paramMessage == null) || (paramMsgHeader == null)) {
      return;
    }
    if (paramMsgHeader.getVersion() != null) {
      paramMessage.setStringProperty("version", paramMsgHeader.getVersion());
    }
    if (paramMsgHeader.getBusinessId() != null) {
      paramMessage.setStringProperty("businessId", paramMsgHeader.getBusinessId());
    }
    if (paramMsgHeader.getRequestId() != null) {
      paramMessage.setStringProperty("requestId", paramMsgHeader.getRequestId());
    }
    if (paramMsgHeader.getResponseId() != null) {
      paramMessage.setStringProperty("responseId", paramMsgHeader.getResponseId());
    }
    if (paramMsgHeader.getSourceSystem() != null) {
      paramMessage.setStringProperty("sourceSystem", paramMsgHeader.getSourceSystem());
    }
    if (paramMsgHeader.getTargetSystem() != null) {
      paramMessage.setStringProperty("targetSystem", paramMsgHeader.getTargetSystem());
    }
    if (paramMsgHeader.getEsbServiceCode() != null) {
      paramMessage.setStringProperty("esbServiceCode", paramMsgHeader.getEsbServiceCode());
    }
    if (paramMsgHeader.getBackServiceCode() != null) {
      paramMessage.setStringProperty("backServiceCode", paramMsgHeader.getBackServiceCode());
    }
    if (paramMsgHeader.getMessageFormat() != null) {
      paramMessage.setStringProperty("messageFormat", paramMsgHeader.getMessageFormat());
    }
    if (paramMsgHeader.getExchangePattern() > -1) {
      paramMessage.setIntProperty("exchangePattern", paramMsgHeader.getExchangePattern());
    }
    if (paramMsgHeader.getSentSequence() != null) {
      paramMessage.setStringProperty("sentSequence", paramMsgHeader.getSentSequence());
    }
    if (paramMsgHeader.getResultCode() > -1) {
      paramMessage.setIntProperty("resultCode", paramMsgHeader.getResultCode());
    }
    if (paramMsgHeader.getUserName() != null) {
      paramMessage.setObjectProperty("userName", paramMsgHeader.getUserName());
    }
    if (paramMsgHeader.getPassword() != null) {
      paramMessage.setObjectProperty("password", paramMsgHeader.getPassword());
    }
  }
  
  public static MsgHeader getMsgHeaderInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    MsgHeader localMsgHeader = new MsgHeader();
    localMsgHeader.setVersion(paramString1);
    localMsgHeader.setEsbServiceCode(paramString2);
    localMsgHeader.setExchangePattern(paramInt);
    localMsgHeader.setMessageFormat(paramString3);
    localMsgHeader.setBusinessId(paramString4);
    localMsgHeader.setRequestId(UUID.randomUUID().toString());
    localMsgHeader.setSourceSystem("EIS");
    return localMsgHeader;
  }
  
  public static void buildResponseJMSProperties(Message paramMessage, String paramString)
    throws JMSException
  {
    if ((paramString == null) || ("".equals(paramString))) {
      paramString = UUID.randomUUID().toString();
    }
    paramMessage.setStringProperty("responseId", paramString);
  }
  
  public static String getStatusInfo(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt);
    localStringBuffer.append(new Date().getTime());
    return localStringBuffer.toString();
  }
  
  public static void buildResponseHeader(Message paramMessage, String paramString, int paramInt)
    throws JMSException
  {
    if ((paramString == null) || ("".equals(paramString))) {
      paramString = UUID.randomUUID().toString();
    }
    paramMessage.setStringProperty("responseId", paramString);
    paramMessage.setIntProperty("resultCode", paramInt);
    paramMessage.setStringProperty("ST_308", new Date().getTime() + "");
  }
  
  public static Map<String, Object> headerConverToMap(Message paramMessage)
    throws JMSException
  {
    HashMap localHashMap = new HashMap();
    Enumeration localEnumeration = paramMessage.getPropertyNames();
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      localHashMap.put(str, paramMessage.getObjectProperty(str));
    }
    return localHashMap;
  }
  
  public static void buildResponseJMSProperties(Message paramMessage, Map<String, Object> paramMap, String paramString, int paramInt)
    throws JMSException
  {
    mapConverToHeader(paramMessage, paramMap);
    if ((paramString == null) || ("".equals(paramString))) {
      paramString = UUID.randomUUID().toString();
    }
    paramMessage.setStringProperty("responseId", paramString);
    paramMessage.setIntProperty("resultCode", paramInt);
  }
  
  public static void mapConverToHeader(Message paramMessage, Map<String, Object> paramMap)
    throws JMSException
  {
    Set localSet = paramMap.entrySet();
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMessage.setObjectProperty((String)localEntry.getKey(), localEntry.getValue());
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.HeaderUtil
 * JD-Core Version:    0.7.0.1
 */