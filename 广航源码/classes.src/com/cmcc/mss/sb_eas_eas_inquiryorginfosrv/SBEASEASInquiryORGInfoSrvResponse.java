package com.cmcc.mss.sb_eas_eas_inquiryorginfosrv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SB_EAS_EAS_InquiryORGInfoSrvResponse", propOrder={"serviceflag", "servicemessage", "instanceid", "inquiryORGInfoSrvOutputCollection"})
public class SBEASEASInquiryORGInfoSrvResponse
{
  @XmlElement(name="SERVICE_FLAG", required=true, nillable=true)
  protected String serviceflag;
  @XmlElement(name="SERVICE_MESSAGE", required=true, nillable=true)
  protected String servicemessage;
  @XmlElement(name="INSTANCE_ID", required=true, nillable=true)
  protected String instanceid;
  @XmlElement(name="InquiryORGInfoSrvOutputCollection", required=true, nillable=true)
  protected InquiryORGInfoSrvOutputCollection inquiryORGInfoSrvOutputCollection;
  
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
  
  public InquiryORGInfoSrvOutputCollection getInquiryORGInfoSrvOutputCollection()
  {
    return this.inquiryORGInfoSrvOutputCollection;
  }
  
  public void setInquiryORGInfoSrvOutputCollection(InquiryORGInfoSrvOutputCollection paramInquiryORGInfoSrvOutputCollection)
  {
    this.inquiryORGInfoSrvOutputCollection = paramInquiryORGInfoSrvOutputCollection;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_inquiryorginfosrv.SBEASEASInquiryORGInfoSrvResponse
 * JD-Core Version:    0.7.0.1
 */