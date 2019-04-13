package Algorithm.Matrix;

public class PrintMaxN {
	public static void print1(int n,String s){
		if(n<=0){
    		int index=-1;
    		for(int i=0;i<s.length();i++){
    			if(s.charAt(i)!='0'){
    				index=i;
    				break;
    			}	
    		}
    		if(index==-1){
    			return;
    		}
    		s=s.substring(index);
    		System.out.println(s);
    		return;
    	}
		for(int i=0;i<10;i++){
			String temp=s+i;
			print1(n-1,temp);
		}
	}
	public static void print(int n) {
		if (n < 1) {
			System.out.println(0);
			return;
		}
		char a[] = new char[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = '0';
		}
		while (true) {
			a[a.length - 1]++;
			for (int i = a.length - 1; i >= 0; i--) {
				if (a[0] > '9') {
					break;
				}
				if (a[i] > '9') {
					a[i - 1]++;
					a[i] = '0';
				} else {
					break;
				}
			}
			if (a[0] > '9') {
				break;
			}
			int flag = 0;
			for (int i = 0; i < a.length; i++) {
				if ((a[i] == '0') && (flag == 0)) {
					continue;
				}
				System.out.print(a[i]);
				flag = 1;
			}
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print1(2,"");

	}

}
