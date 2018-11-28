package Algorithm.LinkedListex;

import java.util.Stack;

public class FindKthToTail {
	public ListNode FindKthToTail1(ListNode head, int k) {// 褒峺寞隈
		if (head == null || k <= 0) {
			return null;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		int kk = 1;
		while ((p1.next != null) && (kk < k)) {
			p1 = p1.next;
			kk++;
		}
		if (kk < k) {
			return null;
		}
		while (p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
	
// 褒峺寞炎彈！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
	public ListNode FindKthToTail2(ListNode head, int k) {
		if (head == null || k == 0)
			return null;
		ListNode temp = head;
		// 登僅k頁倦階狛全燕准泣議倖方��廣吭頁 i < k - 1
		for (int i = 0; i < k - 1; i++) {
			if (temp.next != null)
				temp = temp.next;
			else
				return null;
		}
		ListNode pA = head;
		ListNode pB = head;
		for (int i = 0; i < k - 1; i++)
			pA = pA.next;
		while (pA.next != null) {
			pA = pA.next;
			pB = pB.next;
		}
		return pB;
	}
	//均媚圭隈！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
	public ListNode FindKthToTail3(ListNode head, int k) {
		if (head == null || k == 0)
			return null;
		ListNode temp=head;
		int kk=0;
		Stack<ListNode> s=new Stack<ListNode>();
		while(temp!=null){
			kk++;
			s.add(temp);
			temp=temp.next;
		}
		if(kk<k){
			return null;
		}
		for(int i=0;i<k-1;i++){
			s.pop();
		}
		return s.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
