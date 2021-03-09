package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.access.eBillManage.IEvsStorageDocDAO;
import com.zte.evs.ebill.model.eBillManage.EvsLibraryInfo;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDoc;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDocV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import java.util.List;
import java.util.Map;

public class EvsStorageDocService
  implements IEvsStorageDocService
{
  private IEvsStorageDocDAO evsStorageDocDAO;
  
  public TableDataInfo findAllStorageDoc(EvsStorageDocV paramEvsStorageDocV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.evsStorageDocDAO.findAllStorageDoc(paramEvsStorageDocV, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public String insertStorageDoc(EvsStorageDocV paramEvsStorageDocV, List<EvsLibraryInfo> paramList)
  {
    EvsStorageDoc localEvsStorageDoc = this.evsStorageDocDAO.findStorageDocExist(paramEvsStorageDocV);
    if (localEvsStorageDoc != null) {
      return "E";
    }
    return this.evsStorageDocDAO.insertStorageDoc(paramEvsStorageDocV, paramList);
  }
  
  public String updateStorageDoc(EvsStorageDocV paramEvsStorageDocV, List<EvsLibraryInfo> paramList)
  {
    return this.evsStorageDocDAO.updateStorageDoc(paramEvsStorageDocV, paramList);
  }
  
  public EvsStorageDocV findEvsStorageDocV(Long paramLong)
  {
    return this.evsStorageDocDAO.findEvsStorageDocV(paramLong);
  }
  
  public List<EvsLibraryInfo> findEvsLibraryInfoByStoId(Long paramLong)
  {
    List localList = this.evsStorageDocDAO.findEvsLibraryInfoByStoId(paramLong);
    return localList;
  }
  
  public IEvsStorageDocDAO getEvsStorageDocDAO()
  {
    return this.evsStorageDocDAO;
  }
  
  public void setEvsStorageDocDAO(IEvsStorageDocDAO paramIEvsStorageDocDAO)
  {
    this.evsStorageDocDAO = paramIEvsStorageDocDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsStorageDocService
 * JD-Core Version:    0.7.0.1
 */