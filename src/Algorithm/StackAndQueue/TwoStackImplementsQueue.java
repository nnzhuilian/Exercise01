package Algorithm.StackAndQueue;

import java.util.Stack;

public class TwoStackImplementsQueue {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	/*
	 * public void push(int node) {//�ҵķ��� while(!stack2.isEmpty()){
	 * stack1.push(stack2.pop()); } stack1.push(node); }
	 * 
	 * public int pop() { if(stack1.isEmpty() && stack2.isEmpty()) throw new
	 * RuntimeException("Queue is empty!");//��Ҫ����������� while(!stack1.isEmpty()){
	 * stack2.push(stack1.pop()); } return stack2.pop(); }
	 */
	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			throw new RuntimeException("Queue is empty!");
		}
		if (stack2.isEmpty()) {//��ջ2Ϊ�գ��򵹳�ջ1����Ԫ��
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();//��Ϊ�գ�ջ2ֱ�ӵ���
	}

}
