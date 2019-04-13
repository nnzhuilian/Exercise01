package IOio;
import java.io.*;

public class IOliu {
	public static void write() throws Exception{
		File file=new File("D:\\hxh.txt");
		FileOutputStream fo=new FileOutputStream(file);
		byte[] bt="hahahahahaaha".getBytes();
		fo.write(bt);
		fo.close();
	}
	public static void copy() throws Exception{
		File file=new File("D:\\hxh2.txt");
		FileOutputStream fo=new FileOutputStream(file);
		BufferedOutputStream bo=new BufferedOutputStream(fo);
		FileInputStream fi=new FileInputStream("D:\\hxh.txt");
		BufferedInputStream bi=new BufferedInputStream(fi);
		int len=0;
		while((len=bi.read())!=-1){//len·µ»ØascalÂë£¿£¿
			System.out.println(len);
			bo.write(len);
		}
		bi.close();
		fi.close();
	}
	public static void copyf() throws Exception{
		File file=new File("D:\\hxh2.txt");
		Reader reader=new FileReader("D:\\hxh.txt");
		Writer writer=new FileWriter(file);
		BufferedReader fi=new BufferedReader(reader);
		BufferedWriter bi=new BufferedWriter(writer);
		String len;
		while((len=fi.readLine())!=null){//len·µ»ØascalÂë£¿£¿
			System.out.println(len);
			bi.write(len);
		}
		bi.close();
		fi.close();
	}
	public static void read() throws Exception{
		File file=new File("D:\\hxh.txt");
		FileInputStream fi=new FileInputStream(file);
		byte[] bt=new byte[1024];
		int len=fi.read(bt);
		String buffer=new String(bt,0,len);
		System.out.println(buffer);
		fi.close();
	}
	
    public static void main (String[] args)throws Exception {
		copyf();
	}
}