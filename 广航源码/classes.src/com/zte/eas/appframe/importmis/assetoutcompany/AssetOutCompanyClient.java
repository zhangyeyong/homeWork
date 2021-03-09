package com.zte.eas.appframe.importmis.assetoutcompany;

import java.util.Iterator;
import java.util.List;

public class AssetOutCompanyClient
{
  public static String runAssetClient(List<String> paramList, String paramString)
  {
    String str1 = "SUCCESS";
    String str2 = "";
    try
    {
      FI_FA_ImportAssetTransferIntercompanysSrvPortClient localFI_FA_ImportAssetTransferIntercompanysSrvPortClient = new FI_FA_ImportAssetTransferIntercompanysSrvPortClient();
      FI_FA_ImportAssetTransferIntercompanysSrvProcessRequest localFI_FA_ImportAssetTransferIntercompanysSrvProcessRequest = new FI_FA_ImportAssetTransferIntercompanysSrvProcessRequest();
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
      localFI_FA_ImportAssetTransferIntercompanysSrvProcessRequest.setLineIds((LineIDCollection)localObject);
      localFI_FA_ImportAssetTransferIntercompanysSrvProcessRequest.setEmployeeNumber(paramString);
      str2 = localFI_FA_ImportAssetTransferIntercompanysSrvPortClient.process(localFI_FA_ImportAssetTransferIntercompanysSrvProcessRequest).getErrorFlag();
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
 * Qualified Name:     com.zte.eas.appframe.importmis.assetoutcompany.AssetOutCompanyClient
 * JD-Core Version:    0.7.0.1
 */