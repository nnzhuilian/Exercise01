package Algorithm.leetcode;/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */

import java.util.Arrays;

/**
 * @author ：huangxiaohan
 * @description：
 * @date ：Created in 2022/6/13 下午8:16
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println(replaceString(str));
    }

    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            sb.append(' ' == s.charAt(i) ? "%20" : s.charAt(i));
        }
        return sb.toString();
    }

    public static String replaceString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int spaceNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) {
                spaceNumber++;
            }
        }
        char[] newChars = new char[s.length() + spaceNumber * 2];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) {
                newChars[j] = '%';
                newChars[j + 1] = '2';
                newChars[j + 2] = '0';
                j = j + 3;
            } else {
                newChars[j] = s.charAt(i);
                j = j + 1;
            }
        }
        return new String(newChars);
    }
}
