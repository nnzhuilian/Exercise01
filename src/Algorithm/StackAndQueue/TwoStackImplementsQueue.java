package Algorithm.StackAndQueue;

import java.util.Stack;

public class TwoStackImplementsQueue {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	/*
	 * public void push(int node) {//我的方案 while(!stack2.isEmpty()){
	 * stack1.push(stack2.pop()); } stack1.push(node); }
	 * 
	 * public int pop() { if(stack1.isEmpty() && stack2.isEmpty()) throw new
	 * RuntimeException("Queue is empty!");//不要忘了特数情况 while(!stack1.isEmpty()){
	 * stack2.push(stack1.pop()); } return stack2.pop(); }
	 */
	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			throw new RuntimeException("Queue is empty!");
		}
		if (stack2.isEmpty()) {//若栈2为空，则倒出栈1所有元素
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();//不为空，栈2直接弹出
	}

}
