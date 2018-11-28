package Algorithm.LinkedListex;

class Node {
	int value;
	Node next;
}

public class DeleteNodeInO1 {
	public static void delete(Node head,Node node) {
		if(head==null||node==null){//链表为空，要删除的节点为空
			return;
		}
		if (node.next != null) {//普通情况
			node.value = node.next.value;
			node.next = node.next.next;
		}
		else if(head==node){//只有一个元素的链表
			head=null;
		}
		else{//为最后一个元素
			Node cur=head;
			while(cur.next!=node){
				cur=cur.next;
			}
			cur.next=null;
		}
	}

}
