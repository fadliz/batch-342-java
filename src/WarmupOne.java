public class WarmupOne {
  public boolean sleepIn(boolean weekday, boolean vacation) {
    return !weekday || vacation;
  }

  public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
    return !(aSmile ^ bSmile);
  }

  public int sumDouble(int a, int b) {
    return !(a == b) ? a + b : 2 * (a + b);
  }

  public int diff21(int n) {
    int diff = 21 - n;
    int absDiff = diff < 0 ? -diff : diff;
    return (n > 21) ? absDiff * 2 : absDiff;
  }

  public boolean parrotTrouble(boolean talking, int hour) {
    return (talking && (hour < 7 || hour > 20));
  }

  public boolean makes10(int a, int b) {
    return (a == 10 || b == 10 || a + b == 10);
  }

  public boolean nearHundred(int n) {
    return (Math.abs(100 - n) <= 10 || Math.abs(200 - n) <= 10);
  }

  public boolean posNeg(int a, int b, boolean negative) {
    if (negative) {
      return (a < 0 && b < 0);
    }
    return (a < 0 ^ b < 0);
  }

  public String notString(String str) {
    return (str.startsWith("not")) ? str : "not " + str;
  }

  public String missingChar(String str, int n) {
    return str.replaceFirst(str.charAt(n) + "", "");
  }

  public String frontBack(String str) {
    char[] chars = str.toCharArray();
    if (!str.isEmpty()) {
      char temp = chars[0];
      chars[0] = chars[str.length() - 1];
      chars[str.length() - 1] = temp;
    }
    return new String(chars);
  }

  public String front3(String str) {
    if (str.isEmpty())
      return "";
    String sub = str.length() >= 3 ? str.substring(0, 3) : str.substring(0, str.length());
    return sub + sub + sub;
  }

  public String backAround(String str) {
    return str.isEmpty() ? "" : str.charAt(str.length() - 1) + str + str.charAt(str.length() - 1);
  }

  public boolean or35(int n) {
    return (n % 3 == 0 || n % 5 == 0);
  }

  public String front22(String str) {
    if (str.isEmpty())
      return "";
    String sub = str.length() >= 2 ? str.substring(0, 2) : str.substring(0, str.length());
    return sub + str + sub;
  }

  public boolean startHi(String str) {
    return str.startsWith("hi");
  }

  public boolean icyHot(int temp1, int temp2) {
    return (temp1 < 0 && temp2 > 100) || (temp2 < 0 && temp1 > 100);
  }

  public boolean in1020(int a, int b) {
    return (a >= 10 && a <= 20) || (b >= 10 && b <= 20);
  }

  public boolean hasTeen(int a, int b, int c) {
    return (a >= 13 && a <= 19) ||
        (b >= 13 && b <= 19) ||
        (c >= 13 && c <= 19);
  }

  public boolean loneTeen(int a, int b) {
    return (a <= 19 && a >= 13) ^ (b <= 19 && b >= 13);
  }

  public String delDel(String str) {
    return str.contains("del") && str.length() >= 4 && str.substring(1, 4).equals("del")
        ? str.substring(0, 1) + str.substring(4)
        : str;
  }

  public boolean mixStart(String str) {
    return str.length() >= 3 && str.substring(1, 3).equals("ix");
  }

  public String startOz(String str) {
    return (str.length() >= 1 && str.substring(0, 1).equals("o") ? str.substring(0, 1) : "")
        + (str.length() >= 2 && str.substring(1, 2).equals("z") ? str.substring(1, 2) : "");
  }

  public int intMax(int a, int b, int c) {
    return Math.max(Math.max(a, b), c);
  }

  public int close10(int a, int b) {
    int aDiff = Math.abs(a - 10);
    int bDiff = Math.abs(b - 10);

    if (aDiff < bDiff) {
      return a;
    }
    if (bDiff < aDiff) {
      return b;
    }
    return 0;
  }

  public boolean in3050(int a, int b) {
    return (a >= 30 && a <= 40) && (b >= 30 && b <= 40) 
    || (a >= 40 && a <= 50) && (b >= 40 && b <= 50);
  }
  
  public int max1020(int a, int b) {
    if (a >= 10 && a <= 20) {
      if (b >= 10 && b <= 20) {
        return Math.max(a, b);
      } 
      return a;
    }
    if (b >= 10 && b <= 20) {
      return b;
    }
    return 0;
  }
  
  public boolean stringE(String str) {
    int count = 0;
    for (char chr : str.toCharArray()) {
      if (chr == 'e') {
          count++;
      }
    }
    return count <= 3 && count >= 1;
  }
  
  public boolean lastDigit(int a, int b) {
    return(a % 10 == b % 10);
  }
  
  public String endUp(String str) {
    return (str.length() >= 3) ? str.substring(0, str.length() - 3) + str.substring(str.length() - 3, str.length()).toUpperCase() : str.toUpperCase();
  }

  public String everyNth(String str, int n) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < str.length(); i += n) {
      result.append(str.charAt(i));
    }
    return result.toString();
  }
  
  // Warmup-1 Done
}
