package Algorithm.sortex.Find;

public class BinarySearch {

	public static int binarySearch(int k,int a[]){
		if(a.length==0){
			return -1;
		}
		return binarySearch(k,a,0,a.length-1);
	}
	public static int binarySearch(int k,int a[],int left,int right){
		if(left>right){//注意边界
			return -1;
		}
		int mid=(right+left)/2;
		if(a[mid]==k){
			return mid; 
		}
		else if(a[mid]>k){
			return binarySearch(k,a,left,mid-1);
		}
		else if(a[mid]<k){
			return binarySearch(k, a,mid+1,right);
		}
		return -1;
	}
	/**
     * 二分查找普通实现。
     * @param srcArray 有序数组
     * @param key 查找元素
     * @return  不存在返回-1
     */
    public static int binSearch(int srcArray[], int key) {
        int mid;
        int start = 0;
        int end = srcArray.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key < srcArray[mid]) {
                end = mid - 1;
            } else if (key > srcArray[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
		System.out.println(binarySearch(7, new int[]{0,1,2,3,4,5,6,7}));
		System.out.println(binSearch(new int[]{0,1,2,3,4,5,6,7},7));
	}
}
