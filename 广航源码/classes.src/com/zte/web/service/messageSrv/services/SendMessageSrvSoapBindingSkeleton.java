package com.zte.web.service.messageSrv.services;

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

public class SendMessageSrvSoapBindingSkeleton
  implements SendMessageSrv, Skeleton
{
  private SendMessageSrv impl;
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
  
  public SendMessageSrvSoapBindingSkeleton()
  {
    this.impl = new SendMessageSrvSoapBindingImpl();
  }
  
  public SendMessageSrvSoapBindingSkeleton(SendMessageSrv paramSendMessageSrv)
  {
    this.impl = paramSendMessageSrv;
  }
  
  public SendMessageSrvResponse[] process(SendMessageSrvRequest[] paramArrayOfSendMessageSrvRequest)
    throws RemoteException
  {
    SendMessageSrvResponse[] arrayOfSendMessageSrvResponse = this.impl.process(paramArrayOfSendMessageSrvRequest);
    return arrayOfSendMessageSrvResponse;
  }
  
  static
  {
    ParameterDesc[] arrayOfParameterDesc = { new ParameterDesc(new QName("http://messageSrv.service.web.zte.com", "requestArr"), 1, new QName("http://messageSrv.service.web.zte.com", ">requestArr"), [Lcom.zte.web.service.messageSrv.services.SendMessageSrvRequest.class, false, false) };
    OperationDesc localOperationDesc = new OperationDesc("process", arrayOfParameterDesc, new QName("http://eis.haier.com/services/sendMessageSrv", "processReturn"));
    localOperationDesc.setReturnType(new QName("http://eis.haier.com/services/sendMessageSrv", ">processReturn"));
    localOperationDesc.setElementQName(new QName("", "process"));
    localOperationDesc.setSoapAction("");
    _myOperationsList.add(localOperationDesc);
    if (_myOperations.get("process") == null) {
      _myOperations.put("process", new ArrayList());
    }
    ((List)_myOperations.get("process")).add(localOperationDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.messageSrv.services.SendMessageSrvSoapBindingSkeleton
 * JD-Core Version:    0.7.0.1
 */