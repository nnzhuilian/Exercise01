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

public class PrintListFromTailToHead {//�Լ��ķ���
	
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> temp=new ArrayList();
        if(listNode==null){
            return temp;//����дnull,ֱ�ӷ���temp���С�
}
        while(listNode!=null){
            temp.add(listNode.val);
            listNode=listNode.next;
            }
        ArrayList<Integer> arr=new ArrayList<Integer>();//���з���ֵ��������������ArrayList
        for(int i=temp.size()-1;i>=0;i--){//List�Ĵ�С��size(),������length��String��length();
            arr.add(temp.get(i));
        }
        return arr;
}
	public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {//��ջʵ�ֵķ���
		ArrayList<Integer> arr=new ArrayList<Integer>();
        if(listNode==null){
            return arr;
        }
		Stack<Integer> st=new Stack<Integer>();
        while(listNode!=null){
        	st.add(listNode.val);
        	listNode=listNode.next;
        }
        while(!st.isEmpty()){//Stack�Ķ�Ϊpeek,��peek���׳�ջ�մ�������ô�п�,Ҫôsize,ҪôisEmpty()
        	arr.add(st.pop());
        }
        return arr;
}
	public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {//�õݹ�ķ���������
		ArrayList<Integer> arr=new ArrayList<Integer>();
        if(listNode==null){
            return arr;
        }
        arr=printListFromTailToHead3(listNode.next);
        arr.add(listNode.val);
        return arr;
    }
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {//��ת������ķ���
	        ArrayList<Integer> arr=new ArrayList<Integer>();
	        if(listNode==null){
	            return arr;
	        }
	        ListNode head=listNode;//ͨ�����븨��ָ��
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
