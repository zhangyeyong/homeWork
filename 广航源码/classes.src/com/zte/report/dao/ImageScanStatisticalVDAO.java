package com.zte.report.dao;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.report.model.ImageScanStatisticalV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ImageScanStatisticalVDAO
  extends BaseDAO
  implements IImageScanStatisticalVDAO
{
  public List getImageScanStatisticalVs()
  {
    return super.getObjects(ImageScanStatisticalV.class);
  }
  
  public List<ImageScanStatisticalV> getImageScanStatisticalVs(int paramInt1, int paramInt2)
  {
    return super.getObjects(ImageScanStatisticalV.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeImageScanStatisticalV(ImageScanStatisticalV paramImageScanStatisticalV)
  {
    super.removeObject(paramImageScanStatisticalV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertImageScanStatisticalV(ImageScanStatisticalV paramImageScanStatisticalV)
  {
    super.insertObject(paramImageScanStatisticalV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateImageScanStatisticalV(ImageScanStatisticalV paramImageScanStatisticalV)
  {
    super.updateObject(paramImageScanStatisticalV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertImageScanStatisticalVs(List<ImageScanStatisticalV> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeImageScanStatisticalVs(List<ImageScanStatisticalV> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateImageScanStatisticalVs(List<ImageScanStatisticalV> paramList)
  {
    super.updateObjects(paramList);
  }
  
  public PageInfo findImageScanStatisticalV(ImageScanStatisticalV paramImageScanStatisticalV, int paramInt1, int paramInt2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    StringBuffer localStringBuffer = new StringBuffer("from ImageScanStatisticalV ssv where 1=1");
    ArrayList localArrayList = new ArrayList();
    if (!Util.isNullObject(paramImageScanStatisticalV.getCompanyId()))
    {
      localStringBuffer.append(" and ssv.companyId = ?");
      localArrayList.add(paramImageScanStatisticalV.getCompanyId());
    }
    if (!Util.isNullObject(paramImageScanStatisticalV.getOperationTypeId()))
    {
      localStringBuffer.append(" and ssv.operationTypeId = ?");
      localArrayList.add(paramImageScanStatisticalV.getOperationTypeId());
    }
    if (!Util.isNullObject(paramImageScanStatisticalV.getBeginUploadDate()))
    {
      localStringBuffer.append(" AND ssv.uploadDate >= ?");
      localArrayList.add(localSimpleDateFormat.format(paramImageScanStatisticalV.getBeginUploadDate()));
    }
    if (!Util.isNullObject(paramImageScanStatisticalV.getEndUploadDate()))
    {
      localStringBuffer.append(" AND ssv.uploadDate <= ?");
      localArrayList.add(localSimpleDateFormat.format(paramImageScanStatisticalV.getEndUploadDate()));
    }
    if (!"10000".equals(localEasUserInfo.getUserId()))
    {
      localStringBuffer.append(" and exists(select 1 from FbpPseRelationsV fpr where fpr.operationTypeId = ssv.operationTypeId and fpr.companyId = ssv.companyId and fpr.posStructureCode = ? and fpr.employeeId = ?)");
      localArrayList.add("IMAGE_QUERY");
      localArrayList.add(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    }
    localStringBuffer.append(" order by ssv.uploadDate desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.dao.ImageScanStatisticalVDAO
 * JD-Core Version:    0.7.0.1
 */