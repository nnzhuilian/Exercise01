package Algorithm.Tree;

import java.util.*;

public class GetMedian {
    public PriorityQueue<Integer> min = new PriorityQueue<Integer>();
    public PriorityQueue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>(){
        public int compare(Integer o1,Integer o2){
            return o2-o1;
        }
    });
    public void Insert1(Integer num) {
        if(max.size()==0||num<max.peek()){
            max.offer(num);
        }else{
            min.offer(num);
        }
        if(max.size()-1>=min.size()){
            min.offer(max.poll());
        }else if(min.size()-1>=max.size()){
            max.offer(min.poll());
        }
    }

    public Double GetMedian1() {
        if(max.size()==0&&min.size()==0){
            return 0.0;
        }
        if(max.size()==min.size()){
            return (double)(max.peek()+min.peek())/2;
        }
        if(max.size()<min.size()){
            return (double)min.peek();
        }else{
            return (double)max.peek();
        }
    }

    ///////////////////------------另一种----------//////////////////////
    // 最小堆（右）
    private PriorityQueue<Integer> rHeap = new PriorityQueue<>(); 
    // 最大堆（左）
    private PriorityQueue<Integer> lHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    // 保证lHeap.size()>=rHeap.size()
    public void Insert(Integer num) {
        // 先按大小插入，再调整
        if(lHeap.isEmpty() || num <= lHeap.peek())
            lHeap.offer(num);
        else
            rHeap.offer(num);

        if(lHeap.size() < rHeap.size()){
            lHeap.offer(rHeap.peek());
            rHeap.poll();
        }else if(lHeap.size() - rHeap.size() == 2){
            rHeap.offer(lHeap.peek());
            lHeap.poll();
        }
    }
    public Double GetMedian() {
        if(lHeap.size() > rHeap.size())
            return new Double(lHeap.peek());
        else
            return new Double(lHeap.peek() + rHeap.peek())/2;
    }
}
