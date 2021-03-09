package com.zte.eas.getData.OranizationUnits.services;

import com.zte.eas.getData.ISyncDataDS;
import com.zte.ssb.framework.SSBBus;
import java.rmi.RemoteException;
import org.apache.log4j.Logger;

public class SyncDeptSrvSoapBindingImpl
  implements SyncDeptSrv
{
  Logger logger = Logger.getLogger(SyncDeptSrvSoapBindingImpl.class);
  
  public Message[] syncDepts(Depts[] paramArrayOfDepts)
    throws RemoteException
  {
    try
    {
      this.logger.error("+++++++++++++++++++++++++++++++++++ SyncDeptSrvSoapBindingImpl.syncDepts begin +++++++++++++++++++++++++++++++++++");
      ISyncDataDS localISyncDataDS = (ISyncDataDS)SSBBus.findDomainService("syncDataDS");
      arrayOfMessage = localISyncDataDS.syncDepts(paramArrayOfDepts);
      return arrayOfMessage;
    }
    catch (Exception localException)
    {
      this.logger.error("SyncDeptSrvSoapBindingImpl.syncDepts err " + localException.getMessage(), localException);
      Message[] arrayOfMessage = { new Message("EAS000013", "系统异常" + localException.getMessage(), "False") };
      return arrayOfMessage;
    }
    finally
    {
      this.logger.error("+++++++++++++++++++++++++++++++++++ SyncDeptSrvSoapBindingImpl.syncDepts end +++++++++++++++++++++++++++++++++++");
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.services.SyncDeptSrvSoapBindingImpl
 * JD-Core Version:    0.7.0.1
 */