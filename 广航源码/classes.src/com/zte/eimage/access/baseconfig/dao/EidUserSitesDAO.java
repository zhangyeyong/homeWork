package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidUserSites;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.util.List;

public class EidUserSitesDAO
  extends BaseDAO
  implements IEidUserSitesDAO
{
  public EidUserSites getEidUserSites(BigInteger paramBigInteger)
  {
    return (EidUserSites)super.getObject(EidUserSites.class, paramBigInteger);
  }
  
  public List getEidUserSitess()
  {
    return super.getObjects(EidUserSites.class);
  }
  
  public List<EidUserSites> getEidUserSitess(int paramInt1, int paramInt2)
  {
    return super.getObjects(EidUserSites.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidUserSites(EidUserSites paramEidUserSites)
  {
    super.removeObject(paramEidUserSites);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEidUserSites(EidUserSites paramEidUserSites)
  {
    super.insertObject(paramEidUserSites);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEidUserSites(EidUserSites paramEidUserSites)
  {
    super.updateObject(paramEidUserSites);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEidUserSitess(List<EidUserSites> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidUserSitess(List<EidUserSites> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEidUserSitess(List<EidUserSites> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidUserSites(BigInteger paramBigInteger)
  {
    super.removeObject(EidUserSites.class, paramBigInteger);
  }
  
  public void removeEidUserSitesByUserId(Long paramLong)
  {
    String str = "delete from eid.eid_user_sites us where us.front_user_id = ?";
    super.getSession().createSQLQuery(str).setLong(0, paramLong.longValue()).executeUpdate();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.EidUserSitesDAO
 * JD-Core Version:    0.7.0.1
 */