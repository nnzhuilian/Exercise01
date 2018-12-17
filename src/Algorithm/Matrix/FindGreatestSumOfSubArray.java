package Algorithm.Matrix;

public class FindGreatestSumOfSubArray {
	 public int FindGreatestSumOfSubArray1(int[] array) {
	        if(array.length==0){
	            return 0;
	        }
	        int maxsum=array[0];
	        int sum=0;
	        for(int i=0;i<array.length;i++){
	            if(maxsum<0){
	                if(maxsum<array[i]){
	                    maxsum=array[i];
	                }
	            }else{
	                sum+=array[i];
	                if(sum<=0){
	                    sum=0;
	                }else if(sum>maxsum){
	                    maxsum=sum;
	                }
	            }
	        }
	        return maxsum;
	    }
	 public static int FindGreatestSumOfSubArray(int[] array) {//优化代码
	        if(array.length == 0)
	            return 0;
	        int cur = array[0], max = array[0];
	        for(int i=1; i<array.length; i++){
	            cur = cur > 0 ? cur + array[i] : array[i];
	            if(max < cur)
	                max = cur;
	        }
	        return max;
	    }
	 //也可用动态规划。
	 public static void main(String[] args) {
		int[] a={-3,-4,-1,-7,-2};
		System.out.println(FindGreatestSumOfSubArray(a));
	}
}
