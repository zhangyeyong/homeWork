package com.zte.eas.resconfig.business.numberrule.service;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.resconfig.access.numberrule.dao.IFbpNumberRuleDetailsDAO;
import com.zte.eas.resconfig.access.numberrule.dao.IFbpNumberRulesDAO;
import com.zte.eas.resconfig.access.numberrule.dao.IFbpNumberRulesVDAO;
import com.zte.eas.resconfig.business.lookup.model.FbpLookupValuesV;
import com.zte.eas.resconfig.business.lookup.service.IFbpLookupTypesDS;
import com.zte.eas.resconfig.business.numberrule.model.FbpNumberRuleDetails;
import com.zte.eas.resconfig.business.numberrule.model.FbpNumberRules;
import com.zte.eas.resconfig.business.numberrule.model.FbpNumberRulesV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.exportExcel.tableModel.optionsModel;
import com.zte.ssb.exportExcel.tableModel.selectModel;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.ssb.zorm.util.StringHelper;
import java.io.PrintStream;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class FbpNumberRulesDS
  extends BaseDomainService
  implements IFbpNumberRulesDS, IFbpNumberRuleMgr
{
  private IFbpNumberRulesDAO numberRulesDAO;
  private IFbpNumberRuleDetailsDAO numberRuleDetailsDAO;
  private IFbpNumberRulesVDAO fbpNumberRulesVDAO;
  static final int DATA_COUNT = 40;
  static final int ROW_COUNT = 10;
  static final String EASLOGIN_USERINFO = "easloginuserinfo";
  private int numberRuleIdValue = 0;
  static final String SAVEFILED = "savefild";
  static final String INSERTSUCCEED = "insertsucceed";
  static final String UPDATESUCCESS = "updatesuccess";
  static final String UPDATEFAILD = "updatefaild";
  static final String LOOKUPTYPE = "CONN_CHAR";
  static final String BOECLASSCODE = "BOE_CLASS";
  static final String RULETYPE = "BOE_CLASS";
  private IFbpLookupTypesDS lookupTypesDS = null;
  static final String YO = "启用";
  static final String NO = "禁用";
  static final String RULENUM_REPEAT = "rulenum_repeat";
  static final String RULENAME_REPEAT = "rulename_repeat";
  static final String NUMBERCODEDW = "numbercodedw";
  static final String NUMBERDWBOE = "numberdwboe";
  static final String DEFAUTSELECTVALUE = "";
  
  public String saveNumberRule(FbpNumberRulesV paramFbpNumberRulesV, List<FbpNumberRuleDetails> paramList)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    FbpNumberRules localFbpNumberRules = new FbpNumberRules();
    if ((paramFbpNumberRulesV.getNumberRuleId() == null) || (paramFbpNumberRulesV.getNumberRuleId().equals(new Long(this.numberRuleIdValue))))
    {
      localFbpNumberRules.setStartDate(new Date());
      localFbpNumberRules.setLastUpdateDate(new Date());
      localFbpNumberRules.setLastUpdatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    }
    else
    {
      localFbpNumberRules.setNumberRuleId(paramFbpNumberRulesV.getNumberRuleId());
    }
    localFbpNumberRules.setBoeClassCode(paramFbpNumberRulesV.getBoeClassCode());
    System.out.println(" o.getConnectChar()= " + paramFbpNumberRulesV.getConnectChar());
    localFbpNumberRules.setConnectChar(paramFbpNumberRulesV.getConnectChar());
    localFbpNumberRules.setCreatedBy(paramFbpNumberRulesV.getCreatedBy());
    localFbpNumberRules.setLastUpdateDate(new Date());
    localFbpNumberRules.setStartDate(paramFbpNumberRulesV.getStartDate());
    localFbpNumberRules.setEndDate(paramFbpNumberRulesV.getEndDate());
    localFbpNumberRules.setCreationDate(new Date());
    localFbpNumberRules.setNumberRuleCode(paramFbpNumberRulesV.getNumberRuleCode());
    localFbpNumberRules.setNumberRuleName(paramFbpNumberRulesV.getNumberRuleName());
    localFbpNumberRules.setEnabledFlag(paramFbpNumberRulesV.getEnabledFlag());
    localFbpNumberRules.setCreatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    localFbpNumberRules.setLastUpdatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
    List localList;
    if (localFbpNumberRules.getNumberRuleId() == null)
    {
      if (IsEmpty("", paramFbpNumberRulesV.getNumberRuleCode())) {
        return "rulenum_repeat";
      }
      if (IsEmpty(paramFbpNumberRulesV.getNumberRuleName(), "")) {
        return "rulename_repeat";
      }
      if (listDw(paramFbpNumberRulesV.getMeaning())) {
        return "numberdwboe";
      }
      if ("Y".equals(paramFbpNumberRulesV.getEnabledFlag()))
      {
        localList = IsNumberCodeDw(paramFbpNumberRulesV);
        if ((localList != null) && (localList.size() > 0))
        {
          localObject1 = "";
          localObject2 = (FbpNumberRulesV)localList.get(0);
          if (localObject2 != null) {
            localObject1 = "numbercodedw" + ((FbpNumberRulesV)localObject2).getNumberRuleCode();
          }
          return localObject1;
        }
      }
      this.numberRulesDAO.insertFbpNumberRules(localFbpNumberRules);
    }
    else
    {
      if ("Y".equals(paramFbpNumberRulesV.getEnabledFlag()))
      {
        localList = IsNumberCodeDw(paramFbpNumberRulesV);
        if ((localList != null) && (localList.size() > 0))
        {
          localObject1 = "";
          localObject2 = (FbpNumberRulesV)localList.get(0);
          if (localObject2 != null) {
            localObject1 = "numbercodedw" + ((FbpNumberRulesV)localObject2).getNumberRuleCode();
          }
          return localObject1;
        }
      }
      this.numberRulesDAO.updateFbpNumberRules(localFbpNumberRules);
    }
    int i = paramList.size();
    Object localObject1 = new int[i];
    Object localObject2 = new FbpNumberRuleDetails();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    for (int j = 0; j < paramList.size(); j++)
    {
      localObject2 = (FbpNumberRuleDetails)paramList.get(j);
      ((FbpNumberRuleDetails)localObject2).setLastUpdateDate(new Date());
      ((FbpNumberRuleDetails)localObject2).setCreationDate(new Date());
      ((FbpNumberRuleDetails)localObject2).setLastUpdatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
      ((FbpNumberRuleDetails)localObject2).setCreatedBy(Long.valueOf(localEasUserInfo.getUserInfoPk().longValue()));
      ((FbpNumberRuleDetails)localObject2).setNumberRuleId(localFbpNumberRules.getNumberRuleId());
      if (paramFbpNumberRulesV.getEndDate() != null)
      {
        if (paramFbpNumberRulesV.getEndDate().before(new Date())) {
          ((FbpNumberRuleDetails)localObject2).setEnabledFlag("N");
        } else {
          ((FbpNumberRuleDetails)localObject2).setEnabledFlag(paramFbpNumberRulesV.getEnabledFlag());
        }
      }
      else {
        ((FbpNumberRuleDetails)localObject2).setEnabledFlag(paramFbpNumberRulesV.getEnabledFlag());
      }
      ((FbpNumberRuleDetails)localObject2).setRuleType(((FbpNumberRuleDetails)localObject2).getRuleType());
      ((FbpNumberRuleDetails)localObject2).setRuleValue(((FbpNumberRuleDetails)localObject2).getRuleValue());
      try
      {
        localObject1[j] = ((FbpNumberRuleDetails)localObject2).getLineNum().intValue();
        ((FbpNumberRuleDetails)localObject2).setLineNum(((FbpNumberRuleDetails)localObject2).getLineNum());
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        return "savefild";
      }
      if (((FbpNumberRuleDetails)localObject2).getRuleDetailId() == null) {
        localArrayList1.add(localObject2);
      } else {
        localArrayList2.add(localObject2);
      }
    }
    try
    {
      System.out.print("=========================" + localArrayList1.size());
      boolean bool = isSuccessByCheckedLineNum((int[])localObject1);
      if (!bool) {
        return "savefild";
      }
      if (localArrayList1.size() > 0)
      {
        this.numberRuleDetailsDAO.insertFbpNumberRuleDetail(localArrayList1);
        return "insertsucceed";
      }
      try
      {
        if (localArrayList2.size() > 0) {
          for (int k = 0; k < localArrayList2.size(); k++)
          {
            FbpNumberRuleDetails localFbpNumberRuleDetails = (FbpNumberRuleDetails)localArrayList2.get(k);
            this.numberRuleDetailsDAO.update(localFbpNumberRuleDetails);
          }
        }
        return "updatesuccess";
      }
      catch (Exception localException3)
      {
        return "updatefaild";
      }
      return "savefild";
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
  }
  
  public FbpNumberRulesV findNumberRuleById(String paramString)
  {
    FbpNumberRulesV localFbpNumberRulesV = new FbpNumberRulesV();
    if (!StringHelper.isEmpty(paramString)) {
      localFbpNumberRulesV = this.fbpNumberRulesVDAO.findFbpNumberRulesVById(paramString);
    }
    if (localFbpNumberRulesV.getEndDate() != null)
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String str1 = localSimpleDateFormat.format(new Date());
      String str2 = localSimpleDateFormat.format(localFbpNumberRulesV.getEndDate());
      DateFormat localDateFormat = DateFormat.getDateTimeInstance();
      try
      {
        if (localDateFormat.parse(str2).before(localDateFormat.parse(str1))) {
          localFbpNumberRulesV.setEnabledFlag("N");
        }
      }
      catch (ParseException localParseException)
      {
        localParseException.printStackTrace();
      }
    }
    return localFbpNumberRulesV;
  }
  
  public List<FbpNumberRuleDetails> findRuleDetailId(String paramString)
  {
    Object localObject = new ArrayList();
    FbpNumberRuleDetails localFbpNumberRuleDetails = new FbpNumberRuleDetails();
    if (!StringHelper.isEmpty(paramString))
    {
      localObject = this.numberRuleDetailsDAO.findRuleDetailsByRuleId(paramString);
      for (int i = 0; i < ((List)localObject).size(); i++)
      {
        selectModel localselectModel = new selectModel();
        localFbpNumberRuleDetails = (FbpNumberRuleDetails)((List)localObject).get(i);
        localselectModel.setSelectValue(localFbpNumberRuleDetails.getRuleType());
        this.lookupTypesDS = ((IFbpLookupTypesDS)SSBBus.findCommonService("lookupTypesDS"));
        List localList = this.lookupTypesDS.findLookupValuesByType("RULE_TYPE");
        ArrayList localArrayList = new ArrayList();
        FbpLookupValuesV localFbpLookupValuesV = new FbpLookupValuesV();
        for (int j = 0; j < localList.size(); j++)
        {
          optionsModel localoptionsModel = new optionsModel();
          localFbpLookupValuesV = (FbpLookupValuesV)localList.get(j);
          localoptionsModel.setValue(localFbpLookupValuesV.getLookupCode());
          localoptionsModel.setText(localFbpLookupValuesV.getMeaning());
          localArrayList.add(localoptionsModel);
        }
        localselectModel.setOptions(localArrayList);
        localFbpNumberRuleDetails.setRuleTypeSelect(localselectModel);
      }
    }
    return localObject;
  }
  
  public TableDataInfo findNumberRules(FbpNumberRulesV paramFbpNumberRulesV, String paramString1, String paramString2)
  {
    PageInfo localPageInfo = this.fbpNumberRulesVDAO.findFbpNumberRulesVsByCond(paramFbpNumberRulesV, new Integer(paramString1).intValue(), new Integer(paramString2).intValue());
    List localList = (List)localPageInfo.getResult();
    for (int i = 0; i < localList.size(); i++)
    {
      FbpNumberRulesV localFbpNumberRulesV = (FbpNumberRulesV)localList.get(i);
      if (localFbpNumberRulesV.getEnabledFlag().equalsIgnoreCase("Y")) {
        localFbpNumberRulesV.setEnabledFlag("启用");
      }
      if (localFbpNumberRulesV.getEnabledFlag().equalsIgnoreCase("N")) {
        localFbpNumberRulesV.setEnabledFlag("禁用");
      }
      if (localFbpNumberRulesV.getEndDate() != null)
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str1 = localSimpleDateFormat.format(new Date());
        String str2 = localSimpleDateFormat.format(localFbpNumberRulesV.getEndDate());
        DateFormat localDateFormat = DateFormat.getDateTimeInstance();
        try
        {
          if (localDateFormat.parse(str2).before(localDateFormat.parse(str1))) {
            localFbpNumberRulesV.setEnabledFlag("禁用");
          }
        }
        catch (ParseException localParseException)
        {
          localParseException.printStackTrace();
        }
      }
    }
    TableDataInfo localTableDataInfo = new TableDataInfo();
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  private boolean IsEmpty(String paramString1, String paramString2)
  {
    List localList = this.numberRulesDAO.findFbpNumberRuless(paramString1, paramString2);
    return localList.size() > 0;
  }
  
  private List<FbpNumberRulesV> IsNumberCodeDw(FbpNumberRulesV paramFbpNumberRulesV)
  {
    List localList = this.fbpNumberRulesVDAO.findCodeDw(paramFbpNumberRulesV);
    return localList;
  }
  
  private FbpNumberRules findNumberRuleByIds(String paramString)
  {
    FbpNumberRules localFbpNumberRules = new FbpNumberRules();
    if ((paramString != null) || (!paramString.equals(""))) {
      localFbpNumberRules = this.numberRulesDAO.findFbpNumberRules(paramString);
    }
    return localFbpNumberRules;
  }
  
  public HashMap findLookupValuesForSelectCtr(String paramString)
  {
    FbpNumberRules localFbpNumberRules = findNumberRuleByIds(paramString);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str = "";
    this.lookupTypesDS = ((IFbpLookupTypesDS)SSBBus.findCommonService("lookupTypesDS"));
    List localList = this.lookupTypesDS.findLookupValuesByType("CONN_CHAR");
    FbpLookupValuesV localFbpLookupValuesV = new FbpLookupValuesV();
    for (int i = 0; i < localList.size(); i++)
    {
      localFbpLookupValuesV = (FbpLookupValuesV)localList.get(i);
      localArrayList1.add(localFbpLookupValuesV.getMeaning());
      localArrayList2.add(localFbpLookupValuesV.getLookupCode());
    }
    str = localFbpNumberRules.getConnectChar();
    localHashMap.put("selectText", localArrayList1);
    localHashMap.put("selectValue", localArrayList2);
    localHashMap.put("selectDefault", str);
    return localHashMap;
  }
  
  public HashMap findLookupValuesBoeClasscode(String paramString)
  {
    FbpNumberRules localFbpNumberRules = findNumberRuleByIds(paramString);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str = "";
    this.lookupTypesDS = ((IFbpLookupTypesDS)SSBBus.findCommonService("lookupTypesDS"));
    List localList = this.lookupTypesDS.findLookupValuesByType("BOE_CLASS");
    FbpLookupValuesV localFbpLookupValuesV = new FbpLookupValuesV();
    for (int i = 0; i < localList.size(); i++)
    {
      localFbpLookupValuesV = (FbpLookupValuesV)localList.get(i);
      localArrayList1.add(localFbpLookupValuesV.getMeaning());
      localArrayList2.add(localFbpLookupValuesV.getLookupCode());
    }
    str = localFbpNumberRules.getBoeClassCode();
    localHashMap.put("selectText", localArrayList1);
    localHashMap.put("selectValue", localArrayList2);
    localHashMap.put("selectDefault", str);
    return localHashMap;
  }
  
  public String produceNumberByRuleId(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str = "";
    str = this.numberRulesDAO.getBoeTypeCode(paramString1, paramString2, paramString3, paramString4, paramString5);
    return str;
  }
  
  public boolean listDw(String paramString)
  {
    List localList = this.fbpNumberRulesVDAO.findFbpNumberRulesBoe(paramString);
    return localList.size() > 0;
  }
  
  public FbpNumberRulesV getNumberCode()
  {
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "AA";
    FbpNumberRulesV localFbpNumberRulesV = new FbpNumberRulesV();
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    String str6 = this.numberRulesDAO.getBoeTypeCode(str1, str2, str3, str4, str5);
    localFbpNumberRulesV.setNumberRuleCode(str6);
    if ((str6 != null) && (!str6.equals(""))) {
      localISession.setSessionAttribute("fbpNumberRules", localFbpNumberRulesV);
    }
    return localFbpNumberRulesV;
  }
  
  public void deleteRows(String paramString)
  {
    this.numberRuleDetailsDAO.removeFbpNumberRuleDetail(Long.valueOf(paramString));
  }
  
  public IFbpNumberRulesDAO findNumberRulesDAO()
  {
    return this.numberRulesDAO;
  }
  
  public void setNumberRulesDAO(IFbpNumberRulesDAO paramIFbpNumberRulesDAO)
  {
    this.numberRulesDAO = paramIFbpNumberRulesDAO;
  }
  
  public IFbpNumberRuleDetailsDAO getNumberRuleDetailsDAO()
  {
    return this.numberRuleDetailsDAO;
  }
  
  public void setNumberRuleDetailsDAO(IFbpNumberRuleDetailsDAO paramIFbpNumberRuleDetailsDAO)
  {
    this.numberRuleDetailsDAO = paramIFbpNumberRuleDetailsDAO;
  }
  
  public IFbpNumberRulesVDAO getFbpNumberRulesVDAO()
  {
    return this.fbpNumberRulesVDAO;
  }
  
  public void setFbpNumberRulesVDAO(IFbpNumberRulesVDAO paramIFbpNumberRulesVDAO)
  {
    this.fbpNumberRulesVDAO = paramIFbpNumberRulesVDAO;
  }
  
  public IFbpNumberRulesDAO getNumberRulesDAO()
  {
    return this.numberRulesDAO;
  }
  
  public boolean isSuccessByCheckedLineNum(int[] paramArrayOfInt)
  {
    boolean bool = true;
    for (int j = 0; j < paramArrayOfInt.length; j++) {
      for (int k = j + 1; k < paramArrayOfInt.length; k++) {
        if (paramArrayOfInt[j] > paramArrayOfInt[k])
        {
          int i = paramArrayOfInt[k];
          paramArrayOfInt[k] = paramArrayOfInt[j];
          paramArrayOfInt[j] = i;
        }
      }
    }
    for (j = 0; (j < paramArrayOfInt.length) && (j != paramArrayOfInt.length - 1); j++) {
      if (paramArrayOfInt[j] == paramArrayOfInt[(j + 1)])
      {
        bool = false;
        break;
      }
    }
    return bool;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.numberrule.service.FbpNumberRulesDS
 * JD-Core Version:    0.7.0.1
 */