package com.zte.eas.login.EASLogin;

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

public class EASLoginSoapBindingStub
  extends Stub
  implements EASLoginProxy
{
  private Vector cachedSerClasses = new Vector();
  private Vector cachedSerQNames = new Vector();
  private Vector cachedSerFactories = new Vector();
  private Vector cachedDeserFactories = new Vector();
  static OperationDesc[] _operations = new OperationDesc[2];
  
  private static void _initOperationDesc1()
  {
    OperationDesc localOperationDesc = new OperationDesc();
    localOperationDesc.setName("login");
    ParameterDesc localParameterDesc = new ParameterDesc(new QName("", "userName"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "password"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "slnName"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "dcName"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "language"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "dbType"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "int"), Integer.TYPE, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "authPattern"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localOperationDesc.setReturnType(new QName("urn:client", "WSContext"));
    localOperationDesc.setReturnClass(WSContext.class);
    localOperationDesc.setReturnQName(new QName("", "loginReturn"));
    localOperationDesc.setStyle(Style.RPC);
    localOperationDesc.setUse(Use.ENCODED);
    _operations[0] = localOperationDesc;
    localOperationDesc = new OperationDesc();
    localOperationDesc.setName("login");
    localParameterDesc = new ParameterDesc(new QName("", "userName"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "password"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "slnName"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "dcName"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "language"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "dbType"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "int"), Integer.TYPE, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localOperationDesc.setReturnType(new QName("urn:client", "WSContext"));
    localOperationDesc.setReturnClass(WSContext.class);
    localOperationDesc.setReturnQName(new QName("", "loginReturn"));
    localOperationDesc.setStyle(Style.RPC);
    localOperationDesc.setUse(Use.ENCODED);
    _operations[1] = localOperationDesc;
  }
  
  public EASLoginSoapBindingStub()
    throws AxisFault
  {
    this(null);
  }
  
  public EASLoginSoapBindingStub(URL paramURL, javax.xml.rpc.Service paramService)
    throws AxisFault
  {
    this(paramService);
    this.cachedEndpoint = paramURL;
  }
  
  public EASLoginSoapBindingStub(javax.xml.rpc.Service paramService)
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
    QName localQName = new QName("urn:client", "WSContext");
    this.cachedSerQNames.add(localQName);
    WSContext localWSContext = WSContext.class;
    this.cachedSerClasses.add(localWSContext);
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
  public WSContext login(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
    throws RemoteException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	org/apache/axis/client/Stub:cachedEndpoint	Ljava/net/URL;
    //   4: ifnonnull +11 -> 15
    //   7: new 96	org/apache/axis/NoEndPointException
    //   10: dup
    //   11: invokespecial 97	org/apache/axis/NoEndPointException:<init>	()V
    //   14: athrow
    //   15: aload_0
    //   16: invokevirtual 98	com/zte/eas/login/EASLogin/EASLoginSoapBindingStub:createCall	()Lorg/apache/axis/client/Call;
    //   19: astore 8
    //   21: aload 8
    //   23: getstatic 34	com/zte/eas/login/EASLogin/EASLoginSoapBindingStub:_operations	[Lorg/apache/axis/description/OperationDesc;
    //   26: iconst_0
    //   27: aaload
    //   28: invokevirtual 99	org/apache/axis/client/Call:setOperation	(Lorg/apache/axis/description/OperationDesc;)V
    //   31: aload 8
    //   33: iconst_1
    //   34: invokevirtual 100	org/apache/axis/client/Call:setUseSOAPAction	(Z)V
    //   37: aload 8
    //   39: ldc 7
    //   41: invokevirtual 101	org/apache/axis/client/Call:setSOAPActionURI	(Ljava/lang/String;)V
    //   44: aload 8
    //   46: getstatic 80	org/apache/axis/soap/SOAPConstants:SOAP11_CONSTANTS	Lorg/apache/axis/soap/SOAP11Constants;
    //   49: invokevirtual 81	org/apache/axis/client/Call:setSOAPVersion	(Lorg/apache/axis/soap/SOAPConstants;)V
    //   52: aload 8
    //   54: new 6	javax/xml/namespace/QName
    //   57: dup
    //   58: ldc 102
    //   60: ldc 3
    //   62: invokespecial 9	javax/xml/namespace/QName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: invokevirtual 103	org/apache/axis/client/Call:setOperationName	(Ljavax/xml/namespace/QName;)V
    //   68: aload_0
    //   69: aload 8
    //   71: invokevirtual 104	com/zte/eas/login/EASLogin/EASLoginSoapBindingStub:setRequestHeaders	(Lorg/apache/axis/client/Call;)V
    //   74: aload_0
    //   75: aload 8
    //   77: invokevirtual 105	com/zte/eas/login/EASLogin/EASLoginSoapBindingStub:setAttachments	(Lorg/apache/axis/client/Call;)V
    //   80: aload 8
    //   82: bipush 7
    //   84: anewarray 106	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_1
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: aload_2
    //   94: aastore
    //   95: dup
    //   96: iconst_2
    //   97: aload_3
    //   98: aastore
    //   99: dup
    //   100: iconst_3
    //   101: aload 4
    //   103: aastore
    //   104: dup
    //   105: iconst_4
    //   106: aload 5
    //   108: aastore
    //   109: dup
    //   110: iconst_5
    //   111: new 107	java/lang/Integer
    //   114: dup
    //   115: iload 6
    //   117: invokespecial 108	java/lang/Integer:<init>	(I)V
    //   120: aastore
    //   121: dup
    //   122: bipush 6
    //   124: aload 7
    //   126: aastore
    //   127: invokevirtual 109	org/apache/axis/client/Call:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   130: astore 9
    //   132: aload 9
    //   134: instanceof 110
    //   137: ifeq +9 -> 146
    //   140: aload 9
    //   142: checkcast 110	java/rmi/RemoteException
    //   145: athrow
    //   146: aload_0
    //   147: aload 8
    //   149: invokevirtual 111	com/zte/eas/login/EASLogin/EASLoginSoapBindingStub:extractAttachments	(Lorg/apache/axis/client/Call;)V
    //   152: aload 9
    //   154: checkcast 26	com/zte/eas/login/EASLogin/WSContext
    //   157: areturn
    //   158: astore 10
    //   160: aload 9
    //   162: ldc_w 26
    //   165: invokestatic 113	org/apache/axis/utils/JavaUtils:convert	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   168: checkcast 26	com/zte/eas/login/EASLogin/WSContext
    //   171: areturn
    //   172: astore 9
    //   174: aload 9
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	EASLoginSoapBindingStub
    //   0	177	1	paramString1	String
    //   0	177	2	paramString2	String
    //   0	177	3	paramString3	String
    //   0	177	4	paramString4	String
    //   0	177	5	paramString5	String
    //   0	177	6	paramInt	int
    //   0	177	7	paramString6	String
    //   19	129	8	localCall	Call
    //   130	31	9	localObject	Object
    //   172	3	9	localAxisFault	AxisFault
    //   158	1	10	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   152	157	158	java/lang/Exception
    //   80	157	172	org/apache/axis/AxisFault
    //   158	171	172	org/apache/axis/AxisFault
  }
  
  /* Error */
  public WSContext login(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
    throws RemoteException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	org/apache/axis/client/Stub:cachedEndpoint	Ljava/net/URL;
    //   4: ifnonnull +11 -> 15
    //   7: new 96	org/apache/axis/NoEndPointException
    //   10: dup
    //   11: invokespecial 97	org/apache/axis/NoEndPointException:<init>	()V
    //   14: athrow
    //   15: aload_0
    //   16: invokevirtual 98	com/zte/eas/login/EASLogin/EASLoginSoapBindingStub:createCall	()Lorg/apache/axis/client/Call;
    //   19: astore 7
    //   21: aload 7
    //   23: getstatic 34	com/zte/eas/login/EASLogin/EASLoginSoapBindingStub:_operations	[Lorg/apache/axis/description/OperationDesc;
    //   26: iconst_1
    //   27: aaload
    //   28: invokevirtual 99	org/apache/axis/client/Call:setOperation	(Lorg/apache/axis/description/OperationDesc;)V
    //   31: aload 7
    //   33: iconst_1
    //   34: invokevirtual 100	org/apache/axis/client/Call:setUseSOAPAction	(Z)V
    //   37: aload 7
    //   39: ldc 7
    //   41: invokevirtual 101	org/apache/axis/client/Call:setSOAPActionURI	(Ljava/lang/String;)V
    //   44: aload 7
    //   46: getstatic 80	org/apache/axis/soap/SOAPConstants:SOAP11_CONSTANTS	Lorg/apache/axis/soap/SOAP11Constants;
    //   49: invokevirtual 81	org/apache/axis/client/Call:setSOAPVersion	(Lorg/apache/axis/soap/SOAPConstants;)V
    //   52: aload 7
    //   54: new 6	javax/xml/namespace/QName
    //   57: dup
    //   58: ldc 102
    //   60: ldc 3
    //   62: invokespecial 9	javax/xml/namespace/QName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: invokevirtual 103	org/apache/axis/client/Call:setOperationName	(Ljavax/xml/namespace/QName;)V
    //   68: aload_0
    //   69: aload 7
    //   71: invokevirtual 104	com/zte/eas/login/EASLogin/EASLoginSoapBindingStub:setRequestHeaders	(Lorg/apache/axis/client/Call;)V
    //   74: aload_0
    //   75: aload 7
    //   77: invokevirtual 105	com/zte/eas/login/EASLogin/EASLoginSoapBindingStub:setAttachments	(Lorg/apache/axis/client/Call;)V
    //   80: aload 7
    //   82: bipush 6
    //   84: anewarray 106	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_1
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: aload_2
    //   94: aastore
    //   95: dup
    //   96: iconst_2
    //   97: aload_3
    //   98: aastore
    //   99: dup
    //   100: iconst_3
    //   101: aload 4
    //   103: aastore
    //   104: dup
    //   105: iconst_4
    //   106: aload 5
    //   108: aastore
    //   109: dup
    //   110: iconst_5
    //   111: new 107	java/lang/Integer
    //   114: dup
    //   115: iload 6
    //   117: invokespecial 108	java/lang/Integer:<init>	(I)V
    //   120: aastore
    //   121: invokevirtual 109	org/apache/axis/client/Call:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   124: astore 8
    //   126: aload 8
    //   128: instanceof 110
    //   131: ifeq +9 -> 140
    //   134: aload 8
    //   136: checkcast 110	java/rmi/RemoteException
    //   139: athrow
    //   140: aload_0
    //   141: aload 7
    //   143: invokevirtual 111	com/zte/eas/login/EASLogin/EASLoginSoapBindingStub:extractAttachments	(Lorg/apache/axis/client/Call;)V
    //   146: aload 8
    //   148: checkcast 26	com/zte/eas/login/EASLogin/WSContext
    //   151: areturn
    //   152: astore 9
    //   154: aload 8
    //   156: ldc_w 26
    //   159: invokestatic 113	org/apache/axis/utils/JavaUtils:convert	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   162: checkcast 26	com/zte/eas/login/EASLogin/WSContext
    //   165: areturn
    //   166: astore 8
    //   168: aload 8
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	EASLoginSoapBindingStub
    //   0	171	1	paramString1	String
    //   0	171	2	paramString2	String
    //   0	171	3	paramString3	String
    //   0	171	4	paramString4	String
    //   0	171	5	paramString5	String
    //   0	171	6	paramInt	int
    //   19	123	7	localCall	Call
    //   124	31	8	localObject	Object
    //   166	3	8	localAxisFault	AxisFault
    //   152	1	9	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   146	151	152	java/lang/Exception
    //   80	151	166	org/apache/axis/AxisFault
    //   152	165	166	org/apache/axis/AxisFault
  }
  
  static
  {
    _initOperationDesc1();
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.login.EASLogin.EASLoginSoapBindingStub
 * JD-Core Version:    0.7.0.1
 */