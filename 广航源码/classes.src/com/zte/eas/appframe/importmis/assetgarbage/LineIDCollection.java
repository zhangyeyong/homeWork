package com.zte.eas.appframe.importmis.assetgarbage;

import java.io.Serializable;

public class LineIDCollection
  implements Serializable
{
  protected LineIDItem[] lineIDItem;
  
  public LineIDItem[] getLineIDItem()
  {
    return this.lineIDItem;
  }
  
  public void setLineIDItem(LineIDItem[] paramArrayOfLineIDItem)
  {
    this.lineIDItem = paramArrayOfLineIDItem;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetgarbage.LineIDCollection
 * JD-Core Version:    0.7.0.1
 */