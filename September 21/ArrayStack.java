
public class ArrayStack <T> implements StackInterface {

	private T[] stack;
	public static final int MAX_STACK = 100;
	private int head; //points to the first null element
	public ArrayStack()
	{
		init(MAX_STACK);
	}
	public ArrayStack(int size)
	{
		init(size);
		head = 0;
	}
	private void init(int size)
	{
		if (size <= 0)
		{
			return;
		}
		stack = (T[])(new Object[size]);
	}
	public void push(Object data)
	{
		if(head >= stack.length)//the stack is full
		{
			return;
		}
		stack[head] = (T)data;
		head++;
	}
	public T pop() //removes the last element
	{
		if (head == 0)
		{
			return null;
		}
		T retVal = stack[head - 1];
		head--;
		return retVal;
	}
	public void print()
	{
		for (int i = head-1;i>=0;i--)
		{
			System.out.println(stack[i].toString());
		}
	}
	public T peek()
	{
		if (head == 0)
		{
			return null;
		}
		T retVal = stack[head - 1];
		return retVal;
	}
}
