package Algorithm.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CPrint {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
        if(pRoot == null)
            return res;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        layer.offer(pRoot);
        int start = 0, end = 1;
        while(!layer.isEmpty()){
            TreeNode node = layer.poll();
            temp.add(node.val);
            start ++;
            if(node.left != null)
                layer.add(node.left);
            if(node.right != null)
                layer.add(node.right);
            if(start == end){
                start = 0;
                res.add(temp);
                temp = new ArrayList<Integer>();
                end = layer.size();
            }
        }
        return res;
    }
}
