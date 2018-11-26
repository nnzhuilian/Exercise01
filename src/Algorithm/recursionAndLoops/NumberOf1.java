package Algorithm.recursionAndLoops;

public class NumberOf1 {
	public static int NumberOf11(int n) {//所有数的flag判断都要循环32次
        int count=0;
        int flag=1;
        while(flag!=0){
        	if((n&flag)!=0){
        		count++;
        	}
        	flag=flag<<1;
        }
		return count;
    }
	public int NumberOf12(int n) {//只需循环n次
        int count=0;
		while(n!=0){
       	n=n&(n-1);
           count++;
       }
		return count;
   }
	public static void main(String args[]){
		System.out.println(NumberOf11(-1743));
	}

}
