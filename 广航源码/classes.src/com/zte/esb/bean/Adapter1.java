package com.zte.esb.bean;

import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
  extends XmlAdapter<String, Date>
{
  public Date unmarshal(String paramString)
  {
    return DataTypeAdapter.parseDateTime(paramString);
  }
  
  public String marshal(Date paramDate)
  {
    return DataTypeAdapter.printDateTime(paramDate);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.bean.Adapter1
 * JD-Core Version:    0.7.0.1
 */