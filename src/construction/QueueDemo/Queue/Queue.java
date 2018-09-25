package construction.QueueDemo.Queue;

public interface Queue {
public void enqueue(Object e);
public Object dequeue ()throws ExceptionQueueEmpty;
public int getsize();
public Object front()throws ExceptionQueueEmpty;
public boolean isEmpty();
}
