package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsBookModel;
import com.zte.evs.ebill.model.eBillManage.EvsInventory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;

public abstract interface IEvsDocAccessStorageService
{
  public abstract String findAllBookIsExistByBookCode(String paramString);
  
  public abstract TableDataInfo findDelAllBook(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract String insertBatchEnterDepot(EvsBookModel paramEvsBookModel, String paramString);
  
  public abstract String updateInventoryBybatchNum(EvsInventory paramEvsInventory);
  
  public abstract Integer findBookNum(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract TableDataInfo findAllBook(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract EvsInventory findEvsInventoryByBookId(Long paramLong);
  
  public abstract String updateInventoryByBookId(EvsInventory paramEvsInventory);
  
  public abstract EvsInventory findEvsInventoryByVentoryID(Long paramLong);
  
  public abstract String addInventoryBybatchNum(EvsInventory paramEvsInventory);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IEvsDocAccessStorageService
 * JD-Core Version:    0.7.0.1
 */