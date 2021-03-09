package com.zte.eimage.business.baseconfig.service;

import com.zte.eas.eimage.business.video.proxy.VideoStatusServiceClient;
import com.zte.ssb.framework.base.BaseDomainService;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

public class EvsImageCenterDS
  extends BaseDomainService
  implements IEvsImageCenterDS
{
  public boolean cancelVideo(String paramString)
  {
    try
    {
      VideoStatusServiceClient localVideoStatusServiceClient = new VideoStatusServiceClient();
      return localVideoStatusServiceClient.cancelVideo(paramString);
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      throw new RuntimeException(localRemoteException);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      throw new RuntimeException(localException);
    }
  }
  
  public boolean registerVideo(String paramString, Date paramDate)
  {
    try
    {
      VideoStatusServiceClient localVideoStatusServiceClient = new VideoStatusServiceClient();
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramDate);
      return localVideoStatusServiceClient.registerVideo(paramString, localCalendar);
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      throw new RuntimeException(localRemoteException);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      throw new RuntimeException(localException);
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.EvsImageCenterDS
 * JD-Core Version:    0.7.0.1
 */