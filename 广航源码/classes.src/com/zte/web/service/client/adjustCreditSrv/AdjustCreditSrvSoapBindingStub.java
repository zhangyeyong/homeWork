package com.zte.web.service.client.adjustCreditSrv;

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

public class AdjustCreditSrvSoapBindingStub
  extends Stub
  implements AdjustCreditSrv
{
  private Vector cachedSerClasses = new Vector();
  private Vector cachedSerQNames = new Vector();
  private Vector cachedSerFactories = new Vector();
  private Vector cachedDeserFactories = new Vector();
  static OperationDesc[] _operations = new OperationDesc[1];
  
  private static void _initOperationDesc1()
  {
    OperationDesc localOperationDesc = new OperationDesc();
    localOperationDesc.setName("adjustCredit");
    ParameterDesc localParameterDesc = new ParameterDesc(new QName("", "request"), (byte)1, new QName("impl:AdjustCreditSrvRequest", "AdjustCreditSrvRequest"), AdjustCreditSrvRequest.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localOperationDesc.setReturnType(new QName("impl:AdjustCreditSrvResponse", "AdjustCreditSrvResponse"));
    localOperationDesc.setReturnClass(AdjustCreditSrvResponse.class);
    localOperationDesc.setReturnQName(new QName("", "adjustCreditReturn"));
    localOperationDesc.setStyle(Style.RPC);
    localOperationDesc.setUse(Use.ENCODED);
    _operations[0] = localOperationDesc;
  }
  
  public AdjustCreditSrvSoapBindingStub()
    throws AxisFault
  {
    this(null);
  }
  
  public AdjustCreditSrvSoapBindingStub(URL paramURL, javax.xml.rpc.Service paramService)
    throws AxisFault
  {
    this(paramService);
    this.cachedEndpoint = paramURL;
  }
  
  public AdjustCreditSrvSoapBindingStub(javax.xml.rpc.Service paramService)
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
    QName localQName = new QName("impl:AdjustCreditSrvRequest", "AdjustCreditSrvRequest");
    this.cachedSerQNames.add(localQName);
    Object localObject = AdjustCreditSrvRequest.class;
    this.cachedSerClasses.add(localObject);
    this.cachedSerFactories.add(localBeanSerializerFactory);
    this.cachedDeserFactories.add(localBeanDeserializerFactory);
    localQName = new QName("impl:AdjustCreditSrvResponse", "AdjustCreditSrvResponse");
    this.cachedSerQNames.add(localQName);
    localObject = AdjustCreditSrvResponse.class;
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
  public AdjustCreditSrvResponse adjustCredit(AdjustCreditSrvRequest paramAdjustCreditSrvRequest)
    throws RemoteException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	org/apache/axis/client/Stub:cachedEndpoint	Ljava/net/URL;
    //   4: ifnonnull +11 -> 15
    //   7: new 89	org/apache/axis/NoEndPointException
    //   10: dup
    //   11: invokespecial 90	org/apache/axis/NoEndPointException:<init>	()V
    //   14: athrow
    //   15: aload_0
    //   16: invokevirtual 91	com/zte/web/service/client/adjustCreditSrv/AdjustCreditSrvSoapBindingStub:createCall	()Lorg/apache/axis/client/Call;
    //   19: astore_2
    //   20: aload_2
    //   21: getstatic 26	com/zte/web/service/client/adjustCreditSrv/AdjustCreditSrvSoapBindingStub:_operations	[Lorg/apache/axis/description/OperationDesc;
    //   24: iconst_0
    //   25: aaload
    //   26: invokevirtual 92	org/apache/axis/client/Call:setOperation	(Lorg/apache/axis/description/OperationDesc;)V
    //   29: aload_2
    //   30: iconst_1
    //   31: invokevirtual 93	org/apache/axis/client/Call:setUseSOAPAction	(Z)V
    //   34: aload_2
    //   35: ldc 7
    //   37: invokevirtual 94	org/apache/axis/client/Call:setSOAPActionURI	(Ljava/lang/String;)V
    //   40: aload_2
    //   41: getstatic 73	org/apache/axis/soap/SOAPConstants:SOAP11_CONSTANTS	Lorg/apache/axis/soap/SOAP11Constants;
    //   44: invokevirtual 74	org/apache/axis/client/Call:setSOAPVersion	(Lorg/apache/axis/soap/SOAPConstants;)V
    //   47: aload_2
    //   48: new 6	javax/xml/namespace/QName
    //   51: dup
    //   52: ldc 95
    //   54: ldc 3
    //   56: invokespecial 9	javax/xml/namespace/QName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: invokevirtual 96	org/apache/axis/client/Call:setOperationName	(Ljavax/xml/namespace/QName;)V
    //   62: aload_0
    //   63: aload_2
    //   64: invokevirtual 97	com/zte/web/service/client/adjustCreditSrv/AdjustCreditSrvSoapBindingStub:setRequestHeaders	(Lorg/apache/axis/client/Call;)V
    //   67: aload_0
    //   68: aload_2
    //   69: invokevirtual 98	com/zte/web/service/client/adjustCreditSrv/AdjustCreditSrvSoapBindingStub:setAttachments	(Lorg/apache/axis/client/Call;)V
    //   72: aload_2
    //   73: iconst_1
    //   74: anewarray 99	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_1
    //   80: aastore
    //   81: invokevirtual 100	org/apache/axis/client/Call:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   84: astore_3
    //   85: aload_3
    //   86: instanceof 101
    //   89: ifeq +8 -> 97
    //   92: aload_3
    //   93: checkcast 101	java/rmi/RemoteException
    //   96: athrow
    //   97: aload_0
    //   98: aload_2
    //   99: invokevirtual 102	com/zte/web/service/client/adjustCreditSrv/AdjustCreditSrvSoapBindingStub:extractAttachments	(Lorg/apache/axis/client/Call;)V
    //   102: aload_3
    //   103: checkcast 18	com/zte/web/service/client/adjustCreditSrv/AdjustCreditSrvResponse
    //   106: areturn
    //   107: astore 4
    //   109: aload_3
    //   110: ldc_w 18
    //   113: invokestatic 104	org/apache/axis/utils/JavaUtils:convert	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   116: checkcast 18	com/zte/web/service/client/adjustCreditSrv/AdjustCreditSrvResponse
    //   119: areturn
    //   120: astore_3
    //   121: aload_3
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	AdjustCreditSrvSoapBindingStub
    //   0	123	1	paramAdjustCreditSrvRequest	AdjustCreditSrvRequest
    //   19	80	2	localCall	Call
    //   84	26	3	localObject	Object
    //   120	2	3	localAxisFault	AxisFault
    //   107	1	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   102	106	107	java/lang/Exception
    //   72	106	120	org/apache/axis/AxisFault
    //   107	119	120	org/apache/axis/AxisFault
  }
  
  static
  {
    _initOperationDesc1();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.client.adjustCreditSrv.AdjustCreditSrvSoapBindingStub
 * JD-Core Version:    0.7.0.1
 */