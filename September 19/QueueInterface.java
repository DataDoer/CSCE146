
public interface QueueInterface <T> {
//since queues can be implemented as arrays or linked lists
	public void enqueue(T data);//Add data
	public T dequeue();//remove data
	public T peek();//returns the object but doesn't remove the object
	public void print();
	
	
}
