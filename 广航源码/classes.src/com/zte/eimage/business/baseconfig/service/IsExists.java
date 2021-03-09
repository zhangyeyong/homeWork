package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.access.baseconfig.dao.IEidImageInfosDAO;
import com.zte.eimage.business.baseconfig.model.IsExistsResponse;
import com.zte.eimage.business.common.model.Fbplogins;
import com.zte.ssb.framework.SSBBus;
import java.math.BigInteger;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IsExists
  implements IIsExists
{
  Log log = LogFactory.getLog(IsExists.class);
  
  public IsExistsResponse[] IsExist(String paramString1, String paramString2, String paramString3)
  {
    this.log.error("sessionID:  " + paramString1);
    Fbplogins localFbplogins = EvsServiceSessionMap.getLoginInfo(paramString1);
    if (localFbplogins == null)
    {
      this.log.error("获取登录信息失败!");
      return null;
    }
    IEidImageInfosDAO localIEidImageInfosDAO = (IEidImageInfosDAO)SSBBus.findDaoService("eidImageInfosDAO");
    List localList = localIEidImageInfosDAO.findImageByUser(paramString2, Long.valueOf(localFbplogins.getUserId().longValue()));
    if ((localList != null) && (!localList.isEmpty()))
    {
      IsExistsResponse[] arrayOfIsExistsResponse = new IsExistsResponse[localList.size()];
      for (int i = 0; i < localList.size(); i++)
      {
        Object[] arrayOfObject = (Object[])localList.get(i);
        IsExistsResponse localIsExistsResponse = new IsExistsResponse();
        localIsExistsResponse.setImageNumber(setString(arrayOfObject[0]));
        localIsExistsResponse.setTaskNumber(setString(arrayOfObject[1]));
        localIsExistsResponse.setFtpId(setInteger(arrayOfObject[2]));
        localIsExistsResponse.setImageCount(setInteger(arrayOfObject[3]));
        localIsExistsResponse.setCompanyCode(setString(arrayOfObject[4]));
        localIsExistsResponse.setCompanyName(setString(arrayOfObject[5]));
        localIsExistsResponse.setOperationTypeCode(setString(arrayOfObject[6]));
        localIsExistsResponse.setOperationTypeName(setString(arrayOfObject[7]));
        localIsExistsResponse.setIsBoe(setString(arrayOfObject[8]));
        localIsExistsResponse.setAttribute1(setString(arrayOfObject[10]));
        String str = setString(arrayOfObject[9]);
        if ((str != null) && (str.lastIndexOf("/") > 0)) {
          str = str.substring(0, str.lastIndexOf("/"));
        }
        localIsExistsResponse.setImagePath(str);
        arrayOfIsExistsResponse[i] = localIsExistsResponse;
      }
      return arrayOfIsExistsResponse;
    }
    return null;
  }
  
  public String getImageSeqNo(String paramString)
  {
    Fbplogins localFbplogins = EvsServiceSessionMap.getLoginInfo(paramString);
    if (localFbplogins == null)
    {
      this.log.error("获取登录信息失败!");
      return null;
    }
    IEidImageInfosDAO localIEidImageInfosDAO = (IEidImageInfosDAO)SSBBus.findDaoService("eidImageInfosDAO");
    String str = localIEidImageInfosDAO.getImageSeqNo();
    return str;
  }
  
  private String setString(Object paramObject)
  {
    return paramObject == null ? "" : paramObject.toString();
  }
  
  private Integer setInteger(Object paramObject)
  {
    return paramObject == null ? null : Integer.valueOf(paramObject.toString());
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.IsExists
 * JD-Core Version:    0.7.0.1
 */