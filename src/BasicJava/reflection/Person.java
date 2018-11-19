package BasicJava.reflection;

public class Person {
	String name;
	int age;
	public Person(){}
	public Person(String name){
		this.name=name;
	}
	void check1(){
		System.out.println("haha");
	}
	private void check2(){
		System.out.println("haha");
	}
	public String toString(){
		return "Ãû×Ö£º"+name+",ÄêÁä£º"+age;		
	}
	
}
