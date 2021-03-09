package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsLibraryInfo;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDocV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import java.util.List;

public abstract interface IEvsStorageDocService
{
  public abstract TableDataInfo findAllStorageDoc(EvsStorageDocV paramEvsStorageDocV, int paramInt1, int paramInt2);
  
  public abstract String insertStorageDoc(EvsStorageDocV paramEvsStorageDocV, List<EvsLibraryInfo> paramList);
  
  public abstract EvsStorageDocV findEvsStorageDocV(Long paramLong);
  
  public abstract List<EvsLibraryInfo> findEvsLibraryInfoByStoId(Long paramLong);
  
  public abstract String updateStorageDoc(EvsStorageDocV paramEvsStorageDocV, List<EvsLibraryInfo> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IEvsStorageDocService
 * JD-Core Version:    0.7.0.1
 */