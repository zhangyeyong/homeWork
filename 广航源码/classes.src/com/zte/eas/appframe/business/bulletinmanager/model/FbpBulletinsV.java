package com.zte.eas.appframe.business.bulletinmanager.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpBulletinsV
  extends BaseObject
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected Long bulletinId;
  protected String bulletinCatagoryCode;
  protected String bulletinCatagoryName;
  protected String employeeName;
  protected String bulletinTitle;
  protected String bulletinContent;
  protected Date startDateActive;
  protected Date endDateActive;
  protected String attribute1;
  protected String attribute2;
  protected String attribute3;
  protected String attribute4;
  protected String attribute5;
  protected String attribute6;
  protected String attribute7;
  protected String attribute8;
  protected String attribute9;
  protected String attribute10;
  protected String enabledFlag;
  protected String enabledFlagMeaning;
  protected String memo;
  protected String path;
  protected String upload;
  protected String document;
  protected String bulletinsEmployeeName;
  protected String deptLongName;
  protected String isRollFlag;
  protected Long extentId;
  protected String extentName;
  protected String companyName;
  protected String extentIds;
  protected String createdById;
  
  public FbpBulletinsV() {}
  
  public FbpBulletinsV(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, Long paramLong4, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Date paramDate3, Date paramDate4, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setBulletinId(paramLong4);
    setBulletinCatagoryCode(paramString1);
    setBulletinCatagoryName(paramString2);
    setEmployeeName(paramString3);
    setBulletinTitle(paramString4);
    setBulletinContent(paramString5);
    setStartDateActive(paramDate3);
    setEndDateActive(paramDate4);
    setAttribute1(paramString6);
    setAttribute2(paramString7);
    setAttribute3(paramString8);
    setAttribute4(paramString9);
    setAttribute5(paramString10);
    setAttribute6(paramString11);
    setAttribute7(paramString12);
    setAttribute8(paramString13);
    setAttribute9(paramString14);
    setAttribute10(paramString15);
    setEnabledFlag(paramString16);
    setMemo(paramString17);
  }
  
  public Date getLastUpdateDate()
  {
    return this.lastUpdateDate;
  }
  
  public void setLastUpdateDate(Date paramDate)
  {
    this.lastUpdateDate = paramDate;
  }
  
  public Long getLastUpdatedBy()
  {
    return this.lastUpdatedBy;
  }
  
  public void setLastUpdatedBy(Long paramLong)
  {
    this.lastUpdatedBy = paramLong;
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
  
  public Long getLastUpdateLogin()
  {
    return this.lastUpdateLogin;
  }
  
  public void setLastUpdateLogin(Long paramLong)
  {
    this.lastUpdateLogin = paramLong;
  }
  
  public Long getBulletinId()
  {
    return this.bulletinId;
  }
  
  public void setBulletinId(Long paramLong)
  {
    this.bulletinId = paramLong;
  }
  
  public String getBulletinCatagoryCode()
  {
    return this.bulletinCatagoryCode;
  }
  
  public void setBulletinCatagoryCode(String paramString)
  {
    this.bulletinCatagoryCode = paramString;
  }
  
  public String getBulletinCatagoryName()
  {
    return this.bulletinCatagoryName;
  }
  
  public void setBulletinCatagoryName(String paramString)
  {
    this.bulletinCatagoryName = paramString;
  }
  
  public String getEmployeeName()
  {
    return this.employeeName;
  }
  
  public void setEmployeeName(String paramString)
  {
    this.employeeName = paramString;
  }
  
  public String getBulletinTitle()
  {
    return this.bulletinTitle;
  }
  
  public void setBulletinTitle(String paramString)
  {
    this.bulletinTitle = paramString;
  }
  
  public String getBulletinContent()
  {
    return this.bulletinContent;
  }
  
  public void setBulletinContent(String paramString)
  {
    this.bulletinContent = paramString;
  }
  
  public Date getStartDateActive()
  {
    return this.startDateActive;
  }
  
  public void setStartDateActive(Date paramDate)
  {
    this.startDateActive = paramDate;
  }
  
  public Date getEndDateActive()
  {
    return this.endDateActive;
  }
  
  public void setEndDateActive(Date paramDate)
  {
    this.endDateActive = paramDate;
  }
  
  public String getAttribute1()
  {
    return this.attribute1;
  }
  
  public void setAttribute1(String paramString)
  {
    this.attribute1 = paramString;
  }
  
  public String getAttribute2()
  {
    return this.attribute2;
  }
  
  public void setAttribute2(String paramString)
  {
    this.attribute2 = paramString;
  }
  
  public String getAttribute3()
  {
    return this.attribute3;
  }
  
  public void setAttribute3(String paramString)
  {
    this.attribute3 = paramString;
  }
  
  public String getAttribute4()
  {
    return this.attribute4;
  }
  
  public void setAttribute4(String paramString)
  {
    this.attribute4 = paramString;
  }
  
  public String getAttribute5()
  {
    return this.attribute5;
  }
  
  public void setAttribute5(String paramString)
  {
    this.attribute5 = paramString;
  }
  
  public String getAttribute6()
  {
    return this.attribute6;
  }
  
  public void setAttribute6(String paramString)
  {
    this.attribute6 = paramString;
  }
  
  public String getAttribute7()
  {
    return this.attribute7;
  }
  
  public void setAttribute7(String paramString)
  {
    this.attribute7 = paramString;
  }
  
  public String getAttribute8()
  {
    return this.attribute8;
  }
  
  public void setAttribute8(String paramString)
  {
    this.attribute8 = paramString;
  }
  
  public String getAttribute9()
  {
    return this.attribute9;
  }
  
  public void setAttribute9(String paramString)
  {
    this.attribute9 = paramString;
  }
  
  public String getAttribute10()
  {
    return this.attribute10;
  }
  
  public void setAttribute10(String paramString)
  {
    this.attribute10 = paramString;
  }
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public String getMemo()
  {
    return this.memo;
  }
  
  public void setMemo(String paramString)
  {
    this.memo = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpBulletinsV)) {
      return false;
    }
    FbpBulletinsV localFbpBulletinsV = (FbpBulletinsV)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpBulletinsV.lastUpdateDate).append(this.lastUpdatedBy, localFbpBulletinsV.lastUpdatedBy).append(this.creationDate, localFbpBulletinsV.creationDate).append(this.createdBy, localFbpBulletinsV.createdBy).append(this.lastUpdateLogin, localFbpBulletinsV.lastUpdateLogin).append(this.bulletinId, localFbpBulletinsV.bulletinId).append(this.bulletinCatagoryCode, localFbpBulletinsV.bulletinCatagoryCode).append(this.bulletinCatagoryName, localFbpBulletinsV.bulletinCatagoryName).append(this.employeeName, localFbpBulletinsV.employeeName).append(this.bulletinTitle, localFbpBulletinsV.bulletinTitle).append(this.bulletinContent, localFbpBulletinsV.bulletinContent).append(this.startDateActive, localFbpBulletinsV.startDateActive).append(this.endDateActive, localFbpBulletinsV.endDateActive).append(this.attribute1, localFbpBulletinsV.attribute1).append(this.attribute2, localFbpBulletinsV.attribute2).append(this.attribute3, localFbpBulletinsV.attribute3).append(this.attribute4, localFbpBulletinsV.attribute4).append(this.attribute5, localFbpBulletinsV.attribute5).append(this.attribute6, localFbpBulletinsV.attribute6).append(this.attribute7, localFbpBulletinsV.attribute7).append(this.attribute8, localFbpBulletinsV.attribute8).append(this.attribute9, localFbpBulletinsV.attribute9).append(this.attribute10, localFbpBulletinsV.attribute10).append(this.enabledFlag, localFbpBulletinsV.enabledFlag).append(this.memo, localFbpBulletinsV.memo).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.bulletinId).append(this.bulletinCatagoryCode).append(this.bulletinCatagoryName).append(this.employeeName).append(this.bulletinTitle).append(this.bulletinContent).append(this.startDateActive).append(this.endDateActive).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.enabledFlag).append(this.memo).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("bulletinId", this.bulletinId).append("bulletinCatagoryCode", this.bulletinCatagoryCode).append("bulletinCatagoryName", this.bulletinCatagoryName).append("employeeName", this.employeeName).append("bulletinTitle", this.bulletinTitle).append("bulletinContent", this.bulletinContent).append("startDateActive", this.startDateActive).append("endDateActive", this.endDateActive).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("enabledFlag", this.enabledFlag).append("memo", this.memo).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public String getUpload()
  {
    return this.upload;
  }
  
  public void setUpload(String paramString)
  {
    this.upload = paramString;
  }
  
  public String getDocument()
  {
    return this.document;
  }
  
  public void setDocument(String paramString)
  {
    this.document = paramString;
  }
  
  public String getBulletinsEmployeeName()
  {
    return this.bulletinsEmployeeName;
  }
  
  public void setBulletinsEmployeeName(String paramString)
  {
    this.bulletinsEmployeeName = paramString;
  }
  
  public String getDeptLongName()
  {
    return this.deptLongName;
  }
  
  public void setDeptLongName(String paramString)
  {
    this.deptLongName = paramString;
  }
  
  public Long getExtentId()
  {
    return this.extentId;
  }
  
  public void setExtentId(Long paramLong)
  {
    this.extentId = paramLong;
  }
  
  public String getExtentName()
  {
    return this.extentName;
  }
  
  public void setExtentName(String paramString)
  {
    this.extentName = paramString;
  }
  
  public String getIsRollFlag()
  {
    return this.isRollFlag;
  }
  
  public void setIsRollFlag(String paramString)
  {
    this.isRollFlag = paramString;
  }
  
  public String getCompanyName()
  {
    return this.companyName;
  }
  
  public void setCompanyName(String paramString)
  {
    this.companyName = paramString;
  }
  
  public String getExtentIds()
  {
    return this.extentIds;
  }
  
  public void setExtentIds(String paramString)
  {
    this.extentIds = paramString;
  }
  
  public String getCreatedById()
  {
    return this.createdById;
  }
  
  public void setCreatedById(String paramString)
  {
    this.createdById = paramString;
  }
  
  public String getEnabledFlagMeaning()
  {
    return this.enabledFlagMeaning;
  }
  
  public void setEnabledFlagMeaning(String paramString)
  {
    this.enabledFlagMeaning = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.bulletinmanager.model.FbpBulletinsV
 * JD-Core Version:    0.7.0.1
 */