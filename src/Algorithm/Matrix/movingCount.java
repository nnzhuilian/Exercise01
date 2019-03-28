package Algorithm.Matrix;

public class movingCount {
	/*回溯法：从(0,0)开始走，每成功走一步用一个flag数组标记当前位置为1，然后从当前位置往四个方向探索，
	返回1 + 4 个方向的探索值之和。*/
	   public int movingCount(int threshold, int rows, int cols)
	    {
	        int[][] flag=new int[rows][cols];
	        return movingCount(threshold,rows,cols,0,0,flag);
	    }
	    public int movingCount(int threshold,int rows,int cols,int i,int j,int[][] flag){
	        if(i<0||j<0||i>=rows||j>=cols||(count(i)+count(j))>threshold||flag[i][j]!=0){
	            return 0;
	        }
	        flag[i][j]=1;
	        return 1+movingCount(threshold,rows,cols,i+1,j,flag)+
	            movingCount(threshold,rows,cols,i,j+1,flag)+
	            movingCount(threshold,rows,cols,i-1,j,flag)+
	            movingCount(threshold,rows,cols,i,j-1,flag);
	    }
	    public int count(int i){
	        int c=0;
	        while(i!=0){
	            c+=i%10;
	            i=i/10;
	        }
	        return c;
	    }

}
