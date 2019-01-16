package Algorithm.Tree;

public class KthNode {
    TreeNode KthNode1(TreeNode pRoot, int k)
    {
        if(pRoot==null){
            return null;
        }
        int[] count={0};
        return KthNode1(pRoot,k,count);
    }
    TreeNode KthNode1(TreeNode pRoot,int k,int[] count){
        if(pRoot==null){
            return null;
        }
        TreeNode l=KthNode1(pRoot.left,k,count);
        if(l!=null){
            return l;
        }
        count[0]++;
        if(count[0]==k){
            return pRoot;
        }
        TreeNode r=KthNode1(pRoot.right,k,count);
        if(r!=null){
            return r;
        }
        return null;
    }
//////////////////-ÓÅ»¯´úÂë-//////////////////////////////
    int index = 0;
    TreeNode KthNode2(TreeNode pRoot, int k)
    {
        if(pRoot != null){
            TreeNode node = KthNode2(pRoot.left, k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return pRoot;
            node = KthNode2(pRoot.right, k);
            if(node != null)
                return node;
        }
        return null;
    }
}
