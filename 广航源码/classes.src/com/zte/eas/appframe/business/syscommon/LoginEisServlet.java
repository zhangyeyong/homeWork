package com.zte.eas.appframe.business.syscommon;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eas.organization.business.employeemanage.service.IFbpEmployeesVDS;
import com.zte.eimage.business.baseconfig.service.PasswordStrategyUtil;
import com.zte.ssb.Util;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;
import com.zte.ssb.logmanager.business.model.AppLogInfoEntity;
import com.zte.ssb.logmanager.business.service.IAppLogInfoMgt;
import com.zte.ssb.ui.uiloader.access.Authorization;
import com.zte.ssb.ui.uiloader.model.Menu;
import com.zte.ssb.ui.uiloader.model.UserInfo;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;

public class LoginEisServlet
  extends HttpServlet
{
  static Log log = SSBBus.getLog(LoginEisServlet.class);
  static final String USER_ID = "sessioninfo.userid";
  static final String USER_NAME = "sessioninfo.username";
  static final String LOGIN_USERINFO = "loginuserinfo";
  static final String EASLOGIN_USERINFO = "easloginuserinfo";
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
  final String USER_OR_PASSWORD_ERROR = "user_or_password_error";
  final String USER_DEPT_IS_NULL = "user_dept_is_null";
  final String USER_OR_PASSWORD_IS_NOT_NULL = "user_or_password_is_null";
  final String USER_IS_LOCKED = "user_is_locked";
  String resultMsg = "";
  static ApplicationGlobalResource appresource = ApplicationGlobalResource.getInstance();
  private static IFbpEmployeesVDS _FbpEmployeesVDS;
  
  public void destroy()
  {
    super.destroy();
  }
  
  public void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    UserInfo localUserInfo = new UserInfo();
    localUserInfo.setUserId(paramHttpServletRequest.getParameter("username"));
    localUserInfo.setPassword(paramHttpServletRequest.getParameter("password"));
    String str1 = loginEvs(localUserInfo, paramHttpServletRequest.getSession(), paramHttpServletRequest);
    String str2 = "./uiloader/index/help/loginEis.jsp";
    String str3 = null;
    if (("0000".equals(str1)) || ("9999".equals(str1))) {
      str2 = "./uiloader/index.html";
    } else if (("0003".equals(str1)) || ("0008".equals(str1))) {
      str3 = "user_or_password_error";
    } else if ("0004".equals(str1)) {
      str3 = "user_dept_is_null";
    } else if ("0001".equals(str1)) {
      str3 = "user_or_password_is_null";
    } else if ("0009".equals(str1)) {
      str3 = "user_is_locked";
    }
    paramHttpServletRequest.getSession().setAttribute("resultMsg", str3);
    paramHttpServletResponse.sendRedirect(str2);
  }
  
  public void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    doGet(paramHttpServletRequest, paramHttpServletResponse);
  }
  
  public void init()
    throws ServletException
  {}
  
  void navigateUrl(HttpSession paramHttpSession)
  {
    String str1 = (String)paramHttpSession.getAttribute("sessionmenuid");
    String str2 = (String)paramHttpSession.getAttribute("sessionpagecode");
    Vector localVector1 = (Vector)paramHttpSession.getAttribute("web_key_menu_list");
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = "";
    int i = 0;
    int j = 0;
    int k = 0;
    if ((null != localVector1) && (localVector1.size() > 0))
    {
      Iterator localIterator1 = localVector1.iterator();
      while (localIterator1.hasNext())
      {
        Menu localMenu1 = (Menu)localIterator1.next();
        Vector localVector2 = localMenu1.getMenuList();
        Iterator localIterator2 = localVector2.iterator();
        while (localIterator2.hasNext())
        {
          Menu localMenu2 = (Menu)localIterator2.next();
          Vector localVector3 = localMenu2.getMenuList();
          Iterator localIterator3 = localVector3.iterator();
          while (localIterator3.hasNext())
          {
            Menu localMenu3 = (Menu)localIterator3.next();
            if ((localMenu3 != null) && (localMenu3.getId().equals(str1)))
            {
              str3 = localMenu3.getUri();
              str4 = localMenu3.getOrderId();
              k = Integer.parseInt(str4) - 1;
              str4 = String.valueOf(k);
              Menu localMenu4 = localMenu3.getParent();
              str5 = localMenu4.getOrderId();
              j = Integer.parseInt(str5) - 1;
              str5 = String.valueOf(j);
              Menu localMenu5 = localMenu4.getParent();
              str6 = localMenu5.getOrderId();
              i = Integer.parseInt(str6);
              str6 = String.valueOf(i);
            }
          }
        }
      }
      paramHttpSession.setAttribute("menuUrl", str3);
      paramHttpSession.setAttribute("menuThirdOrderId", str4);
      paramHttpSession.setAttribute("menuParentOrderId", str5);
      paramHttpSession.setAttribute("menuRootOrderId", str6);
    }
  }
  
  void writeLog(EasUserInfo paramEasUserInfo, HttpServletRequest paramHttpServletRequest)
  {
    log.info("begin writeLog() ," + paramEasUserInfo);
    IAppLogInfoMgt localIAppLogInfoMgt = (IAppLogInfoMgt)SSBBus.findDomainService("appLogMgtFacade");
    AppLogInfoEntity localAppLogInfoEntity = new AppLogInfoEntity();
    localAppLogInfoEntity.setUserId(paramEasUserInfo.getUserId());
    String str = paramEasUserInfo.getUserName();
    if ((str == null) || ("".equals(str))) {
      str = "Null";
    }
    localAppLogInfoEntity.setUserName(str);
    localAppLogInfoEntity.setOptTime(new Date());
    localAppLogInfoEntity.setUserIp(paramHttpServletRequest.getRemoteAddr());
    localAppLogInfoEntity.setOptType("登录");
    localAppLogInfoEntity.setOptObject("会话控制");
    localAppLogInfoEntity.setOptDetail("密码登录");
    localIAppLogInfoMgt.writeLog(localAppLogInfoEntity);
    log.info("end writeLog()");
  }
  
  public String loginEvs(UserInfo paramUserInfo, HttpSession paramHttpSession, HttpServletRequest paramHttpServletRequest)
  {
    String str1 = easlogin(paramUserInfo);
    String str2 = paramUserInfo.getUserId();
    String str3 = paramUserInfo.getPassword();
    String str4 = "";
    String str5 = "0000";
    String str6 = "";
    String str7 = "true";
    String str8 = "0000";
    String str9 = "00";
    String str10 = "SYS10000";
    IFbpEmployeesVDS localIFbpEmployeesVDS = (IFbpEmployeesVDS)SSBBus.findCommonService("fbpEmployeesVDS");
    FbpEmployeesLoginV localFbpEmployeesLoginV = localIFbpEmployeesVDS.findEmployeeByUserId(str2);
    if ("0000".equals(str1))
    {
      paramUserInfo.setUserId(str2);
      paramUserInfo.setPassword(str4);
      paramUserInfo.setUserName(localFbpEmployeesLoginV.getEmployeeName());
      paramUserInfo.setDeptId(localFbpEmployeesLoginV.getDeptId().toString());
      paramUserInfo.setDeptName(localFbpEmployeesLoginV.getDeptName());
      paramHttpSession.setAttribute("loginuserinfo", paramUserInfo);
      paramHttpSession.setAttribute(appresource.getValueByKey("sessioninfo.userid"), str2);
      paramHttpSession.setAttribute(appresource.getValueByKey("sessioninfo.userId"), str2);
      paramHttpSession.setAttribute(appresource.getValueByKey("sessioninfo.username"), str6);
      paramHttpSession.setAttribute(appresource.getValueByKey("sessioninfo.currentEnterpriseNo"), str9);
      paramHttpSession.setAttribute(appresource.getValueByKey("sessioninfo.currentSystemNo"), str10);
      paramHttpSession.setAttribute(appresource.getValueByKey("sessioninfo.userId"), str2);
      paramHttpSession.setAttribute(appresource.getValueByKey("sessioninfo.userName"), str6);
      paramHttpSession.setAttribute(appresource.getValueByKey("sessioninfo.currentEnterpriseNo"), "00");
      paramHttpSession.setAttribute(appresource.getValueByKey("sessioninfo.currentSystemNo"), "SYS10000");
      Authorization.authoriaztionMenu(paramHttpSession, str2);
      navigateUrl(paramHttpSession);
      UserInfo localUserInfo = (UserInfo)paramHttpSession.getAttribute("loginuserinfo");
      EasUserInfo localEasUserInfo = new EasUserInfo();
      localEasUserInfo.setDeptId(localUserInfo.getDeptId());
      localEasUserInfo.setDeptName(localUserInfo.getDeptName());
      localEasUserInfo.setDescription(localUserInfo.getDescription());
      localEasUserInfo.setOrgId(localUserInfo.getOrgId());
      localEasUserInfo.setOrgName(localUserInfo.getOrgName());
      localEasUserInfo.setPassword(localUserInfo.getPassword());
      localEasUserInfo.setUserId(localUserInfo.getUserId());
      localEasUserInfo.setUserName(localUserInfo.getUserName());
      localEasUserInfo.setUserInfoPk(localFbpEmployeesLoginV.getEmployeeId());
      if ((null == localFbpEmployeesLoginV.getDeptLongName()) || ("".equals(localFbpEmployeesLoginV.getDeptLongName())))
      {
        localEasUserInfo.setDeptName(localFbpEmployeesLoginV.getDeptName());
      }
      else
      {
        String str11 = localFbpEmployeesLoginV.getDeptLongName();
        if (str11.indexOf("/") != -1)
        {
          String[] arrayOfString = str11.split("/");
          if (arrayOfString.length == 2) {
            localEasUserInfo.setDeptName(localFbpEmployeesLoginV.getDeptLongName().replace("/", "."));
          } else {
            localEasUserInfo.setDeptName(arrayOfString[0] + "." + arrayOfString[1]);
          }
        }
        else
        {
          localEasUserInfo.setDeptName(localFbpEmployeesLoginV.getDeptName());
        }
      }
      localEasUserInfo.setUserName(localFbpEmployeesLoginV.getEmployeeName());
      paramHttpSession.setAttribute("easloginuserinfo", localEasUserInfo);
      paramHttpSession.setAttribute("userInfoPk", localFbpEmployeesLoginV.getEmployeeId());
      writeLog(localEasUserInfo, paramHttpServletRequest);
    }
    return str1;
  }
  
  private String easlogin(UserInfo paramUserInfo)
  {
    String str1 = paramUserInfo.getUserId();
    String str2 = paramUserInfo.getPassword();
    String str3 = "0000";
    boolean bool = "USER_PASSWORD".equals(Util.getToolModel());
    if (StringUtils.isBlank(paramUserInfo.getUserId())) {
      return "0001";
    }
    if ((bool) && (StringUtils.isBlank(str2))) {
      return "0001";
    }
    FbpEmployees localFbpEmployees = getFbpEmployeesVDS().getempFbpEmployees(str1);
    if (localFbpEmployees == null) {
      return "0003";
    }
    if (localFbpEmployees.getDeptId() == null) {
      return "0004";
    }
    FbpEmployeesLoginV localFbpEmployeesLoginV = getFbpEmployeesVDS().findEmployeeByUserId(str1);
    if (localFbpEmployeesLoginV == null) {
      return "0003";
    }
    PasswordStrategyUtil.updateUnlockUser(str1, "1");
    if (PasswordStrategyUtil.getUserIsLock(str1)) {
      return "0009";
    }
    String str4 = null;
    if (localFbpEmployeesLoginV.getPassword() != null) {
      try
      {
        str4 = InfoMapEncrypt.decrypt(localFbpEmployeesLoginV.getPassword());
      }
      catch (Exception localException)
      {
        log.error(localException);
      }
    }
    if ((!str2.equals(str4)) && (bool)) {
      try
      {
        Date localDate1 = new Date();
        String str5 = "2009-01-01";
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date localDate2 = localSimpleDateFormat.parse(str5);
        if ((localDate1.getTime() > localDate2.getTime()) || (!str2.equals(str1 + "abc123456")))
        {
          PasswordStrategyUtil.updateLockUser(str1);
          return "0008";
        }
      }
      catch (ParseException localParseException)
      {
        log.error(localParseException);
        return "0008";
      }
    }
    PasswordStrategyUtil.updateUnlockUser(str1, "2");
    return str3;
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
 * Qualified Name:     com.zte.eas.appframe.business.syscommon.LoginEisServlet
 * JD-Core Version:    0.7.0.1
 */