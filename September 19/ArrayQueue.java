
public class ArrayQueue <T> implements QueueInterface{
	private T[] queue;
	private int tailIndex; //will assume that head is always at index 0. Tail is movable; is one past the last element
	//challenging way - also have movable headIndex - can create a circular queue (mod length) and reset tail when head goes past the tail
	public static final int DEFAULT_SIZE = 100; //always do when doing array based classes
	
	public ArrayQueue()
	{
		init(DEFAULT_SIZE);
	}
	
	public ArrayQueue(int size)
	{
		init(size);
	}
	private void init (int size) //initializes the array (could also be public and used as a reset method)
	{
		if(size > 0)
		{
			queue = (T[])(new Object[size]); //T is generic, doesn't exist yet but is of type object so create object & typecast
			tailIndex = 0; //first null index
		}
	}
	
	public void enqueue(Object data) {
		//must make sure array isn't full
		if(this.queue.length <= tailIndex)
		{
			return;
		}
		this.queue[tailIndex] = (T)data;
		tailIndex++;
	}

	public T dequeue() {
		T returnItem = this.queue[0];
		for (int i = 0; i<tailIndex; i++)
		{
			this.queue[i]=this.queue[i+1];
		}
		tailIndex--;
		return returnItem;
	}

	public T peek() {
		return this.queue[0];
	}

	public void print() {
		for(int i=0;i<tailIndex;i++)
		{
			System.out.println(queue[i].toString());
		}
	}

}
