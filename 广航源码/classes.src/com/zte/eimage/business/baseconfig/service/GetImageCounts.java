package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.access.baseconfig.dao.IEidImageInfosDAO;
import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.eimage.business.common.model.Fbplogins;
import com.zte.ssb.framework.SSBBus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GetImageCounts
  implements IGetImageCounts
{
  Log log = LogFactory.getLog(GetImageCounts.class);
  
  public int GetImageCount(String paramString1, String paramString2)
  {
    this.log.error("\n\n++++++++++++++++++++++++++++ GetImageCount 查询影像文件图像个数 begin +++++++++++++++++++++++++++++++++++++++++++++");
    this.log.error("sessionID:  " + paramString1);
    Fbplogins localFbplogins = EvsServiceSessionMap.getLoginInfo(paramString1);
    if (localFbplogins == null)
    {
      this.log.error("获取登录信息失败!");
      return 0;
    }
    this.log.error("影像文件编号  sBarCode:  " + paramString2);
    IEidImageInfosDAO localIEidImageInfosDAO = (IEidImageInfosDAO)SSBBus.findDaoService("eidImageInfosDAO");
    EidImageInfos localEidImageInfos = localIEidImageInfosDAO.findEidImageInfoByImageNumber(paramString2);
    if ((localEidImageInfos == null) || (localEidImageInfos.getImageCount() == null))
    {
      this.log.error("获取影像文件失败!");
      return 0;
    }
    this.log.error("eidImageInfo:  " + localEidImageInfos);
    this.log.error("imageCount:  " + localEidImageInfos.getImageCount());
    this.log.error("++++++++++++++++++++++++++++ GetImageCount 查询影像文件图像个数 end +++++++++++++++++++++++++++++++++++++++++++++\n\n");
    return Integer.parseInt(localEidImageInfos.getImageCount().toString());
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.GetImageCounts
 * JD-Core Version:    0.7.0.1
 */