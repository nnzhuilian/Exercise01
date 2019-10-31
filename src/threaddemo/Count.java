package threaddemo;

import java.util.concurrent.CountDownLatch;

public class Count{
	static CountDownLatch con=new CountDownLatch(3);
	public static void main(String[] args) {
		for(int i=0;i<3;i++){
			new Thread(){
				public void run(){
					con.countDown();
				}
			}.start();
		}
		try {
			con.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}