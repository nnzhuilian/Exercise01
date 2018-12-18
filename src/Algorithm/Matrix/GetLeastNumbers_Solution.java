package Algorithm.Matrix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {
	public static ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {//基于快排的方法，时间为O(n)
        if(input.length==0||k==0||input.length<k){
            return new ArrayList<Integer>();
        }
        int begin=0;
        int end=input.length-1;
        while(true){
            int index=partition(begin,end,input);
            if(index<k-1){
                begin=index+1;
                end=end;
            }
            else if(index>k-1){
                begin=0;
                end=index-1;
            }
            else{
                break;
            }
        }
        ArrayList<Integer> arr=new ArrayList<Integer>();
        for(int i=0;i<k;i++){
            arr.add(input[i]);
        }
        return arr;
    }
    public static int partition(int begin,int end,int[] input){
        int more=end;
        int less=begin-1;
        int cur=begin;
        while(less<more-1){
            if(input[cur]>input[end]){
                swap(cur,--more,input);
            }
            else{
                cur++;
                less++;
            }
        }
        swap(more,end,input);
        return more;//选择值所在位置
    }
    public static void swap(int a,int b,int[] input){
        int temp=input[a];
        input[a]=input[b];
        input[b]=temp;
    }
    
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {//基于堆的算法，适合海量数据，但还是会改变数组顺序
        ArrayList<Integer> arr=new ArrayList<Integer>();
        if(input.length==0||k==0||input.length<k){
            return arr;
        }
        for(int i=0;i<input.length;i++){
            if(i<k){
                heapIn(input,i);
        }
            else{
                if(input[i]>=input[0]){
                    continue;
                }
                else{
                    swap(i,0,input);
                    heapfy(input,0,k);
                }
            }
    }
        for(int i=0;i<k;i++){
            arr.add(input[i]);
        }
        return arr;
    }
    public static void heapIn(int[] input,int insert){
        while((input[insert]>input[(insert-1)/2])&&(insert!=0)){
            swap(insert,(insert-1)/2,input);
            insert=(insert-1)/2;
        }
    }
    public static void heapfy(int[] input,int index,int end){
            while(true){
                int max;
                if((index*2+2)<end){
                    if(input[index*2+1]>=input[index*2+2]){
                        max=index*2+1;
                    }else{
                        max=index*2+2;
                    }
                }
                else if((index*2+1)<end){
                    max=index*2+1;
                }else{
                    break;
                }
                if(input[index]<input[max]){
                    swap(index,max,input);
                    index=max;
                }else{
                    break;
                }
            }
        }
/*    public static void swap(int a,int b,int[] input){
        int temp=input[a];
        input[a]=input[b];
        input[b]=temp;
    }*/
    
    public ArrayList<Integer> GetLeastNumbers_Solution3(int [] input, int k) {//基于优先队列的，优先队列实现堆？
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(input == null || k ==0 || k > input.length)
            return res;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() { 
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;//最大堆
            }
        });
        for(int i=0; i<input.length; i++){
            if(maxHeap.size() != k)
                maxHeap.offer(input[i]);
            else{
                if(maxHeap.peek() > input[i]){
                    maxHeap.poll();
                    maxHeap.offer(input[i]);
                }
            }
        }
        for(Integer i: maxHeap){
            res.add(i);
        }
        return res;
    }
    public static void main(String[] args) {
		int a[]={4,5,1,6,2,7,3,8};
		ArrayList<Integer> arr=GetLeastNumbers_Solution2(a, 4);
	}
}
