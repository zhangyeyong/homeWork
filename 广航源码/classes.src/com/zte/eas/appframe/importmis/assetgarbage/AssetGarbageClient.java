package com.zte.eas.appframe.importmis.assetgarbage;

import java.util.Iterator;
import java.util.List;

public class AssetGarbageClient
{
  public static String runAssetClient(List<String> paramList, String paramString)
  {
    String str1 = "SUCCESS";
    String str2 = "";
    try
    {
      FI_FA_ImportAssetRetirmentSrvPortClient localFI_FA_ImportAssetRetirmentSrvPortClient = new FI_FA_ImportAssetRetirmentSrvPortClient();
      FI_FA_ImportAssetRetirmentSrvProcessRequest localFI_FA_ImportAssetRetirmentSrvProcessRequest = new FI_FA_ImportAssetRetirmentSrvProcessRequest();
      LineIDItem[] arrayOfLineIDItem = new LineIDItem[paramList.size()];
      int i = 0;
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str3 = (String)((Iterator)localObject).next();
        arrayOfLineIDItem[i] = new LineIDItem();
        arrayOfLineIDItem[i].setLineID(str3);
        i++;
      }
      localObject = new LineIDCollection();
      ((LineIDCollection)localObject).setLineIDItem(arrayOfLineIDItem);
      localFI_FA_ImportAssetRetirmentSrvProcessRequest.setLineIds((LineIDCollection)localObject);
      localFI_FA_ImportAssetRetirmentSrvProcessRequest.setEmployeeNumber(paramString);
      str2 = localFI_FA_ImportAssetRetirmentSrvPortClient.process(localFI_FA_ImportAssetRetirmentSrvProcessRequest).getErrorFlag();
      if (str2.equals("N")) {
        str1 = "FAILD";
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str1 = "FAILD";
    }
    return str1;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.appframe.importmis.assetgarbage.AssetGarbageClient
 * JD-Core Version:    0.7.0.1
 */