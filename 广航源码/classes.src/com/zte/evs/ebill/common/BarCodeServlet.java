package com.zte.evs.ebill.common;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;

public class BarCodeServlet
  extends HttpServlet
{
  public static final int BLACK = -16777216;
  public static final int WHITE = -1;
  private static final int WIDTH = 70;
  private static final int HIGHT = 70;
  private static final String TYPE = "brcode";
  
  protected void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    QRCodeWriter localQRCodeWriter = new QRCodeWriter();
    String str1 = paramHttpServletRequest.getParameter("code");
    if (StringUtils.isBlank(str1)) {
      str1 = "123456";
    }
    String str2 = paramHttpServletRequest.getParameter("type");
    try
    {
      BufferedImage localBufferedImage;
      int i;
      int j;
      if ("brcode".equals(str2))
      {
        localBufferedImage = new BarCodeImage().buildCodeBarImg(str1, 1, 50, 0, 17);
        try
        {
          Graphics2D localGraphics2D = localBufferedImage.createGraphics();
          localGraphics2D.setBackground(Color.WHITE);
          localGraphics2D.setColor(Color.black);
          localGraphics2D.setFont(new Font("Serif", 0, 12));
          i = (localBufferedImage.getWidth() - str1.getBytes().length * 7) / 2;
          j = localBufferedImage.getHeight() - 2;
          localGraphics2D.drawString(str1, i, j);
          localGraphics2D.dispose();
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
      else
      {
        localBufferedImage = new BufferedImage(70, 70, 1);
        BitMatrix localBitMatrix = localQRCodeWriter.encode(str1, BarcodeFormat.QR_CODE, 70, 70);
        for (i = 0; i < 70; i++) {
          for (j = 0; j < 70; j++) {
            localBufferedImage.setRGB(i, j, localBitMatrix.get(i, j) == true ? -16777216 : -1);
          }
        }
      }
      ImageIO.write(localBufferedImage, "JPEG", paramHttpServletResponse.getOutputStream());
      paramHttpServletResponse.getOutputStream().flush();
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.evs.ebill.common.BarCodeServlet
 * JD-Core Version:    0.7.0.1
 */