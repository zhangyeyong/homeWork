package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.business.baseconfig.model.EidAppraiseHistoryV;
import com.zte.eimage.business.baseconfig.model.EidApprovalImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.eimage.business.baseconfig.model.EidImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidImages;
import com.zte.eimage.business.baseconfig.model.EidMyApprovalImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidMyboeImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidOrgeImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidPatrol;
import com.zte.evs.ebill.model.eBillManage.SpecialAttachmentV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.List;

public abstract interface IEidImageInfosDS
{
  public abstract EidImageInfos findEidImageInfoByImageNumber(String paramString);
  
  public abstract TableDataInfo queryImageInfosV(EidImageInfosV paramEidImageInfosV, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo appraiseImageInfosV(EidImageInfosV paramEidImageInfosV, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo patrolImageInfosV(EidAppraiseHistoryV paramEidAppraiseHistoryV, int paramInt1, int paramInt2);
  
  public abstract String getAttachmentUrl(String paramString);
  
  public abstract String getBoeDetailUrl(String paramString);
  
  public abstract List<EidAppraiseHistoryV> findHistoryVByImageNumber(String paramString);
  
  @Transactional(propagation=Propagation.REQUIRED)
  public abstract boolean rejectAppraiseHistory(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract boolean rejectAppraiseHistoryNeed(String paramString1, String paramString2, String paramString3, String paramString4);
  
  @Transactional(propagation=Propagation.REQUIRED)
  public abstract boolean addAppraiseHistory(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract boolean addAppraiseHistoryss(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9);
  
  public abstract EidImageInfos findEidImageInfoByTaskNumber(String paramString);
  
  @Transactional(propagation=Propagation.REQUIRED)
  public abstract boolean addAppraiseHistory(List<String> paramList);
  
  @Transactional(propagation=Propagation.REQUIRED)
  public abstract boolean removeEidImageInfos(List<String> paramList);
  
  public abstract String checkDataContran(List<String> paramList);
  
  public abstract boolean findImageStatusByImageInfoId(String paramString);
  
  public abstract TableDataInfo findMyApprovalInfosV(EidMyApprovalImageInfosV paramEidMyApprovalImageInfosV, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo queryMyBoeInfosV(EidMyboeImageInfosV paramEidMyboeImageInfosV, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo queryOrgeInfosV(EidOrgeImageInfosV paramEidOrgeImageInfosV, int paramInt1, int paramInt2);
  
  public abstract List<EidImages> findEidImages(String paramString);
  
  public abstract TableDataInfo findNeedApprovalInfosVByQry(EidApprovalImageInfosV paramEidApprovalImageInfosV, int paramInt1, int paramInt2);
  
  public abstract void deleteMyImage(Long paramLong);
  
  public abstract List<EidImageInfos> findEidImageInfoByFlag();
  
  public abstract List<EidImageInfos> findWaitDeleteImageInfo();
  
  public abstract void updateEidImageInfos(List<EidImageInfos> paramList);
  
  public abstract TableDataInfo fetchSpecialAttachments(SpecialAttachmentV paramSpecialAttachmentV, int paramInt1, int paramInt2);
  
  public abstract String operationTypeInLimit(String paramString);
  
  public abstract List<EidPatrol> findPatrolByImageInfoId(Integer paramInteger);
  
  public abstract String insertForUpdatePatrol(List<EidPatrol> paramList);
  
  public abstract TableDataInfo findEspecialInfosVByQry(EidImageInfosV paramEidImageInfosV, int paramInt1, int paramInt2);
  
  public abstract void updateImageInfoReject(String paramString1, String paramString2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.IEidImageInfosDS
 * JD-Core Version:    0.7.0.1
 */