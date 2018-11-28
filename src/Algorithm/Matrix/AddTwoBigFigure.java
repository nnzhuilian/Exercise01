package Algorithm.Matrix;
/*Java中有自带的大整数运算
 * 在Java中有两个类BigInteger和BigDecimal分别表示大整数类和大浮点数类，
 * 至于两个类的对象能表示最大范围不清楚，理论上能够表示无线大的数，只要计算机内存足够大。 
 * 这两个类都在java.math.*包中，因此每次必须在开头处引用该包。
 * Ⅰ基本函数： 
1.valueOf(parament); 将参数转换为制定的类型 
比如 int a=3; 
BigInteger b=BigInteger.valueOf(a); 
则b=3; 
String s=”12345”; 
BigInteger c=BigInteger.valueOf(s); 
则c=12345；


2.add(); 大整数相加 
3.subtract(); 相减 
4.multiply(); 相乘 
5.divide(); 相除取整 
6.remainder(); 取余 
7.pow(); a.pow(b)=a^b 
8.gcd(); 最大公约数 
9.abs(); 绝对值 
10.negate(); 取反数 
11.mod(); 
a.mod(b)=a%b=a.remainder(b); 
12.max(); min(); 
13.punlic int comareTo(); 
14.boolean
*/
public class AddTwoBigFigure {
	public static int[] add(String a,String b){//正整数情况,还有负整数情况，未写，也没去0
		int length=a.length()>b.length()?a.length():b.length();
		length=length+1;
		int min=a.length()<b.length()?a.length():b.length();
		int result[]=new int[length];
		for(int i=0;i<min;i++){//可以直接交给下一次判断，不需要每次循环判断
			result[length-i-1]=(a.charAt(a.length()-i-1)-'0')+(b.charAt(b.length()-i-1)-'0')+result[length-i-1];
				for(int j=length-i-1;j>=0;j--){
					if(result[j]<10){
						break;
					}
					result[j]-=10;
					result[j-1]++;
				}		
		}
		if(a.length()>b.length()){
			for(int i=min;i<a.length();i++){
			result[length-i-1]=(a.charAt(a.length()-i-1)-'0')+result[length-i-1];
			for(int j=length-i-1;j>=0;j--){
				if(result[j]<10){
					break;
				}
				result[j]-=10;
				result[j-1]++;
			}
			}
		}
		if(a.length()>b.length()){
			for(int i=min;i<b.length();i++){
			result[length-i-1]=(b.charAt(b.length()-i-1)-'0')+result[length-i-1];
			for(int j=length-i-1;j>=0;j--){
				if(result[j]<10){
					break;
				}
				result[j]-=10;
				result[j-1]++;
			}
			}
		}
			return result;
	}
	
	/**
     * 用字符串模拟两个大数相加
     * @param n1 加数1
     * @param n2 加数2
     * @return   相加结果
     */
    public static String add2(String n1,String n2)
    {
    StringBuffer result = new StringBuffer();

    //1、反转字符串
    n1 = new StringBuffer(n1).reverse().toString();    
    n2 = new StringBuffer(n2).reverse().toString();
    
    int len1 = n1.length();
    int len2 = n1.length();
    int maxLen = len1 > len2 ? len1 : len2;
    boolean nOverFlow = false; //是否越界
    int nTakeOver = 0 ; //溢出数量
    
    //2.把两个字符串补齐，即短字符串的高位用0补齐
    if(len1 < len2)
    {
        for(int i = len1 ; i < len2 ; i++)
        {
        n1 += "0";
        }
    }
    else if (len1 > len2)
    {
        for(int i = len2 ; i < len1 ; i++)
        {
        n2 += "0";
        }
    }
    
    //3.把两个正整数相加，一位一位的加并加上进位
    for(int i = 0 ; i < maxLen ; i++)
    {
        int nSum = Integer.parseInt(n1.charAt(i) +"") + Integer.parseInt(n2.charAt(i) +"");
        
        if(nSum >= 10)
        {
        if(i == (maxLen - 1))
        {
            nOverFlow  = true;
        }
        nTakeOver = 1;
        result.append(nSum - 10);
        }
        else
        {
        nTakeOver = 0;
        result.append(nSum);
        }
    }
    
    //如果溢出的话表示位增加了
    if(nOverFlow)
    {
        result.append(nTakeOver);
    }
    return result.reverse().toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println((char)('3'-'0'+'4'));
		int[] a=add("7654321","654321");
	}

}
