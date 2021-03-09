package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidImageMemoV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.util.List;

public class EidImageMemoVDAO
  extends BaseDAO
  implements IEidImageMemoVDAO
{
  public EidImageMemoV getEidImageMemoV(String paramString)
  {
    return (EidImageMemoV)super.getObject(EidImageMemoV.class, paramString);
  }
  
  public List getEidImageMemoVs()
  {
    return super.getObjects(EidImageMemoV.class);
  }
  
  public List<EidImageMemoV> getEidImageMemoVs(int paramInt1, int paramInt2)
  {
    return super.getObjects(EidImageMemoV.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidImageMemoV(EidImageMemoV paramEidImageMemoV)
  {
    super.removeObject(paramEidImageMemoV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEidImageMemoV(EidImageMemoV paramEidImageMemoV)
  {
    super.insertObject(paramEidImageMemoV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEidImageMemoV(EidImageMemoV paramEidImageMemoV)
  {
    super.updateObject(paramEidImageMemoV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEidImageMemoVs(List<EidImageMemoV> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidImageMemoVs(List<EidImageMemoV> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEidImageMemoVs(List<EidImageMemoV> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidImageMemoV(String paramString)
  {
    super.removeObject(EidImageMemoV.class, paramString);
  }
  
  public List<EidImageMemoV> getImageMemoInfo(String paramString)
  {
    String str = "from EidImageMemoV imgv where imgv.imageNumber='" + paramString + "'";
    List localList = getSession().createQuery(str).list();
    if ((localList != null) && (localList.size() > 0)) {
      return localList;
    }
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.EidImageMemoVDAO
 * JD-Core Version:    0.7.0.1
 */