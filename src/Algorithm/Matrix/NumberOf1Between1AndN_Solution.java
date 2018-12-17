package Algorithm.Matrix;

public class NumberOf1Between1AndN_Solution {
	  public int NumberOf1Between1AndN_Solution1(int n) {
	        int res = 0;
	        for(int i = 1; i <= n; i++)
	            res += number1(i);
	        return res;
	    }

	    public int number1(int n){
	        int res = 0;
	        while(n>0){
	            if(n % 10 == 1)
	                res++;
	            n /= 10;
	        }
	        return res;
	    }
	    public int NumberOf1Between1AndN_Solution2(int n) {
	        int res = 0;
	        StringBuffer s = new StringBuffer();
	        for(int i = 1; i<=n; i++){
	            s.append(i);
	        }
	        String str = s.toString();
	        for(int i=0; i<str.length(); i++){
	            if(str.charAt(i) == '1')
	                res++;
	        }
	        return res;
	    }
	    public static int NumberOf1Between1AndN_Solution3(int n) {
	        int res = 0;
	        int cur = 0, before = 0, after = 0;
	        int i = 1;
	        while(i<=n){
	            before = n/(i*10);
	            cur = (n/i)%10;
	            after = n - n/i*i;
	            if(cur == 0){
	                // 如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
	                res += before * i;
	            }else if(cur == 1){
	                // 如果为1, 出现1的次数由高位和低位决定,高位*当前位+低位+1
	                res += before * i + after + 1;
	            }else{
	                // 如果大于1, 出现1的次数由高位决定,（高位数字+1）* 当前位数
	                res += (before + 1) * i;
	            }
	            i *= 10;
	        }
	        return res;
	    }
	    ///////////////////////计算x∈[0,9]的个数
/*	    这里的  X∈[1,9] ，因为  X=0  不符合下列规律，需要单独计算。

	    		首先要知道以下的规律：

	    		从 1 至 10，在它们的个位数中，任意的 X 都出现了 1 次。
	    		从 1 至 100，在它们的十位数中，任意的 X 都出现了 10 次。
	    		从 1 至 1000，在它们的百位数中，任意的 X 都出现了 100 次。
	    		依此类推，从 1 至  10 i ，在它们的左数第二位（右数第  i  位）中，任意的 X 都出现了  10 i−1  次。

	    		这个规律很容易验证，这里不再多做说明。

	    		接下来以  n=2593,X=5  为例来解释如何得到数学公式。从 1 至 2593 中，数字 5 总计出现了 813 次，其中有 259 次出现在个位，260 次出现在十位，294 次出现在百位，0 次出现在千位。

	    		现在依次分析这些数据，首先是个位。从 1 至 2590 中，包含了 259 个 10，因此任意的 X 都出现了 259 次。最后剩余的三个数 2591, 2592 和 2593，因为它们最大的个位数字 3 < X，因此不会包含任何 5。（也可以这么看，3<X，则个位上可能出现的X的次数仅由更高位决定，等于更高位数字（259）X101-1=259）。

	    		然后是十位。从 1 至 2500 中，包含了 25 个 100，因此任意的 X 都出现了  25×10=250  次。剩下的数字是从 2501 至 2593，它们最大的十位数字 9 > X，因此会包含全部 10 个 5。最后总计 250 + 10 = 260。（也可以这么看，9>X，则十位上可能出现的X的次数仅由更高位决定，等于更高位数字（25+1）X102-1=260）。

	    		接下来是百位。从 1 至 2000 中，包含了 2 个 1000，因此任意的 X 都出现了  2×100=200  次。剩下的数字是从 2001 至 2593，它们最大的百位数字 5 == X，这时情况就略微复杂，它们的百位肯定是包含 5 的，但不会包含全部 100 个。如果把百位是 5 的数字列出来，是从 2500 至 2593，数字的个数与百位和十位数字相关，是 93+1 = 94。最后总计 200 + 94 = 294。（也可以这么看，5==X，则百位上可能出现X的次数不仅受更高位影响，还受低位影响，等于更高位数字（2）X103-1+（93+1）=294）。

	    		最后是千位。现在已经没有更高位，因此直接看最大的千位数字 2 < X，所以不会包含任何 5。（也可以这么看，2<X，则千位上可能出现的X的次数仅由更高位决定，等于更高位数字（0）X104-1=0）。

	    		到此为止，已经计算出全部数字 5 的出现次数。

	    		总结一下以上的算法，可以看到，当计算右数第  i  位包含的 X 的个数时：

	    		取第  i  位左边（高位）的数字，乘以  10 i−1 ，得到基础值  a 。
	    		取第  i  位数字，计算修正值：
	    		如果大于 X，则结果为  a+ 10 i−1 。
	    		如果小于 X，则结果为  a 。
	    		如果等 X，则取第  i  位右边（低位）数字，设为  b ，最后结果为  a+b+1 。
	    		相应的代码非常简单，效率也非常高，时间复杂度只有  O( log 10 n) 。*/
	    public int NumberOfXBetween1AndN_Solution(int n,int x) {   //x具有普适性
	    	if(n<0||x<1||x>9)
	    		return 0;
	    	int high,low,curr,tmp, i = 1;  //表示第几位 ---> 10的多少次方
	    	high = n;
	    	int total = 0;
	    	while(high!=0){
	    		high = n/(int)Math.pow(10, i);// 获取第i位的高位
	    		tmp = n%(int)Math.pow(10, i);     // 当前位//低位
	    		curr = tmp/(int)Math.pow(10, i-1);// 获取第i位
	    		low = tmp%(int)Math.pow(10, i-1);// 获取第i位的低位
	    		if(curr==x){
	    			total+= high*(int)Math.pow(10, i-1)+low+1;
	    		}else if(curr<x){
	    			total+=high*(int)Math.pow(10, i-1);
	    		}else{
	    			total+=(high+1)*(int)Math.pow(10, i-1);
	    		}
	    		i++;
	    	}
			return total;        
	    }
	    public static void main(String[] args) {
			System.out.println(NumberOf1Between1AndN_Solution3(10000));
		}
	    
	    

}
