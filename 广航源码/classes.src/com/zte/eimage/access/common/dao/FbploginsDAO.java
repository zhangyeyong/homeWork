package com.zte.eimage.access.common.dao;

import com.zte.eimage.business.baseconfig.service.EvsServiceSessionMap;
import com.zte.eimage.business.common.model.Fbplogins;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.List;

public class FbploginsDAO
  extends BaseDAO
  implements IFbploginsDAO
{
  public Fbplogins getFbplogins(BigInteger paramBigInteger)
  {
    return (Fbplogins)super.getObject(Fbplogins.class, paramBigInteger);
  }
  
  public List getFbploginss()
  {
    return super.getObjects(Fbplogins.class);
  }
  
  public List<Fbplogins> getFbploginss(int paramInt1, int paramInt2)
  {
    return super.getObjects(Fbplogins.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbplogins(Fbplogins paramFbplogins)
  {
    super.removeObject(paramFbplogins);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbplogins(Fbplogins paramFbplogins)
  {
    super.insertObject(paramFbplogins);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbplogins(Fbplogins paramFbplogins)
  {
    super.updateObject(paramFbplogins);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbploginss(List<Fbplogins> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbploginss(List<Fbplogins> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbploginss(List<Fbplogins> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbplogins(BigInteger paramBigInteger)
  {
    super.removeObject(Fbplogins.class, paramBigInteger);
  }
  
  public Integer getLoginCount()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String str1 = localSimpleDateFormat.format(new java.util.Date());
    String str2 = "SELECT * FROM FBP.FBP_LOGINS LOG WHERE LOG.LOGIN_TIME>=to_date('" + str1 + " " + "00:00:00" + "','yyyy-mm-dd hh24:mi:ss')";
    SQLQuery localSQLQuery = getSession().createSQLQuery(str2);
    if ((localSQLQuery.list() != null) && (localSQLQuery.list().size() > 0)) {
      return Integer.valueOf(localSQLQuery.list().size());
    }
    return Integer.valueOf(0);
  }
  
  public Integer getOnlineLoginCount()
  {
    java.sql.Date localDate = new java.sql.Date(new java.util.Date().getTime());
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String str1 = localSimpleDateFormat.format(new java.util.Date());
    String str2 = "select distinct l.user_id  from fbp_logins l where l.logout_time is null";
    SQLQuery localSQLQuery = getSession().createSQLQuery(str2);
    if ((localSQLQuery.list() != null) && (localSQLQuery.list().size() > 0)) {
      return Integer.valueOf(localSQLQuery.list().size());
    }
    return Integer.valueOf(0);
  }
  
  public Fbplogins getFbplogins(String paramString)
  {
    String str = "select * from (select * from fbp.fbp_logins l where l.app_id = " + EvsServiceSessionMap.APP_ID + " and l.logout_time is null and l.User_Code = '" + paramString + "' order by l.active_time desc) where rownum = 1";
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(str);
    localSQLQuery.addEntity(Fbplogins.class);
    Fbplogins localFbplogins = null;
    List localList = localSQLQuery.list();
    if ((localList != null) && (localList.size() > 0) && (localList.get(0) != null)) {
      localFbplogins = (Fbplogins)localList.get(0);
    }
    return localFbplogins;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.common.dao.FbploginsDAO
 * JD-Core Version:    0.7.0.1
 */