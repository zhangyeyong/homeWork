package com.zte.eas.resconfig.access.numberrule.dao;

import com.zte.eas.resconfig.business.numberrule.model.FbpNumberRuleDetails;
import com.zte.ssb.framework.base.DAO;
import java.util.List;

public abstract interface IFbpNumberRuleDetailsDAO
  extends DAO
{
  public abstract List<FbpNumberRuleDetails> findRuleDetailsByRuleId(String paramString);
  
  public abstract void removeFbpNumberRuleDetail(Long paramLong);
  
  public abstract void removeFbpNumberRuleDetail(FbpNumberRuleDetails paramFbpNumberRuleDetails);
  
  public abstract void insertFbpNumberRuleDetail(FbpNumberRuleDetails paramFbpNumberRuleDetails);
  
  public abstract void update(FbpNumberRuleDetails paramFbpNumberRuleDetails);
  
  public abstract void insertFbpNumberRuleDetail(List<FbpNumberRuleDetails> paramList);
  
  public abstract void removeFbpNumberRuleDetail(List<FbpNumberRuleDetails> paramList);
  
  public abstract void updateFbpNumberRuleDetail(List<FbpNumberRuleDetails> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.numberrule.dao.IFbpNumberRuleDetailsDAO
 * JD-Core Version:    0.7.0.1
 */