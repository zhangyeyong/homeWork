package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.access.baseconfig.dao.IEidAppraiseTasksDAO;
import com.zte.eimage.business.common.model.Fbplogins;
import com.zte.ssb.framework.SSBBus;
import java.math.BigInteger;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GetServCmdInfos
  implements IGetServCmdInfos
{
  Log log = LogFactory.getLog(GetServCmdInfos.class);
  
  public String GetServCmdInfo(String paramString1, String paramString2)
  {
    this.log.error("\n\n++++++++++++++++++++++++++++ GetServCmdInfo 查询评价任务 begin +++++++++++++++++++++++++++++++++++++++++++++");
    this.log.error("sessionID:  " + paramString1);
    Fbplogins localFbplogins = EvsServiceSessionMap.getLoginInfo(paramString1);
    if (localFbplogins == null)
    {
      this.log.error("获取登录信息失败!");
      return null;
    }
    try
    {
      IEidAppraiseTasksDAO localIEidAppraiseTasksDAO = (IEidAppraiseTasksDAO)SSBBus.findDaoService("eidAppraiseTasksDAO");
      StringBuffer localStringBuffer = new StringBuffer();
      BigInteger localBigInteger = localFbplogins.getUserId();
      Object localObject = null;
      List localList = localIEidAppraiseTasksDAO.findAppraiseTask("NONCOMPLETE", Long.valueOf(localBigInteger.longValue()), null);
      if ((localList == null) || (localList.isEmpty())) {
        return localStringBuffer.toString();
      }
      for (int i = 0; i < localList.size(); i++)
      {
        Object[] arrayOfObject = (Object[])localList.get(i);
        String str1 = arrayOfObject[0] == null ? "" : arrayOfObject[0].toString();
        String str2 = arrayOfObject[1] == null ? "" : arrayOfObject[1].toString();
        String str3 = arrayOfObject[2] == null ? "" : arrayOfObject[2].toString();
        String str4 = arrayOfObject[3] == null ? "" : arrayOfObject[3].toString();
        String str5 = arrayOfObject[4] == null ? "" : arrayOfObject[4].toString();
        String str6 = arrayOfObject[5] == null ? "" : arrayOfObject[5].toString();
        String str7 = arrayOfObject[6] == null ? "" : arrayOfObject[6].toString();
        String str8 = arrayOfObject[7] == null ? "" : arrayOfObject[7].toString();
        String str9 = arrayOfObject[8] == null ? "" : arrayOfObject[8].toString();
        String str10 = arrayOfObject[9] == null ? "" : arrayOfObject[9].toString();
        String str11 = arrayOfObject[10] == null ? "" : arrayOfObject[10].toString();
        String str12 = arrayOfObject[11] == null ? "" : arrayOfObject[11].toString();
        String str13 = arrayOfObject[12] == null ? "" : arrayOfObject[12].toString();
        String str14 = str10;
        if ((str14 != null) && (str14.lastIndexOf("/") > 0)) {
          str14 = str14.substring(0, str14.lastIndexOf("/"));
        }
        localStringBuffer.append("[");
        localStringBuffer.append(str1);
        localStringBuffer.append("][");
        localStringBuffer.append(str2);
        localStringBuffer.append("][");
        localStringBuffer.append(str3);
        localStringBuffer.append("][");
        localStringBuffer.append(str4);
        localStringBuffer.append("][");
        localStringBuffer.append(str5);
        localStringBuffer.append("][");
        localStringBuffer.append(getString(str6));
        localStringBuffer.append("][");
        localStringBuffer.append(getString(str7));
        localStringBuffer.append("][");
        localStringBuffer.append(str8);
        localStringBuffer.append("][");
        localStringBuffer.append(str14);
        localStringBuffer.append("][");
        localStringBuffer.append(str9);
        localStringBuffer.append("][");
        localStringBuffer.append(str11);
        localStringBuffer.append("][");
        localStringBuffer.append(str12);
        localStringBuffer.append("][");
        localStringBuffer.append(str13);
        localStringBuffer.append("];");
      }
      this.log.error("returnValue:  " + localStringBuffer.toString());
      this.log.error("++++++++++++++++++++++++++++ GetServCmdInfo 查询评价任务 end +++++++++++++++++++++++++++++++++++++++++++++\n\n");
      if (localStringBuffer.indexOf(";") != -1) {
        return localStringBuffer.toString().substring(0, localStringBuffer.lastIndexOf(";"));
      }
      this.log.error("获取评价任务失败!");
      return localStringBuffer.toString();
    }
    catch (Exception localException)
    {
      this.log.error(localException, localException);
    }
    return "";
  }
  
  private String getString(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replace("[", "").replace("]", "").replace(";", "");
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.GetServCmdInfos
 * JD-Core Version:    0.7.0.1
 */