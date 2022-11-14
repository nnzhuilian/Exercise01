package Algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：huangxiaohan
 * @description：
 * @date ：Created in 2022/6/13 上午10:22
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 */
public class TwoNumberSum {
    public static void main(String[] args) {
        int[] i = {2, 7, 11, 15};
        int[] result = twoSum(i, 9);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> num2Index = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (num2Index.containsKey(target - nums[i])) {
                result[0] = num2Index.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                num2Index.put(nums[i], i);
            }
        }
        return null;
    }
}
