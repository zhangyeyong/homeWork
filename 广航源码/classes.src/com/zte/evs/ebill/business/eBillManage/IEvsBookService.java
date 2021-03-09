package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.model.eBillManage.BookMenuModel;
import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.EvsBookModel;
import com.zte.evs.ebill.model.eBillManage.EvsBookStatisticV;
import com.zte.evs.ebill.model.eBillManage.EvsBookV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherSelect;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import java.util.List;

public abstract interface IEvsBookService
{
  public abstract String getBookArchiveNumberByCode(EvsBookModel paramEvsBookModel);
  
  public abstract String getBookVoucherByCode(EvsBookModel paramEvsBookModel);
  
  public abstract String getBookInFoById(EvsBookModel paramEvsBookModel);
  
  public abstract String getDocNameBySubName(EvsBookModel paramEvsBookModel);
  
  public abstract List getDocName(EvsBookModel paramEvsBookModel);
  
  public abstract String isVoucherBooked(EvsBookModel paramEvsBookModel);
  
  public abstract TableDataInfo getBookQuery(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract List<String> getJournalNum(List<EvsBookModel> paramList);
  
  public abstract TableDataInfo getHeaders(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract void insertBook(List<String> paramList, EvsBookModel paramEvsBookModel);
  
  public abstract EvsBookV getBookInfoByCode(EvsBookModel paramEvsBookModel);
  
  public abstract EvsBookV getBookInfoByArchiveNumber(EvsBookModel paramEvsBookModel);
  
  public abstract EvsBookV getBookInfoByBookId(EvsBookModel paramEvsBookModel);
  
  public abstract TableDataInfo getVoucherInfoByCode(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo getVoucherInfoByCodeForL(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract List updateHeaderInfo(EvsBookModel paramEvsBookModel);
  
  public abstract boolean updateBookVoucherInfoByCode(EvsBookModel paramEvsBookModel);
  
  public abstract boolean updateBookVoucherInfoByCodeForD(EvsBookModel paramEvsBookModel);
  
  public abstract TableDataInfo getVoucherHistoryByCode(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract String isBreakNum(String[] paramArrayOfString);
  
  public abstract String isBreakNums(EvsBookModel paramEvsBookModel);
  
  public abstract String getGenerarionNmber(EvsBookModel paramEvsBookModel);
  
  public abstract List getJournalNumByVoucherId(String paramString);
  
  public abstract String getBookTotal(EvsBookModel paramEvsBookModel);
  
  public abstract List<BookMenuModel> setSessionBookInfo(EvsBookV paramEvsBookV);
  
  public abstract List<String> getLogicUserInfo();
  
  public abstract List<String> getNextNum(List<EvsBookModel> paramList);
  
  public abstract boolean isVoucherByParam(EvsBookModel paramEvsBookModel);
  
  public abstract List<String> lookBreakNums(EvsBookModel paramEvsBookModel);
  
  public abstract List<String> getBreakNum(EvsBookModel paramEvsBookModel);
  
  public abstract List<String> getBreakNums(EvsBookV paramEvsBookV);
  
  public abstract List insertVoucher(EvsBookModel paramEvsBookModel);
  
  public abstract String getSysTime();
  
  public abstract String findVoucherByIsVoucherStatus(String paramString);
  
  public abstract boolean isVoucherCodeByBook(EvsBookModel paramEvsBookModel);
  
  public abstract TableDataInfo getEvsBooks2(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo getStatistic(EvsBookStatisticV paramEvsBookStatisticV, int paramInt1, int paramInt2);
  
  public abstract Long save();
  
  public abstract void deltempFence(String paramString1, String paramString2, String paramString3);
  
  public abstract void vouAddFence(String paramString1, String paramString2);
  
  public abstract void deleteVoucherByBook(String paramString);
  
  public abstract Long insertBooks(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, String paramString4, String paramString5);
  
  public abstract String updateVoucher(EvsBookModel paramEvsBookModel);
  
  public abstract String updateVoucherForL(EvsBookModel paramEvsBookModel);
  
  public abstract String updateVoucherForL2(EvsBookModel paramEvsBookModel);
  
  public abstract String deleteTempVoucher(EvsBookModel paramEvsBookModel);
  
  public abstract Long insertBooksForL(EvsBookModel paramEvsBookModel, List<EvsBookModel> paramList, String paramString1, String paramString2);
  
  public abstract String insertBooksForL2(EvsBookModel paramEvsBookModel, List<EvsBookModel> paramList);
  
  public abstract String checkVoucherNumIsD(EvsBookModel paramEvsBookModel, List<EvsBookModel> paramList);
  
  public abstract TableDataInfo getHeaderForL(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract List getBookByArchiveNumber(String paramString);
  
  public abstract List<EvsBookV> getEvsBookVByBookCode(String paramString);
  
  public abstract List<String> checkBookExists(long paramLong);
  
  public abstract String updateVoucherForYB2(EvsVoucherSelect paramEvsVoucherSelect);
  
  public abstract String insertBooksForYB(EvsVoucherSelect paramEvsVoucherSelect, String paramString1, String paramString2);
  
  public abstract TableDataInfo getHeaderForYB(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2);
  
  public abstract boolean updateBookVoucherInfoByCodeForS(EvsBookModel paramEvsBookModel);
  
  public abstract String checkComPeriod(String[] paramArrayOfString);
  
  public abstract String getGenerarionNmberYB(EvsVoucherSelect paramEvsVoucherSelect);
  
  public abstract String findEvsVoucherVByJournalNum(Long paramLong);
  
  public abstract TableDataInfo getVoucherInfoByCodeForS(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract EvsBook updateBookInfoForS(String paramString);
  
  public abstract String updateEvsBookForS(EvsVoucherSelect paramEvsVoucherSelect, String paramString1, String paramString2);
  
  public abstract List<String> checkBookExistsByVoucherId(String[] paramArrayOfString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IEvsBookService
 * JD-Core Version:    0.7.0.1
 */