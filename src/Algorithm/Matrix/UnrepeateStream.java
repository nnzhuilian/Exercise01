package Algorithm.Matrix;

import java.util.HashMap;
import java.util.LinkedList;

public class UnrepeateStream {
	//方法一：HashMap的方法，常规操作，时间O(n^2)?(如果每添一个字符算一次的话，否则是O(n)),空间O(n)
    HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
    StringBuffer sb=new StringBuffer();
    int flag=0;
    //Insert one char from stringstream
    public void Insert1(char ch)
    {
        sb.append(ch);
        if(hm.containsKey(ch)){
            hm.put(ch,hm.get(ch)+1);
        }else{
            hm.put(ch,1);
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce1()
    {
        for(int i=flag;i<sb.length();i++){
            if(hm.get(sb.charAt(i))==1){
                flag=i;
                return sb.charAt(i);
            }
        }
        return '#';
    }
///////////////////方法二：时间复杂度O(n),空间复杂度O(1)///////////////////////
    LinkedList<Character> l=new LinkedList<Character>();
    int[] c=new int[256];
    //Insert one char from stringstream
    public void Insert2(char ch)
    {
        c[(int)ch]++;
        if(c[(int)ch]==1){
            l.offer(ch);
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce2()
    {
        while(!l.isEmpty()){
        if(c[l.peek()]==1){
            return l.peek();
        }else if(c[l.peek()]>1){
            l.poll();
        }}
        return '#';
    }
}
