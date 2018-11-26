package Algorithm.recursionAndLoops;

public class Power {
	public static double Power1(double base, int exponent) {//��Ҫ���Ǹ�����������Լ�0��0�η�
		if(equals(base,0.0)){
			return 0;//����ָ��Ϊ����0������Ϊ0�����
		}
		if (exponent == 0) {
			return 1;
		}
		double i = Power1(base, exponent / 2);
		if ((exponent % 2) != 0) {
			if (exponent < 0) {
				base = 1 / base;
			}
			return i * i * base;
		}
		if ((exponent % 2) == 0) {
			return i * i;
		}
		return 0;
	}
	//////////////////////�Ż��㷨/////////////////////////
	public double Power2(double base, int exponent) {
        int n = exponent;
        if(exponent==0){
            // ��ָ��Ϊ0����Ϊ0ʱ��û�����壬����0���߷���1������
            return 1;
        }else if(exponent < 0){
            if(base == 0){
                throw new RuntimeException("��ĸ����Ϊ0"); 
            }
            n = -exponent;
        }
        double res = PowerUnsignedExponent(base, n);
        return exponent<0? 1/res: res;
  }
	//����ʹ������������������2����λ����������������������%�����ж�һ��������������ż����
	public double PowerUnsignedExponent(double base, int n){
        if(n == 0)
            return 1;
        if(n == 1)
            return base;
        //�ݹ�
        double res = PowerUnsignedExponent(base, n>>1);
        res *= res;
        if((n & 0x1) == 1)
            res *= base;
        return res;
}
	
	/*����double
	 * ����һ�� double �Ƿ�Ϊ 0��������������ֵ���Ǿ�ȷ�ģ�����ʹ��== ��
	 * ���� double f = 0; ��ʱ f �Ǿ�ȷΪ 0 ��f == 0 Ϊ true��
	 * ���ǣ�double �������У����ڽ�β��ԭ�����������ġ�����ʱ�Ƿ�Ϊ0��Ҫ������������ľ���Ҫ��
	 * ���������f = 0.001,��ʱ���ܼ�ȥ�� e ȥ�Ƚϣ��������� if(abs(x) < 0.000001) // ���0.000001���Ը��ݾ�����Ҫ��Ϊ��С��
	 * */
	public static boolean equals(double a,double b)
	{
		if(((a-b)>0.0000001)||((a-b)<-0.0000001)){
			return false;
		}
		return true;
	}
}
