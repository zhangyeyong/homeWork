package com.zte.evs.ebill.access.archives;

import com.zte.evs.ebill.model.archives.FbpArchivesHistories;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

public class FbpArchivesHistoriesDAO
  extends BaseDAO
  implements IFbpArchivesHistoriesDAO
{
  public PageInfo findFbpArchivesHistories(FbpArchivesHistories paramFbpArchivesHistories, int paramInt1, int paramInt2)
  {
    PageInfo localPageInfo = new PageInfo();
    ArrayList localArrayList = new ArrayList();
    String str = " from FbpArchivesHistories o where 1=1 ";
    if ((null != paramFbpArchivesHistories.getArchivesHeaderId()) && (!"".equals(paramFbpArchivesHistories.getArchivesHeaderId())))
    {
      str = str + " and o.archivesHeaderId=?";
      localArrayList.add(paramFbpArchivesHistories.getArchivesHeaderId());
    }
    localPageInfo = PageInfoQuery(str, paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public FbpArchivesHistories getFbpArchivesHistories(Long paramLong)
  {
    return (FbpArchivesHistories)super.getObject(FbpArchivesHistories.class, paramLong);
  }
  
  public List getFbpArchivesHistoriess()
  {
    return super.getObjects(FbpArchivesHistories.class);
  }
  
  public List<FbpArchivesHistories> getFbpArchivesHistoriess(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpArchivesHistories.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpArchivesHistories(FbpArchivesHistories paramFbpArchivesHistories)
  {
    super.removeObject(paramFbpArchivesHistories);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpArchivesHistories(FbpArchivesHistories paramFbpArchivesHistories)
  {
    super.insertObject(paramFbpArchivesHistories);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpArchivesHistories(FbpArchivesHistories paramFbpArchivesHistories)
  {
    super.updateObject(paramFbpArchivesHistories);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpArchivesHistoriess(List<FbpArchivesHistories> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpArchivesHistoriess(List<FbpArchivesHistories> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpArchivesHistoriess(List<FbpArchivesHistories> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpArchivesHistories(Long paramLong)
  {
    super.removeObject(FbpArchivesHistories.class, paramLong);
  }
  
  public List<FbpArchivesHistories> findFbpArchivesHistories(Long paramLong)
  {
    Object localObject = new ArrayList();
    String str = " from FbpArchivesHistories o where o.archivesHeaderId=? and rownum<=2";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLong);
    localObject = getZormTemplate().find(str, localArrayList.toArray());
    return localObject;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.archives.FbpArchivesHistoriesDAO
 * JD-Core Version:    0.7.0.1
 */