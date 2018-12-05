package Algorithm.StackAndQueue;

import java.util.Stack;

public class minStack {
	Stack<Integer> s1=new Stack<Integer>();
    Stack<Integer> s2=new Stack<Integer>();
    static final int MAX=Integer.MAX_VALUE;
    public void push(int node) {
        s1.push(node);
        if(s2.isEmpty()){
            s2.push(node);
        }else if(s2.peek()>=node){
            s2.push(node);
        }
    }
    
    public void pop() {
        if(s1.isEmpty()){
            return;
        }
        int temp=s1.pop();
        if(temp==s2.peek()){
            s2.pop();
        }
    }
    
    public int top() {
        if(!s1.isEmpty()){
            return s1.peek();
        }
        return MAX;//int类型不能返回null！
    }
    
    public int min() {
        if(!s2.isEmpty()){
            return s2.peek();
        }
        return MAX;
    }


}
