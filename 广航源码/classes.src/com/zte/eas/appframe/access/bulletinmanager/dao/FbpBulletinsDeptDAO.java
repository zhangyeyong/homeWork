package com.zte.eas.appframe.access.bulletinmanager.dao;

import com.zte.eas.appframe.business.bulletinmanager.model.FbpBulletinsDept;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.List;

public class FbpBulletinsDeptDAO
  extends BaseDAO
  implements IFbpBulletinsDeptDAO
{
  public FbpBulletinsDept getFbpBulletinsDept(Long paramLong)
  {
    return (FbpBulletinsDept)super.getObject(FbpBulletinsDept.class, paramLong);
  }
  
  public List getFbpBulletinsDepts()
  {
    return super.getObjects(FbpBulletinsDept.class);
  }
  
  public List<FbpBulletinsDept> getFbpBulletinsDepts(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpBulletinsDept.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpBulletinsDept(FbpBulletinsDept paramFbpBulletinsDept)
  {
    super.removeObject(paramFbpBulletinsDept);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpBulletinsDept(FbpBulletinsDept paramFbpBulletinsDept)
  {
    super.insertObject(paramFbpBulletinsDept);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpBulletinsDept(FbpBulletinsDept paramFbpBulletinsDept)
  {
    super.updateObject(paramFbpBulletinsDept);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpBulletinsDepts(List<FbpBulletinsDept> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpBulletinsDepts(List<FbpBulletinsDept> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpBulletinsDepts(List<FbpBulletinsDept> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpBulletinsDept(Long paramLong)
  {
    super.removeObject(FbpBulletinsDept.class, paramLong);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.bulletinmanager.dao.FbpBulletinsDeptDAO
 * JD-Core Version:    0.7.0.1
 */