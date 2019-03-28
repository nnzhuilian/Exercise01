package Algorithm.Matrix;

public class movingCount {
	/*���ݷ�����(0,0)��ʼ�ߣ�ÿ�ɹ���һ����һ��flag�����ǵ�ǰλ��Ϊ1��Ȼ��ӵ�ǰλ�����ĸ�����̽����
	����1 + 4 �������̽��ֵ֮�͡�*/
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
