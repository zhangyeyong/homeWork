package com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="InquiryUsersInfoSrvOutputCollection", propOrder={"inquiryUsersInfoSrvOutputItem"})
public class InquiryUsersInfoSrvOutputCollection
{
  @XmlElement(name="InquiryUsersInfoSrvOutputItem", nillable=true)
  protected List<InquiryUsersInfoSrvOutputItem> inquiryUsersInfoSrvOutputItem;
  
  public List<InquiryUsersInfoSrvOutputItem> getInquiryUsersInfoSrvOutputItem()
  {
    if (this.inquiryUsersInfoSrvOutputItem == null) {
      this.inquiryUsersInfoSrvOutputItem = new ArrayList();
    }
    return this.inquiryUsersInfoSrvOutputItem;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv.InquiryUsersInfoSrvOutputCollection
 * JD-Core Version:    0.7.0.1
 */