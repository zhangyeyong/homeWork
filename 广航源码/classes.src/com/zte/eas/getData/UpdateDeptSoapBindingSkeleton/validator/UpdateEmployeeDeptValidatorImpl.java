package com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.validator;

import com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.model.EmployeeDeptCollection;
import com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.model.MessageCollection;
import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface UpdateEmployeeDeptValidatorImpl
  extends Remote
{
  public abstract MessageCollection updateEmployeeDept(EmployeeDeptCollection paramEmployeeDeptCollection)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.UpdateDeptSoapBindingSkeleton.validator.UpdateEmployeeDeptValidatorImpl
 * JD-Core Version:    0.7.0.1
 */