package com.zte.eas.appframe.importmis.gl;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface GL_ImportGLInvoiceSrv_PortType
  extends Remote
{
  public abstract GL_ImportGLInvoiceSrvProcessResponse process(GL_ImportGLInvoiceSrvProcessRequest paramGL_ImportGLInvoiceSrvProcessRequest)
    throws RemoteException;
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.gl.GL_ImportGLInvoiceSrv_PortType
 * JD-Core Version:    0.7.0.1
 */