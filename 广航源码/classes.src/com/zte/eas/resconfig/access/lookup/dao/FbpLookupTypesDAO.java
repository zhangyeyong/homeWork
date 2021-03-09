package com.zte.eas.resconfig.access.lookup.dao;

import com.zte.eas.appframe.business.util.SqlManageUtils;
import com.zte.eas.resconfig.business.lookup.model.FbpLookupTypes;
import com.zte.eas.resconfig.business.lookup.model.ResConfigCon;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

public class FbpLookupTypesDAO
  extends BaseDAO
  implements IFbpLookupTypesDAO
{
  public List findFbpLookupTypess()
  {
    return super.getObjects(FbpLookupTypes.class);
  }
  
  public List<FbpLookupTypes> findFbpLookupTypess(ResConfigCon paramResConfigCon)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramResConfigCon == null) {
      return new ArrayList();
    }
    String str = "FROM FbpLookupTypes s WHERE 1=1";
    if ((paramResConfigCon.getLookupType() != null) && (!paramResConfigCon.getLookupType().equals("")))
    {
      str = str + " AND s.lookupType= ?";
      localArrayList.add(SqlManageUtils.cleanUpSQL(paramResConfigCon.getLookupType()));
    }
    if ((paramResConfigCon.getDescription() != null) && (!paramResConfigCon.getDescription().equals("")))
    {
      str = str + " AND s.description= ?";
      localArrayList.add(SqlManageUtils.cleanUpSQL(paramResConfigCon.getDescription()));
    }
    List localList = getZormTemplate().find(str.toString(), localArrayList.toArray());
    return localList;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpLookupTypes(FbpLookupTypes paramFbpLookupTypes)
  {
    super.removeObject(paramFbpLookupTypes);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpLookupTypes(FbpLookupTypes paramFbpLookupTypes)
  {
    super.insertObject(paramFbpLookupTypes);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpLookupTypes(FbpLookupTypes paramFbpLookupTypes)
  {
    super.updateObject(paramFbpLookupTypes);
  }
  
  public void insertFbpLookupTypess(List<FbpLookupTypes> paramList) {}
  
  public void removeFbpLookupTypess(List<FbpLookupTypes> paramList) {}
  
  public void updateFbpLookupTypess(List<FbpLookupTypes> paramList) {}
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.lookup.dao.FbpLookupTypesDAO
 * JD-Core Version:    0.7.0.1
 */