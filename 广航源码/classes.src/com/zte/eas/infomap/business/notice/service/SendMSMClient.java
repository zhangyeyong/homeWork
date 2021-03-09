package com.zte.eas.infomap.business.notice.service;

import com.zte.web.service.client.sendMSMService.CoreSMSReplyType;
import com.zte.web.service.client.sendMSMService.CoreSMSType;
import com.zte.web.service.client.sendMSMService.MessageReplyType;
import com.zte.web.service.client.sendMSMService.MessageType;
import com.zte.web.service.client.sendMSMService.SendMSMService_PortType;
import com.zte.web.service.client.sendMSMService.SendMSMService_ServiceLocator;
import com.zte.web.service.proxy.ISendMSMClient;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SendMSMClient
  implements ISendMSMClient
{
  Log log = LogFactory.getLog(SendMSMClient.class);
  
  public CoreSMSReplyType sendMSM(CoreSMSType paramCoreSMSType)
  {
    this.log.error("+++++++++++++++++++  短信通知服务 SendMSMClient.sendMSM begin +++++++++++++++++++++++++++++++++++++++++++++++++++++");
    this.log.error("input:  " + (paramCoreSMSType == null ? null : paramCoreSMSType.toString()));
    MessageReplyType[] arrayOfMessageReplyType;
    if (paramCoreSMSType != null)
    {
      this.log.error("appendID:  " + paramCoreSMSType.getAppendID());
      this.log.error("consumeSMSID:  " + paramCoreSMSType.getConsumeSMSID());
      this.log.error("departmentNO:  " + paramCoreSMSType.getDepartmentNO());
      this.log.error("operID:  " + paramCoreSMSType.getOperID());
      this.log.error("operPass:  " + paramCoreSMSType.getOperPass());
      this.log.error("sendTime:  " + paramCoreSMSType.getSendTime());
      this.log.error("message[]:  " + (paramCoreSMSType.getMessage() == null ? null : paramCoreSMSType.getMessage().toString()));
      if (paramCoreSMSType.getMessage() != null) {
        for (arrayOfMessageReplyType : paramCoreSMSType.getMessage())
        {
          this.log.error("desMobile:  " + arrayOfMessageReplyType.getDesMobile());
          this.log.error("content" + arrayOfMessageReplyType.getContent());
        }
      }
    }
    else
    {
      this.log.error("input is null");
    }
    ??? = null;
    SendMSMService_ServiceLocator localSendMSMService_ServiceLocator = null;
    SendMSMService_PortType localSendMSMService_PortType = null;
    try
    {
      localSendMSMService_ServiceLocator = new SendMSMService_ServiceLocator();
      localSendMSMService_PortType = localSendMSMService_ServiceLocator.getSendMSMServiceSOAP();
      ??? = localSendMSMService_PortType.sendMSMService(paramCoreSMSType);
      this.log.error("output:  " + (??? == null ? null : ???.toString()));
      if (??? != null)
      {
        this.log.error("consumeSMSID:  " + ((CoreSMSReplyType)???).getConsumeSMSID());
        this.log.error("code:  " + ((CoreSMSReplyType)???).getCode());
        if (((CoreSMSReplyType)???).getMessageReply() != null) {
          for (MessageReplyType localMessageReplyType : ((CoreSMSReplyType)???).getMessageReply())
          {
            this.log.error("desMobile:  " + localMessageReplyType.getDesMobile());
            this.log.error("sMSID:  " + localMessageReplyType.getSMSID());
          }
        }
      }
      else
      {
        this.log.error("output is null");
      }
    }
    catch (ServiceException localServiceException)
    {
      localServiceException.printStackTrace();
      this.log.error(localServiceException);
      return ???;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      this.log.error(localRemoteException);
      return ???;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.log.error(localException);
      return ???;
    }
    this.log.error("+++++++++++++++++++  短信通知服务 SendMSMClient.sendMSM end +++++++++++++++++++++++++++++++++++++++++++++++++++++");
    return ???;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.SendMSMClient
 * JD-Core Version:    0.7.0.1
 */