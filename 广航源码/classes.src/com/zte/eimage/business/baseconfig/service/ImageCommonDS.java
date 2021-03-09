package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.access.baseconfig.dao.IImageCommonDAO;
import com.zte.ssb.framework.base.BaseDomainService;
import java.util.List;

public class ImageCommonDS
  extends BaseDomainService
  implements IImageCommonDS
{
  IImageCommonDAO imageCommonDAO;
  
  public List<Object> findObjectBySQL(String paramString, List paramList, Class paramClass)
  {
    return this.imageCommonDAO.findObjectBySQL(paramString, paramList, paramClass);
  }
  
  public Object findObject(String paramString, List paramList, Class paramClass)
  {
    return this.imageCommonDAO.findObject(paramString, paramList, paramClass);
  }
  
  public void executeSql(String paramString, List paramList)
  {
    this.imageCommonDAO.executeSql(paramString, paramList);
  }
  
  public IImageCommonDAO getImageCommonDAO()
  {
    return this.imageCommonDAO;
  }
  
  public void setImageCommonDAO(IImageCommonDAO paramIImageCommonDAO)
  {
    this.imageCommonDAO = paramIImageCommonDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.ImageCommonDS
 * JD-Core Version:    0.7.0.1
 */