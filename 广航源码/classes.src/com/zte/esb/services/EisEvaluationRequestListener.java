package com.zte.esb.services;

import com.zte.eimage.business.baseconfig.service.IEvsAppraiseHistorisesDS;
import com.zte.esb.bean.SendUserInfoProcessReult;
import com.zte.esb.bean.SendUserInfoResponse;
import com.zte.esb.bean.UserInfo;
import com.zte.esb.bean.fssc.EisEvaluationRequest;
import com.zte.esb.bean.fssc.EisEvaluationResponse;
import com.zte.esb.trans.EisEvaluationRequestTrans;
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

public class EisEvaluationRequestListener
{
  private static Log log = LogFactory.getLog(EisEvaluationRequestListener.class);
  private EisEvaluationResponseSender eisEvaluationResponseSender;
  private IEvsAppraiseHistorisesDS evsAppraiseHistorisesDS;
  
  public void onMessage(Message paramMessage)
  {
    TextMessage localTextMessage = (TextMessage)paramMessage;
    StatusUtils.send(paramMessage, "ST_302");
    try
    {
      String str1 = localTextMessage.getText();
      log.info("接到的报文：" + str1);
      localObject = EisEvaluationRequestTrans.toMessage(str1);
      if (null != localObject)
      {
        StatusUtils.send(paramMessage, "ST_305");
        if (this.evsAppraiseHistorisesDS == null) {
          this.evsAppraiseHistorisesDS = ((IEvsAppraiseHistorisesDS)SSBBus.findDomainService("evsAppraiseHistorisesDS"));
        }
        String str2 = ((EisEvaluationRequest)localObject).getEisTaskNo();
        String str3 = ((EisEvaluationRequest)localObject).getEvaluateType();
        String str4 = "RESET_SCAN";
        if ("NORMAL_THROUGH".equals(str3)) {
          str4 = "ALREADY_FILING";
        }
        String str5 = ((EisEvaluationRequest)localObject).getEvaluateDescription();
        String str6 = ((EisEvaluationRequest)localObject).getEvaluatePerson();
        String str7 = this.evsAppraiseHistorisesDS.remarkVideo(str2, str4, str3, str5, str6);
        Boolean localBoolean = Boolean.valueOf("Y".equals(str7));
        String str8 = localBoolean.booleanValue() ? "" : str7;
        EisEvaluationResponse localEisEvaluationResponse = new EisEvaluationResponse();
        localEisEvaluationResponse.setClaimBillNumber(str2);
        localEisEvaluationResponse.setSuccessMark(localBoolean);
        localEisEvaluationResponse.setFailtureReason(str8);
        localEisEvaluationResponse.setEvaluationType(((EisEvaluationRequest)localObject).getEvaluateType());
        Map localMap2 = HeaderUtil.headerConverToMap(localTextMessage);
        String str9 = UUID.randomUUID().toString();
        this.eisEvaluationResponseSender.send(localEisEvaluationResponse, localMap2, str9, true);
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
        this.eisEvaluationResponseSender.send(localObject, localMap1, null, false);
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
  
  public EisEvaluationResponseSender getEisEvaluationResponseSender()
  {
    return this.eisEvaluationResponseSender;
  }
  
  public void setEisEvaluationResponseSender(EisEvaluationResponseSender paramEisEvaluationResponseSender)
  {
    this.eisEvaluationResponseSender = paramEisEvaluationResponseSender;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.services.EisEvaluationRequestListener
 * JD-Core Version:    0.7.0.1
 */