package com.zte.esb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SendDegreeRequest", propOrder={"degreeInfo"})
public class SendDegreeRequest
  implements Serializable
{
  private static final long serialVersionUID = 11082011L;
  @XmlElement(required=true)
  protected List<DegreeInfo> degreeInfo;
  
  public List<DegreeInfo> getDegreeInfo()
  {
    if (this.degreeInfo == null) {
      this.degreeInfo = new ArrayList();
    }
    return this.degreeInfo;
  }
  
  public void setDegreeInfo(List<DegreeInfo> paramList)
  {
    this.degreeInfo = paramList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.SendDegreeRequest
 * JD-Core Version:    0.7.0.1
 */