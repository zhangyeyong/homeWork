package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsAllotHeaders;
import com.zte.evs.ebill.model.eBillManage.EvsAllotHeadersV;
import com.zte.evs.ebill.model.eBillManage.EvsInventory;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import java.math.BigInteger;
import java.util.List;

public abstract interface IVoucherFlittingService
{
  public abstract List<String> findEmpCheckUtil(String paramString);
  
  public abstract List<String[]> findAllotType(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract List<String[]> findStoreCheckUnit(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract List<String[]> findStoreSit(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract String saveFlittingBoeForBook(EvsAllotHeaders paramEvsAllotHeaders, String paramString)
    throws Exception;
  
  public abstract TableDataInfo findAllotHeaders(EvsAllotHeadersV paramEvsAllotHeadersV, String paramString1, String paramString2);
  
  public abstract TableDataInfo findAllotHeadersV2(EvsAllotHeadersV paramEvsAllotHeadersV, String paramString1, String paramString2);
  
  public abstract TableDataInfo findBookByAllotNum(String paramString1, String paramString2, String paramString3);
  
  public abstract EvsAllotHeadersV findOneAllotBoe(String paramString1, String paramString2);
  
  public abstract String saveFlittingBoeForBox(EvsAllotHeaders paramEvsAllotHeaders, String[] paramArrayOfString, String paramString);
  
  public abstract TableDataInfo findBoxByAllotNum(String paramString, int paramInt1, int paramInt2);
  
  public abstract String checkBoxOnReceive(String paramString1, String paramString2);
  
  public abstract String saveDataToReceive(EvsAllotHeaders paramEvsAllotHeaders, String[] paramArrayOfString, String paramString);
  
  public abstract String checkBookOnReceive(String paramString1, String paramString2);
  
  public abstract String saveDataToReceiveForBook(EvsAllotHeaders paramEvsAllotHeaders, String[] paramArrayOfString, String paramString);
  
  public abstract TableDataInfo findBoxByAllotNumNew(String paramString, List<String> paramList, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findBookByAllotNumNew(String paramString, List<String> paramList, int paramInt1, int paramInt2);
  
  public abstract EvsAllotHeaders findAllotBoeBySubId(String paramString);
  
  public abstract TableDataInfo findAllotHeadersByIncept(EvsAllotHeadersV paramEvsAllotHeadersV, String paramString1, String paramString2);
  
  public abstract String saveFlittingBoeForVoucher(EvsAllotHeaders paramEvsAllotHeaders, String[] paramArrayOfString, String paramString);
  
  public abstract String updateInceptAllot(Long paramLong);
  
  public abstract String updateInceptAllotBoe(List<String> paramList);
  
  public abstract String removeAllotHeadersById(Long paramLong);
  
  public abstract String updateAllotHeadersById2(Long paramLong, String paramString);
  
  public abstract TableDataInfo findVoucherByAllotNum(String paramString1, String paramString2, String paramString3);
  
  public abstract Object findBoxByAllotNum(String paramString);
  
  public abstract EvsAllotHeaders findAllotHeaders1(BigInteger paramBigInteger);
  
  public abstract String updateFlittingBoeForBook(EvsAllotHeaders paramEvsAllotHeaders, String paramString, EvsInventory paramEvsInventory)
    throws Exception;
  
  public abstract EvsAllotHeaders findEvsAllotHeaders(String paramString);
  
  public abstract String findExportData(String[] paramArrayOfString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IVoucherFlittingService
 * JD-Core Version:    0.7.0.1
 */