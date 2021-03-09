package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsBookModel;
import com.zte.evs.ebill.model.eBillManage.EvsBookVoucherDetailV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherBookPackage;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherLineV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherVo;
import com.zte.ssb.framework.base.util.PageInfo;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract interface IEvsVoucherDAO
{
  public abstract List<EvsVoucherV> getBoeInfo(String paramString1, String paramString2);
  
  public abstract List<EvsVoucherV> getApVouchers(String paramString);
  
  public abstract List<EvsVoucherV> getPaymentVouchers(String paramString);
  
  public abstract EvsVoucherV findEvsVoucherVByJournalNum(String paramString);
  
  public abstract List<EvsVoucherV> findEvsVoucherVByJournalNum(Long paramLong);
  
  public abstract Map findVoucherByQry(EvsVoucherVo paramEvsVoucherVo, int paramInt1, int paramInt2);
  
  public abstract List<EvsVoucherLineV> findVoucherWhereNeedCreate(int paramInt);
  
  public abstract List<EvsVoucher> findHistoryWhereNeedCreate(int paramInt);
  
  public abstract void updateVoucherUpdateStatus(Long paramLong, int paramInt);
  
  public abstract void updateVoucherHisUpdateStatus(Long paramLong, int paramInt);
  
  public abstract Map findAllHistoryForVoucher(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<EvsVoucher> findEvsVoucherByVoucherId(List paramList);
  
  public abstract PageInfo findVoucherByQryCondition(EvsBookVoucherDetailV paramEvsBookVoucherDetailV, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract EvsVoucher getEvsVoucherByCode(String paramString);
  
  public abstract void insertObject(EvsVoucher paramEvsVoucher);
  
  public abstract Date getLastDateByType(String paramString);
  
  public abstract void vocherMatch()
    throws SQLException;
  
  public abstract EvsVoucherLineV findVoucherVById(long paramLong);
  
  public abstract Map findFasciculeByQry(EvsVoucherVo paramEvsVoucherVo, int paramInt1, int paramInt2);
  
  public abstract Map findVoucherList(EvsVoucherVo paramEvsVoucherVo, int paramInt1, int paramInt2);
  
  public abstract EvsVoucher findEvsVoucherVByVoucherId(Long paramLong);
  
  public abstract List<EvsVoucher> findEvsVoucherVByBookId(Long paramLong);
  
  public abstract Map findVoucherQueryV(EvsVoucherVo paramEvsVoucherVo, int paramInt1, int paramInt2);
  
  public abstract Map findVoucherByVoucherId(String paramString, int paramInt1, int paramInt2);
  
  public abstract String findEvsManageOrgVS(String paramString1, String paramString2);
  
  public abstract PageInfo findEvsVoucherByBookId(Long paramLong, int paramInt1, int paramInt2);
  
  public abstract PageInfo findImageByBookId(Long paramLong, int paramInt1, int paramInt2);
  
  public abstract int findBookCountByQry(EvsVoucherVo paramEvsVoucherVo);
  
  public abstract PageInfo findVoucherInspect(EvsVoucherVo paramEvsVoucherVo, int paramInt1, int paramInt2);
  
  public abstract List<EvsVoucher> findEvsVoucherByVoucherIds(List paramList);
  
  public abstract String checkFascicule(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract Map findFascicule(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2);
  
  public abstract List<EvsVoucherV> findFasciculeByList(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract boolean findFasciculeListCheck(String paramString);
  
  public abstract Map getVoucherList(EvsBookModel paramEvsBookModel, int paramInt1, int paramInt2);
  
  public abstract List<EvsVoucherV> getVoucherListByList(EvsBookModel paramEvsBookModel);
  
  public abstract List<EvsVoucherBookPackage> getVoucherListForL(EvsBookModel paramEvsBookModel);
  
  public abstract List<EvsVoucherBookPackage> getVoucherListForL2(EvsBookModel paramEvsBookModel);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsVoucherDAO
 * JD-Core Version:    0.7.0.1
 */