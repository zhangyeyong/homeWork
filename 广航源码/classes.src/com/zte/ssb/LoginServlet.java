package com.zte.ssb;

import com.zte.emarket.util.LoginClient;
import com.zte.ssb.framework.util.ApplicationGlobalResource;
import com.zte.ssb.ui.uiloader.access.Authorization;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet
  extends HttpServlet
{
  static final String USER_ID = "sessioninfo.userid";
  static final String USER_NAME = "sessioninfo.username";
  ApplicationGlobalResource appresource = ApplicationGlobalResource.getInstance();
  
  private void handleLoginFail(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, String paramString)
    throws IOException, ServletException
  {
    paramHttpServletResponse.sendRedirect(paramHttpServletRequest.getContextPath() + this.appresource.getValueByKey("loginInfo.loginPage"));
  }
  
  public void service(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws IOException, ServletException
  {
    HttpSession localHttpSession = paramHttpServletRequest.getSession();
    Authorization.clearInitData(localHttpSession);
    String str1 = paramHttpServletRequest.getParameter("username");
    String str2 = paramHttpServletRequest.getParameter("password");
    String str3 = "0000";
    try
    {
      str3 = LoginClient.checkLogin(str1, str2);
    }
    catch (Exception localException)
    {
      handleLoginFail(paramHttpServletRequest, paramHttpServletResponse, "login");
      return;
    }
    if ("0003".equals(str3))
    {
      paramHttpServletRequest.setAttribute("errormessage", "login.error.notexist");
      handleLoginFail(paramHttpServletRequest, paramHttpServletResponse, "login");
      return;
    }
    if ("0004".equals(str3))
    {
      paramHttpServletRequest.setAttribute("errormessage", "login.error.cannot.user");
      handleLoginFail(paramHttpServletRequest, paramHttpServletResponse, "login");
      return;
    }
    if ("0008".equals(str3))
    {
      paramHttpServletRequest.setAttribute("errormessage", "login.error.password.is.wrong");
      handleLoginFail(paramHttpServletRequest, paramHttpServletResponse, "login");
      return;
    }
    if ("0009".equals(str3))
    {
      paramHttpServletRequest.setAttribute("errormessage", "login.error.no.agent");
      handleLoginFail(paramHttpServletRequest, paramHttpServletResponse, "login");
      return;
    }
    if ("0000".equals(str3))
    {
      localHttpSession.setAttribute(this.appresource.getValueByKey("sessioninfo.userid"), str1);
      localHttpSession.setAttribute(this.appresource.getValueByKey("sessioninfo.userId"), str1);
      localHttpSession.setAttribute(this.appresource.getValueByKey("sessioninfo.username"), "管理员");
      localHttpSession.setAttribute(this.appresource.getValueByKey("sessioninfo.currentEnterpriseNo"), "00");
      localHttpSession.setAttribute(this.appresource.getValueByKey("sessioninfo.currentSystemNo"), "SYS10000");
      Cookie localCookie = new Cookie("userid", str1);
      localCookie.setMaxAge(2592000);
      paramHttpServletResponse.addCookie(localCookie);
      Authorization.authoriaztionMenu(localHttpSession, str1);
      paramHttpServletResponse.sendRedirect(paramHttpServletRequest.getContextPath() + "/index.html");
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.ssb.LoginServlet
 * JD-Core Version:    0.7.0.1
 */