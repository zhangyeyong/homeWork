package com.zte.evs.ebill.common.invoice.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import javax.imageio.ImageIO;
import org.apache.log4j.Logger;

public class ImageBuffer
{
  private int startX = 0;
  private int startY = 0;
  private boolean tag = false;
  private int charHeight = 0;
  private BufferedImage bufImg;
  private Font font = null;
  private Graphics2D g = null;
  private int fontsize = 26;
  private int writeX = 0;
  private int writeY = 0;
  private Logger log = Logger.getLogger(getClass());
  
  public ImageBuffer() {}
  
  public ImageBuffer(int paramInt1, int paramInt2, Font paramFont, boolean paramBoolean)
  {
    this.writeX = paramInt1;
    this.writeY = paramInt2;
    this.font = paramFont;
    this.tag = paramBoolean;
  }
  
  public void toArray(String paramString)
  {
    if (this.tag) {
      this.bufImg = pressImage(this.bufImg, paramString, this.writeX, this.writeY);
    } else {
      this.bufImg = modifyImage(this.bufImg, paramString, this.writeX, this.writeY);
    }
  }
  
  public BufferedImage pressImage(BufferedImage paramBufferedImage, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString != null) && (paramBufferedImage != null)) {
      try
      {
        File localFile = new File(paramString);
        BufferedImage localBufferedImage = ImageIO.read(localFile);
        int i = localBufferedImage.getWidth();
        int j = localBufferedImage.getHeight();
        for (int k = 0; k < i; k++) {
          for (int m = 0; m < j; m++)
          {
            int n = localBufferedImage.getRGB(k, m);
            if (n != -1)
            {
              paramBufferedImage.setRGB(k + paramInt1, m + paramInt2, n);
              paramBufferedImage.setRGB(k + 1 + paramInt1, m + 1 + paramInt2, n);
            }
          }
        }
      }
      catch (IOException localIOException)
      {
        this.log.error("输入的参数为" + paramBufferedImage + "----" + paramString, localIOException);
        System.out.println(localIOException.getMessage());
      }
    }
    return paramBufferedImage;
  }
  
  public static void markImageByIcon(BufferedImage paramBufferedImage1, BufferedImage paramBufferedImage2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FileOutputStream localFileOutputStream = null;
    Object localObject1 = null;
    try
    {
      localFileOutputStream = new FileOutputStream("F:/zj/project/EBILL_HAIER/EAS_CJ000_ShareLib/apps/WebContent/common/template/1.gif");
      ImageIO.write(paramBufferedImage1, "JPG", localFileOutputStream);
      localFileOutputStream = new FileOutputStream("F:/zj/project/EBILL_HAIER/EAS_CJ000_ShareLib/apps/WebContent/common/template/2.gif");
      ImageIO.write(paramBufferedImage2, "JPG", localFileOutputStream);
      System.out.println("图片完成添加Icon印章。。。。。。");
      return;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    finally
    {
      try
      {
        if (null != localFileOutputStream) {
          localFileOutputStream.close();
        }
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
      }
    }
  }
  
  public BufferedImage pressImage(BufferedImage paramBufferedImage1, BufferedImage paramBufferedImage2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramBufferedImage2.getWidth();
    int j = paramBufferedImage2.getHeight();
    if (i > paramInt3)
    {
      paramInt1 -= i - paramInt3;
      paramInt1 = paramInt1 > 0 ? paramInt1 : 0;
    }
    for (int k = 0; k < i; k++) {
      for (int m = 0; m < j; m++)
      {
        int n = paramBufferedImage2.getRGB(k, m);
        if (n != -1)
        {
          paramBufferedImage1.setRGB(k + paramInt1, m + paramInt2, n);
          paramBufferedImage1.setRGB(k + 1 + paramInt1, m + 1 + paramInt2, n);
        }
      }
    }
    return paramBufferedImage1;
  }
  
  public BufferedImage pressImageNew(BufferedImage paramBufferedImage1, BufferedImage paramBufferedImage2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      BufferedImage localBufferedImage1 = paramBufferedImage1;
      int i = localBufferedImage1.getWidth(null);
      int j = localBufferedImage1.getHeight(null);
      BufferedImage localBufferedImage2 = new BufferedImage(i, j, 1);
      Graphics2D localGraphics2D = localBufferedImage2.createGraphics();
      localGraphics2D.drawImage(localBufferedImage1, 0, 0, i, j, null);
      BufferedImage localBufferedImage3 = paramBufferedImage2;
      int k = localBufferedImage3.getWidth(null);
      int m = localBufferedImage3.getHeight(null);
      localGraphics2D.drawImage(localBufferedImage3, paramInt1, paramInt2, k, m, null);
      localGraphics2D.dispose();
      return localBufferedImage2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public BufferedImage pressTable(BufferedImage paramBufferedImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    BufferedImage localBufferedImage = paramBufferedImage;
    localBufferedImage = pressLine(localBufferedImage, paramInt1, paramInt2, paramInt3 - paramInt1, paramInt5);
    localBufferedImage = pressLine(localBufferedImage, paramInt1, paramInt4, paramInt3 - paramInt1, paramInt5);
    localBufferedImage = pressLine(localBufferedImage, paramInt3, paramInt2, paramInt5, paramInt4 - paramInt2 + paramInt5);
    localBufferedImage = pressLine(localBufferedImage, paramInt1, paramInt2, paramInt5, paramInt4 - paramInt2);
    return localBufferedImage;
  }
  
  public BufferedImage pressLine(BufferedImage paramBufferedImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    for (int i = 0; i < paramInt3; i++) {
      for (int j = 0; j < paramInt4; j++) {
        paramBufferedImage.setRGB(i + paramInt1, j + paramInt2, 0);
      }
    }
    return paramBufferedImage;
  }
  
  public void writeImg(Object[] paramArrayOfObject)
  {
    String str1 = "D:/www/struts.gif";
    String str2 = "D:/www/struts_new.gif";
    setFont("", this.charHeight);
    BufferedImage localBufferedImage = loadImageLocal(str1);
    this.writeX = this.startX;
    this.writeY = this.startY;
    modifyImage(localBufferedImage, paramArrayOfObject, this.writeX, this.writeY, false);
    writeImageLocal(str2, localBufferedImage);
    System.out.println("起点坐标 X.Y = " + this.writeX + " * " + this.writeY);
  }
  
  public void writeImg(String paramString)
  {
    String str1 = "";
    String str2 = "D:/www/struts_new.gif";
    this.bufImg = loadImageLocal(str1);
    modifyImage(this.bufImg, paramString, this.writeX, this.writeY);
    writeImageLocal(str2, this.bufImg);
    System.out.println("起点坐标 X.Y = " + this.writeX + " * " + this.writeY);
  }
  
  public BufferedImage loadImageLocal(String paramString)
  {
    try
    {
      return ImageIO.read(new File(paramString));
    }
    catch (IOException localIOException)
    {
      System.out.println(localIOException.getMessage());
    }
    return null;
  }
  
  public BufferedImage loadImageUrl(String paramString)
  {
    try
    {
      URL localURL = new URL(paramString);
      return ImageIO.read(localURL);
    }
    catch (IOException localIOException)
    {
      System.out.println(localIOException.getMessage());
    }
    return null;
  }
  
  public void writeImageLocal(String paramString, BufferedImage paramBufferedImage)
  {
    if ((paramString != null) && (paramBufferedImage != null)) {
      try
      {
        File localFile = new File(paramString);
        ImageIO.write(paramBufferedImage, "gif", localFile);
      }
      catch (IOException localIOException)
      {
        System.out.println(localIOException.getMessage());
      }
    }
  }
  
  public String writeImageOutputStream(BufferedImage paramBufferedImage)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      ImageIO.write(paramBufferedImage, "gif", localByteArrayOutputStream);
      localByteArrayOutputStream.close();
    }
    catch (IOException localIOException)
    {
      System.out.println(localIOException.getMessage());
    }
    return localByteArrayOutputStream.toString();
  }
  
  public void setFont(String paramString, int paramInt)
  {
    this.fontsize = paramInt;
    this.font = new Font(paramString, 0, paramInt);
  }
  
  public BufferedImage modifyImage(BufferedImage paramBufferedImage, Object paramObject, int paramInt1, int paramInt2)
  {
    try
    {
      this.g = paramBufferedImage.createGraphics();
      this.g.setBackground(Color.WHITE);
      this.g.setColor(Color.black);
      if (this.font != null) {
        this.g.setFont(this.font);
      }
      this.writeX = paramInt1;
      this.writeY = paramInt2;
      if (paramObject != null) {
        this.g.drawString(paramObject.toString(), this.writeX, this.writeY);
      }
      this.g.dispose();
    }
    catch (Exception localException)
    {
      System.out.println(localException.getMessage());
    }
    return paramBufferedImage;
  }
  
  public BufferedImage modifyImage(BufferedImage paramBufferedImage, Object[] paramArrayOfObject, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      this.g = paramBufferedImage.createGraphics();
      this.g.setBackground(Color.WHITE);
      this.g.setColor(Color.black);
      if (this.font != null) {
        this.g.setFont(this.font);
      }
      this.writeX = paramInt1;
      this.writeY = paramInt2;
      if (paramArrayOfObject != null)
      {
        int i = paramArrayOfObject.length;
        int j;
        if (paramBoolean) {
          for (j = 0; j < i; j++)
          {
            this.g.drawString(paramArrayOfObject[j].toString(), this.writeX, this.writeY);
            this.writeX += paramArrayOfObject[j].toString().length() * this.fontsize / 2 + 5;
          }
        } else {
          for (j = 0; j < i; j++)
          {
            this.g.drawString(paramArrayOfObject[j].toString(), this.writeX, this.writeY);
            this.writeY += this.fontsize + 2;
          }
        }
      }
      this.g.dispose();
    }
    catch (Exception localException)
    {
      System.out.println(localException.getMessage());
    }
    return paramBufferedImage;
  }
  
  public static void main(String[] paramArrayOfString)
    throws IOException
  {}
  
  public BufferedImage getBufImg()
  {
    return this.bufImg;
  }
  
  public void setBufImg(BufferedImage paramBufferedImage)
  {
    this.bufImg = paramBufferedImage;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.invoice.util.ImageBuffer
 * JD-Core Version:    0.7.0.1
 */