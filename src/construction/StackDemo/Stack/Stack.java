package construction.StackDemo.Stack;

public interface Stack {
	public int getsize();
	public Object top ()throws ExceptionStackEmpty;
	public void push(Object e);
	public Object pop()throws ExceptionStackEmpty;
	public boolean isEmpty();

}
