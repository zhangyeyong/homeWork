package com.zte.eas.organization.access.checkunits.dao;

import com.zte.eas.appframe.business.util.SqlManageUtils;
import com.zte.eas.organization.business.checkunits.model.FbpCheckUnitContentsV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.orm.zorm.ZormTemplate;
import java.util.ArrayList;
import java.util.List;

public class FbpCheckUnitContentsVDAO
  extends BaseDAO
  implements IFbpCheckUnitContentsVDAO
{
  public PageInfo findCheckUnitContentsVByQry(FbpCheckUnitContentsV paramFbpCheckUnitContentsV, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "FROM FbpCheckUnitContentsV s WHERE 1=1";
    if ((paramFbpCheckUnitContentsV.getCheckUnit() != null) && (!paramFbpCheckUnitContentsV.getCheckUnit().equals("")))
    {
      str = str + " AND s.checkUnit like ?";
      localArrayList.add("%" + SqlManageUtils.cleanUpSQL(paramFbpCheckUnitContentsV.getCheckUnit()) + "%");
    }
    if ((paramFbpCheckUnitContentsV.getCheckUnitName() != null) && (!paramFbpCheckUnitContentsV.getCheckUnitName().equals("")))
    {
      str = str + " AND s.checkUnitName like ?";
      localArrayList.add("%" + SqlManageUtils.cleanUpSQL(paramFbpCheckUnitContentsV.getCheckUnitName()) + "%");
    }
    if ((paramFbpCheckUnitContentsV.getOrgId() != null) && (!paramFbpCheckUnitContentsV.getOrgId().equals("")))
    {
      str = str + " AND s.orgId = ?";
      localArrayList.add(paramFbpCheckUnitContentsV.getOrgId());
    }
    if ((paramFbpCheckUnitContentsV.getDeptName() != null) && (!paramFbpCheckUnitContentsV.getDeptName().equals("")))
    {
      str = str + " AND s.deptName like ?";
      localArrayList.add(paramFbpCheckUnitContentsV.getDeptName());
    }
    if ((paramFbpCheckUnitContentsV.getErpOrgName() != null) && (!paramFbpCheckUnitContentsV.getErpOrgName().equals("")))
    {
      str = str + " AND s.erpOrgName like ?";
      localArrayList.add("%" + SqlManageUtils.cleanUpSQL(paramFbpCheckUnitContentsV.getErpOrgName()) + "%");
    }
    if ((paramFbpCheckUnitContentsV.getErpOrgId() != null) && (!paramFbpCheckUnitContentsV.getErpOrgId().equals("")))
    {
      str = str + " AND s.erpOrgId = ?";
      localArrayList.add(paramFbpCheckUnitContentsV.getErpOrgId());
    }
    if ((paramFbpCheckUnitContentsV.getEnabledFlag() != null) && (!paramFbpCheckUnitContentsV.getEnabledFlag().equals("")))
    {
      str = str + " AND s.enabledFlag =?";
      localArrayList.add(paramFbpCheckUnitContentsV.getEnabledFlag());
    }
    str = str + " ORDER by s.creationDate desc";
    paramInt1 = paramInt1 / paramInt2 + 1;
    return super.PageInfoQuery(str, paramInt1, paramInt2, localArrayList.toArray());
  }
  
  public FbpCheckUnitContentsV findCheckUnitContentsVById(long paramLong)
  {
    String str = "FROM FbpCheckUnitContentsV s WHERE s.contentId=" + paramLong;
    List localList = getZormTemplate().find(str.toString());
    if (localList.size() == 0) {
      return new FbpCheckUnitContentsV();
    }
    return (FbpCheckUnitContentsV)localList.get(0);
  }
  
  public PageInfo findCheckUnitContentsVByCodeOrName(FbpCheckUnitContentsV paramFbpCheckUnitContentsV)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "FROM FbpCheckUnitContentsV s WHERE 1=1";
    if ((paramFbpCheckUnitContentsV.getCheckUnit() != null) && (!paramFbpCheckUnitContentsV.getCheckUnit().equals("")))
    {
      str = str + " AND s.checkUnit = ? ";
      localArrayList.add(SqlManageUtils.cleanUpSQL(paramFbpCheckUnitContentsV.getCheckUnit()));
    }
    if ((paramFbpCheckUnitContentsV.getCheckUnitName() != null) && (!paramFbpCheckUnitContentsV.getCheckUnitName().equals("")))
    {
      str = str + " AND s.checkUnitName = ?";
      localArrayList.add(SqlManageUtils.cleanUpSQL(paramFbpCheckUnitContentsV.getCheckUnitName()));
    }
    return super.PageInfoQuery(str, 0, 10, localArrayList.toArray());
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.checkunits.dao.FbpCheckUnitContentsVDAO
 * JD-Core Version:    0.7.0.1
 */