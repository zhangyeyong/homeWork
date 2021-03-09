package com.zte.web.service.mergeBoeSrv.service;

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

public class MergeBoeSrvSoapBindingSkeleton
  implements MergeBoeSrv, Skeleton
{
  private MergeBoeSrv impl;
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
  
  public MergeBoeSrvSoapBindingSkeleton()
  {
    this.impl = new MergeBoeSrvSoapBindingImpl();
  }
  
  public MergeBoeSrvSoapBindingSkeleton(MergeBoeSrv paramMergeBoeSrv)
  {
    this.impl = paramMergeBoeSrv;
  }
  
  public MergeBoeResponse mergeBoeSrv(MergeBoeRequest paramMergeBoeRequest)
    throws RemoteException
  {
    MergeBoeResponse localMergeBoeResponse = this.impl.mergeBoeSrv(paramMergeBoeRequest);
    return localMergeBoeResponse;
  }
  
  static
  {
    ParameterDesc[] arrayOfParameterDesc = { new ParameterDesc(new QName("http://127.0.0.1/deppon", "req"), 1, new QName("impl:MergeBoeRequest", "MergeBoeRequest"), MergeBoeRequest.class, false, false) };
    OperationDesc localOperationDesc = new OperationDesc("mergeBoeSrv", arrayOfParameterDesc, new QName("http://127.0.0.1/deppon", "mergeBoeSrvReturn"));
    localOperationDesc.setReturnType(new QName("impl:MergeBoeResponse", "MergeBoeResponse"));
    localOperationDesc.setElementQName(new QName("", "mergeBoeSrv"));
    localOperationDesc.setSoapAction("");
    _myOperationsList.add(localOperationDesc);
    if (_myOperations.get("mergeBoeSrv") == null) {
      _myOperations.put("mergeBoeSrv", new ArrayList());
    }
    ((List)_myOperations.get("mergeBoeSrv")).add(localOperationDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.mergeBoeSrv.service.MergeBoeSrvSoapBindingSkeleton
 * JD-Core Version:    0.7.0.1
 */