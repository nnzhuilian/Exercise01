package Algorithm.Matrix;

class FindIntegerInSortedMatrix1 {// 自己写的 pass
	public boolean find(int[][] a, int b) {
		if (a == null) {
			return false;
		}
		int offset = a[0].length - 1;
		for (int i = 0; i < a.length; i++) {
			for (int j = offset; j >= 0; j--) {
				if (a[i][j] == b) {
					return true;
				}
				if (a[i][j] > b) {
					offset = j - 1;
				}
				if (a[i][j] < b) {
					break;
				}
			}
		}
		return false;
	}
}

class FindIntegerInSortedMatrix2 {// 书上的 pass
	public static boolean find(int[][] array, int number) {
		if (array == null) {
			return false;
		}
		int column = array[0].length - 1;
		int row = 0;
		while (row < array.length && column >= 0) {
			if (array[row][column] == number) {
				return true;
			}
			if (array[row][column] > number) {
				column--;
			} else {
				row++;
			}
		}
		return false;
	}
}

public class FindIntegerInSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = new int[][] { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		FindIntegerInSortedMatrix1 f = new FindIntegerInSortedMatrix1();
		System.out.println(f.find(a, 0));
	}

}
