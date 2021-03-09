package com.zte.eas.getData.OranizationUnits.dao;

import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import java.util.List;

public class EasBaseDAO
  extends BaseDAO
{
  public <T> T findUniqueByHql(String paramString, Object... paramVarArgs)
  {
    List localList = getZormTemplate().find(paramString, paramVarArgs);
    if (localList.isEmpty()) {
      return null;
    }
    return localList.get(0);
  }
  
  public <T> List<T> listByHql(String paramString, Object... paramVarArgs)
  {
    return getZormTemplate().find(paramString, paramVarArgs);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.dao.EasBaseDAO
 * JD-Core Version:    0.7.0.1
 */