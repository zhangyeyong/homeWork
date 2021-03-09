package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidAppraiseHistoriesV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.util.List;

public class EidAppraiseHistoriesVDAO
  extends BaseDAO
  implements IEidAppraiseHistoriesVDAO
{
  public EidAppraiseHistoriesV getEidAppraiseHistoriesV(Long paramLong)
  {
    return (EidAppraiseHistoriesV)super.getObject(EidAppraiseHistoriesV.class, paramLong);
  }
  
  public List getEidAppraiseHistoriesVs()
  {
    return super.getObjects(EidAppraiseHistoriesV.class);
  }
  
  public List<EidAppraiseHistoriesV> getEidAppraiseHistoriesVs(int paramInt1, int paramInt2)
  {
    return super.getObjects(EidAppraiseHistoriesV.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidAppraiseHistoriesV(EidAppraiseHistoriesV paramEidAppraiseHistoriesV)
  {
    super.removeObject(paramEidAppraiseHistoriesV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEidAppraiseHistoriesV(EidAppraiseHistoriesV paramEidAppraiseHistoriesV)
  {
    super.insertObject(paramEidAppraiseHistoriesV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEidAppraiseHistoriesV(EidAppraiseHistoriesV paramEidAppraiseHistoriesV)
  {
    super.updateObject(paramEidAppraiseHistoriesV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEidAppraiseHistoriesVs(List<EidAppraiseHistoriesV> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidAppraiseHistoriesVs(List<EidAppraiseHistoriesV> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEidAppraiseHistoriesVs(List<EidAppraiseHistoriesV> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidAppraiseHistoriesV(Long paramLong)
  {
    super.removeObject(EidAppraiseHistoriesV.class, paramLong);
  }
  
  public List<EidAppraiseHistoriesV> findHistoryByImageInfoId(String paramString)
  {
    String str = "from EidAppraiseHistoriesV his where his.imageInfoId in (select info.imageInfoId from EidImageInfos info where info.imageNumber='" + paramString + "') order by his.creationDate desc";
    List localList = getSession().createQuery(str).list();
    if ((localList == null) || (localList.size() < 0)) {
      return null;
    }
    return localList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.EidAppraiseHistoriesVDAO
 * JD-Core Version:    0.7.0.1
 */