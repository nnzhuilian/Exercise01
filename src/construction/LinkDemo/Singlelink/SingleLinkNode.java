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
	//获取节点元素
	public Object getElements(){
		return element;
	}
	//获取当前节点后驱
	public SingleLinkNode getNext(){
		return next;
	}
	//设置节点元素，并返回之前元素
	public Object setElements(Object element){
		Object old=this.element;
		this.element=element;
		return old;
	}
	//设置下一个节点
	public void setNext(SingleLinkNode next){
		this.next=next;
	}
}
