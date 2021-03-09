package com.zte.eas.appframe.importmis.assetreduice;

import java.util.Iterator;
import java.util.List;

public class AssetReduiceClient
{
  public static String runAssetClient(List<String> paramList, String paramString)
  {
    String str1 = "SUCCESS";
    String str2 = "";
    try
    {
      FI_FA_ImportAssetDevalueSrvPortClient localFI_FA_ImportAssetDevalueSrvPortClient = new FI_FA_ImportAssetDevalueSrvPortClient();
      FI_FA_ImportAssetDevalueSrvProcessRequest localFI_FA_ImportAssetDevalueSrvProcessRequest = new FI_FA_ImportAssetDevalueSrvProcessRequest();
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
      localFI_FA_ImportAssetDevalueSrvProcessRequest.setLineIds((LineIDCollection)localObject);
      localFI_FA_ImportAssetDevalueSrvProcessRequest.setEmployeeNumber(paramString);
      str2 = localFI_FA_ImportAssetDevalueSrvPortClient.process(localFI_FA_ImportAssetDevalueSrvProcessRequest).getErrorFlag();
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
 * Qualified Name:     com.zte.eas.appframe.importmis.assetreduice.AssetReduiceClient
 * JD-Core Version:    0.7.0.1
 */