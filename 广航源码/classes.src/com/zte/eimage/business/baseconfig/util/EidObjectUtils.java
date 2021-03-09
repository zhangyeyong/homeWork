package com.zte.eimage.business.baseconfig.util;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesVDAO;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class EidObjectUtils
  extends BaseDAO
{
  private IFbpEmployeesVDAO fbpEmployeesVDAO;
  static final String EVS_LOGIN_USERINFO = "easloginuserinfo";
  static final String NOCREDIT = "没有对应的等级";
  
  public EasUserInfo getUserInfoBySession()
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    return localEasUserInfo;
  }
  
  public FbpEmployeesV getEmployeeBySession()
  {
    FbpEmployeesV localFbpEmployeesV = new FbpEmployeesV();
    String str = getUserInfoBySession().getUserId();
    if ((str != null) && (!"".equals(str)))
    {
      localFbpEmployeesV = this.fbpEmployeesVDAO.findEmployeesByNumber(str);
      if ((localFbpEmployeesV != null) && (localFbpEmployeesV.getGradeName() == null)) {
        localFbpEmployeesV.setGradeName("没有对应的等级");
      }
    }
    return localFbpEmployeesV;
  }
  
  public List<String> getCheckUnit(String paramString)
  {
    Object localObject = new ArrayList();
    try
    {
      Long localLong = Long.valueOf(Long.parseLong(getEmployeeBySession().getEmployeeId().toString()));
      if ((localLong != null) && (!localLong.equals("")))
      {
        String str = "SELECT DISTINCT fd.default_check_unit AS check_unit FROM fbp_depts fd WHERE fd.dept_code in (SELECT pse.determiner FROM fbp_pos_stru_elements pse WHERE pse.pos_structure_code = '" + paramString + "' AND pse.enabled_flag = 'Y'" + " START WITH EXISTS (SELECT fph.pos_stru_element_id FROM fbp_pse_holders fph" + " WHERE fph.employee_id = " + localLong + " AND fph.enabled_flag = 'Y'" + " AND pse.pos_stru_element_id = fph.pos_stru_element_id)" + " CONNECT BY PRIOR pse.pos_stru_element_id = pse.parent_pos_stru_element_id)";
        localObject = super.getSession().createSQLQuery(str).list();
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    return localObject;
  }
  
  public List<String> getCheckUnit(String paramString1, String paramString2)
  {
    Object localObject = new ArrayList();
    try
    {
      Long localLong = Long.valueOf(Long.parseLong(getEmployeeBySession().getEmployeeId().toString()));
      if ((localLong != null) && (!localLong.equals("")))
      {
        String str = "SELECT DISTINCT fd.default_check_unit AS check_unit FROM fbp_depts fd WHERE fd.dept_code IN (SELECT pse.determiner FROM fbp_pos_stru_elements pse WHERE pse.pos_structure_code = '" + paramString1 + "' AND pse.enabled_flag = 'Y'" + " START WITH EXISTS" + " (SELECT fph.pos_stru_element_id FROM fbp_pse_holders fph" + " WHERE fph.employee_id = " + localLong + " AND fph.enabled_flag = 'Y'" + " AND fph.pos_stru_element_id = pse.pos_stru_element_id)" + " CONNECT BY PRIOR" + " pse.pos_stru_element_id = pse.parent_pos_stru_element_id)";
        if (!Util.isStrEmpty(paramString2)) {
          str = str + " And EXISTS (SELECT d.dept_code from fbp_depts d WHERE d.default_check_unit = '" + paramString2 + "' AND d.dept_code = fd.dept_code)";
        }
        localObject = super.getSession().createSQLQuery(str).list();
      }
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    return localObject;
  }
  
  public IFbpEmployeesVDAO getFbpEmployeesVDAO()
  {
    return this.fbpEmployeesVDAO;
  }
  
  public void setFbpEmployeesVDAO(IFbpEmployeesVDAO paramIFbpEmployeesVDAO)
  {
    this.fbpEmployeesVDAO = paramIFbpEmployeesVDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.util.EidObjectUtils
 * JD-Core Version:    0.7.0.1
 */