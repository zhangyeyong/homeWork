package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.business.baseconfig.model.FasciculeTreeV;
import java.math.BigInteger;
import java.util.List;

public abstract interface IFasciculeTreeVDAO
{
  public abstract List findTree(BigInteger paramBigInteger);
  
  public abstract FasciculeTreeV findFasciculeTreeVById(String paramString);
  
  public abstract String findFasciculeTreeVByCheckunit(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IFasciculeTreeVDAO
 * JD-Core Version:    0.7.0.1
 */