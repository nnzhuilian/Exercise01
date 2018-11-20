import java.util.ArrayList;
import java.util.List;



class SplitTest{
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> temp=new ArrayList();
        if(listNode==null){
            return temp;//不能写null
}
        while(listNode!=null){
            temp.add(listNode.val);
            listNode=listNode.next;
            }
        ArrayList<Integer> arr=new ArrayList<Integer>();//如有返回值，必须完整声明ArrayList
        for(int i=temp.size()-1;i>=0;i--){//List的大小是size(),数组是length，String是length();
            arr.add(temp.get(i));
        }
        return arr;
}
		
}
public class exercisetry {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
