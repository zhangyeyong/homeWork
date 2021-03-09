package com.zte.eas.getData.EmployeeSync.services;

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

public class SyncEmployeeSrvSoapBindingSkeleton
  implements SyncEmployeeSrv, Skeleton
{
  private SyncEmployeeSrv impl;
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
  
  public SyncEmployeeSrvSoapBindingSkeleton()
  {
    this.impl = new SyncEmployeeSrvSoapBindingImpl();
  }
  
  public SyncEmployeeSrvSoapBindingSkeleton(SyncEmployeeSrv paramSyncEmployeeSrv)
  {
    this.impl = paramSyncEmployeeSrv;
  }
  
  public Message[] syncEmployees(Employees[] paramArrayOfEmployees)
    throws RemoteException
  {
    Message[] arrayOfMessage = this.impl.syncEmployees(paramArrayOfEmployees);
    return arrayOfMessage;
  }
  
  static
  {
    ParameterDesc[] arrayOfParameterDesc = { new ParameterDesc(new QName("http://validator.EmployeeSync.getData.eas.zte.com", "employees"), 1, new QName("http://validator.EmployeeSync.getData.eas.zte.com", ">employees"), [Lcom.zte.eas.getData.EmployeeSync.services.Employees.class, false, false) };
    OperationDesc localOperationDesc = new OperationDesc("syncEmployees", arrayOfParameterDesc, new QName("http://www.evs.com/services/syncEmployeeSrv", "syncEmployeesReturn"));
    localOperationDesc.setReturnType(new QName("http://www.evs.com/services/syncEmployeeSrv", ">syncEmployeesReturn"));
    localOperationDesc.setElementQName(new QName("", "syncEmployees"));
    localOperationDesc.setSoapAction("");
    _myOperationsList.add(localOperationDesc);
    if (_myOperations.get("syncEmployees") == null) {
      _myOperations.put("syncEmployees", new ArrayList());
    }
    ((List)_myOperations.get("syncEmployees")).add(localOperationDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.EmployeeSync.services.SyncEmployeeSrvSoapBindingSkeleton
 * JD-Core Version:    0.7.0.1
 */