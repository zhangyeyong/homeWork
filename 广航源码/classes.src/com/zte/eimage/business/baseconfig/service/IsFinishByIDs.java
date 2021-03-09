package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.access.baseconfig.dao.IEidAppraiseTasksDAO;
import com.zte.eimage.business.baseconfig.model.EidAppraiseTasks;
import com.zte.ssb.framework.SSBBus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IsFinishByIDs
  implements IIsFinishByIDs
{
  private final String TASKSSTATUS = "COMPLETE";
  Log log = LogFactory.getLog(IsFinishByIDs.class);
  
  public String IsFinishByID(int paramInt)
  {
    this.log.error("\n\n++++++++++++++++++++++++++++ IsFinishByID 查询任务是否已完成 begin +++++++++++++++++++++++++++++++++++++++++++++");
    IEidAppraiseTasksDAO localIEidAppraiseTasksDAO = (IEidAppraiseTasksDAO)SSBBus.findDaoService("eidAppraiseTasksDAO");
    this.log.error("任务ID taskID:  " + paramInt);
    Long localLong = Long.valueOf(0L);
    try
    {
      localLong = Long.valueOf(paramInt);
    }
    catch (Exception localException)
    {
      this.log.error(localException, localException);
      this.log.error("任务ID错误!任务ID" + paramInt);
      return null;
    }
    EidAppraiseTasks localEidAppraiseTasks = localIEidAppraiseTasksDAO.getEidAppraiseTasks(localLong);
    this.log.error("appraiseTasks" + localEidAppraiseTasks);
    this.log.error("taskStatus:  " + (localEidAppraiseTasks == null ? null : localEidAppraiseTasks.getTaskStatus()));
    if ((localEidAppraiseTasks == null) || (localEidAppraiseTasks.getTaskStatus() == null) || ("".equals(localEidAppraiseTasks.getTaskStatus().trim())))
    {
      this.log.error("获取任务失败!");
      return "-1";
    }
    String str = "COMPLETE".equals(localEidAppraiseTasks.getTaskStatus().trim()) ? "1" : "0";
    this.log.error("returnValue:  " + str);
    this.log.error("++++++++++++++++++++++++++++ IsFinishByID 查询任务是否已完成 end +++++++++++++++++++++++++++++++++++++++++++++\n\n");
    return str;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.IsFinishByIDs
 * JD-Core Version:    0.7.0.1
 */