package com.zte.esb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SendPositionRequest", propOrder={"positionInfo"})
public class SendPositionRequest
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected List<PositionInfo> positionInfo;
  
  public List<PositionInfo> getPositionInfo()
  {
    if (this.positionInfo == null) {
      this.positionInfo = new ArrayList();
    }
    return this.positionInfo;
  }
  
  public void setPositionInfo(List<PositionInfo> paramList)
  {
    this.positionInfo = paramList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.SendPositionRequest
 * JD-Core Version:    0.7.0.1
 */