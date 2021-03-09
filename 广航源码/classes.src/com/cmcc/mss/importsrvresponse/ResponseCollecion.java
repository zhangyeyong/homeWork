package com.cmcc.mss.importsrvresponse;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ResponseCollecion", propOrder={"responseItem"})
public class ResponseCollecion
{
  @XmlElement(name="ResponseItem", nillable=true)
  protected List<ResponseItem> responseItem;
  
  public List<ResponseItem> getResponseItem()
  {
    if (this.responseItem == null) {
      this.responseItem = new ArrayList();
    }
    return this.responseItem;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.importsrvresponse.ResponseCollecion
 * JD-Core Version:    0.7.0.1
 */