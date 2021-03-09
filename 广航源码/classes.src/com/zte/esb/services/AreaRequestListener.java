package com.zte.esb.services;

import com.zte.eas.organization.business.organizationmanage.service.IFbpDeptsVDS;
import com.zte.esb.bean.foss.SyncDistrictRequest;
import com.zte.esb.bean.foss.SyncDistrictResponse;
import com.zte.esb.trans.AreaRequestListenerTrans;
import com.zte.esb.util.DateUtil;
import com.zte.esb.util.HeaderUtil;
import com.zte.esb.util.StatusUtils;
import com.zte.esb.util.exception.CommonExceptionInfo;
import com.zte.ssb.framework.SSBBus;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AreaRequestListener
{
  private static Log log = LogFactory.getLog(AreaRequestListener.class);
  private AreaResponseSender areaResponseSender;
  
  public void onMessage(Message paramMessage)
  {
    TextMessage localTextMessage = (TextMessage)paramMessage;
    StatusUtils.send(paramMessage, "ST_302");
    try
    {
      String str1 = localTextMessage.getText();
      log.info("接到的报文：" + str1);
      localObject = AreaRequestListenerTrans.toMessage(str1);
      if (null != localObject)
      {
        StatusUtils.send(paramMessage, "ST_305");
        List localList = ((SyncDistrictRequest)localObject).getDistrictInfo();
        if (localList != null)
        {
          IFbpDeptsVDS localIFbpDeptsVDS = (IFbpDeptsVDS)SSBBus.findDomainService("fbpDeptsVDS");
          SyncDistrictResponse localSyncDistrictResponse = localIFbpDeptsVDS.syncFossArea(localList);
          Map localMap2 = HeaderUtil.headerConverToMap(localTextMessage);
          String str2 = UUID.randomUUID().toString();
          this.areaResponseSender.send(localSyncDistrictResponse, localMap2, str2, true);
        }
      }
    }
    catch (Exception localException1)
    {
      Object localObject = new CommonExceptionInfo();
      try
      {
        ((CommonExceptionInfo)localObject).setCreatedTime(DateUtil.getXMLGregorianCalendar(new Date()));
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      ((CommonExceptionInfo)localObject).setDetailedInfo(localException1.getMessage());
      ((CommonExceptionInfo)localObject).setExceptioncode("ESB000066");
      ((CommonExceptionInfo)localObject).setExceptiontype("SystemException");
      ((CommonExceptionInfo)localObject).setMessage(localException1.getMessage());
      try
      {
        Map localMap1 = HeaderUtil.headerConverToMap(localTextMessage);
        this.areaResponseSender.send(localObject, localMap1, null, false);
      }
      catch (JMSException localJMSException)
      {
        localJMSException.printStackTrace();
      }
      localException1.printStackTrace();
    }
  }
  
  public AreaResponseSender getAreaResponseSender()
  {
    return this.areaResponseSender;
  }
  
  public void setAreaResponseSender(AreaResponseSender paramAreaResponseSender)
  {
    this.areaResponseSender = paramAreaResponseSender;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.services.AreaRequestListener
 * JD-Core Version:    0.7.0.1
 */