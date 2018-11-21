package Algorithm.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueImplementStack {
	Queue<Integer> q1=new LinkedList<Integer>();
	Queue<Integer> q2=new LinkedList<Integer>();
	
	public void push(int i){
		q1.offer(i);
	}
	
	public int pop(){
		int size=q1.size();
		if(size==0)
			throw new RuntimeException("wrong");
		for(int i=0;i<size-1;i++){
			q2.offer(q1.poll());
		}
		int k=q1.poll();
		Queue<Integer> temp=new LinkedList<Integer>();
		temp=q1;
		q1=q2;
		q2=temp;
		return k;
	}
	

/*public class MyStack<E> {
	LinkedList<E>  q1=new LinkedList<E>();    //队列1
	LinkedList<E>  q2=new LinkedList<E>();    //队列2
	
	//入栈操作 即入队
	public void push(E e) {
		q1.addLast(e);    //从尾部入队
	}
	
	//出栈操作：  非空队列的n-1个压入空队列  剩余的第n个出队   总有一个队列为空
	public E pop() {
		if(size()!=0) {                              //判断栈是否为空
			if(!q1.isEmpty()) {
				putN_1ToAnother();           //非空队列的n-1个压入空队列
				return q1.removeFirst();     //剩余的第n个出队 (从对头出队)
			}else {
				putN_1ToAnother(); 
				return q2.removeFirst(); 
			}
		}else {
			System.out.println("栈为空，无法执行出栈操作");
			return null;
		}
	}
	
	// 非空队列的n-1个压入空队列
	private void putN_1ToAnother() {
		if(!q1.isEmpty()) {               //若q2为空 则从q1中移动前n-1个
			while(q1.size()>1) {  
				q2.addLast(q1.removeFirst());
			}
		}else {
			while(q2.size()>1) {      //若q1为空 则从q2中移动前n-1个
				q1.addLast(q2.removeFirst());
			}
		}
	}
 
	//判断栈是否为空
	public int size() {
		return q1.size()+q2.size();
	}
}*/


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoQueueImplementStack t=new TwoQueueImplementStack();
		t.push(1);
		t.push(2);
		System.out.println(t.pop());
		System.out.println(t.pop());
		t.push(3);
		t.push(4);
		System.out.println(t.pop());
		System.out.println(t.pop());
		System.out.println(t.pop());
	}

}
