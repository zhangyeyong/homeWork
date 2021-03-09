package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsImage;
import com.zte.evs.ebill.model.eBillManage.FbpImages;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.util.List;

public class FbpImagesDAO
  extends BaseDAO
  implements IFbpImagesDAO
{
  public FbpImages getFbpImages(String paramString)
  {
    return (FbpImages)super.getObject(FbpImages.class, paramString);
  }
  
  public FbpImages getFbpImagesByEmployeeNumber(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("from FbpImages t where t.employeeNumber=? and t.enabledFlag='Y'");
    Query localQuery = super.getSession().createQuery(localStringBuilder.toString());
    localQuery.setString(0, paramString);
    List localList = localQuery.list();
    if ((localList != null) && (localList.size() > 0)) {
      return (FbpImages)localList.get(0);
    }
    return null;
  }
  
  public List getFbpImagess()
  {
    return super.getObjects(FbpImages.class);
  }
  
  public List<FbpImages> getFbpImagess(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpImages.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpImages(FbpImages paramFbpImages)
  {
    super.removeObject(paramFbpImages);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpImages(FbpImages paramFbpImages)
  {
    super.insertObject(paramFbpImages);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpImages(FbpImages paramFbpImages)
  {
    super.updateObject(paramFbpImages);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpImagess(List<FbpImages> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpImagess(List<FbpImages> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpImagess(List<FbpImages> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpImages(String paramString)
  {
    super.removeObject(FbpImages.class, paramString);
  }
  
  public List<EvsImage> findImageByImage(Long paramLong)
  {
    Object localObject = null;
    String str = "from EvsImage m where m.barcode is not null and m.voucherId =" + paramLong;
    List localList = getSession().createQuery(str).list();
    return localList;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.FbpImagesDAO
 * JD-Core Version:    0.7.0.1
 */