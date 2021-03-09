package com.zte.web.service.proxy.syn;

import java.util.Calendar;

public abstract interface PaymentJournalInfoSynDS
{
  public abstract void qry()
    throws Throwable;
  
  public abstract boolean qry(String paramString, Calendar paramCalendar1, Calendar paramCalendar2)
    throws Throwable;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.syn.PaymentJournalInfoSynDS
 * JD-Core Version:    0.7.0.1
 */