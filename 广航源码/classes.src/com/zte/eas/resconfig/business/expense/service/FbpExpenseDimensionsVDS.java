package com.zte.eas.resconfig.business.expense.service;

import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.resconfig.access.expense.dao.IFbpExpenseDimRelationsDAO;
import com.zte.eas.resconfig.access.expense.dao.IFbpExpenseDimensionsDAO;
import com.zte.eas.resconfig.access.expense.dao.IFbpExpenseDimensionsVDAO;
import com.zte.eas.resconfig.business.expense.model.FbpExpenseDimRelations;
import com.zte.eas.resconfig.business.expense.model.FbpExpenseDimensions;
import com.zte.eas.resconfig.business.expense.model.FbpExpenseDimensionsV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FbpExpenseDimensionsVDS
  extends BaseDomainService
  implements IFbpExpenseDimensionsVDS
{
  private IFbpExpenseDimensionsVDAO fbpExpenseDimensionsVDAO;
  private IFbpExpenseDimensionsDAO fbpExpenseDimensionsDAO;
  private IFbpExpenseDimRelationsDAO fbpExpenseDimRelationsDAO;
  static final String DO = "启用";
  static final String BAN = "禁用";
  static final String ENABLEFLAG = "Y";
  static final String CLASHFAILNAME = "CLASHFAILNAME";
  static final String CLASHFAILCODE = "CLASHFAILCODE";
  static final String SAVESUCCESS = "SAVESUCCESS";
  static final String SAVEFAIL = "SAVEFAIL";
  static final String EXPENSE_ID = "expenseId";
  static final String MESSAGE = "message";
  static final String SAVEACCOUNT = "SAVEACCOUNT";
  
  public IFbpExpenseDimRelationsDAO getFbpExpenseDimRelationsDAO()
  {
    return this.fbpExpenseDimRelationsDAO;
  }
  
  public void setFbpExpenseDimRelationsDAO(IFbpExpenseDimRelationsDAO paramIFbpExpenseDimRelationsDAO)
  {
    this.fbpExpenseDimRelationsDAO = paramIFbpExpenseDimRelationsDAO;
  }
  
  public IFbpExpenseDimensionsVDAO getFbpExpenseDimensionsVDAO()
  {
    return this.fbpExpenseDimensionsVDAO;
  }
  
  public void setFbpExpenseDimensionsVDAO(IFbpExpenseDimensionsVDAO paramIFbpExpenseDimensionsVDAO)
  {
    this.fbpExpenseDimensionsVDAO = paramIFbpExpenseDimensionsVDAO;
  }
  
  public IFbpExpenseDimensionsDAO getFbpExpenseDimensionsDAO()
  {
    return this.fbpExpenseDimensionsDAO;
  }
  
  public void setFbpExpenseDimensionsDAO(IFbpExpenseDimensionsDAO paramIFbpExpenseDimensionsDAO)
  {
    this.fbpExpenseDimensionsDAO = paramIFbpExpenseDimensionsDAO;
  }
  
  public List<FbpExpenseDimensionsV> getFbpExpenseDimensionsVs(int paramInt1, int paramInt2)
  {
    return this.fbpExpenseDimensionsVDAO.getFbpExpenseDimensionsVs(paramInt1, paramInt2);
  }
  
  public List<FbpExpenseDimensionsV> getFbpExpenseDimensionsVs()
  {
    return this.fbpExpenseDimensionsVDAO.getFbpExpenseDimensionsVs();
  }
  
  public FbpExpenseDimensionsV getFbpExpenseDimensionsV(Long paramLong)
  {
    return this.fbpExpenseDimensionsVDAO.getFbpExpenseDimensionsV(paramLong);
  }
  
  public void removeFbpExpenseDimensionsV(Long paramLong)
  {
    this.fbpExpenseDimensionsVDAO.removeFbpExpenseDimensionsV(paramLong);
  }
  
  public void removeFbpExpenseDimensionsV(FbpExpenseDimensionsV paramFbpExpenseDimensionsV)
  {
    this.fbpExpenseDimensionsVDAO.removeFbpExpenseDimensionsV(paramFbpExpenseDimensionsV);
  }
  
  public void insertFbpExpenseDimensionsV(FbpExpenseDimensionsV paramFbpExpenseDimensionsV)
  {
    this.fbpExpenseDimensionsVDAO.insertFbpExpenseDimensionsV(paramFbpExpenseDimensionsV);
  }
  
  public void updateFbpExpenseDimensionsV(FbpExpenseDimensionsV paramFbpExpenseDimensionsV)
  {
    this.fbpExpenseDimensionsVDAO.updateFbpExpenseDimensionsV(paramFbpExpenseDimensionsV);
  }
  
  public void insertFbpExpenseDimensionsVs(List<FbpExpenseDimensionsV> paramList)
  {
    this.fbpExpenseDimensionsVDAO.insertFbpExpenseDimensionsVs(paramList);
  }
  
  public void removeFbpExpenseDimensionsVs(List<FbpExpenseDimensionsV> paramList)
  {
    this.fbpExpenseDimensionsVDAO.removeFbpExpenseDimensionsVs(paramList);
  }
  
  public void updateFbpExpenseDimensionsVs(List<FbpExpenseDimensionsV> paramList)
  {
    this.fbpExpenseDimensionsVDAO.updateFbpExpenseDimensionsVs(paramList);
  }
  
  public TableDataInfo findFbpExpenseDimensionsVByCon(FbpExpenseDimensionsV paramFbpExpenseDimensionsV, int paramInt1, int paramInt2)
  {
    PageInfo localPageInfo = this.fbpExpenseDimensionsVDAO.findFbpExpenseDimensionsVByCon(paramFbpExpenseDimensionsV, paramInt1, paramInt2);
    List localList = (List)localPageInfo.getResult();
    for (int i = 0; i < localList.size(); i++)
    {
      FbpExpenseDimensionsV localFbpExpenseDimensionsV = (FbpExpenseDimensionsV)localList.get(i);
      if ("Y".equals(localFbpExpenseDimensionsV.getEnabledFlag())) {
        localFbpExpenseDimensionsV.setEnabledFlag("启用");
      } else {
        localFbpExpenseDimensionsV.setEnabledFlag("禁用");
      }
    }
    TableDataInfo localTableDataInfo = new TableDataInfo();
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public Map<String, Object> saveExpenseDimension(FbpExpenseDimensionsV paramFbpExpenseDimensionsV)
  {
    HashMap localHashMap = new HashMap();
    String str = "";
    long l = 0L;
    if (null != paramFbpExpenseDimensionsV.getExpenseId()) {
      l = paramFbpExpenseDimensionsV.getExpenseId().longValue();
    }
    if (ISClashCode(paramFbpExpenseDimensionsV.getExpenseCode(), Long.valueOf(l))) {
      str = "CLASHFAILCODE";
    }
    if (ISClashName(paramFbpExpenseDimensionsV.getExpenseName(), Long.valueOf(l))) {
      str = "CLASHFAILNAME";
    }
    if ((!"CLASHFAILCODE".equals(str)) && (!"CLASHFAILNAME".equals(str)))
    {
      String[] arrayOfString = paramFbpExpenseDimensionsV.getAccountId().split(",");
      try
      {
        if (arrayOfString.length > 1)
        {
          str = checkSubjectRelations(paramFbpExpenseDimensionsV);
          if ("SAVEACCOUNT".equals(str))
          {
            localHashMap.put("message", str);
            return localHashMap;
          }
        }
        FbpExpenseDimensions localFbpExpenseDimensions = saveFbpExpenseDimensions(paramFbpExpenseDimensionsV);
        saveRelationExpenseDims(arrayOfString, localFbpExpenseDimensions.getExpenseId());
        if (l <= 0L) {
          l = localFbpExpenseDimensions.getExpenseId().longValue();
        }
        str = "SAVESUCCESS";
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        str = "SAVEFAIL";
      }
    }
    localHashMap.put("expenseId", Long.valueOf(l));
    localHashMap.put("message", str);
    return localHashMap;
  }
  
  public TableDataInfo findFbpExpenseRelationVByExpenseId(String paramString, int paramInt1, int paramInt2)
  {
    PageInfo localPageInfo = this.fbpExpenseDimensionsVDAO.findFbpExpenseRelationVByExpenseId(Long.valueOf(paramString), paramInt1, paramInt2);
    TableDataInfo localTableDataInfo = new TableDataInfo();
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public String addByExpenseIdAndRelatedId(String paramString1, String paramString2)
  {
    try
    {
      String[] arrayOfString = paramString2.split(",");
      for (int i = 0; i < arrayOfString.length; i++) {
        if (!"".equals(arrayOfString[i]))
        {
          FbpExpenseDimRelations localFbpExpenseDimRelations = new FbpExpenseDimRelations();
          ObjectCopyUtils.setWho(localFbpExpenseDimRelations);
          localFbpExpenseDimRelations.setEnabledFlag("Y");
          localFbpExpenseDimRelations.setExpenseId(Long.valueOf(paramString1));
          localFbpExpenseDimRelations.setAccountId(Long.valueOf(arrayOfString[i]));
          this.fbpExpenseDimRelationsDAO.insertFbpExpenseDimRelations(localFbpExpenseDimRelations);
        }
      }
      return "SAVESUCCESS";
    }
    catch (Exception localException) {}
    return "SAVEFAIL";
  }
  
  public String deleteRults(String paramString)
  {
    try
    {
      this.fbpExpenseDimRelationsDAO.removeFbpExpenseDimRelations(Long.valueOf(paramString));
      return "SAVESUCCESS";
    }
    catch (Exception localException) {}
    return "SAVEFAIL";
  }
  
  private void saveRelationExpenseDims(String[] paramArrayOfString, Long paramLong)
  {
    if ((null != paramLong) && (paramLong.longValue() > 0L))
    {
      List localList = this.fbpExpenseDimRelationsDAO.findByExpenseId(paramLong);
      this.fbpExpenseDimRelationsDAO.removeFbpExpenseDimRelationss(localList);
    }
    for (int i = 0; i < paramArrayOfString.length; i++) {
      if (!"".equals(paramArrayOfString[i]))
      {
        FbpExpenseDimRelations localFbpExpenseDimRelations = new FbpExpenseDimRelations();
        ObjectCopyUtils.setWho(localFbpExpenseDimRelations);
        localFbpExpenseDimRelations.setEnabledFlag("Y");
        localFbpExpenseDimRelations.setExpenseId(paramLong);
        localFbpExpenseDimRelations.setAccountId(Long.valueOf(paramArrayOfString[i]));
        this.fbpExpenseDimRelationsDAO.insertFbpExpenseDimRelations(localFbpExpenseDimRelations);
      }
    }
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  private FbpExpenseDimensions saveFbpExpenseDimensions(FbpExpenseDimensionsV paramFbpExpenseDimensionsV)
  {
    Long localLong = Long.valueOf(0L);
    if (null != paramFbpExpenseDimensionsV.getExpenseId()) {
      localLong = paramFbpExpenseDimensionsV.getExpenseId();
    }
    FbpExpenseDimensions localFbpExpenseDimensions = new FbpExpenseDimensions();
    localFbpExpenseDimensions.setExpenseCode(paramFbpExpenseDimensionsV.getExpenseCode());
    localFbpExpenseDimensions.setExpenseName(paramFbpExpenseDimensionsV.getExpenseName());
    localFbpExpenseDimensions.setEnabledFlag(paramFbpExpenseDimensionsV.getEnabledFlag());
    ObjectCopyUtils.setWho(localFbpExpenseDimensions);
    if (localLong.longValue() <= 0L)
    {
      this.fbpExpenseDimensionsDAO.insertFbpExpenseDimensions(localFbpExpenseDimensions);
    }
    else
    {
      localFbpExpenseDimensions.setExpenseId(localLong);
      this.fbpExpenseDimensionsDAO.updateFbpExpenseDimensions(localFbpExpenseDimensions);
    }
    return localFbpExpenseDimensions;
  }
  
  private boolean ISClashCode(String paramString, Long paramLong)
  {
    FbpExpenseDimensions localFbpExpenseDimensions = new FbpExpenseDimensions();
    localFbpExpenseDimensions.setExpenseCode(paramString);
    localFbpExpenseDimensions.setExpenseId(paramLong);
    List localList = this.fbpExpenseDimensionsDAO.findFbpExpenseDimensions(localFbpExpenseDimensions);
    return localList.size() > 0;
  }
  
  private boolean ISClashName(String paramString, Long paramLong)
  {
    FbpExpenseDimensions localFbpExpenseDimensions = new FbpExpenseDimensions();
    localFbpExpenseDimensions.setExpenseName(paramString);
    localFbpExpenseDimensions.setExpenseId(paramLong);
    List localList = this.fbpExpenseDimensionsDAO.findFbpExpenseDimensions(localFbpExpenseDimensions);
    return localList.size() > 0;
  }
  
  public String checkSubject(String paramString)
  {
    List localList = this.fbpExpenseDimensionsVDAO.findFbpExpenseDimRelationByAccount(Long.valueOf(paramString));
    if (localList.size() > 0) {
      return "Y";
    }
    return null;
  }
  
  public FbpExpenseDimensionsV getFbpExpenseDimensionsVByExpenseId(String paramString)
  {
    return getFbpExpenseDimensionsV(Long.valueOf(paramString));
  }
  
  public String checkSubjectRelations(FbpExpenseDimensionsV paramFbpExpenseDimensionsV)
  {
    if ((paramFbpExpenseDimensionsV.getExpenseId() != null) && (paramFbpExpenseDimensionsV.getExpenseId().longValue() > 0L)) {
      synchronized (this)
      {
        List localList = this.fbpExpenseDimensionsVDAO.findRelationSubject(paramFbpExpenseDimensionsV);
        if (localList.size() > 0) {
          return "SAVEACCOUNT";
        }
      }
    }
    return "SAVESUCCESS";
  }
  
  public Map<String, Object> updateExpenseDimension(FbpExpenseDimensionsV paramFbpExpenseDimensionsV)
  {
    HashMap localHashMap = new HashMap();
    String str = "";
    long l = 0L;
    if (null != paramFbpExpenseDimensionsV.getExpenseId()) {
      l = paramFbpExpenseDimensionsV.getExpenseId().longValue();
    }
    if (ISClashName(paramFbpExpenseDimensionsV.getExpenseName(), Long.valueOf(l))) {
      str = "CLASHFAILNAME";
    }
    if (!"CLASHFAILNAME".equals(str))
    {
      String[] arrayOfString = paramFbpExpenseDimensionsV.getAccountId().split(",");
      try
      {
        if (("Y".equals(paramFbpExpenseDimensionsV.getEnabledFlag())) && (arrayOfString.length > 1))
        {
          str = checkSubjectRelations(paramFbpExpenseDimensionsV);
          if ("SAVEACCOUNT".equals(str))
          {
            localHashMap.put("message", str);
            return localHashMap;
          }
        }
        FbpExpenseDimensions localFbpExpenseDimensions = saveFbpExpenseDimensions(paramFbpExpenseDimensionsV);
        if (l <= 0L) {
          l = localFbpExpenseDimensions.getExpenseId().longValue();
        }
        str = "SAVESUCCESS";
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        str = "SAVEFAIL";
      }
    }
    localHashMap.put("expenseId", Long.valueOf(l));
    localHashMap.put("message", str);
    return localHashMap;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.expense.service.FbpExpenseDimensionsVDS
 * JD-Core Version:    0.7.0.1
 */