package com.zte.web.service.appraiseImageSrv;

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

public class EidImageHistoryServiceSoapBindingSkeleton
  implements EvsAppraiseHistorisesDS, Skeleton
{
  private EvsAppraiseHistorisesDS impl;
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
  
  public EidImageHistoryServiceSoapBindingSkeleton()
  {
    this.impl = new EidImageHistoryServiceSoapBindingImpl();
  }
  
  public EidImageHistoryServiceSoapBindingSkeleton(EvsAppraiseHistorisesDS paramEvsAppraiseHistorisesDS)
  {
    this.impl = paramEvsAppraiseHistorisesDS;
  }
  
  public EidAppraiseHistories[] findHistoryByImageInfoId(String paramString)
    throws RemoteException
  {
    EidAppraiseHistories[] arrayOfEidAppraiseHistories = this.impl.findHistoryByImageInfoId(paramString);
    return arrayOfEidAppraiseHistories;
  }
  
  public String remarkVideo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws RemoteException
  {
    String str = this.impl.remarkVideo(paramString1, paramString2, paramString3, paramString4, paramString5);
    return str;
  }
  
  static
  {
    ParameterDesc[] arrayOfParameterDesc = { new ParameterDesc(new QName("", "imageNumber"), 1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false) };
    OperationDesc localOperationDesc = new OperationDesc("findHistoryByImageInfoId", arrayOfParameterDesc, new QName("", "findHistoryByImageInfoIdReturn"));
    localOperationDesc.setReturnType(new QName("http://localhost:8080/EBILL_HAIER/services/EidImageHistoryService", "ArrayOf_tns1_EidAppraiseHistories"));
    localOperationDesc.setElementQName(new QName("http://service.baseconfig.business.eimage.zte.com", "findHistoryByImageInfoId"));
    localOperationDesc.setSoapAction("");
    _myOperationsList.add(localOperationDesc);
    if (_myOperations.get("findHistoryByImageInfoId") == null) {
      _myOperations.put("findHistoryByImageInfoId", new ArrayList());
    }
    ((List)_myOperations.get("findHistoryByImageInfoId")).add(localOperationDesc);
    arrayOfParameterDesc = new ParameterDesc[] { new ParameterDesc(new QName("", "boeNum"), 1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false), new ParameterDesc(new QName("", "actKind"), 1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false), new ParameterDesc(new QName("", "problem"), 1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false), new ParameterDesc(new QName("", "des"), 1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false), new ParameterDesc(new QName("", "employeeNum"), 1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false) };
    localOperationDesc = new OperationDesc("remarkVideo", arrayOfParameterDesc, new QName("", "remarkVideoReturn"));
    localOperationDesc.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localOperationDesc.setElementQName(new QName("http://service.baseconfig.business.eimage.zte.com", "remarkVideo"));
    localOperationDesc.setSoapAction("");
    _myOperationsList.add(localOperationDesc);
    if (_myOperations.get("remarkVideo") == null) {
      _myOperations.put("remarkVideo", new ArrayList());
    }
    ((List)_myOperations.get("remarkVideo")).add(localOperationDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.appraiseImageSrv.EidImageHistoryServiceSoapBindingSkeleton
 * JD-Core Version:    0.7.0.1
 */