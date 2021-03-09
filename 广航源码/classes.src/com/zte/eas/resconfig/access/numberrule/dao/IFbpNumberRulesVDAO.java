package com.zte.eas.resconfig.access.numberrule.dao;

import com.zte.eas.resconfig.business.numberrule.model.FbpNumberRulesV;
import com.zte.ssb.framework.base.DAO;
import com.zte.ssb.framework.base.util.PageInfo;
import java.util.List;

public abstract interface IFbpNumberRulesVDAO
  extends DAO
{
  public abstract FbpNumberRulesV findFbpNumberRulesVById(String paramString);
  
  public abstract PageInfo findFbpNumberRulesVsByCond(FbpNumberRulesV paramFbpNumberRulesV, int paramInt1, int paramInt2);
  
  public abstract List<FbpNumberRulesV> findFbpNumberRulesBoe(String paramString);
  
  public abstract List<FbpNumberRulesV> findCodeDw(FbpNumberRulesV paramFbpNumberRulesV);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.numberrule.dao.IFbpNumberRulesVDAO
 * JD-Core Version:    0.7.0.1
 */