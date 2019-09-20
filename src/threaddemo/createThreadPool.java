package threaddemo;

import java.util.concurrent.*;

public class createThreadPool {
	ExecutorService thread2=Executors.newFixedThreadPool(10);
	ExecutorService thread3=Executors.newSingleThreadExecutor();
	ExecutorService thread4=Executors.newCachedThreadPool();
	ScheduledExecutorService threadsch1=Executors.newScheduledThreadPool(10);
	public static void main(String[] args) {
		ThreadPoolExecutor threadPool=new ThreadPoolExecutor(10,10,60L,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(10));
		threadPool.execute(new Runnable(){
			public void run(){}
		});
		Executors.callable(new Runnable(){
			public void run(){
				
			}
		});
		Future<Integer> f=threadPool.submit(new Callable<Integer>(){
			public Integer call(){
				return 0;
			}
		});
		try {
			f.get();
			f.cancel(true);
		} catch (InterruptedException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ExecutionException e){
			e.printStackTrace();
		}
		finally{
			threadPool.shutdown();
		}
		
		
	}
}
