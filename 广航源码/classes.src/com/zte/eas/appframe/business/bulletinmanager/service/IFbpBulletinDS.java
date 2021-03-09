package com.zte.eas.appframe.business.bulletinmanager.service;

import com.zte.eas.appframe.business.accessory.model.FbpAccessoryV;
import com.zte.eas.appframe.business.bulletinmanager.model.FbpBulletinsV;
import com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.List;

public abstract interface IFbpBulletinDS
  extends DomainService
{
  public abstract FbpBulletinsV findFbpBulletinsVById(String paramString);
  
  public abstract TableDataInfo findFbpBulletinsVByCon(FbpBulletinsV paramFbpBulletinsV, String paramString1, String paramString2);
  
  public abstract TableDataInfo findFbpBulletinsVByCons(FbpBulletinsV paramFbpBulletinsV, String paramString1, String paramString2);
  
  public abstract String saveFbpBulletin(FbpBulletinsV paramFbpBulletinsV);
  
  public abstract String removeFbpBulletinById(String paramString);
  
  public abstract FbpEmployeesLoginV findEmployees();
  
  public abstract String uploadfile(FbpBulletinsV paramFbpBulletinsV);
  
  public abstract List sessionList();
  
  public abstract String deleteSession(String paramString);
  
  public abstract List<FbpAccessoryV> getFbpAccessories(String paramString);
  
  public abstract String downloadTemplet(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.bulletinmanager.service.IFbpBulletinDS
 * JD-Core Version:    0.7.0.1
 */