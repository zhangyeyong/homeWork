package com.zte.eas.resconfig.business.operationtypes;

import com.zte.eas.resconfig.access.operationtypes.model.FbpOperationTypesV;
import com.zte.eimage.business.baseconfig.model.FbpOperationTypes;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;

public abstract interface IFbpOperationTypesDS
  extends DomainService
{
  public abstract TableDataInfo findOperationTypes(FbpOperationTypes paramFbpOperationTypes, int paramInt1, int paramInt2);
  
  public abstract FbpOperationTypesV createOperationType(FbpOperationTypesV paramFbpOperationTypesV);
  
  public abstract Integer modifyOperationType(FbpOperationTypesV paramFbpOperationTypesV);
  
  public abstract FbpOperationTypesV findOperationTypeV(String paramString);
  
  public abstract Integer existsOperationTypesCode(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.operationtypes.IFbpOperationTypesDS
 * JD-Core Version:    0.7.0.1
 */