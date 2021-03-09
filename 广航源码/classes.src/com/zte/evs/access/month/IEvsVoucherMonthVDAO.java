package com.zte.evs.access.month;

import com.zte.evs.business.month.model.EvsVoucherMonthV;
import com.zte.ssb.framework.base.DAO;
import java.math.BigInteger;
import java.util.List;

public abstract interface IEvsVoucherMonthVDAO
  extends DAO
{
  public abstract List findEvsVoucherMonthVById(String paramString);
  
  public abstract List findAllEvsVoucherMonthV();
  
  public abstract List findDeptsVById();
  
  public abstract List findDownDeptsVl(BigInteger paramBigInteger);
  
  public abstract List findMonthById(String paramString1, String paramString2, String paramString3);
  
  public abstract List findById(BigInteger paramBigInteger);
  
  public abstract List findEvsVoucherByMonthV(String paramString1, String paramString2);
  
  public abstract List findEvsVoucherByYearV(String paramString1, String paramString2);
  
  public abstract List fasciculeQuaryInfoByPZ(String paramString1, String paramString2, String paramString3);
  
  public abstract List findList(String paramString);
  
  public abstract List findList1(Long paramLong);
  
  public abstract EvsVoucherMonthV getEvsVoucherMonthV(BigInteger paramBigInteger);
  
  public abstract List<EvsVoucherMonthV> getEvsVoucherMonthVs(int paramInt1, int paramInt2);
  
  public abstract List<EvsVoucherMonthV> getEvsVoucherMonthVs();
  
  public abstract void removeEvsVoucherMonthV(BigInteger paramBigInteger);
  
  public abstract void removeEvsVoucherMonthV(EvsVoucherMonthV paramEvsVoucherMonthV);
  
  public abstract void insertEvsVoucherMonthV(EvsVoucherMonthV paramEvsVoucherMonthV);
  
  public abstract void updateEvsVoucherMonthV(EvsVoucherMonthV paramEvsVoucherMonthV);
  
  public abstract void insertEvsVoucherMonthVs(List<EvsVoucherMonthV> paramList);
  
  public abstract void removeEvsVoucherMonthVs(List<EvsVoucherMonthV> paramList);
  
  public abstract void updateEvsVoucherMonthVs(List<EvsVoucherMonthV> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.access.month.IEvsVoucherMonthVDAO
 * JD-Core Version:    0.7.0.1
 */