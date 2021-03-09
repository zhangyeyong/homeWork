package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsLibraryInfo;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDoc;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDocV;
import java.util.List;
import java.util.Map;

public abstract interface IEvsStorageDocDAO
{
  public abstract Map findAllStorageDoc(EvsStorageDocV paramEvsStorageDocV, int paramInt1, int paramInt2);
  
  public abstract String insertStorageDoc(EvsStorageDocV paramEvsStorageDocV, List<EvsLibraryInfo> paramList);
  
  public abstract List<EvsLibraryInfo> findEvsLibraryInfoByStoId(Long paramLong);
  
  public abstract EvsStorageDocV findEvsStorageDocV(Long paramLong);
  
  public abstract String updateStorageDoc(EvsStorageDocV paramEvsStorageDocV, List<EvsLibraryInfo> paramList);
  
  public abstract EvsStorageDoc findStorageDocExist(EvsStorageDocV paramEvsStorageDocV);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsStorageDocDAO
 * JD-Core Version:    0.7.0.1
 */