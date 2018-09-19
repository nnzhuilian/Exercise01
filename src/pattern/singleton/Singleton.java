package pattern.singleton;

class Singletone {//����ģʽ
	private static Singletone s = new Singletone();//����������ʵ����

	private Singletone() {
	}

	public static Singletone getSingleton() {
		return s;
	}
}

class Singletonb {//����ģʽ
	private String name;
	private static Singletonb s;

	private Singletonb(String name) {
		this.name = name;
	}

	public static Singletonb getSingleton(String name) {
		if (s == null) {//Ч�ʣ�ֻҪ�ж�һ��
			synchronized ("lock") {//�������̰߳�ȫ
				if (s == null) {
					s = new Singletonb(name);
				}
			}
		}
		return s;
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