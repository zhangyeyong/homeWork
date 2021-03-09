package com.zte.eas.appframe.importmis.arv.types.com.zte.eas.arimport.fiarimportartransactionsrv;

import java.io.Serializable;
import java.util.Calendar;

public class FiArImportARTransactionSrvRequest
  implements Serializable
{
  protected String boeHeaders;
  protected Calendar importDate;
  
  public String getBoeHeaders()
  {
    return this.boeHeaders;
  }
  
  public void setBoeHeaders(String paramString)
  {
    this.boeHeaders = paramString;
  }
  
  public Calendar getImportDate()
  {
    return this.importDate;
  }
  
  public void setImportDate(Calendar paramCalendar)
  {
    this.importDate = paramCalendar;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.arv.types.com.zte.eas.arimport.fiarimportartransactionsrv.FiArImportARTransactionSrvRequest
 * JD-Core Version:    0.7.0.1
 */