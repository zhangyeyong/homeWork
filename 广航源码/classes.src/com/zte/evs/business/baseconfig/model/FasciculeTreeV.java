package com.zte.evs.business.baseconfig.model;

import com.zte.ssb.framework.base.BaseObject;
import java.io.Serializable;
import java.math.BigInteger;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FasciculeTreeV
  extends BaseObject
  implements Serializable
{
  protected BigInteger ttid;
  protected String checkunit;
  protected String checkunitname;
  protected BigInteger yea;
  protected String yearname;
  protected String mon;
  protected String monthname;
  protected BigInteger parentId;
  protected BigInteger nodeLevel;
  protected BigInteger childrenCount;
  
  public FasciculeTreeV() {}
  
  public FasciculeTreeV(BigInteger paramBigInteger1, String paramString1, String paramString2, BigInteger paramBigInteger2, String paramString3, String paramString4, String paramString5, BigInteger paramBigInteger3, BigInteger paramBigInteger4, BigInteger paramBigInteger5)
  {
    setTtid(paramBigInteger1);
    setCheckunit(paramString1);
    setCheckunitname(paramString2);
    setYea(paramBigInteger2);
    setYearname(paramString3);
    setMon(paramString4);
    setMonthname(paramString5);
    setParentId(paramBigInteger3);
    setNodeLevel(paramBigInteger4);
    setChildrenCount(paramBigInteger5);
  }
  
  public BigInteger getTtid()
  {
    return this.ttid;
  }
  
  public void setTtid(BigInteger paramBigInteger)
  {
    this.ttid = paramBigInteger;
  }
  
  public String getCheckunit()
  {
    return this.checkunit;
  }
  
  public void setCheckunit(String paramString)
  {
    this.checkunit = paramString;
  }
  
  public String getCheckunitname()
  {
    return this.checkunitname;
  }
  
  public void setCheckunitname(String paramString)
  {
    this.checkunitname = paramString;
  }
  
  public BigInteger getYea()
  {
    return this.yea;
  }
  
  public void setYea(BigInteger paramBigInteger)
  {
    this.yea = paramBigInteger;
  }
  
  public String getYearname()
  {
    return this.yearname;
  }
  
  public void setYearname(String paramString)
  {
    this.yearname = paramString;
  }
  
  public String getMon()
  {
    return this.mon;
  }
  
  public void setMon(String paramString)
  {
    this.mon = paramString;
  }
  
  public String getMonthname()
  {
    return this.monthname;
  }
  
  public void setMonthname(String paramString)
  {
    this.monthname = paramString;
  }
  
  public BigInteger getParentId()
  {
    return this.parentId;
  }
  
  public void setParentId(BigInteger paramBigInteger)
  {
    this.parentId = paramBigInteger;
  }
  
  public BigInteger getNodeLevel()
  {
    return this.nodeLevel;
  }
  
  public void setNodeLevel(BigInteger paramBigInteger)
  {
    this.nodeLevel = paramBigInteger;
  }
  
  public BigInteger getChildrenCount()
  {
    return this.childrenCount;
  }
  
  public void setChildrenCount(BigInteger paramBigInteger)
  {
    this.childrenCount = paramBigInteger;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FasciculeTreeV)) {
      return false;
    }
    FasciculeTreeV localFasciculeTreeV = (FasciculeTreeV)paramObject;
    return new EqualsBuilder().append(this.ttid, localFasciculeTreeV.ttid).append(this.checkunit, localFasciculeTreeV.checkunit).append(this.checkunitname, localFasciculeTreeV.checkunitname).append(this.yea, localFasciculeTreeV.yea).append(this.yearname, localFasciculeTreeV.yearname).append(this.mon, localFasciculeTreeV.mon).append(this.monthname, localFasciculeTreeV.monthname).append(this.parentId, localFasciculeTreeV.parentId).append(this.nodeLevel, localFasciculeTreeV.nodeLevel).append(this.childrenCount, localFasciculeTreeV.childrenCount).isEquals();
  }
  
  public int hashCode()
  {
    return new HashCodeBuilder(-82280557, -700257973).append(this.ttid).append(this.checkunit).append(this.checkunitname).append(this.yea).append(this.yearname).append(this.mon).append(this.monthname).append(this.parentId).append(this.nodeLevel).append(this.childrenCount).toHashCode();
  }
  
  public String toString()
  {
    return new ToStringBuilder(this).append("ttid", this.ttid).append("checkunit", this.checkunit).append("checkunitname", this.checkunitname).append("yea", this.yea).append("yearname", this.yearname).append("mon", this.mon).append("monthname", this.monthname).append("parentId", this.parentId).append("nodeLevel", this.nodeLevel).append("childrenCount", this.childrenCount).toString();
  }
  
  public String getFirstKeyColumnName()
  {
    return "";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.business.baseconfig.model.FasciculeTreeV
 * JD-Core Version:    0.7.0.1
 */