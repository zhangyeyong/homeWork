package com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv;

import com.cmcc.mss.importsrvresponse.ImportSrvResponse;
import java.io.File;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName;

public final class SBEASEASImportImageOperationInfoSrv_SBEASEASImportImageOperationInfoSrvPort_Client
{
  private static final QName SERVICE_NAME = new QName("http://mss.cmcc.com/SB_EAS_EAS_ImportImageOperationInfoSrv", "SB_EAS_EAS_ImportImageOperationInfoSrv");
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    URL localURL = SBEASEASImportImageOperationInfoSrv_Service.WSDL_LOCATION;
    if (paramArrayOfString.length > 0)
    {
      localObject = new File(paramArrayOfString[0]);
      try
      {
        if (((File)localObject).exists()) {
          localURL = ((File)localObject).toURI().toURL();
        } else {
          localURL = new URL(paramArrayOfString[0]);
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
      }
    }
    Object localObject = new SBEASEASImportImageOperationInfoSrv_Service(localURL, SERVICE_NAME);
    SBEASEASImportImageOperationInfoSrv localSBEASEASImportImageOperationInfoSrv = ((SBEASEASImportImageOperationInfoSrv_Service)localObject).getSBEASEASImportImageOperationInfoSrvPort();
    System.out.println("Invoking process...");
    SBEASEASImportImageOperationInfoSrvRequest localSBEASEASImportImageOperationInfoSrvRequest = null;
    ImportSrvResponse localImportSrvResponse = localSBEASEASImportImageOperationInfoSrv.process(localSBEASEASImportImageOperationInfoSrvRequest);
    System.out.println("process.result=" + localImportSrvResponse);
    System.exit(0);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.cmcc.mss.sb_eas_eas_importimageoperationinfosrv.SBEASEASImportImageOperationInfoSrv_SBEASEASImportImageOperationInfoSrvPort_Client
 * JD-Core Version:    0.7.0.1
 */