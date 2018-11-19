package BasicJava.threadDemo.threadpool;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job>{
	public static final int MAXSIZE=10;
	public static final int DEFAULT=5;
	public static final int MINIMUM=1;
	private final LinkedList<Job> jobs=new LinkedList<Job>();
	private final List<Worker> workers=Collections.synchronizedList(new ArrayList<Worker>());
	private int workerNum=DEFAULT;//����������
	//�̱߳������
	private AtomicLong threadNum=new AtomicLong();
	
	public DefaultThreadPool() {
		initializeWorkers(DEFAULT);// TODO Auto-generated constructor stub
	}
	public DefaultThreadPool(int num) {
		workerNum=num>MAXSIZE?MAXSIZE:num<MINIMUM?MINIMUM:num;
		initializeWorkers(workerNum);// TODO Auto-generated constructor stub
	}
	@Override
	public void excute(Job job) {
		if(job!=null){// ���һ��������Ȼ�����֪ͨ
			synchronized (jobs) {
				jobs.addLast(job);
				jobs.notify();
			}
		}
		
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		for(Worker worker:workers){
			worker.shutdown();
		}
	}

	@Override
	public void addWorker(int num) {
		// TODO Auto-generated method stub
		synchronized (jobs) {
			if(num+this.workerNum>MAXSIZE){
				num=MAXSIZE-this.workerNum;
			}
			initializeWorkers(num);
			this.workerNum+=num;
		}
	}

	@Override
	public void removeWorker(int num) {
		// TODO Auto-generated method stub
		synchronized (jobs) {
			if(num>=this.workerNum){
				throw new IllegalArgumentException("����");
			}
			int count=0;
			while(count<num){
				Worker worker=workers.get(count);
				if(workers.remove(worker)){
					worker.shutdown();
					count++;
				}
			}
			this.workerNum-=count;
		}
	}

	@Override
	public int getJobSize() {
		// TODO Auto-generated method stub
		return jobs.size();
	}
	//��ʼ���̹߳�����
	private void initializeWorkers(int num){/////////�������޷�����
		for(int i=0;i<num;i++){
			Worker worker=new Worker();
			workers.add(worker);
			Thread thread=new Thread(worker,"ThreadPool-Worker-"+threadNum.incrementAndGet());
			thread.start();
		}
	}

class Worker implements Runnable{
	//�Ƿ���
	private volatile boolean running=true;//////------------------ԭ��
	public void run(){
		while(running){
			Job job=null;
			synchronized(jobs){
				while(jobs.isEmpty()){
					try{
						jobs.wait();
					}catch(InterruptedException e){
						//��֪�ⲿ��WorkThread���жϲ���
						Thread.currentThread().interrupt();
						return;
					}
				}
				job=jobs.removeFirst();
			}
			if(job!=null){
				try{
					job.run();
				}catch(Exception e){
					//����job�е�exception
				}
			}
		}
	}
	public void shutdown(){
		running=false;
	}
}
}

