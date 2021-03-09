package com.zte.eas.flowruleengine.access.posstru.dao;

import com.zte.eas.appframe.business.util.SqlManageUtils;
import com.zte.eas.flowruleengine.business.posstru.model.FbpEmployeesQryV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import java.util.ArrayList;
import java.util.List;

public class FbpEmployeesQryVDAO
  extends BaseDAO
  implements IFbpEmployeesQryVDAO
{
  public List getFbpEmployeesQryVs(FbpEmployeesQryV paramFbpEmployeesQryV)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramFbpEmployeesQryV == null) {
      return new ArrayList();
    }
    String str = "from FbpEmployeesQryV s where s.enabledFlag='Y' ";
    if ((paramFbpEmployeesQryV.getDeptId() != null) && (!paramFbpEmployeesQryV.getDeptId().equals("")))
    {
      str = str + " and s.deptId = ?";
      localArrayList.add(paramFbpEmployeesQryV.getDeptId());
    }
    if ((paramFbpEmployeesQryV.getJobId() != null) && (!paramFbpEmployeesQryV.getJobId().equals("")))
    {
      str = str + " and s.jobId = ?";
      localArrayList.add(paramFbpEmployeesQryV.getJobId());
    }
    if ((paramFbpEmployeesQryV.getEmployeeNumber() != null) && (!paramFbpEmployeesQryV.getEmployeeNumber().equals("")))
    {
      str = str + " and s.employeeNumber like ?";
      localArrayList.add("%" + SqlManageUtils.cleanUpSQL(paramFbpEmployeesQryV.getEmployeeNumber()) + "%");
    }
    if ((paramFbpEmployeesQryV.getEmployeeName() != null) && (!paramFbpEmployeesQryV.getEmployeeName().equals("")))
    {
      str = str + " and s.employeeName  like ?";
      localArrayList.add("%" + SqlManageUtils.cleanUpSQL(paramFbpEmployeesQryV.getEmployeeName()) + "%");
    }
    if ((paramFbpEmployeesQryV.getDeptName() != null) && (!paramFbpEmployeesQryV.getDeptName().equals("")))
    {
      str = str + " and s.deptName like ?";
      localArrayList.add("%" + SqlManageUtils.cleanUpSQL(paramFbpEmployeesQryV.getDeptName()) + "%");
    }
    if ((paramFbpEmployeesQryV.getJobName() != null) && (!paramFbpEmployeesQryV.getJobName().equals("")))
    {
      str = str + " and s.jobName  like ?";
      localArrayList.add("%" + SqlManageUtils.cleanUpSQL(paramFbpEmployeesQryV.getJobName()) + "%");
    }
    List localList = getZormTemplate().find(str, localArrayList.toArray());
    return localList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.access.posstru.dao.FbpEmployeesQryVDAO
 * JD-Core Version:    0.7.0.1
 */