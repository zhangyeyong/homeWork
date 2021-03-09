package com.zte.evs.ebill.common.invoice.util;

import com.sun.media.jai.codec.JPEGEncodeParam;
import com.sun.media.jai.codec.TIFFEncodeParam;
import com.sun.media.jai.codec.TIFFField;
import com.sun.media.jai.codecimpl.JPEGImageEncoder;
import com.sun.media.jai.codecimpl.TIFFImageEncoder;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TiffImage
{
  public void createTiffImageFromBuffer(RenderedImage paramRenderedImage, String paramString, int paramInt)
  {
    try
    {
      if (paramRenderedImage != null)
      {
        TIFFEncodeParam localTIFFEncodeParam = new TIFFEncodeParam();
        localTIFFEncodeParam.setCompression(32773);
        TIFFField[] arrayOfTIFFField = new TIFFField[2];
        arrayOfTIFFField[0] = new TIFFField(282, 5, 1, new long[][] { { paramInt, 1L }, { 0L, 0L } });
        arrayOfTIFFField[1] = new TIFFField(283, 5, 1, new long[][] { { paramInt, 1L }, { 0L, 0L } });
        localTIFFEncodeParam.setExtraFields(arrayOfTIFFField);
        File localFile = new File(paramString);
        localFile.createNewFile();
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        TIFFImageEncoder localTIFFImageEncoder = new TIFFImageEncoder(localFileOutputStream, localTIFFEncodeParam);
        localTIFFImageEncoder.encode(paramRenderedImage);
        localFileOutputStream.close();
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void createTiffImageFromBuffer(RenderedImage paramRenderedImage, OutputStream paramOutputStream, int paramInt)
  {
    try
    {
      if (paramRenderedImage != null)
      {
        TIFFEncodeParam localTIFFEncodeParam = new TIFFEncodeParam();
        localTIFFEncodeParam.setCompression(32773);
        TIFFField[] arrayOfTIFFField = new TIFFField[2];
        arrayOfTIFFField[0] = new TIFFField(282, 5, 1, new long[][] { { paramInt, 1L }, { 0L, 0L } });
        arrayOfTIFFField[1] = new TIFFField(283, 5, 1, new long[][] { { paramInt, 1L }, { 0L, 0L } });
        localTIFFEncodeParam.setExtraFields(arrayOfTIFFField);
        TIFFImageEncoder localTIFFImageEncoder = new TIFFImageEncoder(paramOutputStream, localTIFFEncodeParam);
        localTIFFImageEncoder.encode(paramRenderedImage);
        paramOutputStream.close();
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void createJPGImageFromBuffer(RenderedImage paramRenderedImage, String paramString, int paramInt)
  {
    try
    {
      if (paramRenderedImage != null)
      {
        JPEGEncodeParam localJPEGEncodeParam = new JPEGEncodeParam();
        File localFile = new File(paramString);
        localFile.createNewFile();
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        JPEGImageEncoder localJPEGImageEncoder = new JPEGImageEncoder(localFileOutputStream, localJPEGEncodeParam);
        localJPEGImageEncoder.encode(paramRenderedImage);
        localFileOutputStream.close();
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void createJPGImageFromBuffer(RenderedImage paramRenderedImage, OutputStream paramOutputStream, int paramInt)
  {
    try
    {
      if (paramRenderedImage != null)
      {
        JPEGEncodeParam localJPEGEncodeParam = new JPEGEncodeParam();
        JPEGImageEncoder localJPEGImageEncoder = new JPEGImageEncoder(paramOutputStream, localJPEGEncodeParam);
        localJPEGImageEncoder.encode(paramRenderedImage);
        paramOutputStream.close();
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static void main(String[] paramArrayOfString) {}
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.invoice.util.TiffImage
 * JD-Core Version:    0.7.0.1
 */