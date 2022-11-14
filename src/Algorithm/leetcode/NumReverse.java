package Algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：huangxiaohan
 * @description：
 * @date ：Created in 2022/6/13 上午10:22
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class NumReverse {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        try {
            if (x > 0) {
                return Integer.parseInt(new StringBuffer(String.valueOf(x)).reverse().toString());
            }else {
                return -Integer.parseInt(new StringBuffer(String.valueOf(-x)).reverse().toString());
            }
        }catch (Exception e){
            return 0;
        }
    }
}
