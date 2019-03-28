import java.util.*;
public class Main{
  public static void main(String args[]){
    Scanner cin=new Scanner(System.in);    
    int k=0;
    int a,b,c;
    String d;
    a=cin.nextInt();
    b=cin.nextInt();
    c=cin.nextInt();
    d=cin.nextLine();
    String[] mutex=new String[a];
    for(int i=0;i<a;i++){
    	mutex[i]=cin.nextLine();
    }
    for(int i=0;i<a-2;i++){
    	for(int j=1;j<b-1;j++){
    		int md=mutex[i].charAt(j);
    		if(mutex[i].charAt(j)==mutex[i+1].charAt(j-1)&&mutex[i].charAt(j)==mutex[i+1].charAt(j)&&mutex[i].charAt(j)==mutex[i+1].charAt(j+1)&&mutex[i].charAt(j)==mutex[i+2].charAt(j)){
    			k++;
    		}
    	}
    }
    System.out.println(k);
  }
  
}