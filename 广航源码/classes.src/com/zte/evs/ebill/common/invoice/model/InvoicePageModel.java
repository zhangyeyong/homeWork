package com.zte.evs.ebill.common.invoice.model;

import java.util.HashMap;
import java.util.Map;

public class InvoicePageModel
{
  private Map<String, InvoiceModel> invoiceListModels = new HashMap();
  private Map<String, InvoiceModel> invoicePropertyModels = new HashMap();
  private InvoiceModel pageInvoiceModel = null;
  private String modelUrl;
  private String filePath;
  private int pageNum = 1;
  
  public Map<String, InvoiceModel> getInvoiceListModels()
  {
    return this.invoiceListModels;
  }
  
  public void setInvoiceListModels(Map<String, InvoiceModel> paramMap)
  {
    this.invoiceListModels = paramMap;
  }
  
  public Map<String, InvoiceModel> getInvoicePropertyModels()
  {
    return this.invoicePropertyModels;
  }
  
  public void setInvoicePropertyModels(Map<String, InvoiceModel> paramMap)
  {
    this.invoicePropertyModels = paramMap;
  }
  
  public InvoiceModel getPageInvoiceModel()
  {
    return this.pageInvoiceModel;
  }
  
  public void setPageInvoiceModel(InvoiceModel paramInvoiceModel)
  {
    this.pageInvoiceModel = paramInvoiceModel;
  }
  
  public int getPageNum()
  {
    return this.pageNum;
  }
  
  public void setPageNum(int paramInt)
  {
    this.pageNum = paramInt;
  }
  
  public String getModelUrl()
  {
    return this.modelUrl;
  }
  
  public void setModelUrl(String paramString)
  {
    this.modelUrl = paramString;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.invoice.model.InvoicePageModel
 * JD-Core Version:    0.7.0.1
 */