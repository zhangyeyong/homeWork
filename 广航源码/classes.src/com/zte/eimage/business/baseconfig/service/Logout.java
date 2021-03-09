package com.zte.eimage.business.baseconfig.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Logout
  implements ILogout
{
  Log log = LogFactory.getLog(Logout.class);
  
  public void Logout(String paramString)
  {
    this.log.error("\n\n++++++++++++++++++++++++++++ Logout 注销 begin +++++++++++++++++++++++++++++++++++++++++++++");
    this.log.error("sessionID:  " + paramString);
    EvsServiceSessionMap.removeSessionByKey(paramString);
    this.log.error("++++++++++++++++++++++++++++ Logout 注销 end +++++++++++++++++++++++++++++++++++++++++++++\n\n");
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.Logout
 * JD-Core Version:    0.7.0.1
 */