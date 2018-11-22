package Algorithm.sortex;

public class MergeSort {//该思想可用于解小和问题，逆序对问题
	/////////////////////////-归并排序-/////////////////////////////
	public static void gb(int a[]){
		if(a.length<2||a==null){
			return;
		}
		gb(a,0,a.length-1);//要注意边界
	}
	public static void gb(int a[], int L, int R) {
		if(R==L) return;//递归一定要判断返回，不然出错
		int mid = L + ((R -L) >> 1);//安全，不溢出
		gb(a, L, mid);
		gb(a, mid + 1, R);
		merge(a, L, R, mid);
	}
	public static void merge(int a[], int L, int R, int mid) {
		int help[] = new int[R - L + 1];//引入help数组
		int p1 = L;
		int p2 = mid + 1;
		int i = 0;
		while ((p1 <= mid) && (p2 <= R)) {
			help[i++] = a[p1] < a[p2] ? a[p1++] : a[p2++];
		}

		while (p2 <= R) {
			help[i++] = a[p2++];
		}

		while (p1 <= mid) {
			help[i++] = a[p1++];
		}

		for (int j = 0; j < help.length; j++) {
			a[L + j] = help[j];
		}
	}
//////////////////////////////-小和问题-///////////////////////////////
	public static int xh(int a[]){
		if(a.length<2||a==null){
			return 0;
		}
		return xh(a,0,a.length-1);//要注意边界
	}
	public static int xh(int a[], int L, int R) {
		if(R==L) return 0;
		int mid = L + ((R -L) >> 1);
		return xh(a, L, mid)+xh(a, mid + 1, R)+Xiaohe(a, L, R, mid);
	}
	public static int Xiaohe(int a[], int L, int R, int mid) {
		int help[] = new int[R - L + 1];
		int p1 = L;
		int p2 = mid + 1;
		int i = 0;
		int res=0;
		while ((p1 <= mid) && (p2 <= R)) {
			res+=a[p1]<a[p2]?a[p1]*(R-p2+1):0;
			help[i++] = a[p1] > a[p2] ? a[p1++] : a[p2++];
		}

		while (p2 <= R) {
			help[i++] = a[p2++];
		}

		while (p1 <= mid) {
			help[i++] = a[p1++];
		}

		for (int j = 0; j < help.length; j++) {
			a[L + j] = help[j];
		}
		return res;
	}

	
	public static void main(String[] args) {
		int res=0;
		int a[]=new int[]{4,2,7,3,1};
		System.out.println(xh(a));
		gb(a);// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

}
