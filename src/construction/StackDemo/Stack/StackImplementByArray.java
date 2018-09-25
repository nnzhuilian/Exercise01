package construction.StackDemo.Stack;


public class StackImplementByArray implements Stack{

	public static final int MAXSIZE=100;
	public int Capacity;
	public int top=-1;
	Object a[];
	public StackImplementByArray(){
		this.Capacity=MAXSIZE;
		a=new Object[this.Capacity];
	}
	public StackImplementByArray(int capacity){
		this.Capacity=capacity;
		a=new Object[capacity];
	}
	
	@Override
	public int getsize() {
		// TODO Auto-generated method stub
		return top+1;
	}

	@Override
	public Object top() throws ExceptionStackEmpty {
		// TODO Auto-generated method stub
		if(top<0) throw new ExceptionStackEmpty("Õ»Îª¿Õ");
		return a[top];
	}

	@Override
	public void push(Object e) throws ExceptionStackFull{
		if((++top)>=Capacity) throw new ExceptionStackFull("Õ»Òç³ö");
		a[top]=e;// TODO Auto-generated method stub
		
	}

	@Override
	public Object pop() throws ExceptionStackEmpty {
		if(top<0) throw new ExceptionStackEmpty("Õ»Îª¿Õ");
		Object current=a[top];
		a[top--]=null;
		// TODO Auto-generated method stub
		return current;
	}

	@Override
	public boolean isEmpty() {
		if(top<0) return true;// TODO Auto-generated method stub
		else return false;
	}
	
	public static void main(String[] args){
		StackImplementByArray sba=new StackImplementByArray(3);
		sba.push(10);
		sba.push(20);
		System.out.println(sba.top());
		System.out.println(sba.pop());
		sba.push(30);
		sba.push(2);
		System.out.println(sba.pop());
		System.out.println(sba.pop());
		System.out.println(sba.pop());
		//System.out.println(sba.pop());//Õ»Îª¿Õ
	}
}
class ExceptionStackFull extends RuntimeException{
	public ExceptionStackFull(String e){
		super(e);
	}
}