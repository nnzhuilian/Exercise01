package Algorithm.Matrix;

public class GetUglyNumber_Solution {
	public static int GetUglyNumber_Solution1(int index) {
		if (index < 1) {
			return 0;
		}
		if (index == 1) {
			return 1;
		}
		int[] arr = new int[index];
		int[][] temp = { { 0, 1 }, { 0, 1 }, { 0, 1 } };
		for (int i = 0; i < index; i++) {
			arr[i] = Math.min(temp[0][1], Math.min(temp[1][1], temp[2][1]));
			if (arr[i] == temp[0][1])
				temp[0][1] = arr[temp[0][0]++] * 2;
			if (arr[i] == temp[1][1])
				temp[1][1] = arr[temp[1][0]++] * 3;
			if (arr[i] == temp[2][1])
				temp[2][1] = arr[temp[2][0]++] * 5;
		}
		return arr[index - 1];
	}

	public int GetUglyNumber_Solution2(int index) {// ±ê×¼´úÂë
		if (index <= 0)
			return 0;
		if (index == 1)
			return 1;
		int t2 = 0, t3 = 0, t5 = 0;
		int[] res = new int[index];
		res[0] = 1;
		for (int i = 1; i < index; i++) {
			res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
			if (res[i] == res[t2] * 2)
				t2++;
			if (res[i] == res[t3] * 3)
				t3++;
			if (res[i] == res[t5] * 5)
				t5++;
		}
		return res[index - 1];
	}

	public static void main(String[] args) {
		int a = GetUglyNumber_Solution1(2);
	}
}
