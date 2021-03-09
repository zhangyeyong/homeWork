package com.zte.eas.infomap.business.notice.service;

import com.zte.web.service.client.sendEmailPS.InputMessageType;
import com.zte.web.service.client.sendEmailPS.OutputMessageType;
import com.zte.web.service.client.sendEmailPS.SendEmailPS_PortType;
import com.zte.web.service.client.sendEmailPS.SendEmailPS_ServiceLocator;
import com.zte.web.service.proxy.ISendEmailClient;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SendEmailClient
  implements ISendEmailClient
{
  Log log = LogFactory.getLog(SendEmailClient.class);
  
  public OutputMessageType sendEmail(InputMessageType paramInputMessageType)
  {
    this.log.error("+++++++++++++++++++  邮件通知服务 SendEmailClient.sendEmail begin +++++++++++++++++++++++++++++++++++++++++++++++++++++");
    this.log.error("input:  " + (paramInputMessageType == null ? null : paramInputMessageType.toString()));
    if (paramInputMessageType != null)
    {
      this.log.error("consumerEmailID:  " + paramInputMessageType.getConsumerEmailID());
      this.log.error("mailCc:  " + paramInputMessageType.getMailCC());
      this.log.error("mailContent:  " + paramInputMessageType.getMailContent());
      this.log.error("mailSubject:  " + paramInputMessageType.getMailSubject());
      this.log.error("mailTo:  " + paramInputMessageType.getMailTo());
    }
    else
    {
      this.log.error("input is null");
    }
    SendEmailPS_ServiceLocator localSendEmailPS_ServiceLocator = null;
    SendEmailPS_PortType localSendEmailPS_PortType = null;
    OutputMessageType localOutputMessageType = null;
    try
    {
      localSendEmailPS_ServiceLocator = new SendEmailPS_ServiceLocator();
      localSendEmailPS_PortType = localSendEmailPS_ServiceLocator.getSendEmailPSSOAP();
      localOutputMessageType = localSendEmailPS_PortType.sendEmail(paramInputMessageType);
      this.log.error("output:  " + (localOutputMessageType == null ? null : localOutputMessageType.toString()));
      if (localOutputMessageType != null)
      {
        this.log.error("consumerEmailID:  " + localOutputMessageType.getConsumerEmailID());
        this.log.error("resultFlg:  " + localOutputMessageType.getResultFlag());
      }
      else
      {
        this.log.error("output is null");
      }
    }
    catch (ServiceException localServiceException)
    {
      localServiceException.printStackTrace();
      this.log.error(localServiceException, localServiceException);
      return localOutputMessageType;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      this.log.error(localRemoteException, localRemoteException);
      return localOutputMessageType;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.log.error(localException);
      return localOutputMessageType;
    }
    this.log.error("+++++++++++++++++++  邮件通知服务 SendEmailClient.sendEmail end +++++++++++++++++++++++++++++++++++++++++++++++++++++");
    return localOutputMessageType;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.business.notice.service.SendEmailClient
 * JD-Core Version:    0.7.0.1
 */