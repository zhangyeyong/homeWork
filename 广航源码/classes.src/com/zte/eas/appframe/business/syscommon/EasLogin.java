package com.zte.eas.appframe.business.syscommon;

import com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV;
import com.zte.eas.organization.business.employeemanage.service.IFbpEmployeesVDS;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.ssb.ui.uiloader.model.UserInfo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EasLogin
  extends HttpServlet
{
  private final String USER_ID = "10000";
  private static IFbpEmployeesVDS _FbpEmployeesVDS;
  private final String INDEX_PAGE = "./uiloader/index.html";
  private final String IMAGE_URL = "apps/eimage/common/imageDisplay.jsp?imageNumber=";
  protected Log log = SSBBus.getLog(getClass());
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    HttpServletRequest localHttpServletRequest = paramHttpServletRequest;
    HttpSession localHttpSession = localHttpServletRequest.getSession();
    String str1 = paramHttpServletRequest.getParameter("imageNumber");
    this.log.error("req.getParameter(imageNumber):  " + paramHttpServletRequest.getParameter("imageNumber"));
    if ((str1 == null) || (str1.trim().length() == 0))
    {
      getClass();
      paramHttpServletResponse.sendRedirect("./uiloader/index.html");
      return;
    }
    getClass();
    String str2 = "apps/eimage/common/imageDisplay.jsp?imageNumber=" + str1;
    UserInfo localUserInfo1 = new UserInfo();
    localUserInfo1.setUserId("10000");
    UserInfo localUserInfo2 = (UserInfo)localHttpSession.getAttribute("loginuserinfo");
    if (null != localUserInfo2)
    {
      paramHttpServletResponse.sendRedirect(str2);
      return;
    }
    FbpEmployeesLoginV localFbpEmployeesLoginV = getFbpEmployeesVDS().findEmployeeByUserId("10000");
    if ((localFbpEmployeesLoginV == null) || (localFbpEmployeesLoginV.getEmployeeId() == null))
    {
      getClass();
      paramHttpServletResponse.sendRedirect("./uiloader/index.html");
    }
    else
    {
      EasLoginUtil.afterLoginSuccess(localUserInfo1, localFbpEmployeesLoginV, localHttpSession, localRIAContext.getRequest());
      paramHttpServletResponse.sendRedirect(str2);
    }
  }
  
  protected void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    doGet(paramHttpServletRequest, paramHttpServletResponse);
  }
  
  protected static synchronized IFbpEmployeesVDS getFbpEmployeesVDS()
  {
    if (_FbpEmployeesVDS == null) {
      _FbpEmployeesVDS = (IFbpEmployeesVDS)SSBBus.findCommonService("fbpEmployeesVDS");
    }
    return _FbpEmployeesVDS;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.syscommon.EasLogin
 * JD-Core Version:    0.7.0.1
 */