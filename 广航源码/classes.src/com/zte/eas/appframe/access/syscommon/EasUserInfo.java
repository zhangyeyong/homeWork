package com.zte.eas.appframe.access.syscommon;

import com.zte.ssb.ui.uiloader.model.UserInfo;
import java.math.BigInteger;

public class EasUserInfo
  extends UserInfo
{
  private BigInteger userInfoPk;
  private String checkUnit;
  
  public String getCheckUnit()
  {
    return this.checkUnit;
  }
  
  public void setCheckUnit(String paramString)
  {
    this.checkUnit = paramString;
  }
  
  public BigInteger getUserInfoPk()
  {
    return this.userInfoPk;
  }
  
  public void setUserInfoPk(BigInteger paramBigInteger)
  {
    this.userInfoPk = paramBigInteger;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.syscommon.EasUserInfo
 * JD-Core Version:    0.7.0.1
 */