package com.zte.eas.getData.util;

import com.deppon.bpms.module.shared.domain.BpmsParticipant;
import com.deppon.bpmsapi.module.client.api.IDpBpmsClientFacade;
import com.deppon.bpmsapi.module.client.api.impl.DpBpmsClientFacadeImpl;
import com.deppon.bpmsapi.module.client.domain.BpmsOperateInfo;
import com.deppon.bpmsapi.module.client.domain.ParticipantRule;
import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eimage.business.baseconfig.service.IImageCommonDS;
import com.zte.evs.ebill.model.archives.FbpArchivesHeaders;
import com.zte.ssb.AccessPropertiesFile;
import com.zte.ssb.framework.SSBBus;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class ArchivesUtils
{
  static Logger logger = Logger.getLogger(ArchivesUtils.class);
  static String IS_WORK_FLOW = AccessPropertiesFile.getValue("IS_WORK_FLOW");
  
  public static IDpBpmsClientFacade getClient()
  {
    EasUserInfo localEasUserInfo = EisConsts.getCurrentUser();
    if (localEasUserInfo == null) {
      return null;
    }
    BranchRuleManagerImpl localBranchRuleManagerImpl = new BranchRuleManagerImpl();
    ParticipantRuleManagerImpl localParticipantRuleManagerImpl = new ParticipantRuleManagerImpl();
    DpBpmsClientFacadeImpl localDpBpmsClientFacadeImpl = new DpBpmsClientFacadeImpl(localBranchRuleManagerImpl, localParticipantRuleManagerImpl, localEasUserInfo.getUserId(), localEasUserInfo.getUserName());
    return localDpBpmsClientFacadeImpl;
  }
  
  public static String doSubmit(String paramString)
  {
    String str1 = "N";
    try
    {
      logger.error("调用工作流提交,单号[" + paramString + "]begin...");
      if ("N".equals(IS_WORK_FLOW))
      {
        str1 = "Y";
        logger.error("connectBpel.properties文件中配置了不走工作流系统!");
        return str1;
      }
      EasUserInfo localEasUserInfo = EisConsts.getCurrentUser();
      if (localEasUserInfo == null)
      {
        logger.error("获取当前登录用户失败!");
        return str1;
      }
      BranchRuleManagerImpl localBranchRuleManagerImpl = new BranchRuleManagerImpl();
      ParticipantRuleManagerImpl localParticipantRuleManagerImpl = new ParticipantRuleManagerImpl();
      DpBpmsClientFacadeImpl localDpBpmsClientFacadeImpl = new DpBpmsClientFacadeImpl(localBranchRuleManagerImpl, localParticipantRuleManagerImpl, localEasUserInfo.getUserId(), localEasUserInfo.getUserName());
      String str2 = "com.deppon.bpms.module.eis.bpsdesign.voucherBorrow.voucherBorrowApply";
      String str3 = "凭证借阅申请";
      String str4 = "凭证借阅申请";
      String str5 = paramString;
      long l = localDpBpmsClientFacadeImpl.createAndStartProcess(str2, str3, str4, str5);
      String str6 = "update fbp.fbp_archives_headers set process_id = ? where enabled_flag = 'Y' and apply_num = ?";
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(l));
      localArrayList.add(paramString);
      IImageCommonDS localIImageCommonDS = (IImageCommonDS)SSBBus.findDomainService("imageCommonDS");
      localIImageCommonDS.executeSql(str6, localArrayList);
      str1 = "Y";
      logger.error("调用工作流提交,单号[" + paramString + "]end...");
    }
    catch (Exception localException)
    {
      logger.error("借阅单[" + paramString + "]提交失败!" + localException.getMessage(), localException);
      str1 = "借阅单[" + paramString + "]提交失败!失败原因：" + localException.getMessage();
    }
    return str1;
  }
  
  public static String approve(int paramInt, String paramString)
  {
    String str1 = "N";
    try
    {
      logger.error("调用工作流审批,单号[" + paramString + "]begin...");
      if ("N".equals(IS_WORK_FLOW))
      {
        str1 = "Y";
        logger.error("connectBpel.properties文件中配置了不走工作流系统!");
        return str1;
      }
      EasUserInfo localEasUserInfo = EisConsts.getCurrentUser();
      if (localEasUserInfo == null)
      {
        logger.error("获取当前登录用户失败!");
        return str1;
      }
      BranchRuleManagerImpl localBranchRuleManagerImpl = new BranchRuleManagerImpl();
      ParticipantRuleManagerImpl localParticipantRuleManagerImpl = new ParticipantRuleManagerImpl();
      DpBpmsClientFacadeImpl localDpBpmsClientFacadeImpl = new DpBpmsClientFacadeImpl(localBranchRuleManagerImpl, localParticipantRuleManagerImpl, localEasUserInfo.getUserId(), localEasUserInfo.getUserName());
      BpmsOperateInfo localBpmsOperateInfo = new BpmsOperateInfo();
      String str2 = "select * from fbp.fbp_archives_headers ah where ah.enabled_flag = 'Y' and ah.apply_num = ?";
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      IImageCommonDS localIImageCommonDS = (IImageCommonDS)SSBBus.findDomainService("imageCommonDS");
      FbpArchivesHeaders localFbpArchivesHeaders = (FbpArchivesHeaders)localIImageCommonDS.findObject(str2, localArrayList, FbpArchivesHeaders.class);
      if (localFbpArchivesHeaders == null) {
        return str1;
      }
      long l1 = localFbpArchivesHeaders.getProcessId().longValue();
      long l2 = localFbpArchivesHeaders.getWorkItemId().longValue();
      if (1 == paramInt)
      {
        localBpmsOperateInfo.setApproveOpinion("不同意!");
      }
      else
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("processInstID", Long.valueOf(l1));
        BpmsParticipant[] arrayOfBpmsParticipant = new ArchivesUtils().getArchivesManager(null, localHashMap);
        if ((arrayOfBpmsParticipant == null) || (arrayOfBpmsParticipant.length == 0)) {
          return "M";
        }
        localBpmsOperateInfo.setApproveOpinion("同意");
      }
      localBpmsOperateInfo.setOperateType(paramInt);
      localBpmsOperateInfo.setOperateDate(new Date());
      boolean bool = localDpBpmsClientFacadeImpl.send(l2, l1, localBpmsOperateInfo, null);
      logger.error("调用工作流审批,单号[" + paramString + "]返回:" + bool);
      if (bool) {
        str1 = "Y";
      }
      logger.error("调用工作流审批,单号[" + paramString + "]end...");
    }
    catch (Exception localException)
    {
      logger.error("借阅单[" + paramString + "]审批失败!" + localException.getMessage(), localException);
      str1 = "借阅单[" + paramString + "]审批失败!失败原因:" + localException.getMessage();
    }
    return str1;
  }
  
  public BpmsParticipant[] getArchivesManager(ParticipantRule paramParticipantRule, Map<?, ?> paramMap)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("select distinct da.doc_admin_code, da.doc_admin_name");
    localStringBuffer.append("  from fbp.fbp_archives_headers     ah,");
    localStringBuffer.append("       fbp.fbp_archives_lines       al,");
    localStringBuffer.append("       apps.evs_book_voucher_v\t \tbp,");
    localStringBuffer.append("       evs.evs_inventory            ei,");
    localStringBuffer.append("       evs.evs_storage_doc          sd,");
    localStringBuffer.append("       evs.evs_doc_admin            da");
    localStringBuffer.append(" where ah.archives_header_id = al.archives_header_id");
    localStringBuffer.append("   and al.voucher_id = bp.voucher_id");
    localStringBuffer.append("   and bp.book_id = ei.inv_book_id");
    localStringBuffer.append("   and ei.inv_storage_code = sd.storage_code");
    localStringBuffer.append("   and sd.storage_id = da.storage_id");
    localStringBuffer.append("   and ei.enabled_flag = 'Y'");
    localStringBuffer.append("   and ah.enabled_flag = 'Y'");
    localStringBuffer.append("   and al.enabled_flag = 'Y'");
    localStringBuffer.append("   and sd.enabled_flag = 'Y'");
    localStringBuffer.append("   and da.enabled_flag = 'Y'");
    localStringBuffer.append("   and ah.process_id = ?");
    ArrayList localArrayList = new ArrayList();
    long l = ((Long)paramMap.get("processInstID")).longValue();
    localArrayList.add(Long.valueOf(l));
    IImageCommonDS localIImageCommonDS = (IImageCommonDS)SSBBus.findDomainService("imageCommonDS");
    List localList = localIImageCommonDS.findObjectBySQL(localStringBuffer.toString(), localArrayList, null);
    BpmsParticipant[] arrayOfBpmsParticipant = null;
    if ((localList != null) && (!localList.isEmpty()))
    {
      arrayOfBpmsParticipant = new BpmsParticipant[localList.size()];
      for (int i = 0; i < localList.size(); i++)
      {
        Object[] arrayOfObject = (Object[])localList.get(i);
        BpmsParticipant localBpmsParticipant = new BpmsParticipant();
        localBpmsParticipant.setId(arrayOfObject[0] == null ? "" : arrayOfObject[0].toString());
        localBpmsParticipant.setName(arrayOfObject[1] == null ? "" : arrayOfObject[1].toString());
        localBpmsParticipant.setTypeCode("person");
        arrayOfBpmsParticipant[i] = localBpmsParticipant;
      }
    }
    return arrayOfBpmsParticipant;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.util.ArchivesUtils
 * JD-Core Version:    0.7.0.1
 */