package Algorithm.LinkedListex;
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Clone {
	public static RandomListNode Clone1(RandomListNode pHead)//�ҵķ������ƺ�����
    {
        if(pHead==null){
            return null;
        }
        RandomListNode cur=pHead;
        while(cur!=null){
            RandomListNode copy=new RandomListNode(cur.label);
            copy.next=cur.next;
            copy.random=cur.random;
            cur.next=copy;
            cur=copy.next;
        }
        RandomListNode copyCur=pHead.next;
        RandomListNode head=pHead;
        RandomListNode copyHead=head.next;
        while(copyCur!=null){
            if(copyCur.random!=null){
            copyCur.random=copyCur.random.next;
            }
            if(copyCur.next==null){
                break;
            }
            head.next=copyCur.next;
            head=head.next;
            copyCur.next=copyCur.next.next;
            copyCur=copyCur.next;
        }
        head.next=null;
        return copyHead;
    }
	public static RandomListNode Clone2(RandomListNode pHead)//��ֿ����ķ�������ͨ����
    {
        if(pHead == null)
            return null;
        //���ƽڵ� A->B->C ��� A->A'->B->B'->C->C'
        RandomListNode head = pHead;
        while(head != null){
            RandomListNode node = new RandomListNode(head.label);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
        //����random
        head = pHead;
        while(head != null){
            head.next.random = head.random == null ? null : head.random.next;
            head = head.next.next;
        }
        //�۷�
        head = pHead;
        RandomListNode chead = head.next;
        while(head != null){
            RandomListNode node = head.next;
            head.next = node.next;
            node.next = node.next == null ? null : node.next.next;
            head = head.next;
        }
        return chead;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode n1=new RandomListNode(7);
		n1.next=new RandomListNode(6);
		RandomListNode n2=Clone1(n1);
	}

}
