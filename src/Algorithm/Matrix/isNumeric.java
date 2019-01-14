package Algorithm.Matrix;

public class isNumeric {
	public boolean isNumeric1(char[] str) {//����
        String s=String.copyValueOf(str);
        return s.matches("[\\+-]?\\d*(\\.\\d+)?([eE][\\+-]?\\d+)?");
    }
	/*����������־���ֱ��¼��+/-������e/E���͡�.���Ƿ���ֹ���
	 * ���ڡ�+/-���� �����������ǵ�һ�γ��ֵĻ�Ӧ�ó������ַ����ĵ�һ��λ�ã��������һ�γ����ڲ����ַ�����λ����������ǰ��Ҳ���ǡ�e/E�����ǾͲ����Ϲ�������ǵڶ��γ��֣���ô����Ӧ�ó����ڡ�e/E���ĺ��棬�����+/-����ǰ�治�ǡ�e/E������Ҳ�����Ϲ���
	 * ���ڡ�e/E���� ������ĺ��治���κ����֣��Ͳ����Ϲ���������ֶ����e/E��Ҳ�����Ϲ���
	 * ���ڡ�.���� ���ֶ����.���ǲ����Ϲ���ġ����С�e/E�����ַ������֡�.��Ҳ�ǲ����Ϲ���ġ�
	 * ͬʱ��Ҫ��֤�����ַ���Ϊ 0-9 ֮������֡�
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
