package com.zte.eas.resconfig.access.numberrule.dao;

import com.zte.eas.resconfig.business.numberrule.model.FbpNumberRulesV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.orm.zorm.ZormTemplate;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FbpNumberRulesVDAO
  extends BaseDAO
  implements IFbpNumberRulesVDAO
{
  public FbpNumberRulesV findFbpNumberRulesVById(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "From FbpNumberRulesV f where f.numberRuleId = ?";
    localArrayList.add(Long.valueOf(Long.parseLong(paramString.trim().replaceAll("'", "''"))));
    List localList = super.getZormTemplate().find(str, localArrayList.toArray());
    FbpNumberRulesV localFbpNumberRulesV = new FbpNumberRulesV();
    if (localList.size() > 0) {
      localFbpNumberRulesV = (FbpNumberRulesV)localList.get(0);
    }
    return localFbpNumberRulesV;
  }
  
  public PageInfo findFbpNumberRulesVsByCond(FbpNumberRulesV paramFbpNumberRulesV, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = null;
    String str2 = null;
    String str3 = " From FbpNumberRulesV f where 1=1  ";
    if (paramFbpNumberRulesV.getStartDate() != null)
    {
      System.out.println("o.getStartDate()" + paramFbpNumberRulesV.getStartDate());
      str1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paramFbpNumberRulesV.getStartDate());
    }
    if (paramFbpNumberRulesV.getEndDate() != null)
    {
      System.out.println("o.getEndDate()" + paramFbpNumberRulesV.getEndDate());
      str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paramFbpNumberRulesV.getEndDate());
    }
    System.out.println("stratDate::" + str1);
    System.out.println("endDates::" + str2);
    if ((paramFbpNumberRulesV.getNumberRuleName() != null) && (!paramFbpNumberRulesV.getNumberRuleName().equals("")))
    {
      str3 = str3 + " and  f.startDate <> ? and  f.endDate <> ? and  f.numberRuleName<> ?";
      localArrayList.add(paramFbpNumberRulesV.getStartDate());
      localArrayList.add(paramFbpNumberRulesV.getEndDate());
      localArrayList.add(paramFbpNumberRulesV.getNumberRuleName());
    }
    str3 = str3 + " order by f.lastUpdateDate desc";
    paramInt1 = paramInt1 / paramInt2 + 1;
    return super.PageInfoQuery(str3, paramInt1, paramInt2, localArrayList.toArray());
  }
  
  public List<FbpNumberRulesV> findFbpNumberRulesBoe(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str = " From FbpNumberRulesV f where f.meaning = ?";
    localArrayList.add(paramString);
    List localList = super.getZormTemplate().find(str, localArrayList.toArray());
    return localList;
  }
  
  public List<FbpNumberRulesV> findCodeDw(FbpNumberRulesV paramFbpNumberRulesV)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = null;
    String str2 = null;
    String str3 = "From FbpNumberRulesV f where 1=1 and f.enabledFlag = 'Y' ";
    if ((paramFbpNumberRulesV != null) && (paramFbpNumberRulesV.getNumberRuleId() != null))
    {
      str3 = str3 + " and f.numberRuleId <> ?";
      localArrayList.add(paramFbpNumberRulesV.getNumberRuleId());
    }
    if (paramFbpNumberRulesV.getStartDate() != null) {
      str1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paramFbpNumberRulesV.getStartDate());
    }
    if (paramFbpNumberRulesV.getEndDate() != null) {
      str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paramFbpNumberRulesV.getEndDate());
    }
    if ((paramFbpNumberRulesV.getNumberRuleName() != null) && (!paramFbpNumberRulesV.getNumberRuleName().equals("")))
    {
      localObject = new Date(paramFbpNumberRulesV.getEndDate().getTime() + 86400000L);
      str3 = str3 + " and  f.boeClassCode= ?";
      localArrayList.add(paramFbpNumberRulesV.getBoeClassCode());
      str3 = str3 + " and f.endDate >= current_timestamp()";
      str3 = str3 + " and  ((f.startDate >= ? and  f.startDate <= ?)";
      localArrayList.add(paramFbpNumberRulesV.getStartDate());
      localArrayList.add(localObject);
      str3 = str3 + " or  (f.endDate >= ? and  f.endDate <= ?)";
      localArrayList.add(paramFbpNumberRulesV.getStartDate());
      localArrayList.add(localObject);
      str3 = str3 + " or  (f.startDate <= ? and  f.endDate >= ?))";
      localArrayList.add(paramFbpNumberRulesV.getStartDate());
      localArrayList.add(localObject);
    }
    Object localObject = super.getZormTemplate().find(str3, localArrayList.toArray());
    return localObject;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.numberrule.dao.FbpNumberRulesVDAO
 * JD-Core Version:    0.7.0.1
 */