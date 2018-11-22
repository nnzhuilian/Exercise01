package Algorithm.sortex;

import java.util.Arrays;

public class StraightSelectSorting {
	public static void sort(int a[]){
		if(a.length<=1){
			return;
		}
		for(int i=0;i<a.length;i++){
			int minindex=i;//无序区的最小数据数组下标
			for(int j=i+1;j<a.length;j++){//在无序区中找到最小数据并保存其数组下标
				if(a[j]<a[minindex]){
					minindex=j;
				}
			}
			//将最小元素放到本次循环的前端
			int temp=a[i];
			a[i]=a[minindex];
			a[minindex]=temp;
		}
	}
	public static void main(String[] args){
		int a[]={5,8,4,1,5};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
