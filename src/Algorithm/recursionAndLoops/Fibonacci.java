package Algorithm.recursionAndLoops;

public class Fibonacci {

	public int Fibonacci1(int n) {//�ݹ�ʵ��
        if(n==1||n==0){
            return n;
        }
        return Fibonacci1(n-1)+Fibonacci1(n-2);
    }
	 public int Fibonacci2(int n) {//��ѭ��ʵ��
	        if(n==0||n==1){
	            return n;
	        }
	        int i=2;
	        int f1=0;
	        int f2=1;
	        while(i<=n){
	            int temp=f2;
	            f2=f1+f2;
	            f1=temp;
	            i++;
	        }
	        return f2;
	    }
	 public int Fibonacci3(int n) {//�ο�����
	        if(n == 0 || n == 1)
	            return n;
	        int fn1 = 0;
	        int fn2 = 1;
	        for(int i=2; i<=n; i++){
	            fn2 += fn1;
	            fn1 = fn2 - fn1;
	        }
	        return fn2;
	    }

}
