package com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SB_EAS_EAS_InquiryUsersInfoSrvResponse", propOrder={"serviceflag", "servicemessage", "instanceid", "inquiryUsersInfoSrvOutputCollection"})
public class SBEASEASInquiryUsersInfoSrvResponse
{
  @XmlElement(name="SERVICE_FLAG", required=true, nillable=true)
  protected String serviceflag;
  @XmlElement(name="SERVICE_MESSAGE", required=true, nillable=true)
  protected String servicemessage;
  @XmlElement(name="INSTANCE_ID", required=true, nillable=true)
  protected String instanceid;
  @XmlElement(name="InquiryUsersInfoSrvOutputCollection", required=true, nillable=true)
  protected InquiryUsersInfoSrvOutputCollection inquiryUsersInfoSrvOutputCollection;
  
  public String getSERVICEFLAG()
  {
    return this.serviceflag;
  }
  
  public void setSERVICEFLAG(String paramString)
  {
    this.serviceflag = paramString;
  }
  
  public String getSERVICEMESSAGE()
  {
    return this.servicemessage;
  }
  
  public void setSERVICEMESSAGE(String paramString)
  {
    this.servicemessage = paramString;
  }
  
  public String getINSTANCEID()
  {
    return this.instanceid;
  }
  
  public void setINSTANCEID(String paramString)
  {
    this.instanceid = paramString;
  }
  
  public InquiryUsersInfoSrvOutputCollection getInquiryUsersInfoSrvOutputCollection()
  {
    return this.inquiryUsersInfoSrvOutputCollection;
  }
  
  public void setInquiryUsersInfoSrvOutputCollection(InquiryUsersInfoSrvOutputCollection paramInquiryUsersInfoSrvOutputCollection)
  {
    this.inquiryUsersInfoSrvOutputCollection = paramInquiryUsersInfoSrvOutputCollection;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv.SBEASEASInquiryUsersInfoSrvResponse
 * JD-Core Version:    0.7.0.1
 */