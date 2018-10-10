package construction.StackDemo.Stack;

import construction.LinkDemo.Singlelink.SingleLinkNode;
import construction.StackDemo.Stack.ExceptionStackEmpty;

public class SingleLinkStack implements Stack{
	SingleLinkNode top;
	int count=0;

	@Override
	public int getsize() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public Object top() throws ExceptionStackEmpty {
		// TODO Auto-generated method stub
		if(this.isEmpty()){throw new ExceptionStackEmpty("Õ»Îª¿Õ");}
		return top.getElements();
	}

	@Override
	public void push(Object e) {
		// TODO Auto-generated method stub
		SingleLinkNode n=new SingleLinkNode(e,top);
		top=n;
		count++;
	}

	@Override
	public Object pop() throws ExceptionStackEmpty {
		if(this.isEmpty()){throw new ExceptionStackEmpty("Õ»Îª¿Õ");}
		Object e=top.getElements();// TODO Auto-generated method stub
		top=top.getNext();
		count--;
		return e;
	}

	@Override
	public boolean isEmpty() {
		if(this.getsize()==0) return true;// TODO Auto-generated method stub
		return false;
	}
	public static void main(String[] args){
		SingleLinkStack sba=new SingleLinkStack();
		sba.push(10);
		sba.push(20);
		System.out.println(sba.top());
		System.out.println(sba.pop());
		sba.push(30);
		sba.push(2);
		System.out.println(sba.pop());
		System.out.println(sba.pop());
		System.out.println(sba.pop());
		//System.out.println(sba.top());//Õ»Îª¿Õ
	}

}
