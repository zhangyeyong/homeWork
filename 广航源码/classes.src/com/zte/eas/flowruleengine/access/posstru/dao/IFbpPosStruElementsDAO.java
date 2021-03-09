package com.zte.eas.flowruleengine.access.posstru.dao;

import com.zte.eas.flowruleengine.business.posstru.model.FbpPosStruElements;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;

public abstract interface IFbpPosStruElementsDAO
  extends DAO
{
  @Transactional(propagation=Propagation.REQUIRED)
  public abstract void insert(FbpPosStruElements paramFbpPosStruElements);
  
  @Transactional(propagation=Propagation.REQUIRED)
  public abstract void update(FbpPosStruElements paramFbpPosStruElements);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.access.posstru.dao.IFbpPosStruElementsDAO
 * JD-Core Version:    0.7.0.1
 */