package com.zte.eas.resconfig.access.lookup.dao;

import com.zte.eas.appframe.business.util.CacheUtils;
import com.zte.eas.appframe.business.util.SqlManageUtils;
import com.zte.eas.resconfig.business.lookup.model.FbpLookupValuesV;
import com.zte.eas.resconfig.business.lookup.model.ResConfigCon;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class FbpLookupValuesVDAO
  extends BaseDAO
  implements IFbpLookupValuesVDAO
{
  public List<FbpLookupValuesV> findFbpLookupValuesVByCon(ResConfigCon paramResConfigCon)
  {
    return null;
  }
  
  public List<FbpLookupValuesV> findFbpLookupValuess(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (StringUtils.isBlank(paramString)) {
      return null;
    }
    Object localObject = (Map)CacheUtils.getData("LOOKUP_TYPE");
    if ((null != localObject) && (((Map)localObject).containsKey(paramString))) {
      return (List)((Map)localObject).get(paramString);
    }
    localObject = new HashMap();
    String str = "from FbpLookupValuesV s where 1=1";
    str = str + " and s.lookupType = ?";
    localArrayList.add(paramString.trim());
    List localList = getZormTemplate().find(str.toString(), localArrayList.toArray());
    ((Map)localObject).put(paramString, localList);
    CacheUtils.add("LOOKUP_TYPE", localObject);
    return localList;
  }
  
  public FbpLookupValuesV findFbpLookupValues(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "from FbpLookupValuesV s where enabledFlag='Y'";
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      str = str + " and s.lookupType = ?";
      localArrayList.add(SqlManageUtils.cleanUpSQL(paramString1));
    }
    if ((paramString2 != null) && (!paramString2.equals("")))
    {
      str = str + " and s.lookupCode = ?";
      localArrayList.add(SqlManageUtils.cleanUpSQL(paramString2));
    }
    List localList = getZormTemplate().find(str.toString(), localArrayList.toArray());
    return (FbpLookupValuesV)localList.get(0);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.lookup.dao.FbpLookupValuesVDAO
 * JD-Core Version:    0.7.0.1
 */