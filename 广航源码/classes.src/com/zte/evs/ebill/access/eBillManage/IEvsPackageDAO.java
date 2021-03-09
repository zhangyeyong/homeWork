package com.zte.evs.ebill.access.eBillManage;

import com.zte.eas.resconfig.business.periods.model.FbpPeriods;
import com.zte.evs.ebill.model.eBillManage.EvsAddBookV;
import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.EvsBookModel;
import com.zte.evs.ebill.model.eBillManage.EvsBookV;
import com.zte.evs.ebill.model.eBillManage.EvsImage;
import com.zte.evs.ebill.model.eBillManage.EvsPackage;
import com.zte.evs.ebill.model.eBillManage.EvsPackageModel;
import com.zte.evs.ebill.model.eBillManage.EvsPackageV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherBookPackage;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;
import java.util.Map;

public abstract interface IEvsPackageDAO
{
  public abstract Map findAllPackage(EvsPackageModel paramEvsPackageModel, int paramInt1, int paramInt2);
  
  public abstract Map findAllBook(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract Map findBookByStatus(String paramString, int paramInt1, int paramInt2);
  
  public abstract Map findBookByCode(EvsBook paramEvsBook, int paramInt1, int paramInt2);
  
  public abstract Map findVoucherByBookCode(EvsVoucherBookPackage paramEvsVoucherBookPackage, int paramInt1, int paramInt2);
  
  public abstract Map findAttachmentByVoucherId(EvsVoucher paramEvsVoucher, int paramInt1, int paramInt2);
  
  public abstract Map findBookByNumber(String paramString, int paramInt1, int paramInt2);
  
  public abstract Map getBookByBookCode(String paramString, int paramInt1, int paramInt2);
  
  public abstract Map getBookByBookStatus(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract Map getVoucherByVoucherCode(String paramString, int paramInt1, int paramInt2);
  
  public abstract EvsPackage getPackageByCode(EvsPackageModel paramEvsPackageModel);
  
  public abstract EvsPackage getPackageById(EvsPackageModel paramEvsPackageModel);
  
  public abstract EvsBook getBookByCode(EvsBookModel paramEvsBookModel);
  
  public abstract EvsBook getBookById(EvsBook paramEvsBook);
  
  public abstract EvsPackageV getPackageByPackageCode(String paramString);
  
  public abstract EvsVoucherV getVoucherByJournalNum(String paramString);
  
  public abstract String getDocTypeById();
  
  public abstract List getVoucherById(String paramString);
  
  public abstract List getBookByBookIds(String paramString);
  
  public abstract List getBookByBookId(String paramString);
  
  public abstract List<EvsBook> getBookByPackageId(String paramString);
  
  public abstract List<EvsBook> getBookStatusByBookCode(String paramString);
  
  public abstract void updateStatusByPackage(String paramString1, String paramString2, String paramString3);
  
  public abstract void updateStatusByBook(String paramString1, String paramString2);
  
  public abstract void updateStatusByPackageCode(String paramString1, String paramString2);
  
  public abstract void updatePackageStatusById(String paramString1, String paramString2);
  
  public abstract void updateBookStatusByPackageId(String paramString1, String paramString2);
  
  public abstract String updateStatusByBookCode(EvsBookModel paramEvsBookModel, String paramString);
  
  public abstract void updatePackageIdByBookCode(EvsBook paramEvsBook);
  
  public abstract void updateVoucherBookPackageByPackageId(String paramString1, String paramString2);
  
  public abstract void updateVoucherStatusByBookCode(String paramString);
  
  public abstract void updateVoucherOnPackaged(String paramString);
  
  public abstract void updateStatus(String paramString1, String paramString2);
  
  public abstract void updateReturnStatus(String paramString);
  
  public abstract void updateBookStatusByCode(String paramString1, String paramString2);
  
  public abstract String findBookByIsBookStatus(String paramString);
  
  public abstract void savePackage(EvsPackage paramEvsPackage);
  
  public abstract void saveVoucherBookPackage(EvsVoucherBookPackage paramEvsVoucherBookPackage);
  
  public abstract void savePackageInfo(String paramString);
  
  public abstract void saveBook(String paramString);
  
  public abstract String getGenerarionNmber(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract String getPeriodName();
  
  public abstract String getSetBookOrgId();
  
  public abstract List printBookByCode(EvsAddBookV paramEvsAddBookV);
  
  public abstract String getDateByPeriodName(String paramString);
  
  public abstract String getCompanyName();
  
  public abstract void updateVoucherStatusByBookCodeNew(String paramString1, String paramString2);
  
  public abstract Map findAllPackageNew(EvsPackageModel paramEvsPackageModel, String[] paramArrayOfString, int paramInt1, int paramInt2);
  
  public abstract PageInfo getPackageByPackageId(String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2);
  
  public abstract void updateStatusByPackageId(String paramString1, String paramString2);
  
  public abstract List<String> findIdByBoxCode(String paramString);
  
  public abstract PageInfo findBookByIds(String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2);
  
  public abstract List<EvsBookV> findBookByCodeNew(EvsPackageV paramEvsPackageV, String paramString);
  
  public abstract List<EvsVoucherV> findVoucherByBookCodeNwe(EvsBookV paramEvsBookV);
  
  public abstract List<EvsImage> findImageNumByVoucherId(String paramString);
  
  public abstract PageInfo findAllBookNew(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2, String[] paramArrayOfString, String paramString);
  
  public abstract PageInfo findAllVoucherNew(EvsVoucherV paramEvsVoucherV, int paramInt1, int paramInt2, String[] paramArrayOfString, String paramString);
  
  public abstract PageInfo findVoucherByNumbs(String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2);
  
  public abstract PageInfo findBookByNumbs(String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2);
  
  public abstract List<String> findBookedPeriod(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4);
  
  public abstract List<String> findPeriodOnYear(String paramString1, boolean paramBoolean, String paramString2);
  
  public abstract List<FbpPeriods> findPeriod(String paramString);
  
  public abstract void updateStatusByBookId(String paramString1, String paramString2);
  
  public abstract List<EvsBook> findBookByParam(String paramString1, String paramString2, String paramString3);
  
  public abstract List<String> findDocNumb(String paramString);
  
  public abstract String findMaxArchiveNumber(String paramString);
  
  public abstract void updateBoolArhciveNumber(String paramString1, String paramString2);
  
  public abstract List<String> findDossierNumber(String paramString);
  
  public abstract List<String> findAllPeriod(String paramString1, String paramString2, String paramString3);
  
  public abstract List<String> findUnBookPeriod(String paramString1, String paramString2, String paramString3);
  
  public abstract void updateBookStatusByPackageIdNew(String paramString1, String paramString2);
  
  public abstract List<EvsBook> findBookdByArhciveNumber(String paramString);
  
  public abstract void updateSerials(String paramString1, String paramString2);
  
  public abstract void updateBook(EvsBook paramEvsBook);
  
  public abstract List<EvsBook> findBookdByArhciveNumberNew(String paramString);
  
  public abstract List<EvsBookV> findBookByNum(String paramString);
  
  public abstract List findImageByImageNumer(String paramString);
  
  public abstract void updateWarehouse(String paramString1, String paramString2);
  
  public abstract void updateBookStatusByPackage(String paramString1, String paramString2);
  
  public abstract void updateVoucherStatusByPackage(String paramString1, String paramString2);
  
  public abstract Map findPackage(EvsPackageModel paramEvsPackageModel, int paramInt1, int paramInt2);
  
  public abstract String validateVoucherStatus(String paramString);
  
  public abstract String validateVoucherStatusList(String paramString1, String paramString2);
  
  public abstract Map findPackageList(EvsPackageModel paramEvsPackageModel, int paramInt1, int paramInt2);
  
  public abstract List getBookBypackageCode(String paramString);
  
  public abstract List<EvsBook> findBookByPack(String paramString1, String paramString2);
  
  public abstract void delBookStatusByPackage(String paramString1, String paramString2);
  
  public abstract void cleanVoucherBookPackageByPackageId(String paramString);
  
  public abstract void updateVoucherStatusByBookID(String paramString1, String paramString2);
  
  public abstract List<String> findEvsBookCodeVByBookCode(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2);
  
  public abstract EvsBookV getBookVByCode(String paramString1, String paramString2);
  
  public abstract List findAllBookCode(EvsBook paramEvsBook);
  
  public abstract List findAllBookID(EvsBook paramEvsBook);
  
  public abstract List<Long> findAllBookCodeByWarehouse(EvsBookModel paramEvsBookModel, String[] paramArrayOfString, String paramString);
  
  public abstract String getGenerarionAllotNmber(String paramString);
  
  public abstract void updateVoucherStatus(EvsBook paramEvsBook, String paramString);
  
  public abstract List<EvsBookV> getBookVByCodeList(String paramString1, String paramString2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsPackageDAO
 * JD-Core Version:    0.7.0.1
 */