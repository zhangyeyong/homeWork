package com.zte.esb.services;

import com.zte.eas.organization.user.syn.model.ds.ISyncDataDS;
import com.zte.esb.bean.SendPositionRequest;
import com.zte.esb.bean.SendPositionResponse;
import com.zte.esb.bean.SendUserInfoProcessReult;
import com.zte.esb.bean.SendUserInfoResponse;
import com.zte.esb.bean.UserInfo;
import com.zte.esb.trans.SendPositionRequestTrans;
import com.zte.esb.util.DateUtil;
import com.zte.esb.util.HeaderUtil;
import com.zte.esb.util.StatusUtils;
import com.zte.esb.util.exception.CommonExceptionInfo;
import com.zte.ssb.framework.SSBBus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SendPositionRequestListener
{
  private static Log log = LogFactory.getLog(SendPositionRequestListener.class);
  private SendPositionResponseSender sendPositionResponseSender;
  
  public void onMessage(Message paramMessage)
  {
    TextMessage localTextMessage = (TextMessage)paramMessage;
    StatusUtils.send(paramMessage, "ST_302");
    try
    {
      String str1 = localTextMessage.getText();
      log.info("接到的报文：" + str1);
      localObject = SendPositionRequestTrans.toMessage(str1);
      if (null != localObject)
      {
        StatusUtils.send(paramMessage, "ST_305");
        ISyncDataDS localISyncDataDS = (ISyncDataDS)SSBBus.findDomainService("syncDataNewDS");
        SendPositionResponse localSendPositionResponse = localISyncDataDS.syncPositions((SendPositionRequest)localObject);
        if (localSendPositionResponse == null) {
          localSendPositionResponse = new SendPositionResponse();
        }
        Map localMap2 = HeaderUtil.headerConverToMap(localTextMessage);
        String str2 = UUID.randomUUID().toString();
        this.sendPositionResponseSender.send(localSendPositionResponse, localMap2, str2, true);
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
        this.sendPositionResponseSender.send(localObject, localMap1, null, false);
      }
      catch (JMSException localJMSException)
      {
        localJMSException.printStackTrace();
      }
      localException1.printStackTrace();
    }
  }
  
  private void testinidate(SendUserInfoResponse paramSendUserInfoResponse, List<UserInfo> paramList)
  {
    paramSendUserInfoResponse.setSuccessCount(1);
    paramSendUserInfoResponse.setFailedCount(0);
    ArrayList localArrayList = new ArrayList();
    int i = paramList.size();
    for (int j = 0; j < i; j++)
    {
      UserInfo localUserInfo = (UserInfo)paramList.get(j);
      SendUserInfoProcessReult localSendUserInfoProcessReult = new SendUserInfoProcessReult();
      localSendUserInfoProcessReult.setAccountChangeId(localUserInfo.getAccountChangeId());
      localSendUserInfoProcessReult.setChangeType("1");
      localSendUserInfoProcessReult.setEmpCode(localUserInfo.getEmpCode());
      localSendUserInfoProcessReult.setResult(true);
      localArrayList.add(localSendUserInfoProcessReult);
    }
    paramSendUserInfoResponse.setProcessResult(localArrayList);
  }
  
  public SendPositionResponseSender getSendPositionResponseSender()
  {
    return this.sendPositionResponseSender;
  }
  
  public void setSendPositionResponseSender(SendPositionResponseSender paramSendPositionResponseSender)
  {
    this.sendPositionResponseSender = paramSendPositionResponseSender;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.services.SendPositionRequestListener
 * JD-Core Version:    0.7.0.1
 */