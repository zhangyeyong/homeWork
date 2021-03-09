package com.zte.web.service.appraiseImageSrv;

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

public class EidImageHistoryServiceSoapBindingStub
  extends Stub
  implements EvsAppraiseHistorisesDS
{
  private Vector cachedSerClasses = new Vector();
  private Vector cachedSerQNames = new Vector();
  private Vector cachedSerFactories = new Vector();
  private Vector cachedDeserFactories = new Vector();
  static OperationDesc[] _operations = new OperationDesc[2];
  
  private static void _initOperationDesc1()
  {
    OperationDesc localOperationDesc = new OperationDesc();
    localOperationDesc.setName("findHistoryByImageInfoId");
    ParameterDesc localParameterDesc = new ParameterDesc(new QName("", "imageNumber"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localOperationDesc.setReturnType(new QName("http://localhost:8080/EBILL_HAIER/services/EidImageHistoryService", "ArrayOf_tns1_EidAppraiseHistories"));
    localOperationDesc.setReturnClass([Lcom.zte.web.service.appraiseImageSrv.EidAppraiseHistories.class);
    localOperationDesc.setReturnQName(new QName("", "findHistoryByImageInfoIdReturn"));
    localOperationDesc.setStyle(Style.RPC);
    localOperationDesc.setUse(Use.ENCODED);
    _operations[0] = localOperationDesc;
    localOperationDesc = new OperationDesc();
    localOperationDesc.setName("remarkVideo");
    localParameterDesc = new ParameterDesc(new QName("", "boeNum"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "actKind"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "problem"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "des"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "employeeNum"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localOperationDesc.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    localOperationDesc.setReturnClass(String.class);
    localOperationDesc.setReturnQName(new QName("", "remarkVideoReturn"));
    localOperationDesc.setStyle(Style.RPC);
    localOperationDesc.setUse(Use.ENCODED);
    _operations[1] = localOperationDesc;
  }
  
  public EidImageHistoryServiceSoapBindingStub()
    throws AxisFault
  {
    this(null);
  }
  
  public EidImageHistoryServiceSoapBindingStub(URL paramURL, javax.xml.rpc.Service paramService)
    throws AxisFault
  {
    this(paramService);
    this.cachedEndpoint = paramURL;
  }
  
  public EidImageHistoryServiceSoapBindingStub(javax.xml.rpc.Service paramService)
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
    QName localQName1 = new QName("http://localhost:8080/EBILL_HAIER/services/EidImageHistoryService", "ArrayOf_tns1_EidAppraiseHistories");
    this.cachedSerQNames.add(localQName1);
    Object localObject = [Lcom.zte.web.service.appraiseImageSrv.EidAppraiseHistories.class;
    this.cachedSerClasses.add(localObject);
    localQName1 = new QName("impl:EidAppraiseHistories", "EidAppraiseHistories");
    QName localQName2 = null;
    this.cachedSerFactories.add(new ArraySerializerFactory(localQName1, localQName2));
    this.cachedDeserFactories.add(new ArrayDeserializerFactory());
    localQName1 = new QName("impl:EidAppraiseHistories", "EidAppraiseHistories");
    this.cachedSerQNames.add(localQName1);
    localObject = EidAppraiseHistories.class;
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
  public EidAppraiseHistories[] findHistoryByImageInfoId(String paramString)
    throws RemoteException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	org/apache/axis/client/Stub:cachedEndpoint	Ljava/net/URL;
    //   4: ifnonnull +11 -> 15
    //   7: new 100	org/apache/axis/NoEndPointException
    //   10: dup
    //   11: invokespecial 101	org/apache/axis/NoEndPointException:<init>	()V
    //   14: athrow
    //   15: aload_0
    //   16: invokevirtual 102	com/zte/web/service/appraiseImageSrv/EidImageHistoryServiceSoapBindingStub:createCall	()Lorg/apache/axis/client/Call;
    //   19: astore_2
    //   20: aload_2
    //   21: getstatic 26	com/zte/web/service/appraiseImageSrv/EidImageHistoryServiceSoapBindingStub:_operations	[Lorg/apache/axis/description/OperationDesc;
    //   24: iconst_0
    //   25: aaload
    //   26: invokevirtual 103	org/apache/axis/client/Call:setOperation	(Lorg/apache/axis/description/OperationDesc;)V
    //   29: aload_2
    //   30: iconst_1
    //   31: invokevirtual 104	org/apache/axis/client/Call:setUseSOAPAction	(Z)V
    //   34: aload_2
    //   35: ldc 7
    //   37: invokevirtual 105	org/apache/axis/client/Call:setSOAPActionURI	(Ljava/lang/String;)V
    //   40: aload_2
    //   41: getstatic 84	org/apache/axis/soap/SOAPConstants:SOAP11_CONSTANTS	Lorg/apache/axis/soap/SOAP11Constants;
    //   44: invokevirtual 85	org/apache/axis/client/Call:setSOAPVersion	(Lorg/apache/axis/soap/SOAPConstants;)V
    //   47: aload_2
    //   48: new 6	javax/xml/namespace/QName
    //   51: dup
    //   52: ldc 106
    //   54: ldc 3
    //   56: invokespecial 9	javax/xml/namespace/QName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: invokevirtual 107	org/apache/axis/client/Call:setOperationName	(Ljavax/xml/namespace/QName;)V
    //   62: aload_0
    //   63: aload_2
    //   64: invokevirtual 108	com/zte/web/service/appraiseImageSrv/EidImageHistoryServiceSoapBindingStub:setRequestHeaders	(Lorg/apache/axis/client/Call;)V
    //   67: aload_0
    //   68: aload_2
    //   69: invokevirtual 109	com/zte/web/service/appraiseImageSrv/EidImageHistoryServiceSoapBindingStub:setAttachments	(Lorg/apache/axis/client/Call;)V
    //   72: aload_2
    //   73: iconst_1
    //   74: anewarray 110	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_1
    //   80: aastore
    //   81: invokevirtual 111	org/apache/axis/client/Call:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   84: astore_3
    //   85: aload_3
    //   86: instanceof 112
    //   89: ifeq +8 -> 97
    //   92: aload_3
    //   93: checkcast 112	java/rmi/RemoteException
    //   96: athrow
    //   97: aload_0
    //   98: aload_2
    //   99: invokevirtual 113	com/zte/web/service/appraiseImageSrv/EidImageHistoryServiceSoapBindingStub:extractAttachments	(Lorg/apache/axis/client/Call;)V
    //   102: aload_3
    //   103: checkcast 18	[Lcom/zte/web/service/appraiseImageSrv/EidAppraiseHistories;
    //   106: checkcast 18	[Lcom/zte/web/service/appraiseImageSrv/EidAppraiseHistories;
    //   109: areturn
    //   110: astore 4
    //   112: aload_3
    //   113: ldc_w 18
    //   116: invokestatic 115	org/apache/axis/utils/JavaUtils:convert	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   119: checkcast 18	[Lcom/zte/web/service/appraiseImageSrv/EidAppraiseHistories;
    //   122: checkcast 18	[Lcom/zte/web/service/appraiseImageSrv/EidAppraiseHistories;
    //   125: areturn
    //   126: astore_3
    //   127: aload_3
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	EidImageHistoryServiceSoapBindingStub
    //   0	129	1	paramString	String
    //   19	80	2	localCall	Call
    //   84	29	3	localObject	Object
    //   126	2	3	localAxisFault	AxisFault
    //   110	1	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   102	109	110	java/lang/Exception
    //   72	109	126	org/apache/axis/AxisFault
    //   110	125	126	org/apache/axis/AxisFault
  }
  
  /* Error */
  public String remarkVideo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws RemoteException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	org/apache/axis/client/Stub:cachedEndpoint	Ljava/net/URL;
    //   4: ifnonnull +11 -> 15
    //   7: new 100	org/apache/axis/NoEndPointException
    //   10: dup
    //   11: invokespecial 101	org/apache/axis/NoEndPointException:<init>	()V
    //   14: athrow
    //   15: aload_0
    //   16: invokevirtual 102	com/zte/web/service/appraiseImageSrv/EidImageHistoryServiceSoapBindingStub:createCall	()Lorg/apache/axis/client/Call;
    //   19: astore 6
    //   21: aload 6
    //   23: getstatic 26	com/zte/web/service/appraiseImageSrv/EidImageHistoryServiceSoapBindingStub:_operations	[Lorg/apache/axis/description/OperationDesc;
    //   26: iconst_1
    //   27: aaload
    //   28: invokevirtual 103	org/apache/axis/client/Call:setOperation	(Lorg/apache/axis/description/OperationDesc;)V
    //   31: aload 6
    //   33: iconst_1
    //   34: invokevirtual 104	org/apache/axis/client/Call:setUseSOAPAction	(Z)V
    //   37: aload 6
    //   39: ldc 7
    //   41: invokevirtual 105	org/apache/axis/client/Call:setSOAPActionURI	(Ljava/lang/String;)V
    //   44: aload 6
    //   46: getstatic 84	org/apache/axis/soap/SOAPConstants:SOAP11_CONSTANTS	Lorg/apache/axis/soap/SOAP11Constants;
    //   49: invokevirtual 85	org/apache/axis/client/Call:setSOAPVersion	(Lorg/apache/axis/soap/SOAPConstants;)V
    //   52: aload 6
    //   54: new 6	javax/xml/namespace/QName
    //   57: dup
    //   58: ldc 106
    //   60: ldc 27
    //   62: invokespecial 9	javax/xml/namespace/QName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: invokevirtual 107	org/apache/axis/client/Call:setOperationName	(Ljavax/xml/namespace/QName;)V
    //   68: aload_0
    //   69: aload 6
    //   71: invokevirtual 108	com/zte/web/service/appraiseImageSrv/EidImageHistoryServiceSoapBindingStub:setRequestHeaders	(Lorg/apache/axis/client/Call;)V
    //   74: aload_0
    //   75: aload 6
    //   77: invokevirtual 109	com/zte/web/service/appraiseImageSrv/EidImageHistoryServiceSoapBindingStub:setAttachments	(Lorg/apache/axis/client/Call;)V
    //   80: aload 6
    //   82: iconst_5
    //   83: anewarray 110	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_1
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: aload_2
    //   93: aastore
    //   94: dup
    //   95: iconst_2
    //   96: aload_3
    //   97: aastore
    //   98: dup
    //   99: iconst_3
    //   100: aload 4
    //   102: aastore
    //   103: dup
    //   104: iconst_4
    //   105: aload 5
    //   107: aastore
    //   108: invokevirtual 111	org/apache/axis/client/Call:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   111: astore 7
    //   113: aload 7
    //   115: instanceof 112
    //   118: ifeq +9 -> 127
    //   121: aload 7
    //   123: checkcast 112	java/rmi/RemoteException
    //   126: athrow
    //   127: aload_0
    //   128: aload 6
    //   130: invokevirtual 113	com/zte/web/service/appraiseImageSrv/EidImageHistoryServiceSoapBindingStub:extractAttachments	(Lorg/apache/axis/client/Call;)V
    //   133: aload 7
    //   135: checkcast 12	java/lang/String
    //   138: areturn
    //   139: astore 8
    //   141: aload 7
    //   143: ldc_w 12
    //   146: invokestatic 115	org/apache/axis/utils/JavaUtils:convert	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   149: checkcast 12	java/lang/String
    //   152: areturn
    //   153: astore 7
    //   155: aload 7
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	EidImageHistoryServiceSoapBindingStub
    //   0	158	1	paramString1	String
    //   0	158	2	paramString2	String
    //   0	158	3	paramString3	String
    //   0	158	4	paramString4	String
    //   0	158	5	paramString5	String
    //   19	110	6	localCall	Call
    //   111	31	7	localObject	Object
    //   153	3	7	localAxisFault	AxisFault
    //   139	1	8	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   133	138	139	java/lang/Exception
    //   80	138	153	org/apache/axis/AxisFault
    //   139	152	153	org/apache/axis/AxisFault
  }
  
  static
  {
    _initOperationDesc1();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.appraiseImageSrv.EidImageHistoryServiceSoapBindingStub
 * JD-Core Version:    0.7.0.1
 */