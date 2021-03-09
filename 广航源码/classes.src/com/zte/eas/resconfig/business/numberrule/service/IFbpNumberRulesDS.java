package com.zte.eas.resconfig.business.numberrule.service;

import com.zte.eas.resconfig.business.numberrule.model.FbpNumberRuleDetails;
import com.zte.eas.resconfig.business.numberrule.model.FbpNumberRulesV;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.framework.base.DomainService;
import java.util.HashMap;
import java.util.List;

public abstract interface IFbpNumberRulesDS
  extends DomainService
{
  public abstract String saveNumberRule(FbpNumberRulesV paramFbpNumberRulesV, List<FbpNumberRuleDetails> paramList);
  
  public abstract FbpNumberRulesV findNumberRuleById(String paramString);
  
  public abstract TableDataInfo findNumberRules(FbpNumberRulesV paramFbpNumberRulesV, String paramString1, String paramString2);
  
  public abstract List<FbpNumberRuleDetails> findRuleDetailId(String paramString);
  
  public abstract HashMap findLookupValuesForSelectCtr(String paramString);
  
  public abstract HashMap findLookupValuesBoeClasscode(String paramString);
  
  public abstract FbpNumberRulesV getNumberCode();
  
  public abstract void deleteRows(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.business.numberrule.service.IFbpNumberRulesDS
 * JD-Core Version:    0.7.0.1
 */