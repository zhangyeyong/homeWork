package com.zte.eas.organization.access.organizationmanage.dao;

import com.zte.ssb.framework.base.DAO;
import java.math.BigInteger;
import java.util.List;

public abstract interface IFbpDeptsTreeVDAO
  extends DAO
{
  public abstract List findDownDeptsVl(BigInteger paramBigInteger, String paramString);
  
  public abstract List findAllDeptsVl(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsTreeVDAO
 * JD-Core Version:    0.7.0.1
 */