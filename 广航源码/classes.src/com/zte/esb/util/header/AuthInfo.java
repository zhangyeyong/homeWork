package com.zte.esb.util.header;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="AuthInfo", propOrder={"username", "password"})
public class AuthInfo
{
  protected String username;
  protected String password;
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setUsername(String paramString)
  {
    this.username = paramString;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.esb.util.header.AuthInfo
 * JD-Core Version:    0.7.0.1
 */