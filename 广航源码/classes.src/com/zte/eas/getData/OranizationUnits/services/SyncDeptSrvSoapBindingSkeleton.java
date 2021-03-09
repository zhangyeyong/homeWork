package com.zte.eas.getData.OranizationUnits.services;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.wsdl.Skeleton;

public class SyncDeptSrvSoapBindingSkeleton
  implements SyncDeptSrv, Skeleton
{
  private SyncDeptSrv impl;
  private static Map _myOperations = new Hashtable();
  private static Collection _myOperationsList = new ArrayList();
  
  public static List getOperationDescByName(String paramString)
  {
    return (List)_myOperations.get(paramString);
  }
  
  public static Collection getOperationDescs()
  {
    return _myOperationsList;
  }
  
  public SyncDeptSrvSoapBindingSkeleton()
  {
    this.impl = new SyncDeptSrvSoapBindingImpl();
  }
  
  public SyncDeptSrvSoapBindingSkeleton(SyncDeptSrv paramSyncDeptSrv)
  {
    this.impl = paramSyncDeptSrv;
  }
  
  public Message[] syncDepts(Depts[] paramArrayOfDepts)
    throws RemoteException
  {
    Message[] arrayOfMessage = this.impl.syncDepts(paramArrayOfDepts);
    return arrayOfMessage;
  }
  
  static
  {
    ParameterDesc[] arrayOfParameterDesc = { new ParameterDesc(new QName("http://OranizationUnits.getData.eas.zte.com", "ou"), 1, new QName("http://OranizationUnits.getData.eas.zte.com", ">ou"), [Lcom.zte.eas.getData.OranizationUnits.services.Depts.class, false, false) };
    OperationDesc localOperationDesc = new OperationDesc("syncDepts", arrayOfParameterDesc, new QName("http://www.evs.com/services/syncDeptSrv", "syncDeptsReturn"));
    localOperationDesc.setReturnType(new QName("http://www.evs.com/services/syncDeptSrv", ">syncDeptsReturn"));
    localOperationDesc.setElementQName(new QName("", "syncDepts"));
    localOperationDesc.setSoapAction("");
    _myOperationsList.add(localOperationDesc);
    if (_myOperations.get("syncDepts") == null) {
      _myOperations.put("syncDepts", new ArrayList());
    }
    ((List)_myOperations.get("syncDepts")).add(localOperationDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.services.SyncDeptSrvSoapBindingSkeleton
 * JD-Core Version:    0.7.0.1
 */