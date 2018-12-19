package Algorithm.LinkedListex;

import java.util.Stack;

public class FindPubulicNode {
	public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {// 我的方法，类似于栈，不好，尤其边界考虑不清晰，不通过原因，没考虑只有一个节点的情况
		if (pHead1 == null || pHead2 == null) {
			return null;
		}
		ListNode p1 = pHead1;
		ListNode p2 = pHead2;
		int len1 = 0;
		int len2 = 0;
		while (p1 != null) {
			len1++;
			p1 = p1.next;
		}
		while (p2 != null) {
			len2++;
			p2 = p2.next;
		}
		ListNode[] l1 = new ListNode[len1];
		ListNode[] l2 = new ListNode[len2];
		for (int i = 0; i < len1; i++) {
			l1[i] = pHead1;
			pHead1 = pHead1.next;
		}
		for (int i = 0; i < len2; i++) {
			l2[i] = pHead2;
			pHead2 = pHead2.next;
		}
		int pub = -1;
		for (int i = len1 - 1, j = len2 - 1; i >= 0 && j >= 0;) {
			if (l1[i] == l2[j]) {
				pub = i;
			} else {
				break;
			}
			i--;
			j--;
		}
		if (pub > -1) {
			return l1[pub];
		}
		return null;
	}

	public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {// 基于栈的方法，有O(n+m)的空间消耗
		Stack<ListNode> s1 = new Stack<>();
		Stack<ListNode> s2 = new Stack<>();
		while (pHead1 != null) {
			s1.push(pHead1);
			pHead1 = pHead1.next;
		}
		while (pHead2 != null) {
			s2.push(pHead2);
			pHead2 = pHead2.next;
		}

		ListNode res = null;
		while (!s1.isEmpty() && !s2.isEmpty() && s1.peek() == s2.peek()) {
			s1.pop();
			res = s2.pop();
		}
		return res;
	}

	public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {// 计算步长的方法，没有空间消耗，时间同上一样O(m+n)
		if (pHead1 == null || pHead2 == null)
			return null;
		int count1 = 1, count2 = 1;
		ListNode p1 = pHead1;
		ListNode p2 = pHead2;
		while (p1.next != null) {
			p1 = p1.next;
			count1++;
		}
		while (p2.next != null) {
			p2 = p2.next;
			count2++;
		}
		if (count1 > count2) {
			int dif = count1 - count2;
			while (dif != 0) {
				pHead1 = pHead1.next;
				dif--;
			}
		} else {
			int dif = count2 - count1;
			while (dif != 0) {
				pHead2 = pHead2.next;
				dif--;
			}
		}
		while (pHead1 != null && pHead2 != null) {
			if (pHead1 == pHead2)
				return pHead1;
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		return null;
	}
}
