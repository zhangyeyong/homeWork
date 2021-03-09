package com.zte.eas.getData.util;

import com.zte.eas.appframe.access.syscommon.EasUserInfo;
import com.zte.eas.appframe.business.syscommon.InfoMapEncrypt;
import com.zte.eas.getData.OranizationUnits.dao.IEmployeesDAO;
import com.zte.eas.getData.OranizationUnits.model.Message;
import com.zte.eas.organization.access.organizationmanage.dao.IFbpDeptsDAO;
import com.zte.eas.organization.business.employeemanage.model.FbpEmployees;
import com.zte.eas.organization.business.organizationmanage.model.FbpDepts;
import com.zte.ssb.AccessPropertiesFile;
import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.servicecontainer.business.server.ISession;
import com.zte.ssb.servicecontainer.business.server.RIAContext;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;

public class EisConsts
{
  final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
  public static final String INTERFACE_SERVICE = "eas_interface.service.properties";
  public static final String ERR_EAS000001 = "EAS000001";
  public static final String ERR_EAS000002 = "EAS000002";
  public static final String ERR_EAS000003 = "EAS000003";
  public static final String ERR_EAS000004 = "EAS000004";
  public static final String ERR_EAS000005 = "EAS000005";
  public static final String ERR_EAS000006 = "EAS000006";
  public static final String ERR_EAS000007 = "EAS000007";
  public static final String ERR_EAS000008 = "EAS000008";
  public static final String ERR_EAS000009 = "EAS000009";
  public static final String ERR_EAS000010 = "EAS000010";
  public static final String ERR_EAS000011 = "EAS000011";
  public static final String ERR_EAS000012 = "EAS000012";
  public static final String ERR_EAS000013 = "EAS000013";
  public static final String ERR_EAS000014 = "EAS000014";
  public static final String EXECUTE_SUCC = "True";
  public static final String EXECUTE_FAIL = "False";
  public static final String EAS_DATE_TYPE_A = "A";
  public static final String EAS_DATE_TYPE_C = "C";
  public static final String ENABLED_FLAG_Y = "Y";
  public static final String ENABLED_FLAG_N = "N";
  public static final String APPROVED_STATUS_NULL = "NULL";
  public static final String FLEX_VALUE_SET_NAME = "FLEX_VALUE_SET_NAME";
  public static final String _310_MIS_IMPORT_ERROR = "310_MIS_IMPORT_ERROR";
  public static final String IMP_INTO_MIS_FLAG_E = "IMP_INTO_MIS_FLAG_E";
  public static final String IMP_INTO_MIS_FLAG_Y = "IMP_INTO_MIS_FLAG_Y";
  public static final String IMP_INTO_MIS_FLAG_N = "IMP_INTO_MIS_FLAG_N";
  public static final String IMP_INTO_MIS_FLAG_W = "IMP_INTO_MIS_FLAG_W";
  public static final String _300_HAS_APPROVED = "300_HAS_APPROVED";
  public static final String _320_IN_MIS_IMPORT = "320_IN_MIS_IMPORT";
  public static final String _340_DIFF_WAIT_FOR_DEAL = "340_DIFF_WAIT_FOR_DEAL";
  public static final String _400_NORMAL_CLOSED = "400_NORMAL_CLOSED";
  public static final String _601_IMPORT_FINISH = "601_IMPORT_FINISH";
  public static final Integer OTHER_LENGTH = Integer.valueOf(3);
  public static final String LANGUAGE_ZH = "zh";
  public static final String LANGUAGE_EN = "en";
  public static final String EIS_SYSTEM_CODE = "EIS";
  public static final String EVS_SYSTEM_CODE = "EVS";
  public static final String BCC_SYSTEM_CODE = "BCC";
  public static final String LMS_SYSTEM_CODE = "LMS";
  public static final String FSSC_SYSTEM_CODE = "FSSC";
  public static final String GEMS_SYSTEM_CODE = "GEMS";
  public static final String EIS_DELETE = "DELETE";
  public static final String SHOW_IMAGE_URL = AccessPropertiesFile.getValue("showImageUrl") + "?system=#SYSTEM#$userID=#userID#$scanNumber=#scanNumber#";
  public static final String VENDOR_TYPE_V = "VENDOR";
  public static final String VENDOR_TYPE_C = "CUSTOMER";
  public static final String AREA_F_CODE = "F";
  public static final String AREA_V_CODE = "V";
  public static final String AREA_E_CODE = "E";
  public static final String AREA_L_CODE = "L";
  public static final String AREA_F_NAME = "生产";
  public static final String AREA_V_NAME = "销售";
  public static final String AREA_E_NAME = "开发";
  public static final String AREA_L_NAME = "管理";
  public static final String EMP_START_1 = "1";
  public static final String EMP_START_2 = "2";
  public static final String EMP_START_3 = "3";
  public static final String EMP_START_4 = "4";
  public static final String EMP_START_9 = "9";
  public static final String EMP_START_DESC1 = "在职";
  public static final String EMP_START_DESC2 = "不在职";
  public static final String FLEX_VALUE_SET_NAME_COMPANY = "CCT_COMPANY_CODE";
  public static final String BUDGET_EXPEND = "insert 占用";
  public static final String BUDGET_RELEASE = "delete 释放";
  public static final String BUDGET_UPDATE = "update\t修改";
  public static final String SYSTEM_MANAGER = "10000";
  public static final String POSITION_HIERACHY_IMAGE_QUERY = "IMAGE_QUERY";
  public static final String POSITION_HIERACHY_VOUCHER_QUERY = "VOUCHER_QUERY";
  public static final String POSITION_HIERACHY_IMAGE_CHECK = "IMAGE_CHECK";
  public static final String EIS_ZERO = "0";
  public static final String EIS_ONE = "1";
  public static final String CONVERSION_TYPE = "Corporate";
  public static final String FEE_ITEM_CODE = "6666020202";
  public static final String BCC_LANGUAGE_ZH = "zhs";
  public static final String BCC_LANGUAGE_EN = "us";
  public static final String EVS_LANGUAGE_ZH = "zh";
  public static final String EVS_LANGUAGE_EN = "en";
  public static final String BUSINESS_ID = "EIS";
  public static final String EVS_0000 = "0000";
  public static final String EVS_1001 = "1001";
  public static final String EVS_1002 = "1002";
  public static final String EVS_1003 = "1003";
  public static final String EVS_1004 = "1004";
  public static final String EVS_1005 = "1005";
  public static final String EVS_1006 = "1006";
  public static final String EVS_1901 = "1901";
  public static final String EMPLOYEES_GW = "GW";
  public static final String EMPLOYEES_TS = "TS";
  public static final String DEPT_PROPERTY_MA = "MA";
  public static final String DEPT_PROPERTY_HQ = "HQ";
  public static final String[] LANGUAGE_LIST = { "ZHS", "US" };
  public static final String SYNC_SA_FLAG_W = "W";
  public static final String ACCESSORIES_IRREGULARITIES_KEY = "4";
  public static final String IMAGE_FUZZY_KEY = "3";
  public static final String NORMAL_THROUGH_KEY = "2";
  public static final String LACK_OF_INVOICE_KEY = "1";
  public static final String WORKFLOW_REJECT_KEY = "WORKFLOW_REJECT";
  public static final String ACCESSORIES_IRREGULARITIES_VALUE = "ACCESSORIES_IRREGULARITIES";
  public static final String IMAGE_FUZZY_VALUE = "IMAGE_FUZZY";
  public static final String NORMAL_THROUGH_VALUE = "NORMAL_THROUGH";
  public static final String LACK_OF_INVOICE_VALUE = "LACK_OF_INVOICE";
  public static final String WORKFLOW_REJECT_VALUE = "WORKFLOW_REJECT";
  public static final String BCC_EMAIL_SUFFIX = "@haier.com";
  public static boolean IS_NULL = true;
  public static final String ZH = "zh";
  public static final String EN = "en";
  private static IEmployeesDAO _FbpEmployeesVDS;
  
