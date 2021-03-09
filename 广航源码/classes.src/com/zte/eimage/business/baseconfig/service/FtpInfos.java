package com.zte.eimage.business.baseconfig.service;

import com.zte.eas.appframe.business.syscommon.InfoMapEncrypt;
import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesVDAO;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.eimage.access.baseconfig.dao.IFrontUserDao;
import com.zte.eimage.business.baseconfig.model.FrontUserFtpV;
import com.zte.eimage.business.common.model.Fbplogins;
import com.zte.ssb.framework.SSBBus;
import java.math.BigInteger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FtpInfos
  implements IFtpInfos
{
  Log log = LogFactory.getLog(FtpInfos.class);
  
  public String FtpInfo(String paramString1, String paramString2, int paramInt)
  {
    this.log.error("\n\n++++++++++++++++++++++++++++ FtpInfo 查询ftp信息 begin +++++++++++++++++++++++++++++++++++++++++++++");
    this.log.error("ticket: " + paramString1 + "  sUser : " + paramString2 + "  iFtpIndex:  " + paramInt);
    Fbplogins localFbplogins = EvsServiceSessionMap.getLoginInfo(paramString1);
    if (localFbplogins == null)
    {
      this.log.error("获取登录信息失败!");
      return null;
    }
    IFbpEmployeesVDAO localIFbpEmployeesVDAO = (IFbpEmployeesVDAO)SSBBus.findDomainService("fbpEmployeesVDAO");
    BigInteger localBigInteger = localFbplogins.getUserId();
    this.log.error("employeeId:  " + localBigInteger);
    FbpEmployeesV localFbpEmployeesV = localIFbpEmployeesVDAO.findEmployeesById(localBigInteger);
    this.log.error("employeeNum:  " + localFbpEmployeesV.getEmployeeNumber());
    IFrontUserDao localIFrontUserDao = (IFrontUserDao)SSBBus.findDaoService("frontUserDao");
    StringBuffer localStringBuffer = new StringBuffer();
    String str1 = "FROM FrontUserFtpV u WHERE u.enabledFlag = 'Y' AND u.employeeNum ='" + localFbpEmployeesV.getEmployeeNumber() + "' AND u.siteId =" + paramInt;
    FrontUserFtpV localFrontUserFtpV = (FrontUserFtpV)localIFrontUserDao.getObject(str1);
    this.log.error("frontUserFtpV:  " + localFrontUserFtpV);
    if (localFrontUserFtpV == null)
    {
      this.log.error("获取前端用户失败!");
      return localStringBuffer.toString();
    }
    String str2 = null;
    try
    {
      str2 = InfoMapEncrypt.decrypt(localFrontUserFtpV.getFtpPassword());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.log.error(localException);
      this.log.error("解密密码失败!");
      return localStringBuffer.toString();
    }
    localStringBuffer.append("[");
    localStringBuffer.append(localFrontUserFtpV.getFtpSite());
    localStringBuffer.append(":");
    localStringBuffer.append(localFrontUserFtpV.getPort());
    localStringBuffer.append("]");
    localStringBuffer.append("[");
    localStringBuffer.append(localFrontUserFtpV.getFtpUserName());
    localStringBuffer.append("]");
    localStringBuffer.append("[");
    localStringBuffer.append(str2);
    localStringBuffer.append("]");
    this.log.error("returnValue:  " + localStringBuffer.toString());
    this.log.error("++++++++++++++++++++++++++++ FtpInfo 查询ftp信息 end +++++++++++++++++++++++++++++++++++++++++++++\n\n");
    return localStringBuffer.toString();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.FtpInfos
 * JD-Core Version:    0.7.0.1
 */