package com.zte.eas.resconfig.access.operationtypes;

import com.zte.eas.resconfig.access.operationtypes.model.FbpOperationTypesTl;
import com.zte.ssb.framework.base.BaseDAO;
import java.util.List;

public class FbpOperationTypesTlDAO
  extends BaseDAO
  implements IFbpOperationTypesTlDAO
{
  public void removeFbpOperationTypesTl(FbpOperationTypesTl paramFbpOperationTypesTl)
  {
    super.removeObject(paramFbpOperationTypesTl);
  }
  
  public void insertFbpOperationTypesTl(FbpOperationTypesTl paramFbpOperationTypesTl)
  {
    super.insertObject(paramFbpOperationTypesTl);
  }
  
  public void updateFbpOperationTypesTl(FbpOperationTypesTl paramFbpOperationTypesTl)
  {
    super.updateObject(paramFbpOperationTypesTl);
  }
  
  public void updateFbpOperationTypesTls(List<FbpOperationTypesTl> paramList)
  {
    super.updateObjects(paramList);
  }
  
  public List<FbpOperationTypesTl> findFbpOperationTypesTls(Long paramLong)
  {
    String str = " from FbpOperationTypesTl fott where fott.fbpOperationTypesTlPK.operationTypeId = ? ";
    return super.find(str, new Object[] { paramLong });
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.operationtypes.FbpOperationTypesTlDAO
 * JD-Core Version:    0.7.0.1
 */