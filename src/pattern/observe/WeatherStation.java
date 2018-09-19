package pattern.observe;

import java.util.ArrayList;
import java.util.Random;

public class WeatherStation {
	String weather;
	String[] weathers={"晴","雨","多云","雾霾","雪"};
	ArrayList<Personaction> list=new ArrayList<Personaction>();
	public void weathergeneration(){		
		Random random=new Random();
		int index=random.nextInt(weathers.length);
		weather=weathers[index];
		System.out.println("当前天气是："+weather);
	}
	public void add(Personaction e){
		list.add(e);
	}
	public void startt(){
		while(true){
			weathergeneration();
			for(Personaction lis:list){
				lis.notifyWeather(weather);
			}
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}			
			
		}
	}
	public static void main(String[] args){
		new WeatherStation().startt();
	}

}
