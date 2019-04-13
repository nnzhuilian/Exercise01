import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        String s1=cin.next();
        String s2=cin.next();
        int cout=0;
        if(s1.length()==s2.length()){
        	for(int i=0;i<s1.length();i++){
        		if(s1.charAt(i)!=s2.charAt(i))
        			cout++;
        	}
        	System.out.println(cout);
        	return;
        }else{
        	System.out.println(find(s1,s2,0,0,0,s1.length(),s2.length()));
        }
    }
    public static int find(String s1,String s2,int cout,int i,int j,int s1l,int s2l){
    	if(i>=s1.length()||j>=s2.length()){
    		int c=Math.min(s2l, s1l)==s1l?s2l-s1l:s1l-s2l;
    		return cout+c;
    	}
    	if(s1.charAt(i)==s2.charAt(j)){
    		return find(s1,s2,cout,i+1,j+1,s1l,s2l);
    	}
    	if(s1.charAt(i)!=s2.charAt(i)){
    		return Math.min(Math.min(find(s1,s2,cout+1,i,j+1,s1l+1,s2l), find(s1,s2,cout+1,i+1,j,s1l,s2l+1)), find(s1,s2,cout+1,i+1,j+1,s1l,s2l));
    	}
    	return 0;
    }
}