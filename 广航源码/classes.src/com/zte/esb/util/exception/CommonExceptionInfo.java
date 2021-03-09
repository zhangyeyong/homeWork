package com.zte.esb.util.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="CommonExceptionInfo", propOrder={"exceptioncode", "exceptiontype", "message", "createdTime", "detailedInfo"})
@XmlRootElement(name="CommonExceptionInfo")
public class CommonExceptionInfo
{
  @XmlElement(required=true)
  protected String exceptioncode;
  @XmlElement(required=true)
  protected String exceptiontype;
  @XmlElement(required=true)
  protected String message;
  @XmlElement(required=true)
  @XmlSchemaType(name="dateTime")
  protected XMLGregorianCalendar createdTime;
  @XmlElement(required=true)
  protected String detailedInfo;
  
  public String getExceptioncode()
  {
    return this.exceptioncode;
  }
  
  public void setExceptioncode(String paramString)
  {
    this.exceptioncode = paramString;
  }
  
  public String getExceptiontype()
  {
    return this.exceptiontype;
  }
  
  public void setExceptiontype(String paramString)
  {
    this.exceptiontype = paramString;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public XMLGregorianCalendar getCreatedTime()
  {
    return this.createdTime;
  }
  
  public void setCreatedTime(XMLGregorianCalendar paramXMLGregorianCalendar)
  {
    this.createdTime = paramXMLGregorianCalendar;
  }
  
  public String getDetailedInfo()
  {
    return this.detailedInfo;
  }
  
  public void setDetailedInfo(String paramString)
  {
    this.detailedInfo = paramString;
  }
  
  public String toString()
  {
    return "CommonExceptionInfo [exceptioncode=" + this.exceptioncode + ", exceptiontype=" + this.exceptiontype + ", message=" + this.message + ", createdTime=" + this.createdTime + ", detailedInfo=" + this.detailedInfo + "]";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.exception.CommonExceptionInfo
 * JD-Core Version:    0.7.0.1
 */