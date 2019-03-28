package Algorithm.Matrix;

public class MinNumberInRotateArray {
////////////////////////////-我的方案-///////////////////////////////////
	/*
	 * 若左边小于右边，则返回左边
	 * 否则二分比较
	 * 当分组中只存在一个数时返回
	 * 比较两个分组，选出其中最小的数，来返回。
	 * 该方案遇到特例也就是11101时，时间复杂度会增加，因为都111都需要判断
	 * 且比第二种方法多了一次压栈
	 */
	 public static int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        return minNumberInRotateArray(array,0,array.length-1);
    }
    public static int minNumberInRotateArray(int[] array,int left,int right){
        if(array[left]<array[right]){
            return array[left];
        }
        if(left==right){
        	return array[left];
        }
        int mid=(left+right)/2;
        int p=minNumberInRotateArray(array,left,mid);
        int q=minNumberInRotateArray(array,mid+1,right);
        if(p>=q){
            return q;
        }else{
            return p;
        }
    }
    public static int minNumberInRotateArray2(int[] array,int left,int right){
        if(left>right)
            return 0;
        if(left==right)
            return array[left];
        int mid=(left+right)/2;
        if(array[mid]>array[right]){
            return minNumberInRotateArray(array,mid+1,right);
        }else if(array[mid]<array[right]){
            return minNumberInRotateArray(array,left,mid);
        }else if(array[mid]==array[right]){
            return minNumberInRotateArray(array,left,right-1);//绝不能--，会出错！！
        }
        return 0;
    }
/////////////////////////////-优化方案-循环实现，不需递归///////////////////////////
    public static int minNumberInRotateArray1(int [] array) {
    	int len = array.length;
        if(len == 0)
            return 0;
        int low = 0, high = len - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(array[mid] > array[high]){//////////要跟mid比，不是分成两组比。
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }
        }
        return array[low];
    }
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={4,6,8,1,3,4};
		System.out.println(minNumberInRotateArray(a));
	}

}
