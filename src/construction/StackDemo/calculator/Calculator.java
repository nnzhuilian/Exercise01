package construction.StackDemo.calculator;

import java.util.HashMap;
import java.util.LinkedList;

public class Calculator {
	public static LinkedList<Character> backp(String s) {
		LinkedList<Character> a1 = new LinkedList<Character>();
		LinkedList<Character> a2 = new LinkedList<Character>();
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		hm.put('+', 1);
		hm.put('-', 1);
		hm.put('*', 2);
		hm.put('/', 2);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
				a2.add(s.charAt(i));
			}
			if ((s.charAt(i) == '+') || (s.charAt(i) == '-') || (s.charAt(i) == '*') || (s.charAt(i) == '/')
					|| (s.charAt(i) == '(')) {
				char opt = s.charAt(i);
				if ((opt != '(')&&(a1.size()>0)&&(a1.getFirst()!='(')) {
					if (hm.get(opt) <= hm.get(a1.getFirst())) {
						i--;
						a2.add(a1.pop());
					} else {
						a1.push(opt);
					}
				} else {
					a1.push(opt);
				}
			}
			if (s.charAt(i) == ')') {
				char x = a1.pop();
				while (x != '(') {
					a2.add(x);
					x = a1.pop();
				}

			}

		}
		while(a1.size()>0){
			a2.add(a1.pop());
		}
		return a2;
	}
	public static LinkedList<Integer> cal(LinkedList<Character> a){
		LinkedList<Integer> in=new LinkedList<Integer>();
		for(int i=0;i<a.size();i++){
			if((a.get(i)>='0')&&(a.get(i)<='9')){
				in.add((int)a.get(i)-48);
			}
			if((a.get(i)=='+')||(a.get(i)=='-')||(a.get(i)=='*')||(a.get(i)=='/')){
				int s=in.size();
				int p=in.get(in.size()-1);
				int q=in.get(in.size()-2);
				in.removeLast();
				in.removeLast();
				if(a.get(i)=='+'){
					in.add(p+q);
				}
				if(a.get(i)=='-'){
					in.add(q-p);
				}
				if(a.get(i)=='*'){
					in.add(p*q);
				}
				if(a.get(i)=='/'){
					in.add(q/p);
				}
				
			}
		}
		return in;
	}

	public static void main(String[] args) {
		LinkedList<Character> a=backp("9+(3-1)*3+8/2");
		System.out.println(cal(a));

	}

}
