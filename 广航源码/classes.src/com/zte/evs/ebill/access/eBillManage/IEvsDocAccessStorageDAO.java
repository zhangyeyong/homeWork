package com.zte.evs.ebill.access.eBillManage;

import com.zte.eas.resconfig.business.lookup.model.FbpLookupValuesV;
import com.zte.evs.ebill.model.eBillManage.EvsBookModel;
import com.zte.evs.ebill.model.eBillManage.EvsBookV;
import com.zte.evs.ebill.model.eBillManage.EvsCity;
import com.zte.evs.ebill.model.eBillManage.EvsInventory;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDoc;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistory;
import java.util.List;
import java.util.Map;

public abstract interface IEvsDocAccessStorageDAO
{
  public abstract List<EvsBookV> findAllBookIsExistByBookCode(String paramString);
  
  public abstract Map findDelAllBook(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract List findAllBookInfo(EvsBookModel paramEvsBookModel);
  
  public abstract String insertInventory(EvsInventory paramEvsInventory);
  
  public abstract void removeBookIdByBatchNum(String paramString);
  
  public abstract List<EvsInventory> findInventoryByBatchNum(String paramString);
  
  public abstract void updateInventory(EvsInventory paramEvsInventory);
  
  public abstract boolean findLibraryIsExist(EvsInventory paramEvsInventory);
  
  public abstract Integer findBookNum(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void updateBookStateByBookId(Long paramLong);
  
  public abstract void updateVoucherStateByBookId(EvsBookV paramEvsBookV);
  
  public abstract Map findAllBook(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract FbpLookupValuesV findFbpLookupValues(String paramString);
  
  public abstract EvsStorageDoc findStorageDocNameByStoCode(String paramString);
  
  public abstract EvsCity findCityNameByCityId(Long paramLong);
  
  public abstract EvsCity findCityNameByCityCode(String paramString);
  
  public abstract void insertEvsCity(EvsCity paramEvsCity);
  
  public abstract void updateEvsCity(EvsCity paramEvsCity);
  
  public abstract EvsInventory findEvsInventoryByBookId(Long paramLong);
  
  public abstract void updateInventoryByBookId(EvsInventory paramEvsInventory);
  
  public abstract EvsInventory findEvsInventoryByVentoryID(Long paramLong);
  
  public abstract void insertEvsVoucherHistory(EvsVoucherHistory paramEvsVoucherHistory);
  
  public abstract EvsBookV findEvsBookModelByBookId(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsDocAccessStorageDAO
 * JD-Core Version:    0.7.0.1
 */