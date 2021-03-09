package com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00001;

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

public class SynboeHeaderImageDSSoapBindingStub
  extends Stub
  implements SynboeHeaderImageDS
{
  private Vector cachedSerClasses = new Vector();
  private Vector cachedSerQNames = new Vector();
  private Vector cachedSerFactories = new Vector();
  private Vector cachedDeserFactories = new Vector();
  static OperationDesc[] _operations = new OperationDesc[2];
  
  private static void _initOperationDesc1()
  {
    OperationDesc localOperationDesc = new OperationDesc();
    localOperationDesc.setName("createImage");
    ParameterDesc localParameterDesc = new ParameterDesc(new QName("", "boeNum"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localParameterDesc = new ParameterDesc(new QName("", "date"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localOperationDesc.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
    localOperationDesc.setReturnClass(Boolean.TYPE);
    localOperationDesc.setReturnQName(new QName("", "createImageReturn"));
    localOperationDesc.setStyle(Style.RPC);
    localOperationDesc.setUse(Use.ENCODED);
    _operations[0] = localOperationDesc;
    localOperationDesc = new OperationDesc();
    localOperationDesc.setName("deleteImage");
    localParameterDesc = new ParameterDesc(new QName("", "boeNum"), (byte)1, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localOperationDesc.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
    localOperationDesc.setReturnClass(Boolean.TYPE);
    localOperationDesc.setReturnQName(new QName("", "deleteImageReturn"));
    localOperationDesc.setStyle(Style.RPC);
    localOperationDesc.setUse(Use.ENCODED);
    _operations[1] = localOperationDesc;
  }
  
  public SynboeHeaderImageDSSoapBindingStub()
    throws AxisFault
  {
    this(null);
  }
  
  public SynboeHeaderImageDSSoapBindingStub(URL paramURL, javax.xml.rpc.Service paramService)
    throws AxisFault
  {
    this(paramService);
    this.cachedEndpoint = paramURL;
  }
  
  public SynboeHeaderImageDSSoapBindingStub(javax.xml.rpc.Service paramService)
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
  public boolean createImage(String paramString1, String paramString2)
    throws RemoteException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	org/apache/axis/client/Stub:cachedEndpoint	Ljava/net/URL;
    //   4: ifnonnull +11 -> 15
    //   7: new 66	org/apache/axis/NoEndPointException
    //   10: dup
    //   11: invokespecial 67	org/apache/axis/NoEndPointException:<init>	()V
    //   14: athrow
    //   15: aload_0
    //   16: invokevirtual 68	com/zte/eas/bmsctrl/ws/BOE_SC_CMS_00001/SynboeHeaderImageDSSoapBindingStub:createCall	()Lorg/apache/axis/client/Call;
    //   19: astore_3
    //   20: aload_3
    //   21: getstatic 26	com/zte/eas/bmsctrl/ws/BOE_SC_CMS_00001/SynboeHeaderImageDSSoapBindingStub:_operations	[Lorg/apache/axis/description/OperationDesc;
    //   24: iconst_0
    //   25: aaload
    //   26: invokevirtual 69	org/apache/axis/client/Call:setOperation	(Lorg/apache/axis/description/OperationDesc;)V
    //   29: aload_3
    //   30: iconst_1
    //   31: invokevirtual 70	org/apache/axis/client/Call:setUseSOAPAction	(Z)V
    //   34: aload_3
    //   35: ldc 7
    //   37: invokevirtual 71	org/apache/axis/client/Call:setSOAPActionURI	(Ljava/lang/String;)V
    //   40: aload_3
    //   41: getstatic 72	org/apache/axis/soap/SOAPConstants:SOAP11_CONSTANTS	Lorg/apache/axis/soap/SOAP11Constants;
    //   44: invokevirtual 73	org/apache/axis/client/Call:setSOAPVersion	(Lorg/apache/axis/soap/SOAPConstants;)V
    //   47: aload_3
    //   48: new 6	javax/xml/namespace/QName
    //   51: dup
    //   52: ldc 74
    //   54: ldc 3
    //   56: invokespecial 9	javax/xml/namespace/QName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: invokevirtual 75	org/apache/axis/client/Call:setOperationName	(Ljavax/xml/namespace/QName;)V
    //   62: aload_0
    //   63: aload_3
    //   64: invokevirtual 76	com/zte/eas/bmsctrl/ws/BOE_SC_CMS_00001/SynboeHeaderImageDSSoapBindingStub:setRequestHeaders	(Lorg/apache/axis/client/Call;)V
    //   67: aload_0
    //   68: aload_3
    //   69: invokevirtual 77	com/zte/eas/bmsctrl/ws/BOE_SC_CMS_00001/SynboeHeaderImageDSSoapBindingStub:setAttachments	(Lorg/apache/axis/client/Call;)V
    //   72: aload_3
    //   73: iconst_2
    //   74: anewarray 78	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_1
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: aload_2
    //   84: aastore
    //   85: invokevirtual 79	org/apache/axis/client/Call:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   88: astore 4
    //   90: aload 4
    //   92: instanceof 80
    //   95: ifeq +9 -> 104
    //   98: aload 4
    //   100: checkcast 80	java/rmi/RemoteException
    //   103: athrow
    //   104: aload_0
    //   105: aload_3
    //   106: invokevirtual 81	com/zte/eas/bmsctrl/ws/BOE_SC_CMS_00001/SynboeHeaderImageDSSoapBindingStub:extractAttachments	(Lorg/apache/axis/client/Call;)V
    //   109: aload 4
    //   111: checkcast 82	java/lang/Boolean
    //   114: invokevirtual 83	java/lang/Boolean:booleanValue	()Z
    //   117: ireturn
    //   118: astore 5
    //   120: aload 4
    //   122: getstatic 18	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   125: invokestatic 85	org/apache/axis/utils/JavaUtils:convert	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   128: checkcast 82	java/lang/Boolean
    //   131: invokevirtual 83	java/lang/Boolean:booleanValue	()Z
    //   134: ireturn
    //   135: astore 4
    //   137: aload 4
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	SynboeHeaderImageDSSoapBindingStub
    //   0	140	1	paramString1	String
    //   0	140	2	paramString2	String
    //   19	87	3	localCall	Call
    //   88	33	4	localObject	java.lang.Object
    //   135	3	4	localAxisFault	AxisFault
    //   118	1	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   109	117	118	java/lang/Exception
    //   72	117	135	org/apache/axis/AxisFault
    //   118	134	135	org/apache/axis/AxisFault
  }
  
  /* Error */
  public boolean deleteImage(String paramString)
    throws RemoteException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	org/apache/axis/client/Stub:cachedEndpoint	Ljava/net/URL;
    //   4: ifnonnull +11 -> 15
    //   7: new 66	org/apache/axis/NoEndPointException
    //   10: dup
    //   11: invokespecial 67	org/apache/axis/NoEndPointException:<init>	()V
    //   14: athrow
    //   15: aload_0
    //   16: invokevirtual 68	com/zte/eas/bmsctrl/ws/BOE_SC_CMS_00001/SynboeHeaderImageDSSoapBindingStub:createCall	()Lorg/apache/axis/client/Call;
    //   19: astore_2
    //   20: aload_2
    //   21: getstatic 26	com/zte/eas/bmsctrl/ws/BOE_SC_CMS_00001/SynboeHeaderImageDSSoapBindingStub:_operations	[Lorg/apache/axis/description/OperationDesc;
    //   24: iconst_1
    //   25: aaload
    //   26: invokevirtual 69	org/apache/axis/client/Call:setOperation	(Lorg/apache/axis/description/OperationDesc;)V
    //   29: aload_2
    //   30: iconst_1
    //   31: invokevirtual 70	org/apache/axis/client/Call:setUseSOAPAction	(Z)V
    //   34: aload_2
    //   35: ldc 7
    //   37: invokevirtual 71	org/apache/axis/client/Call:setSOAPActionURI	(Ljava/lang/String;)V
    //   40: aload_2
    //   41: getstatic 72	org/apache/axis/soap/SOAPConstants:SOAP11_CONSTANTS	Lorg/apache/axis/soap/SOAP11Constants;
    //   44: invokevirtual 73	org/apache/axis/client/Call:setSOAPVersion	(Lorg/apache/axis/soap/SOAPConstants;)V
    //   47: aload_2
    //   48: new 6	javax/xml/namespace/QName
    //   51: dup
    //   52: ldc 74
    //   54: ldc 27
    //   56: invokespecial 9	javax/xml/namespace/QName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: invokevirtual 75	org/apache/axis/client/Call:setOperationName	(Ljavax/xml/namespace/QName;)V
    //   62: aload_0
    //   63: aload_2
    //   64: invokevirtual 76	com/zte/eas/bmsctrl/ws/BOE_SC_CMS_00001/SynboeHeaderImageDSSoapBindingStub:setRequestHeaders	(Lorg/apache/axis/client/Call;)V
    //   67: aload_0
    //   68: aload_2
    //   69: invokevirtual 77	com/zte/eas/bmsctrl/ws/BOE_SC_CMS_00001/SynboeHeaderImageDSSoapBindingStub:setAttachments	(Lorg/apache/axis/client/Call;)V
    //   72: aload_2
    //   73: iconst_1
    //   74: anewarray 78	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_1
    //   80: aastore
    //   81: invokevirtual 79	org/apache/axis/client/Call:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   84: astore_3
    //   85: aload_3
    //   86: instanceof 80
    //   89: ifeq +8 -> 97
    //   92: aload_3
    //   93: checkcast 80	java/rmi/RemoteException
    //   96: athrow
    //   97: aload_0
    //   98: aload_2
    //   99: invokevirtual 81	com/zte/eas/bmsctrl/ws/BOE_SC_CMS_00001/SynboeHeaderImageDSSoapBindingStub:extractAttachments	(Lorg/apache/axis/client/Call;)V
    //   102: aload_3
    //   103: checkcast 82	java/lang/Boolean
    //   106: invokevirtual 83	java/lang/Boolean:booleanValue	()Z
    //   109: ireturn
    //   110: astore 4
    //   112: aload_3
    //   113: getstatic 18	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   116: invokestatic 85	org/apache/axis/utils/JavaUtils:convert	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   119: checkcast 82	java/lang/Boolean
    //   122: invokevirtual 83	java/lang/Boolean:booleanValue	()Z
    //   125: ireturn
    //   126: astore_3
    //   127: aload_3
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	SynboeHeaderImageDSSoapBindingStub
    //   0	129	1	paramString	String
    //   19	80	2	localCall	Call
    //   84	29	3	localObject	java.lang.Object
    //   126	2	3	localAxisFault	AxisFault
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
 * Qualified Name:     com.zte.eas.bmsctrl.ws.BOE_SC_CMS_00001.SynboeHeaderImageDSSoapBindingStub
 * JD-Core Version:    0.7.0.1
 */