package com.zte.eas.flowruleengine.access.posstru.dao;

import com.zte.eas.flowruleengine.business.posstru.model.FbpPosStruElements;
import com.zte.eas.flowruleengine.business.posstru.model.FbpPosStruElementsV;
import com.zte.eas.flowruleengine.business.posstru.model.FbpPseHoldersV;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpPosStruElementsVDAO
  extends DAO
{
  public abstract List findPosStruElementsVByQry(FbpPosStruElementsV paramFbpPosStruElementsV);
  
  public abstract FbpPosStruElementsV findPosStruElementsVById(String paramString);
  
  public abstract FbpPosStruElements findVirtualCompanyId(String paramString1, String paramString2);
  
  public abstract void delOldRelations(String paramString, Long paramLong1, Long paramLong2);
  
  public abstract String saveRelations(String paramString, List<FbpPseHoldersV> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.access.posstru.dao.IFbpPosStruElementsVDAO
 * JD-Core Version:    0.7.0.1
 */