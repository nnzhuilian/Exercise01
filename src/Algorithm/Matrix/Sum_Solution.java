package Algorithm.Matrix;

public class Sum_Solution {
	public int Sum_Solution1(int n) {//�ö�·�����жϣ��ݹ����ѭ��
        int sum=n;
        boolean t=(n>0)&&(sum=sum+Sum_Solution1(n-1))>0;
        return sum;
    }
}
