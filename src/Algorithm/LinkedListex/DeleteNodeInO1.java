package Algorithm.LinkedListex;

class Node {
	int value;
	Node next;
}

public class DeleteNodeInO1 {
	public static void delete(Node head,Node node) {
		if(head==null||node==null){//����Ϊ�գ�Ҫɾ���Ľڵ�Ϊ��
			return;
		}
		if (node.next != null) {//��ͨ���
			node.value = node.next.value;
			node.next = node.next.next;
		}
		else if(head==node){//ֻ��һ��Ԫ�ص�����
			head=null;
		}
		else{//Ϊ���һ��Ԫ��
			Node cur=head;
			while(cur.next!=node){
				cur=cur.next;
			}
			cur.next=null;
		}
	}

}
