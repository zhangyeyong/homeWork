package com.zte.web.service.proxy.syn;

import java.util.Calendar;

public abstract interface GLJournalInfoSynDS
{
  public abstract void qry()
    throws Exception;
  
  public abstract boolean qry(String paramString, Calendar paramCalendar1, Calendar paramCalendar2)
    throws Exception;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.proxy.syn.GLJournalInfoSynDS
 * JD-Core Version:    0.7.0.1
 */