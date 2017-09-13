
public class GenLinkedListTester {

	public static void main(String[] args) {
		//if it is a primitive type, you must use the wrapper class
		GenLinkedList<Integer> intLL = new GenLinkedList<Integer>();
		
		for(int i = 0; i<10; i++)
		{
			intLL.insert(i);
		}
		for (int i = 0; i <20; i++)
		{
			System.out.println(intLL.getCurrent());
			intLL.goToNext();
		}
	}
}
