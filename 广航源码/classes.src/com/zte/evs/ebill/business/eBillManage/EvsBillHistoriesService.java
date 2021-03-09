package com.zte.evs.ebill.business.eBillManage;

import com.zte.evs.ebill.access.eBillManage.IEvsBillHistoriesDAO;
import com.zte.evs.ebill.model.eBillManage.EvsBillHistoriesV;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvsBillHistoriesService
  implements IEvsBillHistoriesService
{
  private IEvsBillHistoriesDAO evsBillHistoriesDAO;
  
  public List<Map<String, String>> getHistoryByBoeNum(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = this.evsBillHistoriesDAO.findHistoryByBoeNum(paramString);
    if ((localList != null) && (localList.size() > 0))
    {
      HashMap localHashMap = null;
      EvsBillHistoriesV localEvsBillHistoriesV = null;
      for (int i = 0; i < localList.size(); i++)
      {
        localEvsBillHistoriesV = (EvsBillHistoriesV)localList.get(i);
        if (localEvsBillHistoriesV != null)
        {
          localHashMap = new HashMap();
          localHashMap.put("OPERATE_EMPLOYEE_NAME", localEvsBillHistoriesV.getOperateEmployeeName());
          localHashMap.put("creation_date", "" + localEvsBillHistoriesV.getCreationDate());
          localHashMap.put("approve_command", localEvsBillHistoriesV.getApproveCommand());
          localHashMap.put("approve_position_name", localEvsBillHistoriesV.getApprovePositionName());
          localArrayList.add(localHashMap);
        }
      }
    }
    return localArrayList;
  }
  
  public IEvsBillHistoriesDAO getEvsBillHistoriesDAO()
  {
    return this.evsBillHistoriesDAO;
  }
  
  public void setEvsBillHistoriesDAO(IEvsBillHistoriesDAO paramIEvsBillHistoriesDAO)
  {
    this.evsBillHistoriesDAO = paramIEvsBillHistoriesDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.business.eBillManage.EvsBillHistoriesService
 * JD-Core Version:    0.7.0.1
 */