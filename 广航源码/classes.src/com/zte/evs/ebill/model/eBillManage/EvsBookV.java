package com.zte.evs.ebill.model.eBillManage;

import java.io.Serializable;
import java.util.Date;

public class EvsBookV
  implements Serializable
{
  private String bookCode;
  private String setBookName;
  private String setBookCode;
  private String companyName;
  private String periodName;
  private String smaName;
  private String bookPeople;
  private Date bookDate;
  private String beginNum;
  private String endNum;
  private String bookBreakFlag;
  private String bookStatus;
  private Long packageId;
  private Long bookId;
  private String statusName;
  private String invoiceType;
  private String operateUserId;
  private String companyCode;
  private String docName;
  private String bookBreakFlagName;
  private String archiveNumber;
  private String docDeadline;
  private String packageCode;
  private String warehouseCode;
  private Long companyId;
  private Long bookEmployeeId;
  private String warehouseName;
  private String bookSum;
  private String bookCount;
  private Long evsbookSum;
  private Long evsBookCount;
  public String invBatchNumer;
  private Long invCityId;
  private String invStorageCode;
  private String invArea;
  private String invRow;
  private String invColumn;
  private String invLevel;
  protected Long rowNu;
  private String savaPlace;
  private String invoiceTypeName;
  private String remark;
  
  public String getRemark()
  {
    return this.remark;
  }
  
  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }
  
  public String getInvoiceTypeName()
  {
    return this.invoiceTypeName;
  }
  
  public void setInvoiceTypeName(String paramString)
  {
    this.invoiceTypeName = paramString;
  }
  
  public EvsBookV() {}
  
  public EvsBookV(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Date paramDate, String paramString8, String paramString9, String paramString10, String paramString11, Long paramLong1, Long paramLong2, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, Long paramLong3, Long paramLong4, String paramString22, String paramString23, String paramString24, Long paramLong5, String paramString25, Long paramLong6, String paramString26, String paramString27, String paramString28, String paramString29, String paramString30, String paramString31)
  {
    this.bookCode = paramString1;
    this.setBookName = paramString2;
    this.setBookCode = paramString3;
    this.companyName = paramString4;
    this.periodName = paramString5;
    this.smaName = paramString6;
    this.bookPeople = paramString7;
    this.bookDate = paramDate;
    this.beginNum = paramString8;
    this.endNum = paramString9;
    this.bookBreakFlag = paramString10;
    this.bookStatus = paramString11;
    this.packageId = paramLong1;
    this.bookId = paramLong2;
    this.statusName = paramString12;
    this.invoiceType = paramString13;
    this.operateUserId = paramString14;
    this.companyCode = paramString15;
    this.docName = paramString16;
    this.bookBreakFlagName = paramString17;
    this.archiveNumber = paramString18;
    this.docDeadline = paramString19;
    this.packageCode = paramString20;
    this.warehouseCode = paramString21;
    this.companyId = paramLong3;
    this.bookEmployeeId = paramLong4;
    this.warehouseName = paramString22;
    this.bookSum = paramString23;
    this.bookCount = paramString24;
    this.evsbookSum = paramLong5;
    this.invBatchNumer = paramString25;
    this.invCityId = paramLong6;
    this.invStorageCode = paramString26;
    this.invArea = paramString27;
    this.invRow = paramString28;
    this.invColumn = paramString29;
    this.invLevel = paramString30;
    this.savaPlace = paramString31;
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
  
  public String getSetBookCode()
  {
    return this.setBookCode;
  }
  
  public void setSetBookCode(String paramString)
  {
    this.setBookCode = paramString;
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
  
  public String getSmaName()
  {
    return this.smaName;
  }
  
  public void setSmaName(String paramString)
  {
    this.smaName = paramString;
  }
  
  public String getBookPeople()
  {
    return this.bookPeople;
  }
  
  public void setBookPeople(String paramString)
  {
    this.bookPeople = paramString;
  }
  
  public Date getBookDate()
  {
    return this.bookDate;
  }
  
  public void setBookDate(Date paramDate)
  {
    this.bookDate = paramDate;
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
  
  public String getBookBreakFlag()
  {
    return this.bookBreakFlag;
  }
  
  public void setBookBreakFlag(String paramString)
  {
    this.bookBreakFlag = paramString;
  }
  
  public String getBookStatus()
  {
    return this.bookStatus;
  }
  
  public void setBookStatus(String paramString)
  {
    this.bookStatus = paramString;
  }
  
  public Long getPackageId()
  {
    return this.packageId;
  }
  
  public void setPackageId(Long paramLong)
  {
    this.packageId = paramLong;
  }
  
  public Long getBookId()
  {
    return this.bookId;
  }
  
  public void setBookId(Long paramLong)
  {
    this.bookId = paramLong;
  }
  
  public String getStatusName()
  {
    return this.statusName;
  }
  
  public void setStatusName(String paramString)
  {
    this.statusName = paramString;
  }
  
  public String getInvoiceType()
  {
    return this.invoiceType;
  }
  
  public void setInvoiceType(String paramString)
  {
    this.invoiceType = paramString;
  }
  
  public String getOperateUserId()
  {
    return this.operateUserId;
  }
  
  public void setOperateUserId(String paramString)
  {
    this.operateUserId = paramString;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public String getDocName()
  {
    return this.docName;
  }
  
  public void setDocName(String paramString)
  {
    this.docName = paramString;
  }
  
  public String getBookBreakFlagName()
  {
    return this.bookBreakFlagName;
  }
  
  public void setBookBreakFlagName(String paramString)
  {
    this.bookBreakFlagName = paramString;
  }
  
  public String getArchiveNumber()
  {
    return this.archiveNumber;
  }
  
  public void setArchiveNumber(String paramString)
  {
    this.archiveNumber = paramString;
  }
  
  public String getDocDeadline()
  {
    return this.docDeadline;
  }
  
  public void setDocDeadline(String paramString)
  {
    this.docDeadline = paramString;
  }
  
  public String getPackageCode()
  {
    return this.packageCode;
  }
  
  public void setPackageCode(String paramString)
  {
    this.packageCode = paramString;
  }
  
  public String getWarehouseCode()
  {
    return this.warehouseCode;
  }
  
  public void setWarehouseCode(String paramString)
  {
    this.warehouseCode = paramString;
  }
  
  public Long getCompanyId()
  {
    return this.companyId;
  }
  
  public void setCompanyId(Long paramLong)
  {
    this.companyId = paramLong;
  }
  
  public Long getBookEmployeeId()
  {
    return this.bookEmployeeId;
  }
  
  public void setBookEmployeeId(Long paramLong)
  {
    this.bookEmployeeId = paramLong;
  }
  
  public String getWarehouseName()
  {
    return this.warehouseName;
  }
  
  public void setWarehouseName(String paramString)
  {
    this.warehouseName = paramString;
  }
  
  public String getBookSum()
  {
    return this.bookSum;
  }
  
  public void setBookSum(String paramString)
  {
    this.bookSum = paramString;
  }
  
  public String getBookCount()
  {
    return this.bookCount;
  }
  
  public void setBookCount(String paramString)
  {
    this.bookCount = paramString;
  }
  
  public Long getEvsbookSum()
  {
    return this.evsbookSum;
  }
  
  public void setEvsbookSum(Long paramLong)
  {
    this.evsbookSum = paramLong;
  }
  
  public String getInvBatchNumer()
  {
    return this.invBatchNumer;
  }
  
  public void setInvBatchNumer(String paramString)
  {
    this.invBatchNumer = paramString;
  }
  
  public Long getInvCityId()
  {
    return this.invCityId;
  }
  
  public void setInvCityId(Long paramLong)
  {
    this.invCityId = paramLong;
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
  
  public String getSavaPlace()
  {
    return this.savaPlace;
  }
  
  public void setSavaPlace(String paramString)
  {
    this.savaPlace = paramString;
  }
  
  public int hashCode()
  {
    int i = 1;
    i = 31 * i + (this.archiveNumber == null ? 0 : this.archiveNumber.hashCode());
    i = 31 * i + (this.beginNum == null ? 0 : this.beginNum.hashCode());
    i = 31 * i + (this.bookBreakFlag == null ? 0 : this.bookBreakFlag.hashCode());
    i = 31 * i + (this.bookBreakFlagName == null ? 0 : this.bookBreakFlagName.hashCode());
    i = 31 * i + (this.bookCode == null ? 0 : this.bookCode.hashCode());
    i = 31 * i + (this.bookCount == null ? 0 : this.bookCount.hashCode());
    i = 31 * i + (this.bookDate == null ? 0 : this.bookDate.hashCode());
    i = 31 * i + (this.bookEmployeeId == null ? 0 : this.bookEmployeeId.hashCode());
    i = 31 * i + (this.bookId == null ? 0 : this.bookId.hashCode());
    i = 31 * i + (this.bookPeople == null ? 0 : this.bookPeople.hashCode());
    i = 31 * i + (this.bookStatus == null ? 0 : this.bookStatus.hashCode());
    i = 31 * i + (this.bookSum == null ? 0 : this.bookSum.hashCode());
    i = 31 * i + (this.companyCode == null ? 0 : this.companyCode.hashCode());
    i = 31 * i + (this.companyId == null ? 0 : this.companyId.hashCode());
    i = 31 * i + (this.companyName == null ? 0 : this.companyName.hashCode());
    i = 31 * i + (this.docDeadline == null ? 0 : this.docDeadline.hashCode());
    i = 31 * i + (this.docName == null ? 0 : this.docName.hashCode());
    i = 31 * i + (this.endNum == null ? 0 : this.endNum.hashCode());
    i = 31 * i + (this.evsbookSum == null ? 0 : this.evsbookSum.hashCode());
    i = 31 * i + (this.invArea == null ? 0 : this.invArea.hashCode());
    i = 31 * i + (this.invBatchNumer == null ? 0 : this.invBatchNumer.hashCode());
    i = 31 * i + (this.invCityId == null ? 0 : this.invCityId.hashCode());
    i = 31 * i + (this.invColumn == null ? 0 : this.invColumn.hashCode());
    i = 31 * i + (this.invLevel == null ? 0 : this.invLevel.hashCode());
    i = 31 * i + (this.invRow == null ? 0 : this.invRow.hashCode());
    i = 31 * i + (this.invStorageCode == null ? 0 : this.invStorageCode.hashCode());
    i = 31 * i + (this.invoiceType == null ? 0 : this.invoiceType.hashCode());
    i = 31 * i + (this.operateUserId == null ? 0 : this.operateUserId.hashCode());
    i = 31 * i + (this.packageCode == null ? 0 : this.packageCode.hashCode());
    i = 31 * i + (this.packageId == null ? 0 : this.packageId.hashCode());
    i = 31 * i + (this.periodName == null ? 0 : this.periodName.hashCode());
    i = 31 * i + (this.savaPlace == null ? 0 : this.savaPlace.hashCode());
    i = 31 * i + (this.setBookCode == null ? 0 : this.setBookCode.hashCode());
    i = 31 * i + (this.setBookName == null ? 0 : this.setBookName.hashCode());
    i = 31 * i + (this.smaName == null ? 0 : this.smaName.hashCode());
    i = 31 * i + (this.statusName == null ? 0 : this.statusName.hashCode());
    i = 31 * i + (this.warehouseCode == null ? 0 : this.warehouseCode.hashCode());
    i = 31 * i + (this.warehouseName == null ? 0 : this.warehouseName.hashCode());
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    EvsBookV localEvsBookV = (EvsBookV)paramObject;
    if (this.archiveNumber == null)
    {
      if (localEvsBookV.archiveNumber != null) {
        return false;
      }
    }
    else if (!this.archiveNumber.equals(localEvsBookV.archiveNumber)) {
      return false;
    }
    if (this.beginNum == null)
    {
      if (localEvsBookV.beginNum != null) {
        return false;
      }
    }
    else if (!this.beginNum.equals(localEvsBookV.beginNum)) {
      return false;
    }
    if (this.bookBreakFlag == null)
    {
      if (localEvsBookV.bookBreakFlag != null) {
        return false;
      }
    }
    else if (!this.bookBreakFlag.equals(localEvsBookV.bookBreakFlag)) {
      return false;
    }
    if (this.bookBreakFlagName == null)
    {
      if (localEvsBookV.bookBreakFlagName != null) {
        return false;
      }
    }
    else if (!this.bookBreakFlagName.equals(localEvsBookV.bookBreakFlagName)) {
      return false;
    }
    if (this.bookCode == null)
    {
      if (localEvsBookV.bookCode != null) {
        return false;
      }
    }
    else if (!this.bookCode.equals(localEvsBookV.bookCode)) {
      return false;
    }
    if (this.bookCount == null)
    {
      if (localEvsBookV.bookCount != null) {
        return false;
      }
    }
    else if (!this.bookCount.equals(localEvsBookV.bookCount)) {
      return false;
    }
    if (this.bookDate == null)
    {
      if (localEvsBookV.bookDate != null) {
        return false;
      }
    }
    else if (!this.bookDate.equals(localEvsBookV.bookDate)) {
      return false;
    }
    if (this.bookEmployeeId == null)
    {
      if (localEvsBookV.bookEmployeeId != null) {
        return false;
      }
    }
    else if (!this.bookEmployeeId.equals(localEvsBookV.bookEmployeeId)) {
      return false;
    }
    if (this.bookId == null)
    {
      if (localEvsBookV.bookId != null) {
        return false;
      }
    }
    else if (!this.bookId.equals(localEvsBookV.bookId)) {
      return false;
    }
    if (this.bookPeople == null)
    {
      if (localEvsBookV.bookPeople != null) {
        return false;
      }
    }
    else if (!this.bookPeople.equals(localEvsBookV.bookPeople)) {
      return false;
    }
    if (this.bookStatus == null)
    {
      if (localEvsBookV.bookStatus != null) {
        return false;
      }
    }
    else if (!this.bookStatus.equals(localEvsBookV.bookStatus)) {
      return false;
    }
    if (this.bookSum == null)
    {
      if (localEvsBookV.bookSum != null) {
        return false;
      }
    }
    else if (!this.bookSum.equals(localEvsBookV.bookSum)) {
      return false;
    }
    if (this.companyCode == null)
    {
      if (localEvsBookV.companyCode != null) {
        return false;
      }
    }
    else if (!this.companyCode.equals(localEvsBookV.companyCode)) {
      return false;
    }
    if (this.companyId == null)
    {
      if (localEvsBookV.companyId != null) {
        return false;
      }
    }
    else if (!this.companyId.equals(localEvsBookV.companyId)) {
      return false;
    }
    if (this.companyName == null)
    {
      if (localEvsBookV.companyName != null) {
        return false;
      }
    }
    else if (!this.companyName.equals(localEvsBookV.companyName)) {
      return false;
    }
    if (this.docDeadline == null)
    {
      if (localEvsBookV.docDeadline != null) {
        return false;
      }
    }
    else if (!this.docDeadline.equals(localEvsBookV.docDeadline)) {
      return false;
    }
    if (this.docName == null)
    {
      if (localEvsBookV.docName != null) {
        return false;
      }
    }
    else if (!this.docName.equals(localEvsBookV.docName)) {
      return false;
    }
    if (this.endNum == null)
    {
      if (localEvsBookV.endNum != null) {
        return false;
      }
    }
    else if (!this.endNum.equals(localEvsBookV.endNum)) {
      return false;
    }
    if (this.evsbookSum == null)
    {
      if (localEvsBookV.evsbookSum != null) {
        return false;
      }
    }
    else if (!this.evsbookSum.equals(localEvsBookV.evsbookSum)) {
      return false;
    }
    if (this.invArea == null)
    {
      if (localEvsBookV.invArea != null) {
        return false;
      }
    }
    else if (!this.invArea.equals(localEvsBookV.invArea)) {
      return false;
    }
    if (this.invBatchNumer == null)
    {
      if (localEvsBookV.invBatchNumer != null) {
        return false;
      }
    }
    else if (!this.invBatchNumer.equals(localEvsBookV.invBatchNumer)) {
      return false;
    }
    if (this.invCityId == null)
    {
      if (localEvsBookV.invCityId != null) {
        return false;
      }
    }
    else if (!this.invCityId.equals(localEvsBookV.invCityId)) {
      return false;
    }
    if (this.invColumn == null)
    {
      if (localEvsBookV.invColumn != null) {
        return false;
      }
    }
    else if (!this.invColumn.equals(localEvsBookV.invColumn)) {
      return false;
    }
    if (this.invLevel == null)
    {
      if (localEvsBookV.invLevel != null) {
        return false;
      }
    }
    else if (!this.invLevel.equals(localEvsBookV.invLevel)) {
      return false;
    }
    if (this.invRow == null)
    {
      if (localEvsBookV.invRow != null) {
        return false;
      }
    }
    else if (!this.invRow.equals(localEvsBookV.invRow)) {
      return false;
    }
    if (this.invStorageCode == null)
    {
      if (localEvsBookV.invStorageCode != null) {
        return false;
      }
    }
    else if (!this.invStorageCode.equals(localEvsBookV.invStorageCode)) {
      return false;
    }
    if (this.invoiceType == null)
    {
      if (localEvsBookV.invoiceType != null) {
        return false;
      }
    }
    else if (!this.invoiceType.equals(localEvsBookV.invoiceType)) {
      return false;
    }
    if (this.operateUserId == null)
    {
      if (localEvsBookV.operateUserId != null) {
        return false;
      }
    }
    else if (!this.operateUserId.equals(localEvsBookV.operateUserId)) {
      return false;
    }
    if (this.packageCode == null)
    {
      if (localEvsBookV.packageCode != null) {
        return false;
      }
    }
    else if (!this.packageCode.equals(localEvsBookV.packageCode)) {
      return false;
    }
    if (this.packageId == null)
    {
      if (localEvsBookV.packageId != null) {
        return false;
      }
    }
    else if (!this.packageId.equals(localEvsBookV.packageId)) {
      return false;
    }
    if (this.periodName == null)
    {
      if (localEvsBookV.periodName != null) {
        return false;
      }
    }
    else if (!this.periodName.equals(localEvsBookV.periodName)) {
      return false;
    }
    if (this.savaPlace == null)
    {
      if (localEvsBookV.savaPlace != null) {
        return false;
      }
    }
    else if (!this.savaPlace.equals(localEvsBookV.savaPlace)) {
      return false;
    }
    if (this.setBookCode == null)
    {
      if (localEvsBookV.setBookCode != null) {
        return false;
      }
    }
    else if (!this.setBookCode.equals(localEvsBookV.setBookCode)) {
      return false;
    }
    if (this.setBookName == null)
    {
      if (localEvsBookV.setBookName != null) {
        return false;
      }
    }
    else if (!this.setBookName.equals(localEvsBookV.setBookName)) {
      return false;
    }
    if (this.smaName == null)
    {
      if (localEvsBookV.smaName != null) {
        return false;
      }
    }
    else if (!this.smaName.equals(localEvsBookV.smaName)) {
      return false;
    }
    if (this.statusName == null)
    {
      if (localEvsBookV.statusName != null) {
        return false;
      }
    }
    else if (!this.statusName.equals(localEvsBookV.statusName)) {
      return false;
    }
    if (this.warehouseCode == null)
    {
      if (localEvsBookV.warehouseCode != null) {
        return false;
      }
    }
    else if (!this.warehouseCode.equals(localEvsBookV.warehouseCode)) {
      return false;
    }
    if (this.warehouseName == null)
    {
      if (localEvsBookV.warehouseName != null) {
        return false;
      }
    }
    else if (!this.warehouseName.equals(localEvsBookV.warehouseName)) {
      return false;
    }
    return true;
  }
  
  public Long getEvsBookCount()
  {
    return this.evsBookCount;
  }
  
  public void setEvsBookCount(Long paramLong)
  {
    this.evsBookCount = paramLong;
  }
  
  public Long getRowNu()
  {
    return this.rowNu;
  }
  
  public void setRowNu(Long paramLong)
  {
    this.rowNu = paramLong;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsBookV
 * JD-Core Version:    0.7.0.1
 */