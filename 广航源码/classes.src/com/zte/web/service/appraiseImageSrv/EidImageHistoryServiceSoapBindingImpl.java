package com.zte.web.service.appraiseImageSrv;

import com.zte.eimage.business.baseconfig.model.EidAppraiseHistoriesV;
import com.zte.eimage.business.baseconfig.service.IEvsAppraiseHistorisesDS;
import com.zte.evs.ebill.common.ObjectCopyUtils;
import com.zte.ssb.framework.SSBBus;
import java.rmi.RemoteException;
import org.apache.log4j.Logger;

public class EidImageHistoryServiceSoapBindingImpl
  implements EvsAppraiseHistorisesDS
{
  Logger logger = Logger.getLogger(EidImageHistoryServiceSoapBindingImpl.class);
  
  public EidAppraiseHistories[] findHistoryByImageInfoId(String paramString)
    throws RemoteException
  {
    try
    {
      IEvsAppraiseHistorisesDS localIEvsAppraiseHistorisesDS = (IEvsAppraiseHistorisesDS)SSBBus.findDomainService("evsAppraiseHistorisesDS");
      EidAppraiseHistoriesV[] arrayOfEidAppraiseHistoriesV = localIEvsAppraiseHistorisesDS.findHistoryByImageInfoId(paramString);
      if ((arrayOfEidAppraiseHistoriesV != null) && (arrayOfEidAppraiseHistoriesV.length > 0))
      {
        EidAppraiseHistories[] arrayOfEidAppraiseHistories = new EidAppraiseHistories[arrayOfEidAppraiseHistoriesV.length];
        for (int i = 0; i < arrayOfEidAppraiseHistoriesV.length; i++)
        {
          EidAppraiseHistoriesV localEidAppraiseHistoriesV = arrayOfEidAppraiseHistoriesV[i];
          EidAppraiseHistories localEidAppraiseHistories = new EidAppraiseHistories();
          ObjectCopyUtils.copy(localEidAppraiseHistoriesV, localEidAppraiseHistories);
          arrayOfEidAppraiseHistories[i] = localEidAppraiseHistories;
        }
      }
    }
    catch (Exception localException)
    {
      this.logger.error(localException.getMessage(), localException);
    }
    return null;
  }
  
  public String remarkVideo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws RemoteException
  {
    try
    {
      IEvsAppraiseHistorisesDS localIEvsAppraiseHistorisesDS = (IEvsAppraiseHistorisesDS)SSBBus.findDomainService("evsAppraiseHistorisesDS");
      return localIEvsAppraiseHistorisesDS.remarkVideo(paramString1, paramString2, paramString3, paramString4, paramString5);
    }
    catch (Exception localException)
    {
      this.logger.error(localException.getMessage(), localException);
    }
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.appraiseImageSrv.EidImageHistoryServiceSoapBindingImpl
 * JD-Core Version:    0.7.0.1
 */