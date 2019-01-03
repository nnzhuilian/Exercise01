package Algorithm.Matrix;

import java.util.ArrayList;

public class FindNumbersWithSum {
	public ArrayList<Integer> FindNumbersWithSum1(int [] array,int sum) {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        if(array.length==0){
            return arr;
        }
        int first=0;
        int last=array.length-1;
        while(first<last){
            int tempsum=array[first]+array[last];
            if(sum==tempsum){
                arr.add(array[first]);
                arr.add(array[last]);
                break;
            }else if(tempsum>sum){
                last--;
            }else{
                first++;
            }
        }
        return arr;
    }
}
