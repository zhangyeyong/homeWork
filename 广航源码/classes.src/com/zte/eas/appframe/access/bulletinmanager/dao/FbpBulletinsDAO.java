package com.zte.eas.appframe.access.bulletinmanager.dao;

import com.zte.eas.appframe.business.bulletinmanager.model.FbpBulletins;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import java.util.ArrayList;
import java.util.List;

public class FbpBulletinsDAO
  extends BaseDAO
  implements IFbpBulletinsDAO
{
  public void removeFbpBulletins(FbpBulletins paramFbpBulletins)
  {
    super.removeObject(paramFbpBulletins);
  }
  
  public void insertFbpBulletins(FbpBulletins paramFbpBulletins)
  {
    super.insertObject(paramFbpBulletins);
  }
  
  public void updateFbpBulletins(FbpBulletins paramFbpBulletins)
  {
    super.updateObject(paramFbpBulletins);
  }
  
  public FbpBulletins findById(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "From FbpBulletins f where f.bulletinId= ? ";
    localArrayList.add(Long.valueOf(paramString));
    List localList = super.getZormTemplate().find(str, localArrayList.toArray());
    FbpBulletins localFbpBulletins = (FbpBulletins)localList.get(0);
    return localFbpBulletins;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.bulletinmanager.dao.FbpBulletinsDAO
 * JD-Core Version:    0.7.0.1
 */