package com.zte.esb.bean.foss;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SyncDistrictRequest", propOrder={"districtInfo"})
public class SyncDistrictRequest
{
  @XmlElement(name="DistrictInfo", required=true)
  protected List<DistrictInfo> districtInfo;
  
  public List<DistrictInfo> getDistrictInfo()
  {
    if (this.districtInfo == null) {
      this.districtInfo = new ArrayList();
    }
    return this.districtInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.foss.SyncDistrictRequest
 * JD-Core Version:    0.7.0.1
 */