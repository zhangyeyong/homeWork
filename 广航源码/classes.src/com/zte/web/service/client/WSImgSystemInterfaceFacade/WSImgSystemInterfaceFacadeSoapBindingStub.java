package com.zte.web.service.client.WSImgSystemInterfaceFacade;

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

public class WSImgSystemInterfaceFacadeSoapBindingStub
  extends Stub
  implements WSImgSystemInterfaceFacadeSrvProxy
{
  private Vector cachedSerClasses = new Vector();
  private Vector cachedSerQNames = new Vector();
  private Vector cachedSerFactories = new Vector();
  private Vector cachedDeserFactories = new Vector();
  static OperationDesc[] _operations = new OperationDesc[1];
  
  private static void _initOperationDesc1()
  {
    OperationDesc localOperationDesc = new OperationDesc();
    localOperationDesc.setName("imgCreateOrUpdate");
    ParameterDesc localParameterDesc = new ParameterDesc(new QName("", "imgInfor"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localOperationDesc.setReturnType(new QName("http://192.168.17.194:9888/ormrpc/services/WSImgSystemInterfaceFacade", "ArrayOf_xsd_string"));
    localOperationDesc.setReturnClass([Ljava.lang.String.class);
    localOperationDesc.setReturnQName(new QName("", "imgCreateOrUpdateReturn"));
    localOperationDesc.setStyle(Style.RPC);
    localOperationDesc.setUse(Use.ENCODED);
    localOperationDesc.addFault(new FaultDesc(new QName("http://192.168.17.194:9888/ormrpc/services/WSImgSystemInterfaceFacade", "fault"), "com.zte.eas.infomap.WSImgSystemInterfaceFacade.WSInvokeException", new QName("urn:client.imgsysteminterfacefacade", "WSInvokeException"), true));
    _operations[0] = localOperationDesc;
  }
  
  public WSImgSystemInterfaceFacadeSoapBindingStub()
    throws AxisFault
  {
    this(null);
  }
  
  public WSImgSystemInterfaceFacadeSoapBindingStub(URL paramURL, javax.xml.rpc.Service paramService)
    throws AxisFault
  {
    this(paramService);
    this.cachedEndpoint = paramURL;
  }
  
  public WSImgSystemInterfaceFacadeSoapBindingStub(javax.xml.rpc.Service paramService)
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
    QName localQName1 = new QName("http://192.168.17.194:9888/ormrpc/services/WSImgSystemInterfaceFacade", "ArrayOf_xsd_string");
    this.cachedSerQNames.add(localQName1);
    Object localObject = [Ljava.lang.String.class;
    this.cachedSerClasses.add(localObject);
    localQName1 = new QName("http://www.w3.org/2001/XMLSchema", "string");
    QName localQName2 = null;
    this.cachedSerFactories.add(new ArraySerializerFactory(localQName1, localQName2));
    this.cachedDeserFactories.add(new ArrayDeserializerFactory());
    localQName1 = new QName("urn:client.imgsysteminterfacefacade", "WSInvokeException");
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
  public String[] imgCreateOrUpdate(String paramString)
    throws RemoteException, WSInvokeException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	org/apache/axis/client/Stub:cachedEndpoint	Ljava/net/URL;
    //   4: ifnonnull +11 -> 15
    //   7: new 98	org/apache/axis/NoEndPointException
    //   10: dup
    //   11: invokespecial 99	org/apache/axis/NoEndPointException:<init>	()V
    //   14: athrow
    //   15: aload_0
    //   16: invokevirtual 100	com/zte/web/service/client/WSImgSystemInterfaceFacade/WSImgSystemInterfaceFacadeSoapBindingStub:createCall	()Lorg/apache/axis/client/Call;
    //   19: astore_2
    //   20: aload_2
    //   21: getstatic 33	com/zte/web/service/client/WSImgSystemInterfaceFacade/WSImgSystemInterfaceFacadeSoapBindingStub:_operations	[Lorg/apache/axis/description/OperationDesc;
    //   24: iconst_0
    //   25: aaload
    //   26: invokevirtual 101	org/apache/axis/client/Call:setOperation	(Lorg/apache/axis/description/OperationDesc;)V
    //   29: aload_2
    //   30: iconst_1
    //   31: invokevirtual 102	org/apache/axis/client/Call:setUseSOAPAction	(Z)V
    //   34: aload_2
    //   35: ldc 7
    //   37: invokevirtual 103	org/apache/axis/client/Call:setSOAPActionURI	(Ljava/lang/String;)V
    //   40: aload_2
    //   41: getstatic 82	org/apache/axis/soap/SOAPConstants:SOAP11_CONSTANTS	Lorg/apache/axis/soap/SOAP11Constants;
    //   44: invokevirtual 83	org/apache/axis/client/Call:setSOAPVersion	(Lorg/apache/axis/soap/SOAPConstants;)V
    //   47: aload_2
    //   48: new 6	javax/xml/namespace/QName
    //   51: dup
    //   52: ldc 104
    //   54: ldc 3
    //   56: invokespecial 9	javax/xml/namespace/QName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: invokevirtual 105	org/apache/axis/client/Call:setOperationName	(Ljavax/xml/namespace/QName;)V
    //   62: aload_0
    //   63: aload_2
    //   64: invokevirtual 106	com/zte/web/service/client/WSImgSystemInterfaceFacade/WSImgSystemInterfaceFacadeSoapBindingStub:setRequestHeaders	(Lorg/apache/axis/client/Call;)V
    //   67: aload_0
    //   68: aload_2
    //   69: invokevirtual 107	com/zte/web/service/client/WSImgSystemInterfaceFacade/WSImgSystemInterfaceFacadeSoapBindingStub:setAttachments	(Lorg/apache/axis/client/Call;)V
    //   72: aload_2
    //   73: iconst_1
    //   74: anewarray 108	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_1
    //   80: aastore
    //   81: invokevirtual 109	org/apache/axis/client/Call:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   84: astore_3
    //   85: aload_3
    //   86: instanceof 110
    //   89: ifeq +8 -> 97
    //   92: aload_3
    //   93: checkcast 110	java/rmi/RemoteException
    //   96: athrow
    //   97: aload_0
    //   98: aload_2
    //   99: invokevirtual 111	com/zte/web/service/client/WSImgSystemInterfaceFacade/WSImgSystemInterfaceFacadeSoapBindingStub:extractAttachments	(Lorg/apache/axis/client/Call;)V
    //   102: aload_3
    //   103: checkcast 18	[Ljava/lang/String;
    //   106: checkcast 18	[Ljava/lang/String;
    //   109: areturn
    //   110: astore 4
    //   112: aload_3
    //   113: ldc_w 18
    //   116: invokestatic 113	org/apache/axis/utils/JavaUtils:convert	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   119: checkcast 18	[Ljava/lang/String;
    //   122: checkcast 18	[Ljava/lang/String;
    //   125: areturn
    //   126: astore_3
    //   127: aload_3
    //   128: getfield 114	org/apache/axis/AxisFault:detail	Ljava/lang/Throwable;
    //   131: ifnull +39 -> 170
    //   134: aload_3
    //   135: getfield 114	org/apache/axis/AxisFault:detail	Ljava/lang/Throwable;
    //   138: instanceof 110
    //   141: ifeq +11 -> 152
    //   144: aload_3
    //   145: getfield 114	org/apache/axis/AxisFault:detail	Ljava/lang/Throwable;
    //   148: checkcast 110	java/rmi/RemoteException
    //   151: athrow
    //   152: aload_3
    //   153: getfield 114	org/apache/axis/AxisFault:detail	Ljava/lang/Throwable;
    //   156: instanceof 61
    //   159: ifeq +11 -> 170
    //   162: aload_3
    //   163: getfield 114	org/apache/axis/AxisFault:detail	Ljava/lang/Throwable;
    //   166: checkcast 61	com/zte/web/service/client/WSImgSystemInterfaceFacade/WSInvokeException
    //   169: athrow
    //   170: aload_3
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	WSImgSystemInterfaceFacadeSoapBindingStub
    //   0	172	1	paramString	String
    //   19	80	2	localCall	Call
    //   84	29	3	localObject	Object
    //   126	45	3	localAxisFault	AxisFault
    //   110	1	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   102	109	110	java/lang/Exception
    //   72	109	126	org/apache/axis/AxisFault
    //   110	125	126	org/apache/axis/AxisFault
  }
  
  static
  {
    _initOperationDesc1();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.WSImgSystemInterfaceFacade.WSImgSystemInterfaceFacadeSoapBindingStub
 * JD-Core Version:    0.7.0.1
 */