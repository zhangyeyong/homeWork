package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.BaseConfig;
import com.zte.eimage.business.baseconfig.model.BaseConfigV;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IBaseConfigDao
{
  public abstract void insertBaseConfig(BaseConfig paramBaseConfig);
  
  public abstract void updateBaseConfig(BaseConfig paramBaseConfig);
  
  public abstract BaseConfig getBaseConfigById(Integer paramInteger);
  
  public abstract PageInfo findBaseConfig(BaseConfig paramBaseConfig, Integer paramInteger1, Integer paramInteger2);
  
  public abstract List<BaseConfigV> findAllBaseConfig();
  
  public abstract Object getObjectBySql(String paramString);
  
  public abstract Integer getCount(String paramString);
  
  public abstract List getRatioTypeList(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.IBaseConfigDao
 * JD-Core Version:    0.7.0.1
 */