package Algorithm.leetcode;

/**
 * @author ：huangxiaohan
 * @description：最长回文串 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * @date ：Created in 2022/11/7 下午8:09
 */
public class LongestPalindrome {
    public static void main(String args[]) {
        String s = longestPalindrome("babad");
        System.out.println(s);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int maxLen = 0;
        int maxLeft = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = 1;
            int left = i - len;
            int right = i + len;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
                len++;
            }
            while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                right++;
                len++;
            }
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                right++;
                left--;
                len = len + 2;
            }
            if (len > maxLen) {
                maxLeft = left;
                maxLen = len;
            }
        }
        return s.substring(maxLeft + 1, maxLeft + maxLen + 1);
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  // 最长回文串的起点
        int maxEnd = 0;    // 最长回文串的终点
        int maxLen = 1;  // 最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);

    }
}