package Algorithm.Matrix;

public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if(str.length()<2){
            return str;
        }
        if(n>str.length()){
            n=n%str.length();
        }
        String str1=str.substring(n);
        String str2=str.substring(0,n);
        return str1+str2;
    }
    public static void main(String[] args) {//×Ö·û´®×¢Òâµã¼ûcsdn
		String a="1234567";
		System.out.println(a.substring(6));
	}
}
