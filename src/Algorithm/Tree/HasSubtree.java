package Algorithm.Tree;

public class HasSubtree {
		/////////////////////////////////-my way-////////////////////////////
	    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
	        if(root1==null||root2==null){
	            return false;
	        }
	        if(root1.val==root2.val){
	            if(isSubTree(root1,root2))
	                return true;
	        }
	        return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
	    }
	    public boolean isSubTree(TreeNode root1,TreeNode root2){
	        if(root2==null)
	            return true;
	        if(root1==null)
	            return false;
	        if(root1.val==root2.val){
	            return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
	        }
	        return false;
	    }
	/////////////////////////////-标准-/////////////////////////////////
	/**
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	*/
	    public boolean HasSubtree2(TreeNode root1,TreeNode root2) {
	        if(root1 == null || root2 == null){
	            return false;
	        }
	        return IsSubtree2(root1, root2) || 
	               HasSubtree2(root1.left, root2) ||
	               HasSubtree2(root1.right, root2);
	    }
	    public boolean IsSubtree2(TreeNode root1, TreeNode root2){
	        //要先判断roo2, 不然{8,8,7,9,2,#,#,#,#,4,7},{8,9,2}这个测试用例通不过。
	        if(root2 == null)
	            return true;
	        if(root1 == null)
	            return false;
	        if(root1.val == root2.val){
	            return IsSubtree2(root1.left, root2.left) && 
	                IsSubtree2(root1.right, root2.right);
	        }else
	            return false;
	    }

}