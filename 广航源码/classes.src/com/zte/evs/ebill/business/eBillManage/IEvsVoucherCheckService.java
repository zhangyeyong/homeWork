package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsImageModel;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistoryV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherListV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherPrint;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherSelect;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import java.util.List;

public abstract interface IEvsVoucherCheckService
{
  public abstract EvsVoucher findEvsVoucher(String paramString);
  
  public abstract TableDataInfo findCheckedList(EvsVoucherV paramEvsVoucherV, int paramInt1, int paramInt2);
  
  public abstract String findHeader();
  
  public abstract boolean updateCheck(List<String> paramList);
  
  public abstract boolean updateCheckStatus(List<String> paramList);
  
  public abstract TableDataInfo getCheckList(EvsVoucherV paramEvsVoucherV, int paramInt1, int paramInt2);
  
  public abstract EvsVoucher getEvsVoucher(Long paramLong);
  
  public abstract void updateVoucher(EvsVoucherSelect paramEvsVoucherSelect, String paramString);
  
  public abstract boolean updateBack(List<String> paramList);
  
  public abstract TableDataInfo findEntry(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2);
  
  public abstract List<EvsVoucherV> findEvsVoucherVByVoucherId(String paramString);
  
  public abstract TableDataInfo getVoucherByScan(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2);
  
  public abstract String updateBatchVoucher(List<EvsVoucherSelect> paramList);
  
  public abstract boolean addcheckComment(List<String> paramList);
  
  public abstract boolean addcheckCommentNote(String paramString1, String paramString2, String paramString3);
  
  public abstract boolean addcheckCommentBack(List<String> paramList, String paramString);
  
  public abstract void createInvoice();
  
  public abstract TableDataInfo findInvoices(EvsVoucherSelect paramEvsVoucherSelect, int paramInt1, int paramInt2);
  
  public abstract List<String> getCheckedInvoiceArr(Long paramLong);
  
  public abstract String saveInvoice(Long paramLong, List<String> paramList);
  
  public abstract TableDataInfo findcheckedInvoices(Long paramLong, int paramInt1, int paramInt2);
  
  public abstract String cancelVoucher(Long paramLong);
  
  public abstract List<EvsVoucherListV> getEvsVoucherListVByIds(List<String> paramList);
  
  public abstract String printValiate(List<String> paramList);
  
  public abstract List<EvsVoucherPrint> getPrintList(String paramString);
  
  public abstract String totalPrintValiate(List<String> paramList);
  
  public abstract List<EvsVoucherPrint> getTotalPrintList(String paramString);
  
  public abstract String createInvoice(Long paramLong);
  
  public abstract List<EvsVoucherHistoryV> findAppraiseDesc(String paramString);
  
  public abstract void updateVoucherStatus(Long paramLong);
  
  public abstract TableDataInfo findImageInf(EvsImageModel paramEvsImageModel, int paramInt1, int paramInt2);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IEvsVoucherCheckService
 * JD-Core Version:    0.7.0.1
 */