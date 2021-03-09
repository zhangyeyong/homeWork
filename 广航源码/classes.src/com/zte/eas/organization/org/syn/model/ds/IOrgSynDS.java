package com.zte.eas.organization.org.syn.model.ds;

import com.cmcc.mss.sb_eas_eas_inquiryorginfosrv.SBEASEASInquiryORGInfoSrvRequest;
import com.cmcc.mss.sb_eas_eas_inquiryorginfosrv.SBEASEASInquiryORGInfoSrvResponse;

public abstract interface IOrgSynDS
{
  public abstract SBEASEASInquiryORGInfoSrvResponse findOrg(SBEASEASInquiryORGInfoSrvRequest paramSBEASEASInquiryORGInfoSrvRequest);
  
  public abstract void doSynchHRDeptsInfo(String paramString)
    throws Exception;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.org.syn.model.ds.IOrgSynDS
 * JD-Core Version:    0.7.0.1
 */