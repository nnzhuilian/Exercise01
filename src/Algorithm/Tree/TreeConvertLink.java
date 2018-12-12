package Algorithm.Tree;

public class TreeConvertLink {
	TreeNode head=null;
    TreeNode end=null;
    public TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree==null){
            return null;
        }
        subConvert(pRootOfTree);
        return head;
    }
    public void subConvert(TreeNode root){
        if(root==null){
            return;
        }
        subConvert(root.left);
       if(end==null){
           head=root;
           end=root;
       }else{
          end.right=root;
          root.left=end;
          end=root;
       }
        subConvert(root.right);
    }
}
