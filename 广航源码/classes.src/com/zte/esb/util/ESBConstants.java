package com.zte.esb.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ESBConstants
{
  public static final String SOURCE_SYSTEM = "EIS";
  public static final int SUCCESS = 1;
  public static final int FAILURE = 0;
  public static final String RESULT_CODE = "resultCode";
  public static final int EXP_ONE_WAY = 3;
  public static final int EXP_REQUEST_REPLY = 1;
  public static final int EXP_REQUEST_CALLBACK = 2;
  public static final String MSG_SOAP = "SOAP";
  public static final String MSG_JSON = "JSON";
  public static final String MSG_XML = "XML";
  public static final String NO_CONSUMER_SENT = "ST_108";
  public static final String PROVIDER_RECEIVED = "ST_302";
  public static final String EIS_ESB2EIS_SEND_USERINFO_EIS = "EIS_ESB2EIS_SEND_USERINFO_EIS";
  public static final String EIS_ESB2EIS_SEND_EMPLOYEE_EIS = "EIS_ESB2EIS_SEND_EMPLOYEE_EIS";
  public static final String EIS_ESB2EIS_SEND_ADMINORG_EIS = "EIS_ESB2EIS_SEND_ADMINORG_EIS";
  public static final String EIS_ESB2EIS_SEND_POSITION_EIS = "EIS_ESB2EIS_SEND_POSITION_EIS";
  public static final String EIS_ESB2EIS_SEND_DEGREE_EIS = "EIS_ESB2EIS_SEND_DEGREE_EIS";
  public static final String EIS_ESB2EIS_SEND_ROLEINFO_EIS = "EIS_ESB2EIS_SEND_ROLEINFO_EIS";
  public static final String EIS_ESB2EIS_SYNC_DISTRICT = "EIS_ESB2EIS_SYNC_DISTRICT";
  public static final String EIS_ESB2EIS_EVALUATION = "EIS_ESB2EIS_EVALUATION";
  public static final String ESB_EIS2ESB_SPECIAL_ATTACHMENT = "ESB_EIS2ESB_SPECIAL_ATTACHMENT";
  public static final String ESB_EIS2ESB_CREATE_IMAGES = "ESB_EIS2ESB_CREATE_IMAGES";
  public static final String PROVIDER_PROCESSED = "ST_305";
  public static final String PROVIDER_RESPONSED = "ST_308";
  public static final String CONSUMER_RECEIVED = "ST_502";
  public static final String CONSUMER_SENT = "ST_505";
  public static final String COMPLETE = "ST_999";
  public static final String VERSION = "1.0";
  
  public static String getEsbServiceCode(String paramString)
    throws IOException
  {
    Properties localProperties = new Properties();
    InputStream localInputStream = null;
    localInputStream = ESBConstants.class.getClassLoader().getResourceAsStream("esb.properties");
    localProperties.load(localInputStream);
    return localProperties.getProperty(paramString);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.ESBConstants
 * JD-Core Version:    0.7.0.1
 */