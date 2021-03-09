package com.zte.eas.getData.OranizationUnits.dao;

import com.zte.eas.appframe.business.util.CacheUtils;
import com.zte.eas.resconfig.business.lookup.model.FbpLookupValues;
import com.zte.ssb.AccessPropertiesFile;
import com.zte.ssb.framework.base.BaseDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorMessageDAO
  extends BaseDAO
  implements IErrorMessageDAO
{
  final Logger loggers = LoggerFactory.getLogger(ErrorMessageDAO.class);
  private static final String CACHE_ERR_CODE = "CACHE_ERR_CODE";
  
  public String getErrInfos(String paramString1, String paramString2)
  {
    Object localObject1 = (Map)CacheUtils.getData("CACHE_ERR_CODE");
    Object localObject6;
    if (localObject1 == null)
    {
      localObject1 = new HashMap();
      localObject2 = " from FbpLookupValues flv where flv.lookupType='ERR_CODES'";
      localObject3 = find((String)localObject2, new Object[0]);
      localObject4 = ((List)localObject3).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (FbpLookupValues)((Iterator)localObject4).next();
        localObject6 = ((FbpLookupValues)localObject5).getLookupCode();
        Object localObject7 = (List)((Map)localObject1).get(localObject6);
        if (localObject7 == null)
        {
          localObject7 = new ArrayList();
          ((Map)localObject1).put(localObject6, localObject7);
        }
        ((List)localObject7).add(localObject5);
      }
      CacheUtils.add("CACHE_ERR_CODE", localObject1);
    }
    Object localObject2 = (List)((Map)localObject1).get(paramString1);
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      return null;
    }
    Object localObject3 = AccessPropertiesFile.getValue("LANGUAGE", "eas_interface.service.properties");
    Object localObject4 = ((FbpLookupValues)((List)localObject2).get(0)).getMeaning();
    Object localObject5 = ((List)localObject2).iterator();
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (FbpLookupValues)((Iterator)localObject5).next();
      if (((FbpLookupValues)localObject6).getLanguage().equals(localObject3))
      {
        localObject4 = ((FbpLookupValues)localObject6).getMeaning();
        break;
      }
    }
    return paramString1 + "-&" + paramString2 + "&-" + (String)localObject4;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.dao.ErrorMessageDAO
 * JD-Core Version:    0.7.0.1
 */