package Algorithm.Tree;

//Definition for binary tree
/*class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }*/

public class ReConstructBinaryTree {
	public TreeNode reConstructBinaryTree1(int [] pre,int [] in) {//自己写的
        if(pre==null||in==null||pre.length!=in.length){//{}不是null
        	return null;
        }
		int flag=0;
        TreeNode root=null;
        if(pre.length>0){
            root=new TreeNode(pre[0]);
        }else{
            return root;
        }
        for(int i=0;i<in.length;i++){
            if(in[i]==pre[0]){
                flag=i;
                break;
            }
        }
        int Leftin[]=new int[flag];//
        int Rightin[]=new int[in.length-flag-1];
        int Leftpre[]=new int[flag];
        int Rightpre[]=new int[in.length-flag-1];
        int j=0;
        for(j=0;j<flag;j++){
            Leftin[j]=in[j];
            Leftpre[j]=pre[j+1];
}       
        for(j=0;j<in.length-flag-1;j++){
            Rightin[j]=in[j+flag+1];
            Rightpre[j]=pre[j+1+flag];
}
        root.left=reConstructBinaryTree1(Leftpre,Leftin);
        root.right=reConstructBinaryTree1(Rightpre,Rightin);
        return root;
    }
////////////////////////////////////////-优化写法-///////////////////////////////////////
	public TreeNode reConstructBinaryTree2(int [] pre,int [] in) {
        if(pre==null || in==null || pre.length!=in.length||pre.length==0||in.length==0)  //对输入条件进行判断
            return null;
        return  reConstructBinaryTree2(pre,0,pre.length,in,0,in.length-1);
    }
	//重载
     public TreeNode reConstructBinaryTree2(int [] pre, int start1,int end1,int[] in,int start2,int end2){
         if(start1>end1 || start2>end2)
             return null;
         
         TreeNode root=new TreeNode(pre[start1]);   
         for(int i=start2;i<=end2;i++){
             if(in[i]==pre[start1]){
                 //int offset=i-1-start2;    //偏移量  
                 root.left=reConstructBinaryTree2(pre,start1+1,start1+i-start2, in,start2,i-1);
                 root.right=reConstructBinaryTree2(pre,start1+i-start2+1,end1,in,i+1,end2);
                 break; //找到根节点就需要退出循环
             }
         }
         
         return root;
     }
//////////////////////////////////////////--该方法传index不会浪费不必要的空间，令加函数--////////////////////////////////////////////////////////////	
	
    public void print(TreeNode tr){//前序遍历输出
		if(tr==null){
			return;
		}
		else{
			System.out.print(tr.val+" ");
			print(tr.left);
			print(tr.right);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReConstructBinaryTree re=new ReConstructBinaryTree();
		int[] pre={};//{1,2,3,4,5,6,7};
		int[] in={};//{3,2,4,1,6,5,7};
		TreeNode tr=re.reConstructBinaryTree1(pre, in);
		re.print(tr);
	}

}
