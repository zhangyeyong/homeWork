package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsImage;
import com.zte.evs.ebill.model.eBillManage.FbpImages;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpImagesDAO
  extends DAO
{
  public abstract FbpImages getFbpImages(String paramString);
  
  public abstract FbpImages getFbpImagesByEmployeeNumber(String paramString);
  
  public abstract List<FbpImages> getFbpImagess(int paramInt1, int paramInt2);
  
  public abstract List<FbpImages> getFbpImagess();
  
  public abstract void removeFbpImages(String paramString);
  
  public abstract void removeFbpImages(FbpImages paramFbpImages);
  
  public abstract void insertFbpImages(FbpImages paramFbpImages);
  
  public abstract void updateFbpImages(FbpImages paramFbpImages);
  
  public abstract void insertFbpImagess(List<FbpImages> paramList);
  
  public abstract void removeFbpImagess(List<FbpImages> paramList);
  
  public abstract void updateFbpImagess(List<FbpImages> paramList);
  
  public abstract List<EvsImage> findImageByImage(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IFbpImagesDAO
 * JD-Core Version:    0.7.0.1
 */