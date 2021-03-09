package com.zte.eimage.business.baseconfig.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EidImageMemoV
  extends BaseObject
  implements Serializable
{
  protected Long imageInfoId;
  protected String imageNumber;
  protected String memo;
  protected String taskDesc;
  
  public EidImageMemoV() {}
  
  public EidImageMemoV(Long paramLong, String paramString1, String paramString2, String paramString3)
  {
    setImageInfoId(paramLong);
    setImageNumber(paramString1);
    setMemo(paramString2);
    setTaskDesc(paramString3);
  }
  
  public Long getImageInfoId()
  {
    return this.imageInfoId;
  }
  
  public void setImageInfoId(Long paramLong)
  {
    this.imageInfoId = paramLong;
  }
  
  public String getImageNumber()
  {
    return this.imageNumber;
  }
  
  public void setImageNumber(String paramString)
  {
    this.imageNumber = paramString;
  }
  
  public String getMemo()
  {
    return this.memo;
  }
  
  public void setMemo(String paramString)
  {
    this.memo = paramString;
  }
  
  public String getTaskDesc()
  {
    return this.taskDesc;
  }
  
  public void setTaskDesc(String paramString)
  {
    this.taskDesc = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EidImageMemoV)) {
      return false;
    }
    EidImageMemoV localEidImageMemoV = (EidImageMemoV)paramObject;
    return new EqualsBuilder().append(this.imageInfoId, localEidImageMemoV.imageInfoId).append(this.imageNumber, localEidImageMemoV.imageNumber).append(this.memo, localEidImageMemoV.memo).append(this.taskDesc, localEidImageMemoV.taskDesc).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.imageInfoId).append(this.imageNumber).append(this.memo).append(this.taskDesc).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("imageInfoId", this.imageInfoId).append("imageNumber", this.imageNumber).append("memo", this.memo).append("taskDesc", this.taskDesc).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.model.EidImageMemoV
 * JD-Core Version:    0.7.0.1
 */