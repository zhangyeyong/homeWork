package com.zte.eas.appframe.importmis.assetreduice;

import java.io.Serializable;

public class FI_FA_ImportAssetDevalueSrvProcessRequest
  implements Serializable
{
  protected LineIDCollection lineIds;
  protected String employeeNumber;
  
  public LineIDCollection getLineIds()
  {
    return this.lineIds;
  }
  
  public void setLineIds(LineIDCollection paramLineIDCollection)
  {
    this.lineIds = paramLineIDCollection;
  }
  
  public String getEmployeeNumber()
  {
    return this.employeeNumber;
  }
  
  public void setEmployeeNumber(String paramString)
  {
    this.employeeNumber = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetreduice.FI_FA_ImportAssetDevalueSrvProcessRequest
 * JD-Core Version:    0.7.0.1
 */