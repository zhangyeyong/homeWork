package com.zte.esb.util.header;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ESBHeader", propOrder={"version", "businessId", "businessDesc1", "businessDesc2", "businessDesc3", "requestId", "responseId", "sourceSystem", "targetSystem", "esbServiceCode", "backServiceCode", "messageFormat", "exchangePattern", "sentSequence", "resultCode", "authentication", "statusList"})
public class ESBHeader
{
  @XmlElement(required=true)
  protected String version;
  @XmlElement(required=true)
  protected String businessId;
  protected String businessDesc1;
  protected String businessDesc2;
  protected String businessDesc3;
  @XmlElement(required=true)
  protected String requestId;
  protected String responseId;
  @XmlElement(required=true)
  protected String sourceSystem;
  protected String targetSystem;
  @XmlElement(required=true)
  protected String esbServiceCode;
  protected String backServiceCode;
  protected String messageFormat;
  protected Integer exchangePattern;
  protected Integer sentSequence;
  protected Integer resultCode;
  protected AuthInfo authentication;
  protected StatusList statusList;
  
  public String getVersion()
  {
    return this.version;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public String getBusinessId()
  {
    return this.businessId;
  }
  
  public void setBusinessId(String paramString)
  {
    this.businessId = paramString;
  }
  
  public String getBusinessDesc1()
  {
    return this.businessDesc1;
  }
  
  public void setBusinessDesc1(String paramString)
  {
    this.businessDesc1 = paramString;
  }
  
  public String getBusinessDesc2()
  {
    return this.businessDesc2;
  }
  
  public void setBusinessDesc2(String paramString)
  {
    this.businessDesc2 = paramString;
  }
  
  public String getBusinessDesc3()
  {
    return this.businessDesc3;
  }
  
  public void setBusinessDesc3(String paramString)
  {
    this.businessDesc3 = paramString;
  }
  
  public String getRequestId()
  {
    return this.requestId;
  }
  
  public void setRequestId(String paramString)
  {
    this.requestId = paramString;
  }
  
  public String getResponseId()
  {
    return this.responseId;
  }
  
  public void setResponseId(String paramString)
  {
    this.responseId = paramString;
  }
  
  public String getSourceSystem()
  {
    return this.sourceSystem;
  }
  
  public void setSourceSystem(String paramString)
  {
    this.sourceSystem = paramString;
  }
  
  public String getTargetSystem()
  {
    return this.targetSystem;
  }
  
  public void setTargetSystem(String paramString)
  {
    this.targetSystem = paramString;
  }
  
  public String getEsbServiceCode()
  {
    return this.esbServiceCode;
  }
  
  public void setEsbServiceCode(String paramString)
  {
    this.esbServiceCode = paramString;
  }
  
  public String getBackServiceCode()
  {
    return this.backServiceCode;
  }
  
  public void setBackServiceCode(String paramString)
  {
    this.backServiceCode = paramString;
  }
  
  public String getMessageFormat()
  {
    return this.messageFormat;
  }
  
  public void setMessageFormat(String paramString)
  {
    this.messageFormat = paramString;
  }
  
  public Integer getExchangePattern()
  {
    return this.exchangePattern;
  }
  
  public void setExchangePattern(Integer paramInteger)
  {
    this.exchangePattern = paramInteger;
  }
  
  public Integer getSentSequence()
  {
    return this.sentSequence;
  }
  
  public void setSentSequence(Integer paramInteger)
  {
    this.sentSequence = paramInteger;
  }
  
  public Integer getResultCode()
  {
    return this.resultCode;
  }
  
  public void setResultCode(Integer paramInteger)
  {
    this.resultCode = paramInteger;
  }
  
  public AuthInfo getAuthentication()
  {
    return this.authentication;
  }
  
  public void setAuthentication(AuthInfo paramAuthInfo)
  {
    this.authentication = paramAuthInfo;
  }
  
  public StatusList getStatusList()
  {
    return this.statusList;
  }
  
  public void setStatusList(StatusList paramStatusList)
  {
    this.statusList = paramStatusList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.header.ESBHeader
 * JD-Core Version:    0.7.0.1
 */