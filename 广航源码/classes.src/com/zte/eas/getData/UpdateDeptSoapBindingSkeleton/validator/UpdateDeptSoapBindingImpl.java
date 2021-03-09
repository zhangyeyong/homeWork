package com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.validator;

import com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.model.EmployeeDeptCollection;
import com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.model.MessageCollection;
import com.zte.ssb.framework.SSBBus;
import java.rmi.RemoteException;

public class UpdateDeptSoapBindingImpl
  implements UpdateEmployeeDeptValidatorImpl
{
  private UpdateEmployeeDeptValidator updateEmployeeDeptValidator;
  
  public UpdateEmployeeDeptValidator getUpdateEmployeeDeptValidator()
  {
    return this.updateEmployeeDeptValidator;
  }
  
  public void setUpdateEmployeeDeptValidator(UpdateEmployeeDeptValidator paramUpdateEmployeeDeptValidator)
  {
    this.updateEmployeeDeptValidator = paramUpdateEmployeeDeptValidator;
  }
  
  public MessageCollection updateEmployeeDept(EmployeeDeptCollection paramEmployeeDeptCollection)
    throws RemoteException
  {
    UpdateEmployeeDeptValidator localUpdateEmployeeDeptValidator = (UpdateEmployeeDeptValidator)SSBBus.findDomainService("updateEmployeeDeptValidator");
    return localUpdateEmployeeDeptValidator.updateDept(paramEmployeeDeptCollection);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.validator.UpdateDeptSoapBindingImpl
 * JD-Core Version:    0.7.0.1
 */