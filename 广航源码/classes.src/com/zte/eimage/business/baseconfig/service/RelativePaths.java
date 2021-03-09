package com.zte.eimage.business.baseconfig.service;

import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesVDAO;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.eimage.access.baseconfig.dao.IFrontUserDao;
import com.zte.eimage.business.baseconfig.model.FrontUserFtpV;
import com.zte.eimage.business.common.model.Fbplogins;
import com.zte.ssb.framework.SSBBus;
import java.math.BigInteger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RelativePaths
  implements IRelativePaths
{
  Log log = LogFactory.getLog(RelativePaths.class);
  
  public String RelativePath(String paramString1, String paramString2, int paramInt)
  {
    this.log.error("\n\n++++++++++++++++++++++++++++ RelativePath 查询FTP根目录信息 begin +++++++++++++++++++++++++++++++++++++++++++++");
    this.log.error("sessionID:  " + paramString1);
    this.log.error("sUser:  " + paramString2);
    this.log.error("iFtpIndex:  " + paramInt);
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
    this.log.error("employeeNum:  " + localFbpEmployeesV == null ? null : localFbpEmployeesV.getEmployeeNumber());
    IFrontUserDao localIFrontUserDao = (IFrontUserDao)SSBBus.findDaoService("frontUserDao");
    String str1 = "";
    String str2 = "FROM FrontUserFtpV u WHERE u.enabledFlag = 'Y' AND u.employeeNum ='" + localFbpEmployeesV.getEmployeeNumber() + "' AND u.siteId =" + paramInt;
    FrontUserFtpV localFrontUserFtpV = (FrontUserFtpV)localIFrontUserDao.getObject(str2);
    this.log.error("frontUserFtpV:  " + localFrontUserFtpV);
    if (localFrontUserFtpV == null)
    {
      this.log.error("获取FTP根目录信息失败!");
      return str1;
    }
    str1 = localFrontUserFtpV.getRootDirectory();
    this.log.error("returnValue:  " + str1);
    this.log.error("++++++++++++++++++++++++++++ RelativePath 查询FTP根目录信息 end +++++++++++++++++++++++++++++++++++++++++++++\n\n");
    return str1;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.RelativePaths
 * JD-Core Version:    0.7.0.1
 */