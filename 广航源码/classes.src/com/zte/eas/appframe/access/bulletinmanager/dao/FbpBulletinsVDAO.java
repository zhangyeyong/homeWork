package com.zte.eas.appframe.access.bulletinmanager.dao;

import com.zte.eas.appframe.business.bulletinmanager.model.FbpBulletinsV;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.orm.zorm.ZormTemplate;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FbpBulletinsVDAO
  extends BaseDAO
  implements IFbpBulletinsVDAO
{
  public PageInfo findFbpBulletinsVByCon(FbpBulletinsV paramFbpBulletinsV, int paramInt1, int paramInt2)
  {
    String str1 = null;
    Object localObject = null;
    ArrayList localArrayList = new ArrayList();
    String str2 = "From FbpBulletinsV f where 1=1 and f.isRollFlag = 'Y'";
    String str3 = findExtentIds(Long.valueOf(paramFbpBulletinsV.getAttribute2()));
    if ((paramFbpBulletinsV.getBulletinTitle() != null) && (!paramFbpBulletinsV.getBulletinTitle().equals("")))
    {
      str2 = str2 + " and f.bulletinTitle like ? ";
      localArrayList.add("%" + paramFbpBulletinsV.getBulletinTitle().trim().replaceAll("'", "''") + "%");
    }
    if (str3 != null) {
      str2 = str2 + " and f.bulletinId in ( " + str3 + " ) ";
    }
    if ((paramFbpBulletinsV.getBulletinCatagoryCode() != null) && (!paramFbpBulletinsV.getBulletinCatagoryCode().equals("")))
    {
      str2 = str2 + "and f.bulletinCatagoryCode= ? ";
      localArrayList.add(paramFbpBulletinsV.getBulletinCatagoryCode());
    }
    if ((paramFbpBulletinsV.getStartDateActive() != null) && (paramFbpBulletinsV.getEndDateActive() != null) && (paramFbpBulletinsV.getStartDateActive() == paramFbpBulletinsV.getEndDateActive()))
    {
      str1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paramFbpBulletinsV.getStartDateActive());
      str2 = str2 + " AND f.creationDate >= ?";
      localArrayList.add(paramFbpBulletinsV.getStartDateActive());
    }
    else
    {
      if ((paramFbpBulletinsV.getStartDateActive() != null) && (!paramFbpBulletinsV.getStartDateActive().equals("")))
      {
        str1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paramFbpBulletinsV.getStartDateActive());
        str2 = str2 + " and f.creationDate >= ? ";
        localArrayList.add(paramFbpBulletinsV.getStartDateActive());
      }
      if (paramFbpBulletinsV.getEndDateActive() != null)
      {
        Date localDate = new Date(paramFbpBulletinsV.getEndDateActive().getTime() + 86400000L);
        String str4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(localDate).toString();
        str2 = str2 + " AND f.creationDate <= ?";
        localArrayList.add(localDate);
      }
    }
    str2 = str2 + " and f.startDateActive <= sysdate and f.endDateActive >= sysdate - 1 ";
    str2 = str2 + " order by f.lastUpdateDate desc";
    paramInt1 = paramInt1 / paramInt2 + 1;
    return super.PageInfoQuery(str2, paramInt1, paramInt2, localArrayList.toArray());
  }
  
  public PageInfo findFbpBulletinsVByCons(FbpBulletinsV paramFbpBulletinsV, int paramInt1, int paramInt2)
  {
    String str1 = null;
    Object localObject = null;
    ArrayList localArrayList = new ArrayList();
    String str2 = "From FbpBulletinsV f where 1=1 ";
    String str3 = findExtentIds(Long.valueOf(paramFbpBulletinsV.getAttribute2()));
    if ((paramFbpBulletinsV.getBulletinTitle() != null) && (!paramFbpBulletinsV.getBulletinTitle().equals("")))
    {
      str2 = str2 + " and f.bulletinTitle like ? ";
      localArrayList.add("%" + paramFbpBulletinsV.getBulletinTitle().trim().replaceAll("'", "''") + "%");
    }
    if (str3 != null) {
      str2 = str2 + " and ( f.bulletinId in ( " + str3 + " ) or f.createdBy = " + Long.valueOf(paramFbpBulletinsV.getAttribute10()) + " )";
    }
    if ((paramFbpBulletinsV.getBulletinCatagoryCode() != null) && (!paramFbpBulletinsV.getBulletinCatagoryCode().equals("")))
    {
      str2 = str2 + "and f.bulletinCatagoryCode= ? ";
      localArrayList.add(paramFbpBulletinsV.getBulletinCatagoryCode());
    }
    if ((paramFbpBulletinsV.getStartDateActive() != null) && (paramFbpBulletinsV.getEndDateActive() != null) && (paramFbpBulletinsV.getStartDateActive() == paramFbpBulletinsV.getEndDateActive()))
    {
      str1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paramFbpBulletinsV.getStartDateActive());
      str2 = str2 + " AND f.creationDate >= ?";
      localArrayList.add(paramFbpBulletinsV.getStartDateActive());
    }
    else
    {
      if ((paramFbpBulletinsV.getStartDateActive() != null) && (!paramFbpBulletinsV.getStartDateActive().equals("")))
      {
        str1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paramFbpBulletinsV.getStartDateActive());
        str2 = str2 + " and f.creationDate >= ? ";
        localArrayList.add(paramFbpBulletinsV.getStartDateActive());
      }
      if (paramFbpBulletinsV.getEndDateActive() != null)
      {
        Date localDate = new Date(paramFbpBulletinsV.getEndDateActive().getTime() + 86400000L);
        String str4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(localDate).toString();
        str2 = str2 + " AND f.creationDate <= ?";
        localArrayList.add(localDate);
      }
    }
    str2 = str2 + " order by f.lastUpdateDate desc";
    paramInt1 = paramInt1 / paramInt2 + 1;
    return super.PageInfoQuery(str2, paramInt1, paramInt2, localArrayList.toArray());
  }
  
  public FbpBulletinsV findFbpBulletinsVById(Long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "From FbpBulletinsV f where f.bulletinId = ? ";
    localArrayList.add(Long.valueOf(paramLong.longValue()));
    FbpBulletinsV localFbpBulletinsV = new FbpBulletinsV();
    List localList = super.getZormTemplate().find(str, localArrayList.toArray());
    if (localList.size() > 0) {
      localFbpBulletinsV = (FbpBulletinsV)localList.get(0);
    }
    return localFbpBulletinsV;
  }
  
  public String findDeptId(Long paramLong)
  {
    String str = " select a.dept_id from (select * from apps.fbp_depts_v a start with a.dept_id = " + paramLong + " connect by prior" + " a.parent_dept_id = a.dept_id)a where a.parent_dept_id=0";
    List localList = super.getSession().createSQLQuery(str).list();
    if ((localList != null) && (localList.size() > 0))
    {
      Object localObject = localList.get(0);
      return localObject.toString();
    }
    return "";
  }
  
  public String findExtentIds(Long paramLong)
  {
    String str1 = " select c.bulletin_id from (select a.bulletin_id ,b.attribute1,a.extent_name from fbp.fbp_bulletins a, fbp.fbp_bulletins_dept b where a.bulletin_id=b.bulletin_id(+) group by a.bulletin_id , b.attribute1,a.extent_name) c where c.extent_name is null or c.attribute1 = '" + paramLong + "'";
    String str2 = "-99999";
    List localList = super.getSession().createSQLQuery(str1).list();
    if ((localList != null) && (localList.size() > 0)) {
      for (int i = 0; i < localList.size(); i++) {
        if (localList.get(i) != null) {
          if (str2.equals("-99999")) {
            str2 = "'" + localList.get(i).toString() + "'";
          } else {
            str2 = str2 + ",'" + localList.get(i).toString() + "'";
          }
        }
      }
    }
    return str2;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.access.bulletinmanager.dao.FbpBulletinsVDAO
 * JD-Core Version:    0.7.0.1
 */