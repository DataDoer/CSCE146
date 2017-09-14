//able to continuously reuse this for homeworks, labs, etc

public class GenLinkedList <T>//T is the generic type, so it's every type
{
	//Internal class of the node
	private class ListNode
	{
		private T data;
		private ListNode link;
		//constructors
		public ListNode()
		{
			data = null;
			link = null;
		}
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	//pointer nodes
	private ListNode head;//first element
	private ListNode current; //movable pointer that points to stuff
	private ListNode previous;//one node behind the current
			
	//Constructors
	public GenLinkedList()
	{
		head = current = previous = null;
	}
	
	//Accessor for current node
	public T getCurrent()
	{
		if (current != null)
		{
			return current.data;
		}
		else
		{
			return null;
		}
	}
	//modify the current node
	public void setCurrent(T aData)
	{
		if (current != null)
		{
			current.data = aData; //can use this.current.data outside of the internal class
		}
	}
	
	//insert new element to the end of the list
	public void insert(T newData)
	{
		//create a new node
		ListNode newNode = new ListNode(newData, null);
		if(head == null) //list is empty
		{
			head = newNode; //points head to the new node
			current = head; //points current to the first element
			return; //then don't have to put the rest in an else statement
		}
		ListNode temp = head;
		while (temp.link != null)
		{
			temp = temp.link;
		}
		temp.link = newNode;
	}
	
	public void insertAfterCurrent(T newData)
	{
		ListNode newNode = new ListNode(newData, null);
		if(current != null)
		{
			newNode.link = current.link;
			current.link = newNode;
		}
		//unnecessary
		else if (head != null) //out of bounds
		{
			System.out.println("Current is outside of the linked list");
		}
		else //list is empty
		{
			head = current = newNode;
		}
	}
	
	public void goToNext()
	{
		if(current != null) //there is  a list
		{
				previous = current;
				current = current.link;
		}
	}
	public boolean hasMore()
	{
		return current != null;
	}
	public void resetCurrent()
	{
		current = head;
		previous = null;
	}
	public void print()
	{
		ListNode temp = head;
		while (temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
	public void delete()
	{
		if (current != null && previous != null) //in the middle or end
		{
			previous.link = current.link;
			current = current.link;
		}
		else if (current != null && previous == null) //in the beginning
		{
			head = head.link; //or head = current.link;
			current = head;
		}
	}
	
}
