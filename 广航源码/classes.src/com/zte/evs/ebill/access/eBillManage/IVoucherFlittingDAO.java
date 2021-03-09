package com.zte.evs.ebill.access.eBillManage;

import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesLovV;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.evs.ebill.model.archives.FindEmployeesV;
import com.zte.evs.ebill.model.eBillManage.EvsAllotDetails;
import com.zte.evs.ebill.model.eBillManage.EvsAllotHeaders;
import com.zte.evs.ebill.model.eBillManage.EvsAllotHeadersV;
import com.zte.evs.ebill.model.eBillManage.EvsBook;
import com.zte.evs.ebill.model.eBillManage.EvsBookV;
import com.zte.evs.ebill.model.eBillManage.EvsInventory;
import com.zte.evs.ebill.model.eBillManage.EvsPackage;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherBookPackage;
import com.zte.ssb.framework.base.util.PageInfo;
import java.math.BigInteger;
import java.util.List;

public abstract interface IVoucherFlittingDAO
{
  public abstract void addFlittingInvoicesHeader(EvsAllotHeaders paramEvsAllotHeaders);
  
  public abstract void addFlittingInvoicesLine(EvsAllotDetails paramEvsAllotDetails);
  
  public abstract void delFlittingInvoicesHeader(EvsAllotHeaders paramEvsAllotHeaders);
  
  public abstract void delFlittingInvoicesLine(EvsAllotDetails paramEvsAllotDetails);
  
  public abstract void updateFlittingInvoicesHeader(EvsAllotHeaders paramEvsAllotHeaders);
  
  public abstract void updateFlittingInvoicesLine(EvsAllotDetails paramEvsAllotDetails);
  
  public abstract List<String> findEmpCheckUtil(String paramString);
  
  public abstract List<String[]> findAllotType(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract List<String[]> findStoreCheckUnit(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract List<String[]> findStoreSit(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract List<EvsVoucherBookPackage> getEvsVoucherByPackageId(Long paramLong);
  
  public abstract FbpEmployeesV getEmpVInfo(String paramString);
  
  public abstract PageInfo findAllotHeaders(EvsAllotHeadersV paramEvsAllotHeadersV, Integer paramInteger1, Integer paramInteger2);
  
  public abstract PageInfo findAllotHeadersV2(EvsAllotHeadersV paramEvsAllotHeadersV, Integer paramInteger1, Integer paramInteger2);
  
  public abstract PageInfo findAllotHeadersByIncept(EvsAllotHeadersV paramEvsAllotHeadersV, Integer paramInteger1, Integer paramInteger2);
  
  public abstract PageInfo findBookByAllotNum(String paramString, Integer paramInteger1, Integer paramInteger2);
  
  public abstract PageInfo findVoucherByAllotNum(String paramString, Integer paramInteger1, Integer paramInteger2);
  
  public abstract PageInfo findBoxByAllotNum(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<String> findRelationIdByAllotNum(Long paramLong);
  
  public abstract EvsAllotHeaders getEvsAllotHeaders(BigInteger paramBigInteger);
  
  public abstract List<EvsAllotHeadersV> findAllotByNum(List<String> paramList);
  
  public abstract PageInfo findBoxByAllotNumNew(String paramString, List<String> paramList, int paramInt1, int paramInt2);
  
  public abstract List<String> findRelationIdByAllotNumNew(String paramString1, String paramString2);
  
  public abstract PageInfo findBookByNumbs(List<String> paramList, String paramString, int paramInt1, int paramInt2);
  
  public abstract List<EvsAllotHeaders> findAllotBoeBySubId(String paramString);
  
  public abstract List<EvsBook> findBookByAllotId(Long paramLong);
  
  public abstract List<EvsVoucher> getEvsVoucher(String paramString1, String paramString2);
  
  public abstract List<EvsVoucherBookPackage> getEvsVoucherByBookId(Long paramLong);
  
  public abstract void updateEvsVoucher(EvsVoucher paramEvsVoucher);
  
  public abstract List<EvsPackage> findBoxByAllotId(String paramString);
  
  public abstract void updatePackage(EvsPackage paramEvsPackage);
  
  public abstract void updateObject(Object paramObject);
  
  public abstract List<EvsAllotDetails> findAllotDetailsByAllotHeaderId(Long paramLong, String paramString);
  
  public abstract List<EvsAllotHeadersV> findAllotById(List<String> paramList);
  
  public abstract EvsBook findBookByBookId(Long paramLong);
  
  public abstract FindEmployeesV findEmployeesLoginV();
  
  public abstract void delEvsAllotHeadersByDetails(BigInteger paramBigInteger);
  
  public abstract void updateInventory(Long paramLong);
  
  public abstract List<String> getEvsAllotHeadersByDetails(BigInteger paramBigInteger);
  
  public abstract void updateInventoryByBookId(EvsInventory paramEvsInventory);
  
  public abstract int delFlittingInvoicesHeader(BigInteger paramBigInteger);
  
  public abstract int delFlittingDetailsLine(BigInteger paramBigInteger);
  
  public abstract PageInfo findHistoryByObjectCodeNew(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract EvsInventory getEvsInventoryCan(String paramString);
  
  public abstract EvsAllotHeaders getEvsAllotHeadersByAllotNum(String paramString);
  
  public abstract FbpCompanyV getCompanyById(String paramString);
  
  public abstract FbpEmployeesLovV getEmpLovVInfo(String paramString);
  
  public abstract List<EvsBookV> findBookByAllotIdForExport(Long paramLong);
  
  public abstract EvsAllotHeadersV findAllotHeadersById(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IVoucherFlittingDAO
 * JD-Core Version:    0.7.0.1
 */