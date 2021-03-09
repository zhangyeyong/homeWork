package com.zte.report.dao;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.evs.ebill.common.EvsObjectUtils;
import com.zte.report.model.ImageQueryInfoV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageQueryInfoVDAO
  extends BaseDAO
  implements IImageQueryInfoVDAO
{
  public List getImageQueryInfoVs()
  {
    return super.getObjects(ImageQueryInfoV.class);
  }
  
  public List<ImageQueryInfoV> getImageQueryInfoVs(int paramInt1, int paramInt2)
  {
    return super.getObjects(ImageQueryInfoV.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeImageQueryInfoV(ImageQueryInfoV paramImageQueryInfoV)
  {
    super.removeObject(paramImageQueryInfoV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertImageQueryInfoV(ImageQueryInfoV paramImageQueryInfoV)
  {
    super.insertObject(paramImageQueryInfoV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateImageQueryInfoV(ImageQueryInfoV paramImageQueryInfoV)
  {
    super.updateObject(paramImageQueryInfoV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertImageQueryInfoVs(List<ImageQueryInfoV> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeImageQueryInfoVs(List<ImageQueryInfoV> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateImageQueryInfoVs(List<ImageQueryInfoV> paramList)
  {
    super.updateObjects(paramList);
  }
  
  public PageInfo findImageQueryInfoV(ImageQueryInfoV paramImageQueryInfoV, int paramInt1, int paramInt2)
  {
    EvsObjectUtils localEvsObjectUtils = new EvsObjectUtils();
    EasUserInfo localEasUserInfo = EvsObjectUtils.getUserInfoBySession();
    int i = 0;
    if ("Y".equals(paramImageQueryInfoV.getIsLikeQuery())) {
      i = 1;
    }
    StringBuffer localStringBuffer = new StringBuffer("from ImageQueryInfoV t where 1=1");
    ArrayList localArrayList = new ArrayList();
    if (!Util.isNullObject(paramImageQueryInfoV.getImageNumber())) {
      if (i != 0)
      {
        localStringBuffer.append(" and t.imageNumber like ?");
        localArrayList.add("%" + paramImageQueryInfoV.getImageNumber() + "%");
      }
      else
      {
        localStringBuffer.append(" and t.imageNumber = ?");
        localArrayList.add(paramImageQueryInfoV.getImageNumber());
      }
    }
    if (!Util.isNullObject(paramImageQueryInfoV.getTaskNum())) {
      if (i != 0)
      {
        localStringBuffer.append(" and t.taskNum like ?");
        localArrayList.add("%" + paramImageQueryInfoV.getTaskNum() + "%");
      }
      else
      {
        localStringBuffer.append(" and t.taskNum = ?");
        localArrayList.add(paramImageQueryInfoV.getTaskNum());
      }
    }
    if (!Util.isNullObject(paramImageQueryInfoV.getCompanyId()))
    {
      localStringBuffer.append(" and t.companyId = ?");
      localArrayList.add(paramImageQueryInfoV.getCompanyId());
    }
    if (!Util.isNullObject(paramImageQueryInfoV.getOperationTypeId()))
    {
      localStringBuffer.append(" and t.operationTypeId = ?");
      localArrayList.add(paramImageQueryInfoV.getOperationTypeId());
    }
    if (!Util.isNullObject(paramImageQueryInfoV.getUploadEmployeeId()))
    {
      localStringBuffer.append(" and t.uploadEmployeeId = ?");
      localArrayList.add(paramImageQueryInfoV.getUploadEmployeeId());
    }
    if (!Util.isNullObject(paramImageQueryInfoV.getBeginUploadDate()))
    {
      localStringBuffer.append(" AND t.uploadDate >= ?");
      localArrayList.add(paramImageQueryInfoV.getBeginUploadDate());
    }
    if (!Util.isNullObject(paramImageQueryInfoV.getEndUploadDate()))
    {
      localStringBuffer.append(" AND t.uploadDate <= ?");
      localArrayList.add(new Date(paramImageQueryInfoV.getEndUploadDate().getTime() + 86399999L));
    }
    if (!Util.isNullObject(paramImageQueryInfoV.getImageStatus()))
    {
      localStringBuffer.append(" and t.imageStatus = ?");
      localArrayList.add(paramImageQueryInfoV.getImageStatus());
    }
    if (!Util.isNullObject(paramImageQueryInfoV.getAppraiseNode()))
    {
      localStringBuffer.append(" and t.appraiseNode = ?");
      localArrayList.add(paramImageQueryInfoV.getAppraiseNode());
    }
    if (!Util.isNullObject(paramImageQueryInfoV.getAppraiseEmployeeId()))
    {
      localStringBuffer.append(" and t.appraiseEmployeeId = ?");
      localArrayList.add(paramImageQueryInfoV.getAppraiseEmployeeId());
    }
    if (!Util.isNullObject(paramImageQueryInfoV.getBeginAppraiseDate()))
    {
      localStringBuffer.append(" AND t.appraiseDate >= ?");
      localArrayList.add(paramImageQueryInfoV.getBeginAppraiseDate());
    }
    if (!Util.isNullObject(paramImageQueryInfoV.getEndAppraiseDate()))
    {
      localStringBuffer.append(" AND t.appraiseDate <= ?");
      localArrayList.add(new Date(paramImageQueryInfoV.getEndAppraiseDate().getTime() + 86399999L));
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
 * Qualified Name:     com.zte.report.dao.ImageQueryInfoVDAO
 * JD-Core Version:    0.7.0.1
 */