package com.zte.esb.services;

import com.zte.eas.organization.business.organizationmanage.service.IFbpDeptsVDS;
import com.zte.esb.bean.SendAdminOrgRequest;
import com.zte.esb.bean.SendAdminOrgResponse;
import com.zte.esb.trans.SendAdminOrgRequestTrans;
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

public class AdminOrgRequestListener
{
  private static Log log = LogFactory.getLog(AdminOrgRequestListener.class);
  private AdminOrgResponseSender adminOrgResponseSender;
  
  public void onMessage(Message paramMessage)
  {
    TextMessage localTextMessage = (TextMessage)paramMessage;
    StatusUtils.send(paramMessage, "ST_302");
    String str1 = UUID.randomUUID().toString();
    try
    {
      String str2 = localTextMessage.getText();
      log.info("接到的报文：" + str2);
      localObject = SendAdminOrgRequestTrans.toMessage(str2);
      if (null != localObject)
      {
        StatusUtils.send(paramMessage, "ST_305");
        List localList = ((SendAdminOrgRequest)localObject).getAdminOrgInfo();
        IFbpDeptsVDS localIFbpDeptsVDS = (IFbpDeptsVDS)SSBBus.findDomainService("fbpDeptsVDS");
        SendAdminOrgResponse localSendAdminOrgResponse = localIFbpDeptsVDS.syncDepts(localList);
        Map localMap2 = HeaderUtil.headerConverToMap(localTextMessage);
        this.adminOrgResponseSender.send(localSendAdminOrgResponse, localMap2, str1, true);
      }
    }
    catch (Exception localException1)
    {
      Object localObject = new CommonExceptionInfo();
      try
      {
        ((CommonExceptionInfo)localObject).setCreatedTime(DateUtil.getXMLGregorianCalendar(new Date()));
        ((CommonExceptionInfo)localObject).setDetailedInfo(localException1.getMessage());
        ((CommonExceptionInfo)localObject).setExceptioncode("ESB000066");
        ((CommonExceptionInfo)localObject).setExceptiontype("SystemException");
        ((CommonExceptionInfo)localObject).setMessage(localException1.getMessage());
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      try
      {
        Map localMap1 = HeaderUtil.headerConverToMap(localTextMessage);
        this.adminOrgResponseSender.send(localObject, localMap1, str1, false);
      }
      catch (JMSException localJMSException)
      {
        localJMSException.printStackTrace();
      }
      localException1.printStackTrace();
    }
  }
  
  public void setAdminOrgResponseSender(AdminOrgResponseSender paramAdminOrgResponseSender)
  {
    this.adminOrgResponseSender = paramAdminOrgResponseSender;
  }
  
  public AdminOrgResponseSender getAdminOrgResponseSender()
  {
    return this.adminOrgResponseSender;
  }
  
  public static void main(String[] paramArrayOfString) {}
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.services.AdminOrgRequestListener
 * JD-Core Version:    0.7.0.1
 */