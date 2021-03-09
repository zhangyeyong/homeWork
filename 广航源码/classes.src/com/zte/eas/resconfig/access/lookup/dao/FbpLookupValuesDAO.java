package com.zte.eas.resconfig.access.lookup.dao;

import com.zte.eas.appframe.business.util.SqlManageUtils;
import com.zte.eas.resconfig.business.lookup.model.FbpLookupValues;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.util.ArrayList;
import java.util.List;

public class FbpLookupValuesDAO
  extends BaseDAO
  implements IFbpLookupValuesDAO
{
  public FbpLookupValues findFbpLookupValues(Long paramLong)
  {
    return (FbpLookupValues)super.getObject(FbpLookupValues.class, paramLong);
  }
  
  public List findFbpLookupValuess()
  {
    return super.getObjects(FbpLookupValues.class);
  }
  
  public List<FbpLookupValues> findFbpLookupValuess(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString == null) {
      return new ArrayList();
    }
    String str = "FROM FbpLookupValues s WHERE 1=1";
    if ((paramString != null) && (!paramString.equals("")))
    {
      str = str + " AND s.lookupType= ?";
      localArrayList.add(SqlManageUtils.cleanUpSQL(paramString));
    }
    List localList = getZormTemplate().find(str.toString(), localArrayList.toArray());
    return localList;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpLookupValues(FbpLookupValues paramFbpLookupValues)
  {
    super.removeObject(paramFbpLookupValues);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpLookupValues(FbpLookupValues paramFbpLookupValues)
  {
    super.insertObject(paramFbpLookupValues);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpLookupValues(FbpLookupValues paramFbpLookupValues)
  {
    super.updateObject(paramFbpLookupValues);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpLookupValuess(List<FbpLookupValues> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpLookupValuess(List<FbpLookupValues> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpLookupValuess(List<FbpLookupValues> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpLookupValues(Long paramLong)
  {
    super.removeObject(FbpLookupValues.class, paramLong);
  }
  
  public Object findFbpLookupValues(String paramString)
  {
    Object localObject = super.getSession().createSQLQuery(paramString).uniqueResult();
    return localObject;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.lookup.dao.FbpLookupValuesDAO
 * JD-Core Version:    0.7.0.1
 */