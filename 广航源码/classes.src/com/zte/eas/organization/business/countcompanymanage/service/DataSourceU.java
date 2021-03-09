package com.zte.eas.organization.business.countcompanymanage.service;

public class DataSourceU
{
  static final String ZH = "zh";
  static final String EN = "en";
  static final String TH = "th";
  static final String JA = "ja";
  
  public static String getLang(String paramString)
  {
    String str = "ZHS";
    if ("zh".equals(paramString)) {
      str = "ZHS";
    } else if ("en".equals(paramString)) {
      str = "US";
    } else if ("th".equals(paramString)) {
      str = "TH";
    } else if ("ja".equals(paramString)) {
      str = "JA";
    }
    return str;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.organization.business.countcompanymanage.service.DataSourceU
 * JD-Core Version:    0.7.0.1
 */