package Algorithm.Matrix;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class printProbability {
	public static HashMap<Integer,Integer> print(int n){
		HashMap<Integer,Integer> prob=new HashMap<Integer,Integer>();
		pro(n,prob,0);
		return prob;
	}
	public static void pro(int n,HashMap<Integer,Integer> a,int sum){
		if(n==0){
			if(a.containsKey(sum)){
				a.put(sum, a.get(sum)+1);
			}else{
				a.put(sum, 1);
			}
			return;
		}
		pro(n-1,a,sum+1);
		pro(n-1,a,sum+2);
		pro(n-1,a,sum+3);
		pro(n-1,a,sum+4);
		pro(n-1,a,sum+5);
		pro(n-1,a,sum+6);
	}
	public static void main(String[] args) {
		HashMap<Integer,Integer> prob1=print(5);
		Iterator<Entry<Integer,Integer>> it=prob1.entrySet().iterator();
		while(it.hasNext()){
			Entry<Integer,Integer> en=it.next();
			System.out.println(en.getKey()+":"+en.getValue());
			//System.out.println(en.getKey()+":"+(double)(en.getValue()/Math.pow(6, 5)));
		}
	}
}
