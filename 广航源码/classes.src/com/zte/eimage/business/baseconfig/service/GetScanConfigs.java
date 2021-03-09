package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.access.baseconfig.dao.IBaseConfigDao;
import com.zte.eimage.business.baseconfig.model.BaseConfigV;
import com.zte.eimage.business.common.model.Fbplogins;
import com.zte.ssb.framework.SSBBus;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GetScanConfigs
  implements IGetScanConfigs
{
  Log log = LogFactory.getLog(GetScanConfigs.class);
  
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
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      BaseConfigV localBaseConfigV = (BaseConfigV)localIterator.next();
      localStringBuffer.append("[");
      localStringBuffer.append(localBaseConfigV.getBaseConfigName());
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(localBaseConfigV.getPicTypeMeaning());
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(localBaseConfigV.getResRatio());
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(localBaseConfigV.getColorMeaning());
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(localBaseConfigV.getSideTypeMeaning());
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(localBaseConfigV.getIsDefaultMeaning());
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(localBaseConfigV.getLuminance());
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(localBaseConfigV.getContrast());
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(localBaseConfigV.getThreshold());
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(localBaseConfigV.getIsDelBlankPageMeaning());
      localStringBuffer.append("]");
      localStringBuffer.append("[");
      localStringBuffer.append(localBaseConfigV.getCompressRatio());
      localStringBuffer.append("];");
    }
    this.log.error("returnValue:  " + localStringBuffer);
    this.log.error("++++++++++++++++++++++++++++ GetScanConfig 获取扫描配置 end +++++++++++++++++++++++++++++++++++++++++++++\n\n");
    if (localStringBuffer.indexOf(";") != -1) {
      return localStringBuffer.toString().substring(0, localStringBuffer.lastIndexOf(";"));
    }
    this.log.error("获取扫描配置失败!");
    return localStringBuffer.toString();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.GetScanConfigs
 * JD-Core Version:    0.7.0.1
 */