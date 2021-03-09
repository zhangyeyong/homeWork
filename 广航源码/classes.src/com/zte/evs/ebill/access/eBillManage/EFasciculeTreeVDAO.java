package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.business.baseconfig.model.FasciculeTreeV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.util.List;

public class EFasciculeTreeVDAO
  extends BaseDAO
  implements IEFasciculeTreeVDAO
{
  public FasciculeTreeV findFasciculeTreeVById(String paramString)
  {
    BigInteger localBigInteger = BigInteger.valueOf(Long.parseLong(paramString));
    return (FasciculeTreeV)super.getSession().get(FasciculeTreeV.class, localBigInteger);
  }
  
  public String findFasciculeTreeVByCheckunit(String paramString)
  {
    String str = "select e.Erp_Org_Id from FBP_CHECK_UNIT_CONTENTS e where e.CHECK_UNIT= '" + paramString + "'";
    return getSession().createSQLQuery(str).list().get(0).toString();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.EFasciculeTreeVDAO
 * JD-Core Version:    0.7.0.1
 */