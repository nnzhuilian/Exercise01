package threadDemo.threadpool;

public interface ThreadPool<Job extends Runnable> {
	//ִ��һ��job
	void excute(Job job);
	//�����������߳�
	void shutdown();
	//���ӹ������߳�
	void addWorker(int num);
	//���ٹ������߳�
	void removeWorker(int num);
	//�õ�����ִ�е���������
	int getJobSize();
}
