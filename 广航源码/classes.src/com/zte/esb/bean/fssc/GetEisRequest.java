package com.zte.esb.bean.fssc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="getEisRequest", propOrder={"eisFileNo", "eisTaskNo", "eisStatus", "eisFileAccount", "lastModifyPerson", "eisUrl"})
@XmlRootElement
public class GetEisRequest
{
  @XmlElement(name="EISFileNo", required=true)
  protected String eisFileNo;
  @XmlElement(name="EISTaskNo", required=true)
  protected String eisTaskNo;
  @XmlElement(name="EISStatus", required=true)
  protected String eisStatus;
  @XmlElement(name="EISFileAccount", required=true)
  protected String eisFileAccount;
  @XmlElement(required=true)
  protected String lastModifyPerson;
  @XmlElement(name="EISUrl", required=true)
  protected String eisUrl;
  
  public String getEISFileNo()
  {
    return this.eisFileNo;
  }
  
  public void setEISFileNo(String paramString)
  {
    this.eisFileNo = paramString;
  }
  
  public String getEISTaskNo()
  {
    return this.eisTaskNo;
  }
  
  public void setEISTaskNo(String paramString)
  {
    this.eisTaskNo = paramString;
  }
  
  public String getEISStatus()
  {
    return this.eisStatus;
  }
  
  public void setEISStatus(String paramString)
  {
    this.eisStatus = paramString;
  }
  
  public String getEISFileAccount()
  {
    return this.eisFileAccount;
  }
  
  public void setEISFileAccount(String paramString)
  {
    this.eisFileAccount = paramString;
  }
  
  public String getLastModifyPerson()
  {
    return this.lastModifyPerson;
  }
  
  public void setLastModifyPerson(String paramString)
  {
    this.lastModifyPerson = paramString;
  }
  
  public String getEISUrl()
  {
    return this.eisUrl;
  }
  
  public void setEISUrl(String paramString)
  {
    this.eisUrl = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.fssc.GetEisRequest
 * JD-Core Version:    0.7.0.1
 */