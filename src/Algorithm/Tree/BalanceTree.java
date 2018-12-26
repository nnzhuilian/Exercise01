package Algorithm.Tree;

public class BalanceTree {
	public boolean IsBalanced_Solution(TreeNode root) {
        if(IsBalance(root)[0]==1){
            return true;
        }
        return false;
    }
    public int[] IsBalance(TreeNode root){
        if(root==null){
            return new int[]{1,0};
        }
        int[] temp=new int[2];
        int[] ld=IsBalance(root.left);
        int[] rd=IsBalance(root.right);
        if((ld[0]+rd[0])==2){
            if((ld[1]-rd[1])<=1&&(ld[1]-rd[1])>=-1){
                temp[0]=1;
            }
        }
        temp[1]=ld[1]>=rd[1]?ld[1]+1:rd[1]+1;
        return temp;
    }
}
