package threaddemo;

/*import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC {
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition A_con = lock.newCondition();
		Condition B_con = lock.newCondition();
		Condition C_con = lock.newCondition();
		Thread t1=new Thread() {
			public void run() {
				int i=0;
				while(i++<10){
					print();
				}
			}

			public void print() {
				lock.lock();
				System.out.println("A");
				try {
					B_con.signal();
					A_con.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
		};
		Thread t2=new Thread(){
			public void run() {
				int i=0;
				while(i++<10){
					print();
				}
			}
			public void print(){
				lock.lock();
				System.out.println("B");
				try{
					C_con.signal();
					B_con.await();
				}catch (InterruptedException e){
					e.getMessage();
				}finally{
					lock.unlock();
				}
			}
		};
		Thread t3=new Thread(){
			public void run() {
				int i=0;
				while(i++<10){
					print();
				}
			}
			public void print(){
				lock.lock();
				System.out.println("C");
				try{
					A_con.signal();
					C_con.await();
				}catch (InterruptedException e){
					e.getMessage();
				}finally{
					lock.unlock();
				}
			}
		};
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
	}
}*/
public class ABC{
	static String pro="lock";
	static String consume="lock";
	static int count=0;
	public static void main(String[] args) {
		new Thread(){
			public void run(){
				synchronized(pro){
					while(true){
					System.out.println(this.currentThread().getName()+":"+(++count));
					if(count>0){
					consume.notify();}
					try {
						if(count>=10){
						pro.wait();}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}
			}
		}.start();
		new Thread(){
			public void run(){
				int i=0;
				while(true){
				synchronized(consume){
					System.out.println(this.currentThread().getName()+":"+(--count));
					if(count<10){
					pro.notify();}
					try {
						if(count<0){
						consume.wait();}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			}
		}.start();
	}
	
}