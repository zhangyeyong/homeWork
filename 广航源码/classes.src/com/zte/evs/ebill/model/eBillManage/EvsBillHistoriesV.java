package com.zte.evs.ebill.model.eBillManage;

import java.util.Date;

public class EvsBillHistoriesV
{
  private Long wfHistroiesId;
  private Long boeHeaderId;
  private String operateEmployeeName;
  private Date creationDate;
  private String approveCommand;
  private String approvePositionName;
  
  public Long getWfHistroiesId()
  {
    return this.wfHistroiesId;
  }
  
  public void setWfHistroiesId(Long paramLong)
  {
    this.wfHistroiesId = paramLong;
  }
  
  public String getOperateEmployeeName()
  {
    return this.operateEmployeeName;
  }
  
  public void setOperateEmployeeName(String paramString)
  {
    this.operateEmployeeName = paramString;
  }
  
  public Date getCreationDate()
  {
    return this.creationDate;
  }
  
  public void setCreationDate(Date paramDate)
  {
    this.creationDate = paramDate;
  }
  
  public String getApproveCommand()
  {
    return this.approveCommand;
  }
  
  public void setApproveCommand(String paramString)
  {
    this.approveCommand = paramString;
  }
  
  public String getApprovePositionName()
  {
    return this.approvePositionName;
  }
  
  public void setApprovePositionName(String paramString)
  {
    this.approvePositionName = paramString;
  }
  
  public Long getBoeHeaderId()
  {
    return this.boeHeaderId;
  }
  
  public void setBoeHeaderId(Long paramLong)
  {
    this.boeHeaderId = paramLong;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.model.eBillManage.EvsBillHistoriesV
 * JD-Core Version:    0.7.0.1
 */