package sortex;

import java.util.Arrays;

public class zhijie {
	public static void sort(int a[]){
		for(int j=1;j<a.length;j++){
			for(int i=0;i<j;i++){
				if(a[j]<a[i]){
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
	}
	public static void main(String[] args){
		int a[]={5,8,4,1,5};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
