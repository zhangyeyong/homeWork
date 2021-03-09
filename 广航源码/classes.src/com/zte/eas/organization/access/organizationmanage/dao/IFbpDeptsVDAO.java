package com.zte.eas.organization.access.organizationmanage.dao;

import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsV;
import com.zte.ssb.framework.base.DAO;
import java.math.BigInteger;
import java.util.List;

public abstract interface IFbpDeptsVDAO
  extends DAO
{
  public abstract FbpDeptsV findDeptsVById(BigInteger paramBigInteger);
  
  public abstract List findDownDeptsV(BigInteger paramBigInteger, String paramString);
  
  public abstract List findDownDeptsV(BigInteger paramBigInteger);
  
  public abstract List findDeptsVByCode(String paramString);
  
  public abstract FbpDeptsV findDeptByCompId(String paramString);
  
  public abstract List findDeptVByCon(FbpDeptsV paramFbpDeptsV);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsVDAO
 * JD-Core Version:    0.7.0.1
 */