package com.zte.ssb.log;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import org.apache.log4j.RollingFileAppender;

public class ZTEAppender
  extends RollingFileAppender
{
  public static final String KEY_ZTE_LOG_DIR = "zte_log.dir";
  private static final ZteStdOut newConsoleOut = new ZteStdOut();
  private static String _ZTELogDir = null;
  
  public ZTEAppender()
  {
    System.setProperty("zte_log.dir", getZTELogDir());
  }
  
  public static String getZTELogDir()
  {
    if (_ZTELogDir == null) {
      parseZTELogDir();
    }
    return _ZTELogDir;
  }
  
  private static synchronized void parseZTELogDir()
  {
    if (_ZTELogDir != null) {
      return;
    }
    String str1 = ZTEAppender.class.getCanonicalName().replaceAll("\\.", "/") + ".class";
    URL localURL = ZTEAppender.class.getClassLoader().getResource(str1);
    if (localURL != null)
    {
      String str2 = URLDecoder.decode(localURL.getFile());
      File localFile1 = new File(str2.substring(0, str2.lastIndexOf(str1)));
      File localFile2 = localFile1.getParentFile();
      if (localFile2 != null)
      {
        localFile2 = localFile2.getParentFile();
        if (localFile2 != null)
        {
          localFile1 = new File(localFile2, "logFiles");
          localFile1.mkdirs();
          _ZTELogDir = localFile1.getAbsolutePath();
        }
      }
    }
  }
  
  static
  {
    System.setErr(newConsoleOut);
    System.setOut(newConsoleOut);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.ssb.log.ZTEAppender
 * JD-Core Version:    0.7.0.1
 */