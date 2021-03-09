package com.zte.eas.appframe.business.syscommon;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;
import com.zte.ssb.logmanager.business.model.AppLogInfoEntity;
import com.zte.ssb.logmanager.business.service.IAppLogInfoMgt;
import com.zte.ssb.ssbext.ui.uiloader.AppUiLoaderLocalizer;
import com.zte.ssb.ui.uiloader.access.Authorization;
import com.zte.ssb.ui.uiloader.model.Menu;
import com.zte.ssb.ui.uiloader.model.UserInfo;
import java.math.BigInteger;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;

public class EasLoginUtil
{
  public static final String USER_ID = "sessioninfo.userid";
  public static final String USER_NAME = "sessioninfo.username";
  public static final String LOGIN_USERINFO = "loginuserinfo";
  public static final String EASLOGIN_USERINFO = "easloginuserinfo";
  public static final String WEB_LOCAL_LANGUAGE = "web_local_language";
  public static final String LOGININFO_ISHTTPSLOGIN = "loginInfo.isHttpsLogin";
  public static final String SESSIONINFO_USERID = "sessioninfo.userId";
  public static final String SESSIONINFO_USERNAME = "sessioninfo.userName";
  public static final String SESSIONINFO_USERPK = "userInfoPk";
  public static final String SESSIONINFO_CURRENT_ENTERPRISE_NO = "sessioninfo.currentEnterpriseNo";
  public static final String SESSIONINFO_CURRENT_SYSTEM_NO = "sessioninfo.currentSystemNo";
  public static final String SESSION_MENU_ID = "sessionmenuid";
  public static final String SESSION_PAGECODE = "sessionpagecode";
  public static final String MENU_URL = "menuUrl";
  public static final String MENU_THIRD_ORDER_ID = "menuThirdOrderId";
  public static final String MENU_PARENT_ORDER_ID = "menuParentOrderId";
  public static final String MENU_ROOT_ORDER_ID = "menuRootOrderId";
  public static final String LOGIN_ID = "loginId";
  private static ApplicationGlobalResource appresource = ;
  private static Log log = SSBBus.getLog(EasLoginUtil.class);
  
  public static void afterLoginSuccess(UserInfo paramUserInfo, FbpEmployeesLoginV paramFbpEmployeesLoginV, HttpSession paramHttpSession, HttpServletRequest paramHttpServletRequest)
  {
    String str1 = "00";
    String str2 = "SYS10000";
    paramUserInfo.setPassword("");
    paramUserInfo.setUserName(paramFbpEmployeesLoginV.getEmployeeName());
    paramUserInfo.setDeptId(paramFbpEmployeesLoginV.getDeptId().toString());
    paramUserInfo.setDeptName(paramFbpEmployeesLoginV.getDeptName());
    paramHttpSession.setAttribute("loginuserinfo", paramUserInfo);
    paramHttpSession.setAttribute(appresource.getValueByKey("sessioninfo.userid"), paramUserInfo.getUserId());
    paramHttpSession.setAttribute(appresource.getValueByKey("sessioninfo.username"), paramUserInfo.getUserName());
    paramHttpSession.setAttribute(appresource.getValueByKey("sessioninfo.userId"), paramUserInfo.getUserId());
    paramHttpSession.setAttribute(appresource.getValueByKey("sessioninfo.userName"), paramUserInfo.getUserName());
    paramHttpSession.setAttribute(appresource.getValueByKey("sessioninfo.currentEnterpriseNo"), str1);
    paramHttpSession.setAttribute(appresource.getValueByKey("sessioninfo.currentSystemNo"), str2);
    Authorization.authoriaztionMenu(paramHttpSession, paramUserInfo.getUserId());
    AppUiLoaderLocalizer.localizeUiLoader();
    navigateUrl(paramHttpSession);
    EasUserInfo localEasUserInfo = new EasUserInfo();
    localEasUserInfo.setUserId(paramUserInfo.getUserId());
    localEasUserInfo.setUserName(paramUserInfo.getUserName());
    localEasUserInfo.setPassword(paramUserInfo.getPassword());
    localEasUserInfo.setDeptId(paramUserInfo.getDeptId());
    localEasUserInfo.setDeptName(paramUserInfo.getDeptName());
    localEasUserInfo.setDescription(paramUserInfo.getDescription());
    localEasUserInfo.setOrgId(paramUserInfo.getOrgId());
    localEasUserInfo.setOrgName(paramUserInfo.getOrgName());
    localEasUserInfo.setUserInfoPk(paramFbpEmployeesLoginV.getEmployeeId());
    if (StringUtils.isBlank(paramFbpEmployeesLoginV.getDeptLongName()))
    {
      localEasUserInfo.setDeptName(paramFbpEmployeesLoginV.getDeptName());
    }
    else
    {
      String str3 = paramFbpEmployeesLoginV.getDeptLongName();
      if (str3.indexOf("/") != -1)
      {
        String[] arrayOfString = str3.split("/");
        if (arrayOfString.length == 2) {
          localEasUserInfo.setDeptName(str3.replace("/", "."));
        } else {
          localEasUserInfo.setDeptName(arrayOfString[0] + "." + arrayOfString[1]);
        }
      }
      else
      {
        localEasUserInfo.setDeptName(paramFbpEmployeesLoginV.getDeptName());
      }
    }
    localEasUserInfo.setUserName(paramFbpEmployeesLoginV.getEmployeeName());
    paramHttpSession.setAttribute("easloginuserinfo", localEasUserInfo);
    paramHttpSession.setAttribute("userInfoPk", paramFbpEmployeesLoginV.getEmployeeId());
    writeLog(localEasUserInfo, paramHttpServletRequest);
  }
  
  private static void navigateUrl(HttpSession paramHttpSession)
  {
    Vector localVector1 = (Vector)paramHttpSession.getAttribute("web_key_menu_list");
    if ((localVector1 == null) || (localVector1.isEmpty())) {
      return;
    }
    String str1 = (String)paramHttpSession.getAttribute("sessionmenuid");
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    int i = 0;
    int j = 0;
    int k = 0;
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
            str2 = localMenu3.getUri();
            str3 = localMenu3.getOrderId();
            k = Integer.parseInt(str3) - 1;
            str3 = String.valueOf(k);
            Menu localMenu4 = localMenu3.getParent();
            str4 = localMenu4.getOrderId();
            j = Integer.parseInt(str4) - 1;
            str4 = String.valueOf(j);
            Menu localMenu5 = localMenu4.getParent();
            str5 = localMenu5.getOrderId();
            i = Integer.parseInt(str5);
            str5 = String.valueOf(i);
          }
        }
      }
    }
    paramHttpSession.setAttribute("menuUrl", str2);
    paramHttpSession.setAttribute("menuThirdOrderId", str3);
    paramHttpSession.setAttribute("menuParentOrderId", str4);
    paramHttpSession.setAttribute("menuRootOrderId", str5);
  }
  
  private static void writeLog(EasUserInfo paramEasUserInfo, HttpServletRequest paramHttpServletRequest)
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
    localAppLogInfoEntity.setOptType("用户登录");
    localAppLogInfoEntity.setOptObject("系统");
    localAppLogInfoEntity.setOptDetail("用户登录");
    localIAppLogInfoMgt.writeLog(localAppLogInfoEntity);
    log.info("end writeLog()");
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.syscommon.EasLoginUtil
 * JD-Core Version:    0.7.0.1
 */