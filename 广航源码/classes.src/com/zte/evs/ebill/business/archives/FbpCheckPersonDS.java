package com.zte.evs.ebill.business.archives;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.evs.ebill.access.archives.IFbpCheckPersonDAO;
import com.zte.evs.ebill.common.ObjectCopyUtils;
import com.zte.evs.ebill.model.archives.FbpCheckPerson;
import com.zte.evs.ebill.model.archives.FbpCheckPersonV;
import com.zte.evs.ebill.model.eBillManage.EvsSubDocType;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.BaseDomainService;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FbpCheckPersonDS
  extends BaseDomainService
  implements IFbpCheckPersonDS
{
  private IFbpCheckPersonDAO fbpCheckPersonDAO;
  static final String EAS_LOGIN_USERINFO = "easloginuserinfo";
  
  private EasUserInfo getUserInfo()
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    return localEasUserInfo;
  }
  
  public void setFbpCheckPersonDAO(IFbpCheckPersonDAO paramIFbpCheckPersonDAO)
  {
    super.setDao(paramIFbpCheckPersonDAO);
    this.fbpCheckPersonDAO = paramIFbpCheckPersonDAO;
  }
  
  public List<FbpCheckPerson> getFbpCheckPersons(int paramInt1, int paramInt2)
  {
    return this.fbpCheckPersonDAO.getFbpCheckPersons(paramInt1, paramInt2);
  }
  
  public List<FbpCheckPerson> getFbpCheckPersons()
  {
    return this.fbpCheckPersonDAO.getFbpCheckPersons();
  }
  
  public FbpCheckPerson getFbpCheckPerson(Long paramLong)
  {
    return this.fbpCheckPersonDAO.getFbpCheckPerson(paramLong);
  }
  
  public void removeFbpCheckPerson(Long paramLong)
  {
    this.fbpCheckPersonDAO.removeFbpCheckPerson(paramLong);
  }
  
  public void removeFbpCheckPerson(FbpCheckPerson paramFbpCheckPerson)
  {
    this.fbpCheckPersonDAO.removeFbpCheckPerson(paramFbpCheckPerson);
  }
  
  public void insertFbpCheckPerson(FbpCheckPerson paramFbpCheckPerson)
  {
    this.fbpCheckPersonDAO.insertFbpCheckPerson(paramFbpCheckPerson);
  }
  
  public void insertFbpCheckPersons(List<FbpCheckPerson> paramList)
  {
    this.fbpCheckPersonDAO.insertFbpCheckPersons(paramList);
  }
  
  public void removeFbpCheckPersons(List<FbpCheckPerson> paramList)
  {
    this.fbpCheckPersonDAO.removeFbpCheckPersons(paramList);
  }
  
  public String updateFbpCheckPersons(List<FbpCheckPersonV> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "N";
    }
    for (int i = 0; i < paramList.size(); i++)
    {
      FbpCheckPersonV localFbpCheckPersonV = (FbpCheckPersonV)paramList.get(i);
      if ((localFbpCheckPersonV != null) && (localFbpCheckPersonV.getId() != null))
      {
        FbpCheckPerson localFbpCheckPerson = this.fbpCheckPersonDAO.getFbpCheckPerson(localFbpCheckPersonV.getId());
        if ((localFbpCheckPerson != null) && (localFbpCheckPerson.getId() != null))
        {
          localFbpCheckPerson.setEnabledFlag(localFbpCheckPersonV.getEnabledFlag());
          localFbpCheckPerson.setAttribute1(localFbpCheckPersonV.getAttribute1());
          localFbpCheckPerson.setJournalName(localFbpCheckPersonV.getJournalName());
          localFbpCheckPerson.setEmployeeId(localFbpCheckPersonV.getEmployeeId());
          localFbpCheckPerson.setLastUpdateDate(new Date());
          this.fbpCheckPersonDAO.updateObject(localFbpCheckPerson);
        }
      }
    }
    return "Y";
  }
  
  public List<FbpCheckPersonV> getFbpCheckPersonV(Long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    FbpCheckPersonV localFbpCheckPersonV = (FbpCheckPersonV)this.fbpCheckPersonDAO.getObject(FbpCheckPersonV.class, paramLong);
    localArrayList.add(localFbpCheckPersonV);
    return localArrayList;
  }
  
  public TableDataInfo getFbpCheckPerson(FbpCheckPersonV paramFbpCheckPersonV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.fbpCheckPersonDAO.getFbpCheckPerson(paramFbpCheckPersonV, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public String addFbpCheckPerson(FbpCheckPerson paramFbpCheckPerson)
  {
    List localList = this.fbpCheckPersonDAO.queryCheckPersonV(paramFbpCheckPerson.getEmployeeId().longValue());
    if (localList.size() > 0) {
      return "EXISTS";
    }
    String[] arrayOfString1 = paramFbpCheckPerson.getJournalName().split(",");
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      String[] arrayOfString2 = arrayOfString1[i].split("-");
      String str1 = arrayOfString2[0];
      String str2 = arrayOfString2[1];
      FbpCheckPerson localFbpCheckPerson = new FbpCheckPerson();
      localFbpCheckPerson.setLastUpdateDate(new Date());
      localFbpCheckPerson.setLastUpdatedBy(Long.valueOf(Long.parseLong(getUserInfo().getUserInfoPk().toString())));
      localFbpCheckPerson.setCreationDate(new Date());
      localFbpCheckPerson.setCreatedBy(Long.valueOf(Long.parseLong(getUserInfo().getUserInfoPk().toString())));
      localFbpCheckPerson.setEmployeeId(paramFbpCheckPerson.getEmployeeId());
      localFbpCheckPerson.setJournalName(str1);
      localFbpCheckPerson.setCheckPersonId(Long.valueOf(Long.parseLong(str2)));
      localFbpCheckPerson.setEnabledFlag(paramFbpCheckPerson.getEnabledFlag());
      localArrayList.add(localFbpCheckPerson);
    }
    this.fbpCheckPersonDAO.insertFbpCheckPersons(localArrayList);
    return "SUCCESS";
  }
  
  public String findVoucherCheckConfigIsExists(List<FbpCheckPerson> paramList)
  {
    String str = "N";
    if ((paramList == null) || (paramList.isEmpty())) {
      return str;
    }
    for (int i = 0; i < paramList.size(); i++)
    {
      FbpCheckPerson localFbpCheckPerson1 = (FbpCheckPerson)paramList.get(i);
      FbpCheckPerson localFbpCheckPerson2 = this.fbpCheckPersonDAO.getFbpCheckPerson(localFbpCheckPerson1.getAttribute1(), localFbpCheckPerson1.getJournalName());
      if ((localFbpCheckPerson2 != null) && (localFbpCheckPerson2.getId() != null) && (!localFbpCheckPerson2.getId().equals(localFbpCheckPerson1.getId())))
      {
        str = i + 1 + "";
        break;
      }
    }
    return str;
  }
  
  public String addFbpCheckPersons(List<FbpCheckPerson> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FbpCheckPerson localFbpCheckPerson = (FbpCheckPerson)localIterator.next();
      ObjectCopyUtils.setWho(localFbpCheckPerson);
    }
    this.fbpCheckPersonDAO.insertFbpCheckPersons(paramList);
    return "Y";
  }
  
  public TableDataInfo fbpCheckPersonByQuery(EvsSubDocType paramEvsSubDocType, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.fbpCheckPersonDAO.fbpCheckPersonByQuery(paramInt1, paramInt2);
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
  
  public TableDataInfo findFbpCheckPersonByQuery(FbpCheckPersonV paramFbpCheckPersonV, int paramInt1, int paramInt2)
  {
    TableDataInfo localTableDataInfo = new TableDataInfo();
    PageInfo localPageInfo = this.fbpCheckPersonDAO.findFbpCheckPersonByQuery(paramFbpCheckPersonV, paramInt1, paramInt2);
    localTableDataInfo.setData((List)localPageInfo.getResult());
    localTableDataInfo.setTotalCount((int)localPageInfo.getTotalCount());
    return localTableDataInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.archives.FbpCheckPersonDS
 * JD-Core Version:    0.7.0.1
 */