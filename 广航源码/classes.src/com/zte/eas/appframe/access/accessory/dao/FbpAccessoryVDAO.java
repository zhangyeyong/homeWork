package com.zte.eas.appframe.access.accessory.dao;

import com.zte.eas.appframe.business.accessory.model.AppFrameCon;
import com.zte.eas.appframe.business.accessory.model.FbpAccessoryV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import java.util.ArrayList;
import java.util.List;

public class FbpAccessoryVDAO
  extends BaseDAO
  implements IFbpAccessoryVDAO
{
  public List<FbpAccessoryV> findAccessories(AppFrameCon paramAppFrameCon)
  {
    if (paramAppFrameCon == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    String str = "from FbpAccessoryV s where s.enabledFlag='Y'";
    if (paramAppFrameCon.getAccessoryId() != null)
    {
      str = str + " and s.accessoryId=?";
      localArrayList.add(paramAppFrameCon.getAccessoryId());
    }
    if (paramAppFrameCon.getRelationId() != null)
    {
      str = str + " and s.relationId=?";
      localArrayList.add(paramAppFrameCon.getRelationId());
    }
    if ((paramAppFrameCon.getAccessoryType() != null) && (!paramAppFrameCon.getAccessoryType().equals("")))
    {
      str = str + " and s.accessoryType=?";
      localArrayList.add(paramAppFrameCon.getAccessoryType());
    }
    if ((paramAppFrameCon.getAccessoryTitle() != null) && (!paramAppFrameCon.getAccessoryTitle().equals("")))
    {
      str = str + " and s.accessoryTitle=?";
      localArrayList.add(paramAppFrameCon.getAccessoryTitle());
    }
    if ((paramAppFrameCon.getDeptId() != null) && (!paramAppFrameCon.getDeptId().equals("")))
    {
      str = str + " and s.attribute10=?";
      localArrayList.add(paramAppFrameCon.getDeptId());
    }
    if ((paramAppFrameCon.getAccessoryTypes() != null) && (!paramAppFrameCon.getAccessoryTypes().equals("")))
    {
      str = str + " and s.attribute8=?";
      localArrayList.add(paramAppFrameCon.getAccessoryTypes());
    }
    str = str + " order by s.lastUpdateDate desc";
    List localList = getZormTemplate().find(str, localArrayList.toArray());
    super.clear();
    return localList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.accessory.dao.FbpAccessoryVDAO
 * JD-Core Version:    0.7.0.1
 */