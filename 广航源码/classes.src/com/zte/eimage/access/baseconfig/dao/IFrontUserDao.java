package com.zte.eimage.access.baseconfig.dao;

import com.zte.eas.flowruleengine.business.posstru.model.FbpSitesRelations;
import com.zte.eas.flowruleengine.business.posstru.model.FbpUsersRelations;
import com.zte.eimage.business.baseconfig.model.FrontUser;
import com.zte.eimage.business.baseconfig.model.FrontUserV;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IFrontUserDao
{
  public abstract void insertFrontUser(FrontUser paramFrontUser);
  
  public abstract FrontUser findFrontUserById(Integer paramInteger);
  
  public abstract void updateFrontUser(FrontUser paramFrontUser);
  
  public abstract Object getObject(String paramString);
  
  public abstract Integer getCount(String paramString);
  
  public abstract PageInfo findFrontUser(FrontUserV paramFrontUserV, Integer paramInteger1, Integer paramInteger2);
  
  public abstract List<Object[]> findObjectsBySql(String paramString, List paramList, Class paramClass);
  
  public abstract void insertSitesRelation(FbpSitesRelations paramFbpSitesRelations);
  
  public abstract void delOldSitesRelations(Long paramLong);
  
  public abstract void delOldUsersRelations(Long paramLong);
  
  public abstract void insertUsersRelation(FbpUsersRelations paramFbpUsersRelations);
  
  public abstract List getCompanyId(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.IFrontUserDao
 * JD-Core Version:    0.7.0.1
 */