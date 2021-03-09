package com.zte.eas.organization.business.checkunits.service;

import com.zte.eas.organization.access.checkunits.dao.IFbpCheckUnitContentsAllVDAO;
import com.zte.eas.organization.business.checkunits.model.FbpCheckUnitContentsAllV;
import com.zte.ssb.ssbext.resource.ComResUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FbpCheckUnitContentsDS
  implements ICheckUnitsDS
{
  private IFbpCheckUnitContentsAllVDAO fbpCheckUnitContentsAllVDAO;
  static final String ENABLEFLAG = "Y";
  static final String DEFAUTSELECTVALUE = "";
  static final String ALL = "全部";
  
  public HashMap findFbpCheckUnitContentsAllV(String paramString)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    List localList = this.fbpCheckUnitContentsAllVDAO.findFbpCheckUnitContentsAllV();
    ArrayList localArrayList3 = new ArrayList();
    localArrayList3.addAll(localList);
    Iterator localIterator = localList.iterator();
    FbpCheckUnitContentsAllV localFbpCheckUnitContentsAllV;
    while (localIterator.hasNext())
    {
      localFbpCheckUnitContentsAllV = (FbpCheckUnitContentsAllV)localIterator.next();
      if ((localFbpCheckUnitContentsAllV.getEnabledFlag() != null) && (!localFbpCheckUnitContentsAllV.getEnabledFlag().equals("Y"))) {
        localArrayList3.remove(localFbpCheckUnitContentsAllV);
      }
      if ((null != localFbpCheckUnitContentsAllV.getCheckUnitName()) && (localFbpCheckUnitContentsAllV.getCheckUnitName().equals("全部")))
      {
        str2 = localFbpCheckUnitContentsAllV.getCheckUnitName();
        str3 = localFbpCheckUnitContentsAllV.getCheckUnit().toString();
        localArrayList3.remove(localFbpCheckUnitContentsAllV);
      }
    }
    localArrayList1.add(ComResUtil.getMessage("fbp.lookup.select"));
    localArrayList2.add("");
    if ((!"".equals(str2)) && (!"".equals(str3)))
    {
      localArrayList1.add(str2);
      localArrayList2.add(str3);
    }
    localIterator = localArrayList3.iterator();
    while (localIterator.hasNext())
    {
      localFbpCheckUnitContentsAllV = (FbpCheckUnitContentsAllV)localIterator.next();
      localArrayList1.add(localFbpCheckUnitContentsAllV.getCheckUnitName());
      localArrayList2.add(localFbpCheckUnitContentsAllV.getCheckUnit());
    }
    str1 = paramString;
    localHashMap.put("selectText", localArrayList1);
    localHashMap.put("selectValue", localArrayList2);
    localHashMap.put("selectDefault", str1);
    return localHashMap;
  }
  
  public IFbpCheckUnitContentsAllVDAO getFbpCheckUnitContentsAllVDAO()
  {
    return this.fbpCheckUnitContentsAllVDAO;
  }
  
  public void setFbpCheckUnitContentsAllVDAO(IFbpCheckUnitContentsAllVDAO paramIFbpCheckUnitContentsAllVDAO)
  {
    this.fbpCheckUnitContentsAllVDAO = paramIFbpCheckUnitContentsAllVDAO;
  }
  
  public List<FbpCheckUnitContentsAllV> findFbpCheckUnitAllVList(String paramString)
  {
    return null;
  }
  
  public String findFbpCheckUnitByName()
  {
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.checkunits.service.FbpCheckUnitContentsDS
 * JD-Core Version:    0.7.0.1
 */