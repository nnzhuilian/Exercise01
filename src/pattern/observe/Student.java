package pattern.observe;

public class Student implements Personaction{

	@Override
	public void notifyWeather(String weather) {
		switch(weather){
		case "Çç":System.out.println("qin");break;
		case "Óê":System.out.println("yu");break;
		case "Îíö²":System.out.println("wumai");break;
		case "Ñ©":System.out.println("xue");break;
		case "¶àÔÆ":System.out.println("duoyun");break;
		}
		
	}

}
