package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsFtp;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.util.List;

public class EvsFtpDAO
  extends BaseDAO
  implements IEvsFtpDAO
{
  public EvsFtp getFtpUser()
  {
    List localList = getSession().createQuery("from EvsFtp").list();
    if ((localList != null) && (localList.size() > 0)) {
      return (EvsFtp)localList.get(0);
    }
    return new EvsFtp();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsFtpDAO
 * JD-Core Version:    0.7.0.1
 */