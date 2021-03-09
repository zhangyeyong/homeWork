package com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv;

import com.cmcc.mss.msgheader.MsgHeader;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SB_EAS_EAS_ImportImageOperationInfoSrvRequest", propOrder={"msgHeader", "importImageOperationInfoSrvInputCollection"})
public class SBEASEASImportImageOperationInfoSrvRequest
{
  @XmlElement(name="MsgHeader", required=true, nillable=true)
  protected MsgHeader msgHeader;
  @XmlElement(name="ImportImageOperationInfoSrvInputCollection", required=true, nillable=true)
  protected ImportImageOperationInfoSrvInputCollection importImageOperationInfoSrvInputCollection;
  
  public MsgHeader getMsgHeader()
  {
    return this.msgHeader;
  }
  
  public void setMsgHeader(MsgHeader paramMsgHeader)
  {
    this.msgHeader = paramMsgHeader;
  }
  
  public ImportImageOperationInfoSrvInputCollection getImportImageOperationInfoSrvInputCollection()
  {
    return this.importImageOperationInfoSrvInputCollection;
  }
  
  public void setImportImageOperationInfoSrvInputCollection(ImportImageOperationInfoSrvInputCollection paramImportImageOperationInfoSrvInputCollection)
  {
    this.importImageOperationInfoSrvInputCollection = paramImportImageOperationInfoSrvInputCollection;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv.SBEASEASImportImageOperationInfoSrvRequest
 * JD-Core Version:    0.7.0.1
 */