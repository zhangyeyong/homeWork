package com.zte.eas.appframe.business.currencies.service;

import com.zte.eas.appframe.access.currencies.dao.IFbpCurrenciesVDAO;
import com.zte.eas.appframe.business.currencies.model.FbpCurrenciesV;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.ssbext.resource.ComResUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FbpCurrenciesVDS
  extends BaseDomainService
  implements IFbpCurrenciesVDS
{
  private IFbpCurrenciesVDAO fbpCurrenciesVDAO;
  
  public HashMap findCurrenciesValuesForSelectCtr(String paramString)
  {
    HashMap localHashMap = new HashMap();
    List localList = this.fbpCurrenciesVDAO.getFbpCurrencies();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add(ComResUtil.getMessage("fbp.lookup.select"));
    localArrayList2.add("");
    for (int i = 0; i < localList.size(); i++)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject = (Object[])localList.get(i);
      localArrayList1.add(arrayOfObject[1].toString());
      localArrayList2.add(arrayOfObject[0].toString());
    }
    if (localArrayList2.contains(paramString)) {
      localHashMap.put("selectDefault", paramString);
    } else {
      localHashMap.put("selectDefault", "");
    }
    localHashMap.put("selectText", localArrayList1);
    localHashMap.put("selectValue", localArrayList2);
    return localHashMap;
  }
  
  public List<FbpCurrenciesV> findCurrenciesValues()
  {
    List localList = this.fbpCurrenciesVDAO.getFbpCurrencies();
    ArrayList localArrayList = new ArrayList();
    FbpCurrenciesV localFbpCurrenciesV = new FbpCurrenciesV();
    localFbpCurrenciesV.setCurrencyCode("");
    localFbpCurrenciesV.setCurrencyName(ComResUtil.getMessage("fbp.lookup.select"));
    localArrayList.add(localFbpCurrenciesV);
    for (int i = 0; i < localList.size(); i++)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject = (Object[])localList.get(i);
      localFbpCurrenciesV = new FbpCurrenciesV();
      localFbpCurrenciesV.setCurrencyCode(arrayOfObject[0].toString());
      localFbpCurrenciesV.setCurrencyName(arrayOfObject[1].toString());
      localArrayList.add(localFbpCurrenciesV);
    }
    return localArrayList;
  }
  
  public IFbpCurrenciesVDAO getFbpCurrenciesVDAO()
  {
    return this.fbpCurrenciesVDAO;
  }
  
  public void setFbpCurrenciesVDAO(IFbpCurrenciesVDAO paramIFbpCurrenciesVDAO)
  {
    this.fbpCurrenciesVDAO = paramIFbpCurrenciesVDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.currencies.service.FbpCurrenciesVDS
 * JD-Core Version:    0.7.0.1
 */