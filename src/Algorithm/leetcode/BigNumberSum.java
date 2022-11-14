package Algorithm.leetcode;/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */

/**
 * @author ：huangxiaohan
 * @description：大数相加 l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * @date ：Created in 2022/9/8 下午3:27
 */
public class BigNumberSum {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode node = new ListNode(0);
        int count = 0;

        ListNode begin = node;

        while (l1 != null || l2 != null || count != 0) {
            node.next = new ListNode(0);
            node = node.next;
            node.val = node.val + count;
            if (l1 != null) {
                node.val = node.val + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                node.val = node.val + l2.val;
                l2 = l2.next;
            }
            count = node.val / 10;
            node.val = node.val % 10;
        }
        return begin.next;
    }

    public static void main(String args[]){
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l3 = addTwoNumbers(l1,l2);
        System.out.println(l3);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}