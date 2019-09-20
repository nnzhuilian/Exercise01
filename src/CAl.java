import java.util.*;

public class CAl {
	public int opcal(char a, int o1, int o2) {
		switch (a) {
		case '+':
			return o2 + o1;
		case '-':
			return o2 - o1;
		case '*':
			return o2 * o1;
		case '/':
			return o2 / o1;
		default:
			return 0;
		}

	}

	public int cal(String s) {
		HashMap<Character, Integer> op = new HashMap<>();
		op.put('(', 2);
		op.put(')', 2);
		op.put('*', 1);
		op.put('/', 1);
		op.put('+', 0);
		op.put('-', 0);
		char[] str = s.toCharArray();
		Stack<Character> ops = new Stack<>();
		ArrayList<Character> arr = new ArrayList<>();
		for (int i = 0; i < str.length; i++) {
			if (!op.containsKey(str[i])) {
				arr.add(str[i]);
			} else {
				if (ops.isEmpty()) {
					ops.push(str[i]);
				} else {
					if (str[i] == ')') {
						while (ops.peek() != '(') {
							arr.add(ops.pop());
						}
						ops.pop();
					} else if (op.get(ops.peek()) >= op.get(str[i]) && ops.peek() != '(') {
						while (!ops.isEmpty()&& op.get(ops.peek()) >= op.get(str[i]) && ops.peek() != '(') {
							arr.add(ops.pop());
						}ops.push(str[i]);
					} else {
						ops.push(str[i]);
					}
				}
			}
		}
		while(!ops.isEmpty()){
			arr.add(ops.pop());
		}
		Stack<Integer> ca = new Stack<>();
		while (!arr.isEmpty()) {
			if (!op.containsKey(arr.get(0))) {
				ca.push(arr.get(0) - '0');
				arr.remove(0);
			} else {
				int tmp = opcal(arr.get(0), ca.pop(), ca.pop());
				ca.push(tmp);
				arr.remove(0);
			}
		}
		return ca.peek();
	}

	public static void main(String[] args) {
		CAl m = new CAl();
		System.out.println(m.cal("9+(3-1)*3+8/2"));
	}
}