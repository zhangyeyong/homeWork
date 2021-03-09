package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.access.eBillManage.IEvsVoucherLineDAO;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.evs.ebill.model.eBillManage.EvsVoucherLine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvsVoucherLineQuery
  implements IEvsVoucherLineQuery
{
  private IEvsVoucherLineDAO evsVoucherLineDAO;
  
  public List<Map<String, String>> findLineByVoucherId(Long paramLong, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = this.evsVoucherLineDAO.findPrintListByVoucherId(paramLong);
    EvsVoucher localEvsVoucher = this.evsVoucherLineDAO.getEvsVoucher(paramLong);
    if ((localList != null) && (localList.size() > 0))
    {
      HashMap localHashMap = null;
      EvsVoucherLine localEvsVoucherLine = null;
      for (int i = 0; i < localList.size(); i++)
      {
        localEvsVoucherLine = (EvsVoucherLine)localList.get(i);
        if (localEvsVoucherLine != null)
        {
          localHashMap = new HashMap();
          localHashMap.put("LINE_NUM", "" + (i + 1));
          localHashMap.put("LINE_DESC", localEvsVoucherLine.getLineDesc());
          localHashMap.put("ACCOUNT_DESC", localEvsVoucherLine.getAccountDesc());
          localHashMap.put("CONVER_RATE", "" + localEvsVoucherLine.getConverRate());
          localHashMap.put("ACC_DR", "" + localEvsVoucherLine.getAccDr());
          localHashMap.put("ACC_CR", "" + localEvsVoucherLine.getAccCr());
          localHashMap.put("SUBJECT_CODE", "" + localEvsVoucherLine.getSubjectCode() + " " + localEvsVoucherLine.getSubjectDetail());
          if (!"RMB".equals(localEvsVoucher.getCurrencyCode())) {
            localHashMap.put("CURRENCY_AMOUNT", "" + localEvsVoucherLine.getCurrencyAmount());
          }
          localArrayList.add(localHashMap);
        }
      }
    }
    return localArrayList;
  }
  
  public IEvsVoucherLineDAO getEvsVoucherLineDAO()
  {
    return this.evsVoucherLineDAO;
  }
  
  public void setEvsVoucherLineDAO(IEvsVoucherLineDAO paramIEvsVoucherLineDAO)
  {
    this.evsVoucherLineDAO = paramIEvsVoucherLineDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsVoucherLineQuery
 * JD-Core Version:    0.7.0.1
 */