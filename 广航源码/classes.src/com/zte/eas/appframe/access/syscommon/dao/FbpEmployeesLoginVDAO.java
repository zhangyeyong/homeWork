package com.zte.eas.appframe.access.syscommon.dao;

import com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.orm.zorm.ZormTemplate;
import java.math.BigInteger;
import java.util.List;

public class FbpEmployeesLoginVDAO
  extends BaseDAO
  implements IFbpEmployeesLoginVDAO
{
  private Log log = SSBBus.getLog(FbpEmployeesLoginVDAO.class);
  
  public FbpEmployeesLoginV findEmployeeByUserId(String paramString)
  {
    this.log.info("begin FbpEmployeesLoginV(), userId=" + paramString);
    List localList = super.getZormTemplate().find("from FbpEmployeesLoginV v where v.employeeNumber=?", paramString);
    if ((null != localList) && (localList.size() > 0))
    {
      this.log.info("end FbpEmployeesLoginV(), return get(0), " + localList.get(0));
      return (FbpEmployeesLoginV)localList.get(0);
    }
    this.log.info("end FbpEmployeesLoginV(), return null");
    return null;
  }
  
  public FbpEmployeesLoginV findEmployeeByUser(String paramString)
  {
    this.log.info("begin FbpEmployeesLoginV(), userId=" + paramString);
    List localList = super.getZormTemplate().find("from FbpEmployeesLoginV v where v.employeeId=?", BigInteger.valueOf(Long.valueOf("".equals(paramString) ? "-1" : paramString).longValue()));
    if ((null != localList) && (localList.size() > 0))
    {
      this.log.info("end FbpEmployeesLoginV(), return get(0), " + localList.get(0));
      return (FbpEmployeesLoginV)localList.get(0);
    }
    this.log.info("end FbpEmployeesLoginV(), return null");
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.syscommon.dao.FbpEmployeesLoginVDAO
 * JD-Core Version:    0.7.0.1
 */