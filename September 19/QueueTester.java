import java.util.*;

public class QueueTester {
	public static void main(String[] args)
	{
		//QueueInterface<Integer> queue = new ArrayQueue<Integer>();
		QueueInterface<Integer> queue = new LinkedListQueue<Integer>();

		for(int i = 0;i<10;i++)
		{
			queue.enqueue(i);
		}
		for (int i = 0;i<10;i++)
		{
			System.out.println(queue.dequeue());
		}
		
		//to use build-in queue, queue is an interface, must specify =new LinkedList<Integer>(); can't use =new Queue<Integer>();
		//Queue<Integer> queue2 = new LinkedList<Integer>();
	}

}
