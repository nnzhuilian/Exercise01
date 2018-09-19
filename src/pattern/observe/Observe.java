package pattern.observe;

public class Observe {

	public static void main(String[] args) {
		WeatherStation ws=new WeatherStation();
		Student s1=new Student();
		Student s2=new Student();
		ws.add(s1);
		ws.add(s2);
		ws.startt();
	}

}
