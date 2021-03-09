package com.zte.evs.ebill.model.eBillManage;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EvsVoucherQueryV
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected BigInteger num;
  protected BigInteger voucherId;
  protected String journalNum;
  protected String matchMode;
  protected Long companyId;
  protected String companyCode;
  protected String companyName;
  protected String periodName;
  protected String voucherStatus;
  protected String voucherStatusName;
  protected String barcode;
  protected String invoiceTypeCode;
  protected String invoiceTypeName;
  protected String userName;
  protected Date createdDate;
  protected String approver;
  protected String bookCode;
  protected Date approverDate;
  protected String voucherMarker;
  protected String invCityId;
  protected String invStorageCode;
  protected String invArea;
  protected String invRow;
  protected String invColumn;
  protected String invLevel;
  String storeAddress;
  
  public EvsVoucherQueryV() {}
  
  public EvsVoucherQueryV(BigInteger paramBigInteger1, BigInteger paramBigInteger2, String paramString1, String paramString2, Long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, Date paramDate1, String paramString12, String paramString13, Date paramDate2, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20)
  {
    setNum(paramBigInteger1);
    setVoucherId(paramBigInteger2);
    setJournalNum(paramString1);
    setMatchMode(paramString2);
    setCompanyId(paramLong);
    setCompanyCode(paramString3);
    setCompanyName(paramString4);
    setPeriodName(paramString5);
    setVoucherStatus(paramString6);
    setVoucherStatusName(paramString7);
    setBarcode(paramString8);
    setInvoiceTypeCode(paramString9);
    setInvoiceTypeName(paramString10);
    setUserName(paramString11);
    setCreatedDate(paramDate1);
    setApprover(paramString12);
    setBookCode(paramString13);
    setApproverDate(paramDate2);
    setVoucherMarker(paramString14);
    setInvCityId(paramString15);
    setInvStorageCode(paramString16);
    setInvArea(paramString17);
    setInvRow(paramString18);
    setInvColumn(paramString19);
    setInvLevel(paramString20);
  }
  
  public BigInteger getNum()
  {
    return this.num;
  }
  
  public void setNum(BigInteger paramBigInteger)
  {
    this.num = paramBigInteger;
  }
  
  public BigInteger getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(BigInteger paramBigInteger)
  {
    this.voucherId = paramBigInteger;
  }
  
  public String getJournalNum()
  {
    return this.journalNum;
  }
  
  public void setJournalNum(String paramString)
  {
    this.journalNum = paramString;
  }
  
  public String getMatchMode()
  {
    return this.matchMode;
  }
  
  public void setMatchMode(String paramString)
  {
    this.matchMode = paramString;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public String getPeriodName()
  {
    return this.periodName;
  }
  
  public void setPeriodName(String paramString)
  {
    this.periodName = paramString;
  }
  
  public String getVoucherStatus()
  {
    return this.voucherStatus;
  }
  
  public void setVoucherStatus(String paramString)
  {
    this.voucherStatus = paramString;
  }
  
  public String getVoucherStatusName()
  {
    return this.voucherStatusName;
  }
  
  public void setVoucherStatusName(String paramString)
  {
    this.voucherStatusName = paramString;
  }
  
  public String getBarcode()
  {
    return this.barcode;
  }
  
  public void setBarcode(String paramString)
  {
    this.barcode = paramString;
  }
  
  public String getInvoiceTypeCode()
  {
    return this.invoiceTypeCode;
  }
  
  public void setInvoiceTypeCode(String paramString)
  {
    this.invoiceTypeCode = paramString;
  }
  
  public String getInvoiceTypeName()
  {
    return this.invoiceTypeName;
  }
  
  public void setInvoiceTypeName(String paramString)
  {
    this.invoiceTypeName = paramString;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public Date getCreatedDate()
  {
    return this.createdDate;
  }
  
  public void setCreatedDate(Date paramDate)
  {
    this.createdDate = paramDate;
  }
  
  public String getApprover()
  {
    return this.approver;
  }
  
  public void setApprover(String paramString)
  {
    this.approver = paramString;
  }
  
  public String getBookCode()
  {
    return this.bookCode;
  }
  
  public void setBookCode(String paramString)
  {
    this.bookCode = paramString;
  }
  
  public Date getApproverDate()
  {
    return this.approverDate;
  }
  
  public void setApproverDate(Date paramDate)
  {
    this.approverDate = paramDate;
  }
  
  public String getVoucherMarker()
  {
    return this.voucherMarker;
  }
  
  public void setVoucherMarker(String paramString)
  {
    this.voucherMarker = paramString;
  }
  
  public String getInvCityId()
  {
    return this.invCityId;
  }
  
  public void setInvCityId(String paramString)
  {
    this.invCityId = paramString;
  }
  
  public String getInvStorageCode()
  {
    return this.invStorageCode;
  }
  
  public void setInvStorageCode(String paramString)
  {
    this.invStorageCode = paramString;
  }
  
  public String getInvArea()
  {
    return this.invArea;
  }
  
  public void setInvArea(String paramString)
  {
    this.invArea = paramString;
  }
  
  public String getInvRow()
  {
    return this.invRow;
  }
  
  public void setInvRow(String paramString)
  {
    this.invRow = paramString;
  }
  
  public String getInvColumn()
  {
    return this.invColumn;
  }
  
  public void setInvColumn(String paramString)
  {
    this.invColumn = paramString;
  }
  
  public String getInvLevel()
  {
    return this.invLevel;
  }
  
  public void setInvLevel(String paramString)
  {
    this.invLevel = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EvsVoucherQueryV)) {
      return false;
    }
    EvsVoucherQueryV localEvsVoucherQueryV = (EvsVoucherQueryV)paramObject;
    return new EqualsBuilder().append(this.num, localEvsVoucherQueryV.num).append(this.voucherId, localEvsVoucherQueryV.voucherId).append(this.journalNum, localEvsVoucherQueryV.journalNum).append(this.matchMode, localEvsVoucherQueryV.matchMode).append(this.companyId, localEvsVoucherQueryV.companyId).append(this.companyCode, localEvsVoucherQueryV.companyCode).append(this.companyName, localEvsVoucherQueryV.companyName).append(this.periodName, localEvsVoucherQueryV.periodName).append(this.voucherStatus, localEvsVoucherQueryV.voucherStatus).append(this.voucherStatusName, localEvsVoucherQueryV.voucherStatusName).append(this.barcode, localEvsVoucherQueryV.barcode).append(this.invoiceTypeCode, localEvsVoucherQueryV.invoiceTypeCode).append(this.invoiceTypeName, localEvsVoucherQueryV.invoiceTypeName).append(this.userName, localEvsVoucherQueryV.userName).append(this.createdDate, localEvsVoucherQueryV.createdDate).append(this.approver, localEvsVoucherQueryV.approver).append(this.bookCode, localEvsVoucherQueryV.bookCode).append(this.approverDate, localEvsVoucherQueryV.approverDate).append(this.voucherMarker, localEvsVoucherQueryV.voucherMarker).append(this.invCityId, localEvsVoucherQueryV.invCityId).append(this.invStorageCode, localEvsVoucherQueryV.invStorageCode).append(this.invArea, localEvsVoucherQueryV.invArea).append(this.invRow, localEvsVoucherQueryV.invRow).append(this.invColumn, localEvsVoucherQueryV.invColumn).append(this.invLevel, localEvsVoucherQueryV.invLevel).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.num).append(this.voucherId).append(this.journalNum).append(this.matchMode).append(this.companyId).append(this.companyCode).append(this.companyName).append(this.periodName).append(this.voucherStatus).append(this.voucherStatusName).append(this.barcode).append(this.invoiceTypeCode).append(this.invoiceTypeName).append(this.userName).append(this.createdDate).append(this.approver).append(this.bookCode).append(this.approverDate).append(this.voucherMarker).append(this.invCityId).append(this.invStorageCode).append(this.invArea).append(this.invRow).append(this.invColumn).append(this.invLevel).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("num", this.num).append("voucherId", this.voucherId).append("journalNum", this.journalNum).append("matchMode", this.matchMode).append("companyId", this.companyId).append("companyCode", this.companyCode).append("companyName", this.companyName).append("periodName", this.periodName).append("voucherStatus", this.voucherStatus).append("voucherStatusName", this.voucherStatusName).append("barcode", this.barcode).append("invoiceTypeCode", this.invoiceTypeCode).append("invoiceTypeName", this.invoiceTypeName).append("userName", this.userName).append("createdDate", this.createdDate).append("approver", this.approver).append("bookCode", this.bookCode).append("approverDate", this.approverDate).append("voucherMarker", this.voucherMarker).append("invCityId", this.invCityId).append("invStorageCode", this.invStorageCode).append("invArea", this.invArea).append("invRow", this.invRow).append("invColumn", this.invColumn).append("invLevel", this.invLevel).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getStoreAddress()
  {
    return this.storeAddress;
  }
  
  public void setStoreAddress(String paramString)
  {
    this.storeAddress = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsVoucherQueryV
 * JD-Core Version:    0.7.0.1
 */