package com.zte.eas.appframe.importmis.gl;

import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface GL_ImportGLInvoiceSrv_Service
  extends Service
{
  public abstract GL_ImportGLInvoiceSrv_PortType getGL_ImportGLInvoiceSrvPort()
    throws ServiceException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.gl.GL_ImportGLInvoiceSrv_Service
 * JD-Core Version:    0.7.0.1
 */