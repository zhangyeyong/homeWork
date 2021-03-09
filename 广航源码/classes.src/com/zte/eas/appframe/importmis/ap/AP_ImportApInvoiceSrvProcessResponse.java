package com.zte.eas.appframe.importmis.ap;

import java.io.Serializable;

public class AP_ImportApInvoiceSrvProcessResponse
  implements Serializable
{
  protected String errorFlag;
  protected String errorMessage;
  
  public String getErrorFlag()
  {
    return this.errorFlag;
  }
  
  public void setErrorFlag(String paramString)
  {
    this.errorFlag = paramString;
  }
  
  public String getErrorMessage()
  {
    return this.errorMessage;
  }
  
  public void setErrorMessage(String paramString)
  {
    this.errorMessage = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.ap.AP_ImportApInvoiceSrvProcessResponse
 * JD-Core Version:    0.7.0.1
 */