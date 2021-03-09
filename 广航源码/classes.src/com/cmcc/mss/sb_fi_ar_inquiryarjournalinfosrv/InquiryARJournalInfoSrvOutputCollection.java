package com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="InquiryARJournalInfoSrvOutputCollection", propOrder={"inquiryARJournalInfoSrvOutputItem"})
public class InquiryARJournalInfoSrvOutputCollection
{
  @XmlElement(name="InquiryARJournalInfoSrvOutputItem", nillable=true)
  protected List<InquiryARJournalInfoSrvOutputItem> inquiryARJournalInfoSrvOutputItem;
  
  public List<InquiryARJournalInfoSrvOutputItem> getInquiryARJournalInfoSrvOutputItem()
  {
    if (this.inquiryARJournalInfoSrvOutputItem == null) {
      this.inquiryARJournalInfoSrvOutputItem = new ArrayList();
    }
    return this.inquiryARJournalInfoSrvOutputItem;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.InquiryARJournalInfoSrvOutputCollection
 * JD-Core Version:    0.7.0.1
 */