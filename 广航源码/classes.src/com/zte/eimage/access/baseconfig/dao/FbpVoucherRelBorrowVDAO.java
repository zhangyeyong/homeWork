package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.FbpVoucherRelBorrowV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.List;

public class FbpVoucherRelBorrowVDAO
  extends BaseDAO
  implements IFbpVoucherRelBorrowVDAO
{
  public FbpVoucherRelBorrowV getFbpVoucherRelBorrowV(String paramString)
  {
    return (FbpVoucherRelBorrowV)super.getObject(FbpVoucherRelBorrowV.class, paramString);
  }
  
  public List<FbpVoucherRelBorrowV> getFbpVoucherRelBorrowVs()
  {
    return super.getObjects(FbpVoucherRelBorrowV.class);
  }
  
  public PageInfo getFbpVoucherRelBorrowVs(FbpVoucherRelBorrowV paramFbpVoucherRelBorrowV, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(" from FbpVoucherRelBorrowV frv where frv.archivesHeaderId = " + paramFbpVoucherRelBorrowV.getArchivesHeaderId());
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1 / paramInt2 + 1, paramInt2, new Object[0]);
    return localPageInfo;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpVoucherRelBorrowV(FbpVoucherRelBorrowV paramFbpVoucherRelBorrowV)
  {
    super.removeObject(paramFbpVoucherRelBorrowV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpVoucherRelBorrowV(FbpVoucherRelBorrowV paramFbpVoucherRelBorrowV)
  {
    super.insertObject(paramFbpVoucherRelBorrowV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpVoucherRelBorrowV(FbpVoucherRelBorrowV paramFbpVoucherRelBorrowV)
  {
    super.updateObject(paramFbpVoucherRelBorrowV);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpVoucherRelBorrowVs(List<FbpVoucherRelBorrowV> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpVoucherRelBorrowVs(List<FbpVoucherRelBorrowV> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpVoucherRelBorrowVs(List<FbpVoucherRelBorrowV> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpVoucherRelBorrowV(String paramString)
  {
    super.removeObject(FbpVoucherRelBorrowV.class, paramString);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.FbpVoucherRelBorrowVDAO
 * JD-Core Version:    0.7.0.1
 */