package Algorithm.Matrix;

import java.util.Arrays;

public class isContinuous {
//基于排序的
/*
 * 先统计王(0)的数量，再把牌排序，如果后面一个数比前面一个数大于1以上，那么中间的差值就必须用王来补了。
 * 看王的数量够不够，如果够就返回true，否则返回false。
 * */
	public boolean isContinuous2(int [] numbers) {
        int zero = 0, dis = 0;
        if(numbers.length != 5)
            return false;
        Arrays.sort(numbers);
        for(int i = 0; i < 4; i++){
            if(numbers[i] == 0){
                zero ++;
                continue;
            }
            if(numbers[i] == numbers[i+1])
                return false;
            if(numbers[i+1] - numbers[i] > 1){
                dis += numbers[i+1] - numbers[i] - 1;
            }
        }
        if(zero >= dis)
            return true;
        else
            return false;
    }
	
    public static boolean isContinuous(int [] numbers) {//基于数组的
        int[] all=new int[14];
        for(int i=0;i<numbers.length;i++){
            int index=numbers[i];
            all[index]++;
        }
        int begin=1;
        int end=13;
        for(int i=1;i<14;i++){
            begin=i;
        	if(all[i]!=0){
                break;
            }
            
        }
        for(int i=13;i>0;i--){
            end=i;
        	if(all[i]!=0){
                break;
            }
            
        }
        int count=0;
        for(int i=begin;i<end+1;i++){
            if(all[i]>1){
                return false;
            }
            if(all[i]==1){
            	count++;
            }
        }
        if(end-begin+1>5){
            return false;
        }
        if(count+all[0]==5){
        	return true;
        }
        return false;
    }
    public static void main(String[] args) {
		System.out.println(isContinuous(new int[]{1,3,2,6,4}));
	}
}
