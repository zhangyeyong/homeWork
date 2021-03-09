package com.zte.evs.ebill.common;

import java.util.Comparator;

public class ContentComparator
  implements Comparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    Content localContent1 = (Content)paramObject1;
    Content localContent2 = (Content)paramObject2;
    if (localContent1.getKey() > localContent2.getKey()) {
      return 1;
    }
    if (localContent1.getKey() == localContent2.getKey()) {
      return 0;
    }
    return -1;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.ContentComparator
 * JD-Core Version:    0.7.0.1
 */