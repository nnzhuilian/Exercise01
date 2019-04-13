package IOio;

import java.io.*;

public class decrator {
	public static void main(String[] args) throws IOException{
		Reader in=new FileReader("D:\\hxh.txt");
		BufferedReader br=new dotBufferedReader(new quoteBufferedReader(new BufferedReader(in)));
		String line;
		while((line=br.readLine())!=null){
			System.out.println(line);
		}
		br.close();
	}
}
class quoteBufferedReader extends BufferedReader{
	private BufferedReader bufferedreader;
	public quoteBufferedReader(BufferedReader bufferedreader){
		super(bufferedreader);
		this.bufferedreader=bufferedreader;
	}
	public String readLine() throws IOException{
		String line=bufferedreader.readLine();
		if(line!=null)
			return line+"\"";
		return null;
	}
}
class dotBufferedReader extends BufferedReader{
	private BufferedReader bufferedreader;
	public dotBufferedReader(BufferedReader bufferedreader){
		super(bufferedreader);
		this.bufferedreader=bufferedreader;
	}
	public String readLine() throws IOException{
		String line=bufferedreader.readLine();
		if(line!=null)
			return line+".";
		return null;
	}
}

