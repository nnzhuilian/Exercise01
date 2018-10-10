package threadDemo.threadpool;

public interface ThreadPool<Job extends Runnable> {
	//执行一个job
	void excute(Job job);
	//结束工作者线程
	void shutdown();
	//增加工作者线程
	void addWorker(int num);
	//减少工作者线程
	void removeWorker(int num);
	//得到正在执行的任务数量
	int getJobSize();
}
