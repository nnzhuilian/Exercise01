package Algorithm.Tree;

import java.util.ArrayList;
import java.util.Stack;

public class ZPrint {
	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> arrs = new ArrayList<ArrayList<Integer>>();//基于队列的。
		if (pRoot == null)
			return arrs;
		ArrayList<TreeNode> t1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
		temp.add(pRoot);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(pRoot.val);
		arrs.add(arr);
		boolean flag = true;
		while (!temp.isEmpty()) {
			TreeNode cur = temp.get(0);
			temp.remove(0);
			if (cur != null && (!(cur.left == null && cur.right == null))) {
				t1.add(cur.left);
				t1.add(cur.right);
			}
			if (temp.isEmpty()) {
				if (t1.isEmpty()) {
					break;
				}
				arr = new ArrayList<Integer>();
				if (flag == true) {
					for (int i = t1.size() - 1; i >= 0; i--) {
						if (t1.get(i) != null) {
							arr.add(t1.get(i).val);
						}
					}
				} else {
					for (int i = 0; i < t1.size(); i++) {
						if (t1.get(i) != null) {
							arr.add(t1.get(i).val);
						}
					}
				}
				arrs.add(arr);
				temp = t1;
				t1 = new ArrayList<TreeNode>();
				flag = !flag;
			}
		}
		return arrs;
	}
    public ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {//利用两个栈
        ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        int flag = 1;
        if(pRoot == null)
            return res;
        s2.push(pRoot);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(flag % 2 != 0){
                while(!s2.isEmpty()){
                    TreeNode node = s2.pop();
                    temp.add(node.val);
                    if(node.left != null){
                        s1.push(node.left);
                    }
                    if(node.right != null){
                        s1.push(node.right);
                    }
                }
            }
            if(flag % 2 == 0){
                while(!s1.isEmpty()){
                    TreeNode node = s1.pop();
                    temp.add(node.val);
                    if(node.right != null){
                        s2.push(node.right);
                    }
                    if(node.left != null){
                        s2.push(node.left);
                    }
                }
            }
            res.add(new ArrayList<Integer>(temp));
            temp.clear();
            flag ++;
        }
        return res;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		ArrayList<ArrayList<Integer>> arrs = Print(root);
	}

}
