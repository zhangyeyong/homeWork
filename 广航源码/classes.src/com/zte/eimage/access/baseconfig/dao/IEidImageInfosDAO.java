package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidApprovalImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.eimage.business.baseconfig.model.EidImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidMyApprovalImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidMyboeImageInfosV;
import com.zte.eimage.business.baseconfig.model.EidOrgeImageInfosV;
import com.zte.evs.ebill.model.eBillManage.SpecialAttachmentV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IEidImageInfosDAO
  extends DAO
{
  public abstract EidImageInfos getEidImageInfos(Long paramLong);
  
  public abstract List<EidImageInfos> getEidImageInfoss(int paramInt1, int paramInt2);
  
  public abstract List<EidImageInfos> getEidImageInfoss();
  
  public abstract void removeEidImageInfos(Long paramLong);
  
  public abstract void removeEidImageInfos(EidImageInfos paramEidImageInfos);
  
  public abstract EidImageInfos insertEidImageInfos(EidImageInfos paramEidImageInfos);
  
  public abstract void updateEidImageInfos(EidImageInfos paramEidImageInfos);
  
  public abstract void insertEidImageInfoss(List<EidImageInfos> paramList);
  
  public abstract void removeEidImageInfoss(List<EidImageInfos> paramList);
  
  public abstract void updateEidImageInfoss(List<EidImageInfos> paramList);
  
  public abstract EidImageInfos findEidImageInfoByImageNumber(String paramString);
  
  public abstract EidImageInfos findEidImageInfoByTaskNumber(String paramString);
  
  public abstract Object findEidImageInfoByCode(String paramString1, String paramString2, String paramString3);
  
  public abstract List<EidImageInfos> findEidImageInfoByHql(String paramString);
  
  public abstract PageInfo findImageInfosVByQry(EidImageInfosV paramEidImageInfosV, int paramInt1, int paramInt2, String paramString);
  
  public abstract PageInfo findMyBoeInfosVByQry(EidMyboeImageInfosV paramEidMyboeImageInfosV, int paramInt1, int paramInt2);
  
  public abstract PageInfo findMyApprovalInfosVByQry(EidMyApprovalImageInfosV paramEidMyApprovalImageInfosV, int paramInt1, int paramInt2, String paramString);
  
  public abstract PageInfo findOrgeInfosVByQry(EidOrgeImageInfosV paramEidOrgeImageInfosV, int paramInt1, int paramInt2, String paramString);
  
  public abstract PageInfo findNeedApprovalInfosVByQry(EidApprovalImageInfosV paramEidApprovalImageInfosV, int paramInt1, int paramInt2, String paramString);
  
  public abstract List<EidImageInfos> findEidImageInfoByFlag();
  
  public abstract List<EidImageInfos> findWaitDeleteImageInfo();
  
  public abstract void deleteMyImage(Long paramLong);
  
  public abstract List<Object[]> findImageByUser(String paramString, Long paramLong);
  
  public abstract String getImageSeqNo();
  
  public abstract String getLanguage();
  
  public abstract PageInfo fetchSpecialAttachments(SpecialAttachmentV paramSpecialAttachmentV, int paramInt1, int paramInt2);
  
  public abstract String operationTypeInLimit(String paramString);
  
  public abstract PageInfo findEspecialInfosVByQry(EidImageInfosV paramEidImageInfosV, int paramInt1, int paramInt2, String paramString);
  
  public abstract void updateImageInfoReject(String paramString1, String paramString2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.IEidImageInfosDAO
 * JD-Core Version:    0.7.0.1
 */