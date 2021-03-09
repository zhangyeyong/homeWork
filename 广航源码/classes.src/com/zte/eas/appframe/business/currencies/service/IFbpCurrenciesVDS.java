package com.zte.eas.appframe.business.currencies.service;

import com.zte.eas.appframe.business.currencies.model.FbpCurrenciesV;
import com.zte.ssb.framework.base.DomainService;
import java.util.HashMap;
import java.util.List;

public abstract interface IFbpCurrenciesVDS
  extends DomainService
{
  public abstract HashMap findCurrenciesValuesForSelectCtr(String paramString);
  
  public abstract List<FbpCurrenciesV> findCurrenciesValues();
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.currencies.service.IFbpCurrenciesVDS
 * JD-Core Version:    0.7.0.1
 */