package Algorithm.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {
    public int TreeDepth1(TreeNode root) {//递归法
        if(root==null){
            return 0;
        }
        int ld=TreeDepth1(root.left);
        int rd=TreeDepth1(root.right);
        return ld>=rd?ld+1:rd+1;
    }
    public int TreeDepth(TreeNode root) {//层次遍历求，用队列
        if(root == null)
            return 0;
        int deep = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int start = 0, end = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            start ++;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            if(start == end){
                end = queue.size();
                start = 0;
                deep ++;
            }
        }
        return deep;
    }
}
