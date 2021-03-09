package com.zte.eimage.access.baseconfig.dao;

import com.zte.eimage.business.baseconfig.model.EidAppraiseTasks;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.util.ArrayList;
import java.util.List;

public class EidAppraiseTasksDAO
  extends BaseDAO
  implements IEidAppraiseTasksDAO
{
  public EidAppraiseTasks getEidAppraiseTasks(Long paramLong)
  {
    return (EidAppraiseTasks)super.getObject(EidAppraiseTasks.class, paramLong);
  }
  
  public List getEidAppraiseTaskss()
  {
    return super.getObjects(EidAppraiseTasks.class);
  }
  
  public List<EidAppraiseTasks> getEidAppraiseTaskss(int paramInt1, int paramInt2)
  {
    return super.getObjects(EidAppraiseTasks.class, paramInt1, paramInt2);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidAppraiseTasks(EidAppraiseTasks paramEidAppraiseTasks)
  {
    super.removeObject(paramEidAppraiseTasks);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEidAppraiseTasks(EidAppraiseTasks paramEidAppraiseTasks)
  {
    super.insertObject(paramEidAppraiseTasks);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEidAppraiseTasks(EidAppraiseTasks paramEidAppraiseTasks)
  {
    super.updateObject(paramEidAppraiseTasks);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertEidAppraiseTaskss(List<EidAppraiseTasks> paramList)
  {
    super.insertObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidAppraiseTaskss(List<EidAppraiseTasks> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEidAppraiseTaskss(List<EidAppraiseTasks> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeEidAppraiseTasks(Long paramLong)
  {
    super.removeObject(EidAppraiseTasks.class, paramLong);
  }
  
  public EidAppraiseTasks findEidAppraiseTasksByImageNum(String paramString)
  {
    String str = "from EidAppraiseTasks tas where tas.taskStatus = ? and tas.imageNum=?";
    List localList = getSession().createQuery(str).setString(0, "NONCOMPLETE").setString(1, paramString).list();
    if ((localList == null) || (localList.size() <= 0) || (localList.get(0) == null)) {
      return null;
    }
    return (EidAppraiseTasks)localList.get(0);
  }
  
  public List<EidAppraiseTasks> getEidAppraiseTaskss(String paramString)
  {
    Session localSession = super.getSession();
    Query localQuery = localSession.createQuery(paramString);
    return localQuery.list();
  }
  
  public List<Object[]> findAppraiseTask(String paramString, Long paramLong1, Long paramLong2)
  {
    StringBuffer localStringBuffer = new StringBuffer("select task.task_type, img.image_number, img.task_num, task.ftp_path, img.image_count, task.image_memo, task.task_desc, es.site_id, task.APPRAISE_TASK_ID, (select image_path from eid_images ei where ei.image_info_id = img.image_info_id and rownum=1), img.is_boe, fc.company_code, fot.operation_type_code from eid_appraise_tasks task, eid_image_infos img,eid_sites es,fbp.fbp_company fc,fbp.fbp_operation_types fot where task.image_num = img.image_number and img.company_id = fc.company_id and img.operation_type_id = fot.operation_type_id and img.company_id = es.company_id and es.enabled_flag = 'Y' and img.enabled_flag = 'Y'");
    ArrayList localArrayList = new ArrayList();
    if ((paramString != null) && (paramString.trim().length() > 0))
    {
      localStringBuffer.append(" and task.task_status = ?");
      localArrayList.add(paramString);
    }
    if (paramLong1 != null)
    {
      localStringBuffer.append(" and img.upload_employee_id = ?");
      localArrayList.add(paramLong1);
    }
    if (paramLong2 != null)
    {
      localStringBuffer.append(" and task.ftp_id = ?");
      localArrayList.add(paramLong2);
    }
    SQLQuery localSQLQuery = super.getSession().createSQLQuery(localStringBuffer.toString());
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      for (int i = 0; i < localArrayList.size(); i++) {
        localSQLQuery.setParameter(i, localArrayList.get(i));
      }
      return localSQLQuery.list();
    }
    return null;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.EidAppraiseTasksDAO
 * JD-Core Version:    0.7.0.1
 */