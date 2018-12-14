package Algorithm.Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class Permutation {
	public ArrayList<String> Permutation1(String str) {
        ArrayList<String> strs=new ArrayList<String>();
        if(str.length()==0){
            return strs;
        }
         
       ArrayList<Character> strr=new ArrayList<Character>();
        for(int i=0;i<str.length();i++){
            strr.add(str.charAt(i));
        }
        TreeSet<String> tr=new TreeSet<String>();
        StringBuffer sb=new StringBuffer();
        sort(tr,strr,sb);
        Iterator<String> it=tr.iterator();
        while(it.hasNext()){
            strs.add(it.next());
        }
        return strs;
    }
    public void sort(TreeSet<String> strs,ArrayList<Character> strr,StringBuffer sb){
        if(strr.size()==0){
            strs.add(sb.toString());
            return;
        }
        for(int i=0;i<strr.size();i++){
            ArrayList<Character> temp=new ArrayList<Character>(strr);
            StringBuffer s=new StringBuffer(sb.toString());
            s.append(strr.get(i));
            temp.remove(i);
            sort(strs,temp,s);
        }
    }
 ///////////////////////////-优化方法-////////////////////////////   
    ArrayList<String> res = new ArrayList<String>();
    public ArrayList<String> Permutation(String str) {
        if(str == null)
            return res;
        PermutationHelper(str.toCharArray(), 0);
        Collections.sort(res);
        return res;
    }
    public void PermutationHelper(char[] str, int i){
        if(i == str.length - 1){
            res.add(String.valueOf(str));
        }else{
            for(int j = i; j < str.length; j++){
                if(j!=i && str[i] == str[j])
                    continue;
                swap(str, i, j);
                PermutationHelper(str, i+1);
                swap(str, i, j);
            }
        }
    }
    public void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

}
