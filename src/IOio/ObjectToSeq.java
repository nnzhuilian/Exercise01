package IOio;
import java.io.*;
public class ObjectToSeq {
	public static void writeObject()throws IOException{
		FileOutputStream fo=new FileOutputStream("D:\\hxh.txt",true);
		ObjectOutputStream bo=new ObjectOutputStream(fo);
		bo.writeObject(new Cat());
		bo.close();
	}
	public static void main(String[] args) throws IOException{
		writeObject();
	}
}
class Cat implements Serializable{
	int size;
	int age;
	public int getAge(){
		return age;
	}
	public int getSize() {
		return size;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
