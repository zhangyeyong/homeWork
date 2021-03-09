package com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="PageInquiryGLJournalInfoSrvOutputCollection", propOrder={"pageInquiryGLJournalInfoSrvOutputItem"})
public class PageInquiryGLJournalInfoSrvOutputCollection
{
  @XmlElement(name="PageInquiryGLJournalInfoSrvOutputItem", nillable=true)
  protected List<PageInquiryGLJournalInfoSrvOutputItem> pageInquiryGLJournalInfoSrvOutputItem;
  
  public List<PageInquiryGLJournalInfoSrvOutputItem> getPageInquiryGLJournalInfoSrvOutputItem()
  {
    if (this.pageInquiryGLJournalInfoSrvOutputItem == null) {
      this.pageInquiryGLJournalInfoSrvOutputItem = new ArrayList();
    }
    return this.pageInquiryGLJournalInfoSrvOutputItem;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_fi_gl_pageinquirygljournalinfosrv.PageInquiryGLJournalInfoSrvOutputCollection
 * JD-Core Version:    0.7.0.1
 */