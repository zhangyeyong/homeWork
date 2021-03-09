package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.access.baseconfig.dao.IFrontUserDao;
import com.zte.eimage.business.common.model.Fbplogins;
import com.zte.ssb.framework.SSBBus;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RealTimeAllows
  implements IRealTimeAllows
{
  Log log = LogFactory.getLog(RealTimeAllows.class);
  
  public boolean RealTimeAllow(String paramString1, String paramString2)
  {
    this.log.error("\n\n++++++++++++++++++++++++++++ RealTimeAllow 查询用户是否有实时上传权限 begin +++++++++++++++++++++++++++++++++++++++++++++");
    this.log.error("sessionID:  " + paramString1);
    Fbplogins localFbplogins = EvsServiceSessionMap.getLoginInfo(paramString1);
    if (localFbplogins == null)
    {
      this.log.error("获取登录信息失败!");
      return false;
    }
    BigInteger localBigInteger = localFbplogins.getUserId();
    this.log.error("employeeID:  " + localBigInteger);
    IFrontUserDao localIFrontUserDao = (IFrontUserDao)SSBBus.findDaoService("frontUserDao");
    boolean bool = false;
    String str = "select 1 from eid.eid_front_users fu where fu.upload_mode = 'INSTANT_UPLOAD' and fu.employee_id = ?";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localBigInteger);
    List localList = localIFrontUserDao.findObjectsBySql(str, localArrayList, null);
    if ((localList != null) && (!localList.isEmpty())) {
      bool = true;
    }
    this.log.error("returnValue:  " + bool);
    this.log.error("++++++++++++++++++++++++++++ RealTimeAllow 查询用户是否有实时上传权限 end +++++++++++++++++++++++++++++++++++++++++++++\n\n");
    return bool;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.RealTimeAllows
 * JD-Core Version:    0.7.0.1
 */