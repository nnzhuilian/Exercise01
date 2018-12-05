package Algorithm.StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class IsPopOrder {
	public boolean IsPopOrder1(int[] pushA, int[] popA) {// 基于栈实现的
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

	public boolean IsPopOrder2(int[] pushA, int[] popA) {// 基于栈实现的，标准
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
	 * 链接：https://www.nowcoder.com/questionTerminal/
	 * d77d11405cc7470d82554cb392585106 来源：牛客网
	 * 
	 * 看了一下，大家基本都是用栈来模拟过程，其实这题有个递归思路来解，假设pushA中的元素为Xi，popA被X0分割成两个序列p1和p2，
	 * 因为X0是第一个入栈的元素，所以p1中的元素必定比p2中的元素先入栈，则这两个序列必然都满足弹出序列。
	 * 设p1长度为n1，则p1对应的入栈序列为X{1~n1}，p2对应X{n1+1~n-1}，n是原来序列的长度。 import
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
