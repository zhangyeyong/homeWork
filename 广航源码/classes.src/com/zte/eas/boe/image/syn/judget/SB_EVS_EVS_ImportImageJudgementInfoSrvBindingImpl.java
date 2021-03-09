package com.zte.eas.boe.image.syn.judget;

import com.zte.eimage.business.baseconfig.service.IEvsAppraiseHistorisesDS;
import com.zte.ssb.framework.SSBBus;
import java.rmi.RemoteException;
import java.util.Calendar;
import org.apache.log4j.Logger;

public class SB_EVS_EVS_ImportImageJudgementInfoSrvBindingImpl
  implements SB_EVS_EVS_ImportImageJudgementInfoSrv_PortType
{
  private Logger log = Logger.getLogger(getClass());
  
  public ImportSrvResponse process(SB_EVS_EVS_ImportImageJudgementInfoSrvRequest paramSB_EVS_EVS_ImportImageJudgementInfoSrvRequest)
    throws RemoteException
  {
    IEvsAppraiseHistorisesDS localIEvsAppraiseHistorisesDS = (IEvsAppraiseHistorisesDS)SSBBus.findDomainService("evsAppraiseHistorisesDS");
    ImportSrvResponse localImportSrvResponse = new ImportSrvResponse();
    if (paramSB_EVS_EVS_ImportImageJudgementInfoSrvRequest != null)
    {
      MsgHeader localMsgHeader = paramSB_EVS_EVS_ImportImageJudgementInfoSrvRequest.getMsgHeader();
      ImportImageJudgementInfoSrvInputItem[] arrayOfImportImageJudgementInfoSrvInputItem1 = paramSB_EVS_EVS_ImportImageJudgementInfoSrvRequest.getImportImageJudgementInfoSrvInputCollection();
      if (localMsgHeader != null)
      {
        this.log.error("Request MsgHeader SOURCE_SYSTEM_ID:" + localMsgHeader.getSOURCE_SYSTEM_ID());
        this.log.error("Request MsgHeader SOURCE_SYSTEM_NAME:" + localMsgHeader.getSOURCE_SYSTEM_NAME());
        this.log.error("Request MsgHeader USER_ID:" + localMsgHeader.getUSER_ID());
        this.log.error("Request MsgHeader USER_NAME:" + localMsgHeader.getUSER_NAME());
        this.log.error("Request MsgHeader SUBMIT_DATE:" + localMsgHeader.getSUBMIT_DATE().getTime());
      }
      if (arrayOfImportImageJudgementInfoSrvInputItem1 != null)
      {
        int i = 0;
        for (ImportImageJudgementInfoSrvInputItem localImportImageJudgementInfoSrvInputItem : arrayOfImportImageJudgementInfoSrvInputItem1) {
          if (localImportImageJudgementInfoSrvInputItem != null)
          {
            this.log.error("InputItem[" + i + "] PRI_KEY:" + localImportImageJudgementInfoSrvInputItem.getPRI_KEY());
            this.log.error("InputItem[" + i + "] BATCH_NAME:" + localImportImageJudgementInfoSrvInputItem.getBATCH_NAME());
            this.log.error("InputItem[" + i + "] BOE_NUM:" + localImportImageJudgementInfoSrvInputItem.getBOE_NUM());
            this.log.error("InputItem[" + i + "] JUDGE_TYPE:" + localImportImageJudgementInfoSrvInputItem.getJUDGE_TYPE());
            this.log.error("InputItem[" + i + "] PROBLEM:" + localImportImageJudgementInfoSrvInputItem.getPROBLEM());
            this.log.error("InputItem[" + i + "] DETAILS:" + localImportImageJudgementInfoSrvInputItem.getDETAILS());
            this.log.error("InputItem[" + i + "] EMPLOYEE_NUM:" + localImportImageJudgementInfoSrvInputItem.getEMPLOYEE_NUM());
            String str = localIEvsAppraiseHistorisesDS.remarkVideo(localImportImageJudgementInfoSrvInputItem.getBOE_NUM(), localImportImageJudgementInfoSrvInputItem.getJUDGE_TYPE(), localImportImageJudgementInfoSrvInputItem.getPROBLEM(), localImportImageJudgementInfoSrvInputItem.getDETAILS(), localImportImageJudgementInfoSrvInputItem.getEMPLOYEE_NUM());
            Object localObject1;
            Object localObject2;
            if ("Y".equals(str))
            {
              localImportSrvResponse.setSERVICE_FLAG("Y");
              localImportSrvResponse.setSERVICE_MESSAGE("评价成功");
              localObject1 = new ResponseItem();
              ((ResponseItem)localObject1).setREQUEST_ID(localImportImageJudgementInfoSrvInputItem.getPRI_KEY());
              ((ResponseItem)localObject1).setRECORD_NUMBER(localImportImageJudgementInfoSrvInputItem.getBOE_NUM());
              localObject2 = new ResponseItem[] { localObject1 };
              localImportSrvResponse.setResponseCollecion((ResponseItem[])localObject2);
            }
            if ("JUDGE_TYPE_ERROR".equals(str))
            {
              localImportSrvResponse.setSERVICE_FLAG("N");
              localImportSrvResponse.setSERVICE_MESSAGE("评价类型不正确！");
              localObject1 = new ErrorItem();
              ((ErrorItem)localObject1).setRECORD_NUMBER(localImportImageJudgementInfoSrvInputItem.getPRI_KEY());
              ((ErrorItem)localObject1).setENTITY_NAME("IMAGEJUDGEMENT");
              localObject2 = new ErrorItem[] { localObject1 };
              localImportSrvResponse.setErrorCollection((ErrorItem[])localObject2);
            }
            if ("IMAGE_INFO_NULL".equals(str))
            {
              localImportSrvResponse.setSERVICE_FLAG("N");
              localImportSrvResponse.setSERVICE_MESSAGE("单据对应的影像编号不存在！");
              localObject1 = new ErrorItem();
              ((ErrorItem)localObject1).setRECORD_NUMBER(localImportImageJudgementInfoSrvInputItem.getPRI_KEY());
              ((ErrorItem)localObject1).setENTITY_NAME("IMAGEJUDGEMENT");
              localObject2 = new ErrorItem[] { localObject1 };
              localImportSrvResponse.setErrorCollection((ErrorItem[])localObject2);
            }
            if ("EXCEPTION".equals(str))
            {
              localImportSrvResponse.setSERVICE_FLAG("N");
              localImportSrvResponse.setSERVICE_MESSAGE("调用接口异常！");
              localObject1 = new ErrorItem();
              ((ErrorItem)localObject1).setRECORD_NUMBER(localImportImageJudgementInfoSrvInputItem.getPRI_KEY());
              ((ErrorItem)localObject1).setENTITY_NAME("IMAGEJUDGEMENT");
              localObject2 = new ErrorItem[] { localObject1 };
              localImportSrvResponse.setErrorCollection((ErrorItem[])localObject2);
            }
            i++;
          }
        }
      }
    }
    return localImportSrvResponse;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.boe.image.syn.judget.SB_EVS_EVS_ImportImageJudgementInfoSrvBindingImpl
 * JD-Core Version:    0.7.0.1
 */