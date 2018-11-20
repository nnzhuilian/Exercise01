package Algorithm.Matrix;

public class ReplacePause {
	public String replace1(StringBuffer str){//通过编译
		if(str==null){
			return null;
		}
		StringBuffer res = new StringBuffer();
        int len = str.length();
        for(int i = 0; i <len ; i++){
            if(str.charAt(i) == ' ')
                res.append("%20");
            else
                res.append(str.charAt(i));
        }
        return res.toString();
	}
	public String replace(StringBuffer str){//通过
		String a=str.toString();
		String s=a.replaceAll(" ", "%20");
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReplacePause rp=new ReplacePause();
		StringBuffer a=new StringBuffer("We are the!");
		System.out.println(rp.replace(a));
	}

}
