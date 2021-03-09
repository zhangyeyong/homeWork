package com.zte.eas.organization.user.syn.model.dao;

import com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv.InquiryUsersInfoSrvOutputItem;
import java.util.List;

public abstract interface IUserSynDao
{
  public abstract void synUser(List<InquiryUsersInfoSrvOutputItem> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.user.syn.model.dao.IUserSynDao
 * JD-Core Version:    0.7.0.1
 */