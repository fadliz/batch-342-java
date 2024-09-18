public class WarmupTwo {
    public String stringTimes(String str, int n) {
        String bigger = "";
        for (int i = 0; i < n; i++) {
            bigger += str;
        }
        return bigger;
    }

    public String frontTimes(String str, int n) {
        String copies;
        if (str.length() > 3) {
            copies = str.substring(0, 3);
        } else {
            copies = str.substring(0, str.length());
        }
        String res = "";
        for (int i = 0; i < n; i++) {
            res += copies;
        }
        return res;
    }

    public int countXX(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 2).equals("xx"))
                count++;
        }
        return count;
    }

    public boolean doubleX(String str) {
        if (str.length() < 2)
            return false;
        if (str.indexOf("x") != str.length() - 1)
            return str.charAt(str.indexOf("x") + 1) == 'x';
        return false;
    }

    public String stringBits(String str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                res += str.charAt(i);
            }
        }
        return res;
    }

    public String stringSplosion(String str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            res += str.substring(0, i + 1);
        }
        return res;
    }

    public int last2(String str) {
        // Screen out too-short string case.
        if (str.length() < 2)
            return 0;

        String end = str.substring(str.length() - 2);
        // Note: substring() with 1 value goes through the end of the string
        int count = 0;

        // Check each substring length 2 starting at i
        for (int i = 0; i < str.length() - 2; i++) {
            String sub = str.substring(i, i + 2);
            if (sub.equals(end)) { // Use .equals() with strings
                count++;
            }
        }

        return count;
    }

    public int arrayCount9(int[] nums) {
        int count = 0;
        for (int i : nums) {
            if (i == 9) {
                count++;
            }
        }
        return count;
    }

    public boolean arrayFront9(int[] nums) {
        int end = nums.length;
        if (end > 4)
            end = 4;

        for (int i = 0; i < end; i++) {
            if (nums[i] == 9)
                return true;
        }

        return false;
    }

    public boolean array123(int[] nums) {
        if (nums.length == 0)
            return false;
        for (int i = 0; i < nums.length - 2; i++) {
            // Check if the current and next two elements are 1, 2, 3
            if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3) {
                return true;
            }
        }
        return false;
    }

    public int stringMatch(String a, String b) {
        int shorter = a.length() < b.length() ? a.length() : b.length();
        int count = 0;
        for (int i = 0; i < shorter - 1; i++) {
            if (a.substring(i, i + 2).equals(b.substring(i, i + 2)))
                count++;
        }
        return count;
    }

    public String stringX(String str) {
        if (str.length() < 2)
            return str;
        if (str.indexOf("x") != 0 && !str.substring(str.length() - 1).equals("x")) {
            return str.replaceAll("x", "");
        }
        String mid = str.substring(1, str.length() - 1).replaceAll("x", "");
        return "x" + mid + "x";
    }

    public String altPairs(String str) {
        String result = "";

        // Run i by 4 to hit 0, 4, 8, ...
        for (int i = 0; i < str.length(); i += 4) {
            // Append the chars between i and i+2
            int end = i + 2;
            if (end > str.length()) {
                end = str.length();
            }
            result = result + str.substring(i, end);
        }

        return result;
    }

    public String stringYak(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            // Look for i starting a "yak" -- advance i in that case
            if (i + 2 < str.length() && str.charAt(i) == 'y' && str.charAt(i + 2) == 'k') {
                i = i + 2;
            } else { // Otherwise do the normal append
                result = result + str.charAt(i);
            }
        }

        return result;
    }

    public int array667(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 6 && (nums[i + 1] == 6 || nums[i + 1] == 7))
                count++;
        }
        return count;
    }

    public boolean noTriples(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1] && nums[i] == nums[i + 2])
                return false;
        }
        return true;
    }

    public boolean has271(int[] nums) {
        // Iterate < length-2, so can use i+1 and i+2 in the loop.
        // Return true immediately when seeing 271.
        for (int i = 0; i < (nums.length - 2); i++) {
            int val = nums[i];
            if (nums[i + 1] == (val + 5) && // the "7" check
                    Math.abs(nums[i + 2] - (val - 1)) <= 2) { // the "1" check
                return true;
            }
        }

        // If we get here ... none found.
        return false;
    }

    // Warmup-2 Done
}
