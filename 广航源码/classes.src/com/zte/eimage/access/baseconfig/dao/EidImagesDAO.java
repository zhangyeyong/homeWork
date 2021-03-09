package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidImages;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.util.ArrayList;
import java.util.List;

public class EidImagesDAO
  extends BaseDAO
  implements IEidImagesDAO
{
  public EidImages getEidImages(Long paramLong)
  {
    return (EidImages)super.getObject(EidImages.class, paramLong);
  }
  
  public List getEidImagess()
  {
    return super.getObjects(EidImages.class);
  }
  
  public List<EidImages> getEidImagess(int paramInt1, int paramInt2)
  {
    return super.getObjects(EidImages.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidImages(EidImages paramEidImages)
  {
    super.removeObject(paramEidImages);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEidImages(EidImages paramEidImages)
  {
    super.insertObject(paramEidImages);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEidImages(EidImages paramEidImages)
  {
    super.updateObject(paramEidImages);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEidImagess(List<EidImages> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidImagess(List<EidImages> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEidImagess(List<EidImages> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidImages(Long paramLong)
  {
    super.removeObject(EidImages.class, paramLong);
  }
  
  public List<EidImages> findEidImagesByImageInfoId(Long paramLong)
  {
    String str = "from EidImages line where line.enabledFlag='Y' and line.imageInfoId=" + paramLong;
    return getSession().createQuery(str).list();
  }
  
  public List<EidImages> findImageByTif()
  {
    Object localObject = new ArrayList();
    String str = "SELECT * FROM eid_images ei WHERE ei.image_path LIKE '%.tif%' AND ROWNUM <= 10";
    localObject = super.getSession().createSQLQuery(str).addEntity(EidImages.class).list();
    return localObject;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.EidImagesDAO
 * JD-Core Version:    0.7.0.1
 */