package com.zte.eas.appframe.importmis.assetadd.types.com.oracle.xmlns.pcbpel.adapter.db.getdata;

import java.io.Serializable;

public class GetDataOutputCollection
  implements Serializable
{
  protected GetDataOutput[] getDataOutput;
  
  public GetDataOutput[] getGetDataOutput()
  {
    return this.getDataOutput;
  }
  
  public void setGetDataOutput(GetDataOutput[] paramArrayOfGetDataOutput)
  {
    this.getDataOutput = paramArrayOfGetDataOutput;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetadd.types.com.oracle.xmlns.pcbpel.adapter.db.getdata.GetDataOutputCollection
 * JD-Core Version:    0.7.0.1
 */