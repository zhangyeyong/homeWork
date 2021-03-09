package com.zte.eas.resconfig.access.numberrule.dao;

import com.zte.eas.resconfig.business.numberrule.model.FbpNumberRules;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class FbpNumberRulesDAO
  extends BaseDAO
  implements IFbpNumberRulesDAO
{
  public FbpNumberRules findFbpNumberRules(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "From FbpNumberRules f where f.numberRuleId = ?";
    localArrayList.add(Long.valueOf(Long.parseLong(paramString.trim().replaceAll("'", "''"))));
    List localList = super.getZormTemplate().find(str, localArrayList.toArray());
    FbpNumberRules localFbpNumberRules = new FbpNumberRules();
    if (localList.size() > 0) {
      localFbpNumberRules = (FbpNumberRules)localList.get(0);
    }
    return localFbpNumberRules;
  }
  
  public List findFbpNumberRuless()
  {
    String str = "From FbpNumberRules where 1=1";
    List localList = getZormTemplate().find(str);
    return localList;
  }
  
  public List<FbpNumberRules> findFbpNumberRuless(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "From FbpNumberRules f where f.numberRuleName= ? or f.numberRuleCode= ?";
    localArrayList.add(paramString1.trim().replaceAll("'", "''"));
    localArrayList.add(paramString2.trim().replaceAll("'", "''"));
    List localList = super.getZormTemplate().find(str, localArrayList.toArray());
    return localList;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpNumberRules(FbpNumberRules paramFbpNumberRules)
  {
    super.removeObject(paramFbpNumberRules);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpNumberRules(FbpNumberRules paramFbpNumberRules)
  {
    super.insertObject(paramFbpNumberRules);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpNumberRules(FbpNumberRules paramFbpNumberRules)
  {
    super.updateObject(paramFbpNumberRules);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpNumberRuless(List<FbpNumberRules> paramList)
  {
    FbpNumberRules localFbpNumberRules = new FbpNumberRules();
    for (int i = 0; i < paramList.size(); i++) {
      localFbpNumberRules = (FbpNumberRules)paramList.get(i);
    }
    super.getZormTemplate().save(localFbpNumberRules);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpNumberRuless(List<FbpNumberRules> paramList)
  {
    super.removeObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpNumberRuless(List<FbpNumberRules> paramList)
  {
    super.updateObjects(paramList);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void removeFbpNumberRules(BigInteger paramBigInteger)
  {
    super.removeObject(FbpNumberRules.class, paramBigInteger);
  }
  
  public String getBoeTypeCode(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str = "";
    Session localSession = getSession();
    Connection localConnection = localSession.connection();
    CallableStatement localCallableStatement = null;
    try
    {
      synchronized (this)
      {
        localCallableStatement = localConnection.prepareCall("{call FBP_GENERATION_NUMBER_PKG.get_generation_number(?,?,?,?,?,?)}");
        localCallableStatement.setString(1, paramString1);
        localCallableStatement.setString(2, paramString2);
        localCallableStatement.setString(3, paramString3);
        localCallableStatement.setString(4, paramString4);
        localCallableStatement.setString(5, paramString5.toUpperCase());
        localCallableStatement.registerOutParameter(6, 12);
        localCallableStatement.execute();
        str = localCallableStatement.getString(6);
      }
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    finally
    {
      try
      {
        if (localCallableStatement != null)
        {
          localConnection.commit();
          localCallableStatement.close();
          localConnection.close();
        }
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
      }
      localCallableStatement = null;
      localConnection = null;
    }
    return str;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.resconfig.access.numberrule.dao.FbpNumberRulesDAO
 * JD-Core Version:    0.7.0.1
 */