package com.zte.esb.bean;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="PositionInfo", propOrder={"id", "positionChangeId", "positionCode", "positionName", "lastModifyTime", "status"})
public class PositionInfo
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected String id;
  @XmlElement(required=true)
  protected String positionChangeId;
  @XmlElement(required=true)
  protected String positionCode;
  @XmlElement(required=true)
  protected String positionName;
  @XmlElement(required=true, type=String.class)
  @XmlJavaTypeAdapter(Adapter1.class)
  @XmlSchemaType(name="dateTime")
  protected Date lastModifyTime;
  @XmlElement(required=true)
  protected String status;
  
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public String getPositionChangeId()
  {
    return this.positionChangeId;
  }
  
  public void setPositionChangeId(String paramString)
  {
    this.positionChangeId = paramString;
  }
  
  public String getPositionCode()
  {
    return this.positionCode;
  }
  
  public void setPositionCode(String paramString)
  {
    this.positionCode = paramString;
  }
  
  public String getPositionName()
  {
    return this.positionName;
  }
  
  public void setPositionName(String paramString)
  {
    this.positionName = paramString;
  }
  
  public Date getLastModifyTime()
  {
    return this.lastModifyTime;
  }
  
  public void setLastModifyTime(Date paramDate)
  {
    this.lastModifyTime = paramDate;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.PositionInfo
 * JD-Core Version:    0.7.0.1
 */