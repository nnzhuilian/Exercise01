package Algorithm.sortex;

public class Quiksort {

	public static void sort(int a[]){
		if(a.length<2||a==null){
			return;
		}
		sort(a, 0, a.length-1);
	}
	public static void sort(int a[],int L,int R){
		if(L>=R) return;//
		int rI=(int)(Math.random()*(R-L+1));
		swap(a,L+rI,R);
		//System.out.println(rI);
		int p[]=partition(a,L,R);
		sort(a,L,p[0]);
		sort(a,p[1],R);
	}
	public static int[] partition(int a[], int L, int R) {
		int less = L - 1;
		int more = R;
		int index = L;
		int p[]=new int[2];
		while (index < more) {
			if (a[index] == a[R]) {
				index++;
			}
			if (a[index] < a[R]) {
				swap(a, ++less, index++);
			}
			if (a[index] > a[R]) {
				swap(a, --more, index);
			}
		}
		swap(a,more,R);
		p[0]=less;
		p[1]=more;
		return p;
	}
	/*public static void partition(int a[], int L, int R, int num) {
		int less = L - 1;
		int more = R + 1;
		int index = L;
		while (index < more) {
			if (a[index] == num) {
				index++;
			}
			if (a[index] < num) {
				swap(a, ++less, index++);
			}
			if (a[index] > num) {
				swap(a, --more, index);
			}
		}
	}*/

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
