package com.zte.evs.ebill.model.eBillManage;

import com.zte.evs.ebill.common.EvsStatusUtil;
import java.io.Serializable;
import java.util.Date;

public class EvsBook
  implements Serializable
{
  private Long bookId;
  private String bookCode;
  private String setBookName;
  private String companyCode;
  private String periodName;
  private String serialId;
  private String invoiceType;
  private String beginNum;
  private String endNum;
  private String bookStatus;
  private String statusName;
  private String operateUserId;
  private Long bookEmployeeId;
  private Date bookDate;
  private Long packageId;
  private Date creationDate;
  private Long createdBy;
  private Date lastUpdateDate;
  private Long lastUpdateBy;
  private Long lastUpdateLogin;
  private String bookBreakFlag;
  private String remark;
  private Long bookSum;
  private Long bookCount;
  private String archiveNumber;
  
  public EvsBook() {}
  
  public EvsBook(Long paramLong, String paramString)
  {
    this.bookId = paramLong;
    this.bookCode = paramString;
  }
  
  public EvsBook(Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, Long paramLong2, Date paramDate1, Long paramLong3, Date paramDate2, Long paramLong4, Date paramDate3, Long paramLong5, Long paramLong6, String paramString10, Long paramLong7, Long paramLong8, String paramString11)
  {
    this.bookId = paramLong1;
    this.bookCode = paramString1;
    this.setBookName = paramString2;
    this.companyCode = paramString3;
    this.periodName = paramString4;
    this.serialId = paramString5;
    this.invoiceType = paramString6;
    this.beginNum = paramString7;
    this.endNum = paramString8;
    this.bookStatus = paramString9;
    this.bookEmployeeId = paramLong2;
    this.bookDate = paramDate1;
    this.packageId = paramLong3;
    this.creationDate = paramDate2;
    this.createdBy = paramLong4;
    this.lastUpdateDate = paramDate3;
    this.lastUpdateBy = paramLong5;
    this.lastUpdateLogin = paramLong6;
    this.bookBreakFlag = paramString10;
    this.operateUserId = paramString11;
    this.bookCount = paramLong8;
    this.bookSum = paramLong7;
  }
  
  public Long getBookId()
  {
    return this.bookId;
  }
  
  public void setBookId(Long paramLong)
  {
    this.bookId = paramLong;
  }
  
  public String getBookCode()
  {
    return this.bookCode;
  }
  
  public void setBookCode(String paramString)
  {
    this.bookCode = paramString;
  }
  
  public String getSetBookName()
  {
    return this.setBookName;
  }
  
  public void setSetBookName(String paramString)
  {
    this.setBookName = paramString;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public String getPeriodName()
  {
    return this.periodName;
  }
  
  public void setPeriodName(String paramString)
  {
    this.periodName = paramString;
  }
  
  public String getSerialId()
  {
    return this.serialId;
  }
  
  public void setSerialId(String paramString)
  {
    this.serialId = paramString;
  }
  
  public String getInvoiceType()
  {
    return this.invoiceType;
  }
  
  public void setInvoiceType(String paramString)
  {
    this.invoiceType = paramString;
  }
  
  public String getBeginNum()
  {
    return this.beginNum;
  }
  
  public void setBeginNum(String paramString)
  {
    this.beginNum = paramString;
  }
  
  public String getEndNum()
  {
    return this.endNum;
  }
  
  public void setEndNum(String paramString)
  {
    this.endNum = paramString;
  }
  
  public String getBookStatus()
  {
    return this.bookStatus;
  }
  
  public void setBookStatus(String paramString)
  {
    this.bookStatus = paramString;
  }
  
  public Long getBookEmployeeId()
  {
    return this.bookEmployeeId;
  }
  
  public void setBookEmployeeId(Long paramLong)
  {
    this.bookEmployeeId = paramLong;
  }
  
  public Date getBookDate()
  {
    return this.bookDate;
  }
  
  public void setBookDate(Date paramDate)
  {
    this.bookDate = paramDate;
  }
  
  public Long getPackageId()
  {
    return this.packageId;
  }
  
  public void setPackageId(Long paramLong)
  {
    this.packageId = paramLong;
  }
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.creationDate = paramDate;
  }
  
  public Long getCreatedBy()
  {
    return this.createdBy;
  }
  
  public void setCreatedBy(Long paramLong)
  {
    this.createdBy = paramLong;
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public Long getLastUpdateBy()
  {
    return this.lastUpdateBy;
  }
  
  public void setLastUpdateBy(Long paramLong)
  {
    this.lastUpdateBy = paramLong;
  }
  
  public Long getLastUpdateLogin()
  {
    return this.lastUpdateLogin;
  }
  
  public void setLastUpdateLogin(Long paramLong)
  {
    this.lastUpdateLogin = paramLong;
  }
  
  public String getBookBreakFlag()
  {
    return this.bookBreakFlag;
  }
  
  public void setBookBreakFlag(String paramString)
  {
    this.bookBreakFlag = paramString;
  }
  
  public String getStatusName()
  {
    if (this.bookStatus != null) {
      return EvsStatusUtil.getVoucherStatusName(this.bookStatus);
    }
    return this.bookStatus;
  }
  
  public void setStatusName(String paramString)
  {
    this.statusName = paramString;
  }
  
  public String getOperateUserId()
  {
    return this.operateUserId;
  }
  
  public void setOperateUserId(String paramString)
  {
    this.operateUserId = paramString;
  }
  
  public Long getBookSum()
  {
    return this.bookSum;
  }
  
  public void setBookSum(Long paramLong)
  {
    this.bookSum = paramLong;
  }
  
  public Long getBookCount()
  {
    return this.bookCount;
  }
  
  public void setBookCount(Long paramLong)
  {
    this.bookCount = paramLong;
  }
  
  public String getArchiveNumber()
  {
    return this.archiveNumber;
  }
  
  public void setArchiveNumber(String paramString)
  {
    this.archiveNumber = paramString;
  }
  
  public String getRemark()
  {
    return this.remark;
  }
  
  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsBook
 * JD-Core Version:    0.7.0.1
 */