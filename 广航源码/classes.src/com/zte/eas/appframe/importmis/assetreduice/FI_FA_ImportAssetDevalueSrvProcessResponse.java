package com.zte.eas.appframe.importmis.assetreduice;

import java.io.Serializable;

public class FI_FA_ImportAssetDevalueSrvProcessResponse
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
 * Qualified Name:     com.zte.eas.appframe.importmis.assetreduice.FI_FA_ImportAssetDevalueSrvProcessResponse
 * JD-Core Version:    0.7.0.1
 */