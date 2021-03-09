package com.zte.evs.ebill.model.eBillManage;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EvsAllotHeadersV
  extends BaseObject
  implements Serializable
{
  protected BigInteger allotHeaderId;
  protected String allotNum;
  protected String allotNumBegin;
  protected String allotNumEnd;
  protected BigInteger allotTypeId;
  protected String allotTypeName;
  protected String sourceCheckUnit;
  protected String sourceCheckUnitName;
  protected String storeCheckUnit;
  protected String storeCheckUnitName;
  protected BigInteger allotBy;
  protected String employeeName;
  protected Date allotDate;
  protected String allotDateStr;
  protected String allotMode;
  protected String allotModeMeaning;
  protected String allotDesc;
  protected String allotStatus;
  protected String allotStatusMeaning;
  protected BigInteger receiveBy;
  protected String receiveByName;
  protected Date receiveDate;
  protected String rec_beginDate;
  protected String rec_endDate;
  private BigInteger archivesSiteId;
  private String archivesSiteName;
  protected String beginDate;
  protected String endDate;
  protected String flag;
  protected Long companyId;
  protected String companyName;
  protected Long userLoginId;
  private String blurQuery;
  
  public String getBlurQuery()
  {
    return this.blurQuery;
  }
  
  public void setBlurQuery(String paramString)
  {
    this.blurQuery = paramString;
  }
  
  public Long getUserLoginId()
  {
    return this.userLoginId;
  }
  
  public void setUserLoginId(Long paramLong)
  {
    this.userLoginId = paramLong;
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
  
  public String getFlag()
  {
    return this.flag;
  }
  
  public void setFlag(String paramString)
  {
    this.flag = paramString;
  }
  
  public EvsAllotHeadersV() {}
  
  public EvsAllotHeadersV(BigInteger paramBigInteger1, String paramString1, BigInteger paramBigInteger2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, BigInteger paramBigInteger3, String paramString7, Date paramDate, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    setAllotHeaderId(paramBigInteger1);
    setAllotNum(paramString1);
    setAllotTypeId(paramBigInteger2);
    setAllotTypeName(paramString2);
    setSourceCheckUnit(paramString3);
    setSourceCheckUnitName(paramString4);
    setStoreCheckUnit(paramString5);
    setStoreCheckUnitName(paramString6);
    setAllotBy(paramBigInteger3);
    setEmployeeName(paramString7);
    setAllotDate(paramDate);
    setAllotMode(paramString8);
    setAllotModeMeaning(paramString9);
    setAllotDesc(paramString10);
    setAllotStatus(paramString11);
    setAllotStatusMeaning(paramString12);
  }
  
  public BigInteger getAllotHeaderId()
  {
    return this.allotHeaderId;
  }
  
  public void setAllotHeaderId(BigInteger paramBigInteger)
  {
    this.allotHeaderId = paramBigInteger;
  }
  
  public String getAllotNum()
  {
    return this.allotNum;
  }
  
  public void setAllotNum(String paramString)
  {
    this.allotNum = paramString;
  }
  
  public BigInteger getAllotTypeId()
  {
    return this.allotTypeId;
  }
  
  public void setAllotTypeId(BigInteger paramBigInteger)
  {
    this.allotTypeId = paramBigInteger;
  }
  
  public String getAllotTypeName()
  {
    return this.allotTypeName;
  }
  
  public void setAllotTypeName(String paramString)
  {
    this.allotTypeName = paramString;
  }
  
  public String getSourceCheckUnit()
  {
    return this.sourceCheckUnit;
  }
  
  public void setSourceCheckUnit(String paramString)
  {
    this.sourceCheckUnit = paramString;
  }
  
  public String getSourceCheckUnitName()
  {
    return this.sourceCheckUnitName;
  }
  
  public void setSourceCheckUnitName(String paramString)
  {
    this.sourceCheckUnitName = paramString;
  }
  
  public String getStoreCheckUnit()
  {
    return this.storeCheckUnit;
  }
  
  public void setStoreCheckUnit(String paramString)
  {
    this.storeCheckUnit = paramString;
  }
  
  public String getStoreCheckUnitName()
  {
    return this.storeCheckUnitName;
  }
  
  public void setStoreCheckUnitName(String paramString)
  {
    this.storeCheckUnitName = paramString;
  }
  
  public BigInteger getAllotBy()
  {
    return this.allotBy;
  }
  
  public void setAllotBy(BigInteger paramBigInteger)
  {
    this.allotBy = paramBigInteger;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public Date getAllotDate()
  {
    return this.allotDate;
  }
  
  public void setAllotDate(Date paramDate)
  {
    this.allotDate = paramDate;
  }
  
  public String getAllotMode()
  {
    return this.allotMode;
  }
  
  public void setAllotMode(String paramString)
  {
    this.allotMode = paramString;
  }
  
  public String getAllotModeMeaning()
  {
    return this.allotModeMeaning;
  }
  
  public void setAllotModeMeaning(String paramString)
  {
    this.allotModeMeaning = paramString;
  }
  
  public String getAllotDesc()
  {
    return this.allotDesc;
  }
  
  public void setAllotDesc(String paramString)
  {
    this.allotDesc = paramString;
  }
  
  public String getAllotStatus()
  {
    return this.allotStatus;
  }
  
  public void setAllotStatus(String paramString)
  {
    this.allotStatus = paramString;
  }
  
  public String getAllotStatusMeaning()
  {
    return this.allotStatusMeaning;
  }
  
  public void setAllotStatusMeaning(String paramString)
  {
    this.allotStatusMeaning = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EvsAllotHeadersV)) {
      return false;
    }
    EvsAllotHeadersV localEvsAllotHeadersV = (EvsAllotHeadersV)paramObject;
    return new EqualsBuilder().append(this.allotHeaderId, localEvsAllotHeadersV.allotHeaderId).append(this.allotNum, localEvsAllotHeadersV.allotNum).append(this.allotTypeId, localEvsAllotHeadersV.allotTypeId).append(this.allotTypeName, localEvsAllotHeadersV.allotTypeName).append(this.sourceCheckUnit, localEvsAllotHeadersV.sourceCheckUnit).append(this.sourceCheckUnitName, localEvsAllotHeadersV.sourceCheckUnitName).append(this.storeCheckUnit, localEvsAllotHeadersV.storeCheckUnit).append(this.storeCheckUnitName, localEvsAllotHeadersV.storeCheckUnitName).append(this.allotBy, localEvsAllotHeadersV.allotBy).append(this.employeeName, localEvsAllotHeadersV.employeeName).append(this.allotDate, localEvsAllotHeadersV.allotDate).append(this.allotMode, localEvsAllotHeadersV.allotMode).append(this.allotModeMeaning, localEvsAllotHeadersV.allotModeMeaning).append(this.allotDesc, localEvsAllotHeadersV.allotDesc).append(this.allotStatus, localEvsAllotHeadersV.allotStatus).append(this.allotStatusMeaning, localEvsAllotHeadersV.allotStatusMeaning).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.allotHeaderId).append(this.allotNum).append(this.allotTypeId).append(this.allotTypeName).append(this.sourceCheckUnit).append(this.sourceCheckUnitName).append(this.storeCheckUnit).append(this.storeCheckUnitName).append(this.allotBy).append(this.employeeName).append(this.allotDate).append(this.allotMode).append(this.allotModeMeaning).append(this.allotDesc).append(this.allotStatus).append(this.allotStatusMeaning).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("allotHeaderId", this.allotHeaderId).append("allotNum", this.allotNum).append("allotTypeId", this.allotTypeId).append("allotTypeName", this.allotTypeName).append("sourceCheckUnit", this.sourceCheckUnit).append("sourceCheckUnitName", this.sourceCheckUnitName).append("storeCheckUnit", this.storeCheckUnit).append("storeCheckUnitName", this.storeCheckUnitName).append("allotBy", this.allotBy).append("employeeName", this.employeeName).append("allotDate", this.allotDate).append("allotMode", this.allotMode).append("allotModeMeaning", this.allotModeMeaning).append("allotDesc", this.allotDesc).append("allotStatus", this.allotStatus).append("allotStatusMeaning", this.allotStatusMeaning).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getBeginDate()
  {
    return this.beginDate;
  }
  
  public void setBeginDate(String paramString)
  {
    this.beginDate = paramString;
  }
  
  public String getEndDate()
  {
    return this.endDate;
  }
  
  public void setEndDate(String paramString)
  {
    this.endDate = paramString;
  }
  
  public BigInteger getArchivesSiteId()
  {
    return this.archivesSiteId;
  }
  
  public void setArchivesSiteId(BigInteger paramBigInteger)
  {
    this.archivesSiteId = paramBigInteger;
  }
  
  public String getArchivesSiteName()
  {
    return this.archivesSiteName;
  }
  
  public void setArchivesSiteName(String paramString)
  {
    this.archivesSiteName = paramString;
  }
  
  public String getAllotDateStr()
  {
    return this.allotDateStr;
  }
  
  public void setAllotDateStr(String paramString)
  {
    this.allotDateStr = paramString;
  }
  
  public BigInteger getReceiveBy()
  {
    return this.receiveBy;
  }
  
  public void setReceiveBy(BigInteger paramBigInteger)
  {
    this.receiveBy = paramBigInteger;
  }
  
  public String getReceiveByName()
  {
    return this.receiveByName;
  }
  
  public void setReceiveByName(String paramString)
  {
    this.receiveByName = paramString;
  }
  
  public Date getReceiveDate()
  {
    return this.receiveDate;
  }
  
  public void setReceiveDate(Date paramDate)
  {
    this.receiveDate = paramDate;
  }
  
  public String getRec_beginDate()
  {
    return this.rec_beginDate;
  }
  
  public void setRec_beginDate(String paramString)
  {
    this.rec_beginDate = paramString;
  }
  
  public String getRec_endDate()
  {
    return this.rec_endDate;
  }
  
  public void setRec_endDate(String paramString)
  {
    this.rec_endDate = paramString;
  }
  
  public String getAllotNumBegin()
  {
    return this.allotNumBegin;
  }
  
  public void setAllotNumBegin(String paramString)
  {
    this.allotNumBegin = paramString;
  }
  
  public String getAllotNumEnd()
  {
    return this.allotNumEnd;
  }
  
  public void setAllotNumEnd(String paramString)
  {
    this.allotNumEnd = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsAllotHeadersV
 * JD-Core Version:    0.7.0.1
 */