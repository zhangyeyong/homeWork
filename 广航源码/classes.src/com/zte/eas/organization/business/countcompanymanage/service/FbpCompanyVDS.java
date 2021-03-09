package com.zte.eas.organization.business.countcompanymanage.service;

import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eas.organization.access.countcompanymanage.FbpCompanyDAO;
import com.zte.eas.organization.access.countcompanymanage.FbpCompanyTlDAO;
import com.zte.eas.organization.access.countcompanymanage.FbpCompanyVDAO;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompany;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyTl;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyTlPk;
import com.zte.eas.organization.business.countcompanymanage.model.FbpCompanyV;
import com.zte.eimage.access.baseconfig.dao.IImageCommonDAO;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.ssbext.lang.LangType;
import com.zte.ssb.ssbext.lang.LangUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FbpCompanyVDS
  implements IFbpCompanyVDS
{
  FbpCompanyVDAO fbpCompanyVDAO;
  FbpCompanyDAO fbpCompanyDAO;
  FbpCompanyTlDAO fbpCompanyTlDAO;
  protected Log log = LogFactory.getLog(getClass());
  private static final String ENABELD = "启用";
  private static final String SAME_COMPANY_CODE = "SAME_COMPANY_CODE";
  private static final String SAME_COMPANY_NAME = "SAME_COMPANY_NAME";
  private static final String SAVE_FAILED = "SAVE_FAILED";
  private static final String SAVE_SUCCEED = "SAVE_SUCCEED";
  private static final String DISABELD = "禁用";
  private static final String YES = "是";
  private static final String NO = "否";
  private static final String EMP_NOT_ONLY = "EMP_NOT_ONLY";
  
  public void setFbpCompanyVDAO(FbpCompanyVDAO paramFbpCompanyVDAO)
  {
    this.fbpCompanyVDAO = paramFbpCompanyVDAO;
  }
  
  public Map findCompanyByQry(FbpCompanyV paramFbpCompanyV, String paramString1, String paramString2)
  {
    Map localMap = this.fbpCompanyVDAO.findCompanyByQry(paramFbpCompanyV, new Integer(paramString1).intValue(), new Integer(paramString2).intValue());
    List localList = (List)localMap.get("data");
    if (localList != null) {
      setEnabled(localList);
    }
    localMap.put("data", localList);
    return localMap;
  }
  
  private void setEnabled(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      FbpCompanyV localFbpCompanyV = null;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localFbpCompanyV = (FbpCompanyV)localIterator.next();
        if ((localFbpCompanyV != null) && (localFbpCompanyV.getEnabledFlag() != null)) {
          if (localFbpCompanyV.getEnabledFlag().equalsIgnoreCase("Y")) {
            localFbpCompanyV.setEnabledFlag("启用");
          } else if (localFbpCompanyV.getEnabledFlag().equalsIgnoreCase("N")) {
            localFbpCompanyV.setEnabledFlag("禁用");
          }
        }
        if ((localFbpCompanyV != null) && (localFbpCompanyV.getIsCheck() != null)) {
          if (localFbpCompanyV.getIsCheck().equalsIgnoreCase("Y")) {
            localFbpCompanyV.setIsCheck("是");
          } else if (localFbpCompanyV.getIsCheck().equalsIgnoreCase("N")) {
            localFbpCompanyV.setIsCheck("否");
          }
        }
      }
    }
  }
  
  public FbpCompanyV findByCompId(String paramString)
  {
    FbpCompanyV localFbpCompanyV = this.fbpCompanyVDAO.findByCompId(new Long(paramString));
    return localFbpCompanyV;
  }
  
  public String saveFbpCompamyV(FbpCompanyV paramFbpCompanyV)
  {
    Object localObject1 = null;
    FbpCompany localFbpCompany1 = new FbpCompany();
    ObjectCopyUtils.copy(paramFbpCompanyV, localFbpCompany1);
    ObjectCopyUtils.setWho(localFbpCompany1);
    String str1 = "";
    String str2 = "";
    String str3 = "select * from fbp_company where company_code = ?";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramFbpCompanyV.getCompanyCode());
    IImageCommonDAO localIImageCommonDAO = (IImageCommonDAO)SSBBus.findDomainService("imageCommonDAO");
    List localList1 = localIImageCommonDAO.findObjectBySQL(str3, localArrayList, FbpCompany.class);
    String str4 = "0".equals(paramFbpCompanyV.getEnabledFlag()) ? "Y" : "N";
    FbpCompany localFbpCompany2;
    List localList2;
    Iterator localIterator;
    LangType localLangType;
    Object localObject2;
    Object localObject3;
    FbpCompanyTl localFbpCompanyTl;
    if ((localList1 != null) && (!localList1.isEmpty()))
    {
      localFbpCompany2 = (FbpCompany)localList1.get(0);
      localFbpCompany2.setLastUpdateDate(new Date());
      localFbpCompany2.setSuperCompanyName(paramFbpCompanyV.getSuperCompanyName());
      localFbpCompany2.setEnabledFlag(paramFbpCompanyV.getEnabledFlag());
      localFbpCompany2.setSetOfBooksCode(paramFbpCompanyV.getSetOfBooksCode());
      localFbpCompany2.setAttribute2(paramFbpCompanyV.getSetOfBooksCode());
      localFbpCompany2.setAttribute3(paramFbpCompanyV.getSetOfBooksName());
      this.fbpCompanyDAO.updateFbpCompany(localFbpCompany2);
      localList2 = LangUtil.listLangTypes();
      localIterator = localList2.iterator();
      while (localIterator.hasNext())
      {
        localLangType = (LangType)localIterator.next();
        localObject2 = new FbpCompanyTlPk();
        ((FbpCompanyTlPk)localObject2).setCompanyId(localFbpCompany2.getCompanyId());
        localObject3 = DataSourceU.getLang(localLangType.getCode());
        if (localObject3 != null)
        {
          ((FbpCompanyTlPk)localObject2).setLanguage((String)localObject3);
          localFbpCompanyTl = (FbpCompanyTl)this.fbpCompanyTlDAO.getObject(FbpCompanyTl.class, (Serializable)localObject2);
          if (localFbpCompanyTl != null)
          {
            localFbpCompanyTl.setLastUpdateDate(new Date());
            localFbpCompanyTl.setCompanyName(paramFbpCompanyV.getCompanyName());
            localFbpCompanyTl.setEnabledFlag(paramFbpCompanyV.getEnabledFlag());
            this.fbpCompanyTlDAO.updateObject(localFbpCompanyTl);
          }
          else
          {
            localFbpCompanyTl = new FbpCompanyTl();
            localFbpCompanyTl.setFbpCompanyTlPk((FbpCompanyTlPk)localObject2);
            ObjectCopyUtils.setWho(localFbpCompanyTl);
            localFbpCompanyTl.setCompanyName(paramFbpCompanyV.getCompanyName());
            localFbpCompanyTl.setSourceLang((String)localObject3);
            localFbpCompanyTl.setEnabledFlag(paramFbpCompanyV.getEnabledFlag());
            this.fbpCompanyTlDAO.insertFbpCompanyTl(localFbpCompanyTl);
          }
        }
      }
      str1 = localFbpCompany2.getCompanyId().toString();
    }
    else
    {
      localFbpCompany2 = new FbpCompany();
      ObjectCopyUtils.setWho(localFbpCompany2);
      localFbpCompany2.setCompanyCode(paramFbpCompanyV.getCompanyCode());
      localFbpCompany2.setEnabledFlag(paramFbpCompanyV.getEnabledFlag());
      localFbpCompany2.setSuperCompanyName(paramFbpCompanyV.getSuperCompanyName());
      localFbpCompany2.setSetOfBooksCode(paramFbpCompanyV.getSetOfBooksCode());
      localFbpCompany2.setAttribute2(paramFbpCompanyV.getSetOfBooksCode());
      localFbpCompany2.setAttribute3(paramFbpCompanyV.getSetOfBooksName());
      this.fbpCompanyDAO.insertFbpCompany(localFbpCompany2);
      localList2 = LangUtil.listLangTypes();
      localIterator = localList2.iterator();
      while (localIterator.hasNext())
      {
        localLangType = (LangType)localIterator.next();
        localObject2 = DataSourceU.getLang(localLangType.getCode());
        if (localObject2 != null)
        {
          localObject3 = new FbpCompanyTlPk();
          ((FbpCompanyTlPk)localObject3).setCompanyId(localFbpCompany2.getCompanyId());
          ((FbpCompanyTlPk)localObject3).setLanguage((String)localObject2);
          localFbpCompanyTl = (FbpCompanyTl)this.fbpCompanyTlDAO.getObject(FbpCompanyTl.class, (Serializable)localObject3);
          if (localFbpCompanyTl != null)
          {
            localFbpCompanyTl.setLastUpdateDate(new Date());
            localFbpCompanyTl.setCompanyName(paramFbpCompanyV.getCompanyName());
            localFbpCompanyTl.setEnabledFlag(paramFbpCompanyV.getEnabledFlag());
            this.fbpCompanyTlDAO.updateObject(localFbpCompanyTl);
          }
          else
          {
            localFbpCompanyTl = new FbpCompanyTl();
            localFbpCompanyTl.setFbpCompanyTlPk((FbpCompanyTlPk)localObject3);
            ObjectCopyUtils.setWho(localFbpCompanyTl);
            localFbpCompanyTl.setCompanyName(paramFbpCompanyV.getCompanyName());
            localFbpCompanyTl.setSourceLang(localLangType.getCode());
            localFbpCompanyTl.setEnabledFlag(paramFbpCompanyV.getEnabledFlag());
            this.fbpCompanyTlDAO.insertFbpCompanyTl(localFbpCompanyTl);
          }
        }
      }
      str1 = localFbpCompany2.getCompanyId().toString();
    }
    return "SAVE_SUCCEED," + str1;
  }
  
  public String saveFbpCompamyVForCheck(FbpCompanyV paramFbpCompanyV)
  {
    FbpCompanyV localFbpCompanyV = null;
    FbpCompany localFbpCompany = new FbpCompany();
    ObjectCopyUtils.copy(paramFbpCompanyV, localFbpCompany);
    ObjectCopyUtils.setWho(localFbpCompany);
    String str1 = "";
    String str2 = "";
    Object localObject1;
    Object localObject2;
    if ((paramFbpCompanyV.getCompanyId() == null) || (paramFbpCompanyV.getCompanyId().longValue() <= 0L))
    {
      if ((paramFbpCompanyV != null) && (paramFbpCompanyV.getCompanyCode() != null))
      {
        localFbpCompanyV = this.fbpCompanyVDAO.findByCompCode(paramFbpCompanyV.getCompanyCode().trim());
        if (localFbpCompanyV != null) {
          return "SAME_COMPANY_CODE";
        }
      }
      if ((paramFbpCompanyV != null) && (paramFbpCompanyV.getCompanyName() != null))
      {
        localFbpCompanyV = this.fbpCompanyVDAO.findByCompName(paramFbpCompanyV.getCompanyName());
        if ((localFbpCompanyV != null) && (localFbpCompanyV.getEnabledFlag().equals("Y"))) {
          return "SAME_COMPANY_NAME";
        }
      }
      this.fbpCompanyDAO.insertFbpCompany(localFbpCompany);
      if ((localFbpCompany != null) && (localFbpCompany.getCompanyId() != null)) {
        str1 = localFbpCompany.getCompanyId().toString();
      }
      localObject1 = LangUtil.listLangTypes();
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        LangType localLangType = (LangType)((Iterator)localObject2).next();
        FbpCompanyTl localFbpCompanyTl = new FbpCompanyTl();
        ObjectCopyUtils.copy(paramFbpCompanyV, localFbpCompanyTl);
        ObjectCopyUtils.setWho(localFbpCompanyTl);
        FbpCompanyTlPk localFbpCompanyTlPk = new FbpCompanyTlPk();
        localFbpCompanyTlPk.setCompanyId(localFbpCompany.getCompanyId());
        localFbpCompanyTlPk.setLanguage(DataSourceU.getLang(localLangType.getCode()));
        localFbpCompanyTl.setFbpCompanyTlPk(localFbpCompanyTlPk);
        localFbpCompanyTl.setSourceLang(DataSourceU.getLang(localLangType.getCode()));
        try
        {
          this.fbpCompanyTlDAO.insertFbpCompanyTl(localFbpCompanyTl);
        }
        catch (Exception localException2)
        {
          this.log.error("SAVE_FAILED", localException2);
          return "SAVE_FAILED";
        }
      }
    }
    else
    {
      if ((paramFbpCompanyV != null) && (paramFbpCompanyV.getCompanyId() != null))
      {
        localFbpCompanyV = this.fbpCompanyVDAO.findByCompId(paramFbpCompanyV.getCompanyId());
        if ((localFbpCompanyV != null) && (!localFbpCompanyV.getCompanyCode().equals(paramFbpCompanyV.getCompanyCode())))
        {
          str2 = paramFbpCompanyV.getCompanyCode();
          localFbpCompanyV = this.fbpCompanyVDAO.findByCompCode(str2);
          if ((localFbpCompanyV == null) && (localFbpCompanyV == null)) {
            return "SAME_COMPANY_CODE";
          }
        }
      }
      this.fbpCompanyDAO.updateFbpCompany(localFbpCompany);
      if ((localFbpCompany != null) && (localFbpCompany.getCompanyId() != null)) {
        str1 = localFbpCompany.getCompanyId().toString();
      }
      localObject1 = new FbpCompanyTl();
      ObjectCopyUtils.copy(paramFbpCompanyV, localObject1);
      ObjectCopyUtils.setWho(localObject1);
      localObject2 = new FbpCompanyTlPk();
      ((FbpCompanyTlPk)localObject2).setCompanyId(localFbpCompany.getCompanyId());
      ((FbpCompanyTlPk)localObject2).setLanguage(DataSourceU.getLang(LangUtil.getLocale()));
      ((FbpCompanyTl)localObject1).setFbpCompanyTlPk((FbpCompanyTlPk)localObject2);
      ((FbpCompanyTl)localObject1).setSourceLang(DataSourceU.getLang(LangUtil.getLocale()));
      try
      {
        this.fbpCompanyTlDAO.updateFbpCompanyTl((FbpCompanyTl)localObject1);
      }
      catch (Exception localException1)
      {
        this.log.error("SAVE_FAILED", localException1);
        return "SAVE_FAILED";
      }
    }
    return "SAVE_SUCCEED," + str1;
  }
  
  public FbpCompanyDAO getFbpCompanyDAO()
  {
    return this.fbpCompanyDAO;
  }
  
  public void setFbpCompanyDAO(FbpCompanyDAO paramFbpCompanyDAO)
  {
    this.fbpCompanyDAO = paramFbpCompanyDAO;
  }
  
  public FbpCompanyTlDAO getFbpCompanyTlDAO()
  {
    return this.fbpCompanyTlDAO;
  }
  
  public void setFbpCompanyTlDAO(FbpCompanyTlDAO paramFbpCompanyTlDAO)
  {
    this.fbpCompanyTlDAO = paramFbpCompanyTlDAO;
  }
  
  public FbpCompanyVDAO getFbpCompanyVDAO()
  {
    return this.fbpCompanyVDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.countcompanymanage.service.FbpCompanyVDS
 * JD-Core Version:    0.7.0.1
 */