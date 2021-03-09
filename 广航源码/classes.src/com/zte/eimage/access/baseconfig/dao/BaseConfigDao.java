package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.BaseConfig;
import com.zte.eimage.business.baseconfig.model.BaseConfigV;
import com.zte.evs.ebill.model.eBillManage.FbfLookupValues;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.util.ArrayList;
import java.util.List;

public class BaseConfigDao
  extends BaseDAO
  implements IBaseConfigDao
{
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertBaseConfig(BaseConfig paramBaseConfig)
  {
    super.insertObject(paramBaseConfig);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateBaseConfig(BaseConfig paramBaseConfig)
  {
    super.updateObject(paramBaseConfig);
  }
  
  public BaseConfig getBaseConfigById(Integer paramInteger)
  {
    return (BaseConfig)super.getObject(BaseConfig.class, paramInteger);
  }
  
  public PageInfo findBaseConfig(BaseConfig paramBaseConfig, Integer paramInteger1, Integer paramInteger2)
  {
    String str = "FROM BaseConfigV b WHERE 1=1";
    if (paramBaseConfig != null)
    {
      if ((paramBaseConfig.getBaseConfigName() != null) && (!"".equals(paramBaseConfig.getBaseConfigName().trim()))) {
        str = str + " and b.baseConfigName like '%" + paramBaseConfig.getBaseConfigName() + "%'";
      }
      if ((paramBaseConfig.getEnabledFlag() != null) && (!"".equals(paramBaseConfig.getEnabledFlag().trim()))) {
        str = str + " and b.enabledFlag = '" + paramBaseConfig.getEnabledFlag() + "'";
      }
    }
    paramInteger1 = Integer.valueOf(paramInteger1.intValue() / paramInteger2.intValue() + 1);
    return super.PageInfoQuery(str, paramInteger1.intValue(), paramInteger2.intValue(), new Object[0]);
  }
  
  public List<BaseConfigV> findAllBaseConfig()
  {
    String str = "FROM BaseConfigV b WHERE b.enabledFlag = 'Y' ORDER BY b.baseConfigName";
    Session localSession = super.getSession();
    Query localQuery = localSession.createQuery(str);
    return localQuery.list();
  }
  
  public Object getObjectBySql(String paramString)
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
  
  public List getRatioTypeList(String paramString)
  {
    List localList = super.getSession().createSQLQuery("select t.lookup_code || ',' || t.meaning from  FBP_LOOKUP_VALUES t where t.LOOKUP_TYPE='" + paramString + "' and t.language=ZAS_ENV_PKG.getLang() and t.enabled_flag='Y' order by t.lookup_code").list();
    ArrayList localArrayList = new ArrayList();
    if ((localList != null) && (localList.size() > 0)) {
      for (int i = 0; i < localList.size(); i++)
      {
        FbfLookupValues localFbfLookupValues = new FbfLookupValues();
        String str = localList.get(i).toString();
        localFbfLookupValues.setLookupCode(str.split(",")[0]);
        localFbfLookupValues.setMeaning(str.split(",")[1]);
        localArrayList.add(localFbfLookupValues);
      }
    }
    return localArrayList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.BaseConfigDao
 * JD-Core Version:    0.7.0.1
 */