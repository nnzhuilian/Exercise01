package Algorithm.sortex;

import java.util.Arrays;

public class StraightSelectSorting {
	public static void sort(int a[]){
		if(a.length<=1){
			return;
		}
		for(int i=0;i<a.length;i++){
			int minindex=i;//����������С���������±�
			for(int j=i+1;j<a.length;j++){//�����������ҵ���С���ݲ������������±�
				if(a[j]<a[minindex]){
					minindex=j;
				}
			}
			//����СԪ�طŵ�����ѭ����ǰ��
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
