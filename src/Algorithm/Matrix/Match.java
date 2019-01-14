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
        if(pindex+1 < pattern.length && pattern[pindex+1] == '*'){//����ģʽ�еĵڶ����ַ��ǡ�*��ʱ
            if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.') ){//����ַ�����һ���ַ���ģʽ��һ���ַ�ƥ�䣬������3��ƥ�䷽ʽ��
                return matchCore(str, sindex, pindex+2, pattern) ||//ģʽ����2�ַ����൱��x*������
                    matchCore(str, sindex+1, pindex+2, pattern ) ||//�ַ�������1�ַ���ģʽ����2�ַ���
                    matchCore(str, sindex+1, pindex, pattern);//�ַ�������1�ַ���ģʽ���䣬������ƥ���ַ���һλ����Ϊ*����ƥ���λ��
            }else{
                return matchCore(str, sindex, pindex+2, pattern);//����ַ�����һ���ַ���ģʽ��һ���ַ���ƥ�䣬��ģʽ����2���ַ�������ƥ�䡣
            }
        }
        /*��ģʽ�еĵڶ����ַ����ǡ�*��ʱ��
         * 1������ַ�����һ���ַ���ģʽ�еĵ�һ���ַ���ƥ�䣬��ô�ַ�����ģʽ������һ���ַ���Ȼ��ƥ��ʣ��ġ�
         * 2����� �ַ�����һ���ַ���ģʽ�еĵ�һ���ַ��಻ƥ�䣬ֱ�ӷ���false��*/
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
