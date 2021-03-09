package com.zte.eas.resconfig.access.lookup.dao;

import com.zte.eas.appframe.business.util.SqlManageUtils;
import com.zte.eas.resconfig.business.lookup.model.ResConfigCon;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.util.ArrayList;
import java.util.List;

public class FbpLookupTypesVDAO
  extends BaseDAO
  implements IFbpLookupTypesVDAO
{
  public PageInfo findLookupValuesByType(ResConfigCon paramResConfigCon, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "from FbpLookupTypesV s where 1=1";
    if ((paramResConfigCon.getLookupType() != null) && (!paramResConfigCon.getLookupType().equals("")))
    {
      str = str + " and upper(s.lookupType) like ?";
      localArrayList.add("%" + SqlManageUtils.cleanUpSQL(paramResConfigCon.getLookupType()).toUpperCase() + "%");
    }
    if ((paramResConfigCon.getDescription() != null) && (!paramResConfigCon.getDescription().equals("")))
    {
      str = str + " and s.description like ?";
      localArrayList.add("%" + SqlManageUtils.cleanUpSQL(paramResConfigCon.getDescription()) + "%");
    }
    str = str + " order by s.lookupType,s.lastUpdateDate desc";
    paramInt1 = paramInt1 / paramInt2 + 1;
    PageInfo localPageInfo = super.PageInfoQuery(str, paramInt1, paramInt2, localArrayList.toArray());
    super.clear();
    return localPageInfo;
  }
  
  public String getDescriptions(String paramString1, String paramString2)
  {
    String str1 = "\tSELECT a.description  from fbp_flex_values a, fbp_lookups_v t where a.flex_value_set_name = t.meaning and t.lookup_type = 'FLEX_VALUE_SET_NAME' and a.flex_value = :accountCombination and t.lookup_code = :lookupCode and a.summary_flag<>'Y' and (a.start_date_active <= sysdate or a.start_date_active is null) and (a.end_date_active >= sysdate or a.end_date_active is null)";
    String str2 = (String)getSession().createSQLQuery(str1).setParameter("accountCombination", paramString1).setParameter("lookupCode", paramString2).setMaxResults(1).uniqueResult();
    return str2;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.lookup.dao.FbpLookupTypesVDAO
 * JD-Core Version:    0.7.0.1
 */