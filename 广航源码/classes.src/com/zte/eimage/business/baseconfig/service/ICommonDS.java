package com.zte.eimage.business.baseconfig.service;

import com.zte.eimage.business.baseconfig.model.IsExistsResponse;
import com.zte.eimage.business.baseconfig.model.UserInfo;
import com.zte.ssb.framework.base.DomainService;

public abstract interface ICommonDS
  extends DomainService
{
  public abstract String GetSpecialTimeSpan(String paramString);
  
  public abstract String FtpInfo(String paramString1, String paramString2, int paramInt);
  
  public abstract int GetImageCount(String paramString1, String paramString2);
  
  public abstract String GetScanConfig(String paramString);
  
  public abstract String GetServCmdInfo(String paramString1, String paramString2);
  
  public abstract String checkImageSeqNo(String paramString);
  
  public abstract IsExistsResponse[] IsExist(String paramString1, String paramString2, String paramString3);
  
  public abstract String IsFinishByID(int paramInt);
  
  public abstract boolean IsLogin(String paramString);
  
  public abstract UserInfo Login(String paramString1, String paramString2, String paramString3);
  
  public abstract void Logout(String paramString);
  
  public abstract boolean RealTimeAllow(String paramString1, String paramString2);
  
  public abstract String RelativePath(String paramString1, String paramString2, int paramInt);
  
  public abstract int UploadLog(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6, String paramString7);
  
  public abstract String CurrentTime(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eimage.business.baseconfig.service.ICommonDS
 * JD-Core Version:    0.7.0.1
 */