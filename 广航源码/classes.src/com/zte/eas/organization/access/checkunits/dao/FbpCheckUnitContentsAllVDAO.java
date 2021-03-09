package com.zte.eas.organization.access.checkunits.dao;

import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import java.util.List;

public class FbpCheckUnitContentsAllVDAO
  extends BaseDAO
  implements IFbpCheckUnitContentsAllVDAO
{
  public List findFbpCheckUnitContentsAllV()
  {
    String str = "from FbpCheckUnitContentsAllV s where 1=1 order by s.checkUnitName desc";
    List localList = getZormTemplate().find(str.toString());
    super.clear();
    return localList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.checkunits.dao.FbpCheckUnitContentsAllVDAO
 * JD-Core Version:    0.7.0.1
 */