package com.zte.esb.util.header;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="StatusList", propOrder={"statusInfo"})
public class StatusList
{
  protected List<StatusInfo> statusInfo;
  
  public List<StatusInfo> getStatusInfo()
  {
    if (this.statusInfo == null) {
      this.statusInfo = new ArrayList();
    }
    return this.statusInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.header.StatusList
 * JD-Core Version:    0.7.0.1
 */