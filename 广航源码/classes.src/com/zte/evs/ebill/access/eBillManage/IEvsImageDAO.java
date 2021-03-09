package com.zte.evs.ebill.access.eBillManage;

import com.zte.evs.ebill.model.eBillManage.EvsImage;
import com.zte.evs.ebill.model.eBillManage.EvsVoucher;
import com.zte.ssb.framework.base.DAO;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public abstract interface IEvsImageDAO
  extends DAO
{
  public abstract void saveImage(EvsImage paramEvsImage);
  
  public abstract void updateImage(EvsImage paramEvsImage);
  
  public abstract EvsImage findImageByImageUrl(String paramString, Long paramLong);
  
  public abstract void deleteImageById(Long paramLong);
  
  public abstract int updateVideoAbate(Long paramLong);
  
  public abstract Connection getConnection();
  
  public abstract void updateImageInfo(EvsVoucher paramEvsVoucher, List<EvsImage> paramList);
  
  public abstract List<Map<String, Object>> getVoucherCorverInfo(int paramInt);
  
  public abstract Map<String, Object> getMap(Long paramLong);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.eBillManage.IEvsImageDAO
 * JD-Core Version:    0.7.0.1
 */