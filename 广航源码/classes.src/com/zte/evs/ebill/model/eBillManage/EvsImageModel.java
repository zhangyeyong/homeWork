package com.zte.evs.ebill.model.eBillManage;

public class EvsImageModel
{
  private String barcode;
  private String barname;
  private String companyCode;
  private String imageNumber;
  private Long voucherId;
  private String num;
  private String selected;
  
  public String getSelected()
  {
    return this.selected;
  }
  
  public void setSelected(String paramString)
  {
    this.selected = paramString;
  }
  
  public String getNum()
  {
    return this.num;
  }
  
  public void setNum(String paramString)
  {
    this.num = paramString;
  }
  
  public String getImageNumber()
  {
    return this.imageNumber;
  }
  
  public void setImageNumber(String paramString)
  {
    this.imageNumber = paramString;
  }
  
  public Long getVoucherId()
  {
    return this.voucherId;
  }
  
  public void setVoucherId(Long paramLong)
  {
    this.voucherId = paramLong;
  }
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public EvsImageModel() {}
  
  public EvsImageModel(String paramString1, String paramString2)
  {
    this.barcode = paramString1;
    this.barname = paramString2;
  }
  
  public String getBarcode()
  {
    return this.barcode;
  }
  
  public void setBarcode(String paramString)
  {
    this.barcode = paramString;
  }
  
  public String getBarname()
  {
    return this.barname;
  }
  
  public void setBarname(String paramString)
  {
    this.barname = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsImageModel
 * JD-Core Version:    0.7.0.1
 */