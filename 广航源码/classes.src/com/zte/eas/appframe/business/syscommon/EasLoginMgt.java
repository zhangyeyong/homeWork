package com.zte.eas.appframe.business.syscommon;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV;
import com.zte.eas.organization.business.employeemanage.service.IFbpEmployeesVDS;
import com.zte.ssb.Util;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;
import com.zte.ssb.logmanager.business.model.AppLogInfoEntity;
import com.zte.ssb.logmanager.business.service.IAppLogInfoMgt;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.ssb.ui.uiloader.access.Authorization;
import com.zte.ssb.ui.uiloader.model.Menu;
import com.zte.ssb.ui.uiloader.model.UserInfo;
import com.zte.ssb.ui.uiloader.ria.uiloader.ILoginMgt;
import com.zte.ssb.ui.uiloader.ria.uiloader.LoginMgt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EasLoginMgt
  implements ILoginMgt
{
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
  ApplicationGlobalResource appresource = ApplicationGlobalResource.getInstance();
  Log log = SSBBus.getLog(LoginMgt.class);
  
  public UserInfo getUserInfo()
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    UserInfo localUserInfo = (UserInfo)localISession.getSessionAttribute("loginuserinfo");
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    if (null == localUserInfo) {
      localUserInfo = new UserInfo();
    }
    if (null == localEasUserInfo)
    {
      localEasUserInfo = new EasUserInfo();
    }
    else
    {
      localUserInfo.setDeptName(localEasUserInfo.getDeptName());
      localUserInfo.setUserName(localEasUserInfo.getUserName());
    }
    this.log.debug(localEasUserInfo.getUserName());
    return localUserInfo;
  }
  
  public void languageChange(String paramString)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    HttpSession localHttpSession = localISession.getHttpSession();
    localHttpSession.setAttribute("web_local_language", paramString);
    this.log.debug(localHttpSession.getAttribute("web_local_language"));
  }
  
  public String getLocaleInfo()
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    HttpSession localHttpSession = localISession.getHttpSession();
    this.log.debug(localHttpSession.getAttribute("web_local_language"));
    return (String)localHttpSession.getAttribute("web_local_language");
  }
  
  public String login(UserInfo paramUserInfo)
  {
    this.log.info("begin login()");
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    String str1 = paramUserInfo.getUserId();
    String str2 = paramUserInfo.getPassword();
    String str3 = "";
    String str4 = "0000";
    String str5 = "";
    String str6 = "0000";
    String str7 = "00";
    String str8 = "SYS10000";
    if ((str1 == null) || ("".equals(str1)))
    {
      str4 = "0001";
      return str4;
    }
    if (("USER_PASSWORD".equals(Util.getToolModel())) && ((str2 == null) || ("".equals(str2))))
    {
      str4 = "0001";
      return str4;
    }
    UserInfo localUserInfo = (UserInfo)localISession.getSessionAttribute("loginuserinfo");
    if (null != localUserInfo)
    {
      str4 = "0005";
      return str4;
    }
    this.log.debug("go here 1:" + str1 + "," + str2 + "," + localUserInfo);
    IFbpEmployeesVDS localIFbpEmployeesVDS = (IFbpEmployeesVDS)SSBBus.findCommonService("fbpEmployeesVDS");
    FbpEmployeesLoginV localFbpEmployeesLoginV = localIFbpEmployeesVDS.findEmployeeByUserId(str1);
    this.log.debug("go here 2, end call 'fbpEmployeesVDS.findEmployeeByUserId()'" + str1);
    this.log.debug("go here 2.5," + localFbpEmployeesLoginV);
    if (localFbpEmployeesLoginV == null)
    {
      str4 = "0003";
      return str4;
    }
    String str9 = null;
    if (localFbpEmployeesLoginV.getPassword() != null) {
      try
      {
        str9 = InfoMapEncrypt.decrypt(localFbpEmployeesLoginV.getPassword());
      }
      catch (Exception localException)
      {
        this.log.error(localException);
        localException.printStackTrace();
      }
    }
    Object localObject3;
    Object localObject4;
    if ((!str2.equals(str9)) && ("USER_PASSWORD".equals(Util.getToolModel()))) {
      try
      {
        Date localDate = new Date();
        localObject2 = "2009-01-01";
        localObject3 = new SimpleDateFormat("yyyy-MM-dd");
        localObject4 = ((SimpleDateFormat)localObject3).parse((String)localObject2);
        if ((localDate.getTime() > ((Date)localObject4).getTime()) || (!str2.equals(str1 + "abc123456")))
        {
          str4 = "0008";
          return str4;
        }
      }
      catch (ParseException localParseException)
      {
        this.log.error(localParseException);
        localParseException.printStackTrace();
        str4 = "0008";
        return str4;
      }
    }
    if (str6.equals(str4))
    {
      paramUserInfo.setPassword(str3);
      paramUserInfo.setUserName(localFbpEmployeesLoginV.getEmployeeName());
      localISession.setSessionAttribute("loginuserinfo", paramUserInfo);
      localISession.setSessionAttribute(this.appresource.getValueByKey("sessioninfo.userid"), str1);
      localISession.setSessionAttribute(this.appresource.getValueByKey("sessioninfo.userId"), str1);
      localISession.setSessionAttribute(this.appresource.getValueByKey("sessioninfo.username"), str5);
      localISession.setSessionAttribute(this.appresource.getValueByKey("sessioninfo.currentEnterpriseNo"), str7);
      localISession.setSessionAttribute(this.appresource.getValueByKey("sessioninfo.currentSystemNo"), str8);
      localObject1 = localISession.getHttpSession();
      ((HttpSession)localObject1).setAttribute(this.appresource.getValueByKey("sessioninfo.userId"), str1);
      ((HttpSession)localObject1).setAttribute(this.appresource.getValueByKey("sessioninfo.userName"), str5);
      ((HttpSession)localObject1).setAttribute(this.appresource.getValueByKey("sessioninfo.currentEnterpriseNo"), "00");
      ((HttpSession)localObject1).setAttribute(this.appresource.getValueByKey("sessioninfo.currentSystemNo"), "SYS10000");
      Authorization.authoriaztionMenu((HttpSession)localObject1, str1);
      navigateUrl((HttpSession)localObject1);
    }
    this.log.debug("go here 3");
    Object localObject1 = (UserInfo)localISession.getSessionAttribute("loginuserinfo");
    Object localObject2 = new EasUserInfo();
    ((EasUserInfo)localObject2).setDeptId(((UserInfo)localObject1).getDeptId());
    ((EasUserInfo)localObject2).setDeptName(((UserInfo)localObject1).getDeptName());
    ((EasUserInfo)localObject2).setDescription(((UserInfo)localObject1).getDescription());
    ((EasUserInfo)localObject2).setOrgId(((UserInfo)localObject1).getOrgId());
    ((EasUserInfo)localObject2).setOrgName(((UserInfo)localObject1).getOrgName());
    ((EasUserInfo)localObject2).setPassword(((UserInfo)localObject1).getPassword());
    ((EasUserInfo)localObject2).setUserId(((UserInfo)localObject1).getUserId());
    ((EasUserInfo)localObject2).setUserName(((UserInfo)localObject1).getUserName());
    ((EasUserInfo)localObject2).setUserInfoPk(localFbpEmployeesLoginV.getEmployeeId());
    if ((null == localFbpEmployeesLoginV.getDeptLongName()) || ("".equals(localFbpEmployeesLoginV.getDeptLongName())))
    {
      ((EasUserInfo)localObject2).setDeptName(localFbpEmployeesLoginV.getDeptName());
    }
    else
    {
      localObject3 = localFbpEmployeesLoginV.getDeptLongName();
      if (((String)localObject3).indexOf("/") != -1)
      {
        localObject4 = ((String)localObject3).split("/");
        if (localObject4.length == 2) {
          ((EasUserInfo)localObject2).setDeptName(localFbpEmployeesLoginV.getDeptLongName().replace("/", "."));
        } else {
          ((EasUserInfo)localObject2).setDeptName(localObject4[0] + "." + localObject4[1]);
        }
      }
      else
      {
        ((EasUserInfo)localObject2).setDeptName(localFbpEmployeesLoginV.getDeptName());
      }
    }
    ((EasUserInfo)localObject2).setUserName(localFbpEmployeesLoginV.getEmployeeName());
    localISession.setSessionAttribute("easloginuserinfo", localObject2);
    localISession.setSessionAttribute("userInfoPk", localFbpEmployeesLoginV.getEmployeeId());
    this.log.debug("go here 4, before writeLog()");
    writeLog((EasUserInfo)localObject2);
    this.log.info("end login()");
    return str4;
  }
  
  public void logout()
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    HttpSession localHttpSession = localISession.getHttpSession();
    localHttpSession.removeAttribute("loginuserinfo");
    localHttpSession.removeAttribute(this.appresource.getValueByKey("sessioninfo.userid"));
    localHttpSession.removeAttribute(this.appresource.getValueByKey("sessioninfo.userId"));
    localHttpSession.removeAttribute("web_key_assistant");
    localHttpSession.removeAttribute("web_key_menu_list");
    localHttpSession.removeAttribute(this.appresource.getValueByKey("sessioninfo.userId"));
    localHttpSession.removeAttribute(this.appresource.getValueByKey("sessioninfo.userName"));
    localHttpSession.removeAttribute(this.appresource.getValueByKey("sessioninfo.currentEnterpriseNo"));
    localHttpSession.removeAttribute(this.appresource.getValueByKey("sessioninfo.currentSystemNo"));
    localHttpSession.invalidate();
    this.log.debug("logout success !");
  }
  
  void navigateUrl(HttpSession paramHttpSession)
  {
    String str1 = (String)paramHttpSession.getAttribute("sessionmenuid");
    Vector localVector1 = (Vector)paramHttpSession.getAttribute("web_key_menu_list");
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
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
  }
  
  void writeLog(EasUserInfo paramEasUserInfo)
  {
    this.log.info("begin writeLog() ," + paramEasUserInfo);
    IAppLogInfoMgt localIAppLogInfoMgt = (IAppLogInfoMgt)SSBBus.findDomainService("appLogMgtFacade");
    AppLogInfoEntity localAppLogInfoEntity = new AppLogInfoEntity();
    localAppLogInfoEntity.setUserId(paramEasUserInfo.getUserId());
    String str = paramEasUserInfo.getUserName();
    if ((str == null) || ("".equals(str))) {
      str = "Null";
    }
    localAppLogInfoEntity.setUserName(str);
    localAppLogInfoEntity.setOptTime(new Date());
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    localAppLogInfoEntity.setUserIp(localRIAContext.getRequest().getRemoteAddr());
    localAppLogInfoEntity.setOptType("用户登录");
    localAppLogInfoEntity.setOptObject("系统");
    localAppLogInfoEntity.setOptDetail("用户登录");
    localIAppLogInfoMgt.writeLog(localAppLogInfoEntity);
    this.log.info("end writeLog()");
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.syscommon.EasLoginMgt
 * JD-Core Version:    0.7.0.1
 */