package com.zte.web.service.esp;

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
import org.apache.axis.encoding.ser.BaseDeserializerFactory;
import org.apache.axis.encoding.ser.BaseSerializerFactory;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.encoding.ser.EnumDeserializerFactory;
import org.apache.axis.encoding.ser.EnumSerializerFactory;
import org.apache.axis.encoding.ser.SimpleDeserializerFactory;
import org.apache.axis.encoding.ser.SimpleListDeserializerFactory;
import org.apache.axis.encoding.ser.SimpleListSerializerFactory;
import org.apache.axis.encoding.ser.SimpleSerializerFactory;

public class QueryPortalCommonServiceSOAPStub
  extends Stub
  implements QueryPortalCommonService_PortType
{
  private Vector cachedSerClasses = new Vector();
  private Vector cachedSerQNames = new Vector();
  private Vector cachedSerFactories = new Vector();
  private Vector cachedDeserFactories = new Vector();
  static OperationDesc[] _operations = new OperationDesc[1];
  
  private static void _initOperationDesc1()
  {
    OperationDesc localOperationDesc = new OperationDesc();
    localOperationDesc.setName("PortalQueryOperation");
    ParameterDesc localParameterDesc = new ParameterDesc(new QName("http://eai.haier.com/QueryPortalCommonService/", "InputMessage"), (byte)1, new QName("http://eai.haier.com/QueryPortalCommonService/", "InputType"), InputType.class, false, false);
    localOperationDesc.addParameter(localParameterDesc);
    localOperationDesc.setReturnType(new QName("http://eai.haier.com/QueryPortalCommonService/", "OutputType"));
    localOperationDesc.setReturnClass(OutputType.class);
    localOperationDesc.setReturnQName(new QName("http://eai.haier.com/QueryPortalCommonService/", "OutputMessage"));
    localOperationDesc.setStyle(Style.WRAPPED);
    localOperationDesc.setUse(Use.LITERAL);
    _operations[0] = localOperationDesc;
  }
  
  public QueryPortalCommonServiceSOAPStub()
    throws AxisFault
  {
    this(null);
  }
  
  public QueryPortalCommonServiceSOAPStub(URL paramURL, javax.xml.rpc.Service paramService)
    throws AxisFault
  {
    this(paramService);
    this.cachedEndpoint = paramURL;
  }
  
  public QueryPortalCommonServiceSOAPStub(javax.xml.rpc.Service paramService)
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
    QName localQName1 = new QName("http://eai.haier.com/QueryPortalCommonService/", ">>RowSet>Row>Column");
    this.cachedSerQNames.add(localQName1);
    Object localObject = RowSetRowColumn.class;
    this.cachedSerClasses.add(localObject);
    this.cachedSerFactories.add(BaseSerializerFactory.createFactory(SimpleSerializerFactory.class, (Class)localObject, localQName1));
    this.cachedDeserFactories.add(BaseDeserializerFactory.createFactory(SimpleDeserializerFactory.class, (Class)localObject, localQName1));
    localQName1 = new QName("http://eai.haier.com/QueryPortalCommonService/", ">>RowSingle>Row>Column");
    this.cachedSerQNames.add(localQName1);
    localObject = RowSingleRowColumn.class;
    this.cachedSerClasses.add(localObject);
    this.cachedSerFactories.add(BaseSerializerFactory.createFactory(SimpleSerializerFactory.class, (Class)localObject, localQName1));
    this.cachedDeserFactories.add(BaseDeserializerFactory.createFactory(SimpleDeserializerFactory.class, (Class)localObject, localQName1));
    localQName1 = new QName("http://eai.haier.com/QueryPortalCommonService/", ">RowSet>Row");
    this.cachedSerQNames.add(localQName1);
    localObject = [Lcom.zte.web.service.esp.RowSetRowColumn.class;
    this.cachedSerClasses.add(localObject);
    localQName1 = new QName("http://eai.haier.com/QueryPortalCommonService/", ">>RowSet>Row>Column");
    QName localQName2 = new QName("http://eai.haier.com/QueryPortalCommonService/", "Column");
    this.cachedSerFactories.add(new ArraySerializerFactory(localQName1, localQName2));
    this.cachedDeserFactories.add(new ArrayDeserializerFactory());
    localQName1 = new QName("http://eai.haier.com/QueryPortalCommonService/", ">RowSingle>Row");
    this.cachedSerQNames.add(localQName1);
    localObject = [Lcom.zte.web.service.esp.RowSingleRowColumn.class;
    this.cachedSerClasses.add(localObject);
    localQName1 = new QName("http://eai.haier.com/QueryPortalCommonService/", ">>RowSingle>Row>Column");
    localQName2 = new QName("http://eai.haier.com/QueryPortalCommonService/", "Column");
    this.cachedSerFactories.add(new ArraySerializerFactory(localQName1, localQName2));
    this.cachedDeserFactories.add(new ArrayDeserializerFactory());
    localQName1 = new QName("http://eai.haier.com/QueryPortalCommonService/", "InputType");
    this.cachedSerQNames.add(localQName1);
    localObject = InputType.class;
    this.cachedSerClasses.add(localObject);
    this.cachedSerFactories.add(localBeanSerializerFactory);
    this.cachedDeserFactories.add(localBeanDeserializerFactory);
    localQName1 = new QName("http://eai.haier.com/QueryPortalCommonService/", "OutputType");
    this.cachedSerQNames.add(localQName1);
    localObject = OutputType.class;
    this.cachedSerClasses.add(localObject);
    this.cachedSerFactories.add(localBeanSerializerFactory);
    this.cachedDeserFactories.add(localBeanDeserializerFactory);
    localQName1 = new QName("http://eai.haier.com/QueryPortalCommonService/", "RowSet");
    this.cachedSerQNames.add(localQName1);
    localObject = [[Lcom.zte.web.service.esp.RowSetRowColumn.class;
    this.cachedSerClasses.add(localObject);
    localQName1 = new QName("http://eai.haier.com/QueryPortalCommonService/", ">RowSet>Row");
    localQName2 = new QName("http://eai.haier.com/QueryPortalCommonService/", "Row");
    this.cachedSerFactories.add(new ArraySerializerFactory(localQName1, localQName2));
    this.cachedDeserFactories.add(new ArrayDeserializerFactory());
    localQName1 = new QName("http://eai.haier.com/QueryPortalCommonService/", "RowSingle");
    this.cachedSerQNames.add(localQName1);
    localObject = RowSingle.class;
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
          localCall.setEncodingStyle(null);
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
  public OutputType portalQueryOperation(InputType paramInputType)
    throws RemoteException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	org/apache/axis/client/Stub:cachedEndpoint	Ljava/net/URL;
    //   4: ifnonnull +11 -> 15
    //   7: new 102	org/apache/axis/NoEndPointException
    //   10: dup
    //   11: invokespecial 103	org/apache/axis/NoEndPointException:<init>	()V
    //   14: athrow
    //   15: aload_0
    //   16: invokevirtual 104	com/zte/web/service/esp/QueryPortalCommonServiceSOAPStub:createCall	()Lorg/apache/axis/client/Call;
    //   19: astore_2
    //   20: aload_2
    //   21: getstatic 24	com/zte/web/service/esp/QueryPortalCommonServiceSOAPStub:_operations	[Lorg/apache/axis/description/OperationDesc;
    //   24: iconst_0
    //   25: aaload
    //   26: invokevirtual 105	org/apache/axis/client/Call:setOperation	(Lorg/apache/axis/description/OperationDesc;)V
    //   29: aload_2
    //   30: iconst_1
    //   31: invokevirtual 106	org/apache/axis/client/Call:setUseSOAPAction	(Z)V
    //   34: aload_2
    //   35: ldc 107
    //   37: invokevirtual 108	org/apache/axis/client/Call:setSOAPActionURI	(Ljava/lang/String;)V
    //   40: aload_2
    //   41: aconst_null
    //   42: invokevirtual 89	org/apache/axis/client/Call:setEncodingStyle	(Ljava/lang/String;)V
    //   45: aload_2
    //   46: ldc 109
    //   48: getstatic 110	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   51: invokevirtual 87	org/apache/axis/client/Call:setProperty	(Ljava/lang/String;Ljava/lang/Object;)V
    //   54: aload_2
    //   55: ldc 111
    //   57: getstatic 110	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   60: invokevirtual 87	org/apache/axis/client/Call:setProperty	(Ljava/lang/String;Ljava/lang/Object;)V
    //   63: aload_2
    //   64: getstatic 112	org/apache/axis/soap/SOAPConstants:SOAP11_CONSTANTS	Lorg/apache/axis/soap/SOAP11Constants;
    //   67: invokevirtual 113	org/apache/axis/client/Call:setSOAPVersion	(Lorg/apache/axis/soap/SOAPConstants;)V
    //   70: aload_2
    //   71: new 6	javax/xml/namespace/QName
    //   74: dup
    //   75: ldc 7
    //   77: ldc 3
    //   79: invokespecial 9	javax/xml/namespace/QName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: invokevirtual 114	org/apache/axis/client/Call:setOperationName	(Ljavax/xml/namespace/QName;)V
    //   85: aload_0
    //   86: aload_2
    //   87: invokevirtual 115	com/zte/web/service/esp/QueryPortalCommonServiceSOAPStub:setRequestHeaders	(Lorg/apache/axis/client/Call;)V
    //   90: aload_0
    //   91: aload_2
    //   92: invokevirtual 116	com/zte/web/service/esp/QueryPortalCommonServiceSOAPStub:setAttachments	(Lorg/apache/axis/client/Call;)V
    //   95: aload_2
    //   96: iconst_1
    //   97: anewarray 117	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_1
    //   103: aastore
    //   104: invokevirtual 118	org/apache/axis/client/Call:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   107: astore_3
    //   108: aload_3
    //   109: instanceof 119
    //   112: ifeq +8 -> 120
    //   115: aload_3
    //   116: checkcast 119	java/rmi/RemoteException
    //   119: athrow
    //   120: aload_0
    //   121: aload_2
    //   122: invokevirtual 120	com/zte/web/service/esp/QueryPortalCommonServiceSOAPStub:extractAttachments	(Lorg/apache/axis/client/Call;)V
    //   125: aload_3
    //   126: checkcast 16	com/zte/web/service/esp/OutputType
    //   129: areturn
    //   130: astore 4
    //   132: aload_3
    //   133: ldc_w 16
    //   136: invokestatic 122	org/apache/axis/utils/JavaUtils:convert	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   139: checkcast 16	com/zte/web/service/esp/OutputType
    //   142: areturn
    //   143: astore_3
    //   144: aload_3
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	QueryPortalCommonServiceSOAPStub
    //   0	146	1	paramInputType	InputType
    //   19	103	2	localCall	Call
    //   107	26	3	localObject	Object
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
 * Qualified Name:     com.zte.web.service.esp.QueryPortalCommonServiceSOAPStub
 * JD-Core Version:    0.7.0.1
 */