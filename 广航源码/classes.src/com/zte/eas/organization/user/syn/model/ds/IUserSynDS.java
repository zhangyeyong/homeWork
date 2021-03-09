package com.zte.eas.organization.user.syn.model.ds;

import com.cmcc.mss.sb_eas_eas_inquiryusersinfosrv.SBEASEASInquiryUsersInfoSrvRequest;
import com.zte.esb.bean.SendEmployeeRequest;
import com.zte.esb.bean.SendEmployeeResponse;
import com.zte.esb.bean.SendRoleInfoRequest;
import com.zte.esb.bean.SendRoleInfoResponse;
import com.zte.esb.bean.SendUserInfoRequest;
import com.zte.esb.bean.SendUserInfoResponse;
import java.rmi.RemoteException;
import java.util.Map;
import javax.xml.rpc.ServiceException;

public abstract interface IUserSynDS
{
  public abstract String synUser(SBEASEASInquiryUsersInfoSrvRequest paramSBEASEASInquiryUsersInfoSrvRequest);
  
  public abstract SendRoleInfoResponse syncRole(SendRoleInfoRequest paramSendRoleInfoRequest);
  
  public abstract SendEmployeeResponse synEmployees(SendEmployeeRequest paramSendEmployeeRequest);
  
  public abstract SendUserInfoResponse synUser(SendUserInfoRequest paramSendUserInfoRequest);
  
  public abstract Map<String, Object> syncUserOrEmployees(SendUserInfoRequest paramSendUserInfoRequest, SendEmployeeRequest paramSendEmployeeRequest);
  
  public abstract void synEmployeeFromHr(String paramString)
    throws ServiceException, RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.user.syn.model.ds.IUserSynDS
 * JD-Core Version:    0.7.0.1
 */