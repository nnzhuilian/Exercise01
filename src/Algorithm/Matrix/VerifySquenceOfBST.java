package Algorithm.Matrix;

public class VerifySquenceOfBST {
	public static boolean VerifySquenceOfBST1(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        if(sequence.length==1){
            return true;
        }
        return VerifySequenceOfBST1(sequence,0,sequence.length-1);
    }
    public static boolean VerifySequenceOfBST1(int[] sequence,int first,int last){
        if(first==last){
            return true;
        }
        int mid=last-1;
        for(int i=first;i<last;i++){
            if(sequence[i]>sequence[last]){
                mid=i;
                break;
            }
        }
        return isMore(sequence,mid,last)&VerifySequenceOfBST1(sequence,first,mid-1)&VerifySequenceOfBST1(sequence,mid,last-1);
    }
    public static boolean isMore(int[] sequence,int first,int last){
        for(int i=first;i<last;i++){
            if(sequence[i]<sequence[last]){
                return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={4,8,6,12,16,14,10};
		System.out.println(VerifySquenceOfBST1(a));
	}

}
