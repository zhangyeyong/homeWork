package com.zte.eimage.business.baseconfig.service;

import com.zte.eas.appframe.business.syscommon.InfoMapEncrypt;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesVDAO;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.eimage.business.baseconfig.model.FrontUserV;
import com.zte.eimage.business.baseconfig.model.UserInfo;
import com.zte.eimage.business.common.model.Fbplogins;
import com.zte.ssb.framework.SSBBus;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.axis.MessageContext;
import org.apache.axis.transport.http.HTTPConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Login
  implements ILogin
{
  Log log = LogFactory.getLog(Login.class);
  
  public UserInfo Login(String paramString1, String paramString2, String paramString3)
  {
    this.log.error("\n\n++++++++++++++++++++++++++++ Login 登录 begin +++++++++++++++++++++++++++++++++++++++++++++");
    this.log.error("username:  " + paramString1);
    this.log.error("password:  " + paramString2);
    UserInfo localUserInfo = new UserInfo();
    Integer localInteger = Integer.valueOf(1);
    IFbpEmployeesVDAO localIFbpEmployeesVDAO = (IFbpEmployeesVDAO)SSBBus.findDomainService("fbpEmployeesVDAO");
    FbpEmployeesV localFbpEmployeesV = localIFbpEmployeesVDAO.findEmployeesByNumber(paramString1);
    IFrontUserService localIFrontUserService = (IFrontUserService)SSBBus.findDomainService("frontUserService");
    try
    {
      if (localFbpEmployeesV == null)
      {
        localInteger = Integer.valueOf(0);
        localUserInfo.setLoginResult(localInteger.intValue());
        localUserInfo.setTicket(null);
        return localUserInfo;
      }
      PasswordStrategyUtil.updateUnlockUser(paramString1, "1");
      if (PasswordStrategyUtil.getUserIsLock(paramString1))
      {
        localUserInfo.setLoginResult(-3);
        localUserInfo.setTicket(null);
        localObject1 = PasswordStrategyUtil.getLockInfo(paramString1);
        localUserInfo.setPassErrorCount(Integer.valueOf(Integer.parseInt(localObject1[0].toString())));
        localUserInfo.setPassUnLockTime(Integer.valueOf(Integer.parseInt(localObject1[1].toString())));
        localUserInfo.setMaxPassErrorCount(Integer.valueOf(Integer.parseInt(localObject1[2].toString())));
        return localUserInfo;
      }
      Object localObject1 = InfoMapEncrypt.decrypt(localFbpEmployeesV.getPassword());
      String str1 = md5((String)localObject1);
      if (!paramString2.equals(str1.toUpperCase()))
      {
        PasswordStrategyUtil.updateLockUser(paramString1);
        Object[] arrayOfObject = PasswordStrategyUtil.getLockInfo(paramString1);
        localUserInfo.setPassErrorCount(Integer.valueOf(Integer.parseInt(arrayOfObject[0].toString())));
        localUserInfo.setPassUnLockTime(Integer.valueOf(Integer.parseInt(arrayOfObject[1].toString())));
        localUserInfo.setMaxPassErrorCount(Integer.valueOf(Integer.parseInt(arrayOfObject[2].toString())));
        localInteger = Integer.valueOf(-4);
        localUserInfo.setLoginResult(localInteger.intValue());
        localUserInfo.setTicket(null);
        this.log.error("username or password error");
        return localUserInfo;
      }
      PasswordStrategyUtil.updateUnlockUser(paramString1, "2");
      boolean bool = EvsServiceSessionMap.checkUeryIsLogin(paramString1);
      this.log.error("isLog:  " + bool);
      if (bool)
      {
        localInteger = Integer.valueOf(-2);
        localUserInfo.setLoginResult(localInteger.intValue());
        localObject2 = EvsServiceSessionMap.getFbplogins(paramString1);
        if ((localObject2 != null) && (((Fbplogins)localObject2).getLoginId() != null)) {
          localUserInfo.setTicket(((Fbplogins)localObject2).getLoginId().toString());
        }
        return localUserInfo;
      }
      Object localObject2 = localIFrontUserService.findFrontUserByEmpId(Integer.valueOf(localFbpEmployeesV.getEmployeeId().intValue()));
      this.log.error("扫描权限： " + (localObject2 == null ? null : ((FrontUserV)localObject2).getUserPurview()));
      if ((localObject2 == null) || (((FrontUserV)localObject2).getEnabledFlag().equals("N")))
      {
        localInteger = Integer.valueOf(-1);
        localUserInfo.setLoginResult(localInteger.intValue());
        return localUserInfo;
      }
      MessageContext localMessageContext = MessageContext.getCurrentContext();
      String str2 = null;
      HttpServletRequest localHttpServletRequest = null;
      localHttpServletRequest = (HttpServletRequest)localMessageContext.getProperty(HTTPConstants.MC_HTTP_SERVLETREQUEST);
      str2 = localHttpServletRequest.getRemoteAddr();
      Fbplogins localFbplogins = new Fbplogins();
      Date localDate = new Date();
      localFbplogins.setLoginTime(localDate);
      localFbplogins.setActiveTime(localDate);
      localFbplogins.setUserCode(paramString1);
      localFbplogins.setUserId(localFbpEmployeesV.getEmployeeId());
      localFbplogins.setUserName(localFbpEmployeesV.getEmployeeName());
      BigInteger localBigInteger = BigInteger.valueOf(EvsServiceSessionMap.APP_ID.longValue());
      localFbplogins.setAppId(localBigInteger);
      localFbplogins.setLoginIp(str2);
      localFbplogins = EvsServiceSessionMap.addLogin(localFbplogins);
      String str3 = localFbplogins.getLoginId().toString();
      this.log.error("sessionID:  " + str3);
      localUserInfo.setTicket(str3);
      localInteger = ((FrontUserV)localObject2).getSiteId();
      localUserInfo.setLoginResult(localInteger == null ? 1 : localInteger.intValue());
      localUserInfo.setCompanyInfos(localIFrontUserService.findCompanyInfos(Long.valueOf(((FrontUserV)localObject2).getEmployeeId().longValue()), paramString3));
      localUserInfo.setOperationTypeInfos(localIFrontUserService.findOperationTypeInfos(Long.valueOf(((FrontUserV)localObject2).getEmployeeId().longValue()), paramString3));
      this.log.error("siteID:  " + localUserInfo.getLoginResult());
      this.log.error("sessionID:  " + localUserInfo.getTicket());
      this.log.error("++++++++++++++++++++++++++++ Login 登录 end +++++++++++++++++++++++++++++++++++++++++++++\n\n");
      return localUserInfo;
    }
    catch (Exception localException)
    {
      this.log.error(localException, localException);
      localInteger = Integer.valueOf(0);
      localUserInfo.setLoginResult(localInteger.intValue());
      localUserInfo.setTicket(null);
    }
    return localUserInfo;
  }
  
  public static String md5(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      byte[] arrayOfByte1 = paramString.getBytes("UTF-8");
      byte[] arrayOfByte2 = localMessageDigest.digest(arrayOfByte1);
      StringBuffer localStringBuffer = new StringBuffer(32);
      for (int i = 0; i < arrayOfByte2.length; i++)
      {
        int j = arrayOfByte2[i] & 0xFF;
        if (j < 16) {
          localStringBuffer.append("0");
        }
        localStringBuffer.append(Integer.toHexString(j));
      }
      return localStringBuffer.toString();
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static void main(String[] paramArrayOfString)
  {
    System.out.println(md5("149250"));
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.Login
 * JD-Core Version:    0.7.0.1
 */