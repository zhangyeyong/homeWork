package com.zte.eas.appframe.access.accessory.dao;

import com.zte.eas.appframe.business.accessory.model.AppFrameCon;
import com.zte.eas.appframe.business.accessory.model.FbpAccessoryV;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpAccessoryVDAO
  extends DAO
{
  public abstract List<FbpAccessoryV> findAccessories(AppFrameCon paramAppFrameCon);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.accessory.dao.IFbpAccessoryVDAO
 * JD-Core Version:    0.7.0.1
 */