package pattern.singleton;

class Singletone {//饿汉模式
	private static Singletone s = new Singletone();//必须在这里实例化

	private Singletone() {//必须把构造函数申明为私有
	}

	public static Singletone getSingleton() {
		return s;
	}
}

class Singletonb {//饱汉模式
	private String name;
	private volatile static Singletonb s;

	private Singletonb(String name) {
		this.name = name;
	}

	public static Singletonb getSingleton(String name) {
		if (s == null) {//效率，只要判断一次
			synchronized ("lock") {//加锁，线程安全
				if (s == null) {
					s = new Singletonb(name);
				}
			}
		}
		return s;
	}
}

class Singletonclass{
	private Singletonclass(){
		
	}
	private static class single{
		public static Singletonclass s1=new Singletonclass();
	}
	public static Singletonclass getsin(){
		return single.s1;
	}
}

class Singleton{
	public static void main(String[] args) {
		String name="hah";
		Singletone se1=Singletone.getSingleton();
		Singletone se2=Singletone.getSingleton();
		Singletonb sb1=Singletonb.getSingleton(name);
		Singletonb sb2=Singletonb.getSingleton(name);
		System.out.println(se1==se2);
		System.out.println(sb1==sb2);
	}
}