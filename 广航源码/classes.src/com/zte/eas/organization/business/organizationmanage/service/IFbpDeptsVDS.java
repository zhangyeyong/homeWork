package com.zte.eas.organization.business.organizationmanage.service;

import com.zte.eas.organization.business.organizationmanage.model.FbpDepts;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsV;
import com.zte.esb.bean.AdminOrgInfo;
import com.zte.esb.bean.SendAdminOrgResponse;
import com.zte.esb.bean.foss.DistrictInfo;
import com.zte.esb.bean.foss.SyncDistrictResponse;
import com.zte.ssb.framework.base.DomainService;
import java.math.BigInteger;
import java.util.List;

public abstract interface IFbpDeptsVDS
  extends DomainService
{
  public abstract FbpDeptsV findDeptsVById(String paramString);
  
  public abstract String saveDeptsV(FbpDeptsV paramFbpDeptsV);
  
  public abstract List findDownDeptsV(BigInteger paramBigInteger);
  
  public abstract FbpDepts getFbpDepts(BigInteger paramBigInteger);
  
  public abstract void updateFbpDepts(FbpDepts paramFbpDepts);
  
  public abstract SyncDistrictResponse syncFossArea(List<DistrictInfo> paramList);
  
  public abstract SendAdminOrgResponse syncDepts(List<AdminOrgInfo> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.organizationmanage.service.IFbpDeptsVDS
 * JD-Core Version:    0.7.0.1
 */