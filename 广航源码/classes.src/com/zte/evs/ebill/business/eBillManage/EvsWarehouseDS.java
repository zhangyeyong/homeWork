package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.access.eBillManage.IEvsWarehouseDAO;
import com.zte.evs.ebill.model.eBillManage.EvsInventoryV;
import com.zte.evs.ebill.model.eBillManage.EvsWarehouse;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class EvsWarehouseDS
  extends BaseDomainService
  implements IEvsWarehouseDS
{
  private IEvsWarehouseDAO warehouseDAO;
  
  public void setEvsWarehouseDAO(IEvsWarehouseDAO paramIEvsWarehouseDAO)
  {
    super.setDao(paramIEvsWarehouseDAO);
    this.warehouseDAO = paramIEvsWarehouseDAO;
  }
  
  public List<EvsWarehouse> getEvsWarehouses(int paramInt1, int paramInt2)
  {
    return this.warehouseDAO.getEvsWarehouses(paramInt1, paramInt2);
  }
  
  public TableDataInfo findAllWarehouse(EvsWarehouse paramEvsWarehouse, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.warehouseDAO.findAllWarehouse(paramEvsWarehouse, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public TableDataInfo findAllStorageInfo(EvsInventoryV paramEvsInventoryV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    Map localMap = this.warehouseDAO.findAllStorageInfo(paramEvsInventoryV, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localMap.get("data"));
    localTableDataInfo.setTotalCount(Integer.parseInt(localMap.get("totalCount").toString()));
    return localTableDataInfo;
  }
  
  public List<EvsWarehouse> getEvsWarehouses()
  {
    return this.warehouseDAO.getEvsWarehouses();
  }
  
  public EvsWarehouse getEvsWarehouse(BigInteger paramBigInteger)
  {
    return this.warehouseDAO.getEvsWarehouse(paramBigInteger);
  }
  
  public void removeEvsWarehouse(BigInteger paramBigInteger)
  {
    this.warehouseDAO.removeEvsWarehouse(paramBigInteger);
  }
  
  public void removeEvsWarehouse(EvsWarehouse paramEvsWarehouse)
  {
    this.warehouseDAO.removeEvsWarehouse(paramEvsWarehouse);
  }
  
  public void insertEvsWarehouse(EvsWarehouse paramEvsWarehouse)
  {
    this.warehouseDAO.insertEvsWarehouse(paramEvsWarehouse);
  }
  
  public void updateEvsWarehouse(EvsWarehouse paramEvsWarehouse)
  {
    this.warehouseDAO.updateEvsWarehouse(paramEvsWarehouse);
  }
  
  public void insertEvsWarehouses(List<EvsWarehouse> paramList)
  {
    this.warehouseDAO.insertEvsWarehouses(paramList);
  }
  
  public void removeEvsWarehouses(List<EvsWarehouse> paramList)
  {
    this.warehouseDAO.removeEvsWarehouses(paramList);
  }
  
  public void updateEvsWarehouses(List<EvsWarehouse> paramList)
  {
    this.warehouseDAO.updateEvsWarehouses(paramList);
  }
  
  public IEvsWarehouseDAO getWarehouseDAO()
  {
    return this.warehouseDAO;
  }
  
  public void setWarehouseDAO(IEvsWarehouseDAO paramIEvsWarehouseDAO)
  {
    this.warehouseDAO = paramIEvsWarehouseDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsWarehouseDS
 * JD-Core Version:    0.7.0.1
 */