package com.zte.eas.wsf.ssc;

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
import org.apache.axis.description.FaultDesc;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.encoding.DeserializerFactory;
import org.apache.axis.encoding.ser.ArrayDeserializerFactory;
import org.apache.axis.encoding.ser.ArraySerializerFactory;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.encoding.ser.EnumDeserializerFactory;
import org.apache.axis.encoding.ser.EnumSerializerFactory;
import org.apache.axis.encoding.ser.SimpleDeserializerFactory;
import org.apache.axis.encoding.ser.SimpleListDeserializerFactory;
import org.apache.axis.encoding.ser.SimpleListSerializerFactory;
import org.apache.axis.encoding.ser.SimpleSerializerFactory;
import org.apache.axis.soap.SOAPConstants;

public class WSFSSCWebSericeFacadeSoapBindingStub
  extends Stub
  implements WSFSSCWebSericeFacadeSrvProxy
{
  private Vector cachedSerClasses = new Vector();
  private Vector cachedSerQNames = new Vector();
  private Vector cachedSerFactories = new Vector();
  private Vector cachedDeserFactories = new Vector();
  static OperationDesc[] _operations = new OperationDesc[1];
  
  private static void _initOperationDesc1()
  {
    OperationDesc localOperationDesc = new OperationDesc();
    localOperationDesc.setName("getFinCompany");
    ParameterDesc localParameterDesc = new ParameterDesc(new QName("", "beginDate"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "endDate"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localOperationDesc.setReturnType(new QName("http://localhost:6888/ormrpc/services/WSFSSCWebSericeFacade", "ArrayOfArrayOf_xsd_string"));
    localOperationDesc.setReturnClass([[Ljava.lang.String.class);
    localOperationDesc.setReturnQName(new QName("", "getFinCompanyReturn"));
    localOperationDesc.setStyle(Style.RPC);
    localOperationDesc.setUse(Use.ENCODED);
    localOperationDesc.addFault(new FaultDesc(new QName("http://localhost:6888/ormrpc/services/WSFSSCWebSericeFacade", "fault"), "com.zte.eas.wsf.ssc.WSInvokeException", new QName("urn:client.fsscWebSericeFacade", "WSInvokeException"), true));
    _operations[0] = localOperationDesc;
  }
  
  public WSFSSCWebSericeFacadeSoapBindingStub()
    throws AxisFault
  {
    this(null);
  }
  
  public WSFSSCWebSericeFacadeSoapBindingStub(URL paramURL, javax.xml.rpc.Service paramService)
    throws AxisFault
  {
    this(paramService);
    this.cachedEndpoint = paramURL;
  }
  
  public WSFSSCWebSericeFacadeSoapBindingStub(javax.xml.rpc.Service paramService)
    throws AxisFault
  {
    if (paramService == null) {
      this.service = new org.apache.axis.client.Service();
    } else {
      this.service = paramService;
    }
    ((org.apache.axis.client.Service)this.service).setTypeMappingVersion("1.2");
    BeanSerializerFactory localBeanSerializerFactory = BeanSerializerFactory.class;
    BeanDeserializerFactory localBeanDeserializerFactory = BeanDeserializerFactory.class;
    EnumSerializerFactory localEnumSerializerFactory = EnumSerializerFactory.class;
    EnumDeserializerFactory localEnumDeserializerFactory = EnumDeserializerFactory.class;
    ArraySerializerFactory localArraySerializerFactory = ArraySerializerFactory.class;
    ArrayDeserializerFactory localArrayDeserializerFactory = ArrayDeserializerFactory.class;
    SimpleSerializerFactory localSimpleSerializerFactory = SimpleSerializerFactory.class;
    SimpleDeserializerFactory localSimpleDeserializerFactory = SimpleDeserializerFactory.class;
    SimpleListSerializerFactory localSimpleListSerializerFactory = SimpleListSerializerFactory.class;
    SimpleListDeserializerFactory localSimpleListDeserializerFactory = SimpleListDeserializerFactory.class;
    QName localQName1 = new QName("http://localhost:6888/ormrpc/services/WSFSSCWebSericeFacade", "ArrayOfArrayOf_xsd_string");
    this.cachedSerQNames.add(localQName1);
    Object localObject = [[Ljava.lang.String.class;
    this.cachedSerClasses.add(localObject);
    localQName1 = new QName("http://www.w3.org/2001/XMLSchema", "string");
    QName localQName2 = null;
    this.cachedSerFactories.add(new ArraySerializerFactory(localQName1, localQName2));
    this.cachedDeserFactories.add(new ArrayDeserializerFactory());
    localQName1 = new QName("urn:client.fsscWebSericeFacade", "WSInvokeException");
    this.cachedSerQNames.add(localQName1);
    localObject = WSInvokeException.class;
    this.cachedSerClasses.add(localObject);
    this.cachedSerFactories.add(localBeanSerializerFactory);
    this.cachedDeserFactories.add(localBeanDeserializerFactory);
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
      synchronized (this)
      {
        if (firstCall())
        {
          localCall.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
          localCall.setEncodingStyle("http://schemas.xmlsoap.org/soap/encoding/");
          for (int i = 0; i < this.cachedSerFactories.size(); i++)
          {
            Class localClass = (Class)this.cachedSerClasses.get(i);
            QName localQName = (QName)this.cachedSerQNames.get(i);
            Object localObject1 = this.cachedSerFactories.get(i);
            Object localObject2;
            Object localObject3;
            if ((localObject1 instanceof Class))
            {
              localObject2 = (Class)this.cachedSerFactories.get(i);
              localObject3 = (Class)this.cachedDeserFactories.get(i);
              localCall.registerTypeMapping(localClass, localQName, (Class)localObject2, (Class)localObject3, false);
            }
            else if ((localObject1 instanceof javax.xml.rpc.encoding.SerializerFactory))
            {
              localObject2 = (org.apache.axis.encoding.SerializerFactory)this.cachedSerFactories.get(i);
              localObject3 = (DeserializerFactory)this.cachedDeserFactories.get(i);
              localCall.registerTypeMapping(localClass, localQName, (org.apache.axis.encoding.SerializerFactory)localObject2, (DeserializerFactory)localObject3, false);
            }
          }
        }
      }
      return localCall;
    }
    catch (Throwable localThrowable)
    {
      throw new AxisFault("Failure trying to get the Call object", localThrowable);
    }
  }
  
  /* Error */
  public String[][] getFinCompany(String paramString1, String paramString2)
    throws RemoteException, WSInvokeException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	org/apache/axis/client/Stub:cachedEndpoint	Ljava/net/URL;
    //   4: ifnonnull +11 -> 15
    //   7: new 99	org/apache/axis/NoEndPointException
    //   10: dup
    //   11: invokespecial 100	org/apache/axis/NoEndPointException:<init>	()V
    //   14: athrow
    //   15: aload_0
    //   16: invokevirtual 101	com/zte/eas/wsf/ssc/WSFSSCWebSericeFacadeSoapBindingStub:createCall	()Lorg/apache/axis/client/Call;
    //   19: astore_3
    //   20: aload_3
    //   21: getstatic 34	com/zte/eas/wsf/ssc/WSFSSCWebSericeFacadeSoapBindingStub:_operations	[Lorg/apache/axis/description/OperationDesc;
    //   24: iconst_0
    //   25: aaload
    //   26: invokevirtual 102	org/apache/axis/client/Call:setOperation	(Lorg/apache/axis/description/OperationDesc;)V
    //   29: aload_3
    //   30: iconst_1
    //   31: invokevirtual 103	org/apache/axis/client/Call:setUseSOAPAction	(Z)V
    //   34: aload_3
    //   35: ldc 7
    //   37: invokevirtual 104	org/apache/axis/client/Call:setSOAPActionURI	(Ljava/lang/String;)V
    //   40: aload_3
    //   41: getstatic 83	org/apache/axis/soap/SOAPConstants:SOAP11_CONSTANTS	Lorg/apache/axis/soap/SOAP11Constants;
    //   44: invokevirtual 84	org/apache/axis/client/Call:setSOAPVersion	(Lorg/apache/axis/soap/SOAPConstants;)V
    //   47: aload_3
    //   48: new 6	javax/xml/namespace/QName
    //   51: dup
    //   52: ldc 105
    //   54: ldc 3
    //   56: invokespecial 9	javax/xml/namespace/QName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: invokevirtual 106	org/apache/axis/client/Call:setOperationName	(Ljavax/xml/namespace/QName;)V
    //   62: aload_0
    //   63: aload_3
    //   64: invokevirtual 107	com/zte/eas/wsf/ssc/WSFSSCWebSericeFacadeSoapBindingStub:setRequestHeaders	(Lorg/apache/axis/client/Call;)V
    //   67: aload_0
    //   68: aload_3
    //   69: invokevirtual 108	com/zte/eas/wsf/ssc/WSFSSCWebSericeFacadeSoapBindingStub:setAttachments	(Lorg/apache/axis/client/Call;)V
    //   72: aload_3
    //   73: iconst_2
    //   74: anewarray 109	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_1
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: aload_2
    //   84: aastore
    //   85: invokevirtual 110	org/apache/axis/client/Call:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   88: astore 4
    //   90: aload 4
    //   92: instanceof 111
    //   95: ifeq +9 -> 104
    //   98: aload 4
    //   100: checkcast 111	java/rmi/RemoteException
    //   103: athrow
    //   104: aload_0
    //   105: aload_3
    //   106: invokevirtual 112	com/zte/eas/wsf/ssc/WSFSSCWebSericeFacadeSoapBindingStub:extractAttachments	(Lorg/apache/axis/client/Call;)V
    //   109: aload 4
    //   111: checkcast 19	[[Ljava/lang/String;
    //   114: checkcast 19	[[Ljava/lang/String;
    //   117: areturn
    //   118: astore 5
    //   120: aload 4
    //   122: ldc_w 19
    //   125: invokestatic 114	org/apache/axis/utils/JavaUtils:convert	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   128: checkcast 19	[[Ljava/lang/String;
    //   131: checkcast 19	[[Ljava/lang/String;
    //   134: areturn
    //   135: astore 4
    //   137: aload 4
    //   139: getfield 115	org/apache/axis/AxisFault:detail	Ljava/lang/Throwable;
    //   142: ifnull +43 -> 185
    //   145: aload 4
    //   147: getfield 115	org/apache/axis/AxisFault:detail	Ljava/lang/Throwable;
    //   150: instanceof 111
    //   153: ifeq +12 -> 165
    //   156: aload 4
    //   158: getfield 115	org/apache/axis/AxisFault:detail	Ljava/lang/Throwable;
    //   161: checkcast 111	java/rmi/RemoteException
    //   164: athrow
    //   165: aload 4
    //   167: getfield 115	org/apache/axis/AxisFault:detail	Ljava/lang/Throwable;
    //   170: instanceof 62
    //   173: ifeq +12 -> 185
    //   176: aload 4
    //   178: getfield 115	org/apache/axis/AxisFault:detail	Ljava/lang/Throwable;
    //   181: checkcast 62	com/zte/eas/wsf/ssc/WSInvokeException
    //   184: athrow
    //   185: aload 4
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	WSFSSCWebSericeFacadeSoapBindingStub
    //   0	188	1	paramString1	String
    //   0	188	2	paramString2	String
    //   19	87	3	localCall	Call
    //   88	33	4	localObject	Object
    //   135	51	4	localAxisFault	AxisFault
    //   118	1	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   109	117	118	java/lang/Exception
    //   72	117	135	org/apache/axis/AxisFault
    //   118	134	135	org/apache/axis/AxisFault
  }
  
  static
  {
    _initOperationDesc1();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.wsf.ssc.WSFSSCWebSericeFacadeSoapBindingStub
 * JD-Core Version:    0.7.0.1
 */