package construction.QueueDemo.Queue;

public class QueueImplementByArray implements Queue{
	public static final int MAXSIZE=100;
	protected int Capacity;
	protected Object a[];
	protected int front=0;
	protected int last=-1;
	
	public QueueImplementByArray(){
		this.Capacity=MAXSIZE;
		a=new Object[this.Capacity];
	}
	public QueueImplementByArray(int capacity){
		this.Capacity=capacity;
		a=new Object[this.Capacity];
	}


	@Override
	public void enqueue(Object e) throws ExceptionQueueFull{
		if((this.getsize())>Capacity) throw new ExceptionQueueFull("栈溢出");
		if((++last)>=Capacity) last=0;
		a[last]=e;// TODO Auto-generated method stub
		
	}

	@Override
	public Object dequeue() throws ExceptionQueueEmpty {
		if(this.isEmpty()) throw new ExceptionQueueEmpty("栈为空");// TODO Auto-generated method stub
		if(front>=this.Capacity) front=0;
		Object current=a[front];
		a[front++]=null;
		return current;
	}

	@Override
	public int getsize() {
		if(last>=0){// TODO Auto-generated method stub
		return last-front+1;}
		else
		return 0;
	}

	@Override
	public Object front() throws ExceptionQueueEmpty {
		if(this.isEmpty()) throw new ExceptionQueueEmpty("栈为空");// TODO Auto-generated method stub
		if(front>=this.Capacity) front=0;
		return a[front];
	}

	@Override
	public boolean isEmpty() {
		if((this.getsize())==0) return true;// TODO Auto-generated method stub
		else return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueImplementByArray qba=new QueueImplementByArray(3);
		//System.out.println(qba.front());//队列为空
		qba.enqueue(10);
		qba.enqueue(20);
		System.out.println(qba.front());
		qba.enqueue(30);
		System.out.println(qba.getsize());
		//qba.enqueue(40);//队列溢出
		System.out.println(qba.dequeue());
		System.out.println(qba.dequeue());
		System.out.println(qba.dequeue());
		qba.enqueue(40);
		System.out.println(qba.front());
		System.out.println(qba.dequeue());//队列溢出
	}
}

class ExceptionQueueFull extends RuntimeException{
	public ExceptionQueueFull(String e){
		super(e);
	}
}

