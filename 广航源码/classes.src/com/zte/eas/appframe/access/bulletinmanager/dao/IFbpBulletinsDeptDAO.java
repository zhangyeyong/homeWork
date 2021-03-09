package com.zte.eas.appframe.access.bulletinmanager.dao;

import com.zte.eas.appframe.business.bulletinmanager.model.FbpBulletinsDept;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpBulletinsDeptDAO
  extends DAO
{
  public abstract FbpBulletinsDept getFbpBulletinsDept(Long paramLong);
  
  public abstract List<FbpBulletinsDept> getFbpBulletinsDepts(int paramInt1, int paramInt2);
  
  public abstract List<FbpBulletinsDept> getFbpBulletinsDepts();
  
  public abstract void removeFbpBulletinsDept(Long paramLong);
  
  public abstract void removeFbpBulletinsDept(FbpBulletinsDept paramFbpBulletinsDept);
  
  public abstract void insertFbpBulletinsDept(FbpBulletinsDept paramFbpBulletinsDept);
  
  public abstract void updateFbpBulletinsDept(FbpBulletinsDept paramFbpBulletinsDept);
  
  public abstract void insertFbpBulletinsDepts(List<FbpBulletinsDept> paramList);
  
  public abstract void removeFbpBulletinsDepts(List<FbpBulletinsDept> paramList);
  
  public abstract void updateFbpBulletinsDepts(List<FbpBulletinsDept> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.bulletinmanager.dao.IFbpBulletinsDeptDAO
 * JD-Core Version:    0.7.0.1
 */