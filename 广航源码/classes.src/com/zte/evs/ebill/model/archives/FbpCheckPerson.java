package com.zte.evs.ebill.model.archives;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FbpCheckPerson
  extends BaseObject
  implements Serializable
{
  protected Date lastUpdateDate;
  protected Long lastUpdatedBy;
  protected Date creationDate;
  protected Long createdBy;
  protected Long lastUpdateLogin;
  protected String enabledFlag;
  protected Long id;
  protected Long employeeId;
  protected String journalName;
  protected Long checkPersonId;
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
  protected Long numberAttribute1;
  protected Long numberAttribute2;
  protected Long numberAttribute3;
  protected Long numberAttribute4;
  protected Long numberAttribute5;
  protected Long numberAttribute6;
  protected Long numberAttribute7;
  protected Long numberAttribute8;
  protected Long numberAttribute9;
  protected Long numberAttribute10;
  protected Date dateAttribute1;
  protected Date dateAttribute2;
  protected Date dateAttribute3;
  protected Date dateAttribute4;
  protected Date dateAttribute5;
  protected Date dateAttribute6;
  protected Date dateAttribute7;
  protected Date dateAttribute8;
  protected Date dateAttribute9;
  protected Date dateAttribute10;
  
  public FbpCheckPerson() {}
  
  public FbpCheckPerson(Date paramDate1, Long paramLong1, Date paramDate2, Long paramLong2, Long paramLong3, String paramString1, Long paramLong4, Long paramLong5, String paramString2, Long paramLong6, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, Long paramLong7, Long paramLong8, Long paramLong9, Long paramLong10, Long paramLong11, Long paramLong12, Long paramLong13, Long paramLong14, Long paramLong15, Long paramLong16, Date paramDate3, Date paramDate4, Date paramDate5, Date paramDate6, Date paramDate7, Date paramDate8, Date paramDate9, Date paramDate10, Date paramDate11, Date paramDate12)
  {
    setLastUpdateDate(paramDate1);
    setLastUpdatedBy(paramLong1);
    setCreationDate(paramDate2);
    setCreatedBy(paramLong2);
    setLastUpdateLogin(paramLong3);
    setEnabledFlag(paramString1);
    setId(paramLong4);
    setEmployeeId(paramLong5);
    setJournalName(paramString2);
    setCheckPersonId(paramLong6);
    setAttribute1(paramString3);
    setAttribute2(paramString4);
    setAttribute3(paramString5);
    setAttribute4(paramString6);
    setAttribute5(paramString7);
    setAttribute6(paramString8);
    setAttribute7(paramString9);
    setAttribute8(paramString10);
    setAttribute9(paramString11);
    setAttribute10(paramString12);
    setNumberAttribute1(paramLong7);
    setNumberAttribute2(paramLong8);
    setNumberAttribute3(paramLong9);
    setNumberAttribute4(paramLong10);
    setNumberAttribute5(paramLong11);
    setNumberAttribute6(paramLong12);
    setNumberAttribute7(paramLong13);
    setNumberAttribute8(paramLong14);
    setNumberAttribute9(paramLong15);
    setNumberAttribute10(paramLong16);
    setDateAttribute1(paramDate3);
    setDateAttribute2(paramDate4);
    setDateAttribute3(paramDate5);
    setDateAttribute4(paramDate6);
    setDateAttribute5(paramDate7);
    setDateAttribute6(paramDate8);
    setDateAttribute7(paramDate9);
    setDateAttribute8(paramDate10);
    setDateAttribute9(paramDate11);
    setDateAttribute10(paramDate12);
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
  
  public String getEnabledFlag()
  {
    return this.enabledFlag;
  }
  
  public void setEnabledFlag(String paramString)
  {
    this.enabledFlag = paramString;
  }
  
  public Long getId()
  {
    return this.id;
  }
  
  public void setId(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public Long getEmployeeId()
  {
    return this.employeeId;
  }
  
  public void setEmployeeId(Long paramLong)
  {
    this.employeeId = paramLong;
  }
  
  public String getJournalName()
  {
    return this.journalName;
  }
  
  public void setJournalName(String paramString)
  {
    this.journalName = paramString;
  }
  
  public Long getCheckPersonId()
  {
    return this.checkPersonId;
  }
  
  public void setCheckPersonId(Long paramLong)
  {
    this.checkPersonId = paramLong;
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
  
  public Long getNumberAttribute1()
  {
    return this.numberAttribute1;
  }
  
  public void setNumberAttribute1(Long paramLong)
  {
    this.numberAttribute1 = paramLong;
  }
  
  public Long getNumberAttribute2()
  {
    return this.numberAttribute2;
  }
  
  public void setNumberAttribute2(Long paramLong)
  {
    this.numberAttribute2 = paramLong;
  }
  
  public Long getNumberAttribute3()
  {
    return this.numberAttribute3;
  }
  
  public void setNumberAttribute3(Long paramLong)
  {
    this.numberAttribute3 = paramLong;
  }
  
  public Long getNumberAttribute4()
  {
    return this.numberAttribute4;
  }
  
  public void setNumberAttribute4(Long paramLong)
  {
    this.numberAttribute4 = paramLong;
  }
  
  public Long getNumberAttribute5()
  {
    return this.numberAttribute5;
  }
  
  public void setNumberAttribute5(Long paramLong)
  {
    this.numberAttribute5 = paramLong;
  }
  
  public Long getNumberAttribute6()
  {
    return this.numberAttribute6;
  }
  
  public void setNumberAttribute6(Long paramLong)
  {
    this.numberAttribute6 = paramLong;
  }
  
  public Long getNumberAttribute7()
  {
    return this.numberAttribute7;
  }
  
  public void setNumberAttribute7(Long paramLong)
  {
    this.numberAttribute7 = paramLong;
  }
  
  public Long getNumberAttribute8()
  {
    return this.numberAttribute8;
  }
  
  public void setNumberAttribute8(Long paramLong)
  {
    this.numberAttribute8 = paramLong;
  }
  
  public Long getNumberAttribute9()
  {
    return this.numberAttribute9;
  }
  
  public void setNumberAttribute9(Long paramLong)
  {
    this.numberAttribute9 = paramLong;
  }
  
  public Long getNumberAttribute10()
  {
    return this.numberAttribute10;
  }
  
  public void setNumberAttribute10(Long paramLong)
  {
    this.numberAttribute10 = paramLong;
  }
  
  public Date getDateAttribute1()
  {
    return this.dateAttribute1;
  }
  
  public void setDateAttribute1(Date paramDate)
  {
    this.dateAttribute1 = paramDate;
  }
  
  public Date getDateAttribute2()
  {
    return this.dateAttribute2;
  }
  
  public void setDateAttribute2(Date paramDate)
  {
    this.dateAttribute2 = paramDate;
  }
  
  public Date getDateAttribute3()
  {
    return this.dateAttribute3;
  }
  
  public void setDateAttribute3(Date paramDate)
  {
    this.dateAttribute3 = paramDate;
  }
  
  public Date getDateAttribute4()
  {
    return this.dateAttribute4;
  }
  
  public void setDateAttribute4(Date paramDate)
  {
    this.dateAttribute4 = paramDate;
  }
  
  public Date getDateAttribute5()
  {
    return this.dateAttribute5;
  }
  
  public void setDateAttribute5(Date paramDate)
  {
    this.dateAttribute5 = paramDate;
  }
  
  public Date getDateAttribute6()
  {
    return this.dateAttribute6;
  }
  
  public void setDateAttribute6(Date paramDate)
  {
    this.dateAttribute6 = paramDate;
  }
  
  public Date getDateAttribute7()
  {
    return this.dateAttribute7;
  }
  
  public void setDateAttribute7(Date paramDate)
  {
    this.dateAttribute7 = paramDate;
  }
  
  public Date getDateAttribute8()
  {
    return this.dateAttribute8;
  }
  
  public void setDateAttribute8(Date paramDate)
  {
    this.dateAttribute8 = paramDate;
  }
  
  public Date getDateAttribute9()
  {
    return this.dateAttribute9;
  }
  
  public void setDateAttribute9(Date paramDate)
  {
    this.dateAttribute9 = paramDate;
  }
  
  public Date getDateAttribute10()
  {
    return this.dateAttribute10;
  }
  
  public void setDateAttribute10(Date paramDate)
  {
    this.dateAttribute10 = paramDate;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FbpCheckPerson)) {
      return false;
    }
    FbpCheckPerson localFbpCheckPerson = (FbpCheckPerson)paramObject;
    return new EqualsBuilder().append(this.lastUpdateDate, localFbpCheckPerson.lastUpdateDate).append(this.lastUpdatedBy, localFbpCheckPerson.lastUpdatedBy).append(this.creationDate, localFbpCheckPerson.creationDate).append(this.createdBy, localFbpCheckPerson.createdBy).append(this.lastUpdateLogin, localFbpCheckPerson.lastUpdateLogin).append(this.enabledFlag, localFbpCheckPerson.enabledFlag).append(this.id, localFbpCheckPerson.id).append(this.employeeId, localFbpCheckPerson.employeeId).append(this.journalName, localFbpCheckPerson.journalName).append(this.checkPersonId, localFbpCheckPerson.checkPersonId).append(this.attribute1, localFbpCheckPerson.attribute1).append(this.attribute2, localFbpCheckPerson.attribute2).append(this.attribute3, localFbpCheckPerson.attribute3).append(this.attribute4, localFbpCheckPerson.attribute4).append(this.attribute5, localFbpCheckPerson.attribute5).append(this.attribute6, localFbpCheckPerson.attribute6).append(this.attribute7, localFbpCheckPerson.attribute7).append(this.attribute8, localFbpCheckPerson.attribute8).append(this.attribute9, localFbpCheckPerson.attribute9).append(this.attribute10, localFbpCheckPerson.attribute10).append(this.numberAttribute1, localFbpCheckPerson.numberAttribute1).append(this.numberAttribute2, localFbpCheckPerson.numberAttribute2).append(this.numberAttribute3, localFbpCheckPerson.numberAttribute3).append(this.numberAttribute4, localFbpCheckPerson.numberAttribute4).append(this.numberAttribute5, localFbpCheckPerson.numberAttribute5).append(this.numberAttribute6, localFbpCheckPerson.numberAttribute6).append(this.numberAttribute7, localFbpCheckPerson.numberAttribute7).append(this.numberAttribute8, localFbpCheckPerson.numberAttribute8).append(this.numberAttribute9, localFbpCheckPerson.numberAttribute9).append(this.numberAttribute10, localFbpCheckPerson.numberAttribute10).append(this.dateAttribute1, localFbpCheckPerson.dateAttribute1).append(this.dateAttribute2, localFbpCheckPerson.dateAttribute2).append(this.dateAttribute3, localFbpCheckPerson.dateAttribute3).append(this.dateAttribute4, localFbpCheckPerson.dateAttribute4).append(this.dateAttribute5, localFbpCheckPerson.dateAttribute5).append(this.dateAttribute6, localFbpCheckPerson.dateAttribute6).append(this.dateAttribute7, localFbpCheckPerson.dateAttribute7).append(this.dateAttribute8, localFbpCheckPerson.dateAttribute8).append(this.dateAttribute9, localFbpCheckPerson.dateAttribute9).append(this.dateAttribute10, localFbpCheckPerson.dateAttribute10).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.lastUpdateDate).append(this.lastUpdatedBy).append(this.creationDate).append(this.createdBy).append(this.lastUpdateLogin).append(this.enabledFlag).append(this.id).append(this.employeeId).append(this.journalName).append(this.checkPersonId).append(this.attribute1).append(this.attribute2).append(this.attribute3).append(this.attribute4).append(this.attribute5).append(this.attribute6).append(this.attribute7).append(this.attribute8).append(this.attribute9).append(this.attribute10).append(this.numberAttribute1).append(this.numberAttribute2).append(this.numberAttribute3).append(this.numberAttribute4).append(this.numberAttribute5).append(this.numberAttribute6).append(this.numberAttribute7).append(this.numberAttribute8).append(this.numberAttribute9).append(this.numberAttribute10).append(this.dateAttribute1).append(this.dateAttribute2).append(this.dateAttribute3).append(this.dateAttribute4).append(this.dateAttribute5).append(this.dateAttribute6).append(this.dateAttribute7).append(this.dateAttribute8).append(this.dateAttribute9).append(this.dateAttribute10).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("lastUpdateDate", this.lastUpdateDate).append("lastUpdatedBy", this.lastUpdatedBy).append("creationDate", this.creationDate).append("createdBy", this.createdBy).append("lastUpdateLogin", this.lastUpdateLogin).append("enabledFlag", this.enabledFlag).append("id", this.id).append("employeeId", this.employeeId).append("journalName", this.journalName).append("checkPersonId", this.checkPersonId).append("attribute1", this.attribute1).append("attribute2", this.attribute2).append("attribute3", this.attribute3).append("attribute4", this.attribute4).append("attribute5", this.attribute5).append("attribute6", this.attribute6).append("attribute7", this.attribute7).append("attribute8", this.attribute8).append("attribute9", this.attribute9).append("attribute10", this.attribute10).append("numberAttribute1", this.numberAttribute1).append("numberAttribute2", this.numberAttribute2).append("numberAttribute3", this.numberAttribute3).append("numberAttribute4", this.numberAttribute4).append("numberAttribute5", this.numberAttribute5).append("numberAttribute6", this.numberAttribute6).append("numberAttribute7", this.numberAttribute7).append("numberAttribute8", this.numberAttribute8).append("numberAttribute9", this.numberAttribute9).append("numberAttribute10", this.numberAttribute10).append("dateAttribute1", this.dateAttribute1).append("dateAttribute2", this.dateAttribute2).append("dateAttribute3", this.dateAttribute3).append("dateAttribute4", this.dateAttribute4).append("dateAttribute5", this.dateAttribute5).append("dateAttribute6", this.dateAttribute6).append("dateAttribute7", this.dateAttribute7).append("dateAttribute8", this.dateAttribute8).append("dateAttribute9", this.dateAttribute9).append("dateAttribute10", this.dateAttribute10).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "id";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.archives.FbpCheckPerson
 * JD-Core Version:    0.7.0.1
 */