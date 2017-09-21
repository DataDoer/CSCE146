
public class LinkedListQueue <T> implements QueueInterface{
	private class ListNode
	{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	ListNode head;
	ListNode tail; //points to actual last element in LL implementation
	public LinkedListQueue()
	{
		head = tail = null;
	}
	public void enqueue(Object aData)
	{
		ListNode newNode = new ListNode((T)aData, null);
		if(head == null)
		{
			head = newNode;
			tail = newNode;
			return;
		}
		tail.link = newNode;
		tail = tail.link;
	}
	public Object dequeue()
	{
		ListNode temp = head;
		head = head.link;
		return temp.data;
	}
	public Object peek()
	{
		if (head != null)
			return head.data;
		else
			return null;
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
}
