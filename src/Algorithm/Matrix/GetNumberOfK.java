package Algorithm.Matrix;

public class GetNumberOfK {
	public static int GetNumberOfK1(int [] array , int k) {//基于二分查找的适用于所有数字类型的方法
	       if(array.length==0){
	           return 0;
	       }
	        int first=GetFirstK(array,k,0,array.length-1);
	        int last=GetLastK(array,k,0,array.length-1);
	        if(first==-1||last==-1){
	            return 0;
	        }
	        return last-first+1;
	    }
	    public static int GetFirstK(int[] array,int k,int left,int right){
	        if(left>right){
	            return -1;
	        }
	        int mid=left+(right-left)/2;
	        if(array[mid]==k){
	            if(mid==0||array[mid-1]!=k){
	            return mid;
	            }else{
	                return GetFirstK(array,k,left,mid-1);
	            }
	        }
	        return GetFirstK(array,k,mid+1,right);
	    }
	    public static int GetLastK(int[] array,int k,int left,int right){
	        if(left>right){
	            return -1;
	        }
	        int mid=left+(right-left)/2;
	        if(array[mid]==k){
	            if(mid==array.length-1||array[mid+1]!=k){
	            return mid;
	            }else{
	                return GetLastK(array,k,mid+1,right);
	            }
	        }
	        return GetLastK(array,k,left,mid-1);
	    }
	    
	    public int GetNumberOfK2(int [] array , int k) {
	        return getIndex(array,k+0.5)-getIndex(array,k-0.5);
	    }
	    public int getIndex(int[] array,double k){
	        int first=0;
	        int last=array.length-1;
	        while(first<=last){
	            int mid=first+(last-first)/2;
	            if(array[mid]>k){
	                last=mid-1;
	            }else{
	                first=mid+1;
	            }
	        }
	        return first;
	    }
	    public static void main(String[] args) {
			System.out.println(GetNumberOfK1(new int[]{1,2,3,3,3,3,4,5}, 0));
		}
}
