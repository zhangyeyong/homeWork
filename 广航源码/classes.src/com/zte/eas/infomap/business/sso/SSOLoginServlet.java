package com.zte.eas.infomap.business.sso;

import com.zte.eas.appframe.business.syscommon.EasLoginUtil;
import com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesSsologinV;
import com.zte.eas.organization.business.employeemanage.service.IFbpEmployeesVDS;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;
import com.zte.ssb.servicecontainer.business.server.IRIAContextFactory;
import com.zte.ssb.servicecontainer.business.server.RIAConfiguration;
import com.zte.ssb.ui.uiloader.model.UserInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;

public class SSOLoginServlet
  extends HttpServlet
{
  private static final long serialVersionUID = -2600814107825130493L;
  private RIAConfiguration configuration;
  static Log log = SSBBus.getLog(SSOLoginServlet.class);
  static final String USER_ID = "sessioninfo.userid";
  static final String USER_NAME = "sessioninfo.username";
  static final String LOGIN_USERINFO = "loginuserinfo";
  static final String EASLOGIN_USERINFO = "easloginuserinfo";
  static final String WEB_LOCAL_LANGUAGE = "web_local_language";
  static final String LOGININFO_ISHTTPSLOGIN = "loginInfo.isHttpsLogin";
  static final String SESSIONINFO_USERID = "sessioninfo.userId";
  static final String SESSIONINFO_USERPK = "userInfoPk";
  static final String SESSIONINFO_CURRENT_ENTERPRISE_NO = "sessioninfo.currentEnterpriseNo";
  static final String SESSIONINFO_CURRENT_SYSTEM_NO = "sessioninfo.currentSystemNo";
  static final String SESSION_MENU_ID = "sessionmenuid";
  static final String SESSION_PAGECODE = "sessionpagecode";
  static final String MENU_URL = "menuUrl";
  static final String MENU_THIRD_ORDER_ID = "menuThirdOrderId";
  static final String MENU_PARENT_ORDER_ID = "menuParentOrderId";
  static final String MENU_ROOT_ORDER_ID = "menuRootOrderId";
  static final String LOGIN_ID = "loginId";
  static ApplicationGlobalResource appresource = ApplicationGlobalResource.getInstance();
  static IFbpEmployeesVDS fbpEmployeesVDS;
  
  public void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    IRIAContextFactory localIRIAContextFactory = this.configuration.getRiaContextFactory();
    localIRIAContextFactory.getRIAContext(getServletContext(), paramHttpServletRequest, paramHttpServletResponse);
    String str1 = "./uiloader/login.html";
    UserInfo localUserInfo = new UserInfo();
    HttpSession localHttpSession = paramHttpServletRequest.getSession();
    String str2 = (String)localHttpSession.getAttribute("userId");
    if (StringUtils.isEmpty(str2)) {
      str2 = paramHttpServletRequest.getParameter("userId");
    }
    if (StringUtils.isEmpty(str2))
    {
      printMst(paramHttpServletResponse, "用户名不能为空!", str1);
      return;
    }
    localUserInfo.setUserId(str2);
    String str3 = login(localUserInfo, localHttpSession, paramHttpServletRequest);
    if (("0000".equals(str3)) || ("9999".equals(str3)))
    {
      str1 = "./uiloader/index.html";
      paramHttpServletResponse.sendRedirect(str1);
    }
    else
    {
      printMst(paramHttpServletResponse, "用户名[" + str2 + "不存在]", str1);
      return;
    }
  }
  
  void printMst(HttpServletResponse paramHttpServletResponse, String paramString1, String paramString2)
    throws IOException
  {
    paramHttpServletResponse.setContentType("text/html;charset=UTF-8");
    String str = "<script language='javascript'>alert('#msg#');window.location.href='" + paramString2 + "';</script>";
    str = str.replace("#msg#", paramString1);
    paramHttpServletResponse.getWriter().write(str);
  }
  
  public void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    doGet(paramHttpServletRequest, paramHttpServletResponse);
  }
  
  public void init()
    throws ServletException
  {
    try
    {
      InputStream localInputStream = SSOLoginServlet.class.getClassLoader().getResourceAsStream("ria-config.config");
      this.configuration = new RIAConfiguration(localInputStream);
      localInputStream.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  String login(UserInfo paramUserInfo, HttpSession paramHttpSession, HttpServletRequest paramHttpServletRequest)
  {
    if (StringUtils.isBlank(paramUserInfo.getUserId())) {
      return "0001";
    }
    UserInfo localUserInfo = (UserInfo)paramHttpSession.getAttribute("loginuserinfo");
    if ((null != localUserInfo) && (!paramUserInfo.getUserId().equals(localUserInfo.getUserId()))) {
      return "0005";
    }
    if (fbpEmployeesVDS == null) {
      fbpEmployeesVDS = (IFbpEmployeesVDS)SSBBus.findDomainService("fbpEmployeesVDS");
    }
    FbpEmployeesSsologinV localFbpEmployeesSsologinV = fbpEmployeesVDS.getEmployeesSsologinV(paramUserInfo.getUserId());
    FbpEmployeesLoginV localFbpEmployeesLoginV = null;
    if (localFbpEmployeesSsologinV != null) {
      try
      {
        localFbpEmployeesLoginV = new FbpEmployeesLoginV();
        localFbpEmployeesLoginV.setEmployeeId(BigInteger.valueOf(localFbpEmployeesSsologinV.getEmployeeId().longValue()));
        localFbpEmployeesLoginV.setEmployeeNumber(localFbpEmployeesSsologinV.getEmployeeNumber());
        localFbpEmployeesLoginV.setEmployeeName(localFbpEmployeesSsologinV.getEmployeeName());
        localFbpEmployeesLoginV.setDeptId(BigInteger.valueOf(localFbpEmployeesSsologinV.getDeptId().longValue()));
        localFbpEmployeesLoginV.setDeptName(localFbpEmployeesSsologinV.getDeptName());
        localFbpEmployeesLoginV.setDeptLongName(localFbpEmployeesSsologinV.getDeptLongName());
      }
      catch (Exception localException)
      {
        localFbpEmployeesLoginV = null;
      }
    }
    if (localFbpEmployeesLoginV == null) {
      return "0003";
    }
    EasLoginUtil.afterLoginSuccess(paramUserInfo, localFbpEmployeesLoginV, paramHttpSession, paramHttpServletRequest);
    return "0000";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.sso.SSOLoginServlet
 * JD-Core Version:    0.7.0.1
 */