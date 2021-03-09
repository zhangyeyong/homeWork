package com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="InquiryReceiptJournalInfoSrvOutputCollection", propOrder={"inquiryReceiptJournalInfoSrvOutputItem"})
public class InquiryReceiptJournalInfoSrvOutputCollection
{
  @XmlElement(name="InquiryReceiptJournalInfoSrvOutputItem", nillable=true)
  protected List<InquiryReceiptJournalInfoSrvOutputItem> inquiryReceiptJournalInfoSrvOutputItem;
  
  public List<InquiryReceiptJournalInfoSrvOutputItem> getInquiryReceiptJournalInfoSrvOutputItem()
  {
    if (this.inquiryReceiptJournalInfoSrvOutputItem == null) {
      this.inquiryReceiptJournalInfoSrvOutputItem = new ArrayList();
    }
    return this.inquiryReceiptJournalInfoSrvOutputItem;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ar_inquiryreceiptjournalinfosrv.InquiryReceiptJournalInfoSrvOutputCollection
 * JD-Core Version:    0.7.0.1
 */