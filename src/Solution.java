import java.util.Queue;
import java.util.LinkedList;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    /*String Serialize(TreeNode root) {
        if(root == null){
            return "#,";
        }
        StringBuffer res = new StringBuffer(root.val + ",");
        res.append(Serialize(root.left));
        res.append(Serialize(root.right));
        return res.toString();
    }
    TreeNode Deserialize(String str) {
        String [] res = str.split(",");
        Queue<String> queue = new LinkedList<String>();
        for(int i = 0; i < res.length; i++){
            queue.offer(res[i]);
        }
        return pre(queue);
    }
    TreeNode pre(Queue<String> queue){
        String val = queue.poll();
        if(val.equals("#"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = pre(queue);
        node.right = pre(queue);
        return node;
    }*/
    int i=-1;
    String Serialize(TreeNode root) {
        if(root==null)
            return "#,";
        return String.valueOf(root.val+",")+Serialize(root.left)+Serialize(root.right);
  }
    TreeNode Deserialize(String str) {
       if(str==null||str.length()==0)
           return null;
       String strs[]=str.split(",");
       return cons(strs);
  }
    TreeNode cons(String[] str){
        i++;
       if(str[i]=="#")
           return null;
        TreeNode troot=new TreeNode(Integer.parseInt(str[i]));
        troot.left=cons(str);
        troot.right=cons(str);
        return troot;
    }
    public static void main(String[] args) {
		Solution s=new Solution();
		TreeNode t=s.Deserialize("8,6,5,#,#,7,#,#,10,9,#,#,13,#,#,");
		String str=s.Serialize(t);
		System.out.println(str);
	}
}
