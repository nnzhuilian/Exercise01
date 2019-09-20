package Algorithm.sortex;

class LinkedNode {
	int val;
	LinkedNode next;

	public LinkedNode(int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
	}
}

public class LinkedPartition {
	public static void sort(LinkedNode Node) {
		sort(Node, null);
	}

	public static void sort(LinkedNode Head, LinkedNode End) {
		if (Head != End) {
			LinkedNode node = partition(Head, End);
			LinkedNode node2=node;
			sort(Head, node);
			sort(node2.next, null);
		}
	}

	public static LinkedNode partition(LinkedNode Head, LinkedNode End) {
		LinkedNode p1=Head;
		LinkedNode p2=Head.next;
		while(p2!=End){
			if(p2.val<p1.val){
				swap(p1.next,p2);
				p1=p1.next;
				p2=p2.next;
			}else{
				p2=p2.next;
			}
		}
		swap(p1,Head);
		return p1;
	}

	public static void main(String[] args) {
		LinkedNode head=new LinkedNode(1);
		head.next=new LinkedNode(-1);
		head.next.next=new LinkedNode(4);
		head.next.next.next=new LinkedNode(2);
		head.next.next.next.next=new LinkedNode(3);
		sort(head);
	}
	public static void swap(LinkedNode p1,LinkedNode p2){
		int tmp=p1.val;
		p1.val=p2.val;
		p2.val=tmp;
	}
}
