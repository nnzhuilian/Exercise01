package construction.LinkDemo.Singlelink;

public class SingleLinkNode {
	private Object element;
	private SingleLinkNode next;
	public SingleLinkNode(){
		this.element=null;
		this.next=null;
	}
	public SingleLinkNode(Object element,SingleLinkNode next){
		this.element=element;
		this.next=next;
	}
	//��ȡ�ڵ�Ԫ��
	public Object getElements(){
		return element;
	}
	//��ȡ��ǰ�ڵ����
	public SingleLinkNode getNext(){
		return next;
	}
	//���ýڵ�Ԫ�أ�������֮ǰԪ��
	public Object setElements(Object element){
		Object old=this.element;
		this.element=element;
		return old;
	}
	//������һ���ڵ�
	public void setNext(SingleLinkNode next){
		this.next=next;
	}
}
