package threaddemo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeCount {
	public static void main(String[] args) {
		RuncCount r=new RuncCount();
		for(int i=0;i<10;i++){
			new Thread(r).start();
		}
	}
}
class RuncCount implements Runnable{
	AtomicInteger count=new AtomicInteger();
	public void run(){
		while(count.get()<100){
			count.getAndIncrement();
			System.out.println(Thread.currentThread().getName()+":"+count.get());
		}
	}
}
/*class RuncCount implements Runnable{
	int count=0;
	public void run(){
		while(count<100){
			synchronized (this) {
				if(count<100){
				count++;
				System.out.println(Thread.currentThread().getName()+":"+count);
				}
			}
		}
	}
}*/
/*class RuncCount implements Runnable{
	int count=0;
	Lock lock=new ReentrantLock();
	
	public void run(){
		while(count<100){
			lock.lock();
			if(count<100){
				count++;
				System.out.println(Thread.currentThread().getName()+":"+count);
				}
			lock.unlock();
		}
	}
}*/
/*class RuncCount implements Runnable{
	int count=0;
	
	public void run(){
		while(count<100){
			count();
		}
	}
	
	public synchronized void count(){
		if(count<100){
		count++;
		System.out.println(Thread.currentThread().getName()+":"+count);
		}
	}
}*/


