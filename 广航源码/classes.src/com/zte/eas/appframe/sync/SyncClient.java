package com.zte.eas.appframe.sync;

import com.zte.eas.appframe.business.synrequest.model.FbpSynchRequestsV;
import com.zte.ssb.framework.SSBBus;
import com.zte.web.service.proxy.syn.DataSynDS;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SyncClient
{
  static Log log = LogFactory.getLog(SyncClient.class);
  
  public static void syncData(String paramString)
  {
    try
    {
      ALLBPELSYNCPortClient localALLBPELSYNCPortClient = new ALLBPELSYNCPortClient();
      log.info("~~~~~~~SyncClient.syncData calling! " + localALLBPELSYNCPortClient.getEndpoint() + "; syncType=" + paramString);
      log.info("~~~~~~~SyncClient.syncData successed! " + localALLBPELSYNCPortClient.getEndpoint() + "; syncType=" + paramString);
    }
    catch (Exception localException)
    {
      log.error("~~~~~~~SyncClient.syncData() error!\n" + localException.getMessage(), localException);
    }
  }
  
  public static boolean syncData(FbpSynchRequestsV paramFbpSynchRequestsV)
  {
    boolean bool = false;
    try
    {
      DataSynDS localDataSynDS = (DataSynDS)SSBBus.findCommonService(paramFbpSynchRequestsV.getSynchType());
      bool = localDataSynDS.syn(paramFbpSynchRequestsV);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      log.error("~~~~~~~SyncClient.syncData() error!\n" + localThrowable.getMessage(), localThrowable);
    }
    return bool;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.sync.SyncClient
 * JD-Core Version:    0.7.0.1
 */