package com.zte.evs.ebill.common;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

public class BarCodeImage
{
  private int barWidth;
  private int barHeight;
  private int left;
  private int top;
  
  private void buildImg(String paramString, Graphics paramGraphics)
  {
    for (int i = 0; i < paramString.length(); i++)
    {
      int j = paramString.charAt(i);
      if (j == 49) {
        paint(paramGraphics, Color.black, this.left);
      } else {
        paint(paramGraphics, Color.white, this.left);
      }
      this.left += this.barWidth;
    }
  }
  
  private void paint(Graphics paramGraphics, Color paramColor, int paramInt)
  {
    paramGraphics.setColor(paramColor);
    paramGraphics.fillRect(paramInt, this.top, this.barWidth, this.barHeight);
  }
  
  public BufferedImage buildCodeBarImg(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BufferedImage localBufferedImage = null;
    Graphics localGraphics = null;
    try
    {
      boolean bool = checkParameter(paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      if (bool)
      {
        BarCode128 localBarCode128 = new BarCode128();
        String str = localBarCode128.getLogicalBarCode(paramString);
        int i = str.length() * paramInt1 + 2 * paramInt3;
        int j = paramInt2 + 2 * paramInt4;
        localBufferedImage = new BufferedImage(i, j, 1);
        localGraphics = localBufferedImage.getGraphics();
        localGraphics.setColor(Color.white);
        localGraphics.fillRect(0, 0, i, j);
        buildImg(str, localGraphics);
      }
      else
      {
        localBufferedImage = new BufferedImage(200, 100, 1);
        localGraphics = localBufferedImage.getGraphics();
        localGraphics.setColor(Color.white);
        localGraphics.drawString("创建条码图失败!", 20, 80);
      }
    }
    catch (Exception localException)
    {
      localBufferedImage = new BufferedImage(200, 100, 1);
      localGraphics = localBufferedImage.getGraphics();
      localGraphics.setColor(Color.white);
      localGraphics.drawString("创建条码图失败!", 20, 80);
      localException.printStackTrace();
    }
    return localBufferedImage;
  }
  
  public BufferedImage buildDataMaxImg(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BufferedImage localBufferedImage = null;
    Graphics localGraphics = null;
    try
    {
      boolean bool = checkParameter(paramString, paramInt1, paramInt2, paramInt3, paramInt4);
      if (bool)
      {
        localBufferedImage = new BufferedImage(paramInt1, paramInt2, 1);
        BitMatrix localBitMatrix = new QRCodeWriter().encode(paramString, BarcodeFormat.QR_CODE, paramInt1, paramInt2);
        for (int i = 0; i < paramInt1; i++) {
          for (int j = 0; j < paramInt2; j++) {
            localBufferedImage.setRGB(i, j, localBitMatrix.get(i, j) == true ? -16777216 : -1);
          }
        }
      }
      else
      {
        localBufferedImage = new BufferedImage(200, 100, 1);
        localGraphics = localBufferedImage.getGraphics();
        localGraphics.setColor(Color.white);
        localGraphics.drawString("创建二维码图失败!", 20, 80);
      }
    }
    catch (Exception localException)
    {
      localBufferedImage = new BufferedImage(200, 100, 1);
      localGraphics = localBufferedImage.getGraphics();
      localGraphics.setColor(Color.white);
      localGraphics.drawString("创建二维码图失败!", 20, 80);
      localException.printStackTrace();
    }
    return localBufferedImage;
  }
  
  private boolean checkParameter(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    try
    {
      this.barWidth = paramInt1;
      this.barHeight = paramInt2;
      this.left = paramInt3;
      this.top = paramInt4;
      if ((paramString == null) || (paramString.length() <= 0))
      {
        bool = false;
        throw new Exception("条码字符串不能为空!");
      }
      if (paramInt1 <= 0)
      {
        bool = false;
        throw new Exception("条码线宽度不能小于等于0!");
      }
      if (paramInt2 <= 0)
      {
        bool = false;
        throw new Exception("条码线高度不能小于等于0!");
      }
      if (paramInt3 < 0)
      {
        bool = false;
        throw new Exception("条码线左边距不能小于0!");
      }
      if (paramInt4 < 0)
      {
        bool = false;
        throw new Exception("条码线顶边距不能小于0!");
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return bool;
  }
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    BarCodeImage localBarCodeImage = new BarCodeImage();
    BufferedImage localBufferedImage = localBarCodeImage.buildCodeBarImg("fdsafsd", 2, 100, 0, 0);
    JPEGCodec.createJPEGEncoder(new FileOutputStream("C:/jamie7.jpg")).encode(localBufferedImage);
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.BarCodeImage
 * JD-Core Version:    0.7.0.1
 */