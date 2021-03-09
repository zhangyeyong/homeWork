package com.cmcc.mss.sb_eas_eas_inquiryorginfosrv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="InquiryORGInfoSrvOutputCollection", propOrder={"inquiryORGInfoSrvOutputItem"})
public class InquiryORGInfoSrvOutputCollection
{
  @XmlElement(name="InquiryORGInfoSrvOutputItem", nillable=true)
  protected List<InquiryORGInfoSrvOutputItem> inquiryORGInfoSrvOutputItem;
  
  public List<InquiryORGInfoSrvOutputItem> getInquiryORGInfoSrvOutputItem()
  {
    if (this.inquiryORGInfoSrvOutputItem == null) {
      this.inquiryORGInfoSrvOutputItem = new ArrayList();
    }
    return this.inquiryORGInfoSrvOutputItem;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_inquiryorginfosrv.InquiryORGInfoSrvOutputCollection
 * JD-Core Version:    0.7.0.1
 */