package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;

public class EvsFtp
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Long ftpId;
  private String ftpName;
  private String ftpAddress;
  private String webAddress;
  private String ftpUserName;
  private String ftpPwd;
  private String rootList;
  private Long ftpPort;
  private String loaclPath;
  
  public Long getFtpId()
  {
    return this.ftpId;
  }
  
  public void setFtpId(Long paramLong)
  {
    this.ftpId = paramLong;
  }
  
  public String getFtpName()
  {
    return this.ftpName;
  }
  
  public void setFtpName(String paramString)
  {
    this.ftpName = paramString;
  }
  
  public String getFtpAddress()
  {
    return this.ftpAddress;
  }
  
  public void setFtpAddress(String paramString)
  {
    this.ftpAddress = paramString;
  }
  
  public String getWebAddress()
  {
    return this.webAddress;
  }
  
  public void setWebAddress(String paramString)
  {
    this.webAddress = paramString;
  }
  
  public String getFtpUserName()
  {
    return this.ftpUserName;
  }
  
  public void setFtpUserName(String paramString)
  {
    this.ftpUserName = paramString;
  }
  
  public String getFtpPwd()
  {
    return this.ftpPwd;
  }
  
  public void setFtpPwd(String paramString)
  {
    this.ftpPwd = paramString;
  }
  
  public String getRootList()
  {
    return this.rootList;
  }
  
  public void setRootList(String paramString)
  {
    this.rootList = paramString;
  }
  
  public Long getFtpPort()
  {
    return this.ftpPort;
  }
  
  public void setFtpPort(Long paramLong)
  {
    this.ftpPort = paramLong;
  }
  
  public String getLoaclPath()
  {
    return this.loaclPath;
  }
  
  public void setLoaclPath(String paramString)
  {
    this.loaclPath = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsFtp
 * JD-Core Version:    0.7.0.1
 */