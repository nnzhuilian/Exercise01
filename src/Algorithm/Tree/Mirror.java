package Algorithm.Tree;

public class Mirror {
	public void Mirror1(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)){
            return ;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        Mirror1(root.left);
        Mirror1(root.right);
    }
}
