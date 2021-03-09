package com.zte.evs.ebill.common;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesVDAO;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import javax.servlet.http.HttpSession;

public class EvsObjectUtils
{
  private IFbpEmployeesVDAO fbpEmployeesVDAO;
  public static final String EVS_LOGIN_USERINFO = "easloginuserinfo";
  static final String NOCREDIT = "没有对应的等级";
  
  public static EasUserInfo getUserInfoBySession()
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    if (localRIAContext == null) {
      return null;
    }
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
  
  public HttpSession getUserInfoSession()
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    return localISession.getHttpSession();
  }
  
  public static void main(String[] paramArrayOfString) {}
  
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
 * Qualified Name:     com.zte.evs.ebill.common.EvsObjectUtils
 * JD-Core Version:    0.7.0.1
 */