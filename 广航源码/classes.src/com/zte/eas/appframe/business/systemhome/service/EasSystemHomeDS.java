package com.zte.eas.appframe.business.systemhome.service;

import com.zte.eas.appframe.access.syscommon.dao.IFbpEmployeesLoginVDAO;
import com.zte.eas.appframe.business.bulletinmanager.model.FbpBulletinsV;
import com.zte.eas.appframe.business.bulletinmanager.service.IFbpBulletinDS;
import com.zte.eas.appframe.business.syscommon.model.FbpEmployeesLoginV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.SSBBus;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EasSystemHomeDS
  implements IEasSystemHomeDS
{
  public TableDataInfo findBulletins(String paramString1, String paramString2, String paramString3)
  {
    FbpBulletinsV localFbpBulletinsV1 = new FbpBulletinsV();
    IFbpBulletinDS localIFbpBulletinDS = (IFbpBulletinDS)SSBBus.findDomainService("fbpBulletinDS");
    localFbpBulletinsV1.setCreationDate(new Date());
    TableDataInfo localTableDataInfo = localIFbpBulletinDS.findFbpBulletinsVByCon(localFbpBulletinsV1, paramString2, paramString3);
    List localList = localTableDataInfo.getData();
    for (int i = 0; i < localList.size(); i++)
    {
      FbpBulletinsV localFbpBulletinsV2 = (FbpBulletinsV)localList.get(i);
      IFbpEmployeesLoginVDAO localIFbpEmployeesLoginVDAO = (IFbpEmployeesLoginVDAO)SSBBus.findDaoService("fbpEmployeesLoginVDAO");
      FbpEmployeesLoginV localFbpEmployeesLoginV = new FbpEmployeesLoginV();
      localFbpEmployeesLoginV = localIFbpEmployeesLoginVDAO.findEmployeeByUser(localFbpBulletinsV2.getCreatedBy().toString());
      if (localFbpEmployeesLoginV != null)
      {
        str = localFbpEmployeesLoginV.getCompanyName() == null ? "" : localFbpEmployeesLoginV.getCompanyName();
        localFbpBulletinsV2.setCompanyName(str);
      }
      String str = new SimpleDateFormat("yyyy-MM-dd").format(localFbpBulletinsV2.getCreationDate());
      localFbpBulletinsV2.setEnabledFlag(str);
    }
    localTableDataInfo.getTotalCount();
    return localTableDataInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.systemhome.service.EasSystemHomeDS
 * JD-Core Version:    0.7.0.1
 */