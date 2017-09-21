
public class StackTester {
	public static void main(String[] args)
	{
		StackInterface<Integer> stack = new ArrayStack<Integer>();
		for(int i = 0;i<10;i++)
		{
			stack.push(i);
		}
		for(int i = 0;i<10;i++)
		{
			System.out.println(stack.pop());
		}
		
		String b = "o";
		try
		{
			int c = Integer.parseInt(b);
			System.out.println(c);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
