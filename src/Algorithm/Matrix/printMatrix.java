package Algorithm.Matrix;

import java.util.ArrayList;

public class printMatrix {

	public ArrayList<Integer> printMatrix1(int[][] matrix) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		if (matrix.length == 0) {
			return arr;
		}
		int start1 = 0;
		int start2 = 0;
		int end1 = matrix[0].length;
		int end2 = matrix.length;
		while (start1 < (end1 - 1) && start2 < (end2 - 1)) {
			int i = start1;
			int j = start2;
			while (i < end1) {
				arr.add(matrix[j][i++]);
			}
			i--;
			j++;
			while (j < end2) {
				arr.add(matrix[j++][i]);
			}
			j--;
			i--;
			while (i >= start1) {
				arr.add(matrix[j][i--]);
			}
			i++;
			j--;
			while (j > start2) {
				arr.add(matrix[j--][i]);
			}
			start1++;
			start2++;
			end1--;
			end2--;
		}
		if (start1 == (end1 - 1)) {
			for (int j = start2; j < end2; j++) {
				arr.add(matrix[j][start2]);
			}
		} else if (start2 == (end2 - 1)) {
			for (int i = start1; i < end1; i++) {
				arr.add(matrix[start2][i]);
			}
		}
		return arr;
	}
	
	
	public ArrayList<Integer> printMatrix2(int [][] matrix) {//��׼����
		int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();

        if(row == 0 && col == 0)
            return res;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while(left <= right && top <= bottom){
            //�ϣ�������
            for(int i=left; i<=right; i++)
                res.add(matrix[top][i]);
            //�ң����ϵ���
            for(int i=top+1; i<=bottom; i++)
                res.add(matrix[i][right]);
            //�£����ҵ���
            if(top != bottom){
                //��ֹ�������
                for(int i=right-1; i>=left; i--)
                    res.add(matrix[bottom][i]);
            }
            //�󣺴��µ���
            if(left != right){
                //��ֹ�������
                for(int i=bottom-1; i>top; i--)
                    res.add(matrix[i][left]);
            }
            left++; right--; top++; bottom--;
        }
        return res;
    }
}