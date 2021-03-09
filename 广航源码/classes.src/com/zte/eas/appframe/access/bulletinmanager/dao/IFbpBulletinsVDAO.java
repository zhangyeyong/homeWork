package com.zte.eas.appframe.access.bulletinmanager.dao;

import com.zte.eas.appframe.business.bulletinmanager.model.FbpBulletinsV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;

public abstract interface IFbpBulletinsVDAO
  extends DAO
{
  public abstract PageInfo findFbpBulletinsVByCon(FbpBulletinsV paramFbpBulletinsV, int paramInt1, int paramInt2);
  
  public abstract FbpBulletinsV findFbpBulletinsVById(Long paramLong);
  
  public abstract String findDeptId(Long paramLong);
  
  public abstract PageInfo findFbpBulletinsVByCons(FbpBulletinsV paramFbpBulletinsV, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.bulletinmanager.dao.IFbpBulletinsVDAO
 * JD-Core Version:    0.7.0.1
 */