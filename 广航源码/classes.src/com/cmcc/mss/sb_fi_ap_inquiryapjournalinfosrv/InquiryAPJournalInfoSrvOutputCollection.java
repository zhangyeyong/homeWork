package com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="InquiryAPJournalInfoSrvOutputCollection", propOrder={"inquiryAPJournalInfoSrvOutputItem"})
public class InquiryAPJournalInfoSrvOutputCollection
{
  @XmlElement(name="InquiryAPJournalInfoSrvOutputItem", nillable=true)
  protected List<InquiryAPJournalInfoSrvOutputItem> inquiryAPJournalInfoSrvOutputItem;
  
  public List<InquiryAPJournalInfoSrvOutputItem> getInquiryAPJournalInfoSrvOutputItem()
  {
    if (this.inquiryAPJournalInfoSrvOutputItem == null) {
      this.inquiryAPJournalInfoSrvOutputItem = new ArrayList();
    }
    return this.inquiryAPJournalInfoSrvOutputItem;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ap_inquiryapjournalinfosrv.InquiryAPJournalInfoSrvOutputCollection
 * JD-Core Version:    0.7.0.1
 */