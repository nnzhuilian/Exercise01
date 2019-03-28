package Algorithm.Matrix;

import java.util.ArrayList;

public class printMatrix {
	public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        if(matrix.length==0)
          return arr;
        int start1=0;
        int start2=0;
        int end1=matrix[0].length-1;
        int end2=matrix.length-1;
        while(start1<end1&&start2<end2){
            int i=start1;
            int j=start2;
            while(i<end1)
                arr.add(matrix[j][i++]);
            while(j<end2)
                arr.add(matrix[j++][i]);
            while(i>start1)
                arr.add(matrix[j][i--]);
            while(j>start2)
                arr.add(matrix[j--][i]);
            start1++;
            start2++;
            end1--;
            end2--;
        }
        if(start1==end1){
            for(int i=start2;i<=end2;i++)
                arr.add(matrix[i][start1]);
        }
        else if(start2==end2){
            for(int i=start1;i<=end1;i++)
                arr.add(matrix[start2][i]);
        }
        return arr;
    }
	
	
	public ArrayList<Integer> printMatrix2(int [][] matrix) {//标准代码
		int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();

        if(row == 0 && col == 0)
            return res;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while(left <= right && top <= bottom){
            //上：从左到右
            for(int i=left; i<=right; i++)
                res.add(matrix[top][i]);
            //右：从上到下
            for(int i=top+1; i<=bottom; i++)
                res.add(matrix[i][right]);
            //下：从右到左
            if(top != bottom){
                //防止单行情况
                for(int i=right-1; i>=left; i--)
                    res.add(matrix[bottom][i]);
            }
            //左：从下到上
            if(left != right){
                //防止单列情况
                for(int i=bottom-1; i>top; i--)
                    res.add(matrix[i][left]);
            }
            left++; right--; top++; bottom--;
        }
        return res;
    }
}
