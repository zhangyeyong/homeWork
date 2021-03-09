package com.zte.eas.getData.OranizationUnits.validator;

import com.zte.eas.getData.OranizationUnits.dao.IErrorMessageDAO;
import com.zte.eas.getData.OranizationUnits.model.Message;
import com.zte.ssb.ssbext.util.ExtServiceUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicValidatorImpl
{
  final Logger log = LoggerFactory.getLogger(getClass());
  private IErrorMessageDAO errMsgDAO;
  
  private IErrorMessageDAO getErrMsgDAO()
  {
    if (this.errMsgDAO == null) {
      this.errMsgDAO = ((IErrorMessageDAO)ExtServiceUtil.findUniqueService(IErrorMessageDAO.class));
    }
    return this.errMsgDAO;
  }
  
  protected Message buildMessage(String paramString1, String paramString2)
  {
    Message localMessage = new Message();
    String str;
    if ("EAS000001".equals(paramString1))
    {
      this.log.error(paramString2 + "字段为空,验证失败返回错误信息对象");
      localMessage.setResult("False");
      localMessage.setErrCode("EAS000001");
      str = getErrMsgDAO().getErrInfos("EAS000001", paramString2);
      if (null == str)
      {
        this.log.error("错误编码{}在快速编码中没有维护系统返回空值！！", "EAS000001");
        str = "字段" + paramString2 + "不能为空";
      }
      localMessage.setErrInfos(str);
      this.log.error("错误信息对象：" + Message.class.getName() + " result ={} errCode={} errInfos={}", localMessage.getResult(), localMessage.getErrCode());
      return localMessage;
    }
    if ("EAS000002".equals(paramString1))
    {
      this.log.error(paramString2 + "值不唯一,验证失败返回错误信息对象");
      localMessage.setResult("False");
      localMessage.setErrCode("EAS000002");
      str = getErrMsgDAO().getErrInfos("EAS000002", paramString2);
      if (null == str)
      {
        this.log.error("错误编码{}在快速编码中没有维护系统返回空值！！", "EAS000002");
        str = "";
      }
      localMessage.setErrInfos(str);
      this.log.error("错误信息对象：" + Message.class.getName() + " result ={} errCode={} errInfos={}", localMessage.getResult(), localMessage.getErrCode());
      return localMessage;
    }
    if ("EAS000003".equals(paramString1))
    {
      this.log.error(paramString2 + "值错误,验证失败返回错误信息对象");
      localMessage.setResult("False");
      localMessage.setErrCode("EAS000003");
      str = getErrMsgDAO().getErrInfos("EAS000003", paramString2);
      if (null == str)
      {
        this.log.error("错误编码{}在快速编码中没有维护系统返回空值！！", "EAS000003");
        str = "";
      }
      localMessage.setErrInfos(str);
      this.log.error("错误信息对象：" + Message.class.getName() + " result ={} errCode={} errInfos={}", localMessage.getResult(), localMessage.getErrCode());
      return localMessage;
    }
    if ("EAS000004".equals(paramString1))
    {
      this.log.error(paramString2 + "数据类型不匹配,验证失败返回错误信息对象");
      localMessage.setResult("False");
      localMessage.setErrCode("EAS000004");
      str = getErrMsgDAO().getErrInfos("EAS000004", paramString2);
      if (null == str)
      {
        this.log.error("错误编码{}在快速编码中没有维护系统返回空值！！", "EAS000004");
        str = "";
      }
      localMessage.setErrInfos(str);
      this.log.error("错误信息对象：" + Message.class.getName() + " result ={} errCode={} errInfos={}", localMessage.getResult(), localMessage.getErrCode());
      return localMessage;
    }
    if ("EAS000005".equals(paramString1))
    {
      this.log.error(paramString2 + "长度不对,验证失败返回错误信息对象");
      localMessage.setResult("False");
      localMessage.setErrCode("EAS000005");
      str = getErrMsgDAO().getErrInfos("EAS000005", paramString2);
      if (null == str)
      {
        this.log.error("错误编码{}在快速编码中没有维护系统返回空值！！", "EAS000005");
        str = "";
      }
      localMessage.setErrInfos(str);
      this.log.error("错误信息对象：" + Message.class.getName() + " result ={} errCode={} errInfos={}", localMessage.getResult(), localMessage.getErrCode());
      return localMessage;
    }
    if ("EAS000006".equals(paramString1))
    {
      this.log.error(paramString2 + "日期格式不对,验证失败返回错误信息对象");
      localMessage.setResult("False");
      localMessage.setErrCode("EAS000006");
      str = getErrMsgDAO().getErrInfos("EAS000006", paramString2);
      if (null == str)
      {
        this.log.error("错误编码{}在快速编码中没有维护系统返回空值！！", "EAS000006");
        str = "";
      }
      localMessage.setErrInfos(str);
      this.log.error("错误信息对象：" + Message.class.getName() + " result ={} errCode={} errInfos={}", localMessage.getResult(), localMessage.getErrCode());
      return localMessage;
    }
    if ("EAS000007".equals(paramString1))
    {
      this.log.error(paramString2 + "记录已存在，数据操作类型错误,验证失败返回错误信息对象");
      localMessage.setResult("False");
      localMessage.setErrCode("EAS000007");
      str = getErrMsgDAO().getErrInfos("EAS000007", paramString2);
      if (null == str)
      {
        this.log.error("错误编码{}在快速编码中没有维护系统返回空值！！", "EAS000007");
        str = "";
      }
      localMessage.setErrInfos(str);
      this.log.error("错误信息对象：" + Message.class.getName() + " result ={} errCode={} errInfos={}", localMessage.getResult(), localMessage.getErrCode());
      return localMessage;
    }
    if ("EAS000008".equals(paramString1))
    {
      this.log.error(paramString2 + "记录不存在，数据操作类型错误,验证失败返回错误信息对象");
      localMessage.setResult("False");
      localMessage.setErrCode("EAS000008");
      str = getErrMsgDAO().getErrInfos("EAS000008", paramString2);
      if (null == str)
      {
        this.log.error("错误编码{}在快速编码中没有维护系统返回空值！！", "EAS000008");
        str = "";
      }
      localMessage.setErrInfos(str);
      this.log.error("错误信息对象：" + Message.class.getName() + " result ={} errCode={} errInfos={}", localMessage.getResult(), localMessage.getErrCode());
      return localMessage;
    }
    if ("EAS000009".equals(paramString1))
    {
      this.log.error(paramString2 + "记录不存在,验证失败返回错误信息对象");
      localMessage.setResult("False");
      localMessage.setErrCode("EAS000009");
      str = getErrMsgDAO().getErrInfos("EAS000009", paramString2);
      if (null == str)
      {
        this.log.error("错误编码{}在快速编码中没有维护系统返回空值！！", "EAS000009");
        str = "";
      }
      localMessage.setErrInfos(str);
      this.log.error("错误信息对象：" + Message.class.getName() + " result ={} errCode={} errInfos={}", localMessage.getResult(), localMessage.getErrCode());
      return localMessage;
    }
    if ("EAS000010".equals(paramString1))
    {
      this.log.error(paramString2 + "记录不存在,验证失败返回错误信息对象");
      localMessage.setResult("False");
      localMessage.setErrCode("EAS000010");
      str = getErrMsgDAO().getErrInfos("EAS000010", paramString2);
      if (null == str)
      {
        this.log.error("错误编码{}在快速编码中没有维护系统返回空值！！", "EAS000010");
        str = "";
      }
      localMessage.setErrInfos(str);
      this.log.error("错误信息对象：" + Message.class.getName() + " result ={} errCode={} errInfos={}", localMessage.getResult(), localMessage.getErrCode());
      return localMessage;
    }
    if ("EAS000011".equals(paramString1))
    {
      this.log.error(paramString2 + "记录不存在,验证失败返回错误信息对象");
      localMessage.setResult("False");
      localMessage.setErrCode("EAS000011");
      str = getErrMsgDAO().getErrInfos("EAS000011", paramString2);
      if (null == str)
      {
        this.log.error("错误编码{}在快速编码中没有维护系统返回空值！！", "EAS000011");
        str = "";
      }
      localMessage.setErrInfos(str);
      this.log.error("错误信息对象：" + Message.class.getName() + " result ={} errCode={} errInfos={}", localMessage.getResult(), localMessage.getErrCode());
      return localMessage;
    }
    if ("EAS000012".equals(paramString1))
    {
      this.log.error(paramString2 + "记录不存在,验证失败返回错误信息对象");
      localMessage.setResult("False");
      localMessage.setErrCode("EAS000012");
      str = getErrMsgDAO().getErrInfos("EAS000012", paramString2);
      if (null == str)
      {
        this.log.error("错误编码{}在快速编码中没有维护系统返回空值！！", "EAS000012");
        str = "";
      }
      localMessage.setErrInfos(str);
      this.log.error("错误信息对象：" + Message.class.getName() + " result ={} errCode={} errInfos={}", localMessage.getResult(), localMessage.getErrCode());
      return localMessage;
    }
    if ("EAS000014".equals(paramString1))
    {
      this.log.error(paramString2 + "值不容许修改！");
      localMessage.setResult("False");
      localMessage.setErrCode("EAS000014");
      str = getErrMsgDAO().getErrInfos("EAS000014", paramString2);
      if (null == str)
      {
        this.log.error("错误编码{}在快速编码中没有维护系统返回空值！！", "EAS000014");
        str = "";
      }
      localMessage.setErrInfos(str);
      this.log.error("错误信息对象：" + Message.class.getName() + " result ={} errCode={} errInfos={}", localMessage.getResult(), localMessage.getErrCode());
      return localMessage;
    }
    return localMessage;
  }
  
  private String extractAttributeAccessMethod(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("get");
    localStringBuilder.append(paramString);
    localStringBuilder.setCharAt(3, Character.toUpperCase(localStringBuilder.charAt(3)));
    return localStringBuilder.toString();
  }
  
  protected Message valueIsNull(Object paramObject, List<String> paramList)
  {
    if (null == paramObject) {
      return buildMessage("EAS000011", "Object");
    }
    Object localObject2;
    try
    {
      Object localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        Method localMethod = paramObject.getClass().getMethod(extractAttributeAccessMethod((String)localObject2), new Class[0]);
        if (localMethod != null)
        {
          Object localObject3 = localMethod.invoke(paramObject, new Object[0]);
          if (null == localObject3) {
            return buildMessage("EAS000001", (String)localObject2);
          }
          if (((localObject3 instanceof String)) && (StringUtils.isBlank((String)localObject3))) {
            return buildMessage("EAS000001", (String)localObject2);
          }
        }
      }
      localObject1 = new Message();
      ((Message)localObject1).setResult("True");
      return localObject1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      this.log.error("数据验证出现异常: IllegalAccessException {}", localIllegalAccessException);
      localObject2 = new Message();
      ((Message)localObject2).setResult("False");
      ((Message)localObject2).setErrCode("EAS000013");
      ((Message)localObject2).setErrInfos("系统出现异常:{}" + localIllegalAccessException);
      return localObject2;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      this.log.error("数据验证出现异常 InvocationTargetException :{}", localInvocationTargetException);
      localObject2 = new Message();
      ((Message)localObject2).setResult("False");
      ((Message)localObject2).setErrCode("EAS000013");
      ((Message)localObject2).setErrInfos("系统出现异常:{}" + localInvocationTargetException);
      return localObject2;
    }
    catch (Exception localException)
    {
      this.log.error("数据验证出现异常 Exception :{}", localException);
      localObject2 = new Message();
      ((Message)localObject2).setResult("False");
      ((Message)localObject2).setErrCode("EAS000013");
      ((Message)localObject2).setErrInfos("系统出现异常:{}" + localException);
    }
    return localObject2;
  }
  
  protected Message maxLength(Object paramObject, Map<String, Integer> paramMap)
  {
    if (null == paramObject) {
      return buildMessage("EAS000011", "Object");
    }
    Object localObject2;
    try
    {
      Object localObject1 = paramMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        Method localMethod = paramObject.getClass().getMethod(extractAttributeAccessMethod((String)localObject2), new Class[0]);
        if (localMethod != null)
        {
          Object localObject3 = localMethod.invoke(paramObject, new Object[0]);
          if ((localObject3 instanceof String))
          {
            String str = (String)localObject3;
            if (str.length() > ((Integer)paramMap.get(localObject2)).intValue()) {
              return buildMessage("EAS000005", (String)localObject2);
            }
          }
        }
      }
      localObject1 = new Message();
      ((Message)localObject1).setResult("True");
      return localObject1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      this.log.error("数据验证出现异常: IllegalAccessException {}", localIllegalAccessException);
      localObject2 = new Message();
      ((Message)localObject2).setResult("False");
      ((Message)localObject2).setErrCode("EAS000013");
      ((Message)localObject2).setErrInfos("系统出现异常:{}" + localIllegalAccessException);
      return localObject2;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      this.log.error("数据验证出现异常 InvocationTargetException :{}", localInvocationTargetException);
      localObject2 = new Message();
      ((Message)localObject2).setResult("False");
      ((Message)localObject2).setErrCode("EAS000013");
      ((Message)localObject2).setErrInfos("系统出现异常:{}" + localInvocationTargetException);
      return localObject2;
    }
    catch (Exception localException)
    {
      this.log.error("数据验证出现异常 Exception :{}", localException);
      localObject2 = new Message();
      ((Message)localObject2).setResult("False");
      ((Message)localObject2).setErrCode("EAS000013");
      ((Message)localObject2).setErrInfos("系统出现异常:{}" + localException);
    }
    return localObject2;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.validator.BasicValidatorImpl
 * JD-Core Version:    0.7.0.1
 */