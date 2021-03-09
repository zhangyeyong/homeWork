package com.zte.eas.appframe.business.accessory.service;

import com.zte.eas.appframe.business.accessory.model.AppFrameCon;
import com.zte.eas.appframe.business.accessory.model.FbpAccessories;
import com.zte.eas.appframe.business.accessory.model.FbpAccessoryPaths;
import com.zte.eas.appframe.business.accessory.model.FbpAccessoryV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.List;

public abstract interface IFbpAccessoriesDS
  extends DomainService
{
  public abstract List<FbpAccessoryV> findAccessories(AppFrameCon paramAppFrameCon);
  
  public abstract TableDataInfo findAccessories(AppFrameCon paramAppFrameCon, String paramString1, String paramString2);
  
  public abstract void removeAccessories(String paramString);
  
  public abstract void removeFbpAccessories(AppFrameCon paramAppFrameCon);
  
  public abstract void insertFbpAccessories(FbpAccessories paramFbpAccessories, FbpAccessoryPaths paramFbpAccessoryPaths);
  
  public abstract void insertFbpAccessories(FbpAccessoryV paramFbpAccessoryV);
  
  public abstract void removeFbpAccessorie(String paramString);
  
  public abstract String updateValue(String paramString1, String paramString2, String paramString3);
  
  public abstract FbpAccessories uploadAccessoryPublic(FbpAccessoryV paramFbpAccessoryV);
  
  public abstract void updateFbpAccessoriess(AppFrameCon paramAppFrameCon);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.accessory.service.IFbpAccessoriesDS
 * JD-Core Version:    0.7.0.1
 */