package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.eimage.business.baseconfig.util.EidObjectUtils;
import com.zte.evs.ebill.model.archives.FbpArchivesHeadandhistorV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IEidFileProccessDAO
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
  
  public abstract PageInfo findImageInfosVByQry(FbpArchivesHeadandhistorV paramFbpArchivesHeadandhistorV, int paramInt1, int paramInt2, String paramString);
  
  public abstract EidObjectUtils getObjectUtils();
  
  public abstract void setObjectUtils(EidObjectUtils paramEidObjectUtils);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.IEidFileProccessDAO
 * JD-Core Version:    0.7.0.1
 */