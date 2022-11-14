package Algorithm.leetcode;/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：huangxiaohan
 * @description： 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n))
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * @date ：Created in 2022/10/12 下午5:20
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/solutions/8999/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie
 * -fa-by-w-2/
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        double b = findMedianSortedArrays2(new int[] {1,2}, new int[] {3,4});
        System.out.println(b);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int[] middle = (nums1Len + nums2Len) % 2 == 0 ?
                new int[] {(nums1Len + nums2Len) / 2 - 1, (nums1Len + nums2Len) / 2}
                : new int[] {(nums1Len + nums2Len) / 2, (nums1Len + nums2Len) / 2};
        int nums1Index = 0;
        int nums2Index = 0;
        List<Integer> listqueue = new ArrayList<Integer>();
        while (nums1Index < nums1Len || nums2Index < nums2Len) {
            if (listqueue.size() == middle[1] + 1) {
                return ((double) listqueue.get(middle[0]) + (double) listqueue.get(middle[1])) / 2;
            }
            if (nums1Index == nums1Len) {
                listqueue.add(nums2[nums2Index]);
                nums2Index++;
                continue;
            }
            if (nums2Index == nums2Len) {
                listqueue.add(nums1[nums1Index]);
                nums1Index++;
                continue;
            }
            if (nums1[nums1Index] <= nums2[nums2Index]) {
                listqueue.add(nums1[nums1Index]);
                nums1Index++;
            } else {
                listqueue.add(nums2[nums2Index]);
                nums2Index++;
            }
        }
        return ((double) listqueue.get(middle[0]) + (double) listqueue.get(middle[1])) / 2;
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int left = (nums1Len + nums2Len + 1) / 2; // k-个数
        int right = (nums1Len + nums2Len + 2) / 2;//
        return (finMid(left, 0, 0, nums1, nums2) + finMid(right, 0, 0, nums1, nums2)) * 0.5;
    }

    private static int finMid(int k, int n1, int m1, int[] n, int m[]) {
        if (n1 >= n.length) {
            return m[m1 + k - 1];
        }
        if (m1 >= m.length) {
            return n[n1 + k - 1];
        }
        if (k == 1) {
            return Math.min(n[n1], m[m1]);
        }
        int offset = Math.min(k / 2, Math.min(m.length - m1, n.length - n1));
        if (n[n1 + offset -1] <= m[m1 + offset - 1]) {
            n1 = n1 + offset;
        } else {
            m1 = m1 + offset;
        }
        k = k - offset;
        return finMid(k, n1, m1, n, m);
    }
}
