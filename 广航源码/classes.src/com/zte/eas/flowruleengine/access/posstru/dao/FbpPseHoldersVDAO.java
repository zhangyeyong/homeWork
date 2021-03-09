package com.zte.eas.flowruleengine.access.posstru.dao;

import com.zte.eas.flowruleengine.business.posstru.model.FbpPseHoldersV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import java.util.ArrayList;
import java.util.List;

public class FbpPseHoldersVDAO
  extends BaseDAO
  implements IFbpPseHoldersVDAO
{
  public List<FbpPseHoldersV> findPseHoldersVByElementId(FbpPseHoldersV paramFbpPseHoldersV)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramFbpPseHoldersV == null) {
      return new ArrayList();
    }
    String str = "from FbpPseHoldersV s where s.enabledFlag='Y'";
    if ((paramFbpPseHoldersV.getPosStruElementId() != null) && (!paramFbpPseHoldersV.getPosStruElementId().equals("")))
    {
      str = str + " AND s.posStruElementId = ?";
      localArrayList.add(paramFbpPseHoldersV.getPosStruElementId());
    }
    str = str + " order by s.pseHolderId desc";
    List localList = getZormTemplate().find(str, localArrayList.toArray());
    return localList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.access.posstru.dao.FbpPseHoldersVDAO
 * JD-Core Version:    0.7.0.1
 */