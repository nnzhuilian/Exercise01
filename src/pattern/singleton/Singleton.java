package pattern.singleton;

public class Singleton {
	private static Singleton s=new Singleton();
	private Singleton(){
		
	}
	public static Singleton get(){
		return s;
	}
}
class Singleton1{//安全问题
	private static Singleton1 s;
	private Singleton1(){
		
	}
	public static Singleton1 get(){
		if(s==null){//在这里，两线程先判断后停住，同时创建
			s=new Singleton1();
		}
		return s;
	}
}
class Singleton2{
	private static Singleton2 s;
	private Singleton2(){
		
	}
	public synchronized static Singleton2 get(){//产生大量锁争夺
		if(s==null){
			s=new Singleton2();
		}
		return s;
	}
}

class Singleton3{
	private static Singleton3 s;//会有双重否定错误
	private Singleton3(){
		
	}
	public static Singleton3 get(){
		if(s==null){//在这里判断的时候可能内存地址已经赋值了，但是还未初始化。
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
	public static class sin{//注意static
		public static Singleton5 s=new Singleton5();
	}
	
	public static Singleton5 get(){
		return sin.s;
	}
}