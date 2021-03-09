package com.zte.eas.report.business.print.service;

import java.io.PrintStream;

public class BarCode128
{
  static final int END_CODE = 106;
  static final int START_CODE_A = 103;
  static final int START_CODE_B = 104;
  static final int START_CODE_C = 105;
  static final int CODE_A = 101;
  static final int CODE_B = 100;
  static final int CODE_C = 99;
  int START_CODE = 105;
  int checkSum = 105;
  int multiplier = 1;
  String logicalCode = "";
  boolean isBegin = false;
  boolean isEnd = false;
  static boolean isDebug = true;
  private static final String[] BARCODE = { "11011001100", "11001101100", "11001100110", "10010011000", "10010001100", "10001001100", "10011001000", "10011000100", "10001100100", "11001001000", "11001000100", "11000100100", "10110011100", "10011011100", "10011001110", "10111001100", "10011101100", "10011100110", "11001110010", "11001011100", "11001001110", "11011100100", "11001110100", "11101101110", "11101001100", "11100101100", "11100100110", "11101100100", "11100110100", "11100110010", "11011011000", "11011000110", "11000110110", "10100011000", "10001011000", "10001000110", "10110001000", "10001101000", "10001100010", "11010001000", "11000101000", "11000100010", "10110111000", "10110001110", "10001101110", "10111011000", "10111000110", "10001110110", "11101110110", "11010001110", "11000101110", "11011101000", "11011100010", "11011101110", "11101011000", "11101000110", "11100010110", "11101101000", "11101100010", "11100011010", "11101111010", "11001000010", "11110001010", "10100110000", "10100001100", "10010110000", "10010000110", "10000101100", "10000100110", "10110010000", "10110000100", "10011010000", "10011000010", "10000110100", "10000110010", "11000010010", "11001010000", "11110111010", "11000010100", "10001111010", "10100111100", "10010111100", "10010011110", "10111100100", "10011110100", "10011110010", "11110100100", "11110010100", "11110010010", "11011011110", "11011110110", "11110110110", "10101111000", "10100011110", "10001011110", "10111101000", "10111100010", "11110101000", "11110100010", "10111011110", "10111101110", "11101011110", "11110101110", "11010000100", "11010010000", "11010011100", "1100011101011" };
  
  public String getLogicalBarCode(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    String str = "";
    for (int i = 0; i < paramString.length(); i++) {
      if (i > 0)
      {
        if (i == paramString.length() - 1) {
          this.isEnd = true;
        }
        bool2 = isNum(paramString, i);
        if (bool1 == bool2)
        {
          str = str + paramString.substring(i, i + 1);
        }
        else
        {
          dealCodeBarStr(str, bool1);
          str = paramString.substring(i, i + 1);
          bool1 = bool2;
        }
      }
      else if (i == 0)
      {
        this.isBegin = true;
        bool1 = isNum(paramString, 0);
        str = paramString.substring(0, 1);
      }
    }
    if (this.isEnd) {
      dealCodeBarStr(str, bool2);
    }
    i = this.checkSum % 103;
    this.logicalCode += BARCODE[i];
    this.logicalCode = (BARCODE[this.START_CODE] + this.logicalCode + BARCODE[106]);
    return this.logicalCode;
  }
  
  private void dealCodeBarStr(String paramString, boolean paramBoolean)
  {
    debugMsg("dealCodeBarStr dealStr:" + paramString + " isNum:" + paramBoolean);
    int i = paramString.length();
    if ((paramBoolean) && (i >= 4))
    {
      if (i % 2 == 0)
      {
        insertConvertCode(paramBoolean);
        dealCode(paramString, true);
      }
      else
      {
        dealSingularNum(paramString);
      }
    }
    else
    {
      if (this.isBegin)
      {
        this.START_CODE = 104;
        this.checkSum = 104;
        debugMsg("START_CODE 改为:START_CODE_B");
      }
      insertConvertCode(false);
      dealCode(paramString, false);
    }
    if (this.isBegin) {
      this.isBegin = false;
    }
  }
  
  private void dealSingularNum(String paramString)
  {
    debugMsg("dealSingularNum dealStr:" + paramString);
    String str = "";
    if ((this.isEnd) && (!this.isBegin))
    {
      str = paramString.substring(0, 1);
      paramString = paramString.substring(1);
      insertConvertCode(false);
      dealCode(str, false);
      insertConvertCode(true);
      dealCode(paramString, true);
    }
    else
    {
      str = paramString.substring(paramString.length() - 1);
      paramString = paramString.substring(0, paramString.length() - 1);
      insertConvertCode(true);
      dealCode(paramString, true);
      debugMsg("插入CODE_B");
      tailLogicalCode(100);
      dealCode(str, false);
    }
  }
  
  private void dealCode(String paramString, boolean paramBoolean)
  {
    for (int i = 0; i < paramString.length(); i++)
    {
      int j;
      if (paramBoolean)
      {
        String str = paramString.substring(i, i + 2);
        j = Integer.parseInt(str);
        tailLogicalCode(j);
        i++;
      }
      else
      {
        char c = paramString.charAt(i);
        j = getCodeValue(c);
        tailLogicalCode(j);
      }
    }
  }
  
  private void insertConvertCode(boolean paramBoolean)
  {
    if (!this.isBegin)
    {
      if (paramBoolean)
      {
        debugMsg("插入CODE_C");
        tailLogicalCode(99);
      }
      else
      {
        debugMsg("插入CODE_B");
        tailLogicalCode(100);
      }
    }
    else if (this.START_CODE == 105)
    {
      if (!paramBoolean)
      {
        debugMsg("插入CODE_B");
        tailLogicalCode(100);
      }
    }
    else if (paramBoolean)
    {
      debugMsg("插入CODE_C");
      tailLogicalCode(99);
    }
  }
  
