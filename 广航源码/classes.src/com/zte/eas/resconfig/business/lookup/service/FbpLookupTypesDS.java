package com.zte.eas.resconfig.business.lookup.service;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.appframe.business.util.CacheUtils;
import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.organization.business.countcompanymanage.service.DataSourceU;
import com.zte.eas.resconfig.access.lookup.dao.IFbpLookupTypesDAO;
import com.zte.eas.resconfig.access.lookup.dao.IFbpLookupTypesVDAO;
import com.zte.eas.resconfig.access.lookup.dao.IFbpLookupValuesDAO;
import com.zte.eas.resconfig.access.lookup.dao.IFbpLookupValuesVDAO;
import com.zte.eas.resconfig.business.lookup.model.FbpLookupTypes;
import com.zte.eas.resconfig.business.lookup.model.FbpLookupValues;
import com.zte.eas.resconfig.business.lookup.model.FbpLookupValuesV;
import com.zte.eas.resconfig.business.lookup.model.ResConfigCon;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.ssb.ssbext.lang.LangType;
import com.zte.ssb.ssbext.lang.LangUtil;
import com.zte.ssb.ssbext.resource.ComResUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FbpLookupTypesDS
  extends BaseDomainService
  implements IFbpLookupTypesDS
{
  private IFbpLookupTypesDAO lookupTypesDAO;
  private IFbpLookupValuesDAO lookupValuesDAO;
  private IFbpLookupTypesVDAO lookupTypesVDAO;
  private IFbpLookupValuesVDAO lookupValuesVDAO;
  static final int DATA_COUNT = 10000;
  static final int ROW_COUNT = 10;
  static final String LOGIN_USERINFO = "loginuserinfo";
  static final String EAS_LOGIN_USERINFO = "easloginuserinfo";
  static final String SAVEFAIL = "SAVEFAIL";
  static final String INSERTSUCCEED = "INSERTSUCCEED";
  static final String UPDATESUCCEED = "UPDATESUCCEED";
  static final String CLASHFAIL = "CLASHFAIL";
  static final String ENABLEFLAG = "Y";
  static final String DO = "启用";
  static final String BAN = "禁用";
  static final String DEFAUTSELECTVALUE = "";
  static final String TRANSFERACCOUNTS = "转账";
  static final String TRANSFERACCOUNTSVALUE = "TRANSFER_ACCOUNTS";
  static final String SELECTALL = "全部";
  static final String CUSTOMIZATIONLEVEL = "CUSTOMIZATIONLEVEL";
  
  public void setFbpLookupTypesDAO(IFbpLookupTypesDAO paramIFbpLookupTypesDAO)
  {
    super.setDao(paramIFbpLookupTypesDAO);
    this.lookupTypesDAO = paramIFbpLookupTypesDAO;
  }
  
  public HashMap findLookupValuesForSelectCtr(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str = "";
    List localList = findLookupValuesByType(paramString1);
    FbpLookupValuesV localFbpLookupValuesV1 = new FbpLookupValuesV();
    ArrayList localArrayList3 = new ArrayList();
    localArrayList3.addAll(localList);
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FbpLookupValuesV localFbpLookupValuesV2 = (FbpLookupValuesV)((Iterator)localObject).next();
      if ((localFbpLookupValuesV2.getEnabledFlag() != null) && (!localFbpLookupValuesV2.getEnabledFlag().equals("Y"))) {
        localArrayList3.remove(localFbpLookupValuesV2);
      }
    }
    if ((paramString3 != null) && ("Y".equals(paramString3)))
    {
      localArrayList1.add(ComResUtil.getMessage("fbp.lookup.select"));
      localArrayList2.add("");
    }
    localObject = findLookupTypeByType(paramString1);
    if ("Y".equals(((FbpLookupTypes)localObject).getEnabledFlag())) {
      for (int i = 0; i < localArrayList3.size(); i++)
      {
        localFbpLookupValuesV1 = (FbpLookupValuesV)localArrayList3.get(i);
        localArrayList1.add(localFbpLookupValuesV1.getMeaning());
        localArrayList2.add(localFbpLookupValuesV1.getLookupCode());
      }
    }
    str = paramString2;
    localHashMap.put("selectText", localArrayList1);
    localHashMap.put("selectValue", localArrayList2);
    localHashMap.put("selectDefault", str);
    return localHashMap;
  }
  
  public HashMap findLookupValuesForSelectCtrForFascicule(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str = "";
    List localList = findLookupValuesByType(paramString1);
    FbpLookupValuesV localFbpLookupValuesV1 = new FbpLookupValuesV();
    ArrayList localArrayList3 = new ArrayList();
    localArrayList3.addAll(localList);
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FbpLookupValuesV localFbpLookupValuesV2 = (FbpLookupValuesV)((Iterator)localObject).next();
      if ((localFbpLookupValuesV2.getEnabledFlag() != null) && (!localFbpLookupValuesV2.getEnabledFlag().equals("Y"))) {
        localArrayList3.remove(localFbpLookupValuesV2);
      }
    }
    if ((paramString3 != null) && ("Y".equals(paramString3)))
    {
      localArrayList1.add(ComResUtil.getMessage("fbp.lookup.select"));
      localArrayList2.add("");
    }
    localObject = findLookupTypeByType(paramString1);
    if ("Y".equals(((FbpLookupTypes)localObject).getEnabledFlag())) {
      for (int i = 0; i < localArrayList3.size(); i++)
      {
        localFbpLookupValuesV1 = (FbpLookupValuesV)localArrayList3.get(i);
        localArrayList1.add(localFbpLookupValuesV1.getMeaning());
        localArrayList2.add(localFbpLookupValuesV1.getLookupCode());
      }
    }
    str = paramString2;
    localHashMap.put("selectText", localArrayList1);
    localHashMap.put("selectValue", localArrayList2);
    localHashMap.put("selectDefault", str);
    return localHashMap;
  }
  
  public HashMap findLookupValuesForSelectCtr(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str = "";
    List localList = findLookupValuesByType(paramString1);
    FbpLookupValuesV localFbpLookupValuesV1 = new FbpLookupValuesV();
    ArrayList localArrayList3 = new ArrayList();
    localArrayList3.addAll(localList);
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FbpLookupValuesV localFbpLookupValuesV2 = (FbpLookupValuesV)((Iterator)localObject).next();
      if ((localFbpLookupValuesV2.getEnabledFlag() != null) && (!localFbpLookupValuesV2.getEnabledFlag().equals("Y"))) {
        localArrayList3.remove(localFbpLookupValuesV2);
      }
    }
    localArrayList1.add(ComResUtil.getMessage("fbp.lookup.select"));
    localArrayList2.add("");
    localObject = findLookupTypeByType(paramString1);
    if ("Y".equals(((FbpLookupTypes)localObject).getEnabledFlag())) {
      for (int i = 0; i < localArrayList3.size(); i++)
      {
        localFbpLookupValuesV1 = (FbpLookupValuesV)localArrayList3.get(i);
        localArrayList1.add(localFbpLookupValuesV1.getMeaning());
        localArrayList2.add(localFbpLookupValuesV1.getLookupCode());
      }
    }
    str = paramString2;
    localHashMap.put("selectText", localArrayList1);
    localHashMap.put("selectValue", localArrayList2);
    localHashMap.put("selectDefault", str);
    return localHashMap;
  }
  
  public HashMap findLookupValuesFor(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str = "";
    List localList = findLookupValuesByType(paramString1);
    FbpLookupValuesV localFbpLookupValuesV1 = new FbpLookupValuesV();
    ArrayList localArrayList3 = new ArrayList();
    localArrayList3.addAll(localList);
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FbpLookupValuesV localFbpLookupValuesV2 = (FbpLookupValuesV)((Iterator)localObject).next();
      if ((localFbpLookupValuesV2.getEnabledFlag() != null) && (!localFbpLookupValuesV2.getEnabledFlag().equals("Y"))) {
        localArrayList3.remove(localFbpLookupValuesV2);
      }
    }
    localArrayList1.add("转账");
    localArrayList2.add("TRANSFER_ACCOUNTS");
    localObject = findLookupTypeByType(paramString1);
    if ("Y".equals(((FbpLookupTypes)localObject).getEnabledFlag())) {
      for (int i = 0; i < localArrayList3.size(); i++)
      {
        localFbpLookupValuesV1 = (FbpLookupValuesV)localArrayList3.get(i);
        localArrayList1.add(localFbpLookupValuesV1.getMeaning());
        localArrayList2.add(localFbpLookupValuesV1.getLookupCode());
      }
    }
    str = paramString2;
    localHashMap.put("selectText", localArrayList1);
    localHashMap.put("selectValue", localArrayList2);
    localHashMap.put("selectDefault", str);
    return localHashMap;
  }
  
  public FbpLookupTypes findLookupTypeByType(String paramString)
  {
    if (paramString == null) {
      return new FbpLookupTypes();
    }
    ResConfigCon localResConfigCon = new ResConfigCon();
    localResConfigCon.setLookupType(paramString);
    List localList = this.lookupTypesDAO.findFbpLookupTypess(localResConfigCon);
    FbpLookupTypes localFbpLookupTypes = new FbpLookupTypes();
    if (localList.size() > 0) {
      localFbpLookupTypes = (FbpLookupTypes)localList.get(0);
    }
    return localFbpLookupTypes;
  }
  
  public List<FbpLookupValuesV> findLookupValuesByTypeForLookup(String paramString)
  {
    if (paramString == null) {
      return new ArrayList();
    }
    List localList = this.lookupValuesVDAO.findFbpLookupValuess(paramString);
    return localList;
  }
  
  public List<FbpLookupValuesV> findLookupValuesByType(String paramString)
  {
    if (paramString == null) {
      return new ArrayList();
    }
    List localList = this.lookupValuesVDAO.findFbpLookupValuess(paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(localList);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      FbpLookupValuesV localFbpLookupValuesV = (FbpLookupValuesV)localIterator.next();
      if ((localFbpLookupValuesV.getEnabledFlag() != null) && (!localFbpLookupValuesV.getEnabledFlag().equals("Y"))) {
        localArrayList.remove(localFbpLookupValuesV);
      }
    }
    return localArrayList;
  }
  
  public TableDataInfo findLookupTypesByCon(ResConfigCon paramResConfigCon, String paramString1, String paramString2)
  {
    String str = paramResConfigCon.getLookupType().toUpperCase();
    paramResConfigCon.setLookupType(str);
    PageInfo localPageInfo = this.lookupTypesVDAO.findLookupValuesByType(paramResConfigCon, new Integer(paramString1).intValue(), new Integer(paramString2).intValue());
    List localList = (List)localPageInfo.getResult();
    TableDataInfo localTableDataInfo = new TableDataInfo();
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public String saveLookup(FbpLookupTypes paramFbpLookupTypes, List<FbpLookupValues> paramList, String paramString)
  {
    if ((!"update".equals(paramString)) && (ISClash(paramFbpLookupTypes.getLookupType(), paramFbpLookupTypes.getDescription()))) {
      return "CLASHFAIL";
    }
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    List localList = LangUtil.listLangTypes();
    Object localObject1 = localList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (LangType)((Iterator)localObject1).next();
      for (int i = 0; i < paramList.size(); i++)
      {
        FbpLookupValues localFbpLookupValues1 = new FbpLookupValues();
        ObjectCopyUtils.copy(paramList.get(i), localFbpLookupValues1);
        localFbpLookupValues1.setCreationDate(new Date());
        localFbpLookupValues1.setLastUpdateDate(new Date());
        localFbpLookupValues1.setCreatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
        localFbpLookupValues1.setLastUpdatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
        localFbpLookupValues1.setLookupType(paramFbpLookupTypes.getLookupType());
        localFbpLookupValues1.setLanguage(DataSourceU.getLang(((LangType)localObject2).getCode()));
        localFbpLookupValues1.setSourceLang(DataSourceU.getLang(((LangType)localObject2).getCode()));
        if (localFbpLookupValues1.getLookupValueId() == null) {
          localArrayList1.add(localFbpLookupValues1);
        }
      }
    }
    try
    {
      if (!"update".equals(paramString))
      {
        paramFbpLookupTypes.setCreationDate(new Date());
        paramFbpLookupTypes.setLastUpdateDate(new Date());
        paramFbpLookupTypes.setCreatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
        paramFbpLookupTypes.setLastUpdatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
        this.lookupTypesDAO.insertFbpLookupTypes(paramFbpLookupTypes);
        if (localArrayList1 != null) {
          this.lookupValuesDAO.insertFbpLookupValuess(localArrayList1);
        }
        if (localArrayList2 != null) {
          this.lookupValuesDAO.updateFbpLookupValuess(localArrayList2);
        }
        CacheUtils.remove("LOOKUP_TYPE");
        return "INSERTSUCCEED";
      }
      localObject1 = new ResConfigCon();
      ((ResConfigCon)localObject1).setLookupType(paramFbpLookupTypes.getLookupType());
      localObject2 = this.lookupTypesDAO.findFbpLookupTypess((ResConfigCon)localObject1);
      FbpLookupTypes localFbpLookupTypes = new FbpLookupTypes();
      localFbpLookupTypes = (FbpLookupTypes)((List)localObject2).get(0);
      localFbpLookupTypes.setLastUpdateDate(new Date());
      localFbpLookupTypes.setLastUpdatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
      localFbpLookupTypes.setLookupType(paramFbpLookupTypes.getLookupType());
      localFbpLookupTypes.setDescription(paramFbpLookupTypes.getDescription());
      localFbpLookupTypes.setCustomizationLevel(paramFbpLookupTypes.getCustomizationLevel());
      localFbpLookupTypes.setEnabledFlag(paramFbpLookupTypes.getEnabledFlag());
      this.lookupTypesDAO.updateFbpLookupTypes(localFbpLookupTypes);
      if ((localArrayList1 != null) && (localArrayList1.size() > 0)) {
        this.lookupValuesDAO.insertFbpLookupValuess(localArrayList1);
      }
      for (int j = 0; j < paramList.size(); j++)
      {
        FbpLookupValues localFbpLookupValues2 = (FbpLookupValues)paramList.get(j);
        localFbpLookupValues2.setCreationDate(new Date());
        localFbpLookupValues2.setLastUpdateDate(new Date());
        localFbpLookupValues2.setCreatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
        localFbpLookupValues2.setLastUpdatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
        localFbpLookupValues2.setLookupType(paramFbpLookupTypes.getLookupType());
        localFbpLookupValues2.setLanguage(DataSourceU.getLang(LangUtil.getLocale()));
        localFbpLookupValues2.setSourceLang(DataSourceU.getLang(LangUtil.getLocale()));
        if (localFbpLookupValues2.getLookupValueId() != null) {
          localArrayList2.add(localFbpLookupValues2);
        }
      }
      if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
        this.lookupValuesDAO.updateFbpLookupValuess(localArrayList2);
      }
      CacheUtils.remove("LOOKUP_TYPE");
      return "UPDATESUCCEED";
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "SAVEFAIL";
  }
  
  private boolean ISClash(String paramString1, String paramString2)
  {
    ResConfigCon localResConfigCon = new ResConfigCon();
    localResConfigCon.setLookupType(paramString1.trim());
    List localList = this.lookupTypesDAO.findFbpLookupTypess(localResConfigCon);
    return localList.size() > 0;
  }
  
  public IFbpLookupTypesDAO getLookupTypesDAO()
  {
    return this.lookupTypesDAO;
  }
  
  public void setLookupTypesDAO(IFbpLookupTypesDAO paramIFbpLookupTypesDAO)
  {
    this.lookupTypesDAO = paramIFbpLookupTypesDAO;
  }
  
  public IFbpLookupValuesDAO getLookupValuesDAO()
  {
    return this.lookupValuesDAO;
  }
  
  public void setLookupValuesDAO(IFbpLookupValuesDAO paramIFbpLookupValuesDAO)
  {
    this.lookupValuesDAO = paramIFbpLookupValuesDAO;
  }
  
  public IFbpLookupValuesVDAO getLookupValuesVDAO()
  {
    return this.lookupValuesVDAO;
  }
  
  public void setLookupValuesVDAO(IFbpLookupValuesVDAO paramIFbpLookupValuesVDAO)
  {
    this.lookupValuesVDAO = paramIFbpLookupValuesVDAO;
  }
  
  public IFbpLookupTypesVDAO getLookupTypesVDAO()
  {
    return this.lookupTypesVDAO;
  }
  
  public void setLookupTypesVDAO(IFbpLookupTypesVDAO paramIFbpLookupTypesVDAO)
  {
    this.lookupTypesVDAO = paramIFbpLookupTypesVDAO;
  }
  
  public String clearCatches()
  {
    String str = "SUCCESS";
    try
    {
      CacheUtils.flush();
    }
    catch (RuntimeException localRuntimeException)
    {
      str = "FAIL";
      localRuntimeException.printStackTrace();
    }
    return str;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.lookup.service.FbpLookupTypesDS
 * JD-Core Version:    0.7.0.1
 */