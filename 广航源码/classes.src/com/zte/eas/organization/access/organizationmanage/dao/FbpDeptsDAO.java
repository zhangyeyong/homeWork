package com.zte.eas.organization.access.organizationmanage.dao;

import com.zte.eas.organization.business.organizationmanage.model.FbpDepts;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsTl;
import com.zte.eas.organization.business.organizationmanage.model.FbpDeptsV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FbpDeptsDAO
  extends BaseDAO
  implements IFbpDeptsDAO
{
  public FbpDepts getFbpDepts(BigInteger paramBigInteger)
  {
    return (FbpDepts)super.getObject(FbpDepts.class, paramBigInteger);
  }
  
  public FbpDepts getFbpDeptsByCode(String paramString)
  {
    String str = "select dept from FbpDepts dept where dept.deptCode='" + paramString + "'";
    FbpDepts localFbpDepts = (FbpDepts)super.getSession().createQuery(str).uniqueResult();
    return localFbpDepts;
  }
  
  public List getFbpDeptss()
  {
    return super.getObjects(FbpDepts.class);
  }
  
  public List<FbpDepts> getFbpDeptss(int paramInt1, int paramInt2)
  {
    return super.getObjects(FbpDepts.class, paramInt1, paramInt2);
  }
  
  public void removeFbpDepts(FbpDepts paramFbpDepts)
  {
    super.removeObject(paramFbpDepts);
  }
  
  public void insertFbpDepts(FbpDepts paramFbpDepts)
  {
    super.insertObject(paramFbpDepts);
  }
  
  public void updateFbpDepts(FbpDepts paramFbpDepts)
  {
    super.updateObject(paramFbpDepts);
  }
  
  public void insertFbpDeptss(List<FbpDepts> paramList)
  {
    super.insertObjects(paramList);
  }
  
  public void removeFbpDeptss(List<FbpDepts> paramList)
  {
    super.removeObjects(paramList);
  }
  
  public void updateFbpDeptss(List<FbpDepts> paramList)
  {
    super.updateObjects(paramList);
  }
  
  public void removeFbpDepts(BigInteger paramBigInteger)
  {
    super.removeObject(FbpDepts.class, paramBigInteger);
  }
  
  public List findOffspringDepts(BigInteger paramBigInteger, String paramString)
  {
    BigInteger localBigInteger1 = null;
    ArrayList localArrayList = new ArrayList();
    List localList2 = getSession().createQuery("from FbpDepts b where b.defaultCheckUnit =:defaultCheckUnit").setString("defaultCheckUnit", paramString).list();
    BigInteger localBigInteger2 = null;
    Iterator localIterator = localList2.iterator();
    while (localIterator.hasNext())
    {
      FbpDepts localFbpDepts = (FbpDepts)localIterator.next();
      if (localFbpDepts.getDeptId().equals(paramBigInteger)) {
        localBigInteger2 = localFbpDepts.getParentDeptId();
      }
    }
    if (localBigInteger2.equals(BigInteger.valueOf(Long.valueOf(0L).longValue()))) {
      localBigInteger1 = paramBigInteger;
    } else {
      localBigInteger1 = findSecondDeptID(paramBigInteger, paramBigInteger, paramBigInteger, localList2);
    }
    localArrayList.add(localBigInteger1);
    List localList1 = findOffspringDeptID(localArrayList, localList2);
    if ((localList1.size() > 1) && (localBigInteger2.equals(BigInteger.valueOf(Long.valueOf(0L).longValue())))) {
      localList1.remove(0);
    }
    return localList1;
  }
  
  private BigInteger findSecondDeptID(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, List<FbpDepts> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FbpDepts localFbpDepts = (FbpDepts)localIterator.next();
      if (localFbpDepts.getDeptId().equals(paramBigInteger1))
      {
        paramBigInteger3 = paramBigInteger2;
        paramBigInteger2 = paramBigInteger1;
        paramBigInteger1 = localFbpDepts.getParentDeptId();
        if (paramBigInteger1.equals(BigInteger.valueOf(Long.valueOf(0L).longValue()))) {
          return paramBigInteger3;
        }
        return findSecondDeptID(paramBigInteger1, paramBigInteger2, paramBigInteger3, paramList);
      }
    }
    return paramBigInteger3;
  }
  
  public FbpDeptsV findDeptByCompId(String paramString)
  {
    List localList = getSession().createQuery("from FbpDeptsV b where b.attribute7 =:compId").setString("compId", paramString).list();
    if (localList.size() > 0)
    {
      FbpDeptsV localFbpDeptsV = (FbpDeptsV)localList.get(0);
      return localFbpDeptsV;
    }
    return null;
  }
  
  private List<BigInteger> findOffspringDeptID(List<BigInteger> paramList, List<FbpDepts> paramList1)
  {
    int i = paramList.size();
    int j = 0;
    int k = paramList.size();
    while (j < k)
    {
      BigInteger localBigInteger1 = (BigInteger)paramList.get(j);
      int m = 0;
      int n = paramList1.size();
      while (m < n)
      {
        FbpDepts localFbpDepts = (FbpDepts)paramList1.get(m);
        BigInteger localBigInteger2 = localFbpDepts.getParentDeptId();
        BigInteger localBigInteger3 = localFbpDepts.getDeptId();
        if (localBigInteger1.equals(localBigInteger2))
        {
          paramList.add(localBigInteger3);
          paramList1.remove(localFbpDepts);
          n = paramList1.size();
        }
        m++;
      }
      j++;
    }
    if (i != paramList.size()) {
      return findOffspringDeptID(paramList, paramList1);
    }
    return paramList;
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void insertFbpDeptsTl(FbpDeptsTl paramFbpDeptsTl)
  {
    super.insertObject(paramFbpDeptsTl);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateFbpDeptsTl(FbpDeptsTl paramFbpDeptsTl)
  {
    super.updateObject(paramFbpDeptsTl);
  }
  
  public FbpDeptsTl findFbpDeptsTls(BigInteger paramBigInteger, String paramString)
  {
    FbpDeptsTl localFbpDeptsTl = null;
    String str = "from FbpDeptsTl t where t.deptTlPK.deptId = " + paramBigInteger + " and t.deptTlPK.language = '" + paramString + "'";
    localFbpDeptsTl = (FbpDeptsTl)super.getSession().createQuery(str).uniqueResult();
    return localFbpDeptsTl;
  }
  
  public List<FbpDepts> findOffspringDepts(BigInteger paramBigInteger)
  {
    String str = "select * from fbp.fbp_depts dept where 1=1 start with dept.dept_id = " + paramBigInteger + " connect by prior dept.dept_id = dept.parent_dept_id";
    List localList = super.getSession().createSQLQuery(str).addEntity(FbpDepts.class).list();
    return localList;
  }
  
  public boolean findWayBill(String paramString)
  {
    Integer localInteger = Integer.valueOf(0);
    String str = "select COUNT(1) from sie.sie_boe_headers bh,fbp.fbp_depts dept,wfr.wfr_bill_status bs  WHERE bh.boe_dept_id = dept.dept_id  AND bh.boe_header_id = bs.boe_header_id  AND dept.dept_code = '" + paramString + "'" + " AND bs.current_status IN" + "('200_WAIT_BUSINESS_APPROVE'," + "'210_WAIT_COUNTERSIGN_APPROVE'," + "'220_WAIT_FINANCIAL_PRE_APPROVE'," + "'230_WAIT_FINANCIAL_APPROVE'," + "'240_WAIT_FINAN_LEADER_APPROVE'," + "'250_WAIT_FINAN_LEADER_AUDIT')";
    localInteger = Integer.valueOf(Integer.parseInt(super.getSession().createSQLQuery(str).uniqueResult().toString()));
    return localInteger.intValue() > 0;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.access.organizationmanage.dao.FbpDeptsDAO
 * JD-Core Version:    0.7.0.1
 */