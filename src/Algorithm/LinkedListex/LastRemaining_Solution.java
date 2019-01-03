package Algorithm.LinkedListex;

import java.util.LinkedList;

public class LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {//基于链表的方法
        if(n < 1 || m < 1){
            return -1;
        }
        LinkedList<Integer> link=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            link.add(i);
        }
        int count=0;
        int cur=-1;
        while(link.size()>1){
            count++;
            cur++;
            cur=cur%link.size();
            if(count==m){
                link.remove(cur);
                count=0;
                cur--;
            }
        }
        return link.get(0);
    }
    //基于链表优化
    public int LastRemaining_Solution2(int n, int m) {
        if(n < 1 || m < 1)
            return -1;
        LinkedList<Integer> link = new LinkedList<Integer>();
        for(int i = 0; i < n; i++)
            link.add(i);
        int index = -1;   //起步是 -1 不是 0
        while(link.size() > 1){
            index = (index + m) % link.size();  //对 link的长度求余不是对 n
            link.remove(index);
            index --;
        }
        return link.get(0);
    }
    //简洁方法
    public int LastRemaining_Solution3(int n, int m) {//公式法,注意等号
        if(n<1||m<1){
            return -1;
        }
        int last=0;
        for(int i=2;i<=n;i++){
            last=(last+m)%i;
        }
        return last;
    }
}
