package Algorithm.LinkedListex;

/*class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}*/

public class MergeList {
	public ListNode Merge(ListNode list1, ListNode list2) {// ·ÇµÝ¹é
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode merge = new ListNode(-1);
		ListNode head = merge;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				merge.next = list1;
				list1 = list1.next;
			} else {
				merge.next = list2;
				list2 = list2.next;
			}
			merge = merge.next;
		}
		/*
		 * if (list1 == null && list2 == null) { return head.next; }
		 */
		if (list1 == null) {
			merge.next = list2;
		}
		if (list2 == null) {
			merge.next = list1;
		}
		return head.next;
	}

	// µÝ¹é½â·¨

	public ListNode Merge2(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		else if (list2 == null)
			return list1;
		ListNode mergehead = null;
		if (list1.val <= list2.val) {
			mergehead = list1;
			mergehead.next = Merge(list1.next, list2);
		} else {
			mergehead = list2;
			mergehead.next = Merge(list1, list2.next);
		}
		return mergehead;
	}
}
