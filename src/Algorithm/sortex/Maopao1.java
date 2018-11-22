package Algorithm.sortex;

public class Maopao1 {
	public static void sort(int a[]){
		if(a.length<=1){
			return;
		}
		 for(int i =0;i<a.length-1;i++) { 
	            for(int j=0;j<a.length-i-1;j++) {//-1ÎªÁË·ÀÖ¹Òç³ö
	                if(a[j]>a[j+1]) {
	                    int temp = a[j];	                     
	                    a[j]=a[j+1];	                     
	                    a[j+1]=temp;
	            }
	            }    
	        }
	}
	public static void main(String[] args) {
		int a[]={5,8,4,1,5};
		sort(a);
	}
}

