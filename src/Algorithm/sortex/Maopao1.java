package Algorithm.sortex;

import java.util.Arrays;

public class Maopao1 {
	public static void sort(int a[]){
		for(int j=a.length-1;j>0;j--){
			for(int i=0;i<j;i++){
				if(a[i]>a[i+1]){
					int temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
				}
			}
			System.out.println(Arrays.toString(a));
		}
	}
	public static void main(String[] args) {
		int a[]={5,8,4,1,5};
		sort(a);
	}
}

