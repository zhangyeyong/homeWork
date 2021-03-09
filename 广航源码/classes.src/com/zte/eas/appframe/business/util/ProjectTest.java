package com.zte.eas.appframe.business.util;

import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.transaction.PlatformTransactionManager;
import com.zte.ssb.transaction.TransactionStatus;
import com.zte.ssb.transaction.support.DefaultTransactionDefinition;
import junit.framework.TestCase;

public class ProjectTest
  extends TestCase
{
  protected PlatformTransactionManager transactionManager;
  protected TransactionStatus transactionStatus;
  
  protected void setUp()
    throws Exception
  {
    this.transactionManager = ((PlatformTransactionManager)SSBBus.findCommonService("transactionManager"));
    this.transactionStatus = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
  }
  
  protected void tearDown()
    throws Exception
  {
    try
    {
      this.transactionManager.commit(this.transactionStatus);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      throw localException;
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.util.ProjectTest
 * JD-Core Version:    0.7.0.1
 */