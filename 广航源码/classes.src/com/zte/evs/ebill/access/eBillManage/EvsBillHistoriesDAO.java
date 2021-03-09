package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsBillHistoriesV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.util.List;

public class EvsBillHistoriesDAO
  extends BaseDAO
  implements IEvsBillHistoriesDAO
{
  public List<EvsBillHistoriesV> findHistoryByBoeNum(String paramString)
  {
    return getSession().createQuery("FROM EvsBillHistoriesV h WHERE h.boeHeaderId=" + paramString).list();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EvsBillHistoriesDAO
 * JD-Core Version:    0.7.0.1
 */