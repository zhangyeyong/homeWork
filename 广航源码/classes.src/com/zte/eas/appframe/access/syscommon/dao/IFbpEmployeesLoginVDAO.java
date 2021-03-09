package com.zte.eas.appframe.access.syscommon.dao;

import com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV;
import com.zte.ssb.framework.base.DAO;

public abstract interface IFbpEmployeesLoginVDAO
  extends DAO
{
  public abstract FbpEmployeesLoginV findEmployeeByUserId(String paramString);
  
  public abstract FbpEmployeesLoginV findEmployeeByUser(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.syscommon.dao.IFbpEmployeesLoginVDAO
 * JD-Core Version:    0.7.0.1
 */