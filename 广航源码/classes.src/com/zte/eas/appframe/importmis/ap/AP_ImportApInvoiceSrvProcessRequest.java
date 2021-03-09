package com.zte.eas.appframe.importmis.ap;

import java.io.Serializable;
import java.util.Calendar;

public class AP_ImportApInvoiceSrvProcessRequest
  implements Serializable
{
  protected String boeHeaderId;
  protected Calendar invoiceData;
  
  public String getBoeHeaderId()
  {
    return this.boeHeaderId;
  }
  
  public void setBoeHeaderId(String paramString)
  {
    this.boeHeaderId = paramString;
  }
  
  public Calendar getInvoiceData()
  {
    return this.invoiceData;
  }
  
  public void setInvoiceData(Calendar paramCalendar)
  {
    this.invoiceData = paramCalendar;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.ap.AP_ImportApInvoiceSrvProcessRequest
 * JD-Core Version:    0.7.0.1
 */