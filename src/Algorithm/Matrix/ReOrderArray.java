package Algorithm.Matrix;

public class ReOrderArray {
	public void reOrderArray1(int[] array) {// 相对顺序不变的方法，和遍历两遍没差别,array=test,array是不会改变，必须一个个赋值
		if (array.length < 2) {
			return;
		}
		int[] temp = new int[array.length];
		int left = -1;
		int right = array.length;
		for (int i = 0; i < array.length; i++) {
			if ((array[i] % 2) == 0) {
				temp[--right] = array[i];
			} else {
				temp[++left] = array[i];
			}
		}
		for (int i = 0; i <= left; i++) {
			array[i] = temp[i];
		}
		int k = temp.length - 1;
		for (int i = right; i < array.length; i++) {
			array[i] = temp[k--];
		}
	}

	public void reOrderArray2(int[] array) {// 该方法相对顺序改变,这是利用快排的的思想
		if (array.length < 2) {
			return;
		}
		int left = -1;
		int right = array.length;
		int cur = 0;
		while (cur < right) {
			if (array[cur] % 2 == 0) {
				int temp = array[cur];
				array[cur] = array[--right];
				array[right] = temp;
			} else {
				array[++left] = array[cur++];
			}
		}
	}

	public static void reOrderArray3(int[] array) {// 利用类似外排的思想？两个指针，若碰偶奇则交换
		if (array.length < 2) {
			return;
		}
		int left = 0;
		int right = array.length - 1;
		while (left < right) {//注意边界
			if (array[left] % 2 == 0 && array[right % 2] == 1) {
				int temp = array[left];
				array[left++] = array[right];
				array[right--] = temp;
			} else if (array[left] % 2 == 0&& array[right]%2==0) {
				right--;
			} else if(array[right] % 2 == 1&& array[left]%2==1){
				left++;
			}else{
				right--;
				left++;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,2,3,4,5,6,7};
		reOrderArray3(a);
	}

}
