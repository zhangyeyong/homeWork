package com.zte.eas.organization.access.checkunits.dao;

import com.zte.eas.organization.business.checkunits.model.FbpCheckUnitContents;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

public class FbpCheckUnitContentsDAO
  extends BaseDAO
  implements IFbpCheckUnitContentsDAO
{
  public FbpCheckUnitContents getFbpCheckUnitContents(Long paramLong)
  {
    return (FbpCheckUnitContents)super.getObject(FbpCheckUnitContents.class, paramLong);
  }
  
  public List getFbpCheckUnitContentss()
  {
    return super.getObjects(FbpCheckUnitContents.class);
  }
  
  public List<FbpCheckUnitContents> getFbpCheckUnitContentss(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpCheckUnitContents.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpCheckUnitContents(FbpCheckUnitContents paramFbpCheckUnitContents)
  {
    super.insertObject(paramFbpCheckUnitContents);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpCheckUnitContents(FbpCheckUnitContents paramFbpCheckUnitContents)
  {
    super.updateObject(paramFbpCheckUnitContents);
  }
  
  public FbpCheckUnitContents findCheckUnitContentsVByCheckUnit(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "from FbpCheckUnitContents s where s.checkUnit= ? ";
    localArrayList.add(paramString);
    List localList = getZormTemplate().find(str.toString(), localArrayList.toArray());
    if (localList.size() == 0) {
      return new FbpCheckUnitContents();
    }
    return (FbpCheckUnitContents)localList.get(0);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.checkunits.dao.FbpCheckUnitContentsDAO
 * JD-Core Version:    0.7.0.1
 */