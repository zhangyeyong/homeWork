package com.zte.eas.appframe.business.budgets;

public abstract interface IBudgetDS
{
  public abstract int syncBudgetList(String paramString);
  
  public abstract int syncBudgetItem(String paramString);
  
  public abstract int expenseDeduct(String paramString);
  
  public abstract int expenseReserve(String paramString);
  
  public abstract int expenseRollback(String paramString);
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.business.budgets.IBudgetDS
 * JD-Core Version:    0.7.0.1
 */