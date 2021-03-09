package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.EvsBookModel;
import com.zte.evs.ebill.model.eBillManage.EvsBookStatisticV;
import com.zte.evs.ebill.model.eBillManage.EvsBookV;
import com.zte.evs.ebill.model.eBillManage.EvsInventory;
import com.zte.evs.ebill.model.eBillManage.EvsStorageDoc;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherBookPackage;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherSelect;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;
import java.util.Map;

public abstract interface IEvsBookDAO
{
  public abstract String getDocNameBySubName(String paramString);
  
  public abstract String getDocName(String paramString);
  
  public abstract String isVoucherBooked(EvsBookModel paramEvsBookModel);
  
  public abstract List getVoucherInfo(String paramString);
  
  public abstract PageInfo findEmployeesByQry(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract void save(EvsBook paramEvsBook);
  
  public abstract void update(EvsBook paramEvsBook);
  
  public abstract EvsBook getBookByCode(String paramString);
  
  public abstract List<Long> getJournalNum(EvsBookModel paramEvsBookModel);
  
  public abstract Map findEvsHeaderByQry(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract EvsBookV getBookInfoByCode(EvsBookModel paramEvsBookModel);
  
  public abstract EvsVoucher findVoucherById(String paramString);
  
  public abstract Map findEvsVoucherByNum(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract void update(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract Map getVoucherHistoryByCode(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract String isBreakNum(String[] paramArrayOfString);
  
  public abstract EvsBook insertBook(EvsBookModel paramEvsBookModel);
  
  public abstract String getGenerarionNmber(EvsBookModel paramEvsBookModel);
  
  public abstract List getJournalNumByVoucherId(String paramString);
  
  public abstract String getBookTotal(EvsBookModel paramEvsBookModel);
  
  public abstract Map getVoucherMaxMinJournalNum(String paramString);
  
  public abstract void saveVoucherBookPackage(EvsVoucherBookPackage paramEvsVoucherBookPackage);
  
  public abstract void saveVoucherBookPackages(EvsBook paramEvsBook, String paramString);
  
  public abstract void deleteVoucherBookPackage(String paramString1, String paramString2);
  
  public abstract List isBreakNums(EvsBookModel paramEvsBookModel);
  
  public abstract List<String> getLogicUserInfo(String paramString);
  
  public abstract List<String> getNextJournalNum(EvsBookModel paramEvsBookModel);
  
  public abstract List<String> isVoucherByParam(String paramString);
  
  public abstract List<String> lookBreakNums(EvsBookModel paramEvsBookModel);
  
  public abstract List<String> getBreakNum(EvsBookModel paramEvsBookModel);
  
  public abstract List<String> getBreakNums(EvsBookV paramEvsBookV);
  
  public abstract String findVoucherByIsVoucherStatus(String paramString);
  
  public abstract PageInfo findEvsBookBySubDocName(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract Map findQueryBookStatistic(EvsBookStatisticV paramEvsBookStatisticV, int paramInt1, int paramInt2);
  
  public abstract List getOuId(String paramString);
  
  public abstract void deltempFence(String paramString);
  
  public abstract void deleteVoucherByBook(String paramString);
  
  public abstract EvsBook getBookByCodeAndEmployee(String paramString1, String paramString2);
  
  public abstract void updateVoucherStatus(String paramString1, String paramString2);
  
  public abstract String getUnBookCode(EvsBookModel paramEvsBookModel);
  
  public abstract void saveEvsInventory(EvsInventory paramEvsInventory);
  
  public abstract EvsInventory findEvsInventory(EvsBook paramEvsBook);
  
  public abstract EvsStorageDoc findEvsStorageDoc(Long paramLong);
  
  public abstract EvsBookV getBookVByCode(String paramString);
  
  public abstract EvsStorageDoc findEvsStorageDocByEvsStorageDoc(EvsStorageDoc paramEvsStorageDoc);
  
  public abstract EvsBook getEvsBookById(Long paramLong);
  
  public abstract void updateEvsBook(EvsBook paramEvsBook);
  
  public abstract EvsBook getBookByStatus();
  
  public abstract EvsBook getBookByStatusNew(String paramString1, String paramString2);
  
  public abstract EvsBook getBookByStatus2(String paramString);
  
  public abstract List<EvsBookV> getEvsBookVByBookCodes(String paramString);
  
  public abstract List<EvsBookV> getEvsBookVByBookCode(String paramString);
  
  public abstract EvsBook insertBooksForYB(String paramString1, String paramString2, String paramString3, String paramString4, EvsVoucherSelect paramEvsVoucherSelect, EvsVoucherV paramEvsVoucherV, String paramString5, String paramString6);
  
  public abstract List<EvsVoucherV> findVouchersList(String paramString);
  
  public abstract String getGenerarionNmberYB(EvsVoucherSelect paramEvsVoucherSelect);
  
  public abstract void deleteBookPackageVoucherByBookId(Long paramLong, String[] paramArrayOfString);
  
  public abstract List<EvsVoucherBookPackage> findEvsVoucherBookPackageForYB(Long paramLong);
  
  public abstract EvsVoucherV findEvsVoucherVByJournalNum(String paramString);
  
  public abstract List<EvsVoucherBookPackage> checkVoucherForS(Long paramLong);
  
  public abstract EvsVoucher getVoucherForS(Long paramLong);
  
  public abstract List<EvsVoucherBookPackage> findEvsVoucherBookPackageForYBByVouId(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsBookDAO
 * JD-Core Version:    0.7.0.1
 */