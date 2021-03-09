package com.zte.eas.resconfig.access.numberrule.dao;

import com.zte.eas.resconfig.business.numberrule.model.FbpNumberRules;
import com.zte.ssb.framework.base.DAO;
import java.math.BigInteger;
import java.util.List;

public abstract interface IFbpNumberRulesDAO
  extends DAO
{
  public abstract FbpNumberRules findFbpNumberRules(String paramString);
  
  public abstract List<FbpNumberRules> findFbpNumberRuless(String paramString1, String paramString2);
  
  public abstract List<FbpNumberRules> findFbpNumberRuless();
  
  public abstract String getBoeTypeCode(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void removeFbpNumberRules(BigInteger paramBigInteger);
  
  public abstract void removeFbpNumberRules(FbpNumberRules paramFbpNumberRules);
  
  public abstract void insertFbpNumberRules(FbpNumberRules paramFbpNumberRules);
  
  public abstract void updateFbpNumberRules(FbpNumberRules paramFbpNumberRules);
  
  public abstract void insertFbpNumberRuless(List<FbpNumberRules> paramList);
  
  public abstract void removeFbpNumberRuless(List<FbpNumberRules> paramList);
  
  public abstract void updateFbpNumberRuless(List<FbpNumberRules> paramList);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.numberrule.dao.IFbpNumberRulesDAO
 * JD-Core Version:    0.7.0.1
 */