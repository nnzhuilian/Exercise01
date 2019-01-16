package Algorithm.Tree;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class GetNext {//递归
    public TreeLinkNode GetNext1(TreeLinkNode pNode)
    {
        if(pNode==null){
            return null;
        }
        if(pNode.right!=null){
            return getleaf(pNode.right);//求右子树第一个
        }
        else{
            return get(pNode);//回溯父节点
        }
    }
    public TreeLinkNode get(TreeLinkNode pNode){
            if(pNode.next==null){
                return null;
            }else{
                if(pNode==pNode.next.left){
                    return pNode.next;//bushi
                }else{
                    return get(pNode.next);
                }
            }
    }
    public TreeLinkNode getleaf(TreeLinkNode pNode){
        if(pNode.left==null&&pNode.right==null){
            return pNode;
        }else{
            if(pNode.left!=null){
                return getleaf(pNode.left);
            }else{
                return pNode;
            }
        }
    }
/////////////////////////基于循环的//////////////////////////////////
    public TreeLinkNode GetNext2(TreeLinkNode pNode)
    {
        if(pNode == null){
            return null;
        }
        if(pNode.right != null){
            TreeLinkNode node = pNode.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }
        while(pNode.next != null){
            TreeLinkNode root = pNode.next;
            if(pNode == root.left)
                return root;
            pNode = root;
        }
        return null;
    }
}
