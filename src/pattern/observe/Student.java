package pattern.observe;

public class Student implements Personaction{

	@Override
	public void notifyWeather(String weather) {
		switch(weather){
		case "��":System.out.println("qin");break;
		case "��":System.out.println("yu");break;
		case "����":System.out.println("wumai");break;
		case "ѩ":System.out.println("xue");break;
		case "����":System.out.println("duoyun");break;
		}
		
	}

}
