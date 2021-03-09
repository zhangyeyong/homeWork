package com.zte.eas.resconfig.access.operationtypes;

import com.zte.eas.resconfig.access.operationtypes.model.FbpOperationTypesV;
import com.zte.eimage.business.baseconfig.model.FbpOperationTypes;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class FbpOperationTypesDAO
  extends BaseDAO
  implements IFbpOperationTypesDAO
{
  public PageInfo findOperationTypes(FbpOperationTypes paramFbpOperationTypes, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder(" FROM FbpOperationTypesV fot WHERE 1=1 ");
    if (null != paramFbpOperationTypes)
    {
      localObject = paramFbpOperationTypes.getOperationTypeId();
      if (null != localObject)
      {
        localStringBuilder.append(" AND fot.operationTypeId = ? ");
        localArrayList.add(localObject);
      }
      String str1 = paramFbpOperationTypes.getAttribute1();
      if (StringUtils.isNotEmpty(str1))
      {
        localStringBuilder.append(" AND fot.attribute1 = ? ");
        localArrayList.add(str1);
      }
      String str2 = paramFbpOperationTypes.getAttribute2();
      if (StringUtils.isNotEmpty(str2))
      {
        localStringBuilder.append(" AND fot.attribute2 = ? ");
        localArrayList.add(str2);
      }
      String str3 = paramFbpOperationTypes.getEnabledFlag();
      if (StringUtils.isNotEmpty(str3))
      {
        localStringBuilder.append(" AND fot.enabledFlag = ? ");
        localArrayList.add(str3);
      }
    }
    localStringBuilder.append(" ORDER BY fot.lastUpdateDate DESC ");
    paramInt1 = paramInt1 / paramInt2 + 1;
    Object localObject = super.PageInfoQuery(localStringBuilder.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localObject;
  }
  
  public void createOperationType(FbpOperationTypes paramFbpOperationTypes)
  {
    super.insertObject(paramFbpOperationTypes);
  }
  
  public void modifyOperationType(FbpOperationTypes paramFbpOperationTypes)
  {
    super.updateObject(paramFbpOperationTypes);
  }
  
  public FbpOperationTypes findFbpOperationTypes(Long paramLong)
  {
    return (FbpOperationTypes)super.getObject(FbpOperationTypes.class, paramLong);
  }
  
  public FbpOperationTypesV findOperationTypeV(Long paramLong)
  {
    return (FbpOperationTypesV)super.getObject(FbpOperationTypesV.class, paramLong);
  }
  
  public Integer existsOperationTypesCode(String paramString)
  {
    String str = " select 1 from FbpOperationTypes fot where fot.operationTypeCode = ? ";
    int i = super.find(str, new Object[] { paramString }).size();
    return Integer.valueOf(i > 0 ? 1 : 0);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.operationtypes.FbpOperationTypesDAO
 * JD-Core Version:    0.7.0.1
 */