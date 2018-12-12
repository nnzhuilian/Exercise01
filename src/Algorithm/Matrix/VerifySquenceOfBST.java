package Algorithm.Matrix;

public class VerifySquenceOfBST {
	public  boolean VerifySquenceOfBST1(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        if(sequence.length==1){
            return true;
        }
        return VerifySequenceOfBST1(sequence,0,sequence.length-1);
    }
    public  boolean VerifySequenceOfBST1(int[] sequence,int first,int last){
        if(first>=last){//注意边界
            return true;
        }
        int mid=last;//注意m的边界，很容易造成死循环
        for(int i=first;i<last;i++){
            if(sequence[i]>sequence[last]){
                mid=i;
                break;
            }
        }
        return isMore(sequence,mid,last)&&VerifySequenceOfBST1(sequence,first,mid-1)&&VerifySequenceOfBST1(sequence,mid,last-1);
    }
    public  boolean isMore(int[] sequence,int first,int last){
        for(int i=first;i<last;i++){
            if(sequence[i]<sequence[last]){
                return false;
            }
        }
        return true;
    }
 ///////////////////////////////-参考代码-//////////////////////////////////////////   
    public boolean VerifySquenceOfBST2(int [] sequence) {
        if(sequence.length == 0)
            return false;
        if(sequence.length == 1)
            return true;
        return judge(sequence, 0, sequence.length-1);
    }
    public boolean judge(int [] sequence, int start, int root){
        if(start >= root)
            return true;
        int i = start;
        while(i < root && sequence[i] < sequence[root])
            i++;
        for(int j=i; j<root; j++){
            if(sequence[j]<sequence[root])
                return false;
        }
        return (judge(sequence, start, i-1)) && (judge(sequence, i, root-1));
    }
/////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={4,6,7,5};
		VerifySquenceOfBST v=new VerifySquenceOfBST();
		System.out.println(v.VerifySquenceOfBST1(a));
	}

}
