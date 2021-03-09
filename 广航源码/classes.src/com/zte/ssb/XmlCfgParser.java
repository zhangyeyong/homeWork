package com.zte.ssb;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlCfgParser
{
  Log log = LogFactory.getLog(getClass());
  private Map<String, String> cfgMap = null;
  private String xmlFileName;
  
  public XmlCfgParser(String paramString)
  {
    this.xmlFileName = paramString;
  }
  
  public String getValue(String paramString)
  {
    if (this.cfgMap == null) {
      initCfgMap();
    }
    return (String)this.cfgMap.get(paramString);
  }
  
  private synchronized void initCfgMap()
  {
    if (this.cfgMap != null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    InputStream localInputStream = getClass().getClassLoader().getResourceAsStream(this.xmlFileName);
    if (localInputStream == null)
    {
      this.cfgMap = localHashMap;
      this.log.error("** Fail to initCfgMap(): File \"" + this.xmlFileName + "\" not exists!");
      return;
    }
    try
    {
      try
      {
        SAXReader localSAXReader = new SAXReader();
        Document localDocument = localSAXReader.read(localInputStream);
        Element localElement1 = localDocument.getRootElement();
        Iterator localIterator = localElement1.elements().iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = localIterator.next();
          Element localElement2 = (Element)localObject1;
          String str1 = localElement2.getName();
          String str2 = localElement2.getText();
          localHashMap.put(str1, str2);
        }
      }
      finally
      {
        localInputStream.close();
      }
    }
    catch (Exception localException)
    {
      this.log.error("** Fail to initCfgMap():" + localException.getMessage(), localException);
    }
    this.cfgMap = localHashMap;
  }
  
  public String getXmlFileName()
  {
    return this.xmlFileName;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.ssb.XmlCfgParser
 * JD-Core Version:    0.7.0.1
 */