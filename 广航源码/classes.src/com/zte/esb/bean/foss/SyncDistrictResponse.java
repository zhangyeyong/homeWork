package com.zte.esb.bean.foss;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SyncDistrictResponse", propOrder={"failInfos"})
@XmlRootElement
public class SyncDistrictResponse
{
  @XmlElement(required=true)
  protected List<FailInfo> failInfos;
  
  public void setFailInfos(List<FailInfo> paramList)
  {
    this.failInfos = paramList;
  }
  
  public List<FailInfo> getFailInfos()
  {
    if (this.failInfos == null) {
      this.failInfos = new ArrayList();
    }
    return this.failInfos;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.foss.SyncDistrictResponse
 * JD-Core Version:    0.7.0.1
 */