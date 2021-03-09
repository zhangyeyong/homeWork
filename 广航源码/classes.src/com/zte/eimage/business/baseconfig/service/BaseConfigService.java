package com.zte.eimage.business.baseconfig.service;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eimage.access.baseconfig.dao.IBaseConfigDao;
import com.zte.eimage.business.baseconfig.model.BaseConfig;
import com.zte.eimage.business.baseconfig.model.BaseConfigV;
import com.zte.evs.ebill.model.eBillManage.FbfLookupValues;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.ssb.ssbext.resource.ComResUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BaseConfigService
  implements IBaseConfigService
{
  private IBaseConfigDao baseConfigDao;
  static final String EVS_LOGIN_USERINFO = "easloginuserinfo";
  
  public void insertBaseConfig(BaseConfig paramBaseConfig)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    paramBaseConfig.setLastUpdateLogin(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    paramBaseConfig.setLastUpdatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    paramBaseConfig.setLastUpdateDate(new Date());
    paramBaseConfig.setCreatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    paramBaseConfig.setCreationDate(new Date());
    this.baseConfigDao.insertBaseConfig(paramBaseConfig);
  }
  
  public void updateBaseConfig(BaseConfig paramBaseConfig)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    BaseConfig localBaseConfig = this.baseConfigDao.getBaseConfigById(paramBaseConfig.getBaseConfigId());
    localBaseConfig.setBaseConfigName(paramBaseConfig.getBaseConfigName());
    localBaseConfig.setLuminance(paramBaseConfig.getLuminance());
    localBaseConfig.setPicType(paramBaseConfig.getPicType());
    localBaseConfig.setContrast(paramBaseConfig.getContrast());
    localBaseConfig.setResRatio(paramBaseConfig.getResRatio());
    localBaseConfig.setThreshold(paramBaseConfig.getThreshold());
    localBaseConfig.setColor(paramBaseConfig.getColor());
    localBaseConfig.setCompressRatio(paramBaseConfig.getCompressRatio());
    localBaseConfig.setSideType(paramBaseConfig.getSideType());
    localBaseConfig.setIsDelBlankPage(paramBaseConfig.getIsDelBlankPage());
    localBaseConfig.setIsDefault(paramBaseConfig.getIsDefault());
    localBaseConfig.setEnabledFlag(paramBaseConfig.getEnabledFlag());
    localBaseConfig.setLastUpdateLogin(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    localBaseConfig.setLastUpdatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    localBaseConfig.setLastUpdateDate(new Date());
    this.baseConfigDao.updateBaseConfig(localBaseConfig);
  }
  
  public BaseConfig getBaseConfigById(String paramString)
  {
    return this.baseConfigDao.getBaseConfigById(Integer.valueOf(Integer.parseInt(paramString)));
  }
  
  public TableDataInfo findBaseConfig(BaseConfig paramBaseConfig, String paramString1, String paramString2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.baseConfigDao.findBaseConfig(paramBaseConfig, Integer.valueOf(Integer.parseInt(paramString1)), Integer.valueOf(Integer.parseInt(paramString2)));
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public BaseConfigV getBaseConfigVById(String paramString)
  {
    String str = "FROM BaseConfigV b WHERE b.baseConfigId =" + paramString;
    return (BaseConfigV)this.baseConfigDao.getObjectBySql(str);
  }
  
  public Integer isExistsBaseConfigName(String paramString)
  {
    String str = "FROM BaseConfig b WHERE b.baseConfigName = '" + paramString.trim() + "'";
    Integer localInteger = this.baseConfigDao.getCount(str);
    return localInteger;
  }
  
  public Map getResRatio(String paramString)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    List localList = this.baseConfigDao.getRatioTypeList(paramString);
    localArrayList1.add(ComResUtil.getMessage("fbp.lookup.select"));
    localArrayList2.add("");
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FbfLookupValues localFbfLookupValues = (FbfLookupValues)localIterator.next();
        if (localFbfLookupValues != null)
        {
          localArrayList1.add(localFbfLookupValues.getMeaning() == null ? "" : localFbfLookupValues.getMeaning().trim());
          localArrayList2.add(localFbfLookupValues.getLookupCode());
        }
      }
    }
    localHashMap.put("selectText", localArrayList1);
    localHashMap.put("selectValue", localArrayList2);
    return localHashMap;
  }
  
  public IBaseConfigDao getBaseConfigDao()
  {
    return this.baseConfigDao;
  }
  
  public void setBaseConfigDao(IBaseConfigDao paramIBaseConfigDao)
  {
    this.baseConfigDao = paramIBaseConfigDao;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.BaseConfigService
 * JD-Core Version:    0.7.0.1
 */