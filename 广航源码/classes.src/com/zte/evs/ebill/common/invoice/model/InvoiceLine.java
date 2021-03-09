package com.zte.evs.ebill.common.invoice.model;

public class InvoiceLine
{
  private int startX = 0;
  private int startY = 0;
  private int endX = 0;
  private int endY = 0;
  private int lineWidth = 1;
  
  public InvoiceLine() {}
  
  public InvoiceLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.startX = paramInt1;
    this.startY = paramInt2;
    this.endX = paramInt3;
    this.endY = paramInt4;
    this.lineWidth = paramInt5;
  }
  
  public int getStartX()
  {
    return this.startX;
  }
  
  public void setStartX(int paramInt)
  {
    this.startX = paramInt;
  }
  
  public int getStartY()
  {
    return this.startY;
  }
  
  public void setStartY(int paramInt)
  {
    this.startY = paramInt;
  }
  
  public int getEndX()
  {
    return this.endX;
  }
  
  public void setEndX(int paramInt)
  {
    this.endX = paramInt;
  }
  
  public int getEndY()
  {
    return this.endY;
  }
  
  public void setEndY(int paramInt)
  {
    this.endY = paramInt;
  }
  
  public int getLineWidth()
  {
    return this.lineWidth;
  }
  
  public void setLineWidth(int paramInt)
  {
    this.lineWidth = paramInt;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.invoice.model.InvoiceLine
 * JD-Core Version:    0.7.0.1
 */