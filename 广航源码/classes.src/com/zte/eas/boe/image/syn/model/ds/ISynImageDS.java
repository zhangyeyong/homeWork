package com.zte.eas.boe.image.syn.model.ds;

import com.cmcc.mss.importsrvresponse.ImportSrvResponse;
import com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv.SBEASEASImportImageOperationInfoSrvRequest;

public abstract interface ISynImageDS
{
  public abstract ImportSrvResponse synImage(SBEASEASImportImageOperationInfoSrvRequest paramSBEASEASImportImageOperationInfoSrvRequest);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.boe.image.syn.model.ds.ISynImageDS
 * JD-Core Version:    0.7.0.1
 */