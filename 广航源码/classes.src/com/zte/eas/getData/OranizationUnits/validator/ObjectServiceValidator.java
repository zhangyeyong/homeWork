package com.zte.eas.getData.OranizationUnits.validator;

import com.zte.eas.getData.OranizationUnits.model.Message;

public abstract interface ObjectServiceValidator<O, I>
{
  public abstract Message validator(I paramI);
  
  public abstract Message[] validatorList(I[] paramArrayOfI);
  
  public abstract O saveOrUpdate(I paramI);
  
  public abstract O[] saveOrUpdateList(I[] paramArrayOfI);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.validator.ObjectServiceValidator
 * JD-Core Version:    0.7.0.1
 */