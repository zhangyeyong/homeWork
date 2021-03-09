package com.zte.eas.getData.EmployeeSync.services;

import com.zte.eas.getData.ISyncDataDS;
import com.zte.ssb.framework.SSBBus;
import java.rmi.RemoteException;
import org.apache.log4j.Logger;

public class SyncEmployeeSrvSoapBindingImpl
  implements SyncEmployeeSrv
{
  Logger logger = Logger.getLogger(SyncEmployeeSrvSoapBindingImpl.class);
  
  public Message[] syncEmployees(Employees[] paramArrayOfEmployees)
    throws RemoteException
  {
    try
    {
      this.logger.error("++++++++++++++++++++++++  SyncDeptSrvSoapBindingImpl.syncEmployees begin +++++++++++++++++++++");
      ISyncDataDS localISyncDataDS = (ISyncDataDS)SSBBus.findDomainService("syncDataDS");
      arrayOfMessage = localISyncDataDS.syncEmployees(paramArrayOfEmployees);
      return arrayOfMessage;
    }
    catch (Exception localException)
    {
      this.logger.error("SyncDeptSrvSoapBindingImpl.syncEmployees err " + localException.getMessage(), localException);
      Message[] arrayOfMessage = { new Message("EAS000013", "系统异常" + localException.getMessage(), "False") };
      return arrayOfMessage;
    }
    finally
    {
      this.logger.error("++++++++++++++++++++++++  SyncDeptSrvSoapBindingImpl.syncEmployees end +++++++++++++++++++++");
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.EmployeeSync.services.SyncEmployeeSrvSoapBindingImpl
 * JD-Core Version:    0.7.0.1
 */