package Algorithm.Matrix;

public class isNumeric {
	public boolean isNumeric1(char[] str) {//正则
        String s=String.copyValueOf(str);
        return s.matches("[\\+-]?\\d*(\\.\\d+)?([eE][\\+-]?\\d+)?");
    }
		/*
		以下对正则进行解释:
		[\\+\\-]?            -> 正或负符号出现与否
		\\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
		(\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
		                        否则一起不出现
		([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
		                        紧接着必须跟着整数；或者整个部分都不出现
		*/
///////////////////////////////////////////////////////////////////////////////////////////////////	
	/*设置三个标志符分别记录“+/-”、“e/E”和“.”是否出现过。
	 * 对于“+/-”： 正常来看它们第一次出现的话应该出现在字符串的第一个位置，如果它第一次出现在不是字符串首位，而且它的前面也不是“e/E”，那就不符合规则；如果是第二次出现，那么它就应该出现在“e/E”的后面，如果“+/-”的前面不是“e/E”，那也不符合规则。
	 * 对于“e/E”： 如果它的后面不接任何数字，就不符合规则；如果出现多个“e/E”也不符合规则。
	 * 对于“.”： 出现多个“.”是不符合规则的。还有“e/E”的字符串出现“.”也是不符合规则的。
	 * 同时，要保证其他字符均为 0-9 之间的数字。
	 * */
	 public static boolean isNumeric2(char[] str) {
	        int len=str.length;
	        int i=0;
	        boolean flag=true;
	        boolean df=true;
	        while(i<len){
	            if(str[i]=='+'||str[i]=='-'){
	                if(i!=0){
	                    if(!(str[i-1]=='e'||str[i-1]=='E')){
	                        return false;
	                    }
	                }
	            }
	            else if(str[i]=='e'||str[i]=='E'){
	                if(flag==false||i==0||str[i-1]=='.'||i==len-1){
	                    return false;
	                }else{
	                    flag=false;
	                }
	            }
	            else if(str[i]=='.'){
	                if(flag==false||df==false||i==len-1){
	                    return false;
	                }else{
	                    df=false;
	                }
	            }else if(str[i]<'0'||str[i]>'9'){
	                return false;
	            }
	            i++;
	        }
	        return true;
	    }
	 public static void main(String[] args) {
		char[] a={'1','2','3','.','4','5','e','+','6'};
		System.out.println(isNumeric2(a));
	}
}
