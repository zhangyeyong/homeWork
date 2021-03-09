package com.zte.evs.ebill.model.archives;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpCheckPersonV
  extends BaseObject
  implements Serializable
{
  protected Long id;
  protected Date lastUpdateDate;
  protected Date creationDate;
  protected String enabledFlag;
  protected String statusName;
  protected Long employeeId;
  protected String employeeNumber;
  protected String employeeName;
  protected String journalName;
  protected String voucherTypeName;
  protected String attribute1;
  protected String companyName;
  
  public FbpCheckPersonV() {}
  
  public FbpCheckPersonV(Long paramLong1, Date paramDate1, Date paramDate2, String paramString1, String paramString2, Long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    setId(paramLong1);
    setLastUpdateDate(paramDate1);
    setCreationDate(paramDate2);
    setEnabledFlag(paramString1);
    setStatusName(paramString2);
    setEmployeeId(paramLong2);
    setEmployeeNumber(paramString3);
    setEmployeeName(paramString4);
    setVoucherTypeName(paramString6);
    setCompanyName(paramString8);
  }
  
  public Long getId()
  {
    return this.id;
  }
  
  public void setId(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.creationDate = paramDate;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public String getStatusName()
  {
    return this.statusName;
  }
  
  public void setStatusName(String paramString)
  {
    this.statusName = paramString;
  }
  
  public Long getEmployeeId()
  {
    return this.employeeId;
  }
  
  public void setEmployeeId(Long paramLong)
  {
    this.employeeId = paramLong;
  }
  
  public String getEmployeeNumber()
  {
    return this.employeeNumber;
  }
  
  public void setEmployeeNumber(String paramString)
  {
    this.employeeNumber = paramString;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public String getVoucherTypeName()
  {
    return this.voucherTypeName;
  }
  
  public void setVoucherTypeName(String paramString)
  {
    this.voucherTypeName = paramString;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpCheckPersonV)) {
      return false;
    }
    FbpCheckPersonV localFbpCheckPersonV = (FbpCheckPersonV)paramObject;
    return new EqualsBuilder().append(this.id, localFbpCheckPersonV.id).append(this.lastUpdateDate, localFbpCheckPersonV.lastUpdateDate).append(this.creationDate, localFbpCheckPersonV.creationDate).append(this.enabledFlag, localFbpCheckPersonV.enabledFlag).append(this.statusName, localFbpCheckPersonV.statusName).append(this.employeeId, localFbpCheckPersonV.employeeId).append(this.employeeNumber, localFbpCheckPersonV.employeeNumber).append(this.employeeName, localFbpCheckPersonV.employeeName).append(this.voucherTypeName, localFbpCheckPersonV.voucherTypeName).append(this.companyName, localFbpCheckPersonV.companyName).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.id).append(this.lastUpdateDate).append(this.creationDate).append(this.enabledFlag).append(this.statusName).append(this.employeeId).append(this.employeeNumber).append(this.employeeName).append(this.voucherTypeName).append(this.companyName).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("id", this.id).append("lastUpdateDate", this.lastUpdateDate).append("creationDate", this.creationDate).append("enabledFlag", this.enabledFlag).append("statusName", this.statusName).append("employeeId", this.employeeId).append("employeeNumber", this.employeeNumber).append("employeeName", this.employeeName).append("voucherTypeName", this.voucherTypeName).append("companyName", this.companyName).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getJournalName()
  {
    return this.journalName;
  }
  
  public void setJournalName(String paramString)
  {
    this.journalName = paramString;
  }
  
  public String getAttribute1()
  {
    return this.attribute1;
  }
  
  public void setAttribute1(String paramString)
  {
    this.attribute1 = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.archives.FbpCheckPersonV
 * JD-Core Version:    0.7.0.1
 */