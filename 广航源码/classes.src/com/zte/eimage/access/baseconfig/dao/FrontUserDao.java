package com.zte.eimage.access.baseconfig.dao;

import com.zte.eas.flowruleengine.business.posstru.model.FbpSitesRelations;
import com.zte.eas.flowruleengine.business.posstru.model.FbpUsersRelations;
import com.zte.eimage.business.baseconfig.model.FrontUser;
import com.zte.eimage.business.baseconfig.model.FrontUserV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.util.ArrayList;
import java.util.List;

public class FrontUserDao
  extends BaseDAO
  implements IFrontUserDao
{
  public void insertFrontUser(FrontUser paramFrontUser)
  {
    super.insertObject(paramFrontUser);
  }
  
  public void insertSitesRelation(FbpSitesRelations paramFbpSitesRelations)
  {
    super.insertObject(paramFbpSitesRelations);
  }
  
  public void insertUsersRelation(FbpUsersRelations paramFbpUsersRelations)
  {
    super.insertObject(paramFbpUsersRelations);
  }
  
  public void delOldSitesRelations(Long paramLong)
  {
    String str = "delete from fbp.FBP_SITES_RELATIONS pr where pr.employee_id = ?";
    super.getSession().createSQLQuery(str).setLong(0, paramLong.longValue()).executeUpdate();
  }
  
  public void delOldUsersRelations(Long paramLong)
  {
    String str = "delete from fbp.fbp_users_relations pr where pr.employee_id = ?";
    super.getSession().createSQLQuery(str).setLong(0, paramLong.longValue()).executeUpdate();
  }
  
  public FrontUser findFrontUserById(Integer paramInteger)
  {
    return (FrontUser)super.getObject(FrontUser.class, paramInteger);
  }
  
  public void updateFrontUser(FrontUser paramFrontUser)
  {
    super.updateObject(paramFrontUser);
  }
  
  public Object getObject(String paramString)
  {
    Session localSession = super.getSession();
    Query localQuery = localSession.createQuery(paramString);
    return localQuery.uniqueResult();
  }
  
  public Integer getCount(String paramString)
  {
    Integer localInteger = Integer.valueOf(0);
    Session localSession = super.getSession();
    Query localQuery = localSession.createQuery(paramString);
    List localList = localQuery.list();
    if (localList == null) {
      return localInteger;
    }
    localInteger = Integer.valueOf(localList.size());
    return localInteger;
  }
  
  public List getCompanyId(String paramString)
  {
    Session localSession = super.getSession();
    return localSession.createSQLQuery(paramString).list();
  }
  
  public PageInfo findFrontUser(FrontUserV paramFrontUserV, Integer paramInteger1, Integer paramInteger2)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "FROM FrontUserV u WHERE 1=1";
    if (paramFrontUserV != null)
    {
      if ((paramFrontUserV.getEmployeeNum() != null) && (!"".equals(paramFrontUserV.getEmployeeNum().trim())))
      {
        str = str + " AND u.employeeNum like ?";
        localArrayList.add("%" + paramFrontUserV.getEmployeeNum() + "%");
      }
      if ((paramFrontUserV.getEmployeeName() != null) && (!"".equals(paramFrontUserV.getEmployeeName().trim())))
      {
        str = str + " AND u.employeeName like ?";
        localArrayList.add("%" + paramFrontUserV.getEmployeeName() + "%");
      }
      if ((paramFrontUserV.getEnabledFlag() != null) && (!"".equals(paramFrontUserV.getEnabledFlag().trim())))
      {
        str = str + " AND u.enabledFlag = ?";
        localArrayList.add(paramFrontUserV.getEnabledFlag());
      }
      if ((paramFrontUserV.getUploadGroup() != null) && (!"".equals(paramFrontUserV.getUploadGroup().trim())))
      {
        str = str + " AND u.uploadGroup = ?";
        localArrayList.add(paramFrontUserV.getUploadGroup());
      }
    }
    str = str + " ORDER BY u.employeeNum";
    paramInteger1 = Integer.valueOf(paramInteger1.intValue() / paramInteger2.intValue() + 1);
    return super.PageInfoQuery(str, paramInteger1.intValue(), paramInteger2.intValue(), localArrayList.toArray());
  }
  
  public List<Object[]> findObjectsBySql(String paramString, List paramList, Class paramClass)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      return null;
    }
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(paramString);
    if (paramClass != null) {
      localSQLQuery.addEntity(paramClass);
    }
    if ((paramList != null) && (!paramList.isEmpty())) {
      for (int i = 0; i < paramList.size(); i++) {
        localSQLQuery.setParameter(i, paramList.get(i));
      }
    }
    return localSQLQuery.list();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.FrontUserDao
 * JD-Core Version:    0.7.0.1
 */