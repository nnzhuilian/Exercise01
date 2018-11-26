package Algorithm.recursionAndLoops;

public class Power {
	public static double Power1(double base, int exponent) {//不要忘记负数的情况，以及0的0次方
		if(equals(base,0.0)){
			return 0;//考虑指数为负或0，基数为0的情况
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
	//////////////////////优化算法/////////////////////////
	public double Power2(double base, int exponent) {
        int n = exponent;
        if(exponent==0){
            // 当指数为0底数为0时，没有意义，返回0或者返回1都可以
            return 1;
        }else if(exponent < 0){
            if(base == 0){
                throw new RuntimeException("分母不能为0"); 
            }
            n = -exponent;
        }
        double res = PowerUnsignedExponent(base, n);
        return exponent<0? 1/res: res;
  }
	//可以使用右移运算符代替除以2，用位与运算符代替求余运算符（%）来判断一个数是奇数还是偶数。
	public double PowerUnsignedExponent(double base, int n){
        if(n == 0)
            return 1;
        if(n == 1)
            return base;
        //递归
        double res = PowerUnsignedExponent(base, n>>1);
        res *= res;
        if((n & 0x1) == 1)
            res *= base;
        return res;
}
	
	/*关于double
	 * 首先一个 double 是否为 0，或者其他的数值，是精确的，可以使用== 。
	 * 比如 double f = 0; 此时 f 是精确为 0 ，f == 0 为 true。
	 * 但是，double 在运算中，由于截尾的原因，总是有误差的。而此时是否为0，要看你的这个运算的精度要求。
	 * 比如运算后，f = 0.001,此时不能简单去和 e 去比较，可以这样 if(abs(x) < 0.000001) // 这个0.000001可以根据精度需要改为更小的
	 * */
	public static boolean equals(double a,double b)
	{
		if(((a-b)>0.0000001)||((a-b)<-0.0000001)){
			return false;
		}
		return true;
	}
}
