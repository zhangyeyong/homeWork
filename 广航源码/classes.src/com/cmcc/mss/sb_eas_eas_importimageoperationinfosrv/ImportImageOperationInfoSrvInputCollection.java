package com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ImportImageOperationInfoSrvInputCollection", propOrder={"importImageOperationInfoSrvInputItem"})
public class ImportImageOperationInfoSrvInputCollection
{
  @XmlElement(name="ImportImageOperationInfoSrvInputItem", nillable=true)
  protected List<ImportImageOperationInfoSrvInputItem> importImageOperationInfoSrvInputItem;
  
  public List<ImportImageOperationInfoSrvInputItem> getImportImageOperationInfoSrvInputItem()
  {
    if (this.importImageOperationInfoSrvInputItem == null) {
      this.importImageOperationInfoSrvInputItem = new ArrayList();
    }
    return this.importImageOperationInfoSrvInputItem;
  }
  
  public void setImportImageOperationInfoSrvInputItem(List<ImportImageOperationInfoSrvInputItem> paramList)
  {
    this.importImageOperationInfoSrvInputItem = paramList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv.ImportImageOperationInfoSrvInputCollection
 * JD-Core Version:    0.7.0.1
 */