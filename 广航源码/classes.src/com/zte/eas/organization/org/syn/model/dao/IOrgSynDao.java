package com.zte.eas.organization.org.syn.model.dao;

import com.cmcc.mss.sb_eas_eas_inquiryorginfosrv.InquiryORGInfoSrvOutputItem;
import java.util.List;

public abstract interface IOrgSynDao
{
  public abstract boolean findOrg(List<InquiryORGInfoSrvOutputItem> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.org.syn.model.dao.IOrgSynDao
 * JD-Core Version:    0.7.0.1
 */