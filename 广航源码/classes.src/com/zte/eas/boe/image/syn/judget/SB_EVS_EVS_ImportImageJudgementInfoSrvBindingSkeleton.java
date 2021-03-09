package com.zte.eas.boe.image.syn.judget;

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

public class SB_EVS_EVS_ImportImageJudgementInfoSrvBindingSkeleton
  implements SB_EVS_EVS_ImportImageJudgementInfoSrv_PortType, Skeleton
{
  private SB_EVS_EVS_ImportImageJudgementInfoSrv_PortType impl;
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
  
  public SB_EVS_EVS_ImportImageJudgementInfoSrvBindingSkeleton()
  {
    this.impl = new SB_EVS_EVS_ImportImageJudgementInfoSrvBindingImpl();
  }
  
  public SB_EVS_EVS_ImportImageJudgementInfoSrvBindingSkeleton(SB_EVS_EVS_ImportImageJudgementInfoSrv_PortType paramSB_EVS_EVS_ImportImageJudgementInfoSrv_PortType)
  {
    this.impl = paramSB_EVS_EVS_ImportImageJudgementInfoSrv_PortType;
  }
  
  public ImportSrvResponse process(SB_EVS_EVS_ImportImageJudgementInfoSrvRequest paramSB_EVS_EVS_ImportImageJudgementInfoSrvRequest)
    throws RemoteException
  {
    ImportSrvResponse localImportSrvResponse = this.impl.process(paramSB_EVS_EVS_ImportImageJudgementInfoSrvRequest);
    return localImportSrvResponse;
  }
  
  static
  {
    ParameterDesc[] arrayOfParameterDesc = { new ParameterDesc(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "SB_EVS_EVS_ImportImageJudgementInfoSrvRequest"), 1, new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "SB_EVS_EVS_ImportImageJudgementInfoSrvRequest"), SB_EVS_EVS_ImportImageJudgementInfoSrvRequest.class, false, false) };
    OperationDesc localOperationDesc = new OperationDesc("process", arrayOfParameterDesc, new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "SB_EVS_EVS_ImportImageJudgementInfoSrvResponse"));
    localOperationDesc.setReturnType(new QName("http://mss.cmcc.com/ImportSrvResponse", "ImportSrvResponse"));
    localOperationDesc.setElementQName(new QName("http://mss.cmcc.com/SB_EVS_EVS_ImportImageJudgementInfoSrv", "process"));
    localOperationDesc.setSoapAction("process");
    _myOperationsList.add(localOperationDesc);
    if (_myOperations.get("process") == null) {
      _myOperations.put("process", new ArrayList());
    }
    ((List)_myOperations.get("process")).add(localOperationDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.boe.image.syn.judget.SB_EVS_EVS_ImportImageJudgementInfoSrvBindingSkeleton
 * JD-Core Version:    0.7.0.1
 */