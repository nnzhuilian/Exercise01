package Algorithm.StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class IsPopOrder {
	public boolean IsPopOrder1(int[] pushA, int[] popA) {// ����ջʵ�ֵ�
		if (pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
			return false;
		}
		Stack<Integer> s = new Stack<Integer>();
		int pushIndex = 0;
		int popIndex = 0;
		while (popIndex < popA.length) {
			if (!s.isEmpty()) {
				if (popA[popIndex] == s.peek()) {
					popIndex++;
					s.pop();
					continue;
				}
			}
			boolean flag = false;
			for (int k = pushIndex; k < pushA.length; k++) {
				if (pushA[k] == popA[popIndex]) {
					pushIndex = k + 1;
					flag = true;
					break;
				}
				s.push(pushA[k]);
			}
			if (flag == false) {
				return false;
			}
			popIndex++;
		}
		return true;
	}

	public boolean IsPopOrder2(int[] pushA, int[] popA) {// ����ջʵ�ֵģ���׼
		if (pushA.length != popA.length || pushA.length == 0 || popA.length == 0)
			return false;
		Stack<Integer> stack = new Stack<>();
		int index = 0;
		for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while (!stack.empty() && stack.peek() == popA[index]) {
				stack.pop();
				index++;
			}
		}
		return stack.empty();
	}
	/*
	 * ���ӣ�https://www.nowcoder.com/questionTerminal/
	 * d77d11405cc7470d82554cb392585106 ��Դ��ţ����
	 * 
	 * ����һ�£���һ���������ջ��ģ����̣���ʵ�����и��ݹ�˼·���⣬����pushA�е�Ԫ��ΪXi��popA��X0�ָ����������p1��p2��
	 * ��ΪX0�ǵ�һ����ջ��Ԫ�أ�����p1�е�Ԫ�رض���p2�е�Ԫ������ջ�������������б�Ȼ�����㵯�����С�
	 * ��p1����Ϊn1����p1��Ӧ����ջ����ΪX{1~n1}��p2��ӦX{n1+1~n-1}��n��ԭ�����еĳ��ȡ� import
	 * java.util.Arrays;
	 * 
	 * public class PopOrder {
	 */

	public boolean IsPopOrder(int[] pushA, int[] popA) {
		int length = popA.length;
		if (length == 0)
			return true;
		if (length == 1)
			return popA[0] == pushA[0];
		int i;
		for (i = 0; i < popA.length; i++) {
			if (popA[i] == pushA[0])
				break;
		}
		return IsPopOrder(Arrays.copyOfRange(pushA, 1, i + 1), Arrays.copyOfRange(popA, 0, i))
				&& IsPopOrder(Arrays.copyOfRange(pushA, i + 1, length), Arrays.copyOfRange(popA, i + 1, length));
	}

}
