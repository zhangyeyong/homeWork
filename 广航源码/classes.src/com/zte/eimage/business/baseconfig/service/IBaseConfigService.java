package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.business.baseconfig.model.BaseConfig;
import com.zte.eimage.business.baseconfig.model.BaseConfigV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import java.util.Map;

public abstract interface IBaseConfigService
{
  public abstract void insertBaseConfig(BaseConfig paramBaseConfig);
  
  public abstract void updateBaseConfig(BaseConfig paramBaseConfig);
  
  public abstract BaseConfig getBaseConfigById(String paramString);
  
  public abstract BaseConfigV getBaseConfigVById(String paramString);
  
  public abstract TableDataInfo findBaseConfig(BaseConfig paramBaseConfig, String paramString1, String paramString2);
  
  public abstract Integer isExistsBaseConfigName(String paramString);
  
  public abstract Map getResRatio(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.IBaseConfigService
 * JD-Core Version:    0.7.0.1
 */