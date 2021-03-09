package com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.validator;

import com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.model.EmployeeDeptCollection;
import com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.model.MessageCollection;
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

public class UpdateDeptSoapBindingSkeleton
  implements UpdateEmployeeDeptValidatorImpl, Skeleton
{
  private UpdateEmployeeDeptValidatorImpl impl;
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
  
  public UpdateDeptSoapBindingSkeleton()
  {
    this.impl = new UpdateDeptSoapBindingImpl();
  }
  
  public UpdateDeptSoapBindingSkeleton(UpdateEmployeeDeptValidatorImpl paramUpdateEmployeeDeptValidatorImpl)
  {
    this.impl = paramUpdateEmployeeDeptValidatorImpl;
  }
  
  public MessageCollection updateEmployeeDept(EmployeeDeptCollection paramEmployeeDeptCollection)
    throws RemoteException
  {
    MessageCollection localMessageCollection = this.impl.updateEmployeeDept(paramEmployeeDeptCollection);
    return localMessageCollection;
  }
  
  static
  {
    ParameterDesc[] arrayOfParameterDesc = { new ParameterDesc(new QName("http://10.135.6.213:8080/haier/services/updateDept", "employeeDeptList"), 1, new QName("http://model.getdata.eas.zte.com", "EmployeeDeptCollection"), EmployeeDeptCollection.class, false, false) };
    OperationDesc localOperationDesc = new OperationDesc("updateEmployeeDept", arrayOfParameterDesc, new QName("http://10.135.6.213:8080/haier/services/updateDept", "updateEmployeeDeptReturn"));
    localOperationDesc.setReturnType(new QName("http://model.getdata.eas.zte.com", "MessageCollection"));
    localOperationDesc.setElementQName(new QName("", "updateEmployeeDept"));
    localOperationDesc.setSoapAction("");
    _myOperationsList.add(localOperationDesc);
    if (_myOperations.get("updateEmployeeDept") == null) {
      _myOperations.put("updateEmployeeDept", new ArrayList());
    }
    ((List)_myOperations.get("updateEmployeeDept")).add(localOperationDesc);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.validator.UpdateDeptSoapBindingSkeleton
 * JD-Core Version:    0.7.0.1
 */