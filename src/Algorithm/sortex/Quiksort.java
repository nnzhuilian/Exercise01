package Algorithm.sortex;

public class Quiksort {

	public static void sort(int a[]){
		if(a.length<2||a==null){
			return;
		}
		sort(a, 0, a.length-1);
	}
	public static void sort(int a[],int L,int R){
		if(L>=R) return;
		int rI=(int)(Math.random()*(R-L+1));//随机选取一个数
		swap(a,L+rI,R);
		//System.out.println(rI);
		int p[]=partition(a,L,R);
		sort(a,L,p[0]);
		sort(a,p[1],R);
	}
	public static int[] partition(int a[], int L, int R) {
		int less = L - 1;//表示所有小于比较位a[r]的最后一位
		int more = R;//表示所有大于比较位a[r]的最前一位
		int index = L;//表示需要比较的位置
		int p[]=new int[2];
		while (index < more) {
			if (a[index] == a[R]) {//a[R]为用于比较的数
				index++;//若等于，则不动
			}
			else if (a[index] < a[R]) {//若小于，则当前数与最后的小于数的后一位（该数等于or就是当前数）交换
				swap(a, ++less, index++);
			}
			else if (a[index] > a[R]) {//若大于，当前数与more前一个数交换，当前比较数下表不变（换回来的是没判断过的数）
				swap(a, --more, index);
			}
		}
		swap(a,more,R);
		p[0]=less;
		p[1]=more+1;//把R排出去
		return p;
	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int a[]=new int[]{2,5,3,6,1,4,6,9,2,3};
		//partition(a,0,9,4);// TODO Auto-generated method stub
		sort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
		}

	}

}
