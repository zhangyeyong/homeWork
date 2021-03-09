package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherLine;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.util.List;

public class EEvsVoucherLineDAO
  extends BaseDAO
  implements IEvsVoucherLineDAO
{
  public List<EvsVoucherLine> findLineByVoucherId(Long paramLong, String paramString)
  {
    return getSession().createQuery("from EvsVoucherLine l where l.voucherId=" + paramLong + " and l.voucherType='" + paramString + "'").list();
  }
  
  public List<EvsVoucherLine> findPrintListByVoucherId(Long paramLong)
  {
    return getSession().createQuery("from EvsVoucherLine l where l.voucherId=" + paramLong + " order by nvl2(l.accDr,1,2),l.subjectCode DESC ").list();
  }
  
  public void inserEvsVoucherLines(List<EvsVoucherLine> paramList) {}
  
  public EvsVoucher getEvsVoucher(Long paramLong)
  {
    return (EvsVoucher)super.getObject(EvsVoucher.class, paramLong);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EEvsVoucherLineDAO
 * JD-Core Version:    0.7.0.1
 */