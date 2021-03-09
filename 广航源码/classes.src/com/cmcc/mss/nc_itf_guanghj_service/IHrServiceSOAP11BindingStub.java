package com.cmcc.mss.nc_itf_guanghj_service;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import javax.xml.namespace.QName;
import org.apache.axis.AxisFault;
import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;
import org.apache.axis.constants.Style;
import org.apache.axis.constants.Use;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;

public class IHrServiceSOAP11BindingStub
  extends Stub
  implements IHrServicePortType
{
  private Vector cachedSerClasses = new Vector();
  private Vector cachedSerQNames = new Vector();
  private Vector cachedSerFactories = new Vector();
  private Vector cachedDeserFactories = new Vector();
  static OperationDesc[] _operations = new OperationDesc[1];
  
  private static void _initOperationDesc1()
  {
    OperationDesc localOperationDesc = new OperationDesc();
    localOperationDesc.setName("process");
    ParameterDesc localParameterDesc = new ParameterDesc(new QName("", "string"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localParameterDesc.setOmittable(true);
    localParameterDesc.setNillable(true);
    localOperationDesc.addParameter(localParameterDesc);
    localOperationDesc.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localOperationDesc.setReturnClass(String.class);
    localOperationDesc.setReturnQName(new QName("", "return"));
    localOperationDesc.setStyle(Style.WRAPPED);
    localOperationDesc.setUse(Use.LITERAL);
    _operations[0] = localOperationDesc;
  }
  
  public IHrServiceSOAP11BindingStub()
    throws AxisFault
  {
    this(null);
  }
  
  public IHrServiceSOAP11BindingStub(URL paramURL, javax.xml.rpc.Service paramService)
    throws AxisFault
  {
    this(paramService);
    this.cachedEndpoint = paramURL;
  }
  
  public IHrServiceSOAP11BindingStub(javax.xml.rpc.Service paramService)
    throws AxisFault
  {
    if (paramService == null) {
      this.service = new org.apache.axis.client.Service();
    } else {
      this.service = paramService;
    }
    ((org.apache.axis.client.Service)this.service).setTypeMappingVersion("1.2");
  }
  
  protected Call createCall()
    throws RemoteException
  {
    try
    {
      Call localCall = super._createCall();
      if (this.maintainSessionSet) {
        localCall.setMaintainSession(this.maintainSession);
      }
      if (this.cachedUsername != null) {
        localCall.setUsername(this.cachedUsername);
      }
      if (this.cachedPassword != null) {
        localCall.setPassword(this.cachedPassword);
      }
      if (this.cachedEndpoint != null) {
        localCall.setTargetEndpointAddress(this.cachedEndpoint);
      }
      if (this.cachedTimeout != null) {
        localCall.setTimeout(this.cachedTimeout);
      }
      if (this.cachedPortName != null) {
        localCall.setPortName(this.cachedPortName);
      }
      Enumeration localEnumeration = this.cachedProperties.keys();
      while (localEnumeration.hasMoreElements())
      {
        String str = (String)localEnumeration.nextElement();
        localCall.setProperty(str, this.cachedProperties.get(str));
      }
      return localCall;
    }
    catch (Throwable localThrowable)
    {
      throw new AxisFault("Failure trying to get the Call object", localThrowable);
    }
  }
  
  /* Error */
  public String process(String paramString)
    throws RemoteException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	org/apache/axis/client/Stub:cachedEndpoint	Ljava/net/URL;
    //   4: ifnonnull +11 -> 15
    //   7: new 62	org/apache/axis/NoEndPointException
    //   10: dup
    //   11: invokespecial 63	org/apache/axis/NoEndPointException:<init>	()V
    //   14: athrow
    //   15: aload_0
    //   16: invokevirtual 64	com/cmcc/mss/nc_itf_guanghj_service/IHrServiceSOAP11BindingStub:createCall	()Lorg/apache/axis/client/Call;
    //   19: astore_2
    //   20: aload_2
    //   21: getstatic 24	com/cmcc/mss/nc_itf_guanghj_service/IHrServiceSOAP11BindingStub:_operations	[Lorg/apache/axis/description/OperationDesc;
    //   24: iconst_0
    //   25: aaload
    //   26: invokevirtual 65	org/apache/axis/client/Call:setOperation	(Lorg/apache/axis/description/OperationDesc;)V
    //   29: aload_2
    //   30: iconst_1
    //   31: invokevirtual 66	org/apache/axis/client/Call:setUseSOAPAction	(Z)V
    //   34: aload_2
    //   35: ldc 67
    //   37: invokevirtual 68	org/apache/axis/client/Call:setSOAPActionURI	(Ljava/lang/String;)V
    //   40: aload_2
    //   41: aconst_null
    //   42: invokevirtual 69	org/apache/axis/client/Call:setEncodingStyle	(Ljava/lang/String;)V
    //   45: aload_2
    //   46: ldc 70
    //   48: getstatic 71	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   51: invokevirtual 57	org/apache/axis/client/Call:setProperty	(Ljava/lang/String;Ljava/lang/Object;)V
    //   54: aload_2
    //   55: ldc 72
    //   57: getstatic 71	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   60: invokevirtual 57	org/apache/axis/client/Call:setProperty	(Ljava/lang/String;Ljava/lang/Object;)V
    //   63: aload_2
    //   64: getstatic 73	org/apache/axis/soap/SOAPConstants:SOAP11_CONSTANTS	Lorg/apache/axis/soap/SOAP11Constants;
    //   67: invokevirtual 74	org/apache/axis/client/Call:setSOAPVersion	(Lorg/apache/axis/soap/SOAPConstants;)V
    //   70: aload_2
    //   71: new 6	javax/xml/namespace/QName
    //   74: dup
    //   75: ldc 75
    //   77: ldc 3
    //   79: invokespecial 9	javax/xml/namespace/QName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: invokevirtual 76	org/apache/axis/client/Call:setOperationName	(Ljavax/xml/namespace/QName;)V
    //   85: aload_0
    //   86: aload_2
    //   87: invokevirtual 77	com/cmcc/mss/nc_itf_guanghj_service/IHrServiceSOAP11BindingStub:setRequestHeaders	(Lorg/apache/axis/client/Call;)V
    //   90: aload_0
    //   91: aload_2
    //   92: invokevirtual 78	com/cmcc/mss/nc_itf_guanghj_service/IHrServiceSOAP11BindingStub:setAttachments	(Lorg/apache/axis/client/Call;)V
    //   95: aload_2
    //   96: iconst_1
    //   97: anewarray 79	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_1
    //   103: aastore
    //   104: invokevirtual 80	org/apache/axis/client/Call:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   107: astore_3
    //   108: aload_3
    //   109: instanceof 81
    //   112: ifeq +8 -> 120
    //   115: aload_3
    //   116: checkcast 81	java/rmi/RemoteException
    //   119: athrow
    //   120: aload_0
    //   121: aload_2
    //   122: invokevirtual 82	com/cmcc/mss/nc_itf_guanghj_service/IHrServiceSOAP11BindingStub:extractAttachments	(Lorg/apache/axis/client/Call;)V
    //   125: aload_3
    //   126: checkcast 11	java/lang/String
    //   129: areturn
    //   130: astore 4
    //   132: aload_3
    //   133: ldc_w 11
    //   136: invokestatic 84	org/apache/axis/utils/JavaUtils:convert	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   139: checkcast 11	java/lang/String
    //   142: areturn
    //   143: astore_3
    //   144: aload_3
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	IHrServiceSOAP11BindingStub
    //   0	146	1	paramString	String
    //   19	103	2	localCall	Call
    //   107	26	3	localObject	java.lang.Object
    //   143	2	3	localAxisFault	AxisFault
    //   130	1	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   125	129	130	java/lang/Exception
    //   95	129	143	org/apache/axis/AxisFault
    //   130	142	143	org/apache/axis/AxisFault
  }
  
  static
  {
    _initOperationDesc1();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.nc_itf_guanghj_service.IHrServiceSOAP11BindingStub
 * JD-Core Version:    0.7.0.1
 */