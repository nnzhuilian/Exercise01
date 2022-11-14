package Algorithm.leetcode;/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：huangxiaohan
 * @description： 无重复字符的最长子串
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @date ：Created in 2022/9/8 下午5:07
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int subBegin = 0;
        int maxLen = 0;
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (int sIndex = 0; sIndex < s.length(); sIndex++) {
            if (charMap.containsKey(s.charAt(sIndex)) && charMap.get(s.charAt(sIndex)) >= subBegin) {
                int count = sIndex - subBegin;
                maxLen = Math.max(count, maxLen);
                subBegin = charMap.get(s.charAt(sIndex)) + 1;
            }
            charMap.put(s.charAt(sIndex), sIndex);
        }
        maxLen = Math.max(s.length() - subBegin, maxLen);
        return maxLen;
    }

    public static void main(String args[]) {
        int a = lengthOfLongestSubstring(" ");
        System.out.println(a);
    }
}
