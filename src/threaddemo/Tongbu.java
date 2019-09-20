package threaddemo;

import java.util.concurrent.atomic.AtomicInteger;

public class Tongbu extends Thread{
	public static AtomicInteger a=new AtomicInteger(0);
	public void run(){
		a.getAndIncrement();
		System.out.println(Thread.currentThread().getName()+" "+a);
	}
	public static void main(String[] args) throws InterruptedException{
		for(int i=0;i<100;i++){
			new Tongbu().start();
		}
		Thread.sleep(5000);
		System.out.println(a);
	}
	/*public static int count=0;
	public static synchronized void cal() throws InterruptedException{
			if(count<1000){
			count++;
			//Thread.sleep(100);
			System.out.println(Thread.currentThread().getName()+" "+count);
			}
	}
	public void run(){
		try{
		
		while(count<1000){cal();}
		}
		
		catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
	}
	public static void main (String[] args) throws InterruptedException {
		for(int i=0;i<10;i++){
			new Tongbu().start();
		}
		//Thread.sleep(4000);
		//System.out.println(count);
	}*/
}
