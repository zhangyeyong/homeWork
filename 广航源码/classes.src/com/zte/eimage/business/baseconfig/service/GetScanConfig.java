package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.access.baseconfig.dao.IBaseConfigDao;
import com.zte.eimage.business.baseconfig.model.BaseConfigV;
import com.zte.eimage.business.common.model.Fbplogins;
import com.zte.ssb.framework.SSBBus;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GetScanConfig
  implements IGetScanConfig
{
  Log log = LogFactory.getLog(GetScanConfig.class);
  
  public String GetScanConfig(String paramString)
  {
    this.log.error("\n\n++++++++++++++++++++++++++++ GetScanConfig 获取扫描配置 begin +++++++++++++++++++++++++++++++++++++++++++++");
    this.log.error("sessionID:  " + paramString);
    Fbplogins localFbplogins = EvsServiceSessionMap.getLoginInfo(paramString);
    if (localFbplogins == null)
    {
      this.log.error("获取登录信息失败!");
      return null;
    }
    IBaseConfigDao localIBaseConfigDao = (IBaseConfigDao)SSBBus.findDaoService("baseConfigDao");
    StringBuffer localStringBuffer = new StringBuffer();
    List localList = localIBaseConfigDao.findAllBaseConfig();
    this.log.error("baseConfigVList:  " + localList);
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseConfigV localBaseConfigV = (BaseConfigV)((Iterator)localObject).next();
      localStringBuffer.append("[");
      localStringBuffer.append(setString(localBaseConfigV.getBaseConfigName()));
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(setString(localBaseConfigV.getPicTypeMeaning()));
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(setInteger(localBaseConfigV.getResRatio()));
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(setString(localBaseConfigV.getColorMeaning()));
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(setString(localBaseConfigV.getSideTypeMeaning()));
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(setString(localBaseConfigV.getIsDefaultMeaning()));
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(setInteger(localBaseConfigV.getLuminance()));
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(setInteger(localBaseConfigV.getContrast()));
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(setInteger(localBaseConfigV.getThreshold()));
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(setString(localBaseConfigV.getIsDelBlankPageMeaning()));
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(setInteger(localBaseConfigV.getCompressRatio()));
      localStringBuffer.append("];");
    }
    this.log.error("returnValue:  " + localStringBuffer);
    this.log.error("++++++++++++++++++++++++++++ GetScanConfig 获取扫描配置 end +++++++++++++++++++++++++++++++++++++++++++++\n\n");
    if (localStringBuffer.indexOf(";") != -1)
    {
      localObject = localStringBuffer.toString().substring(0, localStringBuffer.lastIndexOf(";"));
      return localObject;
    }
    this.log.error("获取扫描配置失败!");
    return localStringBuffer.toString();
  }
  
  private String setString(String paramString)
  {
    return paramString == null ? "" : paramString;
  }
  
  private String setInteger(Integer paramInteger)
  {
    return paramInteger == null ? "" : paramInteger.toString();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.GetScanConfig
 * JD-Core Version:    0.7.0.1
 */