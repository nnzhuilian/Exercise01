package Algorithm.Matrix;

public class MinNumberInRotateArray {
////////////////////////////-�ҵķ���-///////////////////////////////////
	/*
	 * �����С���ұߣ��򷵻����
	 * ������ֱȽ�
	 * ��������ֻ����һ����ʱ����
	 * �Ƚ��������飬ѡ��������С�����������ء�
	 * �÷�����������Ҳ����11101ʱ��ʱ�临�ӶȻ����ӣ���Ϊ��111����Ҫ�ж�
	 * �ұȵڶ��ַ�������һ��ѹջ
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
            return minNumberInRotateArray(array,left,right-1);//������--���������
        }
        return 0;
    }
/////////////////////////////-�Ż�����-ѭ��ʵ�֣�����ݹ�///////////////////////////
    public static int minNumberInRotateArray1(int [] array) {
    	int len = array.length;
        if(len == 0)
            return 0;
        int low = 0, high = len - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(array[mid] > array[high]){//////////Ҫ��mid�ȣ����Ƿֳ�����ȡ�
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
