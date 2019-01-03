package Algorithm.Matrix;

public class ReverseSentence {
	public String ReverseSentence(String str) {
		if(str.trim().length() == 0)
            return str;
        String[] strs=str.split(" ");
        StringBuffer sb=new StringBuffer();
        for(int i=strs.length-1;i>=1;i--)
        {
            sb.append(strs[i]+" ");
        }
        sb.append(strs[0]);
        return sb.toString();
	}
}
