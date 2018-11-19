package BasicJava.SocketDemo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class TCPSocket_Server extends Thread{
	Socket socket;
	static File file=new File("C:\\HXH软件\\pro.properties");
	public TCPSocket_Server(Socket socket) throws IOException {
		this.socket=socket;// TODO Auto-generated constructor stub	
	}
	static{
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void run(){
		try {
			OutputStreamWriter output=new OutputStreamWriter(socket.getOutputStream());
		    BufferedReader sbr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    String info=sbr.readLine();
		    String[] datas=info.split(" ");
		    String option=datas[0];
		    String user=datas[1];
		    String password=datas[2];
		    Properties pro=new Properties(); 
		    pro.load(new FileReader(file));
		    if("a".equalsIgnoreCase(option)){
		    	
				if (!pro.containsKey(user)) {
					pro.setProperty(user, password);
					output.write("注册成功！\r\n");
				}
				else{
					output.write("用户名已存在！\r\n");
				}
		    }
		    else if("b".equalsIgnoreCase(option)){
		    	if(pro.containsKey(user)){
		    		String pw=pro.getProperty(user);
		    		if(pw.equals(password)){
		    			output.write("登陆成功！\r\n");
		    		}else{
		    			output.write("密码错误！\r\n");
		    		}
		    	}else{
		    		output.write("用户名不存在！\r\n");
		    	}
		    }
		    output.flush();
		    pro.store(new FileWriter(file), "pro");		    	    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) throws IOException {
		ServerSocket serversocket=new ServerSocket(9090);
		while(true){
			Socket socket=serversocket.accept();
			new TCPSocket_Server(socket).run();
		}
	}
}