  private void tailLogicalCode(int paramInt)
  {
    debugMsg("CodeValue:" + paramInt + " BARCODE:" + BARCODE[paramInt]);
    this.logicalCode += BARCODE[paramInt];
    this.checkSum += paramInt * this.multiplier;
    this.multiplier += 1;
  }
  
  private boolean isNum(String paramString, int paramInt)
  {
    char[] arrayOfChar1 = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    boolean bool = false;
    char[] arrayOfChar2 = paramString.toCharArray();
    if (arrayOfChar2.length > 0)
    {
      int i = arrayOfChar2[paramInt];
      for (int j = 0; j < arrayOfChar1.length; j++) {
        if (i == arrayOfChar1[j]) {
          bool = true;
        }
      }
    }
    return bool;
  }
  
  private int getCodeValue(char paramChar)
  {
    int i = 0;
    switch (paramChar)
    {
    case '!': 
      i = 1;
      break;
    case '"': 
      i = 2;
      break;
    case '#': 
      i = 3;
      break;
    case '$': 
      i = 4;
      break;
    case '%': 
      i = 5;
      break;
    case '&': 
      i = 6;
      break;
    case '\'': 
      i = 7;
      break;
    case '(': 
      i = 8;
      break;
    case ')': 
      i = 9;
      break;
    case '*': 
      i = 10;
      break;
    case '+': 
      i = 11;
      break;
    case ',': 
      i = 12;
      break;
    case '-': 
      i = 13;
      break;
    case '.': 
      i = 14;
      break;
    case '/': 
      i = 15;
      break;
    case '0': 
      i = 16;
      break;
    case '1': 
      i = 17;
      break;
    case '2': 
      i = 18;
      break;
    case '3': 
      i = 19;
      break;
    case '4': 
      i = 20;
      break;
    case '5': 
      i = 21;
      break;
    case '6': 
      i = 22;
      break;
    case '7': 
      i = 23;
      break;
    case '8': 
      i = 24;
      break;
    case '9': 
      i = 25;
      break;
    case ':': 
      i = 26;
      break;
    case ';': 
      i = 27;
      break;
    case '<': 
      i = 28;
      break;
    case '=': 
      i = 29;
      break;
    case '>': 
      i = 30;
      break;
    case '?': 
      i = 31;
      break;
    case '@': 
      i = 32;
      break;
    case 'A': 
      i = 33;
      break;
    case 'B': 
      i = 34;
      break;
    case 'C': 
      i = 35;
      break;
    case 'D': 
      i = 36;
      break;
    case 'E': 
      i = 37;
      break;
    case 'F': 
      i = 38;
      break;
    case 'G': 
      i = 39;
      break;
    case 'H': 
      i = 40;
      break;
    case 'I': 
      i = 41;
      break;
    case 'J': 
      i = 42;
      break;
    case 'K': 
      i = 43;
      break;
    case 'L': 
      i = 44;
      break;
    case 'M': 
      i = 45;
      break;
    case 'N': 
      i = 46;
      break;
    case 'O': 
      i = 47;
      break;
    case 'P': 
      i = 48;
      break;
    case 'Q': 
      i = 49;
      break;
    case 'R': 
      i = 50;
      break;
    case 'S': 
      i = 51;
      break;
    case 'T': 
      i = 52;
      break;
    case 'U': 
      i = 53;
      break;
    case 'V': 
      i = 54;
      break;
    case 'W': 
      i = 55;
      break;
    case 'X': 
      i = 56;
      break;
    case 'Y': 
      i = 57;
      break;
    case 'Z': 
      i = 58;
      break;
    case '[': 
      i = 59;
      break;
    case '\\': 
      i = 60;
      break;
    case ']': 
      i = 61;
      break;
    case '^': 
      i = 62;
      break;
    case '_': 
      i = 63;
      break;
    case '`': 
      i = 64;
      break;
    case 'a': 
      i = 65;
      break;
    case 'b': 
      i = 66;
      break;
    case 'c': 
      i = 67;
      break;
    case 'd': 
      i = 68;
      break;
    case 'e': 
      i = 69;
      break;
    case 'f': 
      i = 70;
      break;
    case 'g': 
      i = 71;
      break;
    case 'h': 
      i = 72;
      break;
    case 'i': 
      i = 73;
      break;
    case 'j': 
      i = 74;
      break;
    case 'k': 
      i = 75;
      break;
    case 'l': 
      i = 76;
      break;
    case 'm': 
      i = 77;
      break;
    case 'n': 
      i = 78;
      break;
    case 'o': 
      i = 79;
      break;
    case 'p': 
      i = 80;
      break;
    case 'q': 
      i = 81;
      break;
    case 'r': 
      i = 82;
      break;
    case 's': 
      i = 83;
      break;
    case 't': 
      i = 84;
      break;
    case 'u': 
      i = 85;
      break;
    case 'v': 
      i = 86;
      break;
    case 'w': 
      i = 87;
      break;
    case 'x': 
      i = 88;
      break;
    case 'y': 
      i = 89;
      break;
    case 'z': 
      i = 90;
      break;
    case '{': 
      i = 91;
      break;
    case '|': 
      i = 92;
      break;
    case '}': 
      i = 93;
      break;
    case '~': 
      i = 94;
    }
    return i;
  }
  
  private static void debugMsg(String paramString)
  {
    if (isDebug) {
      System.out.println(paramString);
    }
  }
}


/* Location:           C:\Users\zhangyeyong\Downloads\gdc_evs\evs\webapps\evs\WEB-INF\classes\
 * Qualified Name:     com.zte.eas.report.business.print.service.BarCode128
 * JD-Core Version:    0.7.0.1
 */