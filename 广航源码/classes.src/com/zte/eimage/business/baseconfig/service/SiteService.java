package com.zte.eimage.business.baseconfig.service;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.appframe.business.syscommon.InfoMapEncrypt;
import com.zte.eimage.access.baseconfig.dao.ISiteDao;
import com.zte.eimage.business.baseconfig.model.Site;
import com.zte.eimage.business.baseconfig.model.SiteV;
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

public class SiteService
  implements ISiteService
{
  static final String DEFAUTSELECTVALUE = "";
  private ISiteDao siteDao;
  
  public void insertSite(Site paramSite)
  {
    String str = InfoMapEncrypt.encrypt(paramSite.getFtpPassword());
    paramSite.setFtpPassword(str);
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    paramSite.setLastUpdateLogin(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    paramSite.setLastUpdatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    paramSite.setLastUpdateDate(new Date());
    paramSite.setCreatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    paramSite.setCreationDate(new Date());
    this.siteDao.insertSite(paramSite);
  }
  
  public Site getSiteById(Integer paramInteger)
  {
    Site localSite = this.siteDao.getSiteById(paramInteger);
    String str = null;
    try
    {
      str = InfoMapEncrypt.decrypt(localSite.getFtpPassword());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    localSite.setFtpPassword(str);
    return localSite;
  }
  
  public SiteV getSiteVById(Integer paramInteger)
  {
    String str1 = "FROM SiteV s WHERE s.siteId =" + paramInteger;
    SiteV localSiteV = (SiteV)this.siteDao.findSiteBySql(str1);
    String str2 = null;
    try
    {
      str2 = InfoMapEncrypt.decrypt(localSiteV.getFtpPassword());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    localSiteV.setFtpPassword(str2);
    return localSiteV;
  }
  
  public HashMap getAllSite(String paramString)
  {
    HashMap localHashMap = new HashMap();
    List localList = this.siteDao.getAllSite();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add(ComResUtil.getMessage("fbp.lookup.select"));
    localArrayList2.add("");
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      Site localSite = (Site)localIterator.next();
      localArrayList1.add(localSite.getSiteName());
      localArrayList2.add(localSite.getSiteId());
    }
    localHashMap.put("selectText", localArrayList1);
    localHashMap.put("selectValue", localArrayList2);
    localHashMap.put("selectDefault", paramString);
    return localHashMap;
  }
  
  public HashMap getAllSite(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    List localList = this.siteDao.getAllSite(paramString2);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str1 = "";
    String str2 = "";
    if ((localList != null) && (localList.size() > 0))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Site localSite = (Site)localIterator.next();
        str1 = str1 + localSite.getSiteId() + ",";
        str2 = str2 + localSite.getSiteName() + ",";
      }
      str1 = str1.substring(0, str1.length() - 1);
      str2 = str2.substring(0, str2.length() - 1);
    }
    localHashMap.put("siteId", str1);
    localHashMap.put("siteName", str2);
    return localHashMap;
  }
  
  public void updateSite(Site paramSite)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    Site localSite = this.siteDao.getSiteById(paramSite.getSiteId());
    localSite.setSiteName(paramSite.getSiteName());
    localSite.setFtpSite(paramSite.getFtpSite());
    localSite.setWebSite(paramSite.getWebSite());
    localSite.setPort(paramSite.getPort());
    localSite.setFtpUserName(paramSite.getFtpUserName());
    String str = InfoMapEncrypt.encrypt(paramSite.getFtpPassword());
    localSite.setFtpPassword(str);
    localSite.setFtpAbsolutePath(paramSite.getFtpAbsolutePath());
    localSite.setRootDirectory(paramSite.getRootDirectory());
    localSite.setEnabledFlag(paramSite.getEnabledFlag());
    localSite.setCompanyId(paramSite.getCompanyId());
    localSite.setLastUpdateLogin(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    localSite.setLastUpdatedBy(Long.valueOf(Long.parseLong(localEasUserInfo.getUserInfoPk().toString())));
    localSite.setLastUpdateDate(new Date());
    this.siteDao.updateSite(localSite);
  }
  
  public TableDataInfo findSite(Site paramSite, String paramString1, String paramString2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.siteDao.findSite(paramSite, Integer.valueOf(Integer.parseInt(paramString1)), Integer.valueOf(Integer.parseInt(paramString2)));
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public Integer isExistsSiteName(String paramString)
  {
    String str = "FROM Site s WHERE s.siteName = '" + paramString.trim() + "'";
    return this.siteDao.getCount(str);
  }
  
  public Integer isNOtOnetoOne(String paramString1, String paramString2)
  {
    String str = "FROM SiteV s WHERE ";
    if ((paramString1 != null) && (!"".equals(paramString1))) {
      str = str + " s.siteId <>" + Long.valueOf(paramString1) + " and  s.companyId=" + Long.valueOf(paramString2);
    } else {
      str = str + " s.companyId=" + paramString2;
    }
    return this.siteDao.getCount(str);
  }
  
  public ISiteDao getSiteDao()
  {
    return this.siteDao;
  }
  
  public void setSiteDao(ISiteDao paramISiteDao)
  {
    this.siteDao = paramISiteDao;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.SiteService
 * JD-Core Version:    0.7.0.1
 */