package BasicJava.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect {

	private static void re1() throws Exception{
		Class cla1=Class.forName("reflection.Person");
		/*Constructor[] cons=cla1.getConstructors();
		for(Constructor con : cons){
			System.out.println(con);
		}*/
		/*Constructor con=cla1.getConstructor(String.class);
		Person p=(Person)con.newInstance("≈÷ª¢");
		System.out.println(p);*/
		Constructor con1=cla1.getConstructor();
		Person p1=(Person)con1.newInstance();
		System.out.println(p1);
		/*Method[] m=cla1.getDeclaredMethods();
		for(Method M:m){
			System.out.println(M);
		}*/
		Method m_p=cla1.getDeclaredMethod("check2");
		m_p.setAccessible(true);
		m_p.invoke(p1);
		Field field=cla1.getDeclaredField("age");
		field.setAccessible(true);
		field.set(p1, 10);
		System.out.println(p1);
	}
	public static void main(String[] args) throws Exception {
		re1();// TODO Auto-generated method stub
	}
}
