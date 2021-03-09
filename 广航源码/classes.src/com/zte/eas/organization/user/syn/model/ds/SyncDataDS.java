package com.zte.eas.organization.user.syn.model.ds;

import com.zte.eas.organization.business.countcompanymanage.service.DataSourceU;
import com.zte.eimage.access.baseconfig.dao.IImageCommonDAO;
import com.zte.eimage.business.baseconfig.model.FbpDegreeInfo;
import com.zte.eimage.business.baseconfig.model.FbpPositions;
import com.zte.eimage.business.baseconfig.model.FbpPositionsTl;
import com.zte.eimage.business.baseconfig.model.FbpPositionsTlPk;
import com.zte.esb.bean.DegreeInfo;
import com.zte.esb.bean.PositionInfo;
import com.zte.esb.bean.SendDegreeProcessReult;
import com.zte.esb.bean.SendDegreeRequest;
import com.zte.esb.bean.SendDegreeResponse;
import com.zte.esb.bean.SendPositionProcessReult;
import com.zte.esb.bean.SendPositionRequest;
import com.zte.esb.bean.SendPositionResponse;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.ssbext.lang.LangType;
import com.zte.ssb.ssbext.lang.LangUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

public class SyncDataDS
  implements ISyncDataDS
{
  Logger logger = Logger.getLogger(getClass());
  
  public SendPositionResponse syncPositions(SendPositionRequest paramSendPositionRequest)
  {
    SendPositionResponse localSendPositionResponse = new SendPositionResponse();
    ArrayList localArrayList1 = new ArrayList();
    SendPositionProcessReult localSendPositionProcessReult = null;
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(0);
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    String str1 = "select * from fbp.fbp_positions where position_code = ?";
    ArrayList localArrayList2 = new ArrayList();
    String str2 = "select * from fbp.fbp_positions_tl where position_id = ? and language = ?";
    ArrayList localArrayList3 = new ArrayList();
    try
    {
      String str3 = "1";
      if (paramSendPositionRequest == null)
      {
        localSendPositionProcessReult = new SendPositionProcessReult();
        localSendPositionProcessReult.setReason("传入参数不能为空!");
        localSendPositionProcessReult.setResult(Boolean.FALSE.booleanValue());
        localArrayList1.add(localSendPositionProcessReult);
        localSendPositionResponse.setFailedCount(localInteger1.intValue());
        localSendPositionResponse.setSuccessCount(localInteger2.intValue());
        localSendPositionResponse.setProcessResult(localArrayList1);
        return localSendPositionResponse;
      }
      List localList1 = paramSendPositionRequest.getPositionInfo();
      if ((localList1 == null) || (localList1.isEmpty()))
      {
        localSendPositionProcessReult = new SendPositionProcessReult();
        localSendPositionProcessReult.setReason("传入参数不能为空!");
        localSendPositionProcessReult.setResult(Boolean.FALSE.booleanValue());
        localArrayList1.add(localSendPositionProcessReult);
        localSendPositionResponse.setFailedCount(localInteger1.intValue());
        localSendPositionResponse.setSuccessCount(localInteger2.intValue());
        localSendPositionResponse.setProcessResult(localArrayList1);
        return localSendPositionResponse;
      }
      List localList2 = LangUtil.listLangTypes();
      for (int i = 0; i < localList1.size(); i++)
      {
        PositionInfo localPositionInfo = (PositionInfo)localList1.get(i);
        try
        {
          if (localPositionInfo == null)
          {
            localSendPositionProcessReult.setReason("传入参数不能为空!");
            localSendPositionProcessReult.setResult(Boolean.FALSE.booleanValue());
            localArrayList1.add(localSendPositionProcessReult);
            continue;
          }
          localArrayList2.clear();
          localArrayList2.add(localPositionInfo.getPositionCode());
          FbpPositions localFbpPositions = (FbpPositions)localIImageCommonDAO.findObject(str1, localArrayList2, FbpPositions.class);
          if (localFbpPositions == null)
          {
            localFbpPositions = new FbpPositions();
            localFbpPositions.setCreatedBy(Long.valueOf(1L));
            localFbpPositions.setLastUpdatedBy(Long.valueOf(1L));
            localFbpPositions.setLastUpdateLogin(Long.valueOf(1L));
            localFbpPositions.setCreationDate(new Date());
          }
          localFbpPositions.setLastUpdateDate(new Date());
          localFbpPositions.setPositionCode(localPositionInfo.getPositionCode());
          localObject1 = "Y";
          if ("1".equals(localPositionInfo.getStatus()))
          {
            localObject1 = "N";
            str3 = "3";
          }
          else
          {
            str3 = "2";
          }
          localFbpPositions.setEnabledFlag((String)localObject1);
          localFbpPositions.setAttributeCategory("");
          if (localFbpPositions.getPositionId() == null)
          {
            str3 = "1";
            localIImageCommonDAO.insertObject(localFbpPositions);
          }
          else
          {
            localIImageCommonDAO.updateObject(localFbpPositions);
          }
          localObject2 = localList2.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (LangType)((Iterator)localObject2).next();
            String str4 = DataSourceU.getLang(((LangType)localObject3).getCode());
            localArrayList3.clear();
            localArrayList3.add(localFbpPositions.getPositionId());
            localArrayList3.add(str4);
            FbpPositionsTlPk localFbpPositionsTlPk = new FbpPositionsTlPk();
            localFbpPositionsTlPk.setLanguage(str4);
            localFbpPositionsTlPk.setPositionId(localFbpPositions.getPositionId());
            FbpPositionsTl localFbpPositionsTl = (FbpPositionsTl)localIImageCommonDAO.findObject(str2, localArrayList3, FbpPositionsTl.class);
            Boolean localBoolean = Boolean.valueOf(true);
            if (localFbpPositionsTl == null)
            {
              localFbpPositionsTl = new FbpPositionsTl();
              localFbpPositionsTl.setCreatedBy(Long.valueOf(1L));
              localFbpPositionsTl.setLastUpdatedBy(Long.valueOf(1L));
              localFbpPositionsTl.setLastUpdateLogin(Long.valueOf(1L));
              localFbpPositionsTl.setCreationDate(new Date());
              localBoolean = Boolean.valueOf(false);
            }
            localFbpPositionsTl.setLastUpdateDate(new Date());
            localFbpPositionsTl.setSourceLang(str4);
            localFbpPositionsTl.setPositionName(localPositionInfo.getPositionName());
            localFbpPositionsTl.setPositionsTlPK(localFbpPositionsTlPk);
            if (localBoolean.booleanValue()) {
              localIImageCommonDAO.updateObject(localFbpPositionsTl);
            } else {
              localIImageCommonDAO.insertObject(localFbpPositionsTl);
            }
          }
          localObject2 = localInteger2;
          Object localObject3 = localInteger2 = Integer.valueOf(localInteger2.intValue() + 1);
          localSendPositionProcessReult = setSendPositionProcessReult(localPositionInfo, "", Boolean.TRUE, str3);
        }
        catch (Exception localException2)
        {
          this.logger.error("同步职位信息异常：" + localException2.getMessage(), localException2);
          Object localObject1 = localInteger1;
          Object localObject2 = localInteger1 = Integer.valueOf(localInteger1.intValue() + 1);
          localSendPositionProcessReult = setSendPositionProcessReult(localPositionInfo, "同步职位信息异常：" + localException2.getMessage(), Boolean.FALSE, str3);
        }
        localArrayList1.add(localSendPositionProcessReult);
      }
    }
    catch (Exception localException1)
    {
      this.logger.error("同步职位异常：" + localException1.getMessage(), localException1);
    }
    localSendPositionResponse.setFailedCount(localInteger1.intValue());
    localSendPositionResponse.setSuccessCount(localInteger2.intValue());
    localSendPositionResponse.setProcessResult(localArrayList1);
    return localSendPositionResponse;
  }
  
  public SendDegreeResponse syncDegreeInfo(SendDegreeRequest paramSendDegreeRequest)
  {
    SendDegreeResponse localSendDegreeResponse = new SendDegreeResponse();
    ArrayList localArrayList1 = new ArrayList();
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(0);
    try
    {
      SendDegreeProcessReult localSendDegreeProcessReult = null;
      if ((paramSendDegreeRequest == null) || (paramSendDegreeRequest.getDegreeInfo() == null) || (paramSendDegreeRequest.getDegreeInfo().isEmpty()))
      {
        localSendDegreeProcessReult = new SendDegreeProcessReult();
        localSendDegreeProcessReult.setReason("传入参数不能为空!");
        localSendDegreeProcessReult.setResult(Boolean.FALSE.booleanValue());
        localArrayList1.add(localSendDegreeProcessReult);
        localSendDegreeResponse.setFailedCount(localInteger1.intValue());
        localSendDegreeResponse.setSuccessCount(localInteger2.intValue());
        localSendDegreeResponse.setProcessResult(localArrayList1);
        return localSendDegreeResponse;
      }
      String str1 = "1";
      String str2 = "select * from fbp.FBP_DEGREE_INFO where DEGREE_CODE = ?";
      ArrayList localArrayList2 = new ArrayList();
      IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
      List localList = paramSendDegreeRequest.getDegreeInfo();
      for (int i = 0; i < localList.size(); i++)
      {
        DegreeInfo localDegreeInfo = (DegreeInfo)localList.get(i);
        Object localObject;
        try
        {
          localArrayList2.clear();
          localArrayList2.add(localDegreeInfo.getDegreeCode());
          FbpDegreeInfo localFbpDegreeInfo = (FbpDegreeInfo)localIImageCommonDAO.findObject(str2, localArrayList2, FbpDegreeInfo.class);
          if (localFbpDegreeInfo == null)
          {
            localFbpDegreeInfo = new FbpDegreeInfo();
            localFbpDegreeInfo.setCreatedBy(Long.valueOf(1L));
            localFbpDegreeInfo.setCreationDate(new Date());
            localFbpDegreeInfo.setLastUpdatedBy(Long.valueOf(1L));
            localFbpDegreeInfo.setLastUpdateLogin(Long.valueOf(1L));
          }
          localFbpDegreeInfo.setLastUpdateDate(new Date());
          localFbpDegreeInfo.setDegreeChangeId(localDegreeInfo.getDegreeChangeId());
          localFbpDegreeInfo.setDegreeCode(localDegreeInfo.getDegreeCode());
          localFbpDegreeInfo.setDegreeName(localDegreeInfo.getDegreeName());
          localFbpDegreeInfo.setSourceId(localDegreeInfo.getId());
          localObject = "Y";
          if ("1".equals(localDegreeInfo.getStatus()))
          {
            localObject = "N";
            str1 = "3";
          }
          else
          {
            localObject = "Y";
            str1 = "2";
          }
          localFbpDegreeInfo.setEnabledFlag((String)localObject);
          if (localFbpDegreeInfo.getDegreeInfoId() == null)
          {
            str1 = "1";
            localIImageCommonDAO.insertObject(localFbpDegreeInfo);
          }
          else
          {
            localIImageCommonDAO.updateObject(localFbpDegreeInfo);
          }
          localInteger3 = localInteger2;
          Integer localInteger4 = localInteger2 = Integer.valueOf(localInteger2.intValue() + 1);
          localSendDegreeProcessReult = setSendDegreeProcessReult(localDegreeInfo, "", Boolean.TRUE, str1);
        }
        catch (Exception localException2)
        {
          this.logger.error("同步职等信息异常:" + localException2.getMessage(), localException2);
          localSendDegreeProcessReult = setSendDegreeProcessReult(localDegreeInfo, "同步职等信息异常:" + localException2.getMessage(), Boolean.FALSE, str1);
          localObject = localInteger1;
          Integer localInteger3 = localInteger1 = Integer.valueOf(localInteger1.intValue() + 1);
        }
        localArrayList1.add(localSendDegreeProcessReult);
      }
    }
    catch (Exception localException1)
    {
      this.logger.error("同步职等异常:" + localException1.getMessage(), localException1);
    }
    localSendDegreeResponse.setFailedCount(localInteger1.intValue());
    localSendDegreeResponse.setSuccessCount(localInteger2.intValue());
    localSendDegreeResponse.setProcessResult(localArrayList1);
    return localSendDegreeResponse;
  }
  
  SendDegreeProcessReult setSendDegreeProcessReult(DegreeInfo paramDegreeInfo, String paramString1, Boolean paramBoolean, String paramString2)
  {
    SendDegreeProcessReult localSendDegreeProcessReult = new SendDegreeProcessReult();
    localSendDegreeProcessReult.setChangeType(paramString2);
    localSendDegreeProcessReult.setDegreeChangeId(paramDegreeInfo.getDegreeChangeId());
    localSendDegreeProcessReult.setDegreeName(paramDegreeInfo.getDegreeName());
    localSendDegreeProcessReult.setDegreeCode(paramDegreeInfo.getDegreeCode());
    localSendDegreeProcessReult.setReason(paramString1);
    localSendDegreeProcessReult.setResult(paramBoolean.booleanValue());
    return localSendDegreeProcessReult;
  }
  
  SendPositionProcessReult setSendPositionProcessReult(PositionInfo paramPositionInfo, String paramString1, Boolean paramBoolean, String paramString2)
  {
    SendPositionProcessReult localSendPositionProcessReult = new SendPositionProcessReult();
    localSendPositionProcessReult.setChangeType(paramString2);
    localSendPositionProcessReult.setPositionChangeId(paramPositionInfo.getPositionChangeId());
    localSendPositionProcessReult.setPositionCode(paramPositionInfo.getPositionCode());
    localSendPositionProcessReult.setPositionName(paramPositionInfo.getPositionName());
    localSendPositionProcessReult.setReason(paramString1);
    localSendPositionProcessReult.setResult(paramBoolean.booleanValue());
    return localSendPositionProcessReult;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.user.syn.model.ds.SyncDataDS
 * JD-Core Version:    0.7.0.1
 */