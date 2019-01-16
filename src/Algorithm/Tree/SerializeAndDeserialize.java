package Algorithm.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {
	public static String Serialize(TreeNode root) {
        StringBuffer sb=new StringBuffer();
        if(root==null){
            return "#";
        }
        Serialize(root,sb);
        String s=sb.toString();
        return s.substring(0,s.length()-1);
  }
    public static void Serialize(TreeNode root,StringBuffer sb){
        if(root==null){
            sb.append("#,");
            return;
        }
/*        if(root.left==null&&root.right==null){
            sb.append(String.valueOf(root.val)+",");
            return;
        }*/
        sb.append(String.valueOf(root.val)+",");
        Serialize(root.left,sb);
        Serialize(root.right,sb);
    }
    public static TreeNode Deserialize(String str) {
       if(str.length()==0||str.equals("#")){
           return null;
       }
       String[] strs=str.split(",");
       int[] p={0};
       return Deserialize(strs,p);
  }
    public static TreeNode Deserialize(String[] strs,int[] p){
        if(p[0]>=strs.length||strs[p[0]].equals("#")){
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(strs[p[0]]));
        p[0]++;
        root.left=Deserialize(strs,p);
        p[0]++;
        root.right=Deserialize(strs,p);
        return root;
    }
    public static void main(String[] args) {
		String s="8,6,10,5,7,9,11";
		TreeNode tr=Deserialize(s);
	}
////////////////////////////////////////ÓÅ»¯´úÂë//////////////////////////////
    String Serialize2(TreeNode root) {
        if(root == null){
            return "#,";
        }
        StringBuffer res = new StringBuffer(root.val + ",");
        res.append(Serialize(root.left));
        res.append(Serialize(root.right));
        return res.toString();
    }
    TreeNode Deserialize2(String str) {
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
    }
}
