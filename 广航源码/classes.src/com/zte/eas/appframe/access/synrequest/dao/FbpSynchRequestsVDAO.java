package com.zte.eas.appframe.access.synrequest.dao;

import com.zte.eas.appframe.business.synrequest.model.FbpSynchRequestsV;
import com.zte.eas.appframe.business.util.SqlManageUtils;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.orm.zorm.ZormTemplate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FbpSynchRequestsVDAO
  extends BaseDAO
  implements IFbpSynchRequestsVDAO
{
  private static final String SYNCH_TYPE_AP = "AP";
  private static final String SYNCH_TYPE_AR = "AR";
  private static final String SYNCH_TYPE_GL = "GL";
  private static final String SYNCH_TYPE_RC = "RC";
  
  public FbpSynchRequestsV findSynchRequestsVById(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    FbpSynchRequestsV localFbpSynchRequestsV = new FbpSynchRequestsV();
    String str = "FROM FbpSynchRequestsV f WHERE f.synchRequestId=?";
    localArrayList.add(Long.valueOf(paramString));
    List localList = super.getZormTemplate().find(str, localArrayList.toArray());
    if (localList.size() > 0) {
      localFbpSynchRequestsV = (FbpSynchRequestsV)localList.get(0);
    }
    super.clear();
    return localFbpSynchRequestsV;
  }
  
  public PageInfo findSynchRequestsVByCon(FbpSynchRequestsV paramFbpSynchRequestsV, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder("FROM FbpSynchRequestsV f WHERE 1=1 ");
    String str1 = "";
    String str2 = "";
    ArrayList localArrayList = new ArrayList();
    if ((paramFbpSynchRequestsV.getStartDateActive() != null) && (paramFbpSynchRequestsV.getEndDateActive() != null) && (paramFbpSynchRequestsV.getStartDateActive() == paramFbpSynchRequestsV.getEndDateActive()))
    {
      str1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paramFbpSynchRequestsV.getStartDateActive());
      localStringBuilder.append(" AND f.creationDate >= ?");
      localArrayList.add(paramFbpSynchRequestsV.getStartDateActive());
    }
    else
    {
      if ((paramFbpSynchRequestsV.getStartDateActive() != null) && (!paramFbpSynchRequestsV.getStartDateActive().equals("")))
      {
        str1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paramFbpSynchRequestsV.getStartDateActive());
        localStringBuilder.append(" AND f.creationDate >= ?");
        localArrayList.add(paramFbpSynchRequestsV.getStartDateActive());
      }
      if (paramFbpSynchRequestsV.getEndDateActive() != null)
      {
        localObject = new Date(paramFbpSynchRequestsV.getEndDateActive().getTime() + 86400000L);
        String str3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date)localObject).toString();
        localStringBuilder.append(" AND f.creationDate <= ?");
        localArrayList.add(localObject);
      }
    }
    if ((paramFbpSynchRequestsV.getSynchRequestNumber() != null) && (!paramFbpSynchRequestsV.getSynchRequestNumber().equals("")))
    {
      localStringBuilder.append(" AND f.synchRequestNumber LIKE ?");
      localArrayList.add("%" + SqlManageUtils.cleanUpSQL(paramFbpSynchRequestsV.getSynchRequestNumber().trim().replaceAll("'", "''")) + "%");
    }
    if ((paramFbpSynchRequestsV.getSubmiter() != null) && (!paramFbpSynchRequestsV.getSubmiter().equals("")))
    {
      localStringBuilder.append(" AND f.submiter= ?");
      localArrayList.add(paramFbpSynchRequestsV.getSubmiter());
    }
    if ((paramFbpSynchRequestsV.getStatus() != null) && (!paramFbpSynchRequestsV.getStatus().equals("")))
    {
      localStringBuilder.append(" AND f.status= ? ");
      localArrayList.add(paramFbpSynchRequestsV.getStatus());
    }
    paramInt1 = paramInt1 / paramInt2 + 1;
    Object localObject = super.PageInfoQuery(localStringBuilder.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localObject;
  }
  
  public FbpSynchRequestsV findSynchRequestsVByReqNum(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    FbpSynchRequestsV localFbpSynchRequestsV = null;
    String str = "FROM FbpSynchRequestsV f WHERE f.synchRequestNumber= ? ";
    localArrayList.add(paramString);
    List localList = super.getZormTemplate().find(str, localArrayList.toArray());
    if (localList.size() > 0) {
      localFbpSynchRequestsV = (FbpSynchRequestsV)localList.get(0);
    }
    return localFbpSynchRequestsV;
  }
  
  public List<FbpSynchRequestsV> findAllFbpSynchRequestsV()
  {
    StringBuilder localStringBuilder = new StringBuilder(" FROM FbpSynchRequestsV f WHERE 1=1 ");
    localStringBuilder.append(" and f.status = 'Y' and ");
    localStringBuilder.append(" f.synchType != 'AP' and ");
    localStringBuilder.append("(f.attribute2 = 'Y' or ");
    localStringBuilder.append("(f.attribute2 = 'N' and ");
    localStringBuilder.append("(f.startDateActive <= sysdate or f.startDateActive is null) and ");
    localStringBuilder.append("(f.endDateActive >= sysdate or f.endDateActive is null) and ");
    localStringBuilder.append("((sysdate - f.lastRunTime) * 24 * 60 * 60 >= ");
    localStringBuilder.append("(nvl(f.attribute6, 0) * 60 * 60 + nvl(f.attribute5, 0) * 60 + ");
    localStringBuilder.append("nvl(f.repeatInterval, 0) * 24 * 60 * 60))))");
    List localList = super.getZormTemplate().find(localStringBuilder.toString());
    return localList;
  }
  
  public List<FbpSynchRequestsV> findFbpSynchRequestsByAP()
  {
    return findFbpSynchRequestsByType("AP");
  }
  
  public List<FbpSynchRequestsV> findFbpSynchRequestsByAR()
  {
    return findFbpSynchRequestsByType("AR");
  }
  
  public List<FbpSynchRequestsV> findFbpSynchRequestsByGL()
  {
    return findFbpSynchRequestsByType("GL");
  }
  
  public List<FbpSynchRequestsV> findFbpSynchRequestsByRC()
  {
    return findFbpSynchRequestsByType("RC");
  }
  
  private List<FbpSynchRequestsV> findFbpSynchRequestsByType(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(" FROM FbpSynchRequestsV f WHERE 1=1 ");
    localStringBuilder.append(" AND f.status = 'Y' AND ");
    localStringBuilder.append(" f.synchType = '" + paramString + "' AND ");
    localStringBuilder.append("(f.attribute2 = 'Y' OR ");
    localStringBuilder.append("(f.attribute2 = 'N' AND ");
    localStringBuilder.append("(f.startDateActive <= sysdate OR f.startDateActive is null) AND ");
    localStringBuilder.append("(f.endDateActive >= sysdate OR f.endDateActive is null) AND ");
    localStringBuilder.append("((sysdate - f.lastRunTime) * 24 * 60 * 60 >= ");
    localStringBuilder.append("(nvl(f.attribute6, 0) * 60 * 60 + nvl(f.attribute5, 0) * 60 + ");
    localStringBuilder.append("nvl(f.repeatInterval, 0) * 24 * 60 * 60))))");
    List localList = super.getZormTemplate().find(localStringBuilder.toString());
    return localList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.synrequest.dao.FbpSynchRequestsVDAO
 * JD-Core Version:    0.7.0.1
 */