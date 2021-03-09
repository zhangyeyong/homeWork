package com.zte.eas.appframe.business.sysparm.service;

import com.zte.eas.appframe.access.sysparm.dao.ISieSysParmDAO;
import com.zte.eas.appframe.business.sysparm.model.SieSysParm;
import com.zte.eas.appframe.business.sysparm.model.SysParmTransition;
import com.zte.ssb.framework.base.BaseDomainService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SieSysParmDS
  extends BaseDomainService
  implements ISieSysParmDS
{
  private ISieSysParmDAO sieSysParmDAO;
  private static final String SKIP = "重复审批是否跳过";
  private static final String NUMUSE = "临时编号是否启用";
  private static final String CONCTROL = "合同付款控制";
  private static final String REDUCE = "资产减值账户";
  private static final String REFUSE_APPROVE = "REFUSE_APPROVE";
  
  public Map getSysParmByParmCode(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String str = this.sieSysParmDAO.getSysParmByParmCode(paramString);
    localHashMap.put("parmValue", str);
    return localHashMap;
  }
  
  public SysParmTransition findSysParms(SieSysParm paramSieSysParm)
  {
    SysParmTransition localSysParmTransition = new SysParmTransition();
    List localList = this.sieSysParmDAO.findSysParms(paramSieSysParm);
    for (int i = 0; i < localList.size(); i++)
    {
      SieSysParm localSieSysParm = (SieSysParm)localList.get(i);
      if (localSieSysParm.getSysParmName().equals("重复审批是否跳过")) {
        localSysParmTransition.setSieSysParm1(localSieSysParm);
      }
      if (localSieSysParm.getSysParmName().equals("临时编号是否启用")) {
        localSysParmTransition.setSieSysParm2(localSieSysParm);
      }
      if (localSieSysParm.getSysParmName().equals("合同付款控制")) {
        localSysParmTransition.setSieSysParm3(localSieSysParm);
      }
      if (localSieSysParm.getSysParmName().equals("资产减值账户")) {
        localSysParmTransition.setSieSysParm4(localSieSysParm);
      }
      if (localSieSysParm.getSysParmCode().equals("REFUSE_APPROVE")) {
        localSysParmTransition.setSieSysParm5(localSieSysParm);
      }
    }
    return localSysParmTransition;
  }
  
  public String saveSysParms(SysParmTransition paramSysParmTransition)
  {
    String str = null;
    try
    {
      this.sieSysParmDAO.saveSysParms(paramSysParmTransition);
      str = "success";
    }
    catch (Exception localException)
    {
      str = "fail";
    }
    return str;
  }
  
  public ISieSysParmDAO getSieSysParmDAO()
  {
    return this.sieSysParmDAO;
  }
  
  public void setSieSysParmDAO(ISieSysParmDAO paramISieSysParmDAO)
  {
    this.sieSysParmDAO = paramISieSysParmDAO;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.sysparm.service.SieSysParmDS
 * JD-Core Version:    0.7.0.1
 */