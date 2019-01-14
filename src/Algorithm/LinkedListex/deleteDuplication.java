package Algorithm.LinkedListex;

import java.util.HashMap;

public class deleteDuplication {
	////如果是非排序的
    public ListNode deleteDuplication1(ListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        ListNode p=pHead;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        ListNode before=null;
        while(pHead!=null){
            if(map.containsKey(pHead.val)){
                map.put(pHead.val,map.get(pHead.val)+1);
            }else{
                map.put(pHead.val,1);
            }
            pHead=pHead.next;
        }
        pHead=p;
        ListNode head=null;
        while(pHead!=null){
            if(map.get(pHead.val)>1){
                if(before==null){
                    pHead=pHead.next;
                    continue;
                }
                before.next=pHead.next;
            }else{
                if(before==null){
                    head=pHead;
                }
                before=pHead;
            }
            pHead=pHead.next;
        }
        return head;
    }
    /////////////如果是排序的/////////////////////
    public ListNode deleteDuplication2(ListNode pHead)
    {
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        int value=0;
        boolean flag=true;
        ListNode before=null;
        ListNode head=null;
        while(pHead.next!=null){
           if(pHead.val!=pHead.next.val&&(flag||pHead.val!=value)){
               if(head==null){
                   head=pHead;
               }
               before=pHead;
               pHead=pHead.next;
           }
            else{
                if(before==null){
                    value=pHead.val;
                    pHead=pHead.next;
                    flag=false;
                    continue;
                }
                value=pHead.val;
                before.next=pHead.next;
                pHead=pHead.next;
            }
            flag=false;
        }
        if(pHead.val!=value){
            if(head==null){
                head=pHead;
            }
        }else{
            if(head==null){
                return null;
            }
            before.next=null;
        }
        return head;
    }
//////标准代码////////
    public ListNode deleteDuplication3(ListNode pHead)
    {
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode first = head;
        ListNode second = first.next;
        while(second != null){
            if(second.next != null && second.val == second.next.val){
                while(second.next != null && second.val == second.next.val){
                    second = second.next;
                }
                first.next = second.next;
            }else{
                first = first.next;
            }
            second = second.next;
        }
        return head.next;
    }
}
