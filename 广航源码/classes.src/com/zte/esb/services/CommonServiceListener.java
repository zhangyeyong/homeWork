package com.zte.esb.services;

import com.zte.eas.getData.util.EisConsts;
import com.zte.esb.bean.SendUserInfoProcessReult;
import com.zte.esb.bean.SendUserInfoResponse;
import com.zte.esb.bean.UserInfo;
import java.util.ArrayList;
import java.util.List;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.apache.log4j.Logger;

public class CommonServiceListener
  implements MessageListener
{
  private static Logger log = Logger.getLogger(CommonServiceListener.class);
  private SendEmployeeRequestListener employeeRequestListener;
  private AdminOrgRequestListener adminOrgRequestListener;
  private AreaRequestListener areaRequestListener;
  private EisEvaluationRequestListener eisEvaluationRequestListener;
  private SendDegreeRequestListener degreeRequestListener;
  private SendPositionRequestListener positionRequestListener;
  private SendRoleInfoRequestListener roleInfoRequestListener;
  private UserRequestListener userRequestListener;
  
  public void onMessage(Message paramMessage)
  {
    try
    {
      log.error("公共服务端监听begin...");
      String str = paramMessage.getStringProperty("backServiceCode");
      try
      {
        log.error("esbServiceCode=" + str);
        log.error("请求报文=" + ((TextMessage)paramMessage).getText());
      }
      catch (Exception localException2)
      {
        log.error(localException2.getMessage(), localException2);
      }
      EisConsts.printMsg(paramMessage, log);
      if ("EIS_ESB2EIS_SEND_EMPLOYEE_EIS".equals(str)) {
        this.employeeRequestListener.onMessage(paramMessage);
      } else if ("EIS_ESB2EIS_EVALUATION".equals(str)) {
        this.eisEvaluationRequestListener.onMessage(paramMessage);
      } else if ("EIS_ESB2EIS_SEND_ADMINORG_EIS".equals(str)) {
        this.adminOrgRequestListener.onMessage(paramMessage);
      } else if ("EIS_ESB2EIS_SEND_DEGREE_EIS".equals(str)) {
        this.degreeRequestListener.onMessage(paramMessage);
      } else if ("EIS_ESB2EIS_SEND_POSITION_EIS".equals(str)) {
        this.positionRequestListener.onMessage(paramMessage);
      } else if ("EIS_ESB2EIS_SEND_ROLEINFO_EIS".equals(str)) {
        this.roleInfoRequestListener.onMessage(paramMessage);
      } else if ("EIS_ESB2EIS_SEND_USERINFO_EIS".equals(str)) {
        this.userRequestListener.onMessage(paramMessage);
      } else if ("EIS_ESB2EIS_SYNC_DISTRICT".equals(str)) {
        this.areaRequestListener.onMessage(paramMessage);
      }
    }
    catch (Exception localException1)
    {
      log.error("公共服务端监听异常:" + localException1.getMessage(), localException1);
    }
    log.error("公共服务端监听end...");
  }
  
  public SendEmployeeRequestListener getEmployeeRequestListener()
  {
    return this.employeeRequestListener;
  }
  
  public void setEmployeeRequestListener(SendEmployeeRequestListener paramSendEmployeeRequestListener)
  {
    this.employeeRequestListener = paramSendEmployeeRequestListener;
  }
  
  public AdminOrgRequestListener getAdminOrgRequestListener()
  {
    return this.adminOrgRequestListener;
  }
  
  public void setAdminOrgRequestListener(AdminOrgRequestListener paramAdminOrgRequestListener)
  {
    this.adminOrgRequestListener = paramAdminOrgRequestListener;
  }
  
  public AreaRequestListener getAreaRequestListener()
  {
    return this.areaRequestListener;
  }
  
  public void setAreaRequestListener(AreaRequestListener paramAreaRequestListener)
  {
    this.areaRequestListener = paramAreaRequestListener;
  }
  
  public EisEvaluationRequestListener getEisEvaluationRequestListener()
  {
    return this.eisEvaluationRequestListener;
  }
  
  public void setEisEvaluationRequestListener(EisEvaluationRequestListener paramEisEvaluationRequestListener)
  {
    this.eisEvaluationRequestListener = paramEisEvaluationRequestListener;
  }
  
  public SendDegreeRequestListener getDegreeRequestListener()
  {
    return this.degreeRequestListener;
  }
  
  public void setDegreeRequestListener(SendDegreeRequestListener paramSendDegreeRequestListener)
  {
    this.degreeRequestListener = paramSendDegreeRequestListener;
  }
  
  public SendPositionRequestListener getPositionRequestListener()
  {
    return this.positionRequestListener;
  }
  
  public void setPositionRequestListener(SendPositionRequestListener paramSendPositionRequestListener)
  {
    this.positionRequestListener = paramSendPositionRequestListener;
  }
  
  public SendRoleInfoRequestListener getRoleInfoRequestListener()
  {
    return this.roleInfoRequestListener;
  }
  
  public void setRoleInfoRequestListener(SendRoleInfoRequestListener paramSendRoleInfoRequestListener)
  {
    this.roleInfoRequestListener = paramSendRoleInfoRequestListener;
  }
  
  public UserRequestListener getUserRequestListener()
  {
    return this.userRequestListener;
  }
  
  public void setUserRequestListener(UserRequestListener paramUserRequestListener)
  {
    this.userRequestListener = paramUserRequestListener;
  }
  
  private void testinidate(SendUserInfoResponse paramSendUserInfoResponse, List<UserInfo> paramList)
  {
    paramSendUserInfoResponse.setSuccessCount(1);
    paramSendUserInfoResponse.setFailedCount(0);
    ArrayList localArrayList = new ArrayList();
    int i = paramList.size();
    for (int j = 0; j < i; j++)
    {
      UserInfo localUserInfo = (UserInfo)paramList.get(j);
      SendUserInfoProcessReult localSendUserInfoProcessReult = new SendUserInfoProcessReult();
      localSendUserInfoProcessReult.setAccountChangeId(localUserInfo.getAccountChangeId());
      localSendUserInfoProcessReult.setChangeType("1");
      localSendUserInfoProcessReult.setEmpCode(localUserInfo.getEmpCode());
      localSendUserInfoProcessReult.setResult(true);
      localArrayList.add(localSendUserInfoProcessReult);
    }
    paramSendUserInfoResponse.setProcessResult(localArrayList);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.services.CommonServiceListener
 * JD-Core Version:    0.7.0.1
 */