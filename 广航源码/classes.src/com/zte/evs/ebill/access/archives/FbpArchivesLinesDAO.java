package com.zte.evs.ebill.access.archives;

import com.zte.evs.ebill.model.archives.FbpArchivesLines;
import com.zte.evs.ebill.model.archives.FbpArchivesLinesV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

public class FbpArchivesLinesDAO
  extends BaseDAO
  implements IFbpArchivesLinesDAO
{
  public FbpArchivesLines getFbpArchivesLines(Long paramLong)
  {
    return (FbpArchivesLines)super.getObject(FbpArchivesLines.class, paramLong);
  }
  
  public List getFbpArchivesLiness()
  {
    return super.getObjects(FbpArchivesLines.class);
  }
  
  public List<FbpArchivesLines> getFbpArchivesLiness(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpArchivesLines.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpArchivesLines(FbpArchivesLines paramFbpArchivesLines)
  {
    super.removeObject(paramFbpArchivesLines);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpArchivesLines(FbpArchivesLines paramFbpArchivesLines)
  {
    super.insertObject(paramFbpArchivesLines);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpArchivesLines(FbpArchivesLines paramFbpArchivesLines)
  {
    super.updateObject(paramFbpArchivesLines);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpArchivesLiness(List<FbpArchivesLines> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpArchivesLiness(List<FbpArchivesLines> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpArchivesLiness(List<FbpArchivesLines> paramList)
  {
    super.updateObjects(paramList);
  }
  
  public PageInfo findFbpArchivesLinesV(FbpArchivesLinesV paramFbpArchivesLinesV, int paramInt1, int paramInt2)
  {
    PageInfo localPageInfo = new PageInfo();
    ArrayList localArrayList = new ArrayList();
    String str = " from FbpArchivesLinesV o where 1=1";
    if ((null != paramFbpArchivesLinesV.getArchivesHeaderId()) && (!"".equals(paramFbpArchivesLinesV.getArchivesHeaderId())))
    {
      str = str + " and o.archivesHeaderId=?";
      localArrayList.add(paramFbpArchivesLinesV.getArchivesHeaderId());
    }
    localPageInfo = PageInfoQuery(str, paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpArchivesLines(Long paramLong)
  {
    super.removeObject(FbpArchivesLines.class, paramLong);
  }
  
  public List<FbpArchivesLinesV> findFbpArchivesLinessV(Long paramLong)
  {
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    String str = " from FbpArchivesLinesV o where o.archivesHeaderId=?";
    localArrayList.add(paramLong);
    localObject = super.getZormTemplate().find(str, localArrayList.toArray());
    return localObject;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.archives.FbpArchivesLinesDAO
 * JD-Core Version:    0.7.0.1
 */