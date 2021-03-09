package com.zte.eas.appframe.importmis.assetincompany;

import java.util.Iterator;
import java.util.List;

public class AssetInCompanyClient
{
  public static String runAssetClient(List<String> paramList, String paramString)
  {
    String str1 = "SUCCESS";
    String str2 = "";
    try
    {
      FI_FA_ImportAssetTransferInCompanySrvPortClient localFI_FA_ImportAssetTransferInCompanySrvPortClient = new FI_FA_ImportAssetTransferInCompanySrvPortClient();
      FI_FA_ImportAssetTransferInCompanySrvProcessRequest localFI_FA_ImportAssetTransferInCompanySrvProcessRequest = new FI_FA_ImportAssetTransferInCompanySrvProcessRequest();
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
      localFI_FA_ImportAssetTransferInCompanySrvProcessRequest.setLineIds((LineIDCollection)localObject);
      localFI_FA_ImportAssetTransferInCompanySrvProcessRequest.setEmployeeNumber(paramString);
      str2 = localFI_FA_ImportAssetTransferInCompanySrvPortClient.process(localFI_FA_ImportAssetTransferInCompanySrvProcessRequest).getErrorFlag();
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
 * Qualified Name:     com.zte.eas.appframe.importmis.assetincompany.AssetInCompanyClient
 * JD-Core Version:    0.7.0.1
 */