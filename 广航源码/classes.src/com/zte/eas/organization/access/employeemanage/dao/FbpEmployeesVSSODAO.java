package com.zte.eas.organization.access.employeemanage.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.ssb.orm.zorm.ZormTemplate;
import java.util.List;

public class FbpEmployeesVSSODAO
  extends FbpEmployeesVDAO
{
  public FbpEmployeesV findEmployeesVByOaAddress(String paramString)
  {
    List localList = super.getZormTemplate().find("from FbpEmployeesV v where v.oaAddress=?", paramString);
    if ((null != localList) && (localList.size() > 0)) {
      return (FbpEmployeesV)localList.get(0);
    }
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.employeemanage.dao.FbpEmployeesVSSODAO
 * JD-Core Version:    0.7.0.1
 */