package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsBookVoucherDetailV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistory;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherV;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherVo;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import java.util.List;
import java.util.Map;

public abstract interface IEvsVoucherQuery
{
  public abstract List<EvsVoucherV> getBoeInfo(String paramString1, String paramString2);
  
  public abstract List<EvsVoucherV> getApVouchers(String paramString);
  
  public abstract List<EvsVoucherV> getPaymentVouchers(String paramString1, String paramString2);
  
  public abstract TableDataInfo getVoucherList(EvsVoucherVo paramEvsVoucherVo, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo findVoucherQueryV(EvsVoucherVo paramEvsVoucherVo, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo getVoucherFasciculeList(EvsVoucherVo paramEvsVoucherVo, int paramInt1, int paramInt2);
  
  public abstract List<Map<String, String>> getVoucherWhereNeedCreate(int paramInt);
  
  public abstract List<Map<String, String>> getHistoryWhereNeedCreate(int paramInt);
  
  public abstract void updateVoucherUpdateStatus(Long paramLong, int paramInt);
  
  public abstract void updateVoucherHisUpdateStatus(Long paramLong, int paramInt);
  
  public abstract TableDataInfo getAllHistoryForVoucher(EvsVoucherHistory paramEvsVoucherHistory, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo getVoucherListByCondition(EvsBookVoucherDetailV paramEvsBookVoucherDetailV, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract Map<String, String> getVoucherById(Long paramLong);
  
  public abstract TableDataInfo getAddFasciculeList(EvsVoucherVo paramEvsVoucherVo, int paramInt1, int paramInt2);
  
  public abstract TableDataInfo getAddVoucherList(EvsVoucherVo paramEvsVoucherVo, int paramInt1, int paramInt2);
  
  public abstract int findBookCountByQry(EvsVoucherVo paramEvsVoucherVo);
  
  public abstract TableDataInfo getVoucherInspect(EvsVoucherVo paramEvsVoucherVo, int paramInt1, int paramInt2);
  
  public abstract String fetchCurrentUserInfoPK();
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.IEvsVoucherQuery
 * JD-Core Version:    0.7.0.1
 */