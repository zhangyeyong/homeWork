package com.zte.eas.getData.OranizationUnits.validator;

import com.zte.eas.getData.OranizationUnits.model.Message;
import com.zte.eas.getData.OranizationUnits.model.OrganizationUnits;
import com.zte.eas.organization.business.organizationmanage.model.FbpDepts;

public abstract interface IOrganizationUnitsServiceValidatorImpl
{
  public abstract Message validator(OrganizationUnits paramOrganizationUnits);
  
  public abstract FbpDepts saveOrUpdate(OrganizationUnits paramOrganizationUnits);
  
  public abstract void updateParentDept(OrganizationUnits[] paramArrayOfOrganizationUnits);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.getData.OranizationUnits.validator.IOrganizationUnitsServiceValidatorImpl
 * JD-Core Version:    0.7.0.1
 */