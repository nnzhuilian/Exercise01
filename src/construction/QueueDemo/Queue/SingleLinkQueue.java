package construction.QueueDemo.Queue;

import construction.LinkDemo.Singlelink.SingleLinkNode;

public class SingleLinkQueue implements Queue {
	protected SingleLinkNode front;
	protected SingleLinkNode last;
	int count=0;

	@Override
	public void enqueue(Object e) {
		// TODO Auto-generated method stub
		SingleLinkNode n= new SingleLinkNode(e,null);
		if(this.isEmpty()){
			last=front=n;
		}
		else{
		last.setNext(n);
		last=n;
		}
		count++;
	}

	@Override
	public Object dequeue() throws ExceptionQueueEmpty {
		// TODO Auto-generated method stub
		if(this.isEmpty()){throw new ExceptionQueueEmpty("队列为空！");}
		Object e=front.getElements();
		front=front.getNext();
		count--;
		return e;
	}

	@Override
	public int getsize() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public Object front() throws ExceptionQueueEmpty {
		// TODO Auto-generated method stub
		if(this.isEmpty()){throw new ExceptionQueueEmpty("队列为空！");}
		return front.getElements();
	}

	@Override
	public boolean isEmpty() {
		if(this.getsize()==0) return true;// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLinkQueue qba=new SingleLinkQueue();
		//System.out.println(qba.front.getElements());/没有new！！
		//System.out.println(qba.front());//队列为空
		qba.enqueue(10);
		qba.enqueue(20);
		System.out.println(qba.front());
		qba.enqueue(30);
		System.out.println(qba.getsize());
		qba.enqueue(40);//队列溢出
		System.out.println(qba.dequeue());
		System.out.println(qba.dequeue());
		qba.enqueue(50);
		qba.enqueue(60);
		System.out.println(qba.getsize());
		System.out.println(qba.dequeue());
		
		System.out.println(qba.front());
		System.out.println(qba.dequeue());
		System.out.println(qba.dequeue());
		System.out.println(qba.dequeue());
		System.out.println(qba.dequeue());//队列溢出
	}

}