  public static Integer getLength(Object[] paramArrayOfObject)
  {
    return Integer.valueOf(paramArrayOfObject == null ? 1 : paramArrayOfObject.length);
  }
  
  public static boolean isNull(Object[] paramArrayOfObject)
  {
    for (Object localObject : paramArrayOfObject) {
      if (localObject != null)
      {
        IS_NULL = false;
        break;
      }
    }
    return IS_NULL;
  }
  
  public static String isEvsBoe(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("YFD", "LMS");
    localHashMap.put("FKS", "LMS");
    localHashMap.put("FSSC", "FSSC");
    String str1 = paramString.length() < 3 ? null : paramString.substring(0, 3);
    String str2 = paramString.length() < 4 ? null : paramString.substring(0, 4);
    if ((str1 != null) && (localHashMap.containsKey(str1.toUpperCase()))) {
      return (String)localHashMap.get(str1);
    }
    if ((str2 != null) && (localHashMap.containsKey(str2.toUpperCase()))) {
      return (String)localHashMap.get(str2);
    }
    return null;
  }
  
  public static Message[] setMessage(Message paramMessage, Message[] paramArrayOfMessage)
  {
    if (paramMessage == null) {
      return paramArrayOfMessage;
    }
    if (paramArrayOfMessage == null)
    {
      paramArrayOfMessage = new Message[1];
      paramArrayOfMessage[0] = paramMessage;
      return paramArrayOfMessage;
    }
    for (int i = 0; i < paramArrayOfMessage.length; i++) {
      if (paramArrayOfMessage[i] == null)
      {
        paramArrayOfMessage[i] = paramMessage;
        return paramArrayOfMessage;
      }
    }
    Message[] arrayOfMessage = new Message[paramArrayOfMessage.length + 1];
    for (int j = 0; j < paramArrayOfMessage.length; j++) {
      arrayOfMessage[j] = paramArrayOfMessage[j];
    }
    arrayOfMessage[(arrayOfMessage.length - 1)] = paramMessage;
    return arrayOfMessage;
  }
  
