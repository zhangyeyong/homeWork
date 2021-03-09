package com.zte.evs.ebill.common.invoice.model;

import java.util.List;

public class InvoicePageContext
{
  private List<Invoice> invoice = null;
  private List<InvoiceLine> invoiceLine = null;
  private String modelUrl;
  private String filePath;
  private int totalPage = 0;
  private int totalCount = 0;
  private int curPage = 1;
  
  public int getTotalPage()
  {
    return this.totalPage;
  }
  
  public int getCurPage()
  {
    return this.curPage;
  }
  
  public void setCurPage(int paramInt)
  {
    this.curPage = paramInt;
  }
  
  public void setTotalPage(int paramInt)
  {
    this.totalPage = paramInt;
  }
  
  public int getTotalCount()
  {
    return this.totalCount;
  }
  
  public void setTotalCount(int paramInt)
  {
    this.totalCount = paramInt;
  }
  
  public List<Invoice> getInvoice()
  {
    return this.invoice;
  }
  
  public void setInvoice(List<Invoice> paramList)
  {
    this.invoice = paramList;
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
  
  public List<InvoiceLine> getInvoiceLine()
  {
    return this.invoiceLine;
  }
  
  public void setInvoiceLine(List<InvoiceLine> paramList)
  {
    this.invoiceLine = paramList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.invoice.model.InvoicePageContext
 * JD-Core Version:    0.7.0.1
 */