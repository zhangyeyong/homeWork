package com.zte.eas.appframe.importmis.assetadd;

import java.util.Iterator;
import java.util.List;

public class AssetAddClient
{
  public static String runAssetClient(List<String> paramList, String paramString)
  {
    String str1 = "SUCCESS";
    String str2 = "";
    try
    {
      FI_FA_ImportAssetMassAddtionSrvPortClient localFI_FA_ImportAssetMassAddtionSrvPortClient = new FI_FA_ImportAssetMassAddtionSrvPortClient();
      FI_FA_ImportAssetMassAddtionSrvProcessRequest localFI_FA_ImportAssetMassAddtionSrvProcessRequest = new FI_FA_ImportAssetMassAddtionSrvProcessRequest();
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
      localFI_FA_ImportAssetMassAddtionSrvProcessRequest.setLineIds((LineIDCollection)localObject);
      localFI_FA_ImportAssetMassAddtionSrvProcessRequest.setEmployeeNumber(paramString);
      str2 = localFI_FA_ImportAssetMassAddtionSrvPortClient.process(localFI_FA_ImportAssetMassAddtionSrvProcessRequest).getErrorFlag();
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
 * Qualified Name:     com.zte.eas.appframe.importmis.assetadd.AssetAddClient
 * JD-Core Version:    0.7.0.1
 */