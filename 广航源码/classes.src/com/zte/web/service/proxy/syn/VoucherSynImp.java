package com.zte.web.service.proxy.syn;

import com.zte.evs.ebill.access.eBillManage.IEvsVoucherDAO;
import com.zte.web.service.common.ObjectCommon;
import java.util.Calendar;
import java.util.Date;

public class VoucherSynImp
  implements VoucherSyn
{
  private String apFlag = "";
  private String arFlag = "";
  private String glFlag = "";
  private String paymentFlag = "";
  private String receiptFlag = "";
  private IEvsVoucherDAO evsVoucherDAO;
  private APJournalInfoSynDS apJournalInfoSynImp;
  private ARJournalInfoSynDS arJournalInfoSynImp;
  private GLJournalInfoSynDS glJournalInfoSynImp;
  private PaymentJournalInfoSynDS paymentJournalInfoSynImp;
  private ReceiptJournalInfoSynDS receiptJournalInfoSynImp;
  
  public String getApFlag()
  {
    return this.apFlag;
  }
  
  public void setApFlag(String paramString)
  {
    this.apFlag = paramString;
  }
  
  public String getArFlag()
  {
    return this.arFlag;
  }
  
  public void setArFlag(String paramString)
  {
    this.arFlag = paramString;
  }
  
  public String getGlFlag()
  {
    return this.glFlag;
  }
  
  public void setGlFlag(String paramString)
  {
    this.glFlag = paramString;
  }
  
  public String getPaymentFlag()
  {
    return this.paymentFlag;
  }
  
  public void setPaymentFlag(String paramString)
  {
    this.paymentFlag = paramString;
  }
  
  public String getReceiptFlag()
  {
    return this.receiptFlag;
  }
  
  public void setReceiptFlag(String paramString)
  {
    this.receiptFlag = paramString;
  }
  
  public void Syn()
    throws Throwable
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    Calendar localCalendar3 = Calendar.getInstance();
    Calendar localCalendar4 = Calendar.getInstance();
    Calendar localCalendar5 = Calendar.getInstance();
    Calendar localCalendar6 = Calendar.getInstance();
    Date localDate1 = this.evsVoucherDAO.getLastDateByType(this.apFlag);
    Date localDate2 = this.evsVoucherDAO.getLastDateByType(this.arFlag);
    Date localDate3 = this.evsVoucherDAO.getLastDateByType(this.glFlag);
    Date localDate4 = this.evsVoucherDAO.getLastDateByType(this.paymentFlag);
    Date localDate5 = this.evsVoucherDAO.getLastDateByType(this.receiptFlag);
    this.apJournalInfoSynImp.qry(null, dateToCalendar(localDate1), localCalendar1);
    this.arJournalInfoSynImp.qry(null, dateToCalendar(localDate2), localCalendar1);
    this.glJournalInfoSynImp.qry(null, dateToCalendar(localDate3), localCalendar1);
    this.paymentJournalInfoSynImp.qry(null, dateToCalendar(localDate4), localCalendar1);
    this.receiptJournalInfoSynImp.qry(null, dateToCalendar(localDate5), localCalendar1);
  }
  
  public Calendar dateToCalendar(Date paramDate)
  {
    if (paramDate == null) {
      return null;
    }
    return ObjectCommon.dateToCalendar(paramDate);
  }
  
  public IEvsVoucherDAO getEvsVoucherDAO()
  {
    return this.evsVoucherDAO;
  }
  
  public void setEvsVoucherDAO(IEvsVoucherDAO paramIEvsVoucherDAO)
  {
    this.evsVoucherDAO = paramIEvsVoucherDAO;
  }
  
  public APJournalInfoSynDS getApJournalInfoSynImp()
  {
    return this.apJournalInfoSynImp;
  }
  
  public void setApJournalInfoSynImp(APJournalInfoSynDS paramAPJournalInfoSynDS)
  {
    this.apJournalInfoSynImp = paramAPJournalInfoSynDS;
  }
  
  public ARJournalInfoSynDS getArJournalInfoSynImp()
  {
    return this.arJournalInfoSynImp;
  }
  
  public void setArJournalInfoSynImp(ARJournalInfoSynDS paramARJournalInfoSynDS)
  {
    this.arJournalInfoSynImp = paramARJournalInfoSynDS;
  }
  
  public GLJournalInfoSynDS getGlJournalInfoSynImp()
  {
    return this.glJournalInfoSynImp;
  }
  
  public void setGlJournalInfoSynImp(GLJournalInfoSynDS paramGLJournalInfoSynDS)
  {
    this.glJournalInfoSynImp = paramGLJournalInfoSynDS;
  }
  
  public PaymentJournalInfoSynDS getPaymentJournalInfoSynImp()
  {
    return this.paymentJournalInfoSynImp;
  }
  
  public void setPaymentJournalInfoSynImp(PaymentJournalInfoSynDS paramPaymentJournalInfoSynDS)
  {
    this.paymentJournalInfoSynImp = paramPaymentJournalInfoSynDS;
  }
  
  public ReceiptJournalInfoSynDS getReceiptJournalInfoSynImp()
  {
    return this.receiptJournalInfoSynImp;
  }
  
  public void setReceiptJournalInfoSynImp(ReceiptJournalInfoSynDS paramReceiptJournalInfoSynDS)
  {
    this.receiptJournalInfoSynImp = paramReceiptJournalInfoSynDS;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.syn.VoucherSynImp
 * JD-Core Version:    0.7.0.1
 */