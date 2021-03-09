package com.zte.evs.ebill.model.archives;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpVoucherBorrowRecordV
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 5820742434529862999L;
  protected Long archivesHeaderId;
  protected String applyNum;
  protected Long companyId;
  protected String companyName;
  protected String archivesStatus;
  protected String archivesStatusName;
  protected Long employeeId;
  protected String employeeName;
  protected Date applyDate;
  private String applyDateBegin;
  private String applyDateEnd;
  protected String borrowTypeId;
  protected String borrowTypeName;
  protected Date userDate;
  protected Date giveBackDate;
  private String blurQuery;
  
  public FbpVoucherBorrowRecordV() {}
  
  public FbpVoucherBorrowRecordV(Long paramLong1, String paramString1, Long paramLong2, String paramString2, String paramString3, String paramString4, Long paramLong3, Date paramDate1, String paramString5, String paramString6, Date paramDate2)
  {
    setArchivesHeaderId(paramLong1);
    setApplyNum(paramString1);
    setCompanyId(paramLong2);
    setCompanyName(paramString2);
    setArchivesStatus(paramString3);
    setArchivesStatusName(paramString4);
    setEmployeeId(paramLong3);
    setApplyDate(paramDate1);
    setBorrowTypeId(paramString5);
    setBorrowTypeName(paramString6);
    setGiveBackDate(paramDate2);
  }
  
  public Long getArchivesHeaderId()
  {
    return this.archivesHeaderId;
  }
  
  public void setArchivesHeaderId(Long paramLong)
  {
    this.archivesHeaderId = paramLong;
  }
  
  public String getApplyNum()
  {
    return this.applyNum;
  }
  
  public void setApplyNum(String paramString)
  {
    this.applyNum = paramString;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public String getArchivesStatus()
  {
    return this.archivesStatus;
  }
  
  public void setArchivesStatus(String paramString)
  {
    this.archivesStatus = paramString;
  }
  
  public String getArchivesStatusName()
  {
    return this.archivesStatusName;
  }
  
  public void setArchivesStatusName(String paramString)
  {
    this.archivesStatusName = paramString;
  }
  
  public Long getEmployeeId()
  {
    return this.employeeId;
  }
  
  public void setEmployeeId(Long paramLong)
  {
    this.employeeId = paramLong;
  }
  
  public Date getApplyDate()
  {
    return this.applyDate;
  }
  
  public void setApplyDate(Date paramDate)
  {
    this.applyDate = paramDate;
  }
  
  public String getBorrowTypeId()
  {
    return this.borrowTypeId;
  }
  
  public void setBorrowTypeId(String paramString)
  {
    this.borrowTypeId = paramString;
  }
  
  public String getBorrowTypeName()
  {
    return this.borrowTypeName;
  }
  
  public void setBorrowTypeName(String paramString)
  {
    this.borrowTypeName = paramString;
  }
  
  public Date getGiveBackDate()
  {
    return this.giveBackDate;
  }
  
  public void setGiveBackDate(Date paramDate)
  {
    this.giveBackDate = paramDate;
  }
  
  public String getApplyDateBegin()
  {
    return this.applyDateBegin;
  }
  
  public void setApplyDateBegin(String paramString)
  {
    this.applyDateBegin = paramString;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public String getApplyDateEnd()
  {
    return this.applyDateEnd;
  }
  
  public void setApplyDateEnd(String paramString)
  {
    this.applyDateEnd = paramString;
  }
  
  public String getBlurQuery()
  {
    return this.blurQuery;
  }
  
  public void setBlurQuery(String paramString)
  {
    this.blurQuery = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpVoucherBorrowRecordV)) {
      return false;
    }
    FbpVoucherBorrowRecordV localFbpVoucherBorrowRecordV = (FbpVoucherBorrowRecordV)paramObject;
    return new EqualsBuilder().append(this.archivesHeaderId, localFbpVoucherBorrowRecordV.archivesHeaderId).append(this.applyNum, localFbpVoucherBorrowRecordV.applyNum).append(this.companyId, localFbpVoucherBorrowRecordV.companyId).append(this.companyName, localFbpVoucherBorrowRecordV.companyName).append(this.archivesStatus, localFbpVoucherBorrowRecordV.archivesStatus).append(this.archivesStatusName, localFbpVoucherBorrowRecordV.archivesStatusName).append(this.employeeId, localFbpVoucherBorrowRecordV.employeeId).append(this.applyDate, localFbpVoucherBorrowRecordV.applyDate).append(this.borrowTypeId, localFbpVoucherBorrowRecordV.borrowTypeId).append(this.borrowTypeName, localFbpVoucherBorrowRecordV.borrowTypeName).append(this.giveBackDate, localFbpVoucherBorrowRecordV.giveBackDate).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.archivesHeaderId).append(this.applyNum).append(this.companyId).append(this.companyName).append(this.archivesStatus).append(this.archivesStatusName).append(this.employeeId).append(this.applyDate).append(this.borrowTypeId).append(this.borrowTypeName).append(this.giveBackDate).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("archivesHeaderId", this.archivesHeaderId).append("applyNum", this.applyNum).append("companyId", this.companyId).append("companyName", this.companyName).append("archivesStatus", this.archivesStatus).append("archivesStatusName", this.archivesStatusName).append("employeeId", this.employeeId).append("applyDate", this.applyDate).append("borrowTypeId", this.borrowTypeId).append("borrowTypeName", this.borrowTypeName).append("giveBackDate", this.giveBackDate).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public Date getUserDate()
  {
    return this.userDate;
  }
  
  public void setUserDate(Date paramDate)
  {
    this.userDate = paramDate;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.archives.FbpVoucherBorrowRecordV
 * JD-Core Version:    0.7.0.1
 */