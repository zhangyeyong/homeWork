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
@XmlType(name="DegreeInfo", propOrder={"id", "degreeChangeId", "degreeCode", "degreeName", "lastModifyTime", "status"})
public class DegreeInfo
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected String id;
  @XmlElement(required=true)
  protected String degreeChangeId;
  @XmlElement(required=true)
  protected String degreeCode;
  @XmlElement(required=true)
  protected String degreeName;
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
  
  public String getDegreeChangeId()
  {
    return this.degreeChangeId;
  }
  
  public void setDegreeChangeId(String paramString)
  {
    this.degreeChangeId = paramString;
  }
  
  public String getDegreeCode()
  {
    return this.degreeCode;
  }
  
  public void setDegreeCode(String paramString)
  {
    this.degreeCode = paramString;
  }
  
  public String getDegreeName()
  {
    return this.degreeName;
  }
  
  public void setDegreeName(String paramString)
  {
    this.degreeName = paramString;
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
 * Qualified Name:     com.zte.esb.bean.DegreeInfo
 * JD-Core Version:    0.7.0.1
 */