package com.zte.eimage.business.baseconfig.service;

import com.zte.eas.getData.util.EisConsts;
import com.zte.esb.bean.fssc.SpecialAttachmentRequest;
import com.zte.esb.client.SpecialAttachmentRequestSender;
import com.zte.ssb.framework.SSBBus;
import java.util.ArrayList;
import java.util.List;
import org.apache.axis.utils.StringUtils;
import org.apache.log4j.Logger;

public class SyncSpecialAttachmentDS
  implements ISyncSpecialAttachmentDS
{
  Logger logger = Logger.getLogger(getClass());
  
  public void syncSpecialAttachment(String paramString1, String paramString2)
  {
    String str1 = "select FN_GET_SPECIALATTACHMENT_PAGNO(image_info_id),sync_sa_flag,task_num from eid_image_infos where enabled_flag = 'Y'";
    ArrayList localArrayList = new ArrayList();
    if (!StringUtils.isEmpty(paramString1))
    {
      str1 = str1 + " and IMAGE_NUMBER = ?";
      localArrayList.add(paramString1);
    }
    else if (!StringUtils.isEmpty(paramString2))
    {
      str1 = str1 + " and task_num = ?";
      localArrayList.add(paramString2);
    }
    else
    {
      return;
    }
    IImageCommonDS localIImageCommonDS = (IImageCommonDS)SSBBus.findDomainService("imageCommonDS");
    List localList = localIImageCommonDS.findObjectBySQL(str1, localArrayList, null);
    String str2 = null;
    String str3 = null;
    String str4 = null;
    if ((localList != null) && (!localList.isEmpty()))
    {
      localObject = (Object[])localList.get(0);
      if ((localObject != null) && (localObject.length > 2))
      {
        str2 = localObject[0] == null ? null : localObject[0].toString();
        str3 = localObject[1] == null ? null : localObject[1].toString();
        str4 = localObject[2] == null ? null : localObject[2].toString();
      }
    }
    if ((!"W".equals(str3)) || (!"FSSC".equals(EisConsts.isEvsBoe(str4)))) {
      return;
    }
    Object localObject = (str2 == null) || (str2.trim().length() == 0) ? "N" : "Y";
    SpecialAttachmentRequest localSpecialAttachmentRequest = new SpecialAttachmentRequest();
    SpecialAttachmentRequestSender localSpecialAttachmentRequestSender = (SpecialAttachmentRequestSender)SSBBus.findDomainService("specialAttachmentRequestSender");
    localSpecialAttachmentRequest.setBillNo(str4);
    localSpecialAttachmentRequest.setIsIncludeSpecialAttach((String)localObject);
    localSpecialAttachmentRequest.setSpecialAttachmentPage(str2);
    localSpecialAttachmentRequestSender.send(localSpecialAttachmentRequest);
  }
  
  public void updateSpecialAttachmenFlag(String paramString1, String paramString2, String paramString3)
  {
    if (StringUtils.isEmpty(paramString1))
    {
      this.logger.error("任务号为空");
      return;
    }
    if (!"Y".equals(paramString2)) {
      this.logger.error("任务号为[" + paramString1 + "_syncSpecialAttachment]的影像同步特殊附件失败,失败原因为[" + paramString3 + "]");
    }
    String str = "update eid.eid_image_infos set sync_sa_flag = ? where enabled_flag = 'Y' and task_num = ?";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString2);
    localArrayList.add(paramString1);
    IImageCommonDS localIImageCommonDS = (IImageCommonDS)SSBBus.findDomainService("imageCommonDS");
    localIImageCommonDS.executeSql(str, localArrayList);
  }
  
  public void updateWaitSyncFlag(String paramString)
  {
    IImageCommonDS localIImageCommonDS = (IImageCommonDS)SSBBus.findDomainService("imageCommonDS");
    String str = "update eid_image_Infos set sync_sa_flag = ? where enabled_flag='Y' and image_number = ?";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("W");
    localArrayList.add(paramString);
    localIImageCommonDS.executeSql(str, localArrayList);
  }
  
  public String getWaitSyncFlag(String paramString)
  {
    IImageCommonDS localIImageCommonDS = (IImageCommonDS)SSBBus.findDomainService("imageCommonDS");
    String str = "select sync_sa_flag from eid_image_Infos  where enabled_flag='Y' and image_number = ?";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    List localList = localIImageCommonDS.findObjectBySQL(str, localArrayList, null);
    if ((localList != null) && (!localList.isEmpty())) {
      return (String)localList.get(0);
    }
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.SyncSpecialAttachmentDS
 * JD-Core Version:    0.7.0.1
 */