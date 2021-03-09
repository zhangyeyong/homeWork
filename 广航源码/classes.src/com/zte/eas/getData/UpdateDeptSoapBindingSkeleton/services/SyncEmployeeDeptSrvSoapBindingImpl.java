package com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services;

import com.zte.eas.getData.ISyncDataDS;
import com.zte.ssb.framework.SSBBus;
import java.rmi.RemoteException;
import org.apache.log4j.Logger;

public class SyncEmployeeDeptSrvSoapBindingImpl
  implements SyncEmployeeDeptSrv
{
  Logger logger = Logger.getLogger(SyncEmployeeDeptSrvSoapBindingImpl.class);
  
  public MessageCollection updateEmployeeDept(EmployeeDeptCollection paramEmployeeDeptCollection)
    throws RemoteException
  {
    try
    {
      this.logger.error("++++++++++++++++++++++++  SyncEmployeeDeptSrvSoapBindingImpl.updateEmployeeDept begin ++++++++++++++++++++++++");
      ISyncDataDS localISyncDataDS = (ISyncDataDS)SSBBus.findDomainService("syncDataDS");
      localMessageCollection1 = localISyncDataDS.updateEmployeeDept(paramEmployeeDeptCollection);
      return localMessageCollection1;
    }
    catch (Exception localException)
    {
      this.logger.error("SyncEmployeeDeptSrvSoapBindingImpl.updateEmployeeDept err" + localException.getMessage(), localException);
      MessageCollection localMessageCollection1 = new MessageCollection();
      localMessageCollection1.setMessageList(new Message[] { new Message("EAS000013", "系统异常" + localException.getMessage(), "False") });
      MessageCollection localMessageCollection2 = localMessageCollection1;
      return localMessageCollection2;
    }
    finally
    {
      this.logger.error("++++++++++++++++++++++++  SyncEmployeeDeptSrvSoapBindingImpl.updateEmployeeDept end ++++++++++++++++++++++++");
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.services.SyncEmployeeDeptSrvSoapBindingImpl
 * JD-Core Version:    0.7.0.1
 */