package IOio.Properties;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class property {
	public static void loadfile() throws IOException{
		Properties properties=new Properties();
		FileInputStream fi=new FileInputStream("d:\\hxh.txt");
		properties.load(fi);
		Set<Entry<Object,Object>> set=properties.entrySet();
		Iterator<Entry<Object,Object>> itr=set.iterator();
		while(itr.hasNext()){
			Entry<Object,Object> next=itr.next();
			Object key=next.getKey();
			Object value=next.getValue();
			System.out.println(key+":"+value);
		}
		properties.setProperty("id", "0711");
		FileOutputStream fo=new FileOutputStream("d:\\hxh.txt");
		properties.store(fo,"myname");
	}
	public static void main(String args[])throws IOException{
		loadfile();
	}
}
