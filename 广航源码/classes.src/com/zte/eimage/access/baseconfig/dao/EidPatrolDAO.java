package com.zte.eimage.access.baseconfig.dao;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.appframe.business.util.ObjectCopyUtils;
import com.zte.eimage.business.baseconfig.model.EidPatrol;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class EidPatrolDAO
  extends BaseDAO
  implements IEidPatrolDAO
{
  public List<EidPatrol> findPatrolByImageInfoId(Integer paramInteger)
  {
    String str = " From EidPatrol i WHERE i.imageInfoId = " + paramInteger + " ORDER BY i.patrolId DESC";
    List localList = getSession().createQuery(str).list();
    return localList;
  }
  
  public String insertForUpdatePatrol(List<EidPatrol> paramList)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    Long localLong = Long.valueOf(1L);
    Object localObject;
    if (localRIAContext != null)
    {
      ISession localISession = localRIAContext.getSession();
      localObject = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
      localLong = new Long(((EasUserInfo)localObject).getUserInfoPk().toString());
    }
    for (int i = 0; i < paramList.size(); i++)
    {
      localObject = (EidPatrol)paramList.get(i);
      if (null == ((EidPatrol)localObject).getPatrolId())
      {
        ObjectCopyUtils.setWho(localObject);
        if (null == ((EidPatrol)localObject).getPatrolDate()) {
          ((EidPatrol)localObject).setPatrolDate(new Date());
        }
        ((EidPatrol)localObject).setEnabledFlag("Y");
        super.insertObject(localObject);
      }
    }
    return "Y";
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.baseconfig.dao.EidPatrolDAO
 * JD-Core Version:    0.7.0.1
 */