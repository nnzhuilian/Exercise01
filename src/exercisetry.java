import java.util.ArrayList;
import java.util.List;



class SplitTest{
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> temp=new ArrayList();
        if(listNode==null){
            return temp;//����дnull
}
        while(listNode!=null){
            temp.add(listNode.val);
            listNode=listNode.next;
            }
        ArrayList<Integer> arr=new ArrayList<Integer>();//���з���ֵ��������������ArrayList
        for(int i=temp.size()-1;i>=0;i--){//List�Ĵ�С��size(),������length��String��length();
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
