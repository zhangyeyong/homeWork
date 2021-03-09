package com.zte.eas.resconfig.access.operationtypes;

import com.zte.eas.resconfig.access.operationtypes.model.FbpOperationTypesV;
import com.zte.eimage.business.baseconfig.model.FbpOperationTypes;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;

public abstract interface IFbpOperationTypesDAO
  extends DAO
{
  public abstract PageInfo findOperationTypes(FbpOperationTypes paramFbpOperationTypes, int paramInt1, int paramInt2);
  
  public abstract void modifyOperationType(FbpOperationTypes paramFbpOperationTypes);
  
  public abstract void createOperationType(FbpOperationTypes paramFbpOperationTypes);
  
  public abstract FbpOperationTypes findFbpOperationTypes(Long paramLong);
  
  public abstract FbpOperationTypesV findOperationTypeV(Long paramLong);
  
  public abstract Integer existsOperationTypesCode(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.operationtypes.IFbpOperationTypesDAO
 * JD-Core Version:    0.7.0.1
 */