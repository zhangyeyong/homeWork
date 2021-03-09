package com.zte.evs.ebill.access.eBillManage;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistory;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistoryModel;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherHistoryV;
import com.zte.ssb.framework.base.util.PageInfo;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public abstract interface IEvsVoucherHistoryDAO
{
  public abstract Map findAllHistory(EvsVoucherHistoryModel paramEvsVoucherHistoryModel, int paramInt1, int paramInt2);
  
  public abstract Map findHistoryByObjectCode(String paramString, int paramInt1, int paramInt2);
  
  public abstract Map findHistoryByPackageId(String paramString, int paramInt1, int paramInt2);
  
  public abstract void addHistory(EasUserInfo paramEasUserInfo, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void addHistoryNew(EasUserInfo paramEasUserInfo, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong1, BigInteger paramBigInteger);
  
  public abstract void addHistoryNew(EasUserInfo paramEasUserInfo, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong1, BigInteger paramBigInteger, String paramString5);
  
  public abstract PageInfo findHistoryByObjectCodeNew(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract List<EvsVoucherHistory> findHistoryById(Long paramLong, String paramString);
  
  public abstract Map findHistoryByVoucherId(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<EvsVoucherHistoryV> findHistoryVById(Long paramLong, String paramString);
  
  public abstract void addHistoryNews(EasUserInfo paramEasUserInfo, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong1, String paramString5);
  
  public abstract void addHistoryNews(EasUserInfo paramEasUserInfo, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong1, String paramString5, String paramString6);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsVoucherHistoryDAO
 * JD-Core Version:    0.7.0.1
 */