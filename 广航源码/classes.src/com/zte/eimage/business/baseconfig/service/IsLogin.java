package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.business.common.model.Fbplogins;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IsLogin
  implements IIsLogin
{
  Log log = LogFactory.getLog(IsLogin.class);
  
  public boolean IsLogin(String paramString)
  {
    this.log.error("\n\n++++++++++++++++++++++++++++ IsLogin SI_OUT_12查询用户是否已经登录 begin +++++++++++++++++++++++++++++++++++++++++++++");
    boolean bool = false;
    Fbplogins localFbplogins = EvsServiceSessionMap.getLoginInfo(paramString);
    if (localFbplogins != null) {
      bool = true;
    }
    this.log.error("用户是否已登录：TRUE OR FALSE： " + bool);
    this.log.error("++++++++++++++++++++++++++++ IsLogin SI_OUT_12查询用户是否已经登录 end +++++++++++++++++++++++++++++++++++++++++++++\n\n");
    return bool;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.IsLogin
 * JD-Core Version:    0.7.0.1
 */