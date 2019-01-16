package Algorithm.Tree;

import java.util.Stack;

public class isSymmetrical {
	//µÝ¹é
	   boolean isSymmetrical(TreeNode pRoot)
	    {
	        if(pRoot==null){
	            return true;
	        }
	        return isSymmetrical(pRoot.left,pRoot.right);
	    }
	    boolean isSymmetrical(TreeNode left,TreeNode right){
	        if(left==null&&right==null){
	            return true;
	        }
	        if(left==null||right==null){
	            return false;
	        }
	        if(left.val==right.val){
	            return isSymmetrical(left.left,right.right)&&isSymmetrical(left.right,right.left);
	        }
	        return false;
	    }
	    //Ñ­»·
	    boolean isSymmetrical1(TreeNode pRoot)
	    {
	        if(pRoot == null)
	            return true;
	        Stack<TreeNode> s = new Stack<TreeNode>();
	        s.push(pRoot.left);
	        s.push(pRoot.right);
	        while(!s.isEmpty()){
	            TreeNode right = s.pop();
	            TreeNode left = s.pop();
	            if(right == null && left == null)
	                continue;
	            if(right == null || left == null)
	                return false;
	            if(right.val != left.val)
	                return false;
	            s.push(left.left);
	            s.push(right.right);
	            s.push(left.right);
	            s.push(right.left);
	        }
	        return true;
	    }

}
