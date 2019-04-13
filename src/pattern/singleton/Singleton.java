package pattern.singleton;

public class Singleton {
	private static Singleton s=new Singleton();
	private Singleton(){
		
	}
	public static Singleton get(){
		return s;
	}
}
class Singleton1{//��ȫ����
	private static Singleton1 s;
	private Singleton1(){
		
	}
	public static Singleton1 get(){
		if(s==null){//��������߳����жϺ�ͣס��ͬʱ����
			s=new Singleton1();
		}
		return s;
	}
}
class Singleton2{
	private static Singleton2 s;
	private Singleton2(){
		
	}
	public synchronized static Singleton2 get(){//��������������
		if(s==null){
			s=new Singleton2();
		}
		return s;
	}
}

class Singleton3{
	private static Singleton3 s;//����˫�ط񶨴���
	private Singleton3(){
		
	}
	public static Singleton3 get(){
		if(s==null){//�������жϵ�ʱ������ڴ��ַ�Ѿ���ֵ�ˣ����ǻ�δ��ʼ����
			synchronized("lock"){
				if(s==null){
					s=new Singleton3();
				}
			}
		}
		return s;
	}
}

class Singleton4{
	private volatile static Singleton4 s;
	private Singleton4(){
		
	}
	public static Singleton4 get(){
		if(s==null){
			synchronized("lock"){
				if(s==null){
					s=new Singleton4();
				}
			}
		}
		return s;
	}
}

class Singleton5{
	private Singleton5(){
		
	}
	public static class sin{//ע��static
		public static Singleton5 s=new Singleton5();
	}
	
	public static Singleton5 get(){
		return sin.s;
	}
}