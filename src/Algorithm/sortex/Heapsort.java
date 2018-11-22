package Algorithm.sortex;

public class Heapsort {

	public static void sort(int a[]){
		if((a==null)||(a.length<2)){
			return;
		}
		for(int i=0;i<a.length;i++){
		HeapInsert(a,i);//���ɴ����
		}
		for(int i=a.length-1;i>0;i--){
			swap(a,i,0);
			Heapify(a,0,i);
		}
	}
	public static void HeapInsert(int a[], int index) {//�½ڵ���뵽�ѣ�ͬʱ���ϵ����Ĺ���
		while ((a[index] > a[(index - 1) / 2]) && (index > 0)) {//���ڵ�=���ӽڵ�-1��/2
			swap(a, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	public static void Heapify(int a[], int index, int size) {//�ڵ�ֵ��С�ˣ��ҵ�������������֮����
		int left =  1;
		while (left < size - 1) {
			int temp = ((a[left] > a[left + 1]) || (left + 1 == size - 1)) ? left : left + 1;
			if (a[temp] <= a[index])
				break;
			swap(a, index, temp);
			index = temp;
			left = index * 2 + 1;
		}
	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {
		int a[] = new int[]{7,4,5,2,6,10,8,3,1,9};// TODO Auto-generated method stub
		sort(a);
		print(a);

	}

}
