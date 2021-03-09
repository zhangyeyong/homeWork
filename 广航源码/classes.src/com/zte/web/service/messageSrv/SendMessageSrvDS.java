package com.zte.web.service.messageSrv;

import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;
import com.zte.eas.infomap.business.notice.service.IFbpNoticesNewDS;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.eimage.business.baseconfig.service.IImageCommonDS;
import com.zte.ssb.framework.SSBBus;
import com.zte.web.service.messageSrv.services.SendMessageSrvRequest;
import com.zte.web.service.messageSrv.services.SendMessageSrvResponse;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

public class SendMessageSrvDS
  implements ISendMessageSrvDS
{
  private final String TEMPLATE_1 = "您好，您经办的#BOE_NUM#单号的业务被审核退回。退回类型为#REJECT_TYPE#，退回原因为#REJECT_REASON#，请及时整改后重新提交给单证管理员。";
  private final String TEMPLATE_2 = "您好，您扫描上传的#BOE_NUM#任务编号的影像文件被审核退回。退回类型为#REJECT_TYPE#，退回原因为#REJECT_REASON#，请及时通知经办人整改和重新扫描上传。";
  private final String FLAG_Y = "TRUE";
  private final String FLAG_N = "FALSE";
  Logger logger = Logger.getLogger(SendMessageSrvDS.class);
  
  public SendMessageSrvResponse[] process(SendMessageSrvRequest[] paramArrayOfSendMessageSrvRequest)
  {
    if ((paramArrayOfSendMessageSrvRequest == null) || (paramArrayOfSendMessageSrvRequest.length == 0))
    {
      localObject = new SendMessageSrvResponse();
      ((SendMessageSrvResponse)localObject).setErrorFlag("FALSE");
      ((SendMessageSrvResponse)localObject).setErrorMessage("请求信息不能为空!");
      return new SendMessageSrvResponse[] { localObject };
    }
    Object localObject = new SendMessageSrvResponse[paramArrayOfSendMessageSrvRequest.length];
    IImageCommonDS localIImageCommonDS = (IImageCommonDS)SSBBus.findDomainService("imageCommonDS");
    IFbpNoticesNewDS localIFbpNoticesNewDS = (IFbpNoticesNewDS)SSBBus.findDomainService("fbpNoticesNewDS");
    String str1 = "select * from eid.eid_image_infos where enabled_flag = 'Y' and task_num = ?";
    String str2 = "select * from fbp.fbp_employees where enabled_flag = 'Y' and employee_number = ?";
    for (int i = 0; i < paramArrayOfSendMessageSrvRequest.length; i++)
    {
      SendMessageSrvResponse localSendMessageSrvResponse = new SendMessageSrvResponse();
      SendMessageSrvRequest localSendMessageSrvRequest = paramArrayOfSendMessageSrvRequest[i];
      try
      {
        if ((localSendMessageSrvRequest.getEmployeeNumber() == null) || (localSendMessageSrvRequest.getEmployeeNumber().trim().length() == 0))
        {
          localSendMessageSrvResponse.setBoeNum(localSendMessageSrvRequest.getBoeNum());
          localSendMessageSrvResponse.setEmployeeNumber(localSendMessageSrvRequest.getEmployeeNumber());
          localSendMessageSrvResponse.setErrorFlag("FALSE");
          localSendMessageSrvResponse.setErrorMessage("经办人不能为空!");
          localObject[i] = localSendMessageSrvResponse;
        }
        else if ((localSendMessageSrvRequest.getBoeNum() == null) || (localSendMessageSrvRequest.getBoeNum().trim().length() == 0))
        {
          localSendMessageSrvResponse.setBoeNum(localSendMessageSrvRequest.getBoeNum());
          localSendMessageSrvResponse.setEmployeeNumber(localSendMessageSrvRequest.getEmployeeNumber());
          localSendMessageSrvResponse.setErrorFlag("FALSE");
          localSendMessageSrvResponse.setErrorMessage("单据编号不能为空!");
          localObject[i] = localSendMessageSrvResponse;
        }
        else
        {
          ArrayList localArrayList1 = new ArrayList();
          localArrayList1.add(localSendMessageSrvRequest.getBoeNum());
          List localList1 = localIImageCommonDS.findObjectBySQL(str1, localArrayList1, EidImageInfos.class);
          if ((localList1 == null) || (localList1.isEmpty()))
          {
            localSendMessageSrvResponse.setBoeNum(localSendMessageSrvRequest.getBoeNum());
            localSendMessageSrvResponse.setEmployeeNumber(localSendMessageSrvRequest.getEmployeeNumber());
            localSendMessageSrvResponse.setErrorFlag("FALSE");
            localSendMessageSrvResponse.setErrorMessage("根据单据编号找不到对应的影像信息!");
            localObject[i] = localSendMessageSrvResponse;
          }
          else
          {
            EidImageInfos localEidImageInfos = (EidImageInfos)localList1.get(0);
            ArrayList localArrayList2 = new ArrayList();
            localArrayList2.add(localSendMessageSrvRequest.getEmployeeNumber());
            List localList2 = localIImageCommonDS.findObjectBySQL(str2, localArrayList2, FbpEmployees.class);
            if ((localList2 == null) || (localList2.isEmpty()))
            {
              localSendMessageSrvResponse.setBoeNum(localSendMessageSrvRequest.getBoeNum());
              localSendMessageSrvResponse.setEmployeeNumber(localSendMessageSrvRequest.getEmployeeNumber());
              localSendMessageSrvResponse.setErrorFlag("FALSE");
              localSendMessageSrvResponse.setErrorMessage("单证管理员不存在!");
              localObject[i] = localSendMessageSrvResponse;
            }
            else
            {
              FbpEmployees localFbpEmployees = (FbpEmployees)localList2.get(0);
              String str3 = new String("您好，您经办的#BOE_NUM#单号的业务被审核退回。退回类型为#REJECT_TYPE#，退回原因为#REJECT_REASON#，请及时整改后重新提交给单证管理员。");
              str3 = str3.replace("#BOE_NUM#", localSendMessageSrvRequest.getBoeNum()).replace("#REJECT_TYPE#", localSendMessageSrvRequest.getRejectType()).replace("#REJECT_REASON#", localSendMessageSrvRequest.getRejectReason());
              String str4 = new String("您好，您扫描上传的#BOE_NUM#任务编号的影像文件被审核退回。退回类型为#REJECT_TYPE#，退回原因为#REJECT_REASON#，请及时通知经办人整改和重新扫描上传。");
              str4 = str4.replace("#BOE_NUM#", localSendMessageSrvRequest.getBoeNum()).replace("#REJECT_TYPE#", localSendMessageSrvRequest.getRejectType()).replace("#REJECT_REASON#", localSendMessageSrvRequest.getRejectReason());
              localIFbpNoticesNewDS.insertFbpNoticesNew(getFbpNoticesNew(localEidImageInfos.getImageInfoId(), str3, "1", localEidImageInfos.getUploadEmployeeId().toString()));
              localIFbpNoticesNewDS.insertFbpNoticesNew(getFbpNoticesNew(localEidImageInfos.getImageInfoId(), str3, "2", localEidImageInfos.getUploadEmployeeId().toString()));
              localIFbpNoticesNewDS.insertFbpNoticesNew(getFbpNoticesNew(localEidImageInfos.getImageInfoId(), str4, "1", localFbpEmployees.getEmployeeId().toString()));
              localIFbpNoticesNewDS.insertFbpNoticesNew(getFbpNoticesNew(localEidImageInfos.getImageInfoId(), str4, "2", localFbpEmployees.getEmployeeId().toString()));
              localSendMessageSrvResponse.setBoeNum(localSendMessageSrvRequest.getBoeNum());
              localSendMessageSrvResponse.setEmployeeNumber(localSendMessageSrvRequest.getEmployeeNumber());
              localSendMessageSrvResponse.setErrorFlag("TRUE");
              localSendMessageSrvResponse.setErrorMessage("消息发送成功!");
              localObject[i] = localSendMessageSrvResponse;
            }
          }
        }
      }
      catch (Exception localException)
      {
        this.logger.error("发送消息服务异常:" + localException.getMessage(), localException);
        localSendMessageSrvResponse.setBoeNum(localSendMessageSrvRequest.getBoeNum());
        localSendMessageSrvResponse.setEmployeeNumber(localSendMessageSrvRequest.getEmployeeNumber());
        localSendMessageSrvResponse.setErrorFlag("FALSE");
        localSendMessageSrvResponse.setErrorMessage("系统异常!" + localException.getMessage());
        localObject[i] = localSendMessageSrvResponse;
      }
    }
    return localObject;
  }
  
  private FbpNoticesNew getFbpNoticesNew(Long paramLong, String paramString1, String paramString2, String paramString3)
  {
    FbpNoticesNew localFbpNoticesNew = new FbpNoticesNew();
    localFbpNoticesNew.setBoeHeaderId(paramLong);
    localFbpNoticesNew.setContent(paramString1);
    localFbpNoticesNew.setCreationDate(new Date());
    localFbpNoticesNew.setFromUserId(Long.valueOf(1L));
    localFbpNoticesNew.setIsRuning("N");
    localFbpNoticesNew.setNoticeType(paramString2);
    localFbpNoticesNew.setOperationType(Integer.valueOf(1));
    localFbpNoticesNew.setStatus(Integer.valueOf(0));
    localFbpNoticesNew.setSubmitUserId(Long.valueOf(1L));
    localFbpNoticesNew.setToUserId(paramString3);
    return localFbpNoticesNew;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.messageSrv.SendMessageSrvDS
 * JD-Core Version:    0.7.0.1
 */