package Algorithm.LinkedListex;

public class ReverseList {
	public ListNode ReverseList1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur=head;
        ListNode nextcur=head.next;
        while(nextcur!=null){
            ListNode temp=nextcur.next;//attention£¡
            nextcur.next=cur;
            cur=nextcur;
            nextcur=temp;
        }
        head.next=null;
        return cur;
    }
	 public ListNode ReverseList2(ListNode head) {//±ê×¼
	        if(head == null)
	            return null;
	        ListNode pre = null;
	        ListNode next = null;

	        while(head != null){
	            next = head.next;
	            head.next = pre;
	            pre = head;
	            head = next;
	        }
	        return pre;
	    }
}
