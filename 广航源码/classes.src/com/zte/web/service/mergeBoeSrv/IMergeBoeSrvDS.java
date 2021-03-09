package com.zte.web.service.mergeBoeSrv;

import com.zte.web.service.mergeBoeSrv.service.MergeBoeRequest;
import com.zte.web.service.mergeBoeSrv.service.MergeBoeResponse;

public abstract interface IMergeBoeSrvDS
{
  public abstract MergeBoeResponse createMergeBoeRelation(MergeBoeRequest paramMergeBoeRequest);
  
  public abstract MergeBoeResponse calcelMergeBoeRelation(MergeBoeRequest paramMergeBoeRequest);
  
  public abstract MergeBoeResponse saveMergeBoeSrv(MergeBoeRequest paramMergeBoeRequest);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.web.service.mergeBoeSrv.IMergeBoeSrvDS
 * JD-Core Version:    0.7.0.1
 */