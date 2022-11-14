package Algorithm.leetcode;/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */

/**
 * @author ：huangxiaohan
 * @description：
 * @date ：Created in 2022/6/13 下午7:55
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindNumPairInMap {
    public static void main(String[] args) {
        int[][] map = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        findNumberIn2DArray(map, 17);
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int column = matrix[0].length - 1;
        while (row >= 0 && row < matrix.length && column >= 0 && column < matrix[0].length) {
            if (target == matrix[row][column]) {
                return true;
            }
            if (target > matrix[row][column]) {
                row++;
                continue;
            }
            if (target < matrix[row][column]) {
                column--;
                continue;
            }
        }
        return false;
    }
}
