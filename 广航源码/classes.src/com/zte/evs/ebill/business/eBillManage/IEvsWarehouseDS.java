package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsInventoryV;
import com.zte.evs.ebill.model.eBillManage.EvsWarehouse;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.math.BigInteger;
import java.util.List;

public abstract interface IEvsWarehouseDS
  extends DomainService
{
  public abstract EvsWarehouse getEvsWarehouse(BigInteger paramBigInteger);
  
  public abstract List<EvsWarehouse> getEvsWarehouses(int paramInt1, int paramInt2);
  
  public abstract List<EvsWarehouse> getEvsWarehouses();
  
  public abstract TableDataInfo findAllWarehouse(EvsWarehouse paramEvsWarehouse, int paramInt1, int paramInt2);
  
  public abstract void removeEvsWarehouse(BigInteger paramBigInteger);
  
  public abstract void removeEvsWarehouse(EvsWarehouse paramEvsWarehouse);
  
  public abstract void insertEvsWarehouse(EvsWarehouse paramEvsWarehouse);
  
  public abstract void updateEvsWarehouse(EvsWarehouse paramEvsWarehouse);
  
  public abstract void insertEvsWarehouses(List<EvsWarehouse> paramList);
  
  public abstract void removeEvsWarehouses(List<EvsWarehouse> paramList);
  
  public abstract void updateEvsWarehouses(List<EvsWarehouse> paramList);
  
  public abstract TableDataInfo findAllStorageInfo(EvsInventoryV paramEvsInventoryV, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IEvsWarehouseDS
 * JD-Core Version:    0.7.0.1
 */