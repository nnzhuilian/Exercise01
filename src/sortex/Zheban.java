package sortex;

public class Zheban {
	public static int find(int a[], int b) {
		int fp = 0;
		int lp = a.length - 1;
		int mid = (fp + lp) / 2;
		while (true) {
			if (b < a[mid]) {
				lp = mid;
				mid = (fp + lp) / 2;
			} else if (b > a[mid]) {
				fp = mid;
				mid = (fp + lp) / 2;
			} else if (b == a[mid]) {
				return mid+1;
			}
			if (lp <= fp) {
				return -1;
			}
		}
	}

	public static int find(int a[], int b, int fp, int lp) {
		int mid = (fp + lp) / 2;
		if (lp < fp) {
			return -1;
		}
		if (b == a[mid]) {
			return mid + 1;
		} else if (b > a[mid]) {
			return find(a, b, mid+1, lp);
		} else if (b < a[mid]) {
			return find(a, b, fp, mid-1);
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 4, 5, 8 };
		int b = 5;
		System.out.println(find(a, b, 0, a.length - 1));//µİ¹é
		System.out.println(find(a, b));//ÆÕÍ¨
	}

}
