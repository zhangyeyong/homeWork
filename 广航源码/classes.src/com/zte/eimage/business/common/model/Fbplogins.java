package com.zte.eimage.business.common.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Fbplogins
  extends BaseObject
  implements Serializable
{
  protected BigInteger loginId;
  protected BigInteger appId;
  protected BigInteger userId;
  protected String userCode;
  protected String userName;
  protected Date loginTime;
  protected String loginIp;
  protected Date logoutTime;
  protected Date activeTime;
  
  public Fbplogins() {}
  
  public Fbplogins(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, String paramString1, String paramString2, Date paramDate1, String paramString3, Date paramDate2, Date paramDate3)
  {
    setLoginId(paramBigInteger1);
    setAppId(paramBigInteger2);
    setUserId(paramBigInteger3);
    setUserCode(paramString1);
    setUserName(paramString2);
    setLoginTime(paramDate1);
    setLoginIp(paramString3);
    setLogoutTime(paramDate2);
    setActiveTime(paramDate3);
  }
  
  public BigInteger getLoginId()
  {
    return this.loginId;
  }
  
  public void setLoginId(BigInteger paramBigInteger)
  {
    this.loginId = paramBigInteger;
  }
  
  public BigInteger getAppId()
  {
    return this.appId;
  }
  
  public void setAppId(BigInteger paramBigInteger)
  {
    this.appId = paramBigInteger;
  }
  
  public BigInteger getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(BigInteger paramBigInteger)
  {
    this.userId = paramBigInteger;
  }
  
  public String getUserCode()
  {
    return this.userCode;
  }
  
  public void setUserCode(String paramString)
  {
    this.userCode = paramString;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  public Date getLoginTime()
  {
    return this.loginTime;
  }
  
  public void setLoginTime(Date paramDate)
  {
    this.loginTime = paramDate;
  }
  
  public String getLoginIp()
  {
    return this.loginIp;
  }
  
  public void setLoginIp(String paramString)
  {
    this.loginIp = paramString;
  }
  
  public Date getLogoutTime()
  {
    return this.logoutTime;
  }
  
  public void setLogoutTime(Date paramDate)
  {
    this.logoutTime = paramDate;
  }
  
  public Date getActiveTime()
  {
    return this.activeTime;
  }
  
  public void setActiveTime(Date paramDate)
  {
    this.activeTime = paramDate;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Fbplogins)) {
      return false;
    }
    Fbplogins localFbplogins = (Fbplogins)paramObject;
    return new EqualsBuilder().append(this.loginId, localFbplogins.loginId).append(this.appId, localFbplogins.appId).append(this.userId, localFbplogins.userId).append(this.userCode, localFbplogins.userCode).append(this.userName, localFbplogins.userName).append(this.loginTime, localFbplogins.loginTime).append(this.loginIp, localFbplogins.loginIp).append(this.logoutTime, localFbplogins.logoutTime).append(this.activeTime, localFbplogins.activeTime).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.loginId).append(this.appId).append(this.userId).append(this.userCode).append(this.userName).append(this.loginTime).append(this.loginIp).append(this.logoutTime).append(this.activeTime).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("loginId", this.loginId).append("appId", this.appId).append("userId", this.userId).append("userCode", this.userCode).append("userName", this.userName).append("loginTime", this.loginTime).append("loginIp", this.loginIp).append("logoutTime", this.logoutTime).append("activeTime", this.activeTime).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "loginId";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.common.model.Fbplogins
 * JD-Core Version:    0.7.0.1
 */