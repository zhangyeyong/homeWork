package com.zte.eas.appframe.importmis.gl;

import java.io.Serializable;
import java.util.Calendar;

public class GL_ImportGLInvoiceSrvProcessRequest
  implements Serializable
{
  protected String invoiceId;
  protected Calendar invoicedate;
  
  public String getInvoiceId()
  {
    return this.invoiceId;
  }
  
  public void setInvoiceId(String paramString)
  {
    this.invoiceId = paramString;
  }
  
  public Calendar getInvoicedate()
  {
    return this.invoicedate;
  }
  
  public void setInvoicedate(Calendar paramCalendar)
  {
    this.invoicedate = paramCalendar;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.gl.GL_ImportGLInvoiceSrvProcessRequest
 * JD-Core Version:    0.7.0.1
 */