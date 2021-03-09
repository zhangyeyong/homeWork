package com.zte.report.dao;

import com.zte.report.model.ImageScanDetailV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

public class ImageScanDetailVDAO
  extends BaseDAO
  implements IImageScanDetailVDAO
{
  public List getImageScanDetailVs()
  {
    return super.getObjects(ImageScanDetailV.class);
  }
  
  public List<ImageScanDetailV> getImageScanDetailVs(int paramInt1, int paramInt2)
  {
    return super.getObjects(ImageScanDetailV.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeImageScanDetailV(ImageScanDetailV paramImageScanDetailV)
  {
    super.removeObject(paramImageScanDetailV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertImageScanDetailV(ImageScanDetailV paramImageScanDetailV)
  {
    super.insertObject(paramImageScanDetailV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateImageScanDetailV(ImageScanDetailV paramImageScanDetailV)
  {
    super.updateObject(paramImageScanDetailV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertImageScanDetailVs(List<ImageScanDetailV> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeImageScanDetailVs(List<ImageScanDetailV> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateImageScanDetailVs(List<ImageScanDetailV> paramList)
  {
    super.updateObjects(paramList);
  }
  
  public PageInfo findImageScanDetailV(ImageScanDetailV paramImageScanDetailV, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer("from ImageScanDetailV ssv where 1=1");
    ArrayList localArrayList = new ArrayList();
    if (!Util.isNullObject(paramImageScanDetailV.getCompanyId()))
    {
      localStringBuffer.append(" and ssv.companyId = ?");
      localArrayList.add(paramImageScanDetailV.getCompanyId());
    }
    if (!Util.isNullObject(paramImageScanDetailV.getOperationTypeId()))
    {
      localStringBuffer.append(" and ssv.operationTypeId = ?");
      localArrayList.add(paramImageScanDetailV.getOperationTypeId());
    }
    if (!Util.isNullObject(paramImageScanDetailV.getUploadDateStr()))
    {
      localStringBuffer.append(" and to_char(ssv.uploadDate,'yyyy-mm-dd') = ?");
      localArrayList.add(paramImageScanDetailV.getUploadDateStr());
    }
    localStringBuffer.append("order by ssv.imageNumber desc");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.report.dao.ImageScanDetailVDAO
 * JD-Core Version:    0.7.0.1
 */