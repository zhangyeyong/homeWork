package com.zte.evs.ebill.model.eBillManage;

public class EvsImageV
{
  private String barcode;
  private String barname;
  private String companyCode;
  
  public String getCompanyCode()
  {
    return this.companyCode;
  }
  
  public void setCompanyCode(String paramString)
  {
    this.companyCode = paramString;
  }
  
  public EvsImageV() {}
  
  public EvsImageV(String paramString1, String paramString2)
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
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsImageV
 * JD-Core Version:    0.7.0.1
 */