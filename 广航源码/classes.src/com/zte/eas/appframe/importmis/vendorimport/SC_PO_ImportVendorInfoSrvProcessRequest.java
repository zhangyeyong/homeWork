package com.zte.eas.appframe.importmis.vendorimport;

import java.io.Serializable;

public class SC_PO_ImportVendorInfoSrvProcessRequest
  implements Serializable
{
  protected String boeLineId;
  
  public String getBoeLineId()
  {
    return this.boeLineId;
  }
  
  public void setBoeLineId(String paramString)
  {
    this.boeLineId = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.vendorimport.SC_PO_ImportVendorInfoSrvProcessRequest
 * JD-Core Version:    0.7.0.1
 */