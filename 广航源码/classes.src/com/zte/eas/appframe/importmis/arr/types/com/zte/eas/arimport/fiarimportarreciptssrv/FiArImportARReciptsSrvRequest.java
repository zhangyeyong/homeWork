package com.zte.eas.appframe.importmis.arr.types.com.zte.eas.arimport.fiarimportarreciptssrv;

import java.io.Serializable;
import java.util.Calendar;

public class FiArImportARReciptsSrvRequest
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
 * Qualified Name:     com.zte.eas.appframe.importmis.arr.types.com.zte.eas.arimport.fiarimportarreciptssrv.FiArImportARReciptsSrvRequest
 * JD-Core Version:    0.7.0.1
 */