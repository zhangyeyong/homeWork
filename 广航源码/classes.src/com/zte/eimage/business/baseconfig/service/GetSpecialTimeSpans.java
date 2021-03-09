package com.zte.eimage.business.baseconfig.service;

import com.zte.eas.organization.access.employeemanage.dao.IFbpEmployeesVDAO;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.eimage.access.baseconfig.dao.IFrontUserDao;
import com.zte.eimage.business.baseconfig.model.FrontUserV;
import com.zte.eimage.business.common.model.Fbplogins;
import com.zte.ssb.framework.SSBBus;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GetSpecialTimeSpans
  implements IGetSpecialTimeSpans
{
  Log log = LogFactory.getLog(GetSpecialTimeSpans.class);
  
  public String GetSpecialTimeSpan(String paramString)
  {
    this.log.error("\n\n++++++++++++++++++++++++++++ GetSpecialTimeSpan 查询定时上传时间 begin +++++++++++++++++++++++++++++++++++++++++++++");
    this.log.error("ticket:  " + paramString);
    Fbplogins localFbplogins = EvsServiceSessionMap.getLoginInfo(paramString);
    if (localFbplogins == null)
    {
      this.log.error("获取登录信息失败!");
      return null;
    }
    IFbpEmployeesVDAO localIFbpEmployeesVDAO = (IFbpEmployeesVDAO)SSBBus.findDomainService("fbpEmployeesVDAO");
    IFrontUserDao localIFrontUserDao = (IFrontUserDao)SSBBus.findDaoService("frontUserDao");
    this.log.error("employeeId: " + localFbplogins.getUserId());
    BigInteger localBigInteger = localFbplogins.getUserId();
    FbpEmployeesV localFbpEmployeesV = localIFbpEmployeesVDAO.findEmployeesById(localBigInteger);
    if (localFbpEmployeesV == null)
    {
      this.log.error("获取员工信息失败!");
      return null;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    this.log.error("employeeNum:  " + localFbpEmployeesV.getEmployeeNumber());
    String str = "FROM FrontUserV u WHERE u.uploadMode = 'TIMING_UPLOAD' AND u.enabledFlag = 'Y' AND u.employeeNum = '" + localFbpEmployeesV.getEmployeeNumber() + "'";
    StringBuffer localStringBuffer = new StringBuffer();
    FrontUserV localFrontUserV = (FrontUserV)localIFrontUserDao.getObject(str);
    if (localFrontUserV != null)
    {
      localStringBuffer.append("[");
      localStringBuffer.append(localSimpleDateFormat.format(new Date()));
      localStringBuffer.append(" ");
      localStringBuffer.append(localFrontUserV.getStartHour());
      localStringBuffer.append(":");
      localStringBuffer.append(localFrontUserV.getStartMinute());
      localStringBuffer.append(":");
      localStringBuffer.append("00");
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(localSimpleDateFormat.format(new Date()));
      localStringBuffer.append(" ");
      localStringBuffer.append(localFrontUserV.getEndHour());
      localStringBuffer.append(":");
      localStringBuffer.append(localFrontUserV.getEndMinute());
      localStringBuffer.append(":");
      localStringBuffer.append("00");
      localStringBuffer.append("]");
    }
    else
    {
      localStringBuffer.append("不是定时上传员工!");
    }
    this.log.error("returnValue:  " + localStringBuffer);
    this.log.error("++++++++++++++++++++++++++++ GetSpecialTimeSpan 查询定时上传时间 end +++++++++++++++++++++++++++++++++++++++++++++\n\n");
    return localStringBuffer.toString();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.GetSpecialTimeSpans
 * JD-Core Version:    0.7.0.1
 */