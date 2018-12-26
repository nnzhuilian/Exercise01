package Algorithm.Matrix;

public class FindNumsAppearOnce {
	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
	    public static void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
	        if(array.length==0){
	            return;
	        }
	        int flag=0;
	        for(int i=0;i<array.length;i++){
	            flag=flag^array[i];
	        }
	        String s=Integer.toBinaryString(flag);
	        int index=0;
	        for(int i=s.length()-1;i>=0;i--){
	            if(s.charAt(i)=='1')
	                break;
	            index++;
	        }
	        for(int i=0;i<array.length;i++){
	            int temp=(array[i] >> index)%2;
	            if(temp==1){
	                num1[0]=num1[0]^array[i];
	            }else{
	                num2[0]=num2[0]^array[i];
	            }
	        }
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindNumsAppearOnce1(new int[]{2,4,3,6,3,2,5,5}, new int[1], new int[1]);
	}

}
