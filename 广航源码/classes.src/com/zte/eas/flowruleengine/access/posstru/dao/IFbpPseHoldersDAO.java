package com.zte.eas.flowruleengine.access.posstru.dao;

import com.zte.eas.flowruleengine.business.posstru.model.FbpPseHolders;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpPseHoldersDAO
  extends DAO
{
  public abstract FbpPseHolders getFbpPseHolders(Long paramLong);
  
  public abstract void remove(Long paramLong);
  
  public abstract void insert(List<FbpPseHolders> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.access.posstru.dao.IFbpPseHoldersDAO
 * JD-Core Version:    0.7.0.1
 */