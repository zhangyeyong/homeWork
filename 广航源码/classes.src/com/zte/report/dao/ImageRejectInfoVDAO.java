package com.zte.report.dao;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.report.model.ImageRejectInfoV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageRejectInfoVDAO
  extends BaseDAO
  implements IImageRejectInfoVDAO
{
  public List getImageRejectInfoVs()
  {
    return super.getObjects(ImageRejectInfoV.class);
  }
  
  public List<ImageRejectInfoV> getImageRejectInfoVs(int paramInt1, int paramInt2)
  {
    return super.getObjects(ImageRejectInfoV.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeImageRejectInfoV(ImageRejectInfoV paramImageRejectInfoV)
  {
    super.removeObject(paramImageRejectInfoV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertImageRejectInfoV(ImageRejectInfoV paramImageRejectInfoV)
  {
    super.insertObject(paramImageRejectInfoV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateImageRejectInfoV(ImageRejectInfoV paramImageRejectInfoV)
  {
    super.updateObject(paramImageRejectInfoV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertImageRejectInfoVs(List<ImageRejectInfoV> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeImageRejectInfoVs(List<ImageRejectInfoV> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateImageRejectInfoVs(List<ImageRejectInfoV> paramList)
  {
    super.updateObjects(paramList);
  }
  
  public PageInfo findImageRejectInfoV(ImageRejectInfoV paramImageRejectInfoV, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    int i = 0;
    if ("Y".equals(paramImageRejectInfoV.getIsLikeQuery())) {
      i = 1;
    }
    StringBuffer localStringBuffer = new StringBuffer("from ImageRejectInfoV t where 1=1");
    ArrayList localArrayList = new ArrayList();
    if (!Util.isNullObject(paramImageRejectInfoV.getImageNumber())) {
      if (i != 0)
      {
        localStringBuffer.append(" and t.imageNumber like ?");
        localArrayList.add("%" + paramImageRejectInfoV.getImageNumber() + "%");
      }
      else
      {
        localStringBuffer.append(" and t.imageNumber = ?");
        localArrayList.add(paramImageRejectInfoV.getImageNumber());
      }
    }
    if (!Util.isNullObject(paramImageRejectInfoV.getTaskNum())) {
      if (i != 0)
      {
        localStringBuffer.append(" and t.taskNum like ?");
        localArrayList.add("%" + paramImageRejectInfoV.getTaskNum() + "%");
      }
      else
      {
        localStringBuffer.append(" and t.taskNum = ?");
        localArrayList.add(paramImageRejectInfoV.getTaskNum());
      }
    }
    if (!Util.isNullObject(paramImageRejectInfoV.getCompanyId()))
    {
      localStringBuffer.append(" and t.companyId = ?");
      localArrayList.add(paramImageRejectInfoV.getCompanyId());
    }
    if (!Util.isNullObject(paramImageRejectInfoV.getOperationTypeId()))
    {
      localStringBuffer.append(" and t.operationTypeId = ?");
      localArrayList.add(paramImageRejectInfoV.getOperationTypeId());
    }
    if (!Util.isNullObject(paramImageRejectInfoV.getUploadEmployeeId()))
    {
      localStringBuffer.append(" and t.uploadEmployeeId = ?");
      localArrayList.add(paramImageRejectInfoV.getUploadEmployeeId());
    }
    if (!Util.isNullObject(paramImageRejectInfoV.getBeginUploadDate()))
    {
      localStringBuffer.append(" AND t.uploadDate >= ?");
      localArrayList.add(paramImageRejectInfoV.getBeginUploadDate());
    }
    if (!Util.isNullObject(paramImageRejectInfoV.getEndUploadDate()))
    {
      localStringBuffer.append(" AND t.uploadDate <= ?");
      localArrayList.add(new Date(paramImageRejectInfoV.getEndUploadDate().getTime() + 86399999L));
    }
    if (!Util.isNullObject(paramImageRejectInfoV.getAppraiseType()))
    {
      localStringBuffer.append(" and t.appraiseType = ?");
      localArrayList.add(paramImageRejectInfoV.getAppraiseType());
    }
    if (!"10000".equals(localEasUserInfo.getUserId()))
    {
      localStringBuffer.append(" and exists(select 1 from FbpPseRelationsV fpr where fpr.operationTypeId = t.operationTypeId and fpr.companyId = t.companyId and fpr.posStructureCode = ? and fpr.employeeId = ?)");
      localArrayList.add("IMAGE_QUERY");
      localArrayList.add(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    }
    localStringBuffer.append(" order by t.imageNumber desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.dao.ImageRejectInfoVDAO
 * JD-Core Version:    0.7.0.1
 */