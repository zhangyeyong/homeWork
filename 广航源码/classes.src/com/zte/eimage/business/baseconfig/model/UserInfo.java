package com.zte.eimage.business.baseconfig.model;

import java.io.Serializable;

public class UserInfo
  implements Serializable
{
  private int LoginResult;
  private String ticket;
  private CompanyInfo[] companyInfos;
  private OperationTypeInfo[] operationTypeInfos;
  private Integer passErrorCount;
  private Integer passUnLockTime;
  private Integer maxPassErrorCount;
  
  public Integer getMaxPassErrorCount()
  {
    return this.maxPassErrorCount;
  }
  
  public void setMaxPassErrorCount(Integer paramInteger)
  {
    this.maxPassErrorCount = paramInteger;
  }
  
  public Integer getPassErrorCount()
  {
    return this.passErrorCount;
  }
  
  public void setPassErrorCount(Integer paramInteger)
  {
    this.passErrorCount = paramInteger;
  }
  
  public Integer getPassUnLockTime()
  {
    return this.passUnLockTime;
  }
  
  public void setPassUnLockTime(Integer paramInteger)
  {
    this.passUnLockTime = paramInteger;
  }
  
  public UserInfo() {}
  
  public UserInfo(int paramInt, String paramString)
  {
    this.LoginResult = paramInt;
    this.ticket = paramString;
  }
  
  public int getLoginResult()
  {
    return this.LoginResult;
  }
  
  public void setLoginResult(int paramInt)
  {
    this.LoginResult = paramInt;
  }
  
  public String getTicket()
  {
    return this.ticket;
  }
  
  public void setTicket(String paramString)
  {
    this.ticket = paramString;
  }
  
  public CompanyInfo[] getCompanyInfos()
  {
    return this.companyInfos;
  }
  
  public void setCompanyInfos(CompanyInfo[] paramArrayOfCompanyInfo)
  {
    this.companyInfos = paramArrayOfCompanyInfo;
  }
  
  public OperationTypeInfo[] getOperationTypeInfos()
  {
    return this.operationTypeInfos;
  }
  
  public void setOperationTypeInfos(OperationTypeInfo[] paramArrayOfOperationTypeInfo)
  {
    this.operationTypeInfos = paramArrayOfOperationTypeInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.UserInfo
 * JD-Core Version:    0.7.0.1
 */