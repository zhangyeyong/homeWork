package com.zte.eimage.access.baseconfig.dao;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eimage.business.baseconfig.model.FbpApproveHistoryV;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.util.List;

public class FbpApproveHistoryVDAO
  extends BaseDAO
  implements IFbpApproveHistoryVDAO
{
  public FbpApproveHistoryV getFbpApproveHistoryV(String paramString)
  {
    return (FbpApproveHistoryV)super.getObject(FbpApproveHistoryV.class, paramString);
  }
  
  public List<FbpApproveHistoryV> getFbpApproveHistoryVs()
  {
    return super.getObjects(FbpApproveHistoryV.class);
  }
  
  public PageInfo getFbpApproveHistoryVs(int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    BigInteger localBigInteger = localEasUserInfo.getUserInfoPk();
    String str = " from FbpApproveHistoryV  fv where fv.employeeId = '" + localBigInteger + "' order by fv.creationDate desc";
    paramInt1 = paramInt1 / paramInt2 + 1;
    PageInfo localPageInfo = super.PageInfoQuery(str.toString(), paramInt1, paramInt2, new Object[0]);
    return localPageInfo;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpApproveHistoryV(FbpApproveHistoryV paramFbpApproveHistoryV)
  {
    super.removeObject(paramFbpApproveHistoryV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpApproveHistoryV(FbpApproveHistoryV paramFbpApproveHistoryV)
  {
    super.insertObject(paramFbpApproveHistoryV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpApproveHistoryV(FbpApproveHistoryV paramFbpApproveHistoryV)
  {
    super.updateObject(paramFbpApproveHistoryV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpApproveHistoryVs(List<FbpApproveHistoryV> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpApproveHistoryVs(List<FbpApproveHistoryV> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpApproveHistoryVs(List<FbpApproveHistoryV> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpApproveHistoryV(String paramString)
  {
    super.removeObject(FbpApproveHistoryV.class, paramString);
  }
  
  public List<FbpApproveHistoryV> findHistoryVByApplyNum(String paramString)
  {
    String str = "from FbpApproveHistoryV  fv where fv.applyNum = '" + paramString + "' ORDER BY fv.creationDate ASC";
    List localList = getSession().createQuery(str).list();
    return localList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.FbpApproveHistoryVDAO
 * JD-Core Version:    0.7.0.1
 */