package Algorithm.Matrix;
import java.util.*;
public class maxInWindows {
	//暴力法一：
    public ArrayList<Integer> maxInWindows1(int [] num, int size)
    {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        if(num==null||num.length==0||size==0||size>num.length){
            return arr;
        }
        PriorityQueue<Integer> window=new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                return o2-o1;
            }
        });
        for(int i=0;i<size;i++){
            window.offer(num[i]);
        }
        arr.add(window.peek());
        int i=size;
        int first=0;
        while(i<num.length){
            window.remove(num[first++]);
            window.offer(num[i++]);
            arr.add(window.peek());
        }
        return arr;
    }
    //暴力法2
        public ArrayList<Integer> maxInWindows2(int [] num, int size)
        {
            ArrayList<Integer> res = new ArrayList<Integer>();
            if(num.length < size || size == 0)
                return res;
            for(int i = 0; i < num.length - size + 1; i++){
                res.add(max(num, i, size));
            }
            return res;
        }
        public int max(int [] num, int index, int size){
            int res = num[index];
            for(int i = index + 1; i < index + size; i++){
                if(num[i] > res)
                    res = num[i];
            }
            return res;
        }
    //时间复杂度为O(n)的方法：双向队列
        public ArrayList<Integer> maxInWindows3(int [] num, int size)
        {
            ArrayList<Integer> arr=new ArrayList<Integer>();
            if(num==null||num.length==0||size==0||size>num.length){
                return arr;
            }
            LinkedList<Integer> list=new LinkedList<Integer>();
            for(int i=0;i<num.length;i++){
                while((!list.isEmpty())&&num[i]>list.peekLast()){
                    list.removeLast();
                }
                list.offer(num[i]);
                if(i>=size){
                    if(num[i-size]==list.peek()){
                        list.poll();
                    }
                }
                if(i>size-2){
                arr.add(list.peek());}
            }
            return arr;
        }
        

}
