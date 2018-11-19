package BasicJava.Stringex;

public class SplitTest {
	public String exchange(String st,String exc){
		String as[];
		as=st.split("0");
		System.out.println("//////----"+st+"----////////");
		System.out.println(as);
		for(String a:as){
			System.out.println(a);
		}
		StringBuffer sb=new StringBuffer();
		if(st.charAt(0)=='0'){
			sb.append(exc);
		}
		for(int i=0;i<as.length-1;i++){
			sb.append(as[i]+exc);
		}
		if(st.charAt(st.length()-1)=='0'){
			sb.append(as[as.length-1]+exc);
		}else{
			sb.append(as[as.length-1]);
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplitTest ex=new SplitTest();
		try{
			System.out.println(ex.exchange("We0are0human!", "%"));
		}
		catch(Exception e){
			System.out.println("wrong");
		}
		try{
			System.out.println(ex.exchange("0We0are0human!0", "%"));
		}
		catch(Exception e){
			System.out.println("wrong");
		}
		try{
			System.out.println(ex.exchange("0", "%"));
		}
		catch(Exception e){
			System.out.println("wrong");
		}
		try{
			System.out.println(ex.exchange("00", "%"));
		}
		catch(Exception e){
			System.out.println("wrong");
		}
		try{
			System.out.println(ex.exchange("000", "%"));
		}
		catch(Exception e){
			System.out.println("wrong");
		}
	}

}
