package com.zte.eas.appframe.access.sysparm.dao;

import com.zte.eas.appframe.business.sysparm.model.SieSysParm;
import com.zte.eas.appframe.business.sysparm.model.SysParmTransition;
import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

public class SieSysParmDAO
  extends BaseDAO
  implements ISieSysParmDAO
{
  public String getSysParmByParmCode(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "FROM SieSysParm s WHERE 1=1";
    if ((paramString != null) && (!paramString.equals("")))
    {
      str = str + " AND s.sysParmCode = ?";
      localArrayList.add(paramString);
    }
    else
    {
      str = str + " AND 1=2";
    }
    List localList = getZormTemplate().find(str, localArrayList.toArray());
    if (localList.size() > 0) {
      return ((SieSysParm)localList.get(0)).getSysParmValue();
    }
    return null;
  }
  
  public List findSysParms(SieSysParm paramSieSysParm)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "FROM SieSysParm s WHERE s.enabledFlag = 'Y'";
    if ((paramSieSysParm != null) && (paramSieSysParm.getSysParmId() != null))
    {
      str = str + "and s.sysParmId = ? ";
      localArrayList.add(Long.valueOf(paramSieSysParm.getSysParmId().longValue()));
    }
    return getZormTemplate().find(str, localArrayList.toArray());
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void saveSysParms(SysParmTransition paramSysParmTransition)
  {
    SieSysParm localSieSysParm;
    if ((paramSysParmTransition.getSieSysParm1() != null) && (paramSysParmTransition.getSieSysParm1().getSysParmId() != null))
    {
      localSieSysParm = new SieSysParm();
      localSieSysParm.setSysParmId(paramSysParmTransition.getSieSysParm1().getSysParmId());
      localSieSysParm = (SieSysParm)findSysParms(localSieSysParm).get(0);
      localSieSysParm.setSysParmValue(paramSysParmTransition.getSieSysParm1().getSysParmValue());
      ObjectCopyUtils.setWho(localSieSysParm);
      super.updateObject(localSieSysParm);
    }
    if ((paramSysParmTransition.getSieSysParm2() != null) && (paramSysParmTransition.getSieSysParm2().getSysParmId() != null))
    {
      localSieSysParm = new SieSysParm();
      localSieSysParm.setSysParmId(paramSysParmTransition.getSieSysParm2().getSysParmId());
      localSieSysParm = (SieSysParm)findSysParms(localSieSysParm).get(0);
      localSieSysParm.setSysParmValue(paramSysParmTransition.getSieSysParm2().getSysParmValue());
      ObjectCopyUtils.setWho(localSieSysParm);
      super.updateObject(localSieSysParm);
    }
    if ((paramSysParmTransition.getSieSysParm3() != null) && (paramSysParmTransition.getSieSysParm3().getSysParmId() != null))
    {
      localSieSysParm = new SieSysParm();
      localSieSysParm.setSysParmId(paramSysParmTransition.getSieSysParm3().getSysParmId());
      localSieSysParm = (SieSysParm)findSysParms(localSieSysParm).get(0);
      localSieSysParm.setSysParmValue(paramSysParmTransition.getSieSysParm3().getSysParmValue());
      ObjectCopyUtils.setWho(localSieSysParm);
      super.updateObject(localSieSysParm);
    }
    if ((paramSysParmTransition.getSieSysParm4() != null) && (paramSysParmTransition.getSieSysParm4().getSysParmId() != null))
    {
      localSieSysParm = new SieSysParm();
      localSieSysParm.setSysParmId(paramSysParmTransition.getSieSysParm4().getSysParmId());
      localSieSysParm = (SieSysParm)findSysParms(localSieSysParm).get(0);
      localSieSysParm.setSysParmValue(paramSysParmTransition.getSieSysParm4().getSysParmValue());
      localSieSysParm.setSysParmDesc(paramSysParmTransition.getSieSysParm4().getSysParmDesc());
      ObjectCopyUtils.setWho(localSieSysParm);
      super.updateObject(localSieSysParm);
    }
    if ((paramSysParmTransition.getSieSysParm5() != null) && (paramSysParmTransition.getSieSysParm5().getSysParmId() != null))
    {
      localSieSysParm = new SieSysParm();
      localSieSysParm.setSysParmId(paramSysParmTransition.getSieSysParm5().getSysParmId());
      localSieSysParm = (SieSysParm)findSysParms(localSieSysParm).get(0);
      localSieSysParm.setSysParmValue(paramSysParmTransition.getSieSysParm5().getSysParmValue());
      localSieSysParm.setSysParmDesc(paramSysParmTransition.getSieSysParm5().getSysParmDesc());
      ObjectCopyUtils.setWho(localSieSysParm);
      super.updateObject(localSieSysParm);
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.sysparm.dao.SieSysParmDAO
 * JD-Core Version:    0.7.0.1
 */