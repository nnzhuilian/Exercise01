package Algorithm.Matrix;

import java.util.TreeMap;

public class MoreThanHalfNum_Solution {
	public int MoreThanHalfNum_Solution1(int [] array) {//基于TreeMap或HashMap的
		int length=array.length;
		if(length==0){
			return 0;
		}
		if(length==1){
			return array[0];
		}
        TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>();
        for(int i=0;i<length;i++){
            if(tm.containsKey(array[i])){
            	int num=tm.get(array[i])+1;
            	if(num>length/2){
            		return array[i];
            	}
            	tm.put(array[i], num);
            }else{
            	tm.put(array[i], 1);
            }
        }
        return 0;
    }
	
    public int MoreThanHalfNum_Solution2(int [] array) {//方法2，相同+1，不同-1的方法
        if(array.length==0){
            return 0;
        }
        int[] cal=new int[2];
        int length=array.length;
        for(int i=0;i<length;i++){
            if(array[i]!=cal[0]){
                if(cal[1]>0){
                    cal[1]--;
                }
                if(cal[1]==0){
                    cal[0]=array[i];
                    cal[1]=1;
                }
            }
            else if(array[i]==cal[0]){
                cal[1]++;
            }
        }
        int count=0;
        for(int i=0;i<length;i++){
            if(array[i]==cal[0]){
                count++;
            }
        }
         if(count>(length/2)){
             return cal[0];
         }
         return 0;
     }
    //方法3 基于partition。
}
