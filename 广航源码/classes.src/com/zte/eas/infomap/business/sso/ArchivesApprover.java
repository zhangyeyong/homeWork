package com.zte.eas.infomap.business.sso;

import com.zte.eas.appframe.business.syscommon.EasLoginUtil;
import com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV;
import com.zte.eas.organization.business.employeemanage.service.IFbpEmployeesVDS;
import com.zte.eimage.business.baseconfig.service.IImageCommonDS;
import com.zte.evs.ebill.model.archives.FbpArchivesHeaders;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.common.log.Log;
import com.zte.ssb.framework.util.ApplicationGlobalResource;
import com.zte.ssb.servicecontainer.business.server.IRIAContextFactory;
import com.zte.ssb.servicecontainer.business.server.RIAConfiguration;
import com.zte.ssb.ui.uiloader.model.UserInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;

public class ArchivesApprover
  extends HttpServlet
{
  private static final long serialVersionUID = -2600814107825130493L;
  private RIAConfiguration configuration;
  static Log log = SSBBus.getLog(ArchivesApprover.class);
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
  
  public void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    IRIAContextFactory localIRIAContextFactory = this.configuration.getRiaContextFactory();
    localIRIAContextFactory.getRIAContext(getServletContext(), paramHttpServletRequest, paramHttpServletResponse);
    paramHttpServletResponse.setContentType("text/html;charset=UTF-8");
    String str1 = paramHttpServletRequest.getParameter("workItemId");
    String str2 = paramHttpServletRequest.getParameter("processId");
    String str3 = paramHttpServletRequest.getParameter("claimNo");
    String str4 = paramHttpServletRequest.getParameter("userId");
    String str5 = "./uiloader/login.html";
    if (StringUtils.isEmpty(str4))
    {
      printMst(paramHttpServletResponse, "用户名不能为空!", str5);
      return;
    }
    if (StringUtils.isEmpty(str3))
    {
      printMst(paramHttpServletResponse, "申请单号不能为空!", str5);
      return;
    }
    if (StringUtils.isEmpty(str1))
    {
      printMst(paramHttpServletResponse, "工作项不能为空!", str5);
      return;
    }
    UserInfo localUserInfo = new UserInfo();
    HttpSession localHttpSession = paramHttpServletRequest.getSession();
    localUserInfo.setUserId(str4);
    String str6 = login(localUserInfo, localHttpSession, paramHttpServletRequest);
    if (("0000".equals(str6)) || ("9999".equals(str6)))
    {
      str5 = "./uiloader/index.html";
      String str7 = "select * from fbp.fbp_archives_headers ah where ah.enabled_flag = 'Y' and ah.apply_num = ?";
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str3);
      IImageCommonDS localIImageCommonDS = (IImageCommonDS)SSBBus.findDomainService("imageCommonDS");
      FbpArchivesHeaders localFbpArchivesHeaders = (FbpArchivesHeaders)localIImageCommonDS.findObject(str7, localArrayList, FbpArchivesHeaders.class);
      if ((localFbpArchivesHeaders == null) || (localFbpArchivesHeaders.getArchivesHeaderId() == null))
      {
        printMst(paramHttpServletResponse, "申请单[" + str3 + "]不存在!", str5);
        return;
      }
      String str8 = "update fbp.fbp_archives_headers ah set work_item_id = ? where archives_header_id = ?";
      localArrayList.clear();
      localArrayList.add(Long.valueOf(str1));
      localArrayList.add(localFbpArchivesHeaders.getArchivesHeaderId());
      localIImageCommonDS.executeSql(str8, localArrayList);
      str5 = "./apps/eimage/myboe/borrowView.html?archivesHeaderId=" + localFbpArchivesHeaders.getArchivesHeaderId() + "&attribute1=" + localFbpArchivesHeaders.getAttribute1() + "&flag=Y&isVerify=true";
    }
    paramHttpServletResponse.sendRedirect(str5);
  }
  
  void printMst(HttpServletResponse paramHttpServletResponse, String paramString1, String paramString2)
    throws IOException
  {
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
      InputStream localInputStream = ArchivesApprover.class.getClassLoader().getResourceAsStream("ria-config.config");
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
    IFbpEmployeesVDS localIFbpEmployeesVDS = (IFbpEmployeesVDS)SSBBus.findCommonService("fbpEmployeesVDS");
    FbpEmployeesLoginV localFbpEmployeesLoginV = localIFbpEmployeesVDS.findEmployeeByUserId(paramUserInfo.getUserId());
    if (localFbpEmployeesLoginV == null) {
      return "0003";
    }
    EasLoginUtil.afterLoginSuccess(paramUserInfo, localFbpEmployeesLoginV, paramHttpSession, paramHttpServletRequest);
    return "0000";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.sso.ArchivesApprover
 * JD-Core Version:    0.7.0.1
 */