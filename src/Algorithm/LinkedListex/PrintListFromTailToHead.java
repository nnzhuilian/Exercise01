package Algorithm.LinkedListex;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

public class PrintListFromTailToHead {//自己的方法
	
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> temp=new ArrayList();
        if(listNode==null){
            return temp;//不能写null,直接返回temp就行。
}
        while(listNode!=null){
            temp.add(listNode.val);
            listNode=listNode.next;
            }
        ArrayList<Integer> arr=new ArrayList<Integer>();//如有返回值，必须完整声明ArrayList
        for(int i=temp.size()-1;i>=0;i--){//List的大小是size(),数组是length，String是length();
            arr.add(temp.get(i));
        }
        return arr;
}
	public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {//用栈实现的方法
		ArrayList<Integer> arr=new ArrayList<Integer>();
        if(listNode==null){
            return arr;
        }
		Stack<Integer> st=new Stack<Integer>();
        while(listNode!=null){
        	st.add(listNode.val);
        	listNode=listNode.next;
        }
        while(!st.isEmpty()){//Stack的顶为peek,用peek会抛出栈空错，不能这么判空,要么size,要么isEmpty()
        	arr.add(st.pop());
        }
        return arr;
}
	public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {//用递归的方法，较慢
		ArrayList<Integer> arr=new ArrayList<Integer>();
        if(listNode==null){
            return arr;
        }
        arr=printListFromTailToHead3(listNode.next);
        arr.add(listNode.val);
        return arr;
    }
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {//调转链表方向的方法
	        ArrayList<Integer> arr=new ArrayList<Integer>();
	        if(listNode==null){
	            return arr;
	        }
	        ListNode head=listNode;//通过引入辅助指针
	        ListNode cur=head.next;
	        while(cur!=null){
	            ListNode temp=cur.next;
	            cur.next=head;
	            head=cur;
	            cur=temp;
	        }
	        listNode.next=null;
	        while(head!=null){
	            arr.add(head.val);
	            head=head.next;
	        };
	        return arr;      
	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
