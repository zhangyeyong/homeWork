package com.zte.eas.flowruleengine.access.posstru.dao;

import com.zte.eas.flowruleengine.business.posstru.model.FbpPosStruElements;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;

public class FbpPosStruElementsDAO
  extends BaseDAO
  implements IFbpPosStruElementsDAO
{
  @Transactional(propagation=Propagation.REQUIRED)
  public void insert(FbpPosStruElements paramFbpPosStruElements)
  {
    super.insertObject(paramFbpPosStruElements);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(FbpPosStruElements paramFbpPosStruElements)
  {
    super.updateObject(paramFbpPosStruElements);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.access.posstru.dao.FbpPosStruElementsDAO
 * JD-Core Version:    0.7.0.1
 */