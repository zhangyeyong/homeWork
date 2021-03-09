package com.zte.evs.ebill.access.archives;

import com.zte.evs.ebill.model.archives.FbpCheckPerson;
import com.zte.evs.ebill.model.archives.FbpCheckPersonV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.util.ArrayList;
import java.util.List;

public class FbpCheckPersonDAO
  extends BaseDAO
  implements IFbpCheckPersonDAO
{
  public PageInfo fbpCheckPersonByQuery(int paramInt1, int paramInt2)
  {
    String str = "from EvsSubDocType dt where dt.enabledFlag='Y'";
    paramInt1 = paramInt1 / paramInt2 + 1;
    PageInfo localPageInfo = PageInfoQuery(str, paramInt1, paramInt2, new Object[0]);
    return localPageInfo;
  }
  
  public FbpCheckPerson getFbpCheckPerson(Long paramLong)
  {
    return (FbpCheckPerson)super.getObject(FbpCheckPerson.class, paramLong);
  }
  
  public List getFbpCheckPersons()
  {
    return super.getObjects(FbpCheckPerson.class);
  }
  
  public List<FbpCheckPerson> getFbpCheckPersons(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpCheckPerson.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpCheckPerson(FbpCheckPerson paramFbpCheckPerson)
  {
    super.removeObject(paramFbpCheckPerson);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpCheckPerson(FbpCheckPerson paramFbpCheckPerson)
  {
    super.insertObject(paramFbpCheckPerson);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpCheckPerson(FbpCheckPerson paramFbpCheckPerson)
  {
    super.updateObject(paramFbpCheckPerson);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpCheckPersons(List<FbpCheckPerson> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpCheckPersons(List<FbpCheckPerson> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpCheckPersons(List<FbpCheckPerson> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpCheckPerson(Long paramLong)
  {
    super.removeObject(FbpCheckPerson.class, paramLong);
  }
  
  public PageInfo getFbpCheckPerson(FbpCheckPersonV paramFbpCheckPersonV, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer("from FbpCheckPersonV f where 1=1");
    ArrayList localArrayList = new ArrayList();
    if ((paramFbpCheckPersonV.getAttribute1() != null) && (paramFbpCheckPersonV.getAttribute1().trim().length() > 0))
    {
      localStringBuffer.append(" and f.attribute1 = ?");
      localArrayList.add(paramFbpCheckPersonV.getAttribute1());
    }
    if ((paramFbpCheckPersonV.getJournalName() != null) && (paramFbpCheckPersonV.getJournalName().trim().length() > 0))
    {
      localStringBuffer.append(" and f.journalName = ?");
      localArrayList.add(paramFbpCheckPersonV.getJournalName());
    }
    if (paramFbpCheckPersonV.getEmployeeId() != null)
    {
      localStringBuffer.append(" and f.employeeId = ?");
      localArrayList.add(paramFbpCheckPersonV.getEmployeeId());
    }
    if ((paramFbpCheckPersonV.getEnabledFlag() != null) && (!paramFbpCheckPersonV.getEnabledFlag().equals("")))
    {
      localStringBuffer.append(" and f.enabledFlag=?");
      localArrayList.add(paramFbpCheckPersonV.getEnabledFlag());
    }
    localStringBuffer.append(" order by f.lastUpdateDate desc");
    paramInt1 = paramInt1 / paramInt2 + 1;
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, localArrayList.toArray());
    return localPageInfo;
  }
  
  public List queryCheckPersonV(long paramLong)
  {
    String str = "from FbpCheckPersonV f where 1=1 and f.employeeId=" + paramLong;
    List localList = getZormTemplate().find(str);
    return localList;
  }
  
  public FbpCheckPerson getFbpCheckPerson(String paramString1, String paramString2)
  {
    String str = "from FbpCheckPerson where attribute1 = ? and journalName = ?";
    return (FbpCheckPerson)super.getSession().createQuery(str).setString(0, paramString1).setString(1, paramString2).uniqueResult();
  }
  
  public void updateCheckPerson(FbpCheckPerson paramFbpCheckPerson)
  {
    String str = "update fbp.fbp_check_person f set f.check_person_id='" + paramFbpCheckPerson.getCheckPersonId() + "',f.ENABLED_FLAG='" + paramFbpCheckPerson.getEnabledFlag() + "'" + " where f.employee_id='" + paramFbpCheckPerson.getEmployeeId() + "'" + " and journal_name='" + paramFbpCheckPerson.getJournalName() + "'";
    getSession().createSQLQuery(str).executeUpdate();
  }
  
  public PageInfo findFbpCheckPersonByQuery(FbpCheckPersonV paramFbpCheckPersonV, int paramInt1, int paramInt2)
  {
    String str = "from FbpCheckPersonV f where 1=1 and f.employeeId=" + paramFbpCheckPersonV.getEmployeeId();
    paramInt1 = paramInt1 / paramInt2 + 1;
    PageInfo localPageInfo = PageInfoQuery(str, paramInt1, paramInt2, new Object[0]);
    return localPageInfo;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.access.archives.FbpCheckPersonDAO
 * JD-Core Version:    0.7.0.1
 */