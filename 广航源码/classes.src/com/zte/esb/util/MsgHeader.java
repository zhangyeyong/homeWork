package com.zte.esb.util;

import com.zte.esb.util.header.AuthInfo;
import com.zte.esb.util.header.StatusList;

public class MsgHeader
{
  private String version;
  private String businessId;
  private String businessDesc1;
  private String businessDesc2;
  private String businessDesc3;
  private String requestId;
  private String responseId;
  private String sourceSystem;
  private String targetSystem;
  private String esbServiceCode;
  private String backServiceCode;
  private String messageFormat;
  private int exchangePattern = -1;
  private String sentSequence;
  private int resultCode = -1;
  private AuthInfo authentication;
  private String userName;
  private String password;
  private StatusList statusList;
  
  public String getVersion()
  {
    return this.version;
  }
  
  public String getBusinessId()
  {
    return this.businessId;
  }
  
  public String getBusinessDesc1()
  {
    return this.businessDesc1;
  }
  
  public String getBusinessDesc2()
  {
    return this.businessDesc2;
  }
  
  public String getBusinessDesc3()
  {
    return this.businessDesc3;
  }
  
  public String getRequestId()
  {
    return this.requestId;
  }
  
  public String getResponseId()
  {
    return this.responseId;
  }
  
  public String getSourceSystem()
  {
    return this.sourceSystem;
  }
  
  public String getTargetSystem()
  {
    return this.targetSystem;
  }
  
  public String getEsbServiceCode()
  {
    return this.esbServiceCode;
  }
  
  public String getBackServiceCode()
  {
    return this.backServiceCode;
  }
  
  public String getMessageFormat()
  {
    return this.messageFormat;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public void setBusinessId(String paramString)
  {
    this.businessId = paramString;
  }
  
  public void setBusinessDesc1(String paramString)
  {
    this.businessDesc1 = paramString;
  }
  
  public void setBusinessDesc2(String paramString)
  {
    this.businessDesc2 = paramString;
  }
  
  public void setBusinessDesc3(String paramString)
  {
    this.businessDesc3 = paramString;
  }
  
  public void setRequestId(String paramString)
  {
    this.requestId = paramString;
  }
  
  public void setResponseId(String paramString)
  {
    this.responseId = paramString;
  }
  
  public void setSourceSystem(String paramString)
  {
    this.sourceSystem = paramString;
  }
  
  public void setTargetSystem(String paramString)
  {
    this.targetSystem = paramString;
  }
  
  public void setEsbServiceCode(String paramString)
  {
    this.esbServiceCode = paramString;
  }
  
  public void setBackServiceCode(String paramString)
  {
    this.backServiceCode = paramString;
  }
  
  public void setMessageFormat(String paramString)
  {
    this.messageFormat = paramString;
  }
  
  public void setSentSequence(String paramString)
  {
    this.sentSequence = paramString;
  }
  
  public int getExchangePattern()
  {
    return this.exchangePattern;
  }
  
  public String getSentSequence()
  {
    return this.sentSequence;
  }
  
  public int getResultCode()
  {
    return this.resultCode;
  }
  
  public AuthInfo getAuthentication()
  {
    return this.authentication;
  }
  
  public void setExchangePattern(int paramInt)
  {
    this.exchangePattern = paramInt;
  }
  
  public void setResultCode(int paramInt)
  {
    this.resultCode = paramInt;
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
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public String toString()
  {
    return "MsgHeader [version=" + this.version + ", businessId=" + this.businessId + ", businessDesc1=" + this.businessDesc1 + ", businessDesc2=" + this.businessDesc2 + ", businessDesc3=" + this.businessDesc3 + ", requestId=" + this.requestId + ", responseId=" + this.responseId + ", sourceSystem=" + this.sourceSystem + ", targetSystem=" + this.targetSystem + ", esbServiceCode=" + this.esbServiceCode + ", backServiceCode=" + this.backServiceCode + ", messageFormat=" + this.messageFormat + ", exchangePattern=" + this.exchangePattern + ", sentSequence=" + this.sentSequence + ", resultCode=" + this.resultCode + ", authentication=" + this.authentication + ", userName=" + this.userName + ", password=" + this.password + ", statusList=" + this.statusList + "]";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.MsgHeader
 * JD-Core Version:    0.7.0.1
 */