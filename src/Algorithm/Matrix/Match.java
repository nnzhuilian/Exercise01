package Algorithm.Matrix;

public class Match {
    public static boolean match(char[] str, char[] pattern)
    {
        int sindex = 0, pindex = 0;
        return matchCore(str, sindex, pindex, pattern);
    }
    public static boolean matchCore(char[] str, int sindex, int pindex, char[] pattern){
        if(sindex >= str.length && pindex == pattern.length)
            return true;
        if(pindex >= pattern.length && sindex < str.length)
            return false;
        if(pindex+1 < pattern.length && pattern[pindex+1] == '*'){//而当模式中的第二个字符是“*”时
            if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.') ){//如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
                return matchCore(str, sindex, pindex+2, pattern) ||//模式后移2字符，相当于x*被忽略
                    matchCore(str, sindex+1, pindex+2, pattern ) ||//字符串后移1字符，模式后移2字符；
                    matchCore(str, sindex+1, pindex, pattern);//字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位。
            }else{
                return matchCore(str, sindex, pindex+2, pattern);//如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。
            }
        }
        /*当模式中的第二个字符不是“*”时：
         * 1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
         * 2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。*/
        if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.'))
            return matchCore(str, sindex+1, pindex+1, pattern);
        return false;
    }
    /*
     *     
    public boolean match(char[] str, char[] pattern)
    {
        if(str==null||pattern==null){
            return false;
        }
        int s_i=0;
        int p_i=0;
        return matchcore(str,pattern,s_i,p_i);
    }
    public boolean matchcore(char[] str,char[] pattern,int s_i,int p_i){
        if(s_i==str.length&&p_i==pattern.length){
            return true;
        }
        if(s_i<str.length&&p_i==pattern.length){
            return false;
        }
        if(p_i+1<pattern.length&&pattern[p_i+1]=='*'){
            if(s_i<str.length && (str[s_i]==pattern[p_i]||pattern[p_i]=='.')){
                return matchcore(str,pattern,s_i,p_i+2)||
                    matchcore(str,pattern,s_i+1,p_i+2)||
                    matchcore(str,pattern,s_i+1,p_i);
            }else{
                return matchcore(str,pattern,s_i,p_i+2);
            }
        }
        if(s_i<str.length && (str[s_i]==pattern[p_i]||pattern[p_i]=='.')){
            return matchcore(str,pattern,s_i+1,p_i+1);
        }
        return false;
    }
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str={'a','b','b','b','c','f'};
		char[] pattern={'a','b','*','b','b','c','.','*'};
		System.out.println(match(str,pattern));
	}

}
