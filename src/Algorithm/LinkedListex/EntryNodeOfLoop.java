package Algorithm.LinkedListex;

import java.util.HashSet;

public class EntryNodeOfLoop {
	public ListNode EntryNodeOfLoop1(ListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        HashSet<ListNode> set=new HashSet<ListNode>();
        while(pHead!=null){
            if(set.contains(pHead)){
                return pHead;
            }else{
                set.add(pHead);
            }
            pHead=pHead.next;
        }
        return null;
    }
	/*假设环长度为n，进入环之前结点个数为x,
	 * slow在环内走了k个结点,fast绕环走了m圈,
	 * 则有2(x+k)=x+mn+k 可以得出x = mn - k。
	 * 此时slow距入口结点还剩 n-k个结点,x=(m−1)n+n−k，
	 * 即一个指针从链表头节点走到环入口的长度等于另一个指针从相遇的位置走 m-1圈后再走n-k的长度，
	 * 也就是说两个指针相遇后，让一个指针回到头节点，另一个指针不动，然后他们同时往前每次走一步，
	 * 当他们相遇时，相遇的节点即为环入口节点。
	 * 
	 * 所以，我们设置两个指针，一个是快指针fast，一个是慢指针slow，
	 * fast一次走两步，slow一次走一步，如果单链表有环那么当两个指针相遇时一定在环内。
	 * 此时将一个指针指到链表头部，另一个不变，二者同时每次向前移一格,
	 * 当两个指针再次相遇时即为环的入口节点。如果fast走到null则无环。*/
	 public ListNode EntryNodeOfLoop2(ListNode pHead)
	    {
	        if(pHead.next == null || pHead.next.next == null)
	            return null;
	        ListNode slow = pHead.next;
	        ListNode fast = pHead.next.next;
	        while(fast != null){
	            if(fast == slow){
	                fast = pHead;
	                while(fast != slow){
	                    fast = fast.next;
	                    slow = slow.next;
	                }
	                return fast;
	            }
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return null;
	    }

}
