package Algorithm.Matrix;

public class multiply {
	/*给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
	 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
	 * 不能使用除法。
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
	/*B[i]的值可以看作图中矩阵第 i 行所有元素的乘积。
	 * 我们可以先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去。*/
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
    public int[] multiply3(int[] A) {
        if(A==null||A.length==0)
            return A;
        int[] b1=new int[A.length];
        int[] b2=new int[A.length];
        b1[0]=1;
        b2[A.length-1]=1;
        for(int i=1;i<b1.length;i++){
            b1[i]=b1[i-1]*A[i-1];
        }
        for(int i=b2.length-2;i>=0;i--){
            b2[i]=b2[i+1]*A[i+1];
        }
        int[] B=new int[A.length];
        for(int i=0;i<B.length;i++){
            B[i]=b1[i]*b2[i];
        }
        return B;
    }
	public static void main(String[] args) {
		int[] A=null;
		System.out.println(A.length);
	}
}
