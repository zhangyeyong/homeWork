package com.zte.eas.appframe.access.bulletinmanager.dao;

import com.zte.eas.appframe.business.bulletinmanager.model.FbpBulletins;
import com.zte.ssb.framework.base.DAO;

public abstract interface IFbpBulletinsDAO
  extends DAO
{
  public abstract void removeFbpBulletins(FbpBulletins paramFbpBulletins);
  
  public abstract void insertFbpBulletins(FbpBulletins paramFbpBulletins);
  
  public abstract void updateFbpBulletins(FbpBulletins paramFbpBulletins);
  
  public abstract FbpBulletins findById(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.bulletinmanager.dao.IFbpBulletinsDAO
 * JD-Core Version:    0.7.0.1
 */