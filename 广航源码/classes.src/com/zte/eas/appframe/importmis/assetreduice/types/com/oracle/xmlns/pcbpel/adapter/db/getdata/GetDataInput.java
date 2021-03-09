package com.zte.eas.appframe.importmis.assetreduice.types.com.oracle.xmlns.pcbpel.adapter.db.getdata;

import java.io.Serializable;

public class GetDataInput
  implements Serializable
{
  protected String employeeNumber;
  protected String priKeys;
  
  public String getEmployeeNumber()
  {
    return this.employeeNumber;
  }
  
  public void setEmployeeNumber(String paramString)
  {
    this.employeeNumber = paramString;
  }
  
  public String getPriKeys()
  {
    return this.priKeys;
  }
  
  public void setPriKeys(String paramString)
  {
    this.priKeys = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetreduice.types.com.oracle.xmlns.pcbpel.adapter.db.getdata.GetDataInput
 * JD-Core Version:    0.7.0.1
 */