package threaddemo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class createthread {
	public static void main(String[] args) {
		Threadextend t1=new Threadextend();
		t1.start();
		Thread t2=new Thread(new Threadrun());
		t2.start();
		FutureTask<Integer> ft=new FutureTask<>(new Threadcall());
		Thread t3=new Thread(ft);
		t3.start();
	}
	
	
}
class Threadextend extends Thread{
	public void run(){
		System.out.println("0");
	}
}

class Threadrun implements Runnable{
	public void run(){
		System.out.println();
	}
}

class Threadcall implements Callable<Integer>{
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return 1;
	}
	
}


