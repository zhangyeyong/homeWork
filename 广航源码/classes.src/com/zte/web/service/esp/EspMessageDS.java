package com.zte.web.service.esp;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.ssb.AccessPropertiesFile;
import com.zte.ssb.exportExcel.tableModel.TableDataInfo;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import java.util.ArrayList;
import java.util.List;

public class EspMessageDS
  implements IEspMessageDS
{
  protected static final String EASLOGIN_USERINFO = "easloginuserinfo";
  
  public TableDataInfo findEspMessageList(String paramString, int paramInt1, int paramInt2)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    String[] arrayOfString1 = { "funName", "userNo", "start", "limit", "taskType", "productno" };
    String[] arrayOfString2 = { "outMessageDisplayOperation", localEasUserInfo.getUserId(), paramInt1 + 1 + "", paramInt2 + "", paramString, "EVS" };
    InputType localInputType = new InputType();
    RowSingle localRowSingle = new RowSingle();
    RowSingleRowColumn[] arrayOfRowSingleRowColumn = new RowSingleRowColumn[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      localObject = new RowSingleRowColumn();
      ((RowSingleRowColumn)localObject).setName(arrayOfString1[i]);
      ((RowSingleRowColumn)localObject).set_value(arrayOfString2[i]);
      arrayOfRowSingleRowColumn[i] = localObject;
    }
    localRowSingle.setRow(arrayOfRowSingleRowColumn);
    localInputType.setExtendElement(localRowSingle);
    QueryPortalCommonService_ServiceLocator localQueryPortalCommonService_ServiceLocator = new QueryPortalCommonService_ServiceLocator();
    Object localObject = new TableDataInfo();
    try
    {
      QueryPortalCommonService_PortType localQueryPortalCommonService_PortType = localQueryPortalCommonService_ServiceLocator.getQueryPortalCommonServiceSOAP();
      OutputType localOutputType = localQueryPortalCommonService_PortType.portalQueryOperation(localInputType);
      RowSetRowColumn[][] arrayOfRowSetRowColumn = localOutputType.getReturnRowInfo();
      ArrayList localArrayList = new ArrayList();
      for (int j = 0; j < arrayOfRowSetRowColumn.length; j++)
      {
        RowSetRowColumn[] arrayOfRowSetRowColumn1 = arrayOfRowSetRowColumn[j];
        EspMessage localEspMessage = new EspMessage();
        localEspMessage.setMessageId(arrayOfRowSetRowColumn1[0] != null ? arrayOfRowSetRowColumn1[0].toString() : "0");
        localEspMessage.setTitle(arrayOfRowSetRowColumn1[1] != null ? arrayOfRowSetRowColumn1[1].toString() : "");
        localEspMessage.setUserName(arrayOfRowSetRowColumn1[2] != null ? arrayOfRowSetRowColumn1[2].toString() : "");
        localEspMessage.setActionTime(arrayOfRowSetRowColumn1[3] != null ? arrayOfRowSetRowColumn1[3].toString() : "");
        localEspMessage.setStateCode(arrayOfRowSetRowColumn1[4] != null ? arrayOfRowSetRowColumn1[4].toString() : "");
        localArrayList.add(localEspMessage);
      }
      ((TableDataInfo)localObject).setData(localArrayList);
      ((TableDataInfo)localObject).setTotalCount(localArrayList.size());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localObject;
  }
  
  public List<EspMessage> findEspMessageList(String paramString)
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    String[] arrayOfString1 = { "funName", "userNo", "start", "limit", "taskType", "productno" };
    String[] arrayOfString2 = { "outMessageDisplayOperation", localEasUserInfo.getUserId(), "1", "100", paramString, "EVS" };
    InputType localInputType = new InputType();
    RowSingle localRowSingle = new RowSingle();
    RowSingleRowColumn[] arrayOfRowSingleRowColumn = new RowSingleRowColumn[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      localObject = new RowSingleRowColumn();
      ((RowSingleRowColumn)localObject).setName(arrayOfString1[i]);
      ((RowSingleRowColumn)localObject).set_value(arrayOfString2[i]);
      arrayOfRowSingleRowColumn[i] = localObject;
    }
    localRowSingle.setRow(arrayOfRowSingleRowColumn);
    localInputType.setSysName("ESP");
    localInputType.setFuncName("outMessageDisplayOperation");
    localInputType.setLimit("100");
    localInputType.setUserCode(localEasUserInfo.getUserId());
    localInputType.setExtendElement(localRowSingle);
    QueryPortalCommonService_ServiceLocator localQueryPortalCommonService_ServiceLocator = new QueryPortalCommonService_ServiceLocator();
    Object localObject = new ArrayList();
    try
    {
      QueryPortalCommonService_PortType localQueryPortalCommonService_PortType = localQueryPortalCommonService_ServiceLocator.getQueryPortalCommonServiceSOAP();
      OutputType localOutputType = localQueryPortalCommonService_PortType.portalQueryOperation(localInputType);
      RowSetRowColumn[][] arrayOfRowSetRowColumn = localOutputType.getReturnRowInfo();
      for (int j = 0; j < arrayOfRowSetRowColumn.length; j++)
      {
        RowSetRowColumn[] arrayOfRowSetRowColumn1 = arrayOfRowSetRowColumn[j];
        EspMessage localEspMessage = new EspMessage();
        localEspMessage.setMessageId(arrayOfRowSetRowColumn1[0] != null ? arrayOfRowSetRowColumn1[0].toString() : "0");
        localEspMessage.setTitle(arrayOfRowSetRowColumn1[1] != null ? arrayOfRowSetRowColumn1[1].toString() : "");
        localEspMessage.setUserName(arrayOfRowSetRowColumn1[2] != null ? arrayOfRowSetRowColumn1[2].toString() : "");
        localEspMessage.setActionTime(arrayOfRowSetRowColumn1[3] != null ? arrayOfRowSetRowColumn1[3].toString() : "");
        localEspMessage.setStateCode(arrayOfRowSetRowColumn1[4] != null ? arrayOfRowSetRowColumn1[4].toString() : "");
        ((List)localObject).add(localEspMessage);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localObject;
  }
  
  public String findEspUrl()
  {
    new AccessPropertiesFile();
    String str = AccessPropertiesFile.getValue("EspUrl");
    return str;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.esp.EspMessageDS
 * JD-Core Version:    0.7.0.1
 */