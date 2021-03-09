package com.zte.eimage.business.common.service;

import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eimage.access.baseconfig.dao.IEidImagesDAO;
import com.zte.eimage.access.common.dao.IImageDisplayDAO;
import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.eimage.business.baseconfig.model.EidImages;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.framework.util.Util;
import java.util.ArrayList;
import java.util.List;

public class ImageDisplayDS
  implements IImageDisplayDS
{
  private IImageDisplayDAO imageDisplayDAO;
  private IEidImagesDAO eidImagesDAO;
  
  public List getImage(String paramString)
  {
    Object localObject = new ArrayList();
    if (!Util.isStrEmpty(paramString)) {
      localObject = this.imageDisplayDAO.findImageByImageNumer(paramString);
    }
    return localObject;
  }
  
  public EidImageInfos findEidImageInfos(String paramString)
  {
    return this.imageDisplayDAO.findEidImageInfos(paramString);
  }
  
  public String getImageInfo(String paramString)
  {
    return this.imageDisplayDAO.getImageInfo(paramString);
  }
  
  public PageInfo getImage(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramString.indexOf("#");
    if (i > -1) {
      paramString = paramString.substring(0, i);
    }
    paramInt2 = paramInt2 <= 0 ? 1000000 : paramInt2;
    PageInfo localPageInfo = this.imageDisplayDAO.findImageByImageNumer(paramString, paramInt1, paramInt2);
    return localPageInfo;
  }
  
  public String fillImageShow(String paramString1, String paramString2, String paramString3)
  {
    EidImages localEidImages = this.imageDisplayDAO.getImageShow(Long.valueOf(Long.parseLong(paramString1)), Long.valueOf(Long.parseLong(paramString2)));
    if (localEidImages == null) {
      return "false";
    }
    localEidImages.setOriginImageId(localEidImages.getImageId());
    localEidImages.setIsShowImage(paramString3);
    ObjectCopyUtils.setWho(localEidImages);
    this.imageDisplayDAO.updateEidImages(localEidImages);
    return "true";
  }
  
  public IImageDisplayDAO getImageDisplayDAO()
  {
    return this.imageDisplayDAO;
  }
  
  public void setImageDisplayDAO(IImageDisplayDAO paramIImageDisplayDAO)
  {
    this.imageDisplayDAO = paramIImageDisplayDAO;
  }
  
  public IEidImagesDAO getEidImagesDAO()
  {
    return this.eidImagesDAO;
  }
  
  public void setEidImagesDAO(IEidImagesDAO paramIEidImagesDAO)
  {
    this.eidImagesDAO = paramIEidImagesDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.common.service.ImageDisplayDS
 * JD-Core Version:    0.7.0.1
 */