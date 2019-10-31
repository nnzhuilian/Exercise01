package threaddemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Conditiontest{
	public static Lock lock=new ReentrantLock();
	public static Condition A_con=lock.newCondition();
	public static Condition B_con=lock.newCondition();
	public static Condition C_con=lock.newCondition();
	public static int count=0;
	static class A extends Thread{
		public void run(){
			while(count<12) print();
		}
		public void print(){
			lock.lock();
			System.out.println("A:"+count++);
			B_con.signal();
			try{
				A_con.await();
			}catch(Exception e){
				
			}finally{
				lock.unlock();
			}
		}
	}
	static class B extends Thread{
		public void run(){
			while(count<12) print();
		}
		public void print(){
			lock.lock();
			System.out.println("B:"+count++);
			C_con.signal();
			try{
				B_con.await();
			}catch(Exception e){
				
			}finally{
				lock.unlock();
			}
		}
	}
	static class C extends Thread{
		public void run(){
			while(count<12) print();
		}
		public void print(){
			lock.lock();
			System.out.println("C:"+count++);
			A_con.signal();
			try{
				C_con.await();
			}catch(Exception e){
				
			}finally{
				lock.unlock();
			}
		}
	}
	public static void main(String[] args) {
		new A().start();
		new B().start();
		new C().start();
	}
}

