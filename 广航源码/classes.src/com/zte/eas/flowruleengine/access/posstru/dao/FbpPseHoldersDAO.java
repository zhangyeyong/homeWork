package com.zte.eas.flowruleengine.access.posstru.dao;

import com.zte.eas.flowruleengine.business.posstru.model.FbpPseHolders;
import com.zte.ssb.framework.base.BaseDAO;
import java.util.List;

public class FbpPseHoldersDAO
  extends BaseDAO
  implements IFbpPseHoldersDAO
{
  public FbpPseHolders getFbpPseHolders(Long paramLong)
  {
    return null;
  }
  
  public void remove(Long paramLong)
  {
    super.removeObject(FbpPseHolders.class, paramLong);
  }
  
  public void insert(List<FbpPseHolders> paramList) {}
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.access.posstru.dao.FbpPseHoldersDAO
 * JD-Core Version:    0.7.0.1
 */