package Algorithm.leetcode;/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：huangxiaohan
 * @description：
 * @date ：Created in 2022/6/13 上午10:27
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class DuplicateNum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        findRepeatNumber1(nums);
    }

    public static int findRepeatNumber1(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> num2Count = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(num2Count.contains(nums[i])) {
                return nums[i];
            }
            num2Count.add(nums[i]);
        }
        return 0;
    }

    public static int findRepeatNumber2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0;
        while(i < nums.length) {
            if(i == nums[i]) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]){
                return nums[i];
            }
            int temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;
        }
        return -1;
    }
}
