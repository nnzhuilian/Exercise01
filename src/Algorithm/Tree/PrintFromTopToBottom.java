package Algorithm.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottom {// 使用队列实现
	
	public ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		if (root == null) {
			return arr;
		}
		Queue<TreeNode> tr = new LinkedList<TreeNode>();
		tr.offer(root);
		TreeNode cur = null;
		while (!tr.isEmpty()) {
			cur = tr.poll();
			arr.add(cur.val);
			if (cur.left != null) {
				tr.offer(cur.left);
			}
			if (cur.right != null) {
				tr.offer(cur.right);
			}
		}
		return arr;
	}

	public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {// 用ArrayList实现的方法，效率较低
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<TreeNode> queue = new ArrayList<>();
		if (root == null) {
			return list;
		}
		queue.add(root);
		while (queue.size() != 0) {
			TreeNode temp = queue.remove(0);
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
			list.add(temp.val);
		}
		return list;
	}
}
