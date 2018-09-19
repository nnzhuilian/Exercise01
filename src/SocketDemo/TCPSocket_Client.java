package SocketDemo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TCPSocket_Client {

	public static void getwrite(Socket socket,BufferedReader br,String option) throws IOException{
		
		OutputStreamWriter outputstream=new OutputStreamWriter(socket.getOutputStream());
		System.out.println("请输入用户名：");
		String user=br.readLine();
		System.out.println("请输入密码：");
		String password=br.readLine();
		String info=option+" "+user+" "+password+"\r\n";
		outputstream.write(info);
		outputstream.flush();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket socket=new Socket(InetAddress.getByName("127.0.0.1"), 9090);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader sbr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String option=br.readLine();
		getwrite(socket, br, option);
		String recall=sbr.readLine();
		System.out.println(recall);						
	}

}
