package Algorithm.Matrix;

public class hasPath {
    public boolean hasPath1(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix==null||matrix.length==0||str==null||str.length==0){
            return false;
        }
        int flag[][]=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(search(matrix,rows,cols,i,j,str,0,flag)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean search(char[] matrix,int rows,int cols,int i,int j,char[] str,int index,int[][] flag){
        int p=i*cols+j;
        if(index>=str.length){
            return true;
        }
        if((i<0||j<0||i>=rows||j>=cols||flag[i][j]==1||str[index]!=matrix[p])&&index<str.length){
            return false;
        }
        flag[i][j]=1;
        if(search(matrix,rows,cols,i-1,j,str,index+1,flag)
            ||search(matrix,rows,cols,i,j-1,str,index+1,flag)
            ||search(matrix,rows,cols,i+1,j,str,index+1,flag)
            ||search(matrix,rows,cols,i,j+1,str,index+1,flag)){
            return true;
        }
        flag[i][j]=0;
        return false;
    }


}
