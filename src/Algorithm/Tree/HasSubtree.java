package Algorithm.Tree;

public class HasSubtree {
	public class Solution {
		/////////////////////////////////-my way-////////////////////////////
		public boolean HasSubtree(TreeNode root1, TreeNode root2) {
			if (root1 == null || root2 == null) {
				return false;
			}
			return findroot2(root1, root2);
		}

		public boolean findroot2(TreeNode root1, TreeNode root2) {
			boolean flag = false;
			if (root1 == null) {
				return false;
			}
			if (root1.val == root2.val) {
				flag = isSub(root1, root2);
				if (flag == true) {
					return flag;
				}
			}
			flag = findroot2(root1.left, root2);
			if (flag == true)
				return true;
			flag = findroot2(root1.right, root2);
			return flag;
		}

		public boolean isSub(TreeNode root1, TreeNode root2) {
			boolean flag1 = false;
			boolean flag2 = false;
			if (root1 == null && root2 != null) {
				return false;
			} else if (root2 == null) {
				return true;
			} else if (root2.val != root1.val) {
				return false;
			}
			if (root1.val == root2.val) {
				flag1 = isSub(root1.left, root2.left);
				flag2 = isSub(root1.right, root2.right);
				if (flag1 == true && flag2 == true) {
					return true;
				} else {
					return false;
				}
			}
			return false;
		}
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}