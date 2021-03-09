package com.cmcc.mss.nc_itf_guanghj_service;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface IHrService
  extends Service
{
  public abstract String getIHrServiceSOAP11port_httpAddress();
  
  public abstract IHrServicePortType getIHrServiceSOAP11port_http()
    throws ServiceException;
  
  public abstract IHrServicePortType getIHrServiceSOAP11port_http(URL paramURL)
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.nc_itf_guanghj_service.IHrService
 * JD-Core Version:    0.7.0.1
 */