package Algorithm.LinkedListex;

import java.util.LinkedList;

public class LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {//��������ķ���
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
    //���������Ż�
    public int LastRemaining_Solution2(int n, int m) {
        if(n < 1 || m < 1)
            return -1;
        LinkedList<Integer> link = new LinkedList<Integer>();
        for(int i = 0; i < n; i++)
            link.add(i);
        int index = -1;   //���� -1 ���� 0
        while(link.size() > 1){
            index = (index + m) % link.size();  //�� link�ĳ������಻�Ƕ� n
            link.remove(index);
            index --;
        }
        return link.get(0);
    }
    //��෽��
    public int LastRemaining_Solution3(int n, int m) {//��ʽ��,ע��Ⱥ�
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
