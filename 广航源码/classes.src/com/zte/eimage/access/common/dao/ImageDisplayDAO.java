package com.zte.eimage.access.common.dao;

import com.zte.eas.organization.business.employeemanage.model.FbpEmployeesV;
import com.zte.eimage.business.baseconfig.model.EidImageInfos;
import com.zte.eimage.business.baseconfig.model.EidImages;
import com.zte.eimage.business.baseconfig.util.EidObjectUtils;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.BaseDAO;
import com.zte.ssb.framework.base.util.PageInfo;
import com.zte.ssb.transaction.annotation.Propagation;
import com.zte.ssb.transaction.annotation.Transactional;
import com.zte.ssb.zorm.Query;
import com.zte.ssb.zorm.SQLQuery;
import com.zte.ssb.zorm.Session;
import java.util.ArrayList;
import java.util.List;

public class ImageDisplayDAO
  extends BaseDAO
  implements IImageDisplayDAO
{
  public List findImageByImageNumer(String paramString)
  {
    String str = "select ei.localPath, ei.imagePath, ei.webhostUrl from EidImages ei where ei.imageInfoId = (select eii.imageInfoId from EidImageInfos eii where eii.enabledFlag = 'Y' and eii.imageNumber = '" + paramString.trim() + "') order by ei.imageId";
    List localList = getSession().createQuery(str).list();
    return localList;
  }
  
  public EidImageInfos findEidImageInfos(String paramString)
  {
    String str = "from EidImageInfos where enabledFlag = 'Y' and imageNumber = ?";
    return (EidImageInfos)super.getSession().createQuery(str).setString(0, paramString).uniqueResult();
  }
  
  public String getImageInfo(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("SELECT info.image_info_id||'|'||");
    localStringBuffer.append("       info.image_number||'|'||");
    localStringBuffer.append("       fcts.company_name||'|'||");
    localStringBuffer.append("       fcts.company_code||'|'||");
    localStringBuffer.append("       fcts.set_of_books_code||'|'||");
    localStringBuffer.append("       fots.enabled_flag as type_flag");
    localStringBuffer.append("  FROM eid_image_infos info,  ");
    localStringBuffer.append("       fbp_operation_types fots,");
    localStringBuffer.append("       (select fcy.company_id,");
    localStringBuffer.append("               fcy.company_code,");
    localStringBuffer.append("               fct.company_name,");
    localStringBuffer.append("               fcy.set_of_books_code");
    localStringBuffer.append("          from fbp_company fcy, fbp_company_tl fct");
    localStringBuffer.append("         where fcy.company_id = fct.company_id");
    localStringBuffer.append("           and fct.language = userenv('LANG')) fcts");
    localStringBuffer.append(" WHERE info.enabled_flag = 'Y'");
    localStringBuffer.append("   and fots.operation_type_id = info.operation_type_id");
    localStringBuffer.append("   and fcts.company_id = info.company_id");
    localStringBuffer.append("   and info.image_status in ('FOR_FILING', 'COMPLEMENT_FOR_FILING')");
    localStringBuffer.append("   and info.image_number = ?");
    return (String)super.getSession().createSQLQuery(localStringBuffer.toString()).setString(0, paramString).uniqueResult();
  }
  
  public String getRoleId()
  {
    EidObjectUtils localEidObjectUtils = (EidObjectUtils)SSBBus.findDaoService("eidObjectUtils");
    String str1 = localEidObjectUtils.getEmployeeBySession().getEmployeeNumber();
    String str2 = "select t.role_id from jam.gam_base_role_member t WHERE t.object_id='" + str1 + "' and t.role_id='100000'";
    List localList = getSession().createSQLQuery(str2).list();
    if (localList.size() != 0) {
      return localList.get(0).toString();
    }
    return null;
  }
  
  public PageInfo findImageByImageNumer(String paramString, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList(1);
    localStringBuffer.append(" from EidImages ei  where ei.imageInfoId =(select eii.imageInfoId from EidImageInfos eii where eii.enabledFlag = 'Y' and eii.imageNumber ='" + paramString + "')");
    String str = getRoleId();
    if ((str == null) || (str.equals("")) || ((str != null) && (!str.equals("100000")))) {
      localStringBuffer.append(" and ( ei.isShowImage is null or ei.isShowImage = 'Y')");
    }
    localStringBuffer.append(" order by ei.imageId");
    PageInfo localPageInfo = super.PageInfoQuery(localStringBuffer.toString(), paramInt1, paramInt2, new Object[0]);
    return localPageInfo;
  }
  
  public EidImages getImageShow(Long paramLong1, Long paramLong2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("from EidImages eim where eim.imageId=" + paramLong1 + " and eim.imageInfoId=" + paramLong2);
    List localList = super.find(localStringBuffer.toString(), new Object[0]);
    if ((localList == null) || (localList.size() <= 0)) {
      return null;
    }
    return (EidImages)localList.get(0);
  }
  
  @Transactional(propagation=Propagation.REQUIRED)
  public void updateEidImages(EidImages paramEidImages)
  {
    super.updateObject(paramEidImages);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.access.common.dao.ImageDisplayDAO
 * JD-Core Version:    0.7.0.1
 */