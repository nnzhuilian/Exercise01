package Algorithm.leetcode;/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */

import java.util.Stack;

/**
 * @author ：huangxiaohan
 * @description： 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @date ：Created in 2022/6/27 上午11:30
 */
public class PrintReservedLink {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<Integer> nodeStack = new Stack();
        while (head != null) {
            nodeStack.push(head.val);
            head = head.next;
        }

        int[] printStack = new int[nodeStack.size()];
        int index = 0;
        while (!nodeStack.empty()) {
            printStack[index] = nodeStack.pop();
            index++;
        }
        return printStack;
    }
}


