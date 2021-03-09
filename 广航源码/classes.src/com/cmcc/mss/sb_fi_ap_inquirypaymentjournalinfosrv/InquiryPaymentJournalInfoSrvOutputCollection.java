package com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="InquiryPaymentJournalInfoSrvOutputCollection", propOrder={"inquiryPaymentJournalInfoSrvOutputItem"})
public class InquiryPaymentJournalInfoSrvOutputCollection
{
  @XmlElement(name="InquiryPaymentJournalInfoSrvOutputItem", nillable=true)
  protected List<InquiryPaymentJournalInfoSrvOutputItem> inquiryPaymentJournalInfoSrvOutputItem;
  
  public List<InquiryPaymentJournalInfoSrvOutputItem> getInquiryPaymentJournalInfoSrvOutputItem()
  {
    if (this.inquiryPaymentJournalInfoSrvOutputItem == null) {
      this.inquiryPaymentJournalInfoSrvOutputItem = new ArrayList();
    }
    return this.inquiryPaymentJournalInfoSrvOutputItem;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ap_inquirypaymentjournalinfosrv.InquiryPaymentJournalInfoSrvOutputCollection
 * JD-Core Version:    0.7.0.1
 */