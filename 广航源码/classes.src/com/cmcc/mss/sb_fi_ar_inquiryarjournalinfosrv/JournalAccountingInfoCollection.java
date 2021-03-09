package com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="JournalAccountingInfoCollection", propOrder={"journalaccountinginfoitem"})
public class JournalAccountingInfoCollection
{
  @XmlElement(name="JOURNAL_ACCOUNTING_INFO_ITEM")
  protected List<JournalAccountingInfoItem> journalaccountinginfoitem;
  
  public List<JournalAccountingInfoItem> getJOURNALACCOUNTINGINFOITEM()
  {
    if (this.journalaccountinginfoitem == null) {
      this.journalaccountinginfoitem = new ArrayList();
    }
    return this.journalaccountinginfoitem;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_ar_inquiryarjournalinfosrv.JournalAccountingInfoCollection
 * JD-Core Version:    0.7.0.1
 */