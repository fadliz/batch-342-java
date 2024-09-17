public class WarmupOne {
    public boolean sleepIn(boolean weekday, boolean vacation) {
        return !weekday || vacation ? true : false;
      }

      public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return !(aSmile ^ bSmile) ? true : false;
      }

      public int sumDouble(int a, int b) {
        return !(a == b) ? a+b : 2*(a+b);
      }

      public int diff21(int n) {
        int diff = 21 - n;
        int absDiff = diff < 0 ? -diff : diff;
        return (n > 21) ? absDiff*2 : absDiff;
      }

      public boolean parrotTrouble(boolean talking, int hour) {
        return (talking && (hour < 7 || hour > 20)) ? true : false;
      }
      
      public boolean makes10(int a, int b) {
        return (a == 10 || b == 10 || a+b == 10) ? true : false;
      }
      
      public boolean nearHundred(int n) {
        return (Math.abs(100-n) <= 10 || Math.abs(200-n) <= 10) ? true : false;
      }
      
      public boolean posNeg(int a, int b, boolean negative) {
        if (negative) {
            return (a < 0 && b < 0) ? true : false;
        }
        return (a < 0 ^ b < 0) ? true : false;
      }
      
      public String notString(String str) {
        return (str.startsWith("not")) ? str : "not " + str;
      }
      
      public String missingChar(String str, int n) {
        return str.replaceFirst(str.charAt(n)+"", "");
      }
      
      
}
