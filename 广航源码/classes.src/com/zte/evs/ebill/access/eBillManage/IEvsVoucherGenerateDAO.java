package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.EvsBookModel;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherCheckHistories;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherSelect;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;
import java.util.Map;

public abstract interface IEvsVoucherGenerateDAO
{
  public abstract Map findEmployeeHeaderByQry(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2);
  
  public abstract void update(String paramString1, String paramString2);
  
  public abstract boolean update(EvsBook paramEvsBook, EvsBookModel paramEvsBookModel);
  
  public abstract List<Long> getEvsVoucherBookPackageByBookId(Long paramLong);
  
  public abstract Map findVoucherSubmit(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2);
  
  public abstract Map findEmployeeHeaderByPyVc(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2);
  
  public abstract List findImage(Long paramLong, String paramString);
  
  public abstract void saveVoucher(String paramString);
  
  public abstract List findVoucherByVoucherId(Long paramLong);
  
  public abstract List findImageByVoucherId(Long paramLong);
  
  public abstract List getImageList(List paramList);
  
  public abstract List<EvsVoucherCheckHistories> findVoucherId(Long paramLong);
  
  public abstract String getCheckPersonName(String paramString);
  
  public abstract void saveVoucherByVoucherId(String paramString1, String paramString2);
  
  public abstract String getsubDocName(String paramString);
  
  public abstract PageInfo getImageAccessory(String paramString, int paramInt1, int paramInt2);
  
  public abstract Map findPrintVoucher(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2);
  
  public abstract PageInfo findImageByVoucherId(Long paramLong, int paramInt1, int paramInt2);
  
  public abstract PageInfo findImage(Long paramLong, String paramString, int paramInt1, int paramInt2);
  
  public abstract PageInfo getAllImageByBookId(String paramString, int paramInt1, int paramInt2);
  
  public abstract Map<String, Object> getAllImageByVoucherId(Long paramLong1, Long paramLong2, int paramInt1, int paramInt2);
  
  public abstract PageInfo getAllImageByBookIdNew(Long paramLong, int paramInt1, int paramInt2);
  
  public abstract String findImageCurPage(Long paramLong1, Long paramLong2, int paramInt1, int paramInt2);
  
  public abstract List<EvsVoucherV> getAllInfoPrint(EvsVoucherSelect paramEvsVoucherSelect);
  
  public abstract Map findByTaskNumOrImageNum(List<EvsVoucherV> paramList, int paramInt1, int paramInt2);
  
  public abstract PageInfo getImageNuberList(Long paramLong, int paramInt1, int paramInt2);
  
  public abstract List findImage(Long paramLong);
  
  public abstract Map findVoucherForFascicule(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2);
  
  public abstract List<EvsVoucherV> findVoucherForFasciculeByList(EvsVoucherSelect paramEvsVoucherSelect);
  
  public abstract void updateVoucherFlag(long paramLong, String paramString);
  
  public abstract EvsVoucherV queryEvsVoucherList(long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsVoucherGenerateDAO
 * JD-Core Version:    0.7.0.1
 */