  public static String getZTELogDir()
  {
    return AccessPropertiesFile.getValue("ZTE_LOG_DIR", "eas_interface.service.properties");
  }
  
  public static void printMsg(Object paramObject, org.apache.log4j.Logger paramLogger)
  {
    try
    {
      if (paramLogger == null) {
        return;
      }
      if (paramObject == null)
      {
        paramLogger.error("object is null");
        return;
      }
      Method[] arrayOfMethod1 = paramObject.getClass().getMethods();
      paramLogger.error("print " + paramObject.getClass() + " argument begin..................");
      for (Method localMethod : arrayOfMethod1) {
        try
        {
          if ((localMethod == null) || (localMethod.getName().contains("get"))) {
            paramLogger.error(localMethod.getName() + "=" + localMethod.invoke(paramObject, new Object[0]));
          }
        }
        catch (Exception localException2) {}
      }
      paramLogger.error("print " + paramObject.getClass() + " argument end..................");
    }
    catch (Exception localException1)
    {
      paramLogger.error("print " + paramObject.getClass() + " argument end..................");
    }
  }
  
  public static String getEmployeeNumByFeeItems(String paramString1, String paramString2, String paramString3)
  {
    org.slf4j.Logger localLogger = new EisConsts().logger;
    String str1 = paramString3;
    localLogger.error("费用项目： " + paramString1);
    localLogger.error("部门编码： " + paramString2);
    localLogger.error("员工编码： " + paramString3);
    if ("6666020101".equals(paramString1))
    {
      IFbpDeptsDAO localIFbpDeptsDAO = (IFbpDeptsDAO)SSBBus.findDaoService("fbpDeptsDAO");
      FbpDepts localFbpDepts = localIFbpDeptsDAO.getFbpDeptsByCode(paramString2);
      localLogger.error(paramString2 + " 部门为：" + (localFbpDepts == null ? null : localFbpDepts.toString()));
      if (localFbpDepts != null)
      {
        String str2 = localFbpDepts.getAttribute10();
        localLogger.error(paramString2 + " 部门的部门属性为：" + str2);
        if (!StringUtils.isEmpty(str2)) {
          if ("Y".equals(str2.trim())) {
            str1 = "TS";
          } else {
            str1 = paramString3;
          }
        }
      }
    }
    else if ("6666000002".equals(paramString1))
    {
      str1 = "GW";
    }
    else
    {
      str1 = paramString3;
    }
    if ((str1 == null) || ("".equals(str1))) {
      str1 = paramString3;
    }
    return str1;
  }
  
