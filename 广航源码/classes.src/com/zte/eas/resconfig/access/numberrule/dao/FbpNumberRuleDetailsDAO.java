package com.zte.eas.resconfig.access.numberrule.dao;

import com.zte.eas.resconfig.business.numberrule.model.FbpNumberRuleDetails;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import java.util.ArrayList;
import java.util.List;

public class FbpNumberRuleDetailsDAO
  extends BaseDAO
  implements IFbpNumberRuleDetailsDAO
{
  public List<FbpNumberRuleDetails> findRuleDetailsByRuleId(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "From FbpNumberRuleDetails f where f.numberRuleId = ?";
    localArrayList.add(Long.valueOf(Long.parseLong(paramString.trim().replace("'", "''"))));
    List localList = super.getZormTemplate().find(str, localArrayList.toArray());
    return localList;
  }
  
  public void removeFbpNumberRuleDetail(Long paramLong)
  {
    super.removeObject(FbpNumberRuleDetails.class, paramLong);
  }
  
  public void removeFbpNumberRuleDetail(FbpNumberRuleDetails paramFbpNumberRuleDetails) {}
  
  public void insertFbpNumberRuleDetail(FbpNumberRuleDetails paramFbpNumberRuleDetails) {}
  
  public void update(FbpNumberRuleDetails paramFbpNumberRuleDetails)
  {
    super.updateObject(paramFbpNumberRuleDetails);
  }
  
  public void insertFbpNumberRuleDetail(List<FbpNumberRuleDetails> paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      FbpNumberRuleDetails localFbpNumberRuleDetails = new FbpNumberRuleDetails();
      localFbpNumberRuleDetails = (FbpNumberRuleDetails)paramList.get(i);
      super.insertObject(localFbpNumberRuleDetails);
    }
  }
  
  public void removeFbpNumberRuleDetail(List<FbpNumberRuleDetails> paramList) {}
  
  public void updateFbpNumberRuleDetail(List<FbpNumberRuleDetails> paramList)
  {
    super.updateObjects(paramList);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.numberrule.dao.FbpNumberRuleDetailsDAO
 * JD-Core Version:    0.7.0.1
 */