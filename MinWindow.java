import java.util.*;

class MinWindow {
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() == 0 || t.length() > s.length()) {
            return "";
        }
        int[] dict = new int[256];
        int[] dummy = new int[256];
        for (char ch : t.toCharArray()) {
            dict[ch]++;
        }
        int count = t.length();
        int left = 0;
        int right = 0;
        int lens = Integer.MAX_VALUE;
        String result = "";
        while (right < s.length()) {
            if (count > 0) {
                if (dict[s.charAt(right)] > 0) {
                    dummy[s.charAt(right)]++;
                    if (dummy[s.charAt(right)] <= dict[s.charAt(right)]) {
                        count--;
                    }
                }
                right++;
            }
            while (count == 0) {
                if (right - left < lens) {
                    result = s.substring(left, right);
                    lens = right - left;
                }
                if (dict[s.charAt(left)] > 0) {
                    dummy[s.charAt(left)]--;
                    if (dummy[s.charAt(left)] < dict[s.charAt(left)]) {
                        count++;
                    }
                }
                left++;
            }
        }
        return result;
    }
}