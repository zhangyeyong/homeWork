package com.zte.eas.flowruleengine.access.posstru.dao;

import com.zte.eas.flowruleengine.business.posstru.model.FbpPosStruElements;
import com.zte.eas.flowruleengine.business.posstru.model.FbpPosStruElementsV;
import com.zte.eas.flowruleengine.business.posstru.model.FbpPseHoldersV;
import com.zte.eas.flowruleengine.business.posstru.model.FbpPseRelation;
import com.zte.evs.ebill.common.ObjectCopyUtils;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FbpPosStruElementsVDAO
  extends BaseDAO
  implements IFbpPosStruElementsVDAO
{
  public List findPosStruElementsVByQry(FbpPosStruElementsV paramFbpPosStruElementsV)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramFbpPosStruElementsV == null) || (paramFbpPosStruElementsV.getPosStructureCode() == null)) {
      return new ArrayList();
    }
    String str = "from FbpPosStruElementsV s where 1=1";
    str = str + " and s.posStructureCode like ?";
    localArrayList.add("%" + paramFbpPosStruElementsV.getPosStructureCode() + "%");
    if ((paramFbpPosStruElementsV.getEnabledFlag() != null) && (paramFbpPosStruElementsV.getEnabledFlag().equals("N")))
    {
      str = str + " and s.enabledFlag = ?";
      localArrayList.add("Y");
    }
    if (paramFbpPosStruElementsV.getParentPosStruElementId() != null)
    {
      str = str + " and s.parentPosStruElementId = ?";
      localArrayList.add(paramFbpPosStruElementsV.getParentPosStruElementId());
    }
    if (paramFbpPosStruElementsV.getPositionId() != null)
    {
      str = str + " and s.positionId = ?";
      localArrayList.add(paramFbpPosStruElementsV.getPositionId());
    }
    if ((paramFbpPosStruElementsV.getDeterminer() != null) && (!paramFbpPosStruElementsV.getDeterminer().trim().equals("")))
    {
      str = str + " and s.determiner = ?";
      localArrayList.add(paramFbpPosStruElementsV.getDeterminer());
    }
    str = str + " order by nlssort(s.determinerName,'NLS_SORT=SCHINESE_PINYIN_M') asc";
    List localList = getZormTemplate().find(str, localArrayList.toArray());
    return localList;
  }
  
  public FbpPosStruElementsV findPosStruElementsVById(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString == null) {
      return new FbpPosStruElementsV();
    }
    String str = "from FbpPosStruElementsV s where s.posStruElementId = ?";
    localArrayList.add(Long.valueOf(Long.parseLong(paramString)));
    return (FbpPosStruElementsV)getZormTemplate().find(str, localArrayList.toArray()).get(0);
  }
  
  public FbpPosStruElements findVirtualCompanyId(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer("from FbpPosStruElements where enabledFlag = 'Y' and posStructureCode = ? and determiner = ?");
    return (FbpPosStruElements)super.getSession().createQuery(localStringBuffer.toString()).setString(0, paramString1).setString(1, paramString2).uniqueResult();
  }
  
  public void delOldRelations(String paramString, Long paramLong1, Long paramLong2)
  {
    String str1 = "select company_id from fbp.fbp_company where company_code = ?";
    BigDecimal localBigDecimal = (BigDecimal)super.getSession().createSQLQuery(str1).setString(0, paramString).uniqueResult();
    String str2 = "delete from fbp.fbp_pse_relations pr where pr.employee_id = ? and pr.company_id = ? and pr.pse_holder_id = ?";
    super.getSession().createSQLQuery(str2).setLong(0, paramLong1.longValue()).setLong(1, localBigDecimal.longValue()).setLong(2, paramLong2.longValue()).executeUpdate();
  }
  
  public String saveRelations(String paramString, List<FbpPseHoldersV> paramList)
  {
    String str1 = "Y";
    if ((paramList == null) || (paramList.isEmpty()) || (paramString == null) || (paramString.trim().length() == 0)) {
      return str1;
    }
    String str2 = "select company_id from fbp.fbp_company where company_code = ?";
    BigDecimal localBigDecimal = (BigDecimal)super.getSession().createSQLQuery(str2).setString(0, paramString).uniqueResult();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FbpPseHoldersV localFbpPseHoldersV = (FbpPseHoldersV)localIterator.next();
      String[] arrayOfString = (localFbpPseHoldersV.getOperationTypeIds() == null) || (localFbpPseHoldersV.getOperationTypeIds().trim().length() == 0) ? null : localFbpPseHoldersV.getOperationTypeIds().split(",");
      delOldRelations(paramString, localFbpPseHoldersV.getEmployeeId(), localFbpPseHoldersV.getPseHolderId());
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        for (String str3 : arrayOfString)
        {
          FbpPseRelation localFbpPseRelation = new FbpPseRelation();
          ObjectCopyUtils.setWho(localFbpPseRelation);
          localFbpPseRelation.setCompanyId(Long.valueOf(localBigDecimal.longValue()));
          localFbpPseRelation.setOperationTypeId(Long.valueOf(str3));
          localFbpPseRelation.setEmployeeId(localFbpPseHoldersV.getEmployeeId());
          localFbpPseRelation.setEnabledFlag("Y");
          localFbpPseRelation.setPseHolderId(localFbpPseHoldersV.getPseHolderId());
          super.insertObject(localFbpPseRelation);
        }
      }
      else
      {
        ??? = new FbpPseRelation();
        ObjectCopyUtils.setWho(???);
        ((FbpPseRelation)???).setCompanyId(Long.valueOf(localBigDecimal.longValue()));
        ((FbpPseRelation)???).setEmployeeId(localFbpPseHoldersV.getEmployeeId());
        ((FbpPseRelation)???).setEnabledFlag("Y");
        ((FbpPseRelation)???).setPseHolderId(localFbpPseHoldersV.getPseHolderId());
        super.insertObject(???);
      }
    }
    return str1;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.flowruleengine.access.posstru.dao.FbpPosStruElementsVDAO
 * JD-Core Version:    0.7.0.1
 */