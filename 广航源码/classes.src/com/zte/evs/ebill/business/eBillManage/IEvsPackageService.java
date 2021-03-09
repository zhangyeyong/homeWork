package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.EvsBookModel;
import com.zte.evs.ebill.model.eBillManage.EvsPackage;
import com.zte.evs.ebill.model.eBillManage.EvsPackageModel;
import com.zte.evs.ebill.model.eBillManage.EvsPackageV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherBookPackage;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.evs.ebill.model.eBillManage.ReturnMessage;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IEvsPackageService
{
  public abstract TableDataInfo findAllPackage(EvsPackageModel paramEvsPackageModel, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findAllBook(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findBookByStatus(List<String> paramList, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findBookByCode(EvsBook paramEvsBook, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findVoucherByBookCode(EvsVoucherBookPackage paramEvsVoucherBookPackage, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findAttachmentByVoucherId(EvsVoucher paramEvsVoucher, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findBookByNumber(List<String> paramList, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo getBookByBookCode(List<String> paramList, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo getBookByBookStatus(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo getVoucherByVoucherCode(List<String> paramList, int paramInt1, int paramInt2);
  
  public abstract EvsPackage getPackageByCode(EvsPackageModel paramEvsPackageModel);
  
  public abstract EvsPackage getPackageById(EvsPackageModel paramEvsPackageModel);
  
  public abstract EvsBook getBookByCode(EvsBookModel paramEvsBookModel);
  
  public abstract EvsBook getBookById(EvsBook paramEvsBook);
  
  public abstract EvsPackageV getPackageByPackageCode(String paramString);
  
  public abstract String getDocTypeById();
  
  public abstract List getVoucherById(String paramString);
  
  public abstract List getBookByBookIds(String paramString);
  
  public abstract List getBookByPackageId(String paramString);
  
  public abstract void updateStatusByPackage(List<String> paramList, String paramString);
  
  public abstract void updateStatusByBook(List<String> paramList);
  
  public abstract void updateStatusByPackageCode(String paramString);
  
  public abstract void updateBookStatusByPackageId(String paramString);
  
  public abstract String updateStatusByBookCode(EvsBookModel paramEvsBookModel);
  
  public abstract void updatePackageIdByBookCode(EvsBook paramEvsBook);
  
  public abstract void updatePackageStatusById(String paramString);
  
  public abstract void updateVoucherBookPackageByPackageId(String paramString, List<String> paramList);
  
  public abstract void updateVoucherStatusByBookCode(List<String> paramList);
  
  public abstract void updateVoucherOnPackaged(List<String> paramList);
  
  public abstract void updateStatus(List<String> paramList);
  
  public abstract void updateReturnStatus(List<String> paramList);
  
  public abstract void updateBookStatusByCode(String paramString);
  
  public abstract String findBookByIsBookStatus(List<String> paramList);
  
  public abstract void savePackage(EvsPackage paramEvsPackage);
  
  public abstract void saveVoucherBookPackage(EvsVoucherBookPackage paramEvsVoucherBookPackage);
  
  public abstract String addMessage(String paramString);
  
  public abstract String getGenerarionNmber(String[] paramArrayOfString);
  
  public abstract String getPeriodName();
  
  public abstract String getSetBookOrgId();
  
  public abstract String checkVoucherByNum(EvsVoucherV paramEvsVoucherV);
  
  public abstract String getCompanyName();
  
  public abstract String getDateByPeriodName(String paramString);
  
  public abstract TableDataInfo findAllPackageNew(EvsPackageModel paramEvsPackageModel, String[] paramArrayOfString, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo getPackageByPackageId(String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2);
  
  public abstract String checkBoxByNum(EvsPackageModel paramEvsPackageModel);
  
  public abstract List<String> findIdByBoxCode(List<String> paramList);
  
  public abstract TableDataInfo findBookByIds(String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2);
  
  public abstract String getImagePageUrl(String paramString);
  
  public abstract TableDataInfo findAllBookNew(EvsBookModel paramEvsBookModel, String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findBookByNumbs(String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2);
  
  public abstract ReturnMessage findBookedPeriod(String paramString1, String paramString2, String paramString3);
  
  public abstract ReturnMessage manageArchiveNumber(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract ReturnMessage findRemovePeriod(String paramString1, String paramString2, String paramString3);
  
  public abstract String checkByBookCode(EvsBookModel paramEvsBookModel);
  
  public abstract List getImage(String paramString);
  
  public abstract List<EvsVoucher> getEvsVoucher(String paramString);
  
  public abstract PageInfo findEvsVoucherByBookId(Long paramLong, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findAllVoucherNew(EvsVoucherV paramEvsVoucherV, String[] paramArrayOfString, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findVoucherByNumbs(String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2);
  
  public abstract String updateStatusByWarehouse(List<String> paramList, String paramString);
  
  public abstract TableDataInfo findPackage(EvsPackageModel paramEvsPackageModel, int paramInt1, int paramInt2);
  
  public abstract String validateVoucherStatus(String paramString);
  
  public abstract TableDataInfo findPackageList(EvsPackageModel paramEvsPackageModel, int paramInt1, int paramInt2);
  
  public abstract String validateVoucherStatusList(String paramString1, String paramString2);
  
  public abstract EvsVoucher getVoucherByVoucherId(String paramString);
  
  public abstract TableDataInfo findVoucherByVoucherId(String paramString, int paramInt1, int paramInt2);
  
  public abstract void delPackToBook(List<String> paramList, String paramString);
  
  public abstract String checkSeachLimit(Long paramLong);
  
  public abstract PageInfo findImageByBookId(Long paramLong, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findFascicule(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo getVoucherList(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract List<EvsVoucherBookPackage> getVoucherListForL(EvsBookModel paramEvsBookModel);
  
  public abstract List<EvsVoucherBookPackage> getVoucherListForL2(EvsBookModel paramEvsBookModel);
  
  public abstract List<EvsVoucherV> findFasciculeList(List<EvsVoucherV> paramList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract String findFasciculeListCheck(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IEvsPackageService
 * JD-Core Version:    0.7.0.1
 */