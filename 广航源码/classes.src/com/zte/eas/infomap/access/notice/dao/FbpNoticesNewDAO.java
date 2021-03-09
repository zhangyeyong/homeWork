package com.zte.eas.infomap.access.notice.dao;

import com.zte.eas.infomap.business.notice.model.FbpNoticesNew;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FbpNoticesNewDAO
  extends BaseDAO
  implements IFbpNoticesNewDAO
{
  public FbpNoticesNew getFbpNoticesNew(Long paramLong)
  {
    return (FbpNoticesNew)super.getObject(FbpNoticesNew.class, paramLong);
  }
  
  public List<FbpNoticesNew> findFbpNoticesNews()
  {
    String str = "FROM FbpNoticesNew n WHERE 1=1";
    str = str + " AND (n.status =0 or n.status is null) and (n.isRuning='N' or n.isRuning is null) and toUserId is not null and n.creationDate>=(SYSDATE-7)";
    return getSession().createQuery(str).setFirstResult(0).setMaxResults(100).list();
  }
  
  public List<FbpNoticesNew> getTestFbpNoticesNews(String paramString)
  {
    String str = "FROM FbpNoticesNew n WHERE 1=1";
    str = str + " AND n.attribute5 ='" + paramString + "' order by n.id";
    return getSession().createQuery(str).setFirstResult(0).setMaxResults(100).list();
  }
  
  public List getFbpNoticesNews()
  {
    return super.getObjects(FbpNoticesNew.class);
  }
  
  public List<FbpNoticesNew> getFbpNoticesNews(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpNoticesNew.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpNoticesNew(FbpNoticesNew paramFbpNoticesNew)
  {
    super.removeObject(paramFbpNoticesNew);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpNoticesNew(FbpNoticesNew paramFbpNoticesNew)
  {
    super.insertObject(paramFbpNoticesNew);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpNoticesNew(FbpNoticesNew paramFbpNoticesNew)
  {
    super.updateObject(paramFbpNoticesNew);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpNoticesNews(List<FbpNoticesNew> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpNoticesNews(List<FbpNoticesNew> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpNoticesNews(List<FbpNoticesNew> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpNoticesNew(Long paramLong)
  {
    super.removeObject(FbpNoticesNew.class, paramLong);
  }
  
  public List<Long> getFbpNoticesNewEmpId(Long paramLong, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str = "FROM FbpNoticesNew n WHERE 1=1";
    if ((paramLong != null) && (paramLong.longValue() > 0L))
    {
      str = str + " AND n.boeHeaderId = ?";
      localArrayList1.add(paramLong);
    }
    if ((paramString != null) && (!paramString.equals("")))
    {
      str = str + " AND n.workflowTag  = ?";
      localArrayList1.add(paramString);
    }
    List localList = getZormTemplate().find(str, localArrayList1.toArray());
    if (localList.size() > 0)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        FbpNoticesNew localFbpNoticesNew = (FbpNoticesNew)localObject;
        localArrayList2.add(Long.valueOf(localFbpNoticesNew.getToUserId()));
      }
    }
    return localArrayList2;
  }
  
  public List<FbpNoticesNew> findFbpNoticesNewsPw()
  {
    String str = "FROM FbpNoticesNew n WHERE 1=1";
    str = str + " AND n.status = 0 and (n.isRuning is null or n.isRuning='N') and n.attribute5='Y' and n.noticeType<>'3' and n.creationDate>=(SYSDATE-7)";
    return getSession().createQuery(str).setFirstResult(0).setMaxResults(100).list();
  }
  
  public List<FbpNoticesNew> findFbpNoticesNewsPerson()
  {
    String str = "FROM FbpNoticesNew n WHERE 1=1";
    str = str + " AND n.status = 0 and (n.isRuning is null or n.isRuning='N') and n.templateId in ('BUS_APPROVE_FINISH','BOE_REJECT','BOE_APPROVE_FINISH') and n.noticeType<>'3' and n.creationDate>=(SYSDATE-7)";
    return getSession().createQuery(str).setFirstResult(0).setMaxResults(100).list();
  }
  
  public List<FbpNoticesNew> findFbpNoticesNewsApprove()
  {
    String str = "FROM FbpNoticesNew n WHERE 1=1";
    str = str + " AND n.status = 0 and (n.isRuning is null or n.isRuning='N') and n.templateId in ('BOE_APPROVE') and n.noticeType<>'3' and n.creationDate>=(SYSDATE-7)";
    return getSession().createQuery(str).setFirstResult(0).setMaxResults(100).list();
  }
  
  public List<FbpNoticesNew> findFbpNoticesNewsErpImpError()
  {
    String str = "FROM FbpNoticesNew n WHERE 1=1";
    str = str + " AND n.status = 0 and (n.isRuning is null or n.isRuning='N') and n.templateId ='ERP_ERROR' and n.noticeType<>'3' and n.creationDate>=(SYSDATE-7)";
    return getSession().createQuery(str).setFirstResult(0).setMaxResults(100).list();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.infomap.access.notice.dao.FbpNoticesNewDAO
 * JD-Core Version:    0.7.0.1
 */