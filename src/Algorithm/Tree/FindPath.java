package Algorithm.Tree;

import java.util.ArrayList;

public class FindPath {
	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> arrlist=new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return arrlist;
        }
        ArrayList<Integer> arr=new ArrayList<Integer>();
        Find(root,target,arr,arrlist);
        for(int i=0;i<arrlist.size()-1;i++){
            for(int j=i;j<arrlist.size()-1;j++){
            if(arrlist.get(i).size()<arrlist.get(i+1).size()){
                ArrayList<Integer> temp=arrlist.get(i);
                arrlist.set(i, arrlist.get(i+1));
                arrlist.set(i+1,temp);
            }
        }
        }
        return arrlist;
    }
    public static void Find(TreeNode root,int target,ArrayList<Integer> arr,ArrayList<ArrayList<Integer>> arrlist){
    	if(root==null){
            return;
        }
    	if((root.left==null&&root.right==null)){
        	arr.add(root.val);
        	int num=0;
            for(int i=0;i<arr.size();i++){
                num+=arr.get(i);
            }
            if(num==target){
                ArrayList<Integer> narr=new ArrayList<Integer>();
                for(int i=0;i<arr.size();i++){
                    narr.add(arr.get(i));
                }
                arrlist.add(narr);
            }
            arr.remove(arr.size()-1);
            return;
        }
        arr.add(root.val);
        Find(root.left,target,arr,arrlist);
        Find(root.right,target,arr,arrlist);
        arr.remove(arr.size()-1);
    }
    
    
    public static void main(String[] args) {
    	TreeNode root=new TreeNode(10);
    	root.left=new TreeNode(5);
    	root.right=new TreeNode(12);
    	root.left.left=new TreeNode(4);
    	root.left.right=new TreeNode(7);
    	FindPath(root,22);
	}
    
}

class Solution {//参考代码
    ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
    ArrayList<Integer> temp = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null)
            return res;
        target -= root.val;
        temp.add(root.val);
        if(target == 0 && root.left == null && root.right == null)
            res.add(new ArrayList<Integer>(temp));//赋值new arr,注意赋值方式
        else{
            FindPath(root.left, target);
            FindPath(root.right, target);
        }
        temp.remove(temp.size()-1);
        return res;
    }
}
