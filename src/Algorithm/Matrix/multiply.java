package Algorithm.Matrix;

public class multiply {
	/*����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
	 * ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]��
	 * ����ʹ�ó�����
	*/
	public int[] multiply(int[] A) {
        if(A==null){
            return null;
        }
        int n=A.length;
        if(n<=0){
            return null;
        }
        int[] B=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==i)
                    continue;
                B[i]*=A[j];
            }
        }
        return B;
    }
	/*B[i]��ֵ���Կ���ͼ�о���� i ������Ԫ�صĳ˻���
	 * ���ǿ��������������е����ˣ������������B[i]�е�һ���֣�Ȼ�󵹹������������еķֲ����ɣ�����һ����Ҳ�˽�ȥ��*/
    public int[] multiply2(int[] A) {
        if(A.length <= 1)
            return A;
        int [] B = new int[A.length];
        B[0] = 1;
        for(int i = 1; i < A.length; i++){
            B[i] = B[i-1] * A[i-1];
        }
        int temp = 1;
        for(int j = A.length - 2; j>=0; j--){
            temp *= A[j+1];
            B[j] *= temp;
        }
        return B;
    }
	public static void main(String[] args) {
		int[] A=null;
		System.out.println(A.length);
	}
}
