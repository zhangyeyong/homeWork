package com.zte.eas.appframe.business.syscommon;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesDAO;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eas.organization.business.employeemanage.service.IFbpEmployeesVDS;
import com.zte.eimage.business.baseconfig.service.PasswordStrategyUtil;
import com.zte.ssb.Util;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;
import com.zte.ssb.logmanager.business.model.AppLogInfoEntity;
import com.zte.ssb.logmanager.business.service.IAppLogInfoMgt;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.ssb.ui.uiloader.model.UserInfo;
import com.zte.ssb.ui.uiloader.ria.uiloader.ILoginMgt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;

public class SSOLoginMgt
  implements ILoginMgt
{
  protected Log log = SSBBus.getLog(getClass());
  protected ApplicationGlobalResource appresource = ApplicationGlobalResource.getInstance();
  private static IFbpEmployeesVDS _FbpEmployeesVDS;
  
  public UserInfo getUserInfo()
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    UserInfo localUserInfo = (UserInfo)localISession.getSessionAttribute("loginuserinfo");
    if (null == localUserInfo) {
      localUserInfo = new UserInfo();
    }
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    if (null != localEasUserInfo)
    {
      localUserInfo.setDeptName(localEasUserInfo.getDeptName());
      localUserInfo.setUserName(localEasUserInfo.getUserName());
    }
    this.log.debug(localUserInfo.getUserName());
    return localUserInfo;
  }
  
  public void languageChange(String paramString)
  {
    getHttpSession().setAttribute("web_local_language", paramString);
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
    HttpSession localHttpSession = getHttpSession();
    int i = localHttpSession.getAttribute("ssoLoginResult") == null ? 1 : 0;
    if ((Util.getLoginType().equals("EAS_LOGIN")) && (i != 0)) {
      return easlogin(paramUserInfo);
    }
    if ((Util.getLoginType().equals("EAS_COMMON_LOGIN")) && (i != 0))
    {
      String str = easlogin(paramUserInfo);
      if (!"0000".equals(str)) {
        return str;
      }
      return str;
    }
    return "0004";
  }
  
  private String easlogin(UserInfo paramUserInfo)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
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
    UserInfo localUserInfo = (UserInfo)localISession.getSessionAttribute("loginuserinfo");
    if (null != localUserInfo) {
      return "0005";
    }
    this.log.debug("go here 1:" + str1 + "," + str2 + "," + localUserInfo);
    IFbpEmployeesDAO localIFbpEmployeesDAO = (IFbpEmployeesDAO)SSBBus.findDomainService("fbpEmployeesDAO");
    FbpEmployees localFbpEmployees = localIFbpEmployeesDAO.getFbpEmployees(str1);
    if (localFbpEmployees == null) {
      return "0003";
    }
    if ("N".equals(localFbpEmployees.getEnabledFlag())) {
      return "0006";
    }
    FbpEmployeesLoginV localFbpEmployeesLoginV = getFbpEmployeesVDS().findEmployeeByUserId(str1);
    if (localFbpEmployeesLoginV == null) {
      return "0003";
    }
    PasswordStrategyUtil.updateUnlockUser(str1, "1");
    if (PasswordStrategyUtil.getUserIsLock(str1))
    {
      localObject = PasswordStrategyUtil.getLockInfo(str1);
      return "0002-" + localObject[0] + "-" + Integer.parseInt(localObject[1].toString()) + "-" + localObject[2];
    }
    Object localObject = null;
    if (localFbpEmployeesLoginV.getPassword() != null) {
      try
      {
        localObject = InfoMapEncrypt.decrypt(localFbpEmployeesLoginV.getPassword());
      }
      catch (Exception localException)
      {
        this.log.error(localException);
      }
    }
    if ((!str2.equals(localObject)) && (bool)) {
      try
      {
        PasswordStrategyUtil.updateLockUser(str1);
        Date localDate1 = new Date();
        String str4 = "2009-01-01";
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date localDate2 = localSimpleDateFormat.parse(str4);
        if (PasswordStrategyUtil.getUserIsLock(str1))
        {
          arrayOfObject = PasswordStrategyUtil.getLockInfo(str1);
          return "0002-" + arrayOfObject[0] + "-" + Integer.parseInt(arrayOfObject[1].toString()) + "-" + arrayOfObject[2];
        }
        Object[] arrayOfObject = PasswordStrategyUtil.getLockInfo(str1);
        return "0001-" + arrayOfObject[0] + "-" + Integer.parseInt(arrayOfObject[1].toString()) + "-" + arrayOfObject[2];
      }
      catch (ParseException localParseException)
      {
        this.log.error(localParseException);
        return "0008";
      }
    }
    PasswordStrategyUtil.updateUnlockUser(str1, "2");
    EasLoginUtil.afterLoginSuccess(paramUserInfo, localFbpEmployeesLoginV, localISession.getHttpSession(), localRIAContext.getRequest());
    return str3;
  }
  
  public void logout()
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    HttpServletRequest localHttpServletRequest = localRIAContext.getRequest();
    IAppLogInfoMgt localIAppLogInfoMgt = (IAppLogInfoMgt)SSBBus.findDomainService("appLogMgtFacade");
    UserInfo localUserInfo = (UserInfo)localISession.getSessionAttribute("loginuserinfo");
    HttpSession localHttpSession = getHttpSession();
    localHttpSession.removeAttribute("loginuserinfo");
    localHttpSession.removeAttribute(this.appresource.getValueByKey("sessioninfo.userid"));
    localHttpSession.removeAttribute(this.appresource.getValueByKey("sessioninfo.username"));
    localHttpSession.removeAttribute("web_key_assistant");
    localHttpSession.removeAttribute("web_key_menu_list");
    localHttpSession.removeAttribute(this.appresource.getValueByKey("sessioninfo.userId"));
    localHttpSession.removeAttribute(this.appresource.getValueByKey("sessioninfo.userName"));
    localHttpSession.removeAttribute(this.appresource.getValueByKey("sessioninfo.currentEnterpriseNo"));
    localHttpSession.removeAttribute(this.appresource.getValueByKey("sessioninfo.currentSystemNo"));
    localHttpSession.invalidate();
    AppLogInfoEntity localAppLogInfoEntity = new AppLogInfoEntity();
    localAppLogInfoEntity.setUserId(localUserInfo.getUserId());
    String str = localUserInfo.getUserName();
    if ((str == null) || ("".equals(str))) {
      str = "Null";
    }
    localAppLogInfoEntity.setUserName(str);
    localAppLogInfoEntity.setOptTime(new Date());
    localAppLogInfoEntity.setUserIp(localHttpServletRequest.getRemoteAddr());
    localAppLogInfoEntity.setOptType("用户注销");
    localAppLogInfoEntity.setOptObject("系统");
    localAppLogInfoEntity.setOptDetail("用户注销");
    localIAppLogInfoMgt.writeLog(localAppLogInfoEntity);
    this.log.debug("logout success !");
  }
  
  protected static HttpSession getHttpSession()
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    return localISession.getHttpSession();
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
 * Qualified Name:     com.zte.eas.appframe.business.syscommon.SSOLoginMgt
 * JD-Core Version:    0.7.0.1
 */