package com.zte.ssb.log;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Formatter;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ZteStdOut
  extends PrintStream
{
  static Log log = LogFactory.getLog(ZteStdOut.class);
  private Formatter formatter;
  
  private ZteStdOut(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public ZteStdOut()
  {
    this(new ByteArrayOutputStream());
  }
  
  public void write(int paramInt) {}
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  private void write(char[] paramArrayOfChar) {}
  
  private void write(String paramString) {}
  
  private void newLine()
  {
    write("\n");
  }
  
  public void print(boolean paramBoolean)
  {
    write(paramBoolean ? "true" : "false");
  }
  
  public void print(char paramChar)
  {
    write(String.valueOf(paramChar));
  }
  
  public void print(int paramInt)
  {
    write(String.valueOf(paramInt));
  }
  
  public void print(long paramLong)
  {
    write(String.valueOf(paramLong));
  }
  
  public void print(float paramFloat)
  {
    write(String.valueOf(paramFloat));
  }
  
  public void print(double paramDouble)
  {
    write(String.valueOf(paramDouble));
  }
  
  public void print(char[] paramArrayOfChar)
  {
    write(paramArrayOfChar);
  }
  
  public void print(String paramString)
  {
    if (paramString == null) {
      paramString = "null";
    }
    write(paramString);
  }
  
  public void print(Object paramObject)
  {
    write(String.valueOf(paramObject));
  }
  
  public void println()
  {
    newLine();
  }
  
  public void println(boolean paramBoolean)
  {
    synchronized (this)
    {
      print(paramBoolean);
      newLine();
    }
  }
  
  public void println(char paramChar)
  {
    synchronized (this)
    {
      print(paramChar);
      newLine();
    }
  }
  
  public void println(int paramInt)
  {
    synchronized (this)
    {
      print(paramInt);
      newLine();
    }
  }
  
  public void println(long paramLong)
  {
    synchronized (this)
    {
      print(paramLong);
      newLine();
    }
  }
  
  public void println(float paramFloat)
  {
    synchronized (this)
    {
      print(paramFloat);
      newLine();
    }
  }
  
  public void println(double paramDouble)
  {
    synchronized (this)
    {
      print(paramDouble);
      newLine();
    }
  }
  
  public void println(char[] paramArrayOfChar)
  {
    synchronized (this)
    {
      print(paramArrayOfChar);
      newLine();
    }
  }
  
  public void println(String paramString)
  {
    synchronized (this)
    {
      print(paramString);
      newLine();
    }
  }
  
  public void println(Object paramObject)
  {
    synchronized (this)
    {
      print(paramObject);
      newLine();
    }
  }
  
  public PrintStream printf(String paramString, Object... paramVarArgs)
  {
    return format(paramString, paramVarArgs);
  }
  
  public PrintStream printf(Locale paramLocale, String paramString, Object... paramVarArgs)
  {
    return format(paramLocale, paramString, paramVarArgs);
  }
  
  public PrintStream format(String paramString, Object... paramVarArgs)
  {
    try
    {
      synchronized (this)
      {
        if ((this.formatter == null) || (this.formatter.locale() != Locale.getDefault())) {
          this.formatter = new Formatter(this);
        }
        this.formatter.format(Locale.getDefault(), paramString, paramVarArgs);
      }
    }
    catch (Exception localException) {}
    return this;
  }
  
  public PrintStream format(Locale paramLocale, String paramString, Object... paramVarArgs)
  {
    try
    {
      synchronized (this)
      {
        if ((this.formatter == null) || (this.formatter.locale() != paramLocale)) {
          this.formatter = new Formatter(this, paramLocale);
        }
        this.formatter.format(paramLocale, paramString, paramVarArgs);
      }
    }
    catch (Exception localException) {}
    return this;
  }
  
  public PrintStream append(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      print("null");
    } else {
      print(paramCharSequence.toString());
    }
    return this;
  }
  
  public PrintStream append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    CharSequence localCharSequence = paramCharSequence == null ? "null" : paramCharSequence;
    write(localCharSequence.subSequence(paramInt1, paramInt2).toString());
    return this;
  }
  
  public PrintStream append(char paramChar)
  {
    print(paramChar);
    return this;
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.ssb.log.ZteStdOut
 * JD-Core Version:    0.7.0.1
 */