package com.zte.eimage.business.baseconfig.service;

import com.zte.ssb.framework.SSBBus;
import org.apache.log4j.Logger;

public class AppraiseImageSrv
{
  private static Logger logger = Logger.getLogger(AppraiseImageSrv.class);
  private IEvsAppraiseHistorisesDS evsAppraiseHistorisesDS = null;
  
  public String remarkVideo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      if (this.evsAppraiseHistorisesDS == null) {
        this.evsAppraiseHistorisesDS = ((IEvsAppraiseHistorisesDS)SSBBus.findDomainService("evsAppraiseHistorisesDS"));
      }
      return this.evsAppraiseHistorisesDS.remarkVideo(paramString1, paramString2, paramString3, paramString4, paramString5);
    }
    catch (Exception localException)
    {
      logger.error("系统异常：" + localException.getMessage(), localException);
    }
    return "N";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.AppraiseImageSrv
 * JD-Core Version:    0.7.0.1
 */