  public static synchronized boolean login(String paramString1, String paramString2)
    throws Exception
  {
    boolean bool = false;
    FbpEmployees localFbpEmployees = getFbpEmployeesVDS().findEmployeesByEmployeeNumber(paramString1);
    if (localFbpEmployees != null)
    {
      String str1 = InfoMapEncrypt.decrypt(localFbpEmployees.getPassword());
      String str2 = Md5Encrypt.getEncrypt().encode(str1);
      if ((str2 != null) && (paramString2.toUpperCase().equals(str2.toUpperCase()))) {
        bool = true;
      }
    }
    return bool;
  }
  
  public static EasUserInfo getCurrentUser()
  {
    RIAContext localRIAContext = RIAContext.getCurrentInstance();
    if (localRIAContext == null) {
      return null;
    }
    ISession localISession = localRIAContext.getSession();
    EasUserInfo localEasUserInfo = (EasUserInfo)localISession.getSessionAttribute("easloginuserinfo");
    return localEasUserInfo;
  }
  
  public static String getCMonth(int paramInt)
  {
    String str = null;
    if (paramInt == 1) {
      str = "JAN";
    } else if (paramInt == 2) {
      str = "FEB";
    } else if (paramInt == 3) {
      str = "MAR";
    } else if (paramInt == 4) {
      str = "APR";
    } else if (paramInt == 5) {
      str = "MAY";
    } else if (paramInt == 6) {
      str = "JUN";
    } else if (paramInt == 7) {
      str = "JUL";
    } else if (paramInt == 8) {
      str = "AUG";
    } else if (paramInt == 9) {
      str = "SEP";
    } else if (paramInt == 10) {
      str = "OCT";
    } else if (paramInt == 11) {
      str = "NOV";
    } else if (paramInt == 12) {
      str = "DEC";
    }
    return str;
  }
  
  protected static synchronized IEmployeesDAO getFbpEmployeesVDS()
  {
    if (_FbpEmployeesVDS == null) {
      _FbpEmployeesVDS = (IEmployeesDAO)SSBBus.findCommonService("fbpEmployeesVDS");
    }
    return _FbpEmployeesVDS;
  }
  
  public static String getAppraiseType(String paramString)
  {
    String str = "";
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      str = null;
    } else if ("2".equals(paramString)) {
      str = "NORMAL_THROUGH";
    } else if ("1".equals(paramString)) {
      str = "LACK_OF_INVOICE";
    } else if ("3".equals(paramString)) {
      str = "IMAGE_FUZZY";
    } else if ("4".equals(paramString)) {
      str = "ACCESSORIES_IRREGULARITIES";
    } else if ("WORKFLOW_REJECT".equals(paramString)) {
      str = "WORKFLOW_REJECT";
    }
    return str;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.util.EisConsts
 * JD-Core Version:    0.7.0.1
